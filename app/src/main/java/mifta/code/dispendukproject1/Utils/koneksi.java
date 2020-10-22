package mifta.code.dispendukproject1.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class koneksi {
    public static final String Link = "http://ws.dispendukcapil.situbondokab.go.id/";
    public static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Link).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
