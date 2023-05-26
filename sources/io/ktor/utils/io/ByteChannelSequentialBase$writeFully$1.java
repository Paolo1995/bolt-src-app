package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {193}, m = "writeFully$suspendImpl")
/* loaded from: classes5.dex */
public final class ByteChannelSequentialBase$writeFully$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47311f;

    /* renamed from: g  reason: collision with root package name */
    Object f47312g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47313h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteChannelSequentialBase f47314i;

    /* renamed from: j  reason: collision with root package name */
    int f47315j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeFully$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$writeFully$1> continuation) {
        super(continuation);
        this.f47314i = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47313h = obj;
        this.f47315j |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.Y(this.f47314i, null, this);
    }
}
