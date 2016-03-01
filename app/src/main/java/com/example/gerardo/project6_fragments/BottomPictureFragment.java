package com.example.gerardo.project6_fragments;

/**
 * Created by Gerardo on 29/02/2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomPictureFragment extends Fragment {

    private static TextView txtTopMeme;
    private static TextView txtBottomMeme;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment,container,false);

        txtTopMeme = (TextView) view.findViewById(R.id.txtTopMeme);
        txtBottomMeme = (TextView) view.findViewById(R.id.txtBottomMeme);

        return view;
    }

    public void setMemeText(String top, String bottom) {
        txtTopMeme.setText(top);
        txtBottomMeme.setText(bottom);
    }
}
