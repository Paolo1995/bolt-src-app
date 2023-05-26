package eu.bolt.android.rib;

import eu.bolt.logger.Logger;
import eu.bolt.logger.LoggersConfig;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RibLogger.kt */
/* loaded from: classes5.dex */
public final class RibLogger {

    /* renamed from: a  reason: collision with root package name */
    public static final RibLogger f37068a = new RibLogger();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f37069b = LoggersConfig.f41683a.a().a("RIB");

    private RibLogger() {
    }

    public final void a(String string) {
        Intrinsics.f(string, "string");
        f37069b.b(string);
    }

    public final void b(String message) {
        Intrinsics.f(message, "message");
        f37069b.d(message);
    }
}
