package co.touchlab.kermit;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Logger.kt */
/* loaded from: classes.dex */
public class Logger {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f8826c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final LoggerConfig f8827a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8828b;

    /* compiled from: Logger.kt */
    /* loaded from: classes.dex */
    public static final class Companion extends Logger {
        private Companion() {
            super(LoggerGlobal.f8829a.a(), null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // co.touchlab.kermit.Logger
        public String d() {
            return KermitConfigKt.a();
        }

        public final void j(String tag) {
            Intrinsics.f(tag, "tag");
            KermitConfigKt.c(tag);
        }
    }

    public Logger(LoggerConfig config, String tag) {
        Intrinsics.f(config, "config");
        Intrinsics.f(tag, "tag");
        this.f8827a = config;
        this.f8828b = tag;
    }

    public final void a(String message) {
        Intrinsics.f(message, "message");
        Severity a8 = this.f8827a.a();
        Severity severity = Severity.Debug;
        if (a8.compareTo(severity) <= 0) {
            f(severity, d(), null, message);
        }
    }

    public final void b(String message) {
        Intrinsics.f(message, "message");
        Severity a8 = this.f8827a.a();
        Severity severity = Severity.Error;
        if (a8.compareTo(severity) <= 0) {
            f(severity, d(), null, message);
        }
    }

    public final LoggerConfig c() {
        return this.f8827a;
    }

    public String d() {
        return this.f8828b;
    }

    public final void e(String message) {
        Intrinsics.f(message, "message");
        Severity a8 = this.f8827a.a();
        Severity severity = Severity.Info;
        if (a8.compareTo(severity) <= 0) {
            f(severity, d(), null, message);
        }
    }

    public final void f(Severity severity, String tag, Throwable th, String message) {
        Intrinsics.f(severity, "severity");
        Intrinsics.f(tag, "tag");
        Intrinsics.f(message, "message");
        for (LogWriter logWriter : this.f8827a.b()) {
            if (logWriter.a(severity)) {
                logWriter.b(severity, message, tag, th);
            }
        }
    }

    public final void g(String message) {
        Intrinsics.f(message, "message");
        Severity a8 = this.f8827a.a();
        Severity severity = Severity.Verbose;
        if (a8.compareTo(severity) <= 0) {
            f(severity, d(), null, message);
        }
    }

    public final void h(String message) {
        Intrinsics.f(message, "message");
        Severity a8 = this.f8827a.a();
        Severity severity = Severity.Warn;
        if (a8.compareTo(severity) <= 0) {
            f(severity, d(), null, message);
        }
    }

    public final Logger i(String tag) {
        Intrinsics.f(tag, "tag");
        return new Logger(this.f8827a, tag);
    }

    public /* synthetic */ Logger(LoggerConfig loggerConfig, String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(loggerConfig, (i8 & 2) != 0 ? "Kermit" : str);
    }
}
