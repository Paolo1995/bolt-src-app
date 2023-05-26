package co.touchlab.kermit;

import android.util.Log;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogcatWriter.kt */
/* loaded from: classes.dex */
public final class LogcatWriter extends LogWriter {

    /* compiled from: LogcatWriter.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8825a;

        static {
            int[] iArr = new int[Severity.values().length];
            iArr[Severity.Verbose.ordinal()] = 1;
            iArr[Severity.Debug.ordinal()] = 2;
            iArr[Severity.Info.ordinal()] = 3;
            iArr[Severity.Warn.ordinal()] = 4;
            iArr[Severity.Error.ordinal()] = 5;
            iArr[Severity.Assert.ordinal()] = 6;
            f8825a = iArr;
        }
    }

    private final int c(Severity severity) {
        switch (WhenMappings.f8825a[severity.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // co.touchlab.kermit.LogWriter
    public void b(Severity severity, String message, String tag, Throwable th) {
        String b8;
        Intrinsics.f(severity, "severity");
        Intrinsics.f(message, "message");
        Intrinsics.f(tag, "tag");
        Log.println(c(severity), tag, message);
        if (th != null) {
            int c8 = c(severity);
            b8 = ExceptionsKt__ExceptionsKt.b(th);
            Log.println(c8, tag, b8);
        }
    }
}
