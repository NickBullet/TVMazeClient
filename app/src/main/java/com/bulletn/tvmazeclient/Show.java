package com.bulletn.tvmazeclient;

public class Show {
    private String img;
    private String name;
    private double rating;
    private String genres;
    private long id;
    private String url;
    private boolean isSelected;

    public Show(String img, String name, double rating, String genres, long id, String url, boolean isSelected){
        this.img = img;
        this.name = name;
        this.rating = rating;
        this.genres = genres;
        this.id = id;
        this.url = url;
        this.isSelected = isSelected;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
