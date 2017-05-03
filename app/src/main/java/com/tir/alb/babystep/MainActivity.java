package com.tir.alb.babystep;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tir.alb.babystep.model.Article;
import com.tir.alb.babystep.model.LoginResponse;
import com.tir.alb.babystep.model.News;
import com.tir.alb.babystep.rest.API;
import com.tir.alb.babystep.rest.APIClient;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button BtnLogin,BtnRegister,BtnRecover;
    EditText InpEmail,InpPassword;
    String RcvEmail,RcvPassword;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Gson gson;

    String SharedEmail,SharedPassword;
    List<Article> article;
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
        gson = new GsonBuilder().create();

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = preferences.edit();


        SharedEmail = preferences.getString("log_email", "no email");

        if(!SharedEmail.equalsIgnoreCase("no email")){
            goProfile();
        }

        //Toast.makeText(getApplicationContext(),"Stored Email has: "+SharedEmail,Toast.LENGTH_LONG).show();


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"test pippo",Toast.LENGTH_LONG).show();
               // dialog();
                //checkData();
                get_all_news();

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
            loginUser();
            Toast.makeText(getApplicationContext(), "ka te dhena: "+RcvEmail, Toast.LENGTH_SHORT).show();
           // goProfile();
            editor.putString("log_email", RcvEmail);
            editor.putString("log_password", RcvPassword);
            editor.commit();


        }


    }




    public void goProfile(){

        //b.putDouble("age", ageDouble);
       // b.putBoolean("married", isMarried);

        RcvEmail = InpEmail.getText().toString();

        Intent intent = new Intent(this, MainMenu.class);
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


    private void loginUser() {
        RcvEmail = InpEmail.getText().toString();
        RcvPassword = InpPassword.getText().toString();
        final API apiService =
                APIClient.createAPI().create(API.class);

        Call<LoginResponse> userCallbackCall = apiService.login(RcvEmail, RcvPassword,"123456");
        userCallbackCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                System.out.println("LoginResponse:" + gson.toJson(response.body()));
                //String st = response.body().toString();
                if (!response.body().getError()) {
                    // Toast.makeText(getApplicationContext(), "LoginResponse:" + gson.toJson(response.body()), Toast.LENGTH_SHORT).show();
                    System.out.println("LoginResponse :" + gson.toJson(response.body().getToken()));
                    // int id, String fullname, String email, String phoneNumber, String token, String RememberToken
                    int id=response.body().getData().getId();
                    String fullname=response.body().getData().getFullname();
                    String email=response.body().getData().getEmail();
                    String phoneNumber=response.body().getData().getPhoneNumber();
                    String token=response.body().getToken();
                    String RememberToken=response.body().getData().getRememberToken();
                    //saveData.SaveLoginData(id,fullname,email,phoneNumber,token,RememberToken);
                    if(!token.isEmpty()){
                      //  menu();
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "Dicka Shkoi Gabim", Toast.LENGTH_SHORT).show();
                    }




                }else{
                    //dialog.dismiss();
                    Toast.makeText(getApplicationContext(), gson.toJson(response.body().getMessage()), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ndodhi nje gabim ne sistem"+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void get_all_news() {


        final API api =
                APIClient.createAPI().create(API.class);

        Call<News> totclient = api.news();
        totclient.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, retrofit2.Response<News> response) {
                //dialog.dismiss();
                // Log.d(TAG, "Succes:" + response.body().isError());
                JSONObject obj = new JSONObject();
                System.out.println("AllLectures:" + gson.toJson(response.body()));

                if(!gson.toJson(response.body()).equalsIgnoreCase("null"))
                {
                    String Status = gson.toJson(response.body().getStatus());
                    String Surce = gson.toJson(response.body().getSource());


                    article = response.body().getArticles();
                    Toast.makeText(getApplicationContext(),"Source: "+Surce,Toast.LENGTH_LONG).show();



                }else{
                    Toast.makeText(getApplicationContext(),"Sesioni juaj ka skaduar ju duhet te rilogoheni",Toast.LENGTH_LONG).show();
                }


                // recyclerView.setAdapter(new CategoryAdapter(category, R.layout.adapter_category, getActivity()));

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

                //dialog.dismiss();
            }
        });
    }
}



