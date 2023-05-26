package eu.bolt.android.audio_recording_engine.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioRecorderImpl.kt */
@DebugMetadata(c = "eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl", f = "AudioRecorderImpl.kt", l = {260, 262}, m = "onFileUploaded")
/* loaded from: classes5.dex */
public final class AudioRecorderImpl$onFileUploaded$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f36650f;

    /* renamed from: g  reason: collision with root package name */
    Object f36651g;

    /* renamed from: h  reason: collision with root package name */
    Object f36652h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f36653i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ AudioRecorderImpl f36654j;

    /* renamed from: k  reason: collision with root package name */
    int f36655k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecorderImpl$onFileUploaded$1(AudioRecorderImpl audioRecorderImpl, Continuation<? super AudioRecorderImpl$onFileUploaded$1> continuation) {
        super(continuation);
        this.f36654j = audioRecorderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36653i = obj;
        this.f36655k |= Integer.MIN_VALUE;
        return this.f36654j.b(null, 0, this);
    }
}
