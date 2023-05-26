package co.touchlab.kermit;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KermitConfig.kt */
/* loaded from: classes.dex */
public final class KermitConfigKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f8823a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f8824b = "Kermit";

    public static final String a() {
        return f8824b;
    }

    public static final MutableLoggerConfig b(List<? extends LogWriter> logWriters) {
        Intrinsics.f(logWriters, "logWriters");
        return new JvmMutableLoggerConfig(logWriters);
    }

    public static final void c(String value) {
        Intrinsics.f(value, "value");
        synchronized (f8823a) {
            f8824b = value;
            Unit unit = Unit.f50853a;
        }
    }
}
