package mifta.code.dispendukproject1.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("login.php")
    Call<respon> login(@Field("username") String username,
                       @Field("password") String password);

    @GET("count_kk_kab.php")
    Call<respon> count_kk_kab(@Header("Authorization") String Authorization);

    @GET("count_kk_kec.php")
    Call<respon> count_kk_kec(@Header("Authorization") String Authorization);

    @GET("count_ktp_perekaman_kab.php")
    Call<respon> count_ktp_perekaman_kab(@Header("Authorization") String Authorization);

    @GET("count_ktp_perekaman_kec.php")
    Call<respon> count_ktp_perekaman_kec(@Header("Authorization") String Authorization);

    @GET("count_ktp_pencetakan_kab.php")
    Call<respon> count_ktp_pencetakan_kab(@Header("Authorization") String Authorization);

    @GET("count_ktp_pencetakan_kec.php")
    Call<respon> count_ktp_pencetakan_kec(@Header("Authorization") String Authorization);

    @GET("count_perpindahan_kab.php")
    Call<respon> count_perpindahan_kab(@Header("Authorization") String Authorization);

    @GET("count_perpindahan_kec.php")
    Call<respon> count_perpindahan_kec(@Header("Authorization") String Authorization);

    @GET("count_biodata_kec.php")
    Call<respon> count_biodata_kec(@Header("Authorization") String Authorization);

    @GET("count_biodata_kab.php")
    Call<respon> count_biodata_kab(@Header("Authorization") String Authorization);

    @GET("count_kelahiran_kab.php")
    Call<respon> count_kelahiran_kab(@Header("Authorization") String Authorization);

    @GET("count_kelahiran_kec.php")
    Call<respon> count_kelahiran_kec(@Header("Authorization") String Authorization);

    @GET("count_kematian_kab.php")
    Call<respon> count_kematian_kab(@Header("Authorization") String Authorization);

    @GET("count_kematian_kec.php")
    Call<respon> count_kematian_kec(@Header("Authorization") String Authorization);

    @GET("count_perceraian_kab.php")
    Call<respon> count_perceraian_kab(@Header("Authorization") String Authorization);

    @GET("count_perceraian_kec.php")
    Call<respon> count_perceraian_kec(@Header("Authorization") String Authorization);

    @GET("count_perkawinan_kab.php")
    Call<respon> count_perkawinan_kab(@Header("Authorization") String Authorization);

    @GET("count_perkawinan_kec.php")
    Call<respon> count_perkawinan_kec(@Header("Authorization") String Authorization);

    @GET("biodata_1jat.php")
    Call<respon> biodata_1jat(@Header("Authorization") String Authorization);

    @GET("biodata_2bes.php")
    Call<respon> biodata_2bes(@Header("Authorization") String Authorization);

    @GET("biodata_3sub.php")
    Call<respon> biodata_3sub(@Header("Authorization") String Authorization);

    @GET("biodata_4mlan.php")
    Call<respon> biodata_4mlan(@Header("Authorization") String Authorization);

    @GET("biodata_5kend.php")
    Call<respon> biodata_5kend(@Header("Authorization") String Authorization);

    @GET("biodata_6pan.php")
    Call<respon> biodata_6pan(@Header("Authorization") String Authorization);

    @GET("biodata_7sit.php")
    Call<respon> biodata_7sit(@Header("Authorization") String Authorization);

    @GET("biodata_8panji.php")
    Call<respon> biodata_8panji(@Header("Authorization") String Authorization);

    @GET("biodata_9mang.php")
    Call<respon> biodata_9mang(@Header("Authorization") String Authorization);

    @GET("biodata_10kap.php")
    Call<respon> biodata_10kap(@Header("Authorization") String Authorization);

    @GET("biodata_11arj.php")
    Call<respon> biodata_11arj(@Header("Authorization") String Authorization);

    @GET("biodata_12jang.php")
    Call<respon> biodata_12jang(@Header("Authorization") String Authorization);

    @GET("biodata_13asem.php")
    Call<respon> biodata_13asem(@Header("Authorization") String Authorization);

    @GET("biodata_14putih.php")
    Call<respon> biodata_14putih(@Header("Authorization") String Authorization);

    @GET("biodata_15sumb.php")
    Call<respon> biodata_15sumb(@Header("Authorization") String Authorization);

    @GET("biodata_16glugur.php")
    Call<respon> biodata_16glugur(@Header("Authorization") String Authorization);

    @GET("biodata_17bung.php")
    Call<respon> biodata_17bung(@Header("Authorization") String Authorization);

}
