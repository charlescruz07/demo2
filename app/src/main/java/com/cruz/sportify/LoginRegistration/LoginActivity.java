package com.cruz.sportify.LoginRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.cruz.sportify.R;

public class LoginActivity extends AppCompatActivity {

    private Button facebookLogin, googleLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        facebookLogin = (Button) findViewById(R.id.facebookLogin);
        googleLogin = (Button) findViewById(R.id.googleLogin);

        facebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SelectSportActivity.class));
                finish();
            }
        });

    }
}
