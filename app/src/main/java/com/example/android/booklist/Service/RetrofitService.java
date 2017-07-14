package com.example.android.booklist.Service;

import retrofit.RestAdapter;

/**
 * Created by Terentev on 14.07.2017.
 */

public class RetrofitService {

    /**
     * Creates retrofit service
     * @param clazz Book interface
     * @param endPoint endPoint API
     * @retun retrofit service
     */

    public static<T> T createRetrofitService(final Class<T> clazz, final String endPoint){
        final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(endPoint).build();
        T service = restAdapter.create(clazz);

        return service;
    }
}
