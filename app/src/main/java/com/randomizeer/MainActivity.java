package com.randomizeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String names;
    int SampleSize;
    int SelectSize;
    int[] Randomholder = new int[50];
    EditText name;
    EditText size;
    EditText Ssize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void allButtonClickHandler(View view) {
        if (view.getId()==R.id.Submit){
            validateInput();
        }
    }
    public void validateInput() {
        name = (EditText) findViewById(R.id.NamesInput);
        size = (EditText) findViewById(R.id.editText);
        Ssize = (EditText) findViewById(R.id.selectedSizeInput);

        names = name.getText().toString();
        SampleSize = Integer.valueOf(size.getText().toString());
        SelectSize = Integer.valueOf(Ssize.getText().toString());

        String[] namelist = names.split(",");
        if (namelist.length == SampleSize) {
            Random r = new Random();
            int  i = 0;
            for(int c = SelectSize; c>0; c-- ){
                Randomholder[i] = r.nextInt((SampleSize +1) - 1);
                i++;
            }

        }
        else {


        }
    }
}
