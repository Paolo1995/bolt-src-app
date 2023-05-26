package io.ktor.client.plugins.logging;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ObservingUtils.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.ObservingUtilsKt", f = "ObservingUtils.kt", l = {14}, m = "observe")
/* loaded from: classes5.dex */
public final class ObservingUtilsKt$observe$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46573f;

    /* renamed from: g  reason: collision with root package name */
    Object f46574g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46575h;

    /* renamed from: i  reason: collision with root package name */
    int f46576i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObservingUtilsKt$observe$1(Continuation<? super ObservingUtilsKt$observe$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46575h = obj;
        this.f46576i |= Integer.MIN_VALUE;
        return ObservingUtilsKt.a(null, null, this);
    }
}
