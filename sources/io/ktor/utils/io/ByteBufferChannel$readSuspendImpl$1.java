package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2191}, m = "readSuspendImpl")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$readSuspendImpl$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47211f;

    /* renamed from: g  reason: collision with root package name */
    int f47212g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47213h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47214i;

    /* renamed from: j  reason: collision with root package name */
    int f47215j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readSuspendImpl$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readSuspendImpl$1> continuation) {
        super(continuation);
        this.f47214i = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object n02;
        this.f47213h = obj;
        this.f47215j |= Integer.MIN_VALUE;
        n02 = this.f47214i.n0(0, this);
        return n02;
    }
}
