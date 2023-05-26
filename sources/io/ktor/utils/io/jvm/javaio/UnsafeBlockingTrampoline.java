package io.ktor.utils.io.jvm.javaio;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Blocking.kt */
/* loaded from: classes5.dex */
final class UnsafeBlockingTrampoline extends CoroutineDispatcher {

    /* renamed from: h  reason: collision with root package name */
    public static final UnsafeBlockingTrampoline f47508h = new UnsafeBlockingTrampoline();

    private UnsafeBlockingTrampoline() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void G0(CoroutineContext context, Runnable block) {
        Intrinsics.f(context, "context");
        Intrinsics.f(block, "block");
        block.run();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean K0(CoroutineContext context) {
        Intrinsics.f(context, "context");
        return true;
    }
}
