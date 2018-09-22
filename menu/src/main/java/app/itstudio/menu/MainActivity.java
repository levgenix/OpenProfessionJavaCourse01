/*
 * Created by Evgeny V. Lobach on 22.09.18 22:18
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 22.09.18 22:18
 */

package app.itstudio.menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MENU_COLOR_RED_ID = 1;
    public static final int MENU_COLOR_GREEN_ID = 2;
    public static final int MENU_COLOR_BLUE_ID = 3;
    public static final int GROUP_ID = Menu.NONE;
    public static final int ORDER_ID = Menu.NONE;
    public TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = findViewById(R.id.tv_hello);
        tvHello.setText("Long tap for Context menu");
        //registerForContextMenu(tvHello); // Включение контекстного меню в onResume() и идентично tvHello.setOnCreateContextMenuListener(this);
        tvHello.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                getMenuInflater().inflate(R.menu.context_menu, menu);
                // Additional items
                menu.add(GROUP_ID, MENU_COLOR_RED_ID, ORDER_ID, "Red");
                menu.add(GROUP_ID, MENU_COLOR_GREEN_ID, ORDER_ID, "Green");
                menu.add(GROUP_ID, MENU_COLOR_BLUE_ID, ORDER_ID, "Blue");
                menu.setHeaderTitle(R.string.context_menu_header);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_2:
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_3:
                Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_1_of_group:
                Toast.makeText(this, "Item 1 of group", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_2_of_group:
                Toast.makeText(this, "Item 2 of group", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.app_bar_search:
                Toast.makeText(this, "App bar search", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        //return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.removeItem(R.id.item_2);
        return super.onPrepareOptionsMenu(menu);
    }

/*    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.tv_hello) {
            menu.add(GROUP_ID, MENU_COLOR_RED_ID, ORDER_ID, "Red");
            menu.add(GROUP_ID, MENU_COLOR_GREEN_ID, ORDER_ID, "Green");
            menu.add(GROUP_ID, MENU_COLOR_BLUE_ID, ORDER_ID, "Blue");
        } else {
            super.onCreateContextMenu(menu, v, menuInfo);
        }

    }*/

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_COLOR_RED_ID:
                tvHello.setTextColor(Color.RED);
                break;
            case MENU_COLOR_GREEN_ID:
                tvHello.setTextColor(Color.GREEN);
                break;
            case MENU_COLOR_BLUE_ID:
                tvHello.setTextColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }
}