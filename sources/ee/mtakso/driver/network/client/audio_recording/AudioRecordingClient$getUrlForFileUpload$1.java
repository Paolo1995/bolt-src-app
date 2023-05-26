package ee.mtakso.driver.network.client.audio_recording;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioRecordingClient.kt */
@DebugMetadata(c = "ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient", f = "AudioRecordingClient.kt", l = {33}, m = "getUrlForFileUpload")
/* loaded from: classes3.dex */
public final class AudioRecordingClient$getUrlForFileUpload$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f21373f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ AudioRecordingClient f21374g;

    /* renamed from: h  reason: collision with root package name */
    int f21375h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecordingClient$getUrlForFileUpload$1(AudioRecordingClient audioRecordingClient, Continuation<? super AudioRecordingClient$getUrlForFileUpload$1> continuation) {
        super(continuation);
        this.f21374g = audioRecordingClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f21373f = obj;
        this.f21375h |= Integer.MIN_VALUE;
        return this.f21374g.c(null, 0, 0, this);
    }
}
