package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PendingRawMessageStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.DefaultPendingRawMessageStorage", f = "PendingRawMessageStorage.kt", l = {105}, m = "removeMessages")
/* loaded from: classes5.dex */
public final class DefaultPendingRawMessageStorage$removeMessages$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39585f;

    /* renamed from: g  reason: collision with root package name */
    Object f39586g;

    /* renamed from: h  reason: collision with root package name */
    Object f39587h;

    /* renamed from: i  reason: collision with root package name */
    Object f39588i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f39589j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ DefaultPendingRawMessageStorage f39590k;

    /* renamed from: l  reason: collision with root package name */
    int f39591l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultPendingRawMessageStorage$removeMessages$1(DefaultPendingRawMessageStorage defaultPendingRawMessageStorage, Continuation<? super DefaultPendingRawMessageStorage$removeMessages$1> continuation) {
        super(continuation);
        this.f39590k = defaultPendingRawMessageStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39589j = obj;
        this.f39591l |= Integer.MIN_VALUE;
        return this.f39590k.b(null, null, this);
    }
}
