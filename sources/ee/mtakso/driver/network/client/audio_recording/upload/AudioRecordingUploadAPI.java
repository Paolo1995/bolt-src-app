package ee.mtakso.driver.network.client.audio_recording.upload;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Url;

/* compiled from: AudioRecordingUploadAPI.kt */
/* loaded from: classes3.dex */
public interface AudioRecordingUploadAPI {
    @PUT
    Object a(@Url String str, @Body RequestBody requestBody, Continuation<? super Unit> continuation);
}
