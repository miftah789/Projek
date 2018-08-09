package com.miftah.asyst.pizzaordermiftah.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.miftah.asyst.pizzaordermiftah.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {

    TextView tvName;
    CheckBox cbPizzaSatu, cbPizzaDua, cbPizzaTiga;
    OnSubmitButtonListener listener;

    public PizzaFragment() {
        // Required empty public constructor
    }

    public static PizzaFragment newInstance(String name, String order) {
        // Required empty public constructor
        //set argumen activity to fragment
        PizzaFragment pizzaFragment = new PizzaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nama", name);
        bundle.putString("order", order);

        pizzaFragment.setArguments(bundle);
        return pizzaFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pizza, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnSubmitButtonListener) {
            listener = (OnSubmitButtonListener) context;
        } else {
            throw new RuntimeException(context.toString() + " activity harus implamen interface");
        }
    }

    public interface OnSubmitButtonListener {
        void onSubmitButton(String name, String order);
    }

}
