package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteReadChannelJVM.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", l = {302, 305}, m = "copyToImpl")
/* loaded from: classes5.dex */
public final class ByteReadChannelJVMKt$copyToImpl$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47332f;

    /* renamed from: g  reason: collision with root package name */
    Object f47333g;

    /* renamed from: h  reason: collision with root package name */
    Object f47334h;

    /* renamed from: i  reason: collision with root package name */
    long f47335i;

    /* renamed from: j  reason: collision with root package name */
    long f47336j;

    /* renamed from: k  reason: collision with root package name */
    int f47337k;

    /* renamed from: l  reason: collision with root package name */
    int f47338l;

    /* renamed from: m  reason: collision with root package name */
    /* synthetic */ Object f47339m;

    /* renamed from: n  reason: collision with root package name */
    int f47340n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteReadChannelJVMKt$copyToImpl$1(Continuation<? super ByteReadChannelJVMKt$copyToImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c8;
        this.f47339m = obj;
        this.f47340n |= Integer.MIN_VALUE;
        c8 = ByteReadChannelJVMKt.c(null, null, 0L, this);
        return c8;
    }
}
