package eu.bolt.chat.tools.logger;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultLogger.kt */
/* loaded from: classes5.dex */
public final class DefaultLogger implements Logger {
    @Override // eu.bolt.chat.tools.logger.Logger
    public void a(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        System.out.println((Object) (e8 + ' ' + str));
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void b(String message) {
        Intrinsics.f(message, "message");
        System.out.println((Object) message);
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void c(Throwable e8) {
        Intrinsics.f(e8, "e");
        System.out.println(e8);
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void d(String message) {
        Intrinsics.f(message, "message");
        System.out.println((Object) message);
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void f(String message) {
        Intrinsics.f(message, "message");
        System.out.println((Object) message);
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void g(String message) {
        Intrinsics.f(message, "message");
        System.out.println((Object) message);
    }
}
