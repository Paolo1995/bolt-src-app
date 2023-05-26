package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PendingRawMessageStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.DefaultPendingRawMessageStorage", f = "PendingRawMessageStorage.kt", l = {105}, m = "getMessages")
/* loaded from: classes5.dex */
public final class DefaultPendingRawMessageStorage$getMessages$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39572f;

    /* renamed from: g  reason: collision with root package name */
    Object f39573g;

    /* renamed from: h  reason: collision with root package name */
    Object f39574h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f39575i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ DefaultPendingRawMessageStorage f39576j;

    /* renamed from: k  reason: collision with root package name */
    int f39577k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultPendingRawMessageStorage$getMessages$1(DefaultPendingRawMessageStorage defaultPendingRawMessageStorage, Continuation<? super DefaultPendingRawMessageStorage$getMessages$1> continuation) {
        super(continuation);
        this.f39576j = defaultPendingRawMessageStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39575i = obj;
        this.f39577k |= Integer.MIN_VALUE;
        return this.f39576j.c(null, this);
    }
}
