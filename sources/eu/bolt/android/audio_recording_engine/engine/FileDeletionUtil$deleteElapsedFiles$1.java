package eu.bolt.android.audio_recording_engine.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDeletionUtil.kt */
@DebugMetadata(c = "eu.bolt.android.audio_recording_engine.engine.FileDeletionUtil", f = "FileDeletionUtil.kt", l = {13}, m = "deleteElapsedFiles")
/* loaded from: classes5.dex */
public final class FileDeletionUtil$deleteElapsedFiles$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f36669f;

    /* renamed from: g  reason: collision with root package name */
    Object f36670g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f36671h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ FileDeletionUtil f36672i;

    /* renamed from: j  reason: collision with root package name */
    int f36673j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDeletionUtil$deleteElapsedFiles$1(FileDeletionUtil fileDeletionUtil, Continuation<? super FileDeletionUtil$deleteElapsedFiles$1> continuation) {
        super(continuation);
        this.f36672i = fileDeletionUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36671h = obj;
        this.f36673j |= Integer.MIN_VALUE;
        return this.f36672i.a(null, null, this);
    }
}
