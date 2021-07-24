package com.example.android.miwok;

public class ListItem {
    public String english;
    public String miwok;
    public int audioTrackId;
    public int imageId = -1;

    public ListItem(String english, String miwok, int audioTrackId){
        this.english = english;
        this.miwok = miwok;
        this.audioTrackId = audioTrackId;
    }

    public ListItem(String english, String miwok, int imageId, int audioTrackId){
        this.english = english;
        this.miwok = miwok;
        this.audioTrackId = audioTrackId;
        this.imageId = imageId;
    }
}
