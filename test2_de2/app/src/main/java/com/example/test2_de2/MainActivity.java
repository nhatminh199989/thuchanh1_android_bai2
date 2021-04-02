package com.example.test2_de2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listStudent;
    List<Student> t = new ArrayList<>();
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listStudent = findViewById(R.id.listView);
        adapter = new ListViewAdapter(this,t);
        listStudent.setAdapter(adapter);
        Button dobBtn = findViewById(R.id.buttonDate);
        TextView id,name;
        RadioButton male,female;
        Button dob = findViewById(R.id.buttonDate);
        id = findViewById(R.id.std_id);
        name = findViewById(R.id.std_name);
        male = findViewById(R.id.rbMale);
        female = findViewById(R.id.rbFemale);
        Spinner sp = findViewById(R.id.sp_images);
        dobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dobBtn.setText(dayOfMonth+"-"+monthOfYear+"-"+year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        Button addStd = findViewById(R.id.addStd);
        addStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String selectedImage = sp.getSelectedItem().toString();
                    int anh = 0;
                    if(selectedImage.contains("SV1"))  anh = R.drawable.sv1;
                    if(selectedImage.contains("SV2"))  anh = R.drawable.sv2;
                    if(selectedImage.contains("SV3"))  anh = R.drawable.sv3;
                    String stdId = id.getText().toString();
                    String stdName = name.getText().toString();
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    Date stdDob = format.parse(dobBtn.getText().toString());

                    String gender="";
                    if(male.isChecked()){
                        gender= "Male";
                    }
                    if(female.isChecked()){
                        gender = "Female";
                    }
                    t.add(new Student(anh,stdId,gender,stdName,stdDob));
                    adapter.notifyDataSetChanged();
                }catch (Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}