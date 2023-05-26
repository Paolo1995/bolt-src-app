package io.ktor.utils.io.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequentialCopyTo.kt */
@DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", l = {60, 66}, m = "copyToTail")
/* loaded from: classes5.dex */
public final class SequentialCopyToKt$copyToTail$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47466f;

    /* renamed from: g  reason: collision with root package name */
    Object f47467g;

    /* renamed from: h  reason: collision with root package name */
    int f47468h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f47469i;

    /* renamed from: j  reason: collision with root package name */
    int f47470j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SequentialCopyToKt$copyToTail$1(Continuation<? super SequentialCopyToKt$copyToTail$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c8;
        this.f47469i = obj;
        this.f47470j |= Integer.MIN_VALUE;
        c8 = SequentialCopyToKt.c(null, null, 0L, this);
        return c8;
    }
}
