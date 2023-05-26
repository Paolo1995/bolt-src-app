package ee.mtakso.driver.network.client.driver;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverStatus.kt */
/* loaded from: classes3.dex */
public final class DriverStatusKt {

    /* compiled from: DriverStatus.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21958a;

        static {
            int[] iArr = new int[DriverStatus.values().length];
            try {
                iArr[DriverStatus.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverStatus.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverStatus.UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverStatus.BUSY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DriverStatus.WAITING_ORDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DriverStatus.ACTIVE_ORDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f21958a = iArr;
        }
    }

    public static final boolean a(DriverStatus driverStatus) {
        Intrinsics.f(driverStatus, "<this>");
        int i8 = WhenMappings.f21958a[driverStatus.ordinal()];
        if (i8 == 1 || i8 == 2 || i8 == 3 || i8 == 4) {
            return true;
        }
        return false;
    }

    public static final boolean b(DriverStatus driverStatus) {
        Intrinsics.f(driverStatus, "<this>");
        int i8 = WhenMappings.f21958a[driverStatus.ordinal()];
        if (i8 == 5 || i8 == 6) {
            return true;
        }
        return false;
    }
}
