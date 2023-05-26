package co.touchlab.kermit;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;

/* compiled from: Logger.kt */
/* loaded from: classes.dex */
public final class LoggerGlobal {

    /* renamed from: a  reason: collision with root package name */
    public static final LoggerGlobal f8829a = new LoggerGlobal();

    /* renamed from: b  reason: collision with root package name */
    private static final MutableLoggerConfig f8830b;

    static {
        List e8;
        e8 = CollectionsKt__CollectionsJVMKt.e(PlatformLogWriterKt.a());
        f8830b = KermitConfigKt.b(e8);
    }

    private LoggerGlobal() {
    }

    public final MutableLoggerConfig a() {
        return f8830b;
    }
}
