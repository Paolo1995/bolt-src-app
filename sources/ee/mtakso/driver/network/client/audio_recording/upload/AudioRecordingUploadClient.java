package ee.mtakso.driver.network.client.audio_recording.upload;

import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* compiled from: AudioRecordingUploadClient.kt */
/* loaded from: classes3.dex */
public final class AudioRecordingUploadClient {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRecordingUploadAPI f21388a;

    @Inject
    public AudioRecordingUploadClient(AudioRecordingUploadAPI audioRecordingUploadAPI) {
        Intrinsics.f(audioRecordingUploadAPI, "audioRecordingUploadAPI");
        this.f21388a = audioRecordingUploadAPI;
    }

    public final Object a(String str, byte[] bArr, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = this.f21388a.a(str, RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }
}
