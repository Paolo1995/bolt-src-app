package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PendingRawMessageStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.DefaultPendingRawMessageStorage", f = "PendingRawMessageStorage.kt", l = {105}, m = "removeAllMessagesFor")
/* loaded from: classes5.dex */
public final class DefaultPendingRawMessageStorage$removeAllMessagesFor$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39579f;

    /* renamed from: g  reason: collision with root package name */
    Object f39580g;

    /* renamed from: h  reason: collision with root package name */
    Object f39581h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f39582i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ DefaultPendingRawMessageStorage f39583j;

    /* renamed from: k  reason: collision with root package name */
    int f39584k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultPendingRawMessageStorage$removeAllMessagesFor$1(DefaultPendingRawMessageStorage defaultPendingRawMessageStorage, Continuation<? super DefaultPendingRawMessageStorage$removeAllMessagesFor$1> continuation) {
        super(continuation);
        this.f39583j = defaultPendingRawMessageStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39582i = obj;
        this.f39584k |= Integer.MIN_VALUE;
        return this.f39583j.a(null, this);
    }
}
