package br.com.marveltest.call.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicsResponseApi {
    @Expose
    @SerializedName("data")
    public Data data;
    @Expose
    @SerializedName("etag")
    public String etag;
    @Expose
    @SerializedName("attributionHTML")
    public String attributionhtml;
    @Expose
    @SerializedName("attributionText")
    public String attributiontext;
    @Expose
    @SerializedName("copyright")
    public String copyright;
    @Expose
    @SerializedName("status")
    public String status;
    @Expose
    @SerializedName("code")
    public int code;

    public static class Data {
        @Expose
        @SerializedName("results")
        public List<Results> results;
        @Expose
        @SerializedName("count")
        public int count;
        @Expose
        @SerializedName("total")
        public int total;
        @Expose
        @SerializedName("limit")
        public int limit;
        @Expose
        @SerializedName("offset")
        public int offset;
    }

    public static class Results {
        @Expose
        @SerializedName("events")
        public Events events;
        @Expose
        @SerializedName("stories")
        public Stories stories;
        @Expose
        @SerializedName("characters")
        public Characters characters;
        @Expose
        @SerializedName("creators")
        public Creators creators;
        @Expose
        @SerializedName("images")
        public List<Images> images;
        @Expose
        @SerializedName("thumbnail")
        public Thumbnail thumbnail;
        @Expose
        @SerializedName("prices")
        public List<Prices> prices;
        @Expose
        @SerializedName("dates")
        public List<Dates> dates;
        @Expose
        @SerializedName("series")
        public Series series;
        @Expose
        @SerializedName("urls")
        public List<Urls> urls;
        @Expose
        @SerializedName("resourceURI")
        public String resourceuri;
        @Expose
        @SerializedName("pageCount")
        public int pagecount;
        @Expose
        @SerializedName("format")
        public String format;
        @Expose
        @SerializedName("issn")
        public String issn;
        @Expose
        @SerializedName("ean")
        public String ean;
        @Expose
        @SerializedName("diamondCode")
        public String diamondcode;
        @Expose
        @SerializedName("upc")
        public String upc;
        @Expose
        @SerializedName("isbn")
        public String isbn;
        @Expose
        @SerializedName("modified")
        public String modified;
        @Expose
        @SerializedName("description")
        public String description;
        @Expose
        @SerializedName("variantDescription")
        public String variantdescription;
        @Expose
        @SerializedName("issueNumber")
        public int issuenumber;
        @Expose
        @SerializedName("title")
        public String title;
        @Expose
        @SerializedName("digitalId")
        public int digitalid;
        @Expose
        @SerializedName("id")
        public int id;
    }

    public static class Events {
        @Expose
        @SerializedName("returned")
        public int returned;
        @Expose
        @SerializedName("items")
        public List<Items> items;
        @Expose
        @SerializedName("collectionURI")
        public String collectionuri;
        @Expose
        @SerializedName("available")
        public int available;
    }

    public static class Items {
        @Expose
        @SerializedName("name")
        public String name;
        @Expose
        @SerializedName("resourceURI")
        public String resourceuri;
    }

    public static class Stories {
        @Expose
        @SerializedName("returned")
        public int returned;
        @Expose
        @SerializedName("items")
        public List<Items> items;
        @Expose
        @SerializedName("collectionURI")
        public String collectionuri;
        @Expose
        @SerializedName("available")
        public int available;
    }


    public static class Characters {
        @Expose
        @SerializedName("returned")
        public int returned;
        @Expose
        @SerializedName("items")
        public List<Items> items;
        @Expose
        @SerializedName("collectionURI")
        public String collectionuri;
        @Expose
        @SerializedName("available")
        public int available;
    }


    public static class Creators {
        @Expose
        @SerializedName("returned")
        public int returned;
        @Expose
        @SerializedName("items")
        public List<Items> items;
        @Expose
        @SerializedName("collectionURI")
        public String collectionuri;
        @Expose
        @SerializedName("available")
        public int available;
    }

    public static class Images {
        @Expose
        @SerializedName("extension")
        public String extension;
        @Expose
        @SerializedName("path")
        public String path;
    }

    public static class Thumbnail {
        @Expose
        @SerializedName("extension")
        public String extension;
        @Expose
        @SerializedName("path")
        public String path;
    }

    public static class Prices {
        @Expose
        @SerializedName("price")
        public double price;
        @Expose
        @SerializedName("type")
        public String type;
    }

    public static class Dates {
        @Expose
        @SerializedName("date")
        public String date;
        @Expose
        @SerializedName("type")
        public String type;
    }

    public static class Series {
        @Expose
        @SerializedName("name")
        public String name;
        @Expose
        @SerializedName("resourceURI")
        public String resourceuri;
    }

    public static class Urls {
        @Expose
        @SerializedName("url")
        public String url;
        @Expose
        @SerializedName("type")
        public String type;
    }

    public static class Textobjects {
        @Expose
        @SerializedName("text")
        public String text;
        @Expose
        @SerializedName("language")
        public String language;
        @Expose
        @SerializedName("type")
        public String type;
    }
}