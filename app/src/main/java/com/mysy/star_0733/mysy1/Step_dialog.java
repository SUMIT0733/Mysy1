package com.mysy.star_0733.mysy1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Step_dialog extends DialogFragment {
    Button got_it;
    ImageView img;
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.step_dialog,container,false);
        img = rootview.findViewById(R.id.help_img);
        got_it = rootview.findViewById(R.id.got_it);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        got_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageDrawable(null);
                getDialog().dismiss();
            }
        });
    }
}
