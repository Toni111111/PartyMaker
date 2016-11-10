package com.example.tony.partymaker.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.tony.partymaker.API;
import com.example.tony.partymaker.model.Data;
import com.example.tony.partymaker.model.Party;
import com.example.tony.partymaker.view.AllPartyActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by miha on 11.11.16.
 */

public class AllPartyPresenter {

    /*pkg*/ final AllPartyActivity activity;
    /*pkg*/ ArrayList<Data> parties;

    public AllPartyPresenter(final AllPartyActivity activity, @Nullable Bundle savedInstanceState) {
        this.activity = activity;

        if (savedInstanceState != null) {
            parties = savedInstanceState.getParcelableArrayList("parties");
        }
        if (parties == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://52.45.147.109/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            retrofit.create(API.class).getParties().enqueue(new Callback<Party>() {
                @Override
                public void onResponse(Call<Party> call, Response<Party> response) {
                    if (response.isSuccessful()) {
                        parties = response.body().getData();
                        AllPartyPresenter.this.activity.showParties(parties);
                    } else {
                        AllPartyPresenter.this.activity.onHttpError(response.code());
                    }
                }

                @Override
                public void onFailure(Call<Party> call, Throwable t) {
                    AllPartyPresenter.this.activity.onConnectionError(t);
                }
            });
        } else {
            this.activity.showParties(parties);
        }
    }

    public void saveState(Bundle outState) {
        outState.putParcelableArrayList("parties", parties);
    }

}
