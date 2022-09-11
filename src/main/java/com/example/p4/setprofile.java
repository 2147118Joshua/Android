package com.example.p4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class setprofile extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    ConstraintLayout cl;

    String[] courses = { "10-15", "16-20",
            "21-26", "26-35",
            "35-50", "60+" };
    ToggleButton tb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        cl=(ConstraintLayout) findViewById(R.id.cll);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setprofile);
        Spinner spino = findViewById(R.id.spinner);
        spino.setOnItemSelectedListener(this);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        tb.setChecked(false);
        tb.setTextOn("Remainder is Set");

        tb.setTextOff("Remainder is Turned Off");
        tb.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(android.R.id.content),"Remander is added to you Calender",Snackbar.LENGTH_LONG).setAction("close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setActionTextColor(Color.RED).show();
            }
        });

        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses);
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spino.setAdapter(ad);

    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.context_menu, menu);

        return true;

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.context_Home:

                Toast.makeText(setprofile.this,"Going to home page",Toast.LENGTH_SHORT).show();
                MainActivity();


                return true;

            case R.id.help:

                Toast.makeText(setprofile.this,"Choose your Brand",Toast.LENGTH_SHORT).show();
                suggestion();

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(setprofile.this);

        // Set the message show for the Alert time
        builder.setMessage("Do you want to exit ?");

        // Set Alert Title
        builder.setTitle("Alert !");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);
        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // When the user click yes button
                                // then app will close
                                finish();
                            }
                        });
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),
                courses[position],
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void MainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void suggestion(){
        Intent intent = new Intent(this, suggestion.class);
        startActivity(intent);
    }
}