package ee.mtakso.driver.network.client.audio_recording;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioRecordingClient.kt */
@DebugMetadata(c = "ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient", f = "AudioRecordingClient.kt", l = {46}, m = "setFileUploadFinished")
/* loaded from: classes3.dex */
public final class AudioRecordingClient$setFileUploadFinished$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f21376f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ AudioRecordingClient f21377g;

    /* renamed from: h  reason: collision with root package name */
    int f21378h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecordingClient$setFileUploadFinished$1(AudioRecordingClient audioRecordingClient, Continuation<? super AudioRecordingClient$setFileUploadFinished$1> continuation) {
        super(continuation);
        this.f21377g = audioRecordingClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f21376f = obj;
        this.f21378h |= Integer.MIN_VALUE;
        return this.f21377g.d(null, 0, this);
    }
}
