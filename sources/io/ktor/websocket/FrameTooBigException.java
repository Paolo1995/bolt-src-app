package io.ktor.websocket;

import io.ktor.util.internal.ExceptionUtilsJvmKt;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: FrameTooBigException.kt */
/* loaded from: classes5.dex */
public final class FrameTooBigException extends Exception implements CopyableThrowable<FrameTooBigException> {

    /* renamed from: f  reason: collision with root package name */
    private final long f47548f;

    public FrameTooBigException(long j8) {
        this.f47548f = j8;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    /* renamed from: b */
    public FrameTooBigException a() {
        FrameTooBigException frameTooBigException = new FrameTooBigException(this.f47548f);
        ExceptionUtilsJvmKt.a(frameTooBigException, this);
        return frameTooBigException;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Frame is too big: " + this.f47548f;
    }
}
