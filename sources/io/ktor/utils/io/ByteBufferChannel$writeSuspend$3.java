package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2363}, m = "writeSuspend")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$writeSuspend$3 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47251f;

    /* renamed from: g  reason: collision with root package name */
    int f47252g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47253h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47254i;

    /* renamed from: j  reason: collision with root package name */
    int f47255j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeSuspend$3(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$writeSuspend$3> continuation) {
        super(continuation);
        this.f47254i = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object W0;
        this.f47253h = obj;
        this.f47255j |= Integer.MIN_VALUE;
        W0 = this.f47254i.W0(0, this);
        return W0;
    }
}
