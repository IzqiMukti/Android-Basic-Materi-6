package com.dycode.edu.actors;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ActorsService {
    @GET("/JSONParsingTutorial/jsonActors")
    Call<ActorsService> getActors();
}
