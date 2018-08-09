package com.miftah.asyst.learnfragment.fragment;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.miftah.asyst.learnfragment.R;
import com.miftah.asyst.learnfragment.utility.DateUtils;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputBottonSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    EditText etName, etAddress;
    Button btnSubmit;
    TextView tvDate;
    ImageView ivDate;
    InputBottonSheetFragment.OnSubmitButtonListener listener;
    DatePickerDialog datePickerDialog;

    public InputBottonSheetFragment() {
        // Required empty public constructor
    }

    public static InputBottonSheetFragment newInstance(String name, String address, String date) {
        // Required empty public constructor
        //set argumen activity to fragment
        InputBottonSheetFragment inputBottonSheetFragment = new InputBottonSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nama", name);
        bundle.putString("address", address);
        bundle.putString("date", date);

        inputBottonSheetFragment.setArguments(bundle);
        return inputBottonSheetFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_botton_sheet, container, false);

        etName = view.findViewById(R.id.et_name);
        etAddress = view.findViewById(R.id.et_address);
        btnSubmit = view.findViewById(R.id.btn_submit);
        tvDate = view.findViewById(R.id.tv_date);
        ivDate = view.findViewById(R.id.img_view_date);

        if (getArguments() != null) {
            etName.setText(getArguments().getString("nama", ""));
            etAddress.setText(getArguments().getString("address", ""));
            tvDate.setText(getArguments().getString("date", ""));
        }

        Calendar calendar = Calendar.getInstance();
        int year = 1999, month = 0, day = 1;
        String selectDate = tvDate.getText().toString();
        if (!selectDate.equalsIgnoreCase("")) {

            calendar.setTime(DateUtils.dateToString("dd MMMM yyyy", selectDate));
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);

        }

        datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);

        btnSubmit.setOnClickListener(this);
        ivDate.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                listener.onSubmitButton(etName.getText().toString(), etAddress.getText().toString(), tvDate.getText().toString());
                dismiss();
//                  getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.img_view_date:
                datePickerDialog.show();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + " " + (month + 1) + " " + year;
        tvDate.setText(DateUtils.formatDate("dd MM yyyy", "dd MMMM yyyy", date));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof InputBottonSheetFragment.OnSubmitButtonListener) {
            listener = (InputBottonSheetFragment.OnSubmitButtonListener) context;
        } else {
            throw new RuntimeException(context.toString() + " activity harus implamen interface");
        }
    }

    public interface OnSubmitButtonListener {
        void onSubmitButton(String name, String addres, String date);
    }
}
