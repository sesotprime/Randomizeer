package com.randomizeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final EditText RanName = findViewById(R.id.NamesInput);


        //   ConName = RanName.getText().toString();


    }

    public void allButtonClickHandler(View view) {
        if (view.getId() == R.id.Submit) {
            final TextView test = (TextView) findViewById(R.id.Test);
            final EditText RanName = (EditText) findViewById(R.id.NamesInput);
            final EditText size = findViewById(R.id.totalSizeInput);
            final EditText Ssize = findViewById(R.id.selectedSizeInput);
            ConName = RanName.getText().toString();
            namelist = ConName.split(",");
            SampleSize = Integer.parseInt(size.getText().toString());
            SelectSize = Integer.parseInt(Ssize.getText().toString());
            //test.setText("" + SelectSize +"" +namelist[i] + ""+namelist[1] + ""+ namelist[2]);
            validateInput();
            //goToResults();

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
/*
         final TextView test = (TextView)findViewById(R.id.Test);
         test.setText("TELL ME: "+namelist[0]+namelist[1]+namelist[2]);
/*
        Random r = new Random();
       int a = r.nextInt(max - min +1 ) + min ;
        final TextView test = (TextView)findViewById(R.id.Test);
        test.setText(namelist[a]);
        test.setText("TELL ME: "+namelist[a]);*/

        Random r = new Random();
        final TextView test = findViewById(R.id.Test);
        final TextView test2 = findViewById(R.id.Test2);
        i = 0;
        //List<String> NameArrayList = Arrays.asList(namelist);
        //List<String> NameArraLList2 = Arrays.asList(namelist);
        test.setText("");
        test2.setText("");
        while (i < SelectSize) {
            //int a = r.nextInt((max - min +1) + min);
            int hold = r.nextInt((max - min + 1) + min);

            if(intArrayContains(Randomholder,hold)==true)
            {
                hold = r.nextInt((max - min + 1) + min);
            }/*
            if (Arrays.asList(Randomholder).contains(hold)) {
                test2.append("Present");
            }*/
            else {
                Randomholder[i] = hold;
                Nameholder[i]= namelist[hold];
                test.append(" "+ Nameholder[i]);
                i++;
            }

            //test.setText("Some Shi" + Randomholder[i]);*/
            /*int randIndex = r.nextInt(NameArrayList.size());
            String name = NameArrayList.get(randIndex);
            /*NameArraLList2.add(name);
            NameArrayList.remove(name);*/

        }/*
        test.setText("");
        for(int j = 0; j<namelist.length; j++) {
            test.append("" + Randomholder[j]);
        }*/
        //test.setText("Result: " + NameArraLList2);
        //test.setText("TELL ME: "+namelist[0]+namelist[1]+namelist[2]);
        goToResults();
        /*
        for(int c = SelectSize; c>0; c-- ){
            Randomholder[i] = r.nextInt((max - min +1) + min);
            //Nameholder[i] = namelist[i];
            test.setText("Some Shi" +Randomholder[i]);
            i++;
        }
        */
        // final TextView test = (TextView)findViewById(R.id.Test);
        //for(int i =SelectSize; i>0; i--){
        //    test.setText(Nameholder[i]);
        // }


    }
        public void goToResults() {
            //String myRandResult =Randomholder.toString();
            Intent results = new Intent(this, Results.class);
            String[] testName = Nameholder;
            String[] testNamelist = namelist;
            results.putExtra("strings", testName);
            results.putExtra("Namelist", testNamelist);
            startActivity(results);
    }
    private boolean intArrayContains(int[] intArray,int value){
        boolean result = false;
        for (int i=0;i<intArray.length;i++){
            if(intArray[i]==value){
                result = true;
                break;
            }
        }
        return result;
    }
}
