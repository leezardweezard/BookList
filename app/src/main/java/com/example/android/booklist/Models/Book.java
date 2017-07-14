package com.example.android.booklist.Models;

import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Terentev on 14.07.2017.
 */

public class Book {
    private String bookAuthor;
    private String bookTitle;
    private String bookGenre;
    private String openLibraryId;


    public String getBookAuthor(){
        return bookAuthor;
    }

    public String getBookTitle(){
        return bookTitle;
    }
    public String getBookGenre(){
        return bookGenre;
    }

    public String getOpenLibraryId(){ return openLibraryId; }

    public String getBookCover(){
        return "https://www.themarysue.com/wp-content/uploads/2016/08/cover-new.jpg";
    }

    public void setTitle(String title){
        this.bookTitle = title;
    }

    public void setAuthor(String title){
        this.bookTitle = title;
    }



    public static Book fromJson(JSONObject jObject){
        Book mBook = new Book();
return null;
    }
}
