package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {423}, m = "readRemainingSuspend")
/* loaded from: classes5.dex */
public final class ByteChannelSequentialBase$readRemainingSuspend$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47305f;

    /* renamed from: g  reason: collision with root package name */
    Object f47306g;

    /* renamed from: h  reason: collision with root package name */
    long f47307h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f47308i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ByteChannelSequentialBase f47309j;

    /* renamed from: k  reason: collision with root package name */
    int f47310k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readRemainingSuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$readRemainingSuspend$1> continuation) {
        super(continuation);
        this.f47309j = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object U;
        this.f47308i = obj;
        this.f47310k |= Integer.MIN_VALUE;
        U = this.f47309j.U(null, 0L, this);
        return U;
    }
}
