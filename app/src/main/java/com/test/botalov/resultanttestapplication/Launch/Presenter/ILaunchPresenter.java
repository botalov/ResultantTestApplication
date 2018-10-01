package com.test.botalov.resultanttestapplication.Launch.Presenter;

import com.test.botalov.resultanttestapplication.Launch.VIew.ILaunchView;

public interface ILaunchPresenter {
    void attachView(ILaunchView view);
    void detachView();
    void onShowMainView();
}
