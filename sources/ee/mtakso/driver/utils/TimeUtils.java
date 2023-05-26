package ee.mtakso.driver.utils;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: TimeUtils.kt */
/* loaded from: classes5.dex */
public final class TimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeUtils f36328a = new TimeUtils();

    private TimeUtils() {
    }

    public static final String a(long j8) {
        int i8 = (int) (j8 / 3600);
        long j9 = 60;
        int i9 = (int) ((j8 / j9) % j9);
        int i10 = (int) (j8 % j9);
        StringBuilder sb = new StringBuilder();
        if (i8 != 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            String format = String.format("%02d:", Arrays.copyOf(new Object[]{Integer.valueOf(i8)}, 1));
            Intrinsics.e(format, "format(format, *args)");
            sb.append(format);
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f51021a;
        String format2 = String.format("%02d:", Arrays.copyOf(new Object[]{Integer.valueOf(i9)}, 1));
        Intrinsics.e(format2, "format(format, *args)");
        sb.append(format2);
        String format3 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
        Intrinsics.e(format3, "format(format, *args)");
        sb.append(format3);
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "builder.toString()");
        return sb2;
    }

    public final String b(Long l8) {
        long j8;
        if (l8 != null) {
            j8 = l8.longValue();
        } else {
            j8 = 0;
        }
        long max = Math.max(j8, 0L);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        long j9 = 60;
        String format = String.format("%1$02d:%2$02d", Arrays.copyOf(new Object[]{Long.valueOf(max / j9), Long.valueOf(max % j9)}, 2));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }
}
