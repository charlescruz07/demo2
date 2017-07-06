package com.cruz.sportify.LoginRegistration;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cruz.sportify.Main.MainActivity;
import com.cruz.sportify.R;
import com.github.mmin18.widget.RealtimeBlurView;

public class SelectFrequencyActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView moderateFreq, normalFreq, extremeFreq, freqDesc;
    private int selectedFreq = R.id.normalFreq;
    private Button nextBtn;
    private RealtimeBlurView realtimeBlurView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_frequency);

        moderateFreq = (TextView) findViewById(R.id.moderateFreq);
        normalFreq = (TextView) findViewById(R.id.normalFreq);
        extremeFreq = (TextView) findViewById(R.id.extremeFreq);
        freqDesc = (TextView) findViewById(R.id.freqDesc);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        realtimeBlurView = (RealtimeBlurView) findViewById(R.id.blurviewHome);
    }

    @Override
    public void onClick(View view) {
        unSelect(selectedFreq);

        if(view.getId() == R.id.moderateFreq){
            moderateFreq.setBackground(ContextCompat.getDrawable(this,R.drawable.frame));
            moderateFreq.setTypeface(null, Typeface.BOLD);
            freqDesc.setText("FOR USERS WHO SELDOM\n" +
                    "ENGAGE IN SPORTS AND\n" +
                    "OTHER PHYSICAL ACTIVITIES");
            selectedFreq = R.id.moderateFreq;
        }else if(view.getId() == R.id.normalFreq){
            normalFreq.setBackground(ContextCompat.getDrawable(this,R.drawable.frame));
            normalFreq.setTypeface(null, Typeface.BOLD);
            freqDesc.setText("FOR USERS WHO ARE QUITE\n" +
                    "ACTIVE AND JUST WANT TO\n" +
                    "PLAY FOR FUN");
            selectedFreq = R.id.normalFreq;
        }else if(view.getId() == R.id.extremeFreq){
            extremeFreq.setBackground(ContextCompat.getDrawable(this,R.drawable.frame));
            extremeFreq.setTypeface(null, Typeface.BOLD);
            freqDesc.setText("FOR USERS WHO ARE\n" +
                    "HIGHLY COMPETITIVE AND\n" +
                    "ALWAYS SEEKING FOR A MATCH");
            selectedFreq = R.id.extremeFreq;
        }else if(view.getId() == R.id.nextBtn){
            realtimeBlurView.setVisibility(View.VISIBLE);
            startActivity(new Intent(SelectFrequencyActivity.this, MainActivity.class));
            finish();
        }
    }

    public void unSelect(int id){
        switch (id){
            case R.id.moderateFreq:
                moderateFreq.setBackgroundResource(0);
                moderateFreq.setTypeface(null,Typeface.NORMAL);
                break;
            case R.id.normalFreq:
                normalFreq.setBackgroundResource(0);
                normalFreq.setTypeface(null,Typeface.NORMAL);
                break;
            case R.id.extremeFreq:
                extremeFreq.setBackgroundResource(0);
                extremeFreq.setTypeface(null,Typeface.NORMAL);
                break;
        }
    }
}
