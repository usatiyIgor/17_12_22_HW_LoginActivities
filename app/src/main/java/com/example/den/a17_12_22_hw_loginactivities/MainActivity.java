package com.example.den.a17_12_22_hw_loginactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    private Button btn;
    private TextView loginTxt;
    private TextView passwordTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.wellcome_btn);
        loginTxt = findViewById(R.id.login_input);
        passwordTxt = findViewById(R.id.password_input);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.wellcome_btn){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                loginTxt.setText(data.getExtras().getString("LOGIN"));
                passwordTxt.setText(data.getExtras().getString("PASSWORD"));
            }
        }
    }
}
