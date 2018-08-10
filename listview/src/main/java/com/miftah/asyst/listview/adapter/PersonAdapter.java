package com.miftah.asyst.listview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.miftah.asyst.listview.R;
import com.miftah.asyst.listview.model.Person;

import java.util.ArrayList;


public class PersonAdapter extends ArrayAdapter<Person> {

    ArrayList<Person> listPerson;

    public PersonAdapter(Context context, ArrayList<Person> listPerson) {
        super(context, R.layout.item_person, listPerson);
        this.listPerson = listPerson;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, null);

        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvAddress = view.findViewById(R.id.tv_address);

        tvName.setText(listPerson.get(position).getName());
        tvAddress.setText(listPerson.get(position).getAddress());
        return view;
    }
}
