package com.miftah.asyst.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.miftah.asyst.listview.adapter.PersonAdapter;
import com.miftah.asyst.listview.fragment.EditFragment;
import com.miftah.asyst.listview.model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, EditFragment.OnSubmitButtonListener, View.OnClickListener, AdapterView.OnItemLongClickListener {

    ListView listView;
    Button btnAdd;
    EditText etNama;

    ArrayList<String> listNama = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    ArrayList<Person> listPerson = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        etNama = findViewById(R.id.et_name);
        btnAdd = findViewById(R.id.btn_add);

        listNama.add("Miftah");
        listNama.add("Adel");
        listNama.add("Nisa");
        listNama.add("Evi");
        listNama.add("Yeni");
        listNama.add("Feby");
        listNama.add("Loisa");

        for (int i = 0; i < 10; i++) {
            Person person = new Person("Nama ke-" + i, "Alamat ke-" + i);
            listPerson.add(person);
        }

        PersonAdapter personAdapter = new PersonAdapter(this, listPerson);

//        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listNama);

        listView.setAdapter(personAdapter);
        listView.setOnItemLongClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(MainActivity.this, listNama.get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                if (!etNama.getText().toString().equalsIgnoreCase("")) {
                    listNama.add(etNama.getText().toString());
                    etNama.setText("");
                    arrayAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        EditFragment editFragment = EditFragment.newInstance(listNama.get(position), position);
        editFragment.show(getSupportFragmentManager(), "");
        return false;
    }

    @Override
    public void onSubmitButton(String nama, int position) {
        listNama.set(position, nama);
        arrayAdapter.notifyDataSetChanged();
    }
}
