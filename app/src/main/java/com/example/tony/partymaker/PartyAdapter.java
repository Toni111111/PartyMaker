package com.example.tony.partymaker;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.tony.partymaker.model.Party;

import java.util.ArrayList;

/**
 * Created by Tony on 01.11.2016.
 */
public class PartyAdapter extends RecyclerView.Adapter<PartyAdapter.ViewHolder> {
    private Party party;
    private Activity activity;
    private ArrayList<Party> mParties;

    public PartyAdapter(Activity activity, ArrayList<Party> mParties) {
        this.activity = activity;
        this.mParties = mParties;
    }

    public Party add(Party party){
        mParties.add(party);
        return party;
    }


    @Override
    public PartyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PartyAdapter.ViewHolder holder, int position) {

        holder.namePartyView.setText("Название" + mParties.get(position).getData().get(position));

    }

    @Override
    public int getItemCount() {
        return mParties.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView namePartyView;
        public ImageView imagePartyView;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            namePartyView = (TextView) itemView.findViewById(R.id.name_party);
            imagePartyView = (ImageView) itemView.findViewById(R.id.image_party);
        }
    }
}

