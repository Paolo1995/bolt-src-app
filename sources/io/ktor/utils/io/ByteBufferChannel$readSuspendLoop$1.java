package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2144}, m = "readSuspendLoop")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$readSuspendLoop$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47216f;

    /* renamed from: g  reason: collision with root package name */
    int f47217g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47218h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47219i;

    /* renamed from: j  reason: collision with root package name */
    int f47220j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readSuspendLoop$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readSuspendLoop$1> continuation) {
        super(continuation);
        this.f47219i = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object o02;
        this.f47218h = obj;
        this.f47220j |= Integer.MIN_VALUE;
        o02 = this.f47219i.o0(0, this);
        return o02;
    }
}
