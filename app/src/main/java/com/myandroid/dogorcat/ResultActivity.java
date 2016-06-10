package com.myandroid.dogorcat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import dogorcat.myandroid.achitu.dogorcatperson.R;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewPerson;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewPerson=(TextView)findViewById(R.id.textViewPersonId);
        imageViewResult=(ImageView)findViewById(R.id.imageViewResultId);

        Bundle extras= getIntent().getExtras();
        if(extras!=null){
            int dogResult= extras.getInt("dogCounter");
            int catResult=extras.getInt("catCounter");

            if(dogResult>catResult){
                textViewPerson.setText("DOG PERSON!!!");
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.dog));

            }else if(dogResult<catResult){
                textViewPerson.setText("CAT PERSON!!!");
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.cat));
            }else{
                textViewPerson.setText("Neither!!!");
            }

        }
    }

}
