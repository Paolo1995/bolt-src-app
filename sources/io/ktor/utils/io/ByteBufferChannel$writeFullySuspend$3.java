package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1116, 1118}, m = "writeFullySuspend")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$writeFullySuspend$3 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47227f;

    /* renamed from: g  reason: collision with root package name */
    Object f47228g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47229h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47230i;

    /* renamed from: j  reason: collision with root package name */
    int f47231j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeFullySuspend$3(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$writeFullySuspend$3> continuation) {
        super(continuation);
        this.f47230i = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object S0;
        this.f47229h = obj;
        this.f47231j |= Integer.MIN_VALUE;
        S0 = this.f47230i.S0(null, this);
        return S0;
    }
}
