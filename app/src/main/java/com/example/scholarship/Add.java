package com.example.scholarship;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Add extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextInputLayout title,eligible,amt,link;
    Button btn;
    DatabaseReference scholarshipRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.domain, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        title = findViewById(R.id.textInputLayout2);
        eligible = findViewById(R.id.textInputLayout3);
        amt = findViewById(R.id.textInputLayout4);
        link = findViewById(R.id.textInputLayout5);
        btn = findViewById(R.id.button8);
        scholarshipRef = FirebaseDatabase.getInstance().getReference("Scholarship");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " Selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                insert();
            }
        });
    }
        private void insert(){
            String tit = title.getEditText().getText().toString();
            String eligibility= eligible.getEditText().getText().toString();
            String amnt = amt.getEditText().getText().toString();
            String apply_link= link.getEditText().getText().toString();
            String course = spinner.getSelectedItem().toString();
            Scholarship sc = new Scholarship(course,tit,eligibility,amnt,apply_link);
            scholarshipRef.push().setValue(sc);
            Toast.makeText(Add.this,"Data inserted!",Toast.LENGTH_SHORT).show();
        }
    }





