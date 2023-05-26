package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.network.client.order.ScheduledRideDetailsComponent;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderButtonAppearanceMapper.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderButtonAppearanceMapper {

    /* compiled from: ScheduledOrderButtonAppearanceMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31652a;

        static {
            int[] iArr = new int[ScheduledRideDetailsComponent.ButtonAppearance.values().length];
            try {
                iArr[ScheduledRideDetailsComponent.ButtonAppearance.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScheduledRideDetailsComponent.ButtonAppearance.CRITICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScheduledRideDetailsComponent.ButtonAppearance.ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f31652a = iArr;
        }
    }

    public final UiKitRoundButtonType a(ScheduledRideDetailsComponent.ButtonAppearance appearance) {
        Intrinsics.f(appearance, "appearance");
        int i8 = WhenMappings.f31652a[appearance.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return UiKitRoundButtonType.f36161k;
                }
                return UiKitRoundButtonType.f36161k;
            }
            return UiKitRoundButtonType.f36163m;
        }
        return UiKitRoundButtonType.f36162l;
    }
}
