package eu.bolt.chat.async;

import eu.bolt.chat.async.TimedChunkFlow$resultFlow$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowBufferedChunks.kt */
@DebugMetadata(c = "eu.bolt.chat.async.TimedChunkFlow$resultFlow$1$1", f = "FlowBufferedChunks.kt", l = {39, 23}, m = "emit")
/* loaded from: classes5.dex */
public final class TimedChunkFlow$resultFlow$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f37866f;

    /* renamed from: g  reason: collision with root package name */
    Object f37867g;

    /* renamed from: h  reason: collision with root package name */
    Object f37868h;

    /* renamed from: i  reason: collision with root package name */
    Object f37869i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f37870j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ TimedChunkFlow$resultFlow$1.AnonymousClass1<T> f37871k;

    /* renamed from: l  reason: collision with root package name */
    int f37872l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimedChunkFlow$resultFlow$1$1$emit$1(TimedChunkFlow$resultFlow$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super TimedChunkFlow$resultFlow$1$1$emit$1> continuation) {
        super(continuation);
        this.f37871k = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f37870j = obj;
        this.f37872l |= Integer.MIN_VALUE;
        return this.f37871k.b(null, this);
    }
}
