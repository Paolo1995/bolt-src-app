package co.touchlab.kermit;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogWriter.kt */
/* loaded from: classes.dex */
public abstract class LogWriter {
    public boolean a(Severity severity) {
        Intrinsics.f(severity, "severity");
        return true;
    }

    public abstract void b(Severity severity, String str, String str2, Throwable th);
}
