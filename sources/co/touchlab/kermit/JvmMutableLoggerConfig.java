package co.touchlab.kermit;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JvmMutableLoggerConfig.kt */
/* loaded from: classes.dex */
public final class JvmMutableLoggerConfig implements MutableLoggerConfig {

    /* renamed from: a  reason: collision with root package name */
    private volatile Severity f8821a;

    /* renamed from: b  reason: collision with root package name */
    private volatile List<? extends LogWriter> f8822b;

    public JvmMutableLoggerConfig(List<? extends LogWriter> logWriters) {
        Intrinsics.f(logWriters, "logWriters");
        this.f8821a = LoggerKt.a();
        this.f8822b = logWriters;
    }

    @Override // co.touchlab.kermit.LoggerConfig
    public Severity a() {
        return this.f8821a;
    }

    @Override // co.touchlab.kermit.LoggerConfig
    public List<LogWriter> b() {
        return this.f8822b;
    }
}
