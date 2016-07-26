package com.example.andrewkhristyan.fragmentexample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.andrewkhristyan.fragmentexample.R;

/**
 * Created by andrewkhristyan on 7/26/16.
 */
public class FirstFragment extends Fragment {

    private OnSecondFragmentSelectedListener mListener;
    private Button mButton;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnSecondFragmentSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity should implement " + OnSecondFragmentSelectedListener.class.getSimpleName());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        createUI(view);
        return view;
    }

    private void createUI(View view) {
        mButton = (Button) view.findViewById(R.id.button_action);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSecondFragmentChoosed();
            }
        });
    }

    public interface OnSecondFragmentSelectedListener {

        void onSecondFragmentChoosed();

    }
}
