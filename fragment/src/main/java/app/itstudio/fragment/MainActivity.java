/*
 * Created by Evgeny V. Lobach on 29.09.18 22:29
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 29.09.18 22:29
 */

package app.itstudio.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
    }
}
