package de.hsb.gastromaster.presentation.features.create_order;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.databinding.FragmentCreateOrderBinding;

public class CreateOrderFragment extends Fragment
        implements CreateOrderContract.CreateOrderView {


    public static CreateOrderFragment newInstance() {

        Bundle args = new Bundle();
        CreateOrderFragment fragment = new CreateOrderFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentCreateOrderBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_create_order, container, false);

        return binding.getRoot();
    }
}
