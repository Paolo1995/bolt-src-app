package ee.mtakso.driver.ui.screens.vehicle;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.vehicle.CarApplicationState;
import ee.mtakso.driver.uikit.utils.Color;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarApplicationStateExt.kt */
/* loaded from: classes5.dex */
public final class CarApplicationStateExtKt {

    /* compiled from: CarApplicationStateExt.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33506a;

        static {
            int[] iArr = new int[CarApplicationState.values().length];
            try {
                iArr[CarApplicationState.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CarApplicationState.RESUBMITTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CarApplicationState.SUBMITTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CarApplicationState.ONBOARDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CarApplicationState.NEEDS_RESUBMISSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CarApplicationState.DECLINED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f33506a = iArr;
        }
    }

    public static final Color a(CarApplicationState carApplicationState) {
        Intrinsics.f(carApplicationState, "<this>");
        switch (WhenMappings.f33506a[carApplicationState.ordinal()]) {
            case 1:
                return new Color.Attr(R.attr.labelBackgroundGraySmall);
            case 2:
            case 3:
            case 4:
                return new Color.Attr(R.attr.colorBgActionPrimary);
            case 5:
            case 6:
                return new Color.Attr(R.attr.colorBgDangerSecondary);
            default:
                String str = "Unsupported value " + carApplicationState;
                Kalev.m(new IllegalArgumentException(str), str);
                return null;
        }
    }

    public static final int b(CarApplicationState carApplicationState) {
        Intrinsics.f(carApplicationState, "<this>");
        switch (WhenMappings.f33506a[carApplicationState.ordinal()]) {
            case 1:
                return R.string.car_application_chip_draft;
            case 2:
            case 3:
            case 4:
                return R.string.car_application_chip_in_review;
            case 5:
                return R.string.car_application_chip_incomplete;
            case 6:
                return R.string.car_application_chip_declined;
            default:
                String str = "Unsupported value " + carApplicationState;
                Kalev.m(new IllegalArgumentException(str), str);
                return 0;
        }
    }

    public static final Color c(CarApplicationState carApplicationState) {
        Intrinsics.f(carApplicationState, "<this>");
        switch (WhenMappings.f33506a[carApplicationState.ordinal()]) {
            case 1:
                return new Color.Attr(R.attr.labelContentGraySmall);
            case 2:
            case 3:
            case 4:
                return new Color.Attr(R.attr.colorContentKeyLight);
            case 5:
            case 6:
                return new Color.Attr(R.attr.colorContentDangerPrimary);
            default:
                String str = "Unsupported value " + carApplicationState;
                Kalev.m(new IllegalArgumentException(str), str);
                return null;
        }
    }
}
