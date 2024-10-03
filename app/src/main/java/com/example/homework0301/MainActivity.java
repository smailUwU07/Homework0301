package com.example.homework0301;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TO_EMAIL = "join.doh@example.com";

    EditText email;
    EditText theme;
    EditText message;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email_EditText);
        theme = findViewById(R.id.theme_EditText);
        message = findViewById(R.id.text_EditText);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String emailSend = email.getText().toString();
            String emailSubject = theme.getText().toString();
            String emailMessage = message.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{TO_EMAIL});
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailMessage);
            if (emailMessage.equals("") && emailSend.equals("") && emailSubject.equals("")) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(Intent.createChooser(intent, "Send to email"));
            }
        });
    }

}