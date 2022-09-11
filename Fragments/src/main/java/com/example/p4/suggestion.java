package com.example.p4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class suggestion extends AppCompatActivity {
    private CheckBox yes, no, sometimes;
    Button btnSubmit;
    private RadioButton rb1, rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                StringBuffer result = new StringBuffer();
//                if (yes.isChecked()) {
//                    result.append(yes.getText().toString()).append("/n");
//                }
//                if (no.isChecked()) {
//                    result.append(yes.getText().toString()).append("/n");
//                }
//                if (sometimes.isChecked()) {
//                    result.append(yes.getText().toString()).append("/n");
//                }
//
//                Toast.makeText(suggestion.this, result.toString(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//        rb1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


    }

//    public void suggestion(View view) {
//        yes = findViewById(R.id.checkBox_yes);
//        no = findViewById(R.id.checkBox_no);
//        sometimes = findViewById(R.id.checkBox_sometimes);
//        rb1 = findViewById(R.id.radioButton);
//        rb2 = findViewById(R.id.radioButton2);
//    }

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radioButton:
//                if (checked)
//                    // Pirates are the best
//                    break;
//            case R.id.radioButton2:
//                if (checked)
//                    // Ninjas rule
//                    break;
//        }
//    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.sidemenu,menu);
        return  true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.home:

                Toast.makeText(suggestion.this,"Going to home page",Toast.LENGTH_SHORT).show();
                MainActivity();



                return true;

            case R.id.pprofile:

                Toast.makeText(suggestion.this,"Your Profile ",Toast.LENGTH_SHORT).show();
                setprofile();


                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

    public void MainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void setprofile(){
        Intent intent = new Intent(this, setprofile.class);
        startActivity(intent);
    }

}