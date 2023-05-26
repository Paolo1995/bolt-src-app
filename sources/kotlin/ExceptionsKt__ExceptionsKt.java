package kotlin;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
/* loaded from: classes5.dex */
public class ExceptionsKt__ExceptionsKt {
    public static void a(Throwable th, Throwable exception) {
        Intrinsics.f(th, "<this>");
        Intrinsics.f(exception, "exception");
        if (th != exception) {
            PlatformImplementationsKt.f50939a.a(th, exception);
        }
    }

    public static String b(Throwable th) {
        Intrinsics.f(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.e(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
