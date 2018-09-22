/*
 * Created by Evgeny V. Lobach on 22.09.18 22:02
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 22.09.18 22:02
 */

package app.itstudio.customtoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.buttonId);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View layout = getLayoutInflater().inflate(R.layout.custom_toast, null, false);

                EditText et = findViewById(R.id.editTextId);

                TextView text = layout.findViewById(R.id.textId);
                text.setText("Hello, " + et.getText().toString() + ", from custom toast!");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0, 120);
                toast.setView(layout);
                toast.show();
            }
        });
    }
}
