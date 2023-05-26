package io.ktor.client.engine.okhttp;

import io.ktor.websocket.Frame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: OkHttpWebsocketSession.kt */
/* loaded from: classes5.dex */
public final class UnsupportedFrameTypeException extends IllegalArgumentException implements CopyableThrowable<UnsupportedFrameTypeException> {

    /* renamed from: f  reason: collision with root package name */
    private final Frame f46227f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedFrameTypeException(Frame frame) {
        super("Unsupported frame type: " + frame);
        Intrinsics.f(frame, "frame");
        this.f46227f = frame;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    /* renamed from: b */
    public UnsupportedFrameTypeException a() {
        UnsupportedFrameTypeException unsupportedFrameTypeException = new UnsupportedFrameTypeException(this.f46227f);
        unsupportedFrameTypeException.initCause(this);
        return unsupportedFrameTypeException;
    }
}
