package io.ktor.utils.io.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AwaitingSlot.kt */
@DebugMetadata(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", l = {57}, m = "trySuspend")
/* loaded from: classes5.dex */
public final class AwaitingSlot$trySuspend$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    int f47416f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f47417g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ AwaitingSlot f47418h;

    /* renamed from: i  reason: collision with root package name */
    int f47419i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwaitingSlot$trySuspend$1(AwaitingSlot awaitingSlot, Continuation<? super AwaitingSlot$trySuspend$1> continuation) {
        super(continuation);
        this.f47418h = awaitingSlot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object e8;
        this.f47417g = obj;
        this.f47419i |= Integer.MIN_VALUE;
        e8 = this.f47418h.e(null, this);
        return e8;
    }
}
