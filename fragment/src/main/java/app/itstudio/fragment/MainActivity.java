/*
 * Created by Evgeny V. Lobach on 29.09.18 22:29
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 29.09.18 22:29
 */

package app.itstudio.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRed, btnGreen, btnYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simpleButton = findViewById(R.id.simpleFragmentButton);
        simpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SimpleFragmentActivity.class);
                startActivity(intent);
            }
        });

        btnGreen = findViewById(R.id.btnGreen);
        btnRed = findViewById(R.id.btnRed);
        btnYellow = findViewById(R.id.btnYellow);
        btnGreen.setOnClickListener(this);
        btnRed.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGreen:
                switchFragment("green", R.color.green);
                break;
            case R.id.btnRed:
                switchFragment("red", R.color.red);
                break;
            case R.id.btnYellow:
                switchFragment("yellow", R.color.yellow);
                break;
        }
    }

    void switchFragment(String name, int color) {
        Fragment fragment;
        fragment = getSupportFragmentManager().findFragmentByTag(name);
        if (fragment == null) {
            fragment = MainFragment.newInstance(name, ContextCompat.getColor(this, color));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.colorFrameLayout, fragment, name)
                    .commit();
        } else {
            Toast.makeText(this, "Не меняем", Toast.LENGTH_SHORT).show();
        }
    }
}
