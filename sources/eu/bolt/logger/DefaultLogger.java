package eu.bolt.logger;

import eu.bolt.logger.exception.DebugError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultLogger.kt */
/* loaded from: classes5.dex */
public final class DefaultLogger implements Logger {

    /* renamed from: a  reason: collision with root package name */
    private final String f41682a;

    public DefaultLogger(String tag) {
        Intrinsics.f(tag, "tag");
        this.f41682a = tag;
    }

    @Override // eu.bolt.logger.Logger
    public void a(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        System.out.println((Object) (this.f41682a + ' ' + e8 + ' ' + str));
    }

    @Override // eu.bolt.logger.Logger
    public void b(String message) {
        Intrinsics.f(message, "message");
        System.out.println((Object) (this.f41682a + ' ' + message));
    }

    @Override // eu.bolt.logger.Logger
    public void c(Throwable e8) {
        Intrinsics.f(e8, "e");
        System.out.println((Object) (this.f41682a + ' ' + e8));
    }

    @Override // eu.bolt.logger.Logger
    public void d(String message) {
        Intrinsics.f(message, "message");
        System.out.println((Object) (this.f41682a + ' ' + message));
    }

    @Override // eu.bolt.logger.Logger
    public void e(String message) {
        Intrinsics.f(message, "message");
        System.out.println((Object) message);
    }

    @Override // eu.bolt.logger.Logger
    public void f(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        System.out.println((Object) (this.f41682a + ' ' + e8 + ' ' + str));
    }

    @Override // eu.bolt.logger.Logger
    public void g(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        if (!LoggersConfig.f41683a.b()) {
            c(e8);
            return;
        }
        throw new DebugError(str, e8);
    }

    @Override // eu.bolt.logger.Logger
    public void h(Throwable e8) {
        Intrinsics.f(e8, "e");
        if (!LoggersConfig.f41683a.b()) {
            c(e8);
            return;
        }
        throw new DebugError(null, e8, 1, null);
    }

    @Override // eu.bolt.logger.Logger
    public void i(String message) {
        Intrinsics.f(message, "message");
        if (!LoggersConfig.f41683a.b()) {
            e(message);
            return;
        }
        throw new DebugError(message, null, 2, null);
    }
}
