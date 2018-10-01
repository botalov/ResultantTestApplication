package com.test.botalov.resultanttestapplication.Main.Presenter;

import com.test.botalov.resultanttestapplication.Main.View.IMainView;

public interface IMainPresenter {
    void attachView(IMainView view);
    void detachView();

    void onUpdate();
    void onLoad();
}
