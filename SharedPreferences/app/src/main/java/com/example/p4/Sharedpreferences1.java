package com.example.p4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Sharedpreferences1 extends AppCompatActivity {

    EditText etAddress;
    EditText etAge;
    Button btSave;
    TextView tvSize;
    ArrayList<SharedPrefModalClass>arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);

        etAddress = findViewById(R.id.et_Address);
        etAge = findViewById(R.id.et_age);
        btSave= findViewById(R.id.bt_save);
        tvSize = findViewById(R.id.tv_size);
        loadData();
        
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData(etAddress.getText().toString(),etAge.getText().toString());
            }
        });



    }

    @SuppressLint("SetTextI18n")
    private void loadData() {
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("DATA",MODE_PRIVATE);
        Gson gson=new Gson();
        String json=sharedPreferences.getString("student_data",null);
        Type type = new TypeToken<ArrayList<SharedPrefModalClass>>(){

        }.getType();

        arrayList=gson.fromJson(json,type);

        if(arrayList==null){
            arrayList=new ArrayList<>();
            tvSize.setText(""+0);
        }else{
            for(int i=0; i<arrayList.size();i++){
                tvSize.setText(tvSize.getText().toString()+"\n"+arrayList.get(i).name+"\n");
            }
        }
    }

    private void saveData(String name, String age) {

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("DATA",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        Gson gson=new Gson();
        arrayList.add(new SharedPrefModalClass(name, Integer.parseInt(age)));
        String json = gson.toJson(arrayList);
        editor.putString("student_data",json);
        editor.apply();
        tvSize.setText("Address\n");
        loadData();
    }
}