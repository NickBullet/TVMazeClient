package com.bulletn.tvmazeclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
// Class adapter for our list of shows
public class ShowAdapter extends ArrayAdapter<Show> {

    private LayoutInflater inflater;
    private int layout;
    private List<Show> shows;

    public ShowAdapter(Context context, int resource, List<Show> shows) {
        super(context, resource, shows);
        this.shows = shows;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent){

        View view = inflater.inflate(this.layout, parent, false);

        ImageView ivShowImg = (ImageView) view.findViewById(R.id.show_img);
        TextView tvShowName = (TextView) view.findViewById(R.id.show_name);
        TextView tvShowRating = (TextView) view.findViewById(R.id.show_rating);
        TextView tvShowGenres = (TextView) view.findViewById(R.id.show_genres);

        Show show = shows.get(position);

        Picasso.with(this.inflater.getContext()).load(show.getImg()).into(ivShowImg);
        tvShowName.setText(show.getName());
        tvShowRating.setText(Double.toString(show.getRating()));
        tvShowGenres.setText(show.getGenres());

        return view;
    }
}
