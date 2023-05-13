package com.example.recyclerviewnew;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class EPLTeamModel implements Parcelable {
    private String judul;
    private String league;

    private String badges;

    private String stadiumName;

    private String stadiumLoc;

    private String description;

    private String formedYear;

    private String stadium;

    private String jersey;

    protected EPLTeamModel(Parcel in) {
        judul = in.readString();
        league = in.readString();
        badges = in.readString();
        stadiumName = in.readString();
        stadiumLoc = in.readString();
        description = in.readString();
        formedYear = in.readString();
        stadium = in.readString();
        jersey = in.readString();
    }

    EPLTeamModel(){}

    public static final Creator<EPLTeamModel> CREATOR = new Creator<EPLTeamModel>() {
        @Override
        public EPLTeamModel createFromParcel(Parcel in) {
            return new EPLTeamModel(in);
        }

        @Override
        public EPLTeamModel[] newArray(int size) {
            return new EPLTeamModel[size];
        }
    };

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }



    public String getBadges() {
        return badges;
    }

    public void setBadges(String badges) {
        this.badges = badges;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getStadiumLoc() {
        return stadiumLoc;
    }

    public void setStadiumLoc(String stadiumLoc) {
        this.stadiumLoc = stadiumLoc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormedYear() {
        return formedYear;
    }

    public void setFormedYear(String formedYear) {
        this.formedYear = formedYear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(judul);
        parcel.writeString(league);
        parcel.writeString(badges);
        parcel.writeString(stadiumName);
        parcel.writeString(stadiumLoc);
        parcel.writeString(description);
        parcel.writeString(formedYear);
        parcel.writeString(stadium);
        parcel.writeString(jersey);
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getJersey() {
        return jersey;
    }

    public void setJersey(String jersey) {
        this.jersey = jersey;
    }
}
