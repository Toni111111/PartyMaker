package com.example.tony.partymaker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony on 21.10.2016.
 */
public class Party implements Parcelable {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    // fixme: зачем создавать новый ArrayList, если в конструкторе создаётся другой?
    private List<Data> data = new ArrayList<Data>();

    // fixme: нет конструктора без аргументов. Gson вынужден создавать объект через пень-колоду

    protected Party(Parcel in) {
        msg = in.readString();
        data = in.createTypedArrayList(Data.CREATOR);
    }

    public static final Creator<Party> CREATOR = new Creator<Party>() {
        @Override
        public Party createFromParcel(Parcel in) {
            return new Party(in);
        }

        @Override
        public Party[] newArray(int size) {
            return new Party[size];
        }
    };

    // fixme: с неиспользуемыми геттерами/сеттерами то же самое, что в Party

    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Data> getData() {
        return data;
    }


    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(code);
        parcel.writeString(msg);
        parcel.writeTypedList(data);
    }
}



