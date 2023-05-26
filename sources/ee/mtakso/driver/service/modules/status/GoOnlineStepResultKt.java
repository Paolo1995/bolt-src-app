package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.client.driver.MightBeBlockedType;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.service.modules.status.GoOnlineIssue;
import ee.mtakso.driver.service.modules.status.GoOnlineStepResult;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoOnlineStepResult.kt */
/* loaded from: classes3.dex */
public final class GoOnlineStepResultKt {

    /* compiled from: GoOnlineStepResult.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25283a;

        static {
            int[] iArr = new int[GeoLocationManagerState.values().length];
            try {
                iArr[GeoLocationManagerState.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GeoLocationManagerState.OUTDATED_LOCATION_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f25283a = iArr;
        }
    }

    public static final GoOnlineIssue a(GoOnlineStepResult goOnlineStepResult) {
        Intrinsics.f(goOnlineStepResult, "<this>");
        if (goOnlineStepResult instanceof GoOnlineStepResult.LocationCheck) {
            if (b((GoOnlineStepResult.LocationCheck) goOnlineStepResult)) {
                return null;
            }
            return GoOnlineIssue.LocationRequired.f25266a;
        } else if (!(goOnlineStepResult instanceof GoOnlineStepResult.StartWorking)) {
            return null;
        } else {
            GoOnlineStepResult.StartWorking startWorking = (GoOnlineStepResult.StartWorking) goOnlineStepResult;
            if (startWorking.a().f() == MightBeBlockedType.PRICING_REQUIRED && startWorking.a().e() != null) {
                return new GoOnlineIssue.PricingNotChosen(startWorking.a().e());
            }
            if (startWorking.a().f() != MightBeBlockedType.PRICING_CONFIRMATION_REQUIRED || startWorking.a().d() == null || startWorking.a().b() == null) {
                return null;
            }
            return new GoOnlineIssue.PricingConfirmation(startWorking.a().b(), startWorking.a().d());
        }
    }

    public static final boolean b(GoOnlineStepResult.LocationCheck locationCheck) {
        Intrinsics.f(locationCheck, "<this>");
        int i8 = WhenMappings.f25283a[locationCheck.a().ordinal()];
        if (i8 == 1 || i8 == 2) {
            return true;
        }
        return false;
    }
}
