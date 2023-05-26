package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {483}, m = "readAvailable$ktor_io")
/* loaded from: classes5.dex */
public final class ByteChannelSequentialBase$readAvailable$2 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47293f;

    /* renamed from: g  reason: collision with root package name */
    Object f47294g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47295h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteChannelSequentialBase f47296i;

    /* renamed from: j  reason: collision with root package name */
    int f47297j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readAvailable$2(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$readAvailable$2> continuation) {
        super(continuation);
        this.f47296i = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47295h = obj;
        this.f47297j |= Integer.MIN_VALUE;
        return this.f47296i.Q(null, this);
    }
}
