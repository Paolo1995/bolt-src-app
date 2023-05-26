package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PendingRawMessageStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.DefaultPendingRawMessageStorage", f = "PendingRawMessageStorage.kt", l = {105}, m = "updateMessage")
/* loaded from: classes5.dex */
public final class DefaultPendingRawMessageStorage$updateMessage$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39593f;

    /* renamed from: g  reason: collision with root package name */
    Object f39594g;

    /* renamed from: h  reason: collision with root package name */
    Object f39595h;

    /* renamed from: i  reason: collision with root package name */
    Object f39596i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f39597j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ DefaultPendingRawMessageStorage f39598k;

    /* renamed from: l  reason: collision with root package name */
    int f39599l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultPendingRawMessageStorage$updateMessage$1(DefaultPendingRawMessageStorage defaultPendingRawMessageStorage, Continuation<? super DefaultPendingRawMessageStorage$updateMessage$1> continuation) {
        super(continuation);
        this.f39598k = defaultPendingRawMessageStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39597j = obj;
        this.f39599l |= Integer.MIN_VALUE;
        return this.f39598k.e(null, null, this);
    }
}
