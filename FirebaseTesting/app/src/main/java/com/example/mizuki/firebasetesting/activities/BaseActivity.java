package com.example.mizuki.firebasetesting.activities;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mizuki.firebasetesting.data.model.AppModel;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    AppModel mAppModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(setDisplayHomeUpEnabled());
        }

        ButterKnife.bind(this,this);

        mAppModel = ViewModelProviders.of(this).get(AppModel.class);
    }

    protected abstract boolean setDisplayHomeUpEnabled();

    protected abstract int getLayout();

    protected AppModel getmAppModel(){
        return mAppModel;
    }
}
