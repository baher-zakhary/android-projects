package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.LineNumberReader;
import java.util.ArrayList;

public class ListItemAdapter extends ArrayAdapter<ListItem> {

    private int itemColorId;

    public ListItemAdapter(Context context, ArrayList<ListItem> models, int colorId){
        super(context, 0, models);
        this.itemColorId = context.getResources().getColor(colorId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_item, parent, false);
        }

        final ListItem currentItem = getItem(position);
        ((TextView) v.findViewById(R.id.topText)).setText(currentItem.miwok);
        ((TextView) v.findViewById(R.id.bottomText)).setText(currentItem.english);
        ((LinearLayout) v.findViewById(R.id.textLinearLayout)).setBackgroundColor(itemColorId);
        ((ImageView) v.findViewById(R.id.playImg)).setBackgroundColor(itemColorId);

        ImageView img = (ImageView) v.findViewById(R.id.listImage);
        if(currentItem.imageId != -1){
            img.setVisibility(View.VISIBLE);
            img.setImageResource(currentItem.imageId);
        }else{
            img.setVisibility(View.GONE);
        }

        return v;
    }
}
