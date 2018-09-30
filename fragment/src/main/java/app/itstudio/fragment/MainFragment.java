/*
 * Created by Evgeny V. Lobach on 30.09.18 14:54
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 30.09.18 14:54
 */

package app.itstudio.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainFragment extends Fragment {

    private static final String ARG_NAME = "arg_name";
    private static final String ARG_COLOR = "arg_color";

    private String mName;
    private int mColor;
    private TextView mTextView;

    public MainFragment() {
        // Required empty public constructor
    }

    static MainFragment newInstance(String name, int color) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
            mColor = getArguments().getInt(ARG_COLOR);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tvDesc);
        if (mName != null) {
            mTextView.setText(new String("Fragment is ").concat(mName).toString());
            view.setBackgroundColor(mColor);
        }
    }
}
