package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {605}, m = "awaitSuspend")
/* loaded from: classes5.dex */
public final class ByteChannelSequentialBase$awaitSuspend$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47282f;

    /* renamed from: g  reason: collision with root package name */
    int f47283g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47284h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteChannelSequentialBase f47285i;

    /* renamed from: j  reason: collision with root package name */
    int f47286j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$awaitSuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$awaitSuspend$1> continuation) {
        super(continuation);
        this.f47285i = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47284h = obj;
        this.f47286j |= Integer.MIN_VALUE;
        return this.f47285i.B(0, this);
    }
}
