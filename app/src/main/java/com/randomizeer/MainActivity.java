package com.randomizeer;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
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
    private InterstitialAd mInterstitialAd;
    private AdView mBannerAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBannerAd = findViewById(R.id.banner_AdView);
        mInterstitialAd = createNewIntAd();
        loadIntAdd();
        //Load BannerAd
        showBannerAd();

    }

    private void loadIntAdd() {
        //submit.setEnabled(false);
        AdRequest adRequest = new AdRequest.Builder().build();
                //.addTestDevice("754DB6521943676637AE86202C5ACE52")
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                //.addTestDevice("318982EEFA2B1B71D7F4A1D588C6D720")
                //.addTestDevice("743470B27F839084A5DFDEF4852F3733")
        mInterstitialAd.loadAd(adRequest);
    }

    private InterstitialAd createNewIntAd() {
        InterstitialAd intAd = new InterstitialAd(this);
        // set the adUnitId (defined in values/strings.xml)
        intAd.setAdUnitId(getString(R.string.ad_id_interstitial));
        intAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
               // submit.setEnabled(true);
            }
            @Override
            public void onAdFailedToLoad(int errorCode) {
                //submit.setEnabled(true);
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                goToResults();
            }
        });
        return intAd;
    }

    private void showBannerAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
                //.Builder().build();
                //.addTestDevice("743470B27F839084A5DFDEF4852F3733");
        mBannerAd.loadAd(adRequest);
    }

    public void allButtonClickHandler(View view) {
        if (view.getId() == R.id.Submit) {
            submit = findViewById(R.id.Submit);
            EditText RanName = findViewById(R.id.NamesInput);
            EditText size = findViewById(R.id.totalSizeInput);
            EditText Ssize = findViewById(R.id.selectedSizeInput);
            textView = findViewById(R.id.textView);
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
        int max;
        int min = 0;
        int defaultLength = namelist.length;

        defaultLength = defaultLength - 1;


        if (defaultLength == SampleSize) {

            max = SampleSize;
        } else {
            max = defaultLength;
        }
        Random r = new Random();
        i = 0;
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
        showIntAdd();
        //goToResults();
    }

    private void showIntAdd() {
        if(mInterstitialAd !=null && mInterstitialAd.isLoaded()){
            mInterstitialAd.show();

        }
        else{
            goToResults();
        }

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
