package ee.mtakso.driver.network.client.audio_recording;

import ee.mtakso.driver.network.client.audio_recording.upload.FileUploadFinishedRequest;
import ee.mtakso.driver.network.client.audio_recording.upload.FileUploadFinishedResponse;
import ee.mtakso.driver.network.client.audio_recording.upload.GetUrlForFileUploadRequest;
import ee.mtakso.driver.network.client.audio_recording.upload.GetUrlForFileUploadResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: AudioRecordingNetworkAPI.kt */
/* loaded from: classes3.dex */
public interface AudioRecordingNetworkAPI {
    @POST("/driver/safety/tripAudioRecording/getUrlForFileUpload")
    Object a(@Body GetUrlForFileUploadRequest getUrlForFileUploadRequest, Continuation<? super ServerResponse<GetUrlForFileUploadResponse>> continuation);

    @POST("/driver/safety/tripAudioRecording/fileUploadFinished")
    Object b(@Body FileUploadFinishedRequest fileUploadFinishedRequest, Continuation<? super ServerResponse<FileUploadFinishedResponse>> continuation);

    @POST("/driver/safety/tripAudioRecording/getCryptoKey")
    Object c(@Body GetCryptoKeyRequest getCryptoKeyRequest, Continuation<? super ServerResponse<GetCryptoKeyResponse>> continuation);
}
