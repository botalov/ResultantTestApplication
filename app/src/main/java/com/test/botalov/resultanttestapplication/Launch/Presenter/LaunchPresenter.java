package com.test.botalov.resultanttestapplication.Launch.Presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.test.botalov.resultanttestapplication.Launch.VIew.ILaunchView;
import com.test.botalov.resultanttestapplication.Main.View.MainActivity;

public class LaunchPresenter implements ILaunchPresenter {
    private ILaunchView view;

    @Override
    public void attachView(ILaunchView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onShowMainView() {
        Intent intent = new Intent((AppCompatActivity)view, MainActivity.class);
        ((AppCompatActivity)view).startActivity(intent);
    }
}
