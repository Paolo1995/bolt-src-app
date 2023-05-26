package eu.bolt.verification.sdk.internal;

import io.reactivex.Single;
import java.util.Map;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

@g0(name = "verification")
/* loaded from: classes5.dex */
public interface im {
    @Headers({"Location: Required"})
    @POST("flowRun/submitData")
    Single<rk> a(@Body bq bqVar);

    @POST
    Single<qq> b(@Url String str, @Body Map<String, String> map);

    @Headers({"Location: Required"})
    @POST("flowRun/reportSdkEvent")
    Single<Object> c(@Body lp lpVar);

    @Headers({"Location: Required"})
    @POST("flowRun/uploadFile")
    @Multipart
    Single<qq> d(@Part MultipartBody.Part part, @Part MultipartBody.Part part2, @Part MultipartBody.Part part3);

    @Headers({"Location: Required"})
    @POST("flow/trigger")
    Single<mq> e(@Body kq kqVar);

    @Headers({"Location: Required"})
    @POST("flow/getDetails")
    Single<ko> f(@Body io ioVar);
}
