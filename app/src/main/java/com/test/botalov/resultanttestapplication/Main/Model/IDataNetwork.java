package com.test.botalov.resultanttestapplication.Main.Model;

import com.test.botalov.resultanttestapplication.Main.Model.Entities.Data;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IDataNetwork {
    @GET("stocks.json")
    Observable<Data> getData();
}
