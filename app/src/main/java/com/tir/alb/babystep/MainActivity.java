package com.tir.alb.babystep;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button BtnLogin,BtnRegister,BtnRecover;
    EditText InpEmail,InpPassword;
    String RcvEmail,RcvPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BtnLogin = (Button) findViewById(R.id.btn_login);
        BtnRegister = (Button) findViewById(R.id.bnt_register);
        BtnRecover = (Button) findViewById(R.id.bnt_recover);

        InpEmail = (EditText) findViewById(R.id.inp_email);
        InpPassword = (EditText) findViewById(R.id.inp_password);




        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"test pippo",Toast.LENGTH_LONG).show();
               // dialog();
                checkData();
            }
        });

        BtnRegister.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"Breshkaaa",Toast.LENGTH_LONG).show();

                return false;
            }
        });




    }


    public void dialog(){



        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Alert Dialog");

        // Setting Dialog Message
        alertDialog.setMessage("Welcome to AndroidHive.info");

        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
            }
        });

        // Showing Alert Message
        alertDialog.show();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Intent intent = new Intent(this, Paf_Menu.class);
    //startActivity(intent);
    //finish();


    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first



    }

    public void checkData(){
        RcvEmail = InpEmail.getText().toString();
        RcvPassword = InpPassword.getText().toString();
        if(RcvEmail.equalsIgnoreCase("") || RcvEmail==null){
            Toast.makeText(getApplicationContext(), "ska te dhena", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "ka te dhena: "+RcvEmail, Toast.LENGTH_SHORT).show();
            goProfile();
        }


    }


    public void goProfile(){

        //b.putDouble("age", ageDouble);
       // b.putBoolean("married", isMarried);

        RcvEmail = InpEmail.getText().toString();

        Intent intent = new Intent(this, Profili.class);
        Bundle b = new Bundle();
        b.putString("fullname", RcvEmail);
        b.putLong("phoneNumber", 123466);
        //intent.putExtra("email","erion@email.com");
        //intent.putExtra(b);
        intent.putExtras(b);

        startActivity(intent);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //finish();
    }

}
