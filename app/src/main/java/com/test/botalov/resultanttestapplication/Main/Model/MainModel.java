package com.test.botalov.resultanttestapplication.Main.Model;

import com.test.botalov.resultanttestapplication.Application.ApplicationTest;
import com.test.botalov.resultanttestapplication.Main.Model.Entities.Data;
import com.test.botalov.resultanttestapplication.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel implements IMainModel {
    private Retrofit retrofit;

    @Override
    public Observable<Data> getDataObservable() {
        return getRetrofit().create(IDataNetwork.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Data> getRepeatObservable() {
        return getRetrofit().create(IDataNetwork.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .repeatWhen(completed -> completed.delay(15, TimeUnit.SECONDS));
    }

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OkHttpClient okHttpClient = builder
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();

            String baseUrl = ApplicationTest.getAppContext().getString(R.string.base_url);
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return retrofit;
    }
}
