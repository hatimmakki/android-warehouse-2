package com.maxwell.androidwarehouse2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;

/**
 * Created by Maxwell on 22/09/2015.
 */
public class ArticleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.simple_layout,
                container, false);

        return view;
    }

    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.simpleText);
        view.setText(item);
    }
}
