package ee.mtakso.driver.ui.interactor.warnings;

import ee.mtakso.driver.service.connectivity.ConnectionMessage;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WarningMessage.kt */
/* loaded from: classes3.dex */
public final class WarningMessageKt {

    /* compiled from: WarningMessage.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26956a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f26957b;

        static {
            int[] iArr = new int[GeoLocationManagerState.values().length];
            try {
                iArr[GeoLocationManagerState.OUTDATED_LOCATION_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GeoLocationManagerState.LOCATION_ACCESS_ISSUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f26956a = iArr;
            int[] iArr2 = new int[NetworkConnectionStatus.values().length];
            try {
                iArr2[NetworkConnectionStatus.INTERNET_NOT_ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[NetworkConnectionStatus.CONNECTION_ISSUES.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f26957b = iArr2;
        }
    }

    public static final int a(WarningMessage warningMessage, WarningMessage message) {
        Intrinsics.f(warningMessage, "<this>");
        Intrinsics.f(message, "message");
        return Intrinsics.h(c(warningMessage), c(message));
    }

    private static final int b(WarningMessage.Connection connection) {
        ConnectionMessage a8 = connection.a();
        if (!(a8 instanceof ConnectionMessage.Reconnected)) {
            if (a8 instanceof ConnectionMessage.Status) {
                int i8 = WhenMappings.f26957b[((ConnectionMessage.Status) connection.a()).a().ordinal()];
                if (i8 == 1 || i8 == 2) {
                    return 2;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return 0;
    }

    public static final int c(WarningMessage warningMessage) {
        Intrinsics.f(warningMessage, "<this>");
        if (warningMessage instanceof WarningMessage.Empty) {
            return 0;
        }
        if (warningMessage instanceof WarningMessage.Connection) {
            return b((WarningMessage.Connection) warningMessage);
        }
        if (warningMessage instanceof WarningMessage.Location) {
            return d((WarningMessage.Location) warningMessage);
        }
        if (warningMessage instanceof WarningMessage.Polling) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final int d(WarningMessage.Location location) {
        int i8 = WhenMappings.f26956a[location.a().ordinal()];
        if (i8 == 1 || i8 == 2) {
            return 2;
        }
        return 0;
    }
}
