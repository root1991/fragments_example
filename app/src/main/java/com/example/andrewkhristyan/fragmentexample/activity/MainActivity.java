package com.example.andrewkhristyan.fragmentexample.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andrewkhristyan.fragmentexample.R;
import com.example.andrewkhristyan.fragmentexample.fragment.FirstFragment;
import com.example.andrewkhristyan.fragmentexample.fragment.SecondFragment;
import com.example.andrewkhristyan.fragmentexample.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnSecondFragmentSelectedListener,
        SecondFragment.OnThirdFragmentSelectedListener, ThirdFragment.OnActivityFinishListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchFragment(FirstFragment.newInstance());
    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void onSecondFragmentChoosed() {
        switchFragment(SecondFragment.newInstance());
    }

    @Override
    public void onThirdFragmentSelected() {
        switchFragment(ThirdFragment.newInstance());
    }

    @Override
    public void onFinishPressed() {
        finish();
    }
}
