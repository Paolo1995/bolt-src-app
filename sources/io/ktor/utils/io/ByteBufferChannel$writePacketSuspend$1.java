package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1737, 1739}, m = "writePacketSuspend")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$writePacketSuspend$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47239f;

    /* renamed from: g  reason: collision with root package name */
    Object f47240g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47241h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47242i;

    /* renamed from: j  reason: collision with root package name */
    int f47243j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writePacketSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$writePacketSuspend$1> continuation) {
        super(continuation);
        this.f47242i = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object V0;
        this.f47241h = obj;
        this.f47243j |= Integer.MIN_VALUE;
        V0 = this.f47242i.V0(null, this);
        return V0;
    }
}
