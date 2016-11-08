package com.example.tony.partymaker;

import com.example.tony.partymaker.model.Party;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tony on 01.11.2016.
 */
public interface API {
    @GET("partymaker/get_parties.py")
    Call<Party> getParties();
}
