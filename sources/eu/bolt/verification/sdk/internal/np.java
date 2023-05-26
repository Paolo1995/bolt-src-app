package eu.bolt.verification.sdk.internal;

import io.reactivex.Single;
import java.util.Map;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

@g0(name = "verification")
/* loaded from: classes5.dex */
public interface np {
    @POST("flowRun/submitData")
    Single<rk> a(@Body bq bqVar);

    @POST
    Single<nq> b(@Url String str, @Body Map<String, String> map);

    @POST("flowRun/reportSdkEvent")
    Single<Object> c(@Body lp lpVar);

    @POST("flowRun/uploadFile")
    @Multipart
    Single<nq> d(@Part MultipartBody.Part part, @Part MultipartBody.Part part2, @Part MultipartBody.Part part3);

    @POST("flow/trigger")
    Single<lq> e(@Body kq kqVar);

    @POST("flow/getDetails")
    Single<jo> f(@Body io ioVar);
}
