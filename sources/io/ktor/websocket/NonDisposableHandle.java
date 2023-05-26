package io.ktor.websocket;

import kotlinx.coroutines.DisposableHandle;

/* compiled from: FrameCommon.kt */
/* loaded from: classes5.dex */
public final class NonDisposableHandle implements DisposableHandle {

    /* renamed from: f  reason: collision with root package name */
    public static final NonDisposableHandle f47560f = new NonDisposableHandle();

    private NonDisposableHandle() {
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
