package eu.bolt.android.audio_recording_engine.db;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioRecordingDBImpl.kt */
@DebugMetadata(c = "eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl", f = "AudioRecordingDBImpl.kt", l = {28, 30}, m = "getRecordingProperties")
/* loaded from: classes5.dex */
public final class AudioRecordingDBImpl$getRecordingProperties$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f36586f;

    /* renamed from: g  reason: collision with root package name */
    Object f36587g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f36588h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ AudioRecordingDBImpl f36589i;

    /* renamed from: j  reason: collision with root package name */
    int f36590j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecordingDBImpl$getRecordingProperties$1(AudioRecordingDBImpl audioRecordingDBImpl, Continuation<? super AudioRecordingDBImpl$getRecordingProperties$1> continuation) {
        super(continuation);
        this.f36589i = audioRecordingDBImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36588h = obj;
        this.f36590j |= Integer.MIN_VALUE;
        return this.f36589i.c(null, this);
    }
}
