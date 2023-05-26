package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {722, 726}, m = "readAvailableSuspend")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$readAvailableSuspend$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47191f;

    /* renamed from: g  reason: collision with root package name */
    Object f47192g;

    /* renamed from: h  reason: collision with root package name */
    int f47193h;

    /* renamed from: i  reason: collision with root package name */
    int f47194i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f47195j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47196k;

    /* renamed from: l  reason: collision with root package name */
    int f47197l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readAvailableSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readAvailableSuspend$1> continuation) {
        super(continuation);
        this.f47196k = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object j02;
        this.f47195j = obj;
        this.f47197l |= Integer.MIN_VALUE;
        j02 = this.f47196k.j0(null, 0, 0, this);
        return j02;
    }
}
