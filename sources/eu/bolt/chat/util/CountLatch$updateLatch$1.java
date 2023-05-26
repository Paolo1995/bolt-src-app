package eu.bolt.chat.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CountLatch.kt */
@DebugMetadata(c = "eu.bolt.chat.util.CountLatch", f = "CountLatch.kt", l = {61}, m = "updateLatch")
/* loaded from: classes5.dex */
public final class CountLatch$updateLatch$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39695f;

    /* renamed from: g  reason: collision with root package name */
    Object f39696g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f39697h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ CountLatch f39698i;

    /* renamed from: j  reason: collision with root package name */
    int f39699j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountLatch$updateLatch$1(CountLatch countLatch, Continuation<? super CountLatch$updateLatch$1> continuation) {
        super(continuation);
        this.f39698i = countLatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f8;
        this.f39697h = obj;
        this.f39699j |= Integer.MIN_VALUE;
        f8 = this.f39698i.f(null, this);
        return f8;
    }
}
