package io.ktor.utils.io.internal;

import io.ktor.utils.io.ClosedWriteChannelException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ByteBufferChannelInternals.kt */
/* loaded from: classes5.dex */
public final class ClosedElement {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f47425b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final ClosedElement f47426c = new ClosedElement(null);

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f47427a;

    /* compiled from: ByteBufferChannelInternals.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClosedElement a() {
            return ClosedElement.f47426c;
        }
    }

    public ClosedElement(Throwable th) {
        this.f47427a = th;
    }

    public final Throwable b() {
        return this.f47427a;
    }

    public final Throwable c() {
        Throwable th = this.f47427a;
        if (th == null) {
            return new ClosedWriteChannelException("The channel was closed");
        }
        return th;
    }

    public String toString() {
        return "Closed[" + c() + ']';
    }
}
