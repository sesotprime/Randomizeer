package com.randomizeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.NameList;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String ConName;
    int SampleSize;
    int SelectSize;
    int[] Randomholder = new int[100];
    String[] Nameholder = new String[100];
    int i = 0;
    EditText RanName;
    String[] namelist;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void allButtonClickHandler(View view) {
        if (view.getId() == R.id.Submit) {
            final Button submit =findViewById(R.id.Submit);
            submit.setEnabled(false);
            final EditText RanName = (EditText) findViewById(R.id.NamesInput);
            final EditText size = findViewById(R.id.totalSizeInput);
            final EditText Ssize = findViewById(R.id.selectedSizeInput);

            ConName = RanName.getText().toString();
            namelist = ConName.split(",");
            SampleSize = Integer.parseInt(size.getText().toString());
            SelectSize = Integer.parseInt(Ssize.getText().toString());
            validateInput();
        }
    }

    public void validateInput() {
        int max = 0;
        int min = 0;
        int defaultLength = namelist.length;

        defaultLength = defaultLength - 1;


        if (defaultLength == SampleSize) {

            max = SampleSize;
        } else {
            max = defaultLength;
        }
        Random r = new Random();
        final TextView test = findViewById(R.id.Test);
        final TextView test2 = findViewById(R.id.Test2);
        i = 0;

        test.setText("");
        test2.setText("");
        while (i < SelectSize) {
            int hold = r.nextInt((max - min + 1) + min);

            if(intArrayContains(Randomholder,hold)==true)
            {
                hold = r.nextInt((max - min + 1) + min);
            }
            else {
                Randomholder[i] = hold;
                Nameholder[i]= namelist[hold];
                test.append(" "+ Nameholder[i]);
                i++;
            }

        }
        goToResults();
    }
        public void goToResults() {
            Intent results = new Intent(this, Results.class);
            String[] testName = Nameholder;
            String[] testNamelist = namelist;
            results.putExtra("strings", testName);
            results.putExtra("Namelist", testNamelist);
            startActivity(results);
    }
    private boolean intArrayContains(int[] intArray,int value){
        boolean result = false;
        for (int item : intArray) {
            if (item == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
