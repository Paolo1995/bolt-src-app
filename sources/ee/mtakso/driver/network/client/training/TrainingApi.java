package ee.mtakso.driver.network.client.training;

import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

/* compiled from: TrainingApi.kt */
/* loaded from: classes3.dex */
public interface TrainingApi {
    @GET("/driver-in-app-training/driver/startTraining")
    Single<ServerResponse<Training>> a();

    @GET("/driver-in-app-training/driver/completeTraining")
    Single<ServerResponse<TrainingModal>> b();

    @GET("/driver-in-app-training/driver/getTrainingNotifyModal")
    Single<ServerResponse<TrainingModal>> c();
}
