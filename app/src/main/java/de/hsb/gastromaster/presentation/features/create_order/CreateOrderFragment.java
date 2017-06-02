package de.hsb.gastromaster.presentation.features.create_order;


import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.OrderDataRepository;
import de.hsb.gastromaster.data.order.local.OrderDataStore;
import de.hsb.gastromaster.databinding.FragmentCreateOrderBinding;
import de.hsb.gastromaster.domain.feature.create_order.CreateOrderUseCase;

public class CreateOrderFragment extends Fragment
        implements CreateOrderContract.View {

    private FragmentCreateOrderBinding binding;
    private CreateOrderContract.Presenter presenter;

    private ObservableField<String> txtTableNumber = new ObservableField<>();
    private ObservableField<String> txtWaitressNumber = new ObservableField<>();
    private ObservableField<String> txtDish = new ObservableField<>();
    private ObservableBoolean isEnabled = new ObservableBoolean();

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

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_create_order,
                container,
                false);

        binding.setView(this);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view,
                              @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        init();
    }

    private void init() {

        initLayout();
        initPresenter();
    }

    private void initLayout() {

    }

    private void initPresenter() {

        presenter = new CreateOrderPresenter(
                this,
                new CreateOrderUseCase(
                        new OrderDataRepository(
                                new OrderDataStore())));
        presenter.init();
    }

    public void onCreateButtonClick(View __) {

        presenter.createOrder(
                Order.builder()
                        .setId(1)
                        .setTableNumber("")
                        .setWaitressId(1)
                        .setDate("")
                        .setDishList(new ArrayList<>())
                        .build());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public ObservableField<String> getTxtTableNumber() {
        return txtTableNumber;
    }

    public void setTxtTableNumber(ObservableField<String> txtTableNumber) {
        this.txtTableNumber = txtTableNumber;
    }

    public ObservableField<String> getTxtWaitressNumber() {
        return txtWaitressNumber;
    }

    public void setTxtWaitressNumber(ObservableField<String> txtWaitressNumber) {
        this.txtWaitressNumber = txtWaitressNumber;
    }

    public ObservableField<String> getTxtDish() {
        return txtDish;
    }

    public void setTxtDish(ObservableField<String> txtDish) {
        this.txtDish = txtDish;
    }

    public ObservableBoolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(ObservableBoolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}
