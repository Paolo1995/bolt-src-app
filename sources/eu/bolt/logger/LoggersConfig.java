package eu.bolt.logger;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggersConfig.kt */
/* loaded from: classes5.dex */
public final class LoggersConfig {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f41684b;

    /* renamed from: a  reason: collision with root package name */
    public static final LoggersConfig f41683a = new LoggersConfig();

    /* renamed from: c  reason: collision with root package name */
    private static LoggerFactory f41685c = new LoggerFactory() { // from class: eu.bolt.logger.LoggersConfig$loggerFactory$1
        @Override // eu.bolt.logger.LoggerFactory
        public Logger a(String tag) {
            Intrinsics.f(tag, "tag");
            return new DefaultLogger(tag);
        }
    };

    private LoggersConfig() {
    }

    public final LoggerFactory a() {
        return f41685c;
    }

    public final boolean b() {
        return f41684b;
    }
}
