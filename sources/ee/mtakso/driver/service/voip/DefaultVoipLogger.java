package ee.mtakso.driver.service.voip;

import ee.mtakso.voip_client.VoipLogger;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.LogEntry;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: DefaultVoipLogger.kt */
/* loaded from: classes3.dex */
public final class DefaultVoipLogger implements VoipLogger {

    /* renamed from: a  reason: collision with root package name */
    private final String f26099a = "VoipCall";

    @Override // ee.mtakso.voip_client.VoipLogger
    public void a(Throwable t7, String message, Object... args) {
        Intrinsics.f(t7, "t");
        Intrinsics.f(message, "message");
        Intrinsics.f(args, "args");
        LogEntry o8 = Kalev.j(this.f26099a).o(t7);
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format = String.format(message, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.e(format, "format(this, *args)");
        o8.b(format);
    }

    @Override // ee.mtakso.voip_client.VoipLogger
    public String b(String str, String message) {
        Intrinsics.f(message, "message");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("%s:%s", Arrays.copyOf(new Object[]{str, message}, 2));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    @Override // ee.mtakso.voip_client.VoipLogger
    public void c(String message, Object... args) {
        Intrinsics.f(message, "message");
        Intrinsics.f(args, "args");
        LogEntry j8 = Kalev.j(this.f26099a);
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format = String.format(message, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.e(format, "format(this, *args)");
        j8.i(format);
    }

    @Override // ee.mtakso.voip_client.VoipLogger
    public void d(String message, Object... args) {
        Intrinsics.f(message, "message");
        Intrinsics.f(args, "args");
        LogEntry j8 = Kalev.j(this.f26099a);
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format = String.format(message, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.e(format, "format(this, *args)");
        j8.b(format);
    }
}
