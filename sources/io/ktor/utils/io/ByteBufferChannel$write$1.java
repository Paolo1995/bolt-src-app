package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1502}, m = "write$suspendImpl")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$write$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47221f;

    /* renamed from: g  reason: collision with root package name */
    Object f47222g;

    /* renamed from: h  reason: collision with root package name */
    int f47223h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f47224i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47225j;

    /* renamed from: k  reason: collision with root package name */
    int f47226k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$write$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$write$1> continuation) {
        super(continuation);
        this.f47225j = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47224i = obj;
        this.f47226k |= Integer.MIN_VALUE;
        return ByteBufferChannel.K0(this.f47225j, 0, null, this);
    }
}
