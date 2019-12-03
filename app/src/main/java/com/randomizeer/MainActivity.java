package com.randomizeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
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
    String[] namelist;
    int count = 0;
    public Button submit;
    EditText size;
    EditText Ssize;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void allButtonClickHandler(View view) {
        if (view.getId() == R.id.Submit) {
            submit = findViewById(R.id.Submit);
            //submit.setEnabled(false);
            EditText RanName = findViewById(R.id.NamesInput);
            EditText size = findViewById(R.id.totalSizeInput);
            EditText Ssize = findViewById(R.id.selectedSizeInput);
            textView = findViewById(R.id.textView);

            String SampleSizeHolder = size.getText().toString();
            String SelectSizeHolder = Ssize.getText().toString();
            if (myIsDigitsOnly(size.getText().toString())){
                textView.append("It works1");
                if(myIsDigitsOnly(Ssize.getText().toString())) {
                    textView.append("It works 1_1");
                    if (!(RanName.getText().toString().trim().equals(""))) {
                        SampleSize = Integer.parseInt(size.getText().toString().trim());
                        SelectSize = Integer.parseInt(Ssize.getText().toString().trim());
                        ConName = RanName.getText().toString().trim();
                        namelist = ConName.split(",");

                        if (SampleSize==SelectSize){
                            Ssize.setError("This can't be the same as the chosen size (" +SampleSize +")");
                            textView.append(" Error 1");
                        }
                        else if(SelectSize>SampleSize){
                            Ssize.setError("This can't be the greater than chosen size (" +SampleSize +")");
                            textView.append(" Error 1");
                        }
                        if(namelist.length>SampleSize||namelist.length<SampleSize){
                            RanName.setError("Please enter " +SampleSize +" names");
                        }
                        if(SelectSize<SampleSize && namelist.length==SampleSize)
                        {
                            validateInput();
                        }
                        //validateInput();
                    }
                    else if((RanName.getText().toString().trim().equals(""))){
                        RanName.setError("Enter the names to be selected");
                        textView.append("It works1_3");
                    }
                }
                else if(!myIsDigitsOnly(Ssize.getText().toString())){
                    Ssize.setError("Enter the names to be selected");
                    textView.append("It works1_4");
                    if((RanName.getText().toString().trim().equals(""))){
                        RanName.setError("Enter the names to be selected");
                        textView.append("It works_5");
                    }
                }
                else if(RanName.getText().toString().trim().equals("")){
                    RanName.setError("Enter the names to be selected");
                    textView.append(" It works_6");
                    if(!myIsDigitsOnly(Ssize.getText().toString())) {
                        Ssize.setError("Enter the names to be selected");
                        textView.append(" It works1_6");
                    }
                }
            }
            else if (!myIsDigitsOnly(Ssize.getText().toString())) {
                Ssize.setError("Enter the size to be chosen");
                textView.append(" Go 1 2");
                if(RanName.getText().toString().trim().equals("")){
                    RanName.setError("Enter the names to be selected");
                    textView.append(" It works2_1");
                    if (!myIsDigitsOnly(size.getText().toString())){
                        size.setError("Enter the size to be chosen from");
                        textView.append(" It works2_2");
                    }
                }
            }
             else if(RanName.getText().toString().trim().equals("")){
                 RanName.setError("Enter the names to be selected");
                 textView.append(" It works3_1");
                 if (!myIsDigitsOnly(Ssize.getText().toString())) {
                     Ssize.setError("Enter the size to be chosen");
                     textView.append(" Go 3_2");
                     if (!myIsDigitsOnly(size.getText().toString())){
                         size.setError("Enter the size to be chosen from");
                         textView.append(" It works 3_3");
                     }
                 }
                 else if (!myIsDigitsOnly(size.getText().toString())){
                    size.setError("Enter the size to be chosen from");
                    textView.append(" It works 3_3");
                }
            }
             else if (!myIsDigitsOnly(size.getText().toString())){
                 size.setError("Enter the size to be chosen from");
                 textView.append(" It works 4_1");
                 if(RanName.getText().toString().trim().equals(""))
                 {
                     RanName.setError("Enter the names to be selected");
                     textView.append(" It works4_2");
                     if (!myIsDigitsOnly(Ssize.getText().toString()))
                     {
                         Ssize.setError("Enter the size to be chosen");
                         textView.append(" Go 4_3");
                     }
                 }
             }

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

        //test.setText("");
        //test2.setText("");

        while (i < SelectSize) {
            int hold = r.nextInt((max - min + 1) + min);

            if(intArrayContains(Randomholder, hold))
            {
                count++;
            }
            else {
                Randomholder[i] = hold;
                Nameholder[i]= namelist[hold];
                //test.append(" "+ Nameholder[i]);
                i++;
            }

        }
        goToResults();
    }
        public void goToResults() {
            Intent results = new Intent(this, Results.class);
            String[] Name = Nameholder;
            results.putExtra("strings", Name);
            results.putExtra("SelectSize",SelectSize);
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


    boolean myIsDigitsOnly(String str) {
        if(str.isEmpty()) {
            return false;
        } else {
            return TextUtils.isDigitsOnly(str);
        }
    }
}
