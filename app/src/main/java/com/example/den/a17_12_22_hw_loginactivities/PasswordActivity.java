package com.example.den.a17_12_22_hw_loginactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener {
    Button nextBtn;
    Button backBtn;
    EditText passwordText;
    String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        nextBtn = findViewById(R.id.password_btn);
        backBtn = findViewById(R.id.password_back_btn);
        passwordText = findViewById(R.id.input_password);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            login = intent.getExtras().getString("LOGIN", "noname user");
        }
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.password_btn) {
            Intent intent = new Intent();
            intent.putExtra("LOGIN", login);
            intent.putExtra("PASSWORD", String.valueOf(passwordText.getText()));
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
