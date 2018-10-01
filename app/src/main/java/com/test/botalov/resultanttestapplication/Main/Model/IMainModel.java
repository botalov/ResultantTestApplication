package com.test.botalov.resultanttestapplication.Main.Model;

import com.test.botalov.resultanttestapplication.Main.Model.Entities.Data;

import io.reactivex.Observable;

public interface IMainModel {
    Observable<Data> getDataObservable();
    Observable<Data> getRepeatObservable();
}
