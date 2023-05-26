package ee.mtakso.driver.network.client.audio_recording;

import ee.mtakso.driver.network.client.OrderHandle;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.rx2.RxSingleKt;

/* compiled from: AudioRecordingClient.kt */
/* loaded from: classes3.dex */
public final class AudioRecordingClient {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineDispatcher f21368a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioRecordingNetworkAPI f21369b;

    @Inject
    public AudioRecordingClient(CoroutineDispatcher dispatcher, AudioRecordingNetworkAPI audioRecordingNetworkAPI) {
        Intrinsics.f(dispatcher, "dispatcher");
        Intrinsics.f(audioRecordingNetworkAPI, "audioRecordingNetworkAPI");
        this.f21368a = dispatcher;
        this.f21369b = audioRecordingNetworkAPI;
    }

    public final Single<GetCryptoKeyResponse> b(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return RxSingleKt.b(this.f21368a, new AudioRecordingClient$getCryptoKey$1(this, orderHandle, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(ee.mtakso.driver.network.client.OrderHandle r5, int r6, int r7, kotlin.coroutines.Continuation<? super ee.mtakso.driver.network.client.audio_recording.upload.GetUrlForFileUploadResponse> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$getUrlForFileUpload$1
            if (r0 == 0) goto L13
            r0 = r8
            ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$getUrlForFileUpload$1 r0 = (ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$getUrlForFileUpload$1) r0
            int r1 = r0.f21375h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21375h = r1
            goto L18
        L13:
            ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$getUrlForFileUpload$1 r0 = new ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$getUrlForFileUpload$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f21373f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f21375h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r8)
            ee.mtakso.driver.network.client.audio_recording.AudioRecordingNetworkAPI r8 = r4.f21369b
            ee.mtakso.driver.network.client.audio_recording.upload.GetUrlForFileUploadRequest r2 = new ee.mtakso.driver.network.client.audio_recording.upload.GetUrlForFileUploadRequest
            r2.<init>(r5, r6, r7)
            r0.f21375h = r3
            java.lang.Object r8 = r8.a(r2, r0)
            if (r8 != r1) goto L44
            return r1
        L44:
            eu.bolt.driver.core.network.response.ServerResponse r8 = (eu.bolt.driver.core.network.response.ServerResponse) r8
            java.lang.Object r5 = eu.bolt.driver.core.network.response.BasicServerResponseKt.a(r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient.c(ee.mtakso.driver.network.client.OrderHandle, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(ee.mtakso.driver.network.client.OrderHandle r5, int r6, kotlin.coroutines.Continuation<? super ee.mtakso.driver.network.client.audio_recording.upload.FileUploadFinishedResponse> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$setFileUploadFinished$1
            if (r0 == 0) goto L13
            r0 = r7
            ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$setFileUploadFinished$1 r0 = (ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$setFileUploadFinished$1) r0
            int r1 = r0.f21378h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21378h = r1
            goto L18
        L13:
            ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$setFileUploadFinished$1 r0 = new ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$setFileUploadFinished$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f21376f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f21378h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            ee.mtakso.driver.network.client.audio_recording.AudioRecordingNetworkAPI r7 = r4.f21369b
            ee.mtakso.driver.network.client.audio_recording.upload.FileUploadFinishedRequest r2 = new ee.mtakso.driver.network.client.audio_recording.upload.FileUploadFinishedRequest
            r2.<init>(r5, r6)
            r0.f21378h = r3
            java.lang.Object r7 = r7.b(r2, r0)
            if (r7 != r1) goto L44
            return r1
        L44:
            eu.bolt.driver.core.network.response.ServerResponse r7 = (eu.bolt.driver.core.network.response.ServerResponse) r7
            java.lang.Object r5 = eu.bolt.driver.core.network.response.BasicServerResponseKt.a(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient.d(ee.mtakso.driver.network.client.OrderHandle, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
