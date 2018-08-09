package com.miftah.asyst.pizzaordermiftah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.miftah.asyst.pizzaordermiftah.utility.Constant;

public class ResultActivity extends AppCompatActivity {

    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvHasil = findViewById(R.id.tv_hasil);
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            tvHasil.setText(bundle.getString(Constant.KEY_RESULT));
        }

    }
}
