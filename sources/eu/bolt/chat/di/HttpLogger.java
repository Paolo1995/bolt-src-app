package eu.bolt.chat.di;

import io.ktor.client.plugins.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpModule.kt */
/* loaded from: classes5.dex */
final class HttpLogger implements Logger {

    /* renamed from: b  reason: collision with root package name */
    private final co.touchlab.kermit.Logger f39044b;

    public HttpLogger(co.touchlab.kermit.Logger delegate) {
        Intrinsics.f(delegate, "delegate");
        this.f39044b = delegate;
    }

    @Override // io.ktor.client.plugins.logging.Logger
    public void log(String message) {
        Intrinsics.f(message, "message");
        this.f39044b.g(message);
    }
}
