package com.example.android.booklist.Service;

import com.example.android.booklist.Models.Book;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Terentev on 14.07.2017.
 */

public interface OpenBookService {

    String SERVICE_ENDPOINT = "http://openlibrary.org";

    @GET("/search.json?q=")
    Observable<Book> getBook(@Query("author") String author);

}
