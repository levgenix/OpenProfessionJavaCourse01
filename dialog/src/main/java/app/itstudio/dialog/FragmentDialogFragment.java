/*
 * Created by Evgeny V. Lobach on 30.09.18 22:58
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 30.09.18 22:58
 */

package app.itstudio.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class FragmentDialogFragment extends DialogFragment {

    private EditText mEditText;
    private DialogCallback mCallback;

    public interface DialogCallback {
        void setPositiveResult(String result);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DialogCallback) {
            mCallback = (DialogCallback) context;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View inflate = getActivity().getLayoutInflater().inflate(R.layout.di_info, null);
        mEditText = inflate.findViewById(R.id.editText);

        builder.setTitle("Info")
                .setView(inflate)
                .setPositiveButton("true", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mEditText.getText().length() > 0) {
                            mCallback.setPositiveResult(mEditText.getText().toString());
                        }
                    }
                }) .setNegativeButton("false", null).setNeutralButton("cancel", null);
        return builder.create();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
}
