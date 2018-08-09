package com.miftah.asyst.learnfragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.miftah.asyst.learnfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements View.OnClickListener {

    Button btnFirst, btnSecond, btnThird;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_base, container, false);

        btnFirst = view.findViewById(R.id.btn_first_fragment);
        btnSecond = view.findViewById(R.id.btn_second_fragment);
        btnThird = view.findViewById(R.id.btn_third_fragment);

        btnFirst.setOnClickListener(this);
        btnSecond.setOnClickListener(this);
        btnThird.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;

        switch (v.getId()) {
            case R.id.btn_first_fragment:
                fragment = new FirstFragment();
                break;
            case R.id.btn_second_fragment:
                fragment = new SecondFragment();
                break;
            case R.id.btn_third_fragment:
                fragment = new ThirdFragment();
                break;
        }

        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
