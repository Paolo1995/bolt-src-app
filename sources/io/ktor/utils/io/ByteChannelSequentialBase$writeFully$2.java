package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {204}, m = "writeFully$suspendImpl")
/* loaded from: classes5.dex */
public final class ByteChannelSequentialBase$writeFully$2 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47316f;

    /* renamed from: g  reason: collision with root package name */
    Object f47317g;

    /* renamed from: h  reason: collision with root package name */
    int f47318h;

    /* renamed from: i  reason: collision with root package name */
    int f47319i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f47320j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ ByteChannelSequentialBase f47321k;

    /* renamed from: l  reason: collision with root package name */
    int f47322l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeFully$2(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$writeFully$2> continuation) {
        super(continuation);
        this.f47321k = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47320j = obj;
        this.f47322l |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.Z(this.f47321k, null, 0, 0, this);
    }
}
