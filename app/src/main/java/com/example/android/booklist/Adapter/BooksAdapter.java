package com.example.android.booklist.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.booklist.Models.Book;
import com.example.android.booklist.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.http.Path;

/**
 * Created by Terentev on 14.07.2017.
 */

public class BooksAdapter extends ArrayAdapter<Book> {

    private static class ViewHolder{
        public ImageView bookCover;
        public TextView bookTitle;
        public TextView bookAuthor;
    }

    public BooksAdapter(Context context,ArrayList<Book> books){
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get the data for a book at certain position
        final Book mBook = getItem(position);
        ViewHolder viewHolder;
        if(convertView==null){
           viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.book_item, parent, false);
            viewHolder.bookCover = (ImageView)convertView.findViewById(R.id.book_cover);
            viewHolder.bookTitle = (TextView)convertView.findViewById(R.id.book_title);
            viewHolder.bookAuthor = (TextView)convertView.findViewById(R.id.book_author);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //populate view with data
        viewHolder.bookTitle.setText(mBook.getBookTitle());
        viewHolder.bookAuthor.setText(mBook.getBookAuthor());
        Picasso.with(getContext()).load(Uri.parse(mBook.getBookCover())).error(R.drawable.ic_menu_share);

        return convertView;

    }
}
