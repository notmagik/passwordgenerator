package com.example.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public String generateString() {
        CheckBox digCheckBox = (CheckBox) findViewById(R.id.digCheckBox);
        CheckBox upperCheckBox = (CheckBox) findViewById(R.id.upperCheckBox);
        CheckBox lowerCheckBox = (CheckBox) findViewById(R.id.lowerCheckBox);
        CheckBox symbolCheckBox = (CheckBox) findViewById(R.id.symbolCheckBox);
        EditText kolEditText = (EditText) findViewById(R.id.editText);
        int numberOfSymbols = Integer.parseInt(kolEditText.getText().toString());

        String allowedChars = "";
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+<>?/{}~!";

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        if(upperCheckBox.isChecked()) {
            allowedChars += upperCaseChars;
            sb.append(upperCaseChars.charAt(random.nextInt(upperCaseChars.length()-1)));
        }

        if(lowerCheckBox.isChecked()) {
            allowedChars += lowerCaseChars;
            sb.append(lowerCaseChars.charAt(random.nextInt(lowerCaseChars.length()-1)));
        }

        if(digCheckBox.isChecked()) {
            allowedChars += numberChars;
            sb.append(numberChars.charAt(random.nextInt(numberChars.length()-1)));
        }

        if(symbolCheckBox.isChecked()) {
            allowedChars += specialChars;
            sb.append(specialChars.charAt(random.nextInt(specialChars.length()-1)));
        }

        for(int i=sb.length();i < allowedChars.length();++i){
            sb.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
        }

        return  sb.toString().substring(0,numberOfSymbols);
    }

    public void generate(View view) {
        TextView pass = (TextView) findViewById(R.id.textView);
        TextView pass2 = (TextView)findViewById(R.id.textView2);
        TextView pass3 = (TextView)findViewById(R.id.textView3);
        pass.setText(generateString());
        pass2.setText(generateString());
        pass3.setText(generateString());
    }
}
