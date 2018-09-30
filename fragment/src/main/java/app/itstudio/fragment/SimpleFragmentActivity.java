/*
 * Created by Evgeny V. Lobach on 29.09.18 22:53
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 29.09.18 22:53
 */

package app.itstudio.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SimpleFragmentActivity extends AppCompatActivity {

    /*
        D/myLogs: Fragment1 onAttach
        D/myLogs: Fragment1 onCreate
        D/myLogs: Fragment1 onCreateView
        D/myLogs: Fragment1 onViewCreated
        D/myLogs: Fragment2 onAttach
        D/myLogs: Fragment2 onCreate
        D/myLogs: Fragment2 onCreateView
        D/myLogs: Fragment2 onViewCreated
        D/myLogs: Fragment1 onActivityCreated
        D/myLogs: Fragment2 onActivityCreated
        D/myLogs: Fragment1 onStart
        D/myLogs: Fragment2 onStart
        D/myLogs: Fragment1 onResume
        D/myLogs: Fragment2 onResume
        D/myLogs: Fragment1 onPause
        D/myLogs: Fragment2 onPause
        D/myLogs: Fragment1 onStop
        D/myLogs: Fragment2 onStop
        D/myLogs: Fragment1 onDestroyView
        D/myLogs: Fragment1 onDestroy
        D/myLogs: Fragment1 onDetach
        D/myLogs: Fragment2 onDestroyView
        D/myLogs: Fragment2 onDestroy
        D/myLogs: Fragment2 onDetach
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);
    }

}
