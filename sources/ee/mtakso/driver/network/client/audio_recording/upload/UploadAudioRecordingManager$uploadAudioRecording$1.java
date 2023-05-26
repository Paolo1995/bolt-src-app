package ee.mtakso.driver.network.client.audio_recording.upload;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadAudioRecordingManager.kt */
@DebugMetadata(c = "ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager", f = "UploadAudioRecordingManager.kt", l = {25}, m = "uploadAudioRecording-gIAlu-s")
/* loaded from: classes3.dex */
public final class UploadAudioRecordingManager$uploadAudioRecording$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f21404f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ UploadAudioRecordingManager f21405g;

    /* renamed from: h  reason: collision with root package name */
    int f21406h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadAudioRecordingManager$uploadAudioRecording$1(UploadAudioRecordingManager uploadAudioRecordingManager, Continuation<? super UploadAudioRecordingManager$uploadAudioRecording$1> continuation) {
        super(continuation);
        this.f21405g = uploadAudioRecordingManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        this.f21404f = obj;
        this.f21406h |= Integer.MIN_VALUE;
        Object g8 = this.f21405g.g(null, this);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        return g8 == d8 ? g8 : Result.a(g8);
    }
}
