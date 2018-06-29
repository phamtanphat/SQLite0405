package com.ptp.phamtanphat.sqlite0405;

import android.os.Parcel;
import android.os.Parcelable;

public class Monan implements Parcelable {
    private Integer Id;
    private String Tenmonan;
    private Integer Giamonan;
    private String Diachi;

    public Monan(Integer id, String tenmonan, Integer giamonan, String Diachi) {
        Id = id;
        Tenmonan = tenmonan;
        Giamonan = giamonan;
        this.Diachi = Diachi;
    }

    protected Monan(Parcel in) {
        if (in.readByte() == 0) {
            Id = null;
        } else {
            Id = in.readInt();
        }
        Tenmonan = in.readString();
        if (in.readByte() == 0) {
            Giamonan = null;
        } else {
            Giamonan = in.readInt();
        }
        Diachi = in.readString();
    }

    public static final Creator<Monan> CREATOR = new Creator<Monan>() {
        @Override
        public Monan createFromParcel(Parcel in) {
            return new Monan(in);
        }

        @Override
        public Monan[] newArray(int size) {
            return new Monan[size];
        }
    };

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenmonan() {
        return Tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        Tenmonan = tenmonan;
    }

    public Integer getGiamonan() {
        return Giamonan;
    }

    public void setGiamonan(Integer giamonan) {
        Giamonan = giamonan;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (Id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(Id);
        }
        dest.writeString(Tenmonan);
        if (Giamonan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(Giamonan);
        }
        dest.writeString(Diachi);
    }
}
