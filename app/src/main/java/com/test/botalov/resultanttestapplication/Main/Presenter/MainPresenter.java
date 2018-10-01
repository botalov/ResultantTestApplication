package com.test.botalov.resultanttestapplication.Main.Presenter;

import com.test.botalov.resultanttestapplication.Main.Model.Entities.Data;
import com.test.botalov.resultanttestapplication.Main.Model.IMainModel;
import com.test.botalov.resultanttestapplication.Main.Model.MainModel;
import com.test.botalov.resultanttestapplication.Main.View.IMainView;

import io.reactivex.observers.DisposableObserver;

public class MainPresenter implements IMainPresenter {
    private IMainModel model;
    private IMainView view;

    private DisposableObserver<Data> dataDisposableObserver;
    private DisposableObserver<Data> dataRepeatDisposableObserver;

    @Override
    public void attachView(IMainView view) {
        this.view = view;
        this.model = new MainModel();
    }

    @Override
    public void detachView() {
        this.view = null;
        this.model = null;
        this.dataDisposableObserver.dispose();
        this.dataRepeatDisposableObserver.dispose();
    }

    @Override
    public void onUpdate() {
        dataDisposableObserver = model.getDataObservable()
                .subscribeWith(getObserver());
    }

    @Override
    public void onLoad() {
        view.showLoader();
        dataRepeatDisposableObserver = model.getRepeatObservable()
                .subscribeWith(getRepeatObserver());
    }

    private DisposableObserver<Data> getObserver() {
        return new DisposableObserver<Data>() {

            @Override
            public void onNext(Data data) {
                view.hideLoader();
                view.updateData(data);
            }

            @Override
            public void onError(Throwable e) {
                view.hideLoader();
                view.showError();
            }

            @Override
            public void onComplete() {
                view.hideLoader();
                dataDisposableObserver.dispose();
            }
        };
    }

    private DisposableObserver<Data> getRepeatObserver() {
        return new DisposableObserver<Data>() {

            @Override
            public void onNext(Data data) {
                view.hideLoader();
                view.updateData(data);
            }

            @Override
            public void onError(Throwable e) {
                view.showError();
            }

            @Override
            public void onComplete() {
            }
        };
    }
}
