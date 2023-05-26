package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {738, 742}, m = "readAvailableSuspend")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$readAvailableSuspend$3 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47198f;

    /* renamed from: g  reason: collision with root package name */
    Object f47199g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47200h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47201i;

    /* renamed from: j  reason: collision with root package name */
    int f47202j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readAvailableSuspend$3(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readAvailableSuspend$3> continuation) {
        super(continuation);
        this.f47201i = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object i02;
        this.f47200h = obj;
        this.f47202j |= Integer.MIN_VALUE;
        i02 = this.f47201i.i0(null, this);
        return i02;
    }
}
