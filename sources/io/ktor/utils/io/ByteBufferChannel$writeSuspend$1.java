package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1434, 1436}, m = "writeSuspend")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$writeSuspend$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47244f;

    /* renamed from: g  reason: collision with root package name */
    Object f47245g;

    /* renamed from: h  reason: collision with root package name */
    int f47246h;

    /* renamed from: i  reason: collision with root package name */
    int f47247i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f47248j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47249k;

    /* renamed from: l  reason: collision with root package name */
    int f47250l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$writeSuspend$1> continuation) {
        super(continuation);
        this.f47249k = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object X0;
        this.f47248j = obj;
        this.f47250l |= Integer.MIN_VALUE;
        X0 = this.f47249k.X0(null, 0, 0, this);
        return X0;
    }
}
