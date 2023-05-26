package eu.bolt.driver.chat.service.log;

import eu.bolt.chat.tools.logger.Logger;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatLogger.kt */
/* loaded from: classes5.dex */
public final class ChatLogger implements Logger {

    /* renamed from: a  reason: collision with root package name */
    public static final ChatLogger f40497a = new ChatLogger();

    private ChatLogger() {
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void a(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        if (str == null) {
            str = "";
        }
        Kalev.e(e8, str);
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void b(String message) {
        Intrinsics.f(message, "message");
        Kalev.h(message);
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void c(Throwable e8) {
        Intrinsics.f(e8, "e");
        Kalev.e(e8, "");
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void d(String message) {
        Intrinsics.f(message, "message");
        Kalev.l(message);
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void f(String message) {
        Intrinsics.f(message, "message");
        Kalev.b(message);
    }

    @Override // eu.bolt.chat.tools.logger.Logger
    public void g(String message) {
        Intrinsics.f(message, "message");
        Kalev.k(message);
    }
}
