package com.miftah.asyst.learnfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.miftah.asyst.learnfragment.fragment.FourthFragment;
import com.miftah.asyst.learnfragment.fragment.InputBottonSheetFragment;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, FourthFragment.OnSubmitButtonListener, InputBottonSheetFragment.OnSubmitButtonListener {

    TextView tvName, tvAddress, tvDate;
    Button btnInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = findViewById(R.id.tv_name);
        tvAddress = findViewById(R.id.tv_address);
        btnInput = findViewById(R.id.btn_input);
        tvDate = findViewById(R.id.tv_date);

        btnInput.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_input:
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                FourthFragment fourthFragment = new FourthFragment();
                FourthFragment fourthFragment = FourthFragment.newInstance(tvName.getText().toString(), tvAddress.getText().toString(), tvDate.getText().toString());
                fragmentTransaction.add(android.R.id.content, fourthFragment);
                fragmentTransaction.addToBackStack(null);

//                //set argumen activity to fragment
//                Bundle bundle = new Bundle();
//                bundle.putString("nama", tvName.getText().toString());
//                bundle.putString("address", tvAddress.getText().toString());
//
//                fourthFragment.setArguments(bundle);

                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void onSubmitButton(String name, String address, String date) {
        tvName.setText(name);
        tvAddress.setText(address);
        tvDate.setText(date);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.input_main_menu:
                InputBottonSheetFragment inputBottonSheetFragment = InputBottonSheetFragment.newInstance(tvName.getText().toString(), tvAddress.getText().toString(), tvDate.getText().toString());
                inputBottonSheetFragment.show(getSupportFragmentManager(), "inputBottomSheet");

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
