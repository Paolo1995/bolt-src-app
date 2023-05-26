package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1417}, m = "writeFullySuspend")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$writeFullySuspend$5 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47232f;

    /* renamed from: g  reason: collision with root package name */
    Object f47233g;

    /* renamed from: h  reason: collision with root package name */
    int f47234h;

    /* renamed from: i  reason: collision with root package name */
    int f47235i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f47236j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47237k;

    /* renamed from: l  reason: collision with root package name */
    int f47238l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeFullySuspend$5(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$writeFullySuspend$5> continuation) {
        super(continuation);
        this.f47237k = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object T0;
        this.f47236j = obj;
        this.f47238l |= Integer.MIN_VALUE;
        T0 = this.f47237k.T0(null, 0, 0, this);
        return T0;
    }
}
