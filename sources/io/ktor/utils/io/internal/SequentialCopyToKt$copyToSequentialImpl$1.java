package io.ktor.utils.io.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequentialCopyTo.kt */
@DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", l = {27, 32, 40}, m = "copyToSequentialImpl")
/* loaded from: classes5.dex */
public final class SequentialCopyToKt$copyToSequentialImpl$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47459f;

    /* renamed from: g  reason: collision with root package name */
    Object f47460g;

    /* renamed from: h  reason: collision with root package name */
    long f47461h;

    /* renamed from: i  reason: collision with root package name */
    long f47462i;

    /* renamed from: j  reason: collision with root package name */
    long f47463j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f47464k;

    /* renamed from: l  reason: collision with root package name */
    int f47465l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SequentialCopyToKt$copyToSequentialImpl$1(Continuation<? super SequentialCopyToKt$copyToSequentialImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47464k = obj;
        this.f47465l |= Integer.MIN_VALUE;
        return SequentialCopyToKt.b(null, null, 0L, this);
    }
}
