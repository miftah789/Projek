package com.miftah.asyst.pizzaordermiftah;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.miftah.asyst.pizzaordermiftah.utility.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    TextView tvTittle;
    EditText etName;
    ImageButton ibClose;
    CheckBox cbSatu, cbDua, cbTiga;
    RadioGroup rgPizzaSatu, rgPizzaDua, rgPizzaTiga;
    RadioButton rbS1, rbM1, rbL1, rbS2, rbM2, rbL2, rbS3, rbM3, rbL3;
    Switch upSizeSwitch;
    Button btnSubmit, btnKirim;

    String stringSizeSatu, stringSizeDua, stringSizeTiga;
    String switchUpsize;
    String stringName;
    String pizzaSatu = "";
    String pizzaDua = "";
    String pizzaTiga = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTittle = findViewById(R.id.tv_tittle);
        etName = findViewById(R.id.edit_text_name);
        ibClose = findViewById(R.id.img_close);
        cbSatu = findViewById(R.id.cb_satu);
        cbSatu.setOnCheckedChangeListener(this);
        rgPizzaSatu = findViewById(R.id.rg_satu);
        rgPizzaSatu.setOnCheckedChangeListener(this);
        rbS1 = findViewById(R.id.rb_s);
        rbM1 = findViewById(R.id.rb_m);
        rbL1 = findViewById(R.id.rb_l);
        cbDua = findViewById(R.id.cb_dua);
        cbDua.setOnCheckedChangeListener(this);
        rgPizzaDua = findViewById(R.id.rg_dua);
        rgPizzaDua.setOnCheckedChangeListener(this);
        rbS2 = findViewById(R.id.rb_ss);
        rbM2 = findViewById(R.id.rb_mm);
        rbL2 = findViewById(R.id.rb_ll);
        cbTiga = findViewById(R.id.cb_tiga);
        cbTiga.setOnCheckedChangeListener(this);
        rgPizzaTiga = findViewById(R.id.rg_tiga);
        rgPizzaTiga.setOnCheckedChangeListener(this);
        rbS3 = findViewById(R.id.rb_sss);
        rbM3 = findViewById(R.id.rb_mmm);
        rbL3 = findViewById(R.id.rb_lll);
        upSizeSwitch = findViewById(R.id.switch_upsize);
        upSizeSwitch.setOnCheckedChangeListener(this);
        btnSubmit = findViewById(R.id.button_submit);
        btnSubmit.setOnClickListener(this);
        btnKirim = findViewById(R.id.button_kirik);
        btnKirim.setOnClickListener(this);
        cbSatu.setEnabled(false);
        cbDua.setEnabled(false);
        cbTiga.setEnabled(false);
        rbS1.setEnabled(false);
        rbM1.setEnabled(false);
        rbL1.setEnabled(false);
        rbS2.setEnabled(false);
        rbM2.setEnabled(false);
        rbL2.setEnabled(false);
        rbS3.setEnabled(false);
        rbM3.setEnabled(false);
        rbL3.setEnabled(false);
        btnKirim.setEnabled(false);

//        ((RadioButton) findViewById(R.id.rb_s)).setChecked(true);
//        ((RadioButton) findViewById(R.id.rb_ss)).setChecked(true);
//        ((RadioButton) findViewById(R.id.rb_sss)).setChecked(true);

        String pizzaSatu, pizzaDua, pizzaTiga;


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.button_submit:
                stringName = etName.getText().toString();
                if (!TextUtils.isEmpty(stringName)) {
                    cbSatu.setEnabled(true);
                    cbDua.setEnabled(true);
                    cbTiga.setEnabled(true);
                    btnKirim.setEnabled(true);
                } else {
                    etName.setError("Anda Belum Mengisi Nama");
                    cbSatu.setEnabled(false);
                    cbDua.setEnabled(false);
                    cbTiga.setEnabled(false);
                    btnKirim.setEnabled(false);
                }
                break;
            case R.id.button_kirik:
                stringName = etName.getText().toString();
                if (!TextUtils.isEmpty(stringName)) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Confirmation").setCancelable(false).setMessage("are you sure?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                    String result = "Nama = " + stringName + "\nOrder = " + pizzaSatu + "(" + stringSizeSatu + ")" + " " + pizzaDua + "(" + stringSizeDua + ")" + " " + pizzaTiga + "(" + stringSizeTiga + ")\nUpsize = " + switchUpsize;
                                    intent.putExtra(Constant.KEY_RESULT, result);
                                    startActivity(intent);
                                }
                            }).setNegativeButton("No", null).show();
//                    textViewSatu.setText("Nama = "+stringSatu + "\nJenis Kelamin = " + stringDua +
//                            "\nMakanan Fav = " +foods+"\nKota = "+citySelect);
                    break;
                }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();

        switch (id) {
            case R.id.cb_satu:
                pizzaSatu = cbSatu.getText().toString();
                if (!TextUtils.isEmpty(pizzaSatu)) {
                    rbS1.setEnabled(true);
                    rbM1.setEnabled(true);
                    rbL1.setEnabled(true);
                    if (isChecked) {
                        pizzaSatu = "Pizza Satu";
                    } else {
                        pizzaSatu = ("");
                    }
                } else {
                    rbS1.setEnabled(false);
                    rbM1.setEnabled(false);
                    rbL1.setEnabled(false);
                }
                break;
            case R.id.cb_dua:
                pizzaDua = cbDua.getText().toString();
                if (!TextUtils.isEmpty(pizzaDua)) {
                    rbS2.setEnabled(true);
                    rbM2.setEnabled(true);
                    rbL2.setEnabled(true);
                    if (isChecked) {
                        pizzaDua = "Pizza Dua";
                    } else {
                        pizzaDua = ("");
                    }
                } else {
                    rbS2.setEnabled(false);
                    rbM2.setEnabled(false);
                    rbL2.setEnabled(false);
                }
                break;
            case R.id.cb_tiga:
                pizzaTiga = cbTiga.getText().toString();
                if (!TextUtils.isEmpty(pizzaTiga)) {
                    rbS3.setEnabled(true);
                    rbM3.setEnabled(true);
                    rbL3.setEnabled(true);
                    if (isChecked) {
                        pizzaTiga = "Pizza Tiga";
                    } else {
                        pizzaTiga = ("");
                    }
                } else {
                    rbS3.setEnabled(false);
                    rbM3.setEnabled(false);
                    rbL3.setEnabled(false);
                }
                break;
            case R.id.switch_upsize:
                switchUpsize = " " + isChecked;
                Log.d("Upsize ", "" + isChecked);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_s:
                stringSizeSatu = "S";
                break;
            case R.id.rb_m:
                stringSizeSatu = "M";
                break;
            case R.id.rb_l:
                stringSizeSatu = "L";
                break;
            case R.id.rb_ss:
                stringSizeDua = "S";
                break;
            case R.id.rb_mm:
                stringSizeDua = "M";
                break;
            case R.id.rb_ll:
                stringSizeDua = "L";
                break;
            case R.id.rb_sss:
                stringSizeTiga = "S";
                break;
            case R.id.rb_mmm:
                stringSizeTiga = "M";
                break;
            case R.id.rb_lll:
                stringSizeTiga = "L";
                break;
        }
    }
}
