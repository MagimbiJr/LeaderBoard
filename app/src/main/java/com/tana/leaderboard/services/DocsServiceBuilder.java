package com.tana.leaderboard.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DocsServiceBuilder {
    private static final String URL = "https://docs.google.com/forms/d/e/";
    private static Retrofit.Builder mBuilder = new Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit mRetrofit = mBuilder.build();
    public static <S> S buildService(Class<S> serviceType) {
        return mRetrofit.create(serviceType);
    }

}
