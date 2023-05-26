package ee.mtakso.driver.utils;

import android.os.Environment;
import android.os.StatFs;
import j$.util.Spliterator;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorageUtils.kt */
/* loaded from: classes5.dex */
public final class StorageUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final StorageUtils f36324a = new StorageUtils();

    private StorageUtils() {
    }

    private final String b(double d8) {
        return String.valueOf(d8 / 1048576);
    }

    public final boolean a() {
        if (Double.parseDouble(c()) > 150.0d) {
            return true;
        }
        return false;
    }

    public final String c() {
        File dataDirectory = Environment.getDataDirectory();
        Intrinsics.e(dataDirectory, "getDataDirectory()");
        StatFs statFs = new StatFs(dataDirectory.getPath());
        return b(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
    }

    public final String d(long j8, String stringKB, String stringMB, String stringGB) {
        Intrinsics.f(stringKB, "stringKB");
        Intrinsics.f(stringMB, "stringMB");
        Intrinsics.f(stringGB, "stringGB");
        double d8 = j8 / 1048576.0d;
        boolean z7 = true;
        double doubleValue = new BigDecimal(String.valueOf(d8)).setScale(1, RoundingMode.HALF_UP).doubleValue();
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        if (d8 < 1.0d) {
            String valueOf = String.valueOf((int) (j8 / ((long) Spliterator.IMMUTABLE)));
            return valueOf + " " + stringKB;
        }
        float f8 = (float) d8;
        if ((1.0f > f8 || f8 > 999.0f) ? false : false) {
            String format = decimalFormat.format(doubleValue);
            return format + " " + stringMB;
        }
        String format2 = decimalFormat.format(Math.ceil(d8 / ((double) Spliterator.IMMUTABLE)));
        return format2 + " " + stringGB;
    }
}
