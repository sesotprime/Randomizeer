package com.randomizeer;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends MainActivity {
    TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
        showResults();
    }

    private void showResults() {
        Result = findViewById(R.id.resultDisplay);
        Result.setText("Results: ");
        Intent intent =getIntent();
        String[] testArray = intent.getStringArrayExtra("strings");
        String[] testNamelist = intent.getStringArrayExtra("Namelist");
        int arraySize = testNamelist.length - 2;
        for(int i = 0; i < arraySize; i++) {
            Result.append(""+ testArray[i]);
            Result.append(" ");
        }
    }
    @Override
    public void onBackPressed(){
        Intent backToMain = new Intent(this,MainActivity.class);
        submit.setEnabled(true);
        startActivity(backToMain);
    }
}
