package com.tir.alb.babystep.rest;




import com.tir.alb.babystep.model.LoginResponse;
import com.tir.alb.babystep.model.Model_Video;
import com.tir.alb.babystep.model.News;
import com.tir.alb.babystep.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Aron on 5/21/2016.
 */
public interface API {
    //String BASE_URL = "http://46.101.125.115/news/index.php/"; //replace this with your base url
    // String BASE_URL = "http://192.168.43.77/backends/paper/index.php/api/"; //replace this with your base url
    String BASE_URL = "http://develop.almotech.org/autoshkolla_studenti/autoshkolla_studenti_service/public/api/"; //replace this with your base url
    String BASE_URL1 = "https://newsapi.org/v1/"; //replace this with your base url
//http://develop.almotech.org/autoshkolla_studenti/autoshkolla_studenti_service/public/api/login
             //articles?source=bbc-news&sortBy=top&apiKey=885fdf2bbc1449dc851652be64d6af60
    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse> register(@Field("fullname") String fullname,
                                    @Field("email") String email,
                                    @Field("password") String password,
                                    @Field("phone_number") String phone_number,
                                    @Field("device_token") String device_token,
                                    @Field("register_platform") String register_platform);
     @FormUrlEncoded
     @POST("login")
     Call<LoginResponse> login(@Field("email") String email, @Field("password") String password, @Field("device_token") String device_token);


    @GET("get_videos")
    Call<Model_Video> videos();




      @GET("articles?source=bbc-news&sortBy=top&apiKey=885fdf2bbc1449dc851652be64d6af60")
      Call<News> news();




    @FormUrlEncoded
    @POST("evoucher_access")
    Call<LoginResponse> evoucher(@Field("evoucher") String evoucher);



/*
    @GET("get_branches_markers")
    Call<Markers> clients();


    @GET("get_categories")
    Call<Model_Category> category();

    @GET("customer_favourite_categories")
    Call<Model_Category> favourite_category();

    @GET("customer_favourite_branches")
    Call<Model_Branch_Fafourites_Profile> customer_favourite_branches();

    @GET("get_offers")
    Call<Model_Offers> offers();

    @GET("get_featured_offers")
    Call<Model_Advertisement> get_featured_offers();

    @GET("customer_favourite_offers")
    Call<Model_Offers> favourite_offers();

    @GET("get_offers_by_category/{id}")
    Call<Model_Offers> get_offers_by_category(@Path("id") String id);

    @GET("get_offer_pages/{id}")
    Call<Model_Offers_Image> offerpages(@Path("id") String id);


    @GET("get_branch/{id}")
    Call<ModelBranchProfile> get_branch(@Path("id") String id);

    @GET("get_business/{id}")
    Call<ModelBussinesProfile> getbusiness(@Path("id") String id);

    @GET("get_global_offer_branches/{id}")
    Call<BranchListModel> get_global_offer_branches(@Path("id") String id);

    @GET("customer_notifications")
    Call<Model_Notification> customer_notifications();


    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("email") String email, @Field("password") String password, @Field("mobile_uuid") String mobile_uuid);

    @FormUrlEncoded
    @POST("post_customer_favourite_branch")
    Call<FavouritesModel> favourite_branch(@Field("id_branch") int favourite_branch);

    @FormUrlEncoded
    @POST("customer_notification_permission")
    Call<FavouritesModel> notification_permission(@Field("notification_permission") String notification_permission);

    @FormUrlEncoded
    @POST("refresh_token")
    Call<Model_Remember_Token> remember_token(@Field("remember_token") String remember_token);

    @FormUrlEncoded
    @POST("password/email")
    Call<FavouritesModel> forget_pass(@Field("email") String email);

    @FormUrlEncoded
    @POST("suggestion")
    Call<FavouritesModel> suggestion(@Field("suggestion") String suggestion);

    @FormUrlEncoded
    @POST("password/logout")
    Call<FavouritesModel> logout(@Field("device_token") String device_token);

    @FormUrlEncoded
    @POST("post_customer_favourite_category")
    Call<FavouritesModel> favourite_category(@Field("id_category") int favourite_category);

    @FormUrlEncoded
    @POST("post_customer_favourite_offer")
    Call<FavouritesModel> favourite_offer(@Field("id_offer") int favourite_offer);





    @FormUrlEncoded
    @POST("post_edit_customer_profile")
    Call<LoginResponse> edit_user(@Field("firstname") String firstname, @Field("lastname") String lastname, @Field("email") String email,
                                  @Field("phone_number") String phone_number, @Field("gender") String gender, @Field("age") String age,
                                  @Field("city") String city);
*/
}
