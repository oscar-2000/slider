package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.AsyncTask;

public class login_act extends AppCompatActivity {

    private ProgressBar progress;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_act);
        btn = (Button)findViewById(R.id.btnLogin);
        progress = (ProgressBar)findViewById(R.id.progressBar);
        progress.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });


    }

    class Task extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            for(int i = 0; i <= 3; i++)
            {
                try{
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            progress.setVisibility(View.INVISIBLE);
            Intent menu = new Intent(getBaseContext(),MainActivity.class);
            startActivity(menu);
        }
    }
}