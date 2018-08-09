package com.miftah.asyst.listview.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.miftah.asyst.listview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    EditText etNama;
    Button btnSimpan;
    int position;
    EditFragment.OnSubmitButtonListener listener;

    public EditFragment() {
        // Required empty public constructor
    }

    public static EditFragment newInstance(String nama, int position) {
        // Required empty public constructor
        //set argumen activity to fragment
        EditFragment editFragment = new EditFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nama", nama);
        bundle.putInt("position", position);
        editFragment.setArguments(bundle);
        return editFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        etNama = view.findViewById(R.id.et_nama);
        btnSimpan = view.findViewById(R.id.btn_simpan);
        etNama.setText(getArguments().getString("nama"));
        position = getArguments().getInt("position");
        btnSimpan.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simpan:
                listener.onSubmitButton(etNama.getText().toString(), position);
                dismiss();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof EditFragment.OnSubmitButtonListener) {
            listener = (EditFragment.OnSubmitButtonListener) context;
        } else {
            throw new RuntimeException(context.toString() + " activity harus implamen interface");
        }
    }

    public interface OnSubmitButtonListener {
        void onSubmitButton(String nama, int position);
    }
}
