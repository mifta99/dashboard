package mifta.code.dispendukproject1;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("login.php")
    Call<respon> login(@Field("username") String username,
                       @Field("password") String password);

}
