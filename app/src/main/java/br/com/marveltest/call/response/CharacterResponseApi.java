package br.com.marveltest.call.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CharacterResponseApi {
    @Expose
    @SerializedName("data")
    public Data data;
    @Expose
    @SerializedName("etag")
    public String eTag;
    @Expose
    @SerializedName("attributionHTML")
    public String attributionHTML;
    @Expose
    @SerializedName("attributionText")
    public String attributionText;
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
        @SerializedName("urls")
        public List<Urls> urls;
        @Expose
        @SerializedName("events")
        public Events events;
        @Expose
        @SerializedName("stories")
        public Stories stories;
        @Expose
        @SerializedName("series")
        public Series series;
        @Expose
        @SerializedName("comics")
        public Comics comics;
        @Expose
        @SerializedName("resourceURI")
        public String resourceURI;
        @Expose
        @SerializedName("thumbnail")
        public Thumbnail thumbnail;
        @Expose
        @SerializedName("modified")
        public String modified;
        @Expose
        @SerializedName("description")
        public String description;
        @Expose
        @SerializedName("name")
        public String name;
        @Expose
        @SerializedName("id")
        public int id;
    }

    public static class Urls {
        @Expose
        @SerializedName("url")
        public String url;
        @Expose
        @SerializedName("type")
        public String type;
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
        public String collectionURI;
        @Expose
        @SerializedName("available")
        public int available;
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
        public String collectionURI;
        @Expose
        @SerializedName("available")
        public int available;
    }

    public static class Items {
        @Expose
        @SerializedName("type")
        public String type;
        @Expose
        @SerializedName("name")
        public String name;
        @Expose
        @SerializedName("resourceURI")
        public String resourceURI;
    }

    public static class Series {
        @Expose
        @SerializedName("returned")
        public int returned;
        @Expose
        @SerializedName("items")
        public List<Items> items;
        @Expose
        @SerializedName("collectionURI")
        public String collectionURI;
        @Expose
        @SerializedName("available")
        public int available;
    }

    public static class Comics {
        @Expose
        @SerializedName("returned")
        public int returned;
        @Expose
        @SerializedName("items")
        public List<Items> items;
        @Expose
        @SerializedName("collectionURI")
        public String collectionURI;
        @Expose
        @SerializedName("available")
        public int available;
    }

    public static class Thumbnail {
        @Expose
        @SerializedName("extension")
        public String extension;
        @Expose
        @SerializedName("path")
        public String path;
    }
}