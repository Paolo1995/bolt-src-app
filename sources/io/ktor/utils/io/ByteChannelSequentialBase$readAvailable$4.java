package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {527}, m = "readAvailable$suspendImpl")
/* loaded from: classes5.dex */
public final class ByteChannelSequentialBase$readAvailable$4 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47298f;

    /* renamed from: g  reason: collision with root package name */
    Object f47299g;

    /* renamed from: h  reason: collision with root package name */
    int f47300h;

    /* renamed from: i  reason: collision with root package name */
    int f47301i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f47302j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ ByteChannelSequentialBase f47303k;

    /* renamed from: l  reason: collision with root package name */
    int f47304l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readAvailable$4(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$readAvailable$4> continuation) {
        super(continuation);
        this.f47303k = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47302j = obj;
        this.f47304l |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.S(this.f47303k, null, 0, 0, this);
    }
}
