package com.example.android.booklist.Models;

import android.text.TextUtils;

import org.json.JSONArray;
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


    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    private static String getAuthorFromJSON(final JSONObject jObject){
        try{
            final JSONArray authors = jObject.getJSONArray("author name");
            int authorsCount = authors.length();
            final String[] authorsArray = new String[authorsCount];
            for (int i=0;i<authorsCount;i++){
                authorsArray[i] = authors.getString(i);
            }
            return TextUtils.join(", ",authorsArray);
        } catch (JSONException e) {
            return "";
        }
    }
    public String getOpenLibraryId() {
        return openLibraryId;
    }

    public String getBookCover() {
        return "https://www.themarysue.com/wp-content/uploads/2016/08/cover-new.jpg";
    }

    public void setTitle(String title) {
        this.bookTitle = title;
    }

    public void setAuthor(String author) {
        this.bookAuthor = author;
    }
    public void setBookOpenLibraryId(String id){
        this.openLibraryId = id;
    }


    public static Book fromJson(JSONObject jObject) {
        Book mBook = new Book();
        try{
            //TODO refactor
            if(jObject.has("cover_edition_key")){
                mBook.setBookOpenLibraryId(jObject.getString("cover_edition_key"));
            }else if(jObject.has("edition_key")){
                final JSONArray ids = jObject.getJSONArray("edition_key");
                mBook.setBookOpenLibraryId(ids.getString(0));
            }
            mBook.setTitle(jObject.has("title_suggest")?jObject.getString("title_suggest"):" ");
            mBook.setAuthor(getAuthorFromJSON(jObject));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return mBook;
    }
}
