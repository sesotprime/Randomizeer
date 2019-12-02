package com.randomizeer;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class Results extends MainActivity {
    Toolbar toolbar;
    TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        //toolbar = findViewById(R.id.resultToolbar);
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        showResults();
    }

    private void showResults() {
        Result = findViewById(R.id.resultDisplay);
        Result.setText("Results: ");
        Intent intent =getIntent();
        MainActivity mainActivity = new MainActivity();
        String[] testArray = intent.getStringArrayExtra("strings");
        String[] testNamelist = intent.getStringArrayExtra("Namelist");
        int selectSize =intent.getIntExtra("SelectSize",0);
        int arraySize = selectSize;
        //Result.append("" + arraySize);
        //Result.append(" " + selectSize);
        int a = arraySize;
        for(int i = 0; i < arraySize; i++) {

            Result.append(""+ testArray[i]);
            if (i==arraySize-1)
            {
                Result.append(" ");
            }
            else{
                Result.append(",");
            }
        }
        //Result.setText("" +count);
    }
    @Override
    public void onBackPressed(){
        Intent backToMain = new Intent(this,MainActivity.class);
        startActivity(backToMain);
    }

    public void allButtonClickHandler(View view) {
        Intent backToMain = new Intent(this,MainActivity.class);
        startActivity(backToMain);
    }
}
