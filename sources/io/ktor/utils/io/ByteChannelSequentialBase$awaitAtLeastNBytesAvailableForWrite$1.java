package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {81}, m = "awaitAtLeastNBytesAvailableForWrite$ktor_io")
/* loaded from: classes5.dex */
public final class ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47275f;

    /* renamed from: g  reason: collision with root package name */
    int f47276g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47277h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteChannelSequentialBase f47278i;

    /* renamed from: j  reason: collision with root package name */
    int f47279j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1> continuation) {
        super(continuation);
        this.f47278i = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47277h = obj;
        this.f47279j |= Integer.MIN_VALUE;
        return this.f47278i.z(0, this);
    }
}
