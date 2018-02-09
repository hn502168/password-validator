package com.example.a18731.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = editText.getText().toString();
                Validator V = new Validator();
                if (V.Password(pass) == 1){
                    textView.setText("The password cannot be word 'password'");
                }
                else if (V.Password(pass) == 2){
                    textView.setText("The password need to longer than 8 numbers/letters");
                }
                else if (V.Password(pass) == 3){
                    textView.setText("The password cannot include special character");
                }
                else if (V.Password(pass) == 4) {
                    textView.setText("The password is weak ");
                }
                else if (V.Password(pass) == 5) {
                    textView.setText("The password is not strong enough");
                }
                else if (V.Password(pass) == 6){
                    textView.setText("The password is strong");
                }
            }
        });
    }
}
