package ee.mtakso.driver.network.client.audio_recording.upload;

import android.content.Context;
import android.net.Uri;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import java.io.InputStream;
import javax.inject.Inject;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: UploadAudioRecordingManager.kt */
/* loaded from: classes3.dex */
public final class UploadAudioRecordingManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21398a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioRecordingManager f21399b;

    /* renamed from: c  reason: collision with root package name */
    private final AudioRecordingMapper f21400c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioRecordingClient f21401d;

    /* renamed from: e  reason: collision with root package name */
    private final AudioRecordingUploadClient f21402e;

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineDispatcher f21403f;

    @Inject
    public UploadAudioRecordingManager(Context context, AudioRecordingManager audioRecordingManager, AudioRecordingMapper audioRecordingMapper, AudioRecordingClient audioRecordingClient, AudioRecordingUploadClient audioRecordingUploadClient, CoroutineDispatcher dispatcher) {
        Intrinsics.f(context, "context");
        Intrinsics.f(audioRecordingManager, "audioRecordingManager");
        Intrinsics.f(audioRecordingMapper, "audioRecordingMapper");
        Intrinsics.f(audioRecordingClient, "audioRecordingClient");
        Intrinsics.f(audioRecordingUploadClient, "audioRecordingUploadClient");
        Intrinsics.f(dispatcher, "dispatcher");
        this.f21398a = context;
        this.f21399b = audioRecordingManager;
        this.f21400c = audioRecordingMapper;
        this.f21401d = audioRecordingClient;
        this.f21402e = audioRecordingUploadClient;
        this.f21403f = dispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] f(Uri uri) {
        byte[] bArr;
        InputStream openInputStream = this.f21398a.getContentResolver().openInputStream(uri);
        if (openInputStream != null) {
            bArr = ByteStreamsKt.c(openInputStream);
        } else {
            bArr = null;
        }
        if (bArr != null) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return bArr;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(ee.mtakso.driver.network.client.OrderHandle r6, kotlin.coroutines.Continuation<? super kotlin.Result<ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager$uploadAudioRecording$1
            if (r0 == 0) goto L13
            r0 = r7
            ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager$uploadAudioRecording$1 r0 = (ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager$uploadAudioRecording$1) r0
            int r1 = r0.f21406h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21406h = r1
            goto L18
        L13:
            ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager$uploadAudioRecording$1 r0 = new ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager$uploadAudioRecording$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f21404f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f21406h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = r5.f21403f
            ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager$uploadAudioRecording$2 r2 = new ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager$uploadAudioRecording$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.f21406h = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r6 = r7.j()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager.g(ee.mtakso.driver.network.client.OrderHandle, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
