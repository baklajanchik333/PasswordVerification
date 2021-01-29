package com.example.passwordverification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText userName, password;
    private MaterialButton register;
    private ImageView image1, image2, image3, image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (hasLength(s)) {
                    image1.setImageResource(R.drawable.ic_check_green);
                } else {
                    image1.setImageResource(R.drawable.ic_check_black);
                }

                if (hasSymbol(s)) {
                    image4.setImageResource(R.drawable.ic_check_green);
                } else {
                    image4.setImageResource(R.drawable.ic_check_black);
                }

                if (hasDigit(s)) {
                    image3.setImageResource(R.drawable.ic_check_green);
                } else {
                    image3.setImageResource(R.drawable.ic_check_black);
                }

                if (hasUppercase(s)) {
                    image2.setImageResource(R.drawable.ic_check_green);
                } else {
                    image2.setImageResource(R.drawable.ic_check_black);
                }

                if (hasLength(s) && hasUppercase(s) && hasDigit(s) && hasSymbol(s)) {
                    register.setVisibility(View.VISIBLE);
                } else {
                    register.setVisibility(View.GONE);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public boolean hasLength(CharSequence value) {
        return String.valueOf(value).length() >= 8;
    }

    public boolean hasDigit(CharSequence value) {
        return String.valueOf(value).matches("(.*\\d.*)");
    }

    public boolean hasUppercase(CharSequence value) {
        String s = String.valueOf(value);
        return !s.equals(s.toLowerCase());
    }

    public boolean hasSymbol(CharSequence value) {
        String s = String.valueOf(value);
        return !s.matches("[A-Za-z0-9 ]*");
    }
}