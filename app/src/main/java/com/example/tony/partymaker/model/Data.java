package com.example.tony.partymaker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tony on 03.11.2016.
 */
// fixme: неинформативное имя класса
public class Data implements Parcelable {

    // fixme: @Expose нужно при конвертации объекта в JSON (а не из JSON) при довольно экзотических настройках.
    // fixme: Я ни разу в жизни этой аннотацией не воспользовался.

    @SerializedName("maxPeople")
    @Expose
    private Integer maxPeople;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("long")
    @Expose
    private Double _long;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("photoId")
    @Expose
    private Integer photoId;
    @SerializedName("people")
    @Expose
    private String people;
    @SerializedName("currentPeople")
    @Expose
    private Integer currentPeople;

    // fixme: нет конструктора без аргументов. Gson вынужден создавать объект через пень-колоду

    protected Data(Parcel in) {
        description = in.readString();
        title = in.readString();
        type = in.readString();
        people = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(title);
        dest.writeString(type);
        dest.writeString(people);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    // fixme: нагенерированные геттеры-сеттеры — плохо:
    // Студия не подсвечивает фактически неиспользуемые поля, которые можно было бы удалить.

    public Integer getMaxPeople() {
        return maxPeople;
    }


    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Double getLong() {
        return _long;
    }


    public void setLong(Double _long) {
        this._long = _long;
    }

    public Double getLat() {
        return lat;
    }


    public void setLat(Double lat) {
        this.lat = lat;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getPhotoId() {
        return photoId;
    }


    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }


    public String getPeople() {
        return people;
    }


    public void setPeople(String people) {
        this.people = people;
    }


    public Integer getCurrentPeople() {
        return currentPeople;
    }


    public void setCurrentPeople(Integer currentPeople) {
        this.currentPeople = currentPeople;
    }

}
