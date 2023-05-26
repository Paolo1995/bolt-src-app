package io.ktor.client.engine;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HttpClientEngineBase.kt */
/* loaded from: classes5.dex */
public final class ClientEngineClosedException extends IllegalStateException {

    /* renamed from: f  reason: collision with root package name */
    private final Throwable f46108f;

    public ClientEngineClosedException() {
        this(null, 1, null);
    }

    public /* synthetic */ ClientEngineClosedException(Throwable th, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : th);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f46108f;
    }

    public ClientEngineClosedException(Throwable th) {
        super("Client already closed");
        this.f46108f = th;
    }
}
