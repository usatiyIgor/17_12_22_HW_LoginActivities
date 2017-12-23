package com.example.den.a17_12_22_hw_loginactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login_next_btn;
    Button login_back_btn;
    EditText login_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_next_btn = findViewById(R.id.login_btn);
        login_back_btn = findViewById(R.id.login_back_btn);
        login_text = findViewById(R.id.input_login);
        login_next_btn.setOnClickListener(this);
        login_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_btn) {
            Intent data = new Intent(this, PasswordActivity.class);
            data.putExtra("LOGIN", String.valueOf(login_text.getText()));
            startActivityForResult(data,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                setResult(RESULT_OK, data);
                finish();
            }
        }
    }
}

