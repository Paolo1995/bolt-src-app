package io.ktor.utils.io.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AwaitingSlot.kt */
@DebugMetadata(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", l = {24}, m = "sleep")
/* loaded from: classes5.dex */
public final class AwaitingSlot$sleep$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47412f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f47413g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ AwaitingSlot f47414h;

    /* renamed from: i  reason: collision with root package name */
    int f47415i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwaitingSlot$sleep$1(AwaitingSlot awaitingSlot, Continuation<? super AwaitingSlot$sleep$1> continuation) {
        super(continuation);
        this.f47414h = awaitingSlot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47413g = obj;
        this.f47415i |= Integer.MIN_VALUE;
        return this.f47414h.d(null, this);
    }
}
