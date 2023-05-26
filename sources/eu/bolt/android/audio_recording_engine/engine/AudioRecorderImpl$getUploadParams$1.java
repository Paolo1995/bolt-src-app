package eu.bolt.android.audio_recording_engine.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioRecorderImpl.kt */
@DebugMetadata(c = "eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl", f = "AudioRecorderImpl.kt", l = {222}, m = "getUploadParams")
/* loaded from: classes5.dex */
public final class AudioRecorderImpl$getUploadParams$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f36645f;

    /* renamed from: g  reason: collision with root package name */
    Object f36646g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f36647h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ AudioRecorderImpl f36648i;

    /* renamed from: j  reason: collision with root package name */
    int f36649j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecorderImpl$getUploadParams$1(AudioRecorderImpl audioRecorderImpl, Continuation<? super AudioRecorderImpl$getUploadParams$1> continuation) {
        super(continuation);
        this.f36648i = audioRecorderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36647h = obj;
        this.f36649j |= Integer.MIN_VALUE;
        return this.f36648i.d(null, this);
    }
}
