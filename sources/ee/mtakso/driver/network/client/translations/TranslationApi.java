package ee.mtakso.driver.network.client.translations;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: TranslationApi.kt */
/* loaded from: classes3.dex */
public interface TranslationApi {
    @GET("/translation/exportFileHttp")
    Single<ServiceTranslations> a(@Query("project") String str, @Query("file") String str2, @Query("language") String str3);
}
