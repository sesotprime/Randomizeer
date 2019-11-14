package com.randomizeer;

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
        showResults();
    }

    private void showResults() {
        Result = findViewById(R.id.resultDisplay);
        //MainActivity myMainActivity = new MainActivity();
        //int arraySize =3;
        /*String extras = getIntent().getStringExtra("myArr");
        String[] extras = getIntent().getStringExtra("myArr");
        String[] myArr = extras.
                //.toString();
        Bundle b= this.getIntent().getExtras();
        String[] array=b.getStringArray("key");*/
        Intent intent =getIntent();
        String[] testArray = intent.getStringArrayExtra("strings");
        String[] testNamelist = intent.getStringArrayExtra("Namelist");
        /*for(int i = 0; i < arraySize; i++) {
            Result.setText("Show me: " +testArray[i]);
            //Result.append("\n");
        }
        */
        int arraySize = testNamelist.length - 2;
        for(int i = 0; i < arraySize; i++) {
            Result.append("Show me "+ testArray[i]);
            Result.append("\n");
        }
    }
}
