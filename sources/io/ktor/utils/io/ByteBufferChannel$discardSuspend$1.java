package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1697}, m = "discardSuspend")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$discardSuspend$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47185f;

    /* renamed from: g  reason: collision with root package name */
    Object f47186g;

    /* renamed from: h  reason: collision with root package name */
    long f47187h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f47188i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47189j;

    /* renamed from: k  reason: collision with root package name */
    int f47190k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$discardSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$discardSuspend$1> continuation) {
        super(continuation);
        this.f47189j = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object S;
        this.f47188i = obj;
        this.f47190k |= Integer.MIN_VALUE;
        S = this.f47189j.S(0L, 0L, this);
        return S;
    }
}
