package com.example.tony.partymaker;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tony.partymaker.model.Data;

import java.util.ArrayList;

/**
 * Created by Tony on 01.11.2016.
 */
public class PartyAdapter extends RecyclerView.Adapter<PartyAdapter.ViewHolder> {

    // fixme: эти поля могут быть финальными
    private Activity activity;
    private ArrayList<Data> mParties;


    public PartyAdapter(Activity activity, ArrayList<Data> mParties) {
        this.activity = activity;
        this.mParties = mParties;
    }

    @Override
    public PartyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PartyAdapter.ViewHolder holder, int position) {
        // fixme: (...).setText(String.format(activity.getString(R.string.title_pattern), mParties.get(position).getTitle()))
        // <string name="title_pattern">Название: %s</string>
        holder.namePartyView.setText("Название: " + mParties.get(position).getTitle());

    }
    @Override
    public int getItemCount() {
        return mParties.size();
    }

    // fixme: класс и его члены можно сделать package-local, поля — ещё и финальными
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView namePartyView;
        public ImageView imagePartyView;

        public ViewHolder(View itemView) {
            super(itemView);
            namePartyView = (TextView) itemView.findViewById(R.id.name_party);
            imagePartyView = (ImageView) itemView.findViewById(R.id.image_party);
        }
    }
}

