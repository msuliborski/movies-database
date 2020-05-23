package com.suliborski.dataintegration.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Movie {
    private String title;
    private String imageURL;
    private String year;
    private String releaseDateUSA;
    private String country;
    private String director;
    private List<String> producers = new ArrayList<>();
    private List<String> cast = new ArrayList<>();
    private String duration;
    private String distributedBy;
    private String originalLanguage;
    private List<String> musicAuthors = new ArrayList<>();;
    private String budget;
    private String boxOffice;

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
                ", budget='" + budget + '\'' + "\n" +
                ", boxOffice='" + boxOffice + '\'' + "\n" +
                '}';
    }
}
