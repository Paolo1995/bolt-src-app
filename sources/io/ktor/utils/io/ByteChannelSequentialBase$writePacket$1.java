package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {186}, m = "writePacket$suspendImpl")
/* loaded from: classes5.dex */
public final class ByteChannelSequentialBase$writePacket$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47323f;

    /* renamed from: g  reason: collision with root package name */
    Object f47324g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47325h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteChannelSequentialBase f47326i;

    /* renamed from: j  reason: collision with root package name */
    int f47327j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writePacket$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$writePacket$1> continuation) {
        super(continuation);
        this.f47326i = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47325h = obj;
        this.f47327j |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.a0(this.f47326i, null, this);
    }
}
