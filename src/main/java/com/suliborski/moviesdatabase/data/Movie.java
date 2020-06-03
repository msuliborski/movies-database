package com.suliborski.moviesdatabase.data;

import com.suliborski.moviesdatabase.utils.HttpRequest;
import com.suliborski.moviesdatabase.utils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title = "";
    private String imageURL;
    private int year;
    private String releaseDateUSA;
    private String country;
    private String director;
    private List<String> producers = new ArrayList<>();
    private List<String> cast = new ArrayList<>();
    private int duration;
    private String distributedBy;
    private String originalLanguage;
    private List<String> musicAuthors = new ArrayList<>();
    private float boxOfficeInMillionDollar;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReleaseDateUSA() {
        return releaseDateUSA;
    }

    public void setReleaseDateUSA(String releaseDateUSA) {
        this.releaseDateUSA = releaseDateUSA;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDistributedBy() {
        return distributedBy;
    }

    public void setDistributedBy(String distributedBy) {
        this.distributedBy = distributedBy;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public List<String> getMusicAuthors() {
        return musicAuthors;
    }

    public void setMusicAuthors(List<String> musicAuthors) {
        this.musicAuthors = musicAuthors;
    }

    public float getBoxOfficeInMillionDollar() {
        return boxOfficeInMillionDollar;
    }

    public void setBoxOfficeInMillionDollar(float boxOfficeInMillionDollar) {
        this.boxOfficeInMillionDollar = boxOfficeInMillionDollar;
    }

    @Override
    public String toString() {
        return "\nMovie{" + "\n" +
                "title='" + title + '\'' + "\n" +
                ", imageURL='" + imageURL + '\'' + "\n" +
                ", year=" + year + "\n" +
                ", releaseDateUSA='" + releaseDateUSA + '\'' + "\n" +
                ", country='" + country + '\'' + "\n" +
                ", director='" + director + '\'' + "\n" +
                ", producers='" + producers + '\'' + "\n" +
                ", cast=" + cast + "\n" +
                ", duration=" + duration + "\n" +
                ", distributedBy='" + distributedBy + '\'' + "\n" +
                ", originalLanguage='" + originalLanguage + '\'' + "\n" +
                ", musicAuthors=" + musicAuthors + "\n" +
                ", boxOffice='" + boxOfficeInMillionDollar + '\'' + "\n" +
                '}';
    }
}
