package co.touchlab.kermit;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonWriter.kt */
/* loaded from: classes.dex */
public class CommonWriter extends LogWriter {
    @Override // co.touchlab.kermit.LogWriter
    public void b(Severity severity, String message, String tag, Throwable th) {
        Intrinsics.f(severity, "severity");
        Intrinsics.f(message, "message");
        Intrinsics.f(tag, "tag");
        System.out.println((Object) c(severity, message, tag, th));
        if (th != null) {
            th.printStackTrace();
        }
    }

    public String c(Severity severity, String message, String tag, Throwable th) {
        Intrinsics.f(severity, "severity");
        Intrinsics.f(message, "message");
        Intrinsics.f(tag, "tag");
        return severity + ": (" + tag + ") " + message;
    }
}
