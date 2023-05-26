package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2048}, m = "readRemainingSuspend")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$readRemainingSuspend$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47203f;

    /* renamed from: g  reason: collision with root package name */
    Object f47204g;

    /* renamed from: h  reason: collision with root package name */
    Object f47205h;

    /* renamed from: i  reason: collision with root package name */
    Object f47206i;

    /* renamed from: j  reason: collision with root package name */
    Object f47207j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f47208k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47209l;

    /* renamed from: m  reason: collision with root package name */
    int f47210m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readRemainingSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readRemainingSuspend$1> continuation) {
        super(continuation);
        this.f47209l = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l02;
        this.f47208k = obj;
        this.f47210m |= Integer.MIN_VALUE;
        l02 = this.f47209l.l0(0L, this);
        return l02;
    }
}
