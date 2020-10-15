package br.com.marveltest.api;

import br.com.marveltest.base.Configurations;
import br.com.marveltest.call.response.CharacterResponseApi;
import br.com.marveltest.call.response.ComicsResponseApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IApiConnection {
    String URL_BASE = Configurations.URL_BASE_PROD;

    @GET("characters")
    Call<CharacterResponseApi> characters(@Query("ts") String ts,
                                          @Query("apikey") String apiKey,
                                          @Query("hash") String hash);

    @GET("characters/{id}/comics")
    Call<ComicsResponseApi> comics(@Path("id") int idCharacter,
                                   @Query("ts") String ts,
                                   @Query("apikey") String apiKey,
                                   @Query("hash") String hash);
}