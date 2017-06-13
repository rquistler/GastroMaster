package de.hsb.gastromaster.presentation.features.create_order;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.OrderDataRepository;
import de.hsb.gastromaster.data.order.local.OrderDataStore;
import de.hsb.gastromaster.domain.feature.create_order.CreateOrderUseCase;

public class CreateOrderFragment extends Fragment
        implements CreateOrderContract.View {

    private CreateOrderContract.Presenter presenter;

    @BindView(R.id.btnCreate) Button btnCreateOrder;

    @BindView(R.id.txtTableNumber) EditText edtxtTableNumber;

    @BindView(R.id.txtWaitressNumber) EditText edtxtWaitessId;

    @BindView(R.id.txtDish) EditText edtxtDish;


    public static CreateOrderFragment newInstance() {

        Bundle args = new Bundle();
        CreateOrderFragment fragment = new CreateOrderFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater
                .inflate(R.layout.fragment_create_order,
                        container,
                        false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view,
                              @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        init();
    }

    private void init() {

        initLayout();

        initPresenter(new CreateOrderPresenter(
                this,
                new CreateOrderUseCase(
                        new OrderDataRepository(
                                new OrderDataStore()))));
    }

    private void initLayout() {

    }

    public void initPresenter(CreateOrderContract.Presenter presenter) {

        this.presenter = presenter;

        presenter.init();
    }

    @OnClick(R.id.btnCreate)
    public void onCreateButtonClick(View __) {

        String tableNumber = edtxtTableNumber.getText().toString();
        int waitressId = Integer.valueOf(edtxtWaitessId.getText().toString());
        String dishName = edtxtDish.getText().toString();

        presenter.createOrder(
                Order.builder()
                        .setId(1)
                        .setTableNumber(tableNumber)
                        .setWaitressId(waitressId)
                        .setDate("1.1.1111")
                        .setDishList(new ArrayList<>())
                        .build());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
