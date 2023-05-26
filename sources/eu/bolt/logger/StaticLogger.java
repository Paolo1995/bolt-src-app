package eu.bolt.logger;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticLogger.kt */
/* loaded from: classes5.dex */
public final class StaticLogger implements Logger {

    /* renamed from: a  reason: collision with root package name */
    public static final StaticLogger f41686a = new StaticLogger();

    /* renamed from: b  reason: collision with root package name */
    private static Logger f41687b = new DefaultLogger("StaticLogger");

    private StaticLogger() {
    }

    @Override // eu.bolt.logger.Logger
    public void a(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        f41687b.a(e8, str);
    }

    @Override // eu.bolt.logger.Logger
    public void b(String message) {
        Intrinsics.f(message, "message");
        f41687b.b(message);
    }

    @Override // eu.bolt.logger.Logger
    public void c(Throwable e8) {
        Intrinsics.f(e8, "e");
        f41687b.c(e8);
    }

    @Override // eu.bolt.logger.Logger
    public void d(String message) {
        Intrinsics.f(message, "message");
        f41687b.d(message);
    }

    @Override // eu.bolt.logger.Logger
    public void e(String message) {
        Intrinsics.f(message, "message");
        f41687b.e(message);
    }

    @Override // eu.bolt.logger.Logger
    public void f(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        f41687b.f(e8, str);
    }

    @Override // eu.bolt.logger.Logger
    public void g(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        f41687b.g(e8, str);
    }

    @Override // eu.bolt.logger.Logger
    public void h(Throwable e8) {
        Intrinsics.f(e8, "e");
        f41687b.h(e8);
    }

    @Override // eu.bolt.logger.Logger
    public void i(String message) {
        Intrinsics.f(message, "message");
        f41687b.i(message);
    }
}
