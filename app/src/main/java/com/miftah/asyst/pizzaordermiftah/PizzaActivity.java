package com.miftah.asyst.pizzaordermiftah;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.miftah.asyst.pizzaordermiftah.fragment.PizzaFragment;

public class PizzaActivity extends AppCompatActivity implements View.OnClickListener, PizzaFragment.OnSubmitButtonListener {

    TextView tvName, tvOrder;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        tvName = findViewById(R.id.tv_name);
        tvOrder = findViewById(R.id.tv_order);
        btnOrder = findViewById(R.id.btn_order);
        btnOrder.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_order:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                PizzaFragment pizzaFragment = PizzaFragment.newInstance(tvName.getText().toString(), tvOrder.getText().toString());
                transaction.add(android.R.id.content, pizzaFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }
    }

    @Override
    public void onSubmitButton(String name, String order) {
        tvName.setText(name);
        tvOrder.setText(order);
    }
}
