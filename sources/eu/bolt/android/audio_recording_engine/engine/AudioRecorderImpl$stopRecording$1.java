package eu.bolt.android.audio_recording_engine.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioRecorderImpl.kt */
@DebugMetadata(c = "eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl", f = "AudioRecorderImpl.kt", l = {176}, m = "stopRecording")
/* loaded from: classes5.dex */
public final class AudioRecorderImpl$stopRecording$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f36656f;

    /* renamed from: g  reason: collision with root package name */
    Object f36657g;

    /* renamed from: h  reason: collision with root package name */
    Object f36658h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f36659i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ AudioRecorderImpl f36660j;

    /* renamed from: k  reason: collision with root package name */
    int f36661k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecorderImpl$stopRecording$1(AudioRecorderImpl audioRecorderImpl, Continuation<? super AudioRecorderImpl$stopRecording$1> continuation) {
        super(continuation);
        this.f36660j = audioRecorderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36659i = obj;
        this.f36661k |= Integer.MIN_VALUE;
        return this.f36660j.f(this);
    }
}
