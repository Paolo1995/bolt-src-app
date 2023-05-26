package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {667}, m = "discardSuspend")
/* loaded from: classes5.dex */
public final class ByteChannelSequentialBase$discardSuspend$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47287f;

    /* renamed from: g  reason: collision with root package name */
    long f47288g;

    /* renamed from: h  reason: collision with root package name */
    long f47289h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f47290i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ByteChannelSequentialBase f47291j;

    /* renamed from: k  reason: collision with root package name */
    int f47292k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$discardSuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$discardSuspend$1> continuation) {
        super(continuation);
        this.f47291j = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object E;
        this.f47290i = obj;
        this.f47292k |= Integer.MIN_VALUE;
        E = this.f47291j.E(0L, 0L, this);
        return E;
    }
}
