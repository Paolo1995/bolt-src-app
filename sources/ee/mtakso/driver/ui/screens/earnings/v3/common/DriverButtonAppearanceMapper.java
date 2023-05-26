package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.earnings.network.DriverButton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverButtonAppearanceMapper.kt */
/* loaded from: classes3.dex */
public final class DriverButtonAppearanceMapper {

    /* compiled from: DriverButtonAppearanceMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29022a;

        static {
            int[] iArr = new int[DriverButton.Appearance.values().length];
            try {
                iArr[DriverButton.Appearance.ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverButton.Appearance.PRIMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverButton.Appearance.CRITICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverButton.Appearance.SECONDARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DriverButton.Appearance.OFFLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f29022a = iArr;
        }
    }

    public final UiKitRoundButtonType a(DriverButton.Appearance appearance) {
        Intrinsics.f(appearance, "appearance");
        int i8 = WhenMappings.f29022a[appearance.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 != 5) {
                            return UiKitRoundButtonType.f36164n;
                        }
                        return UiKitRoundButtonType.f36167q;
                    }
                    return UiKitRoundButtonType.f36164n;
                }
                return UiKitRoundButtonType.f36163m;
            }
            return UiKitRoundButtonType.f36162l;
        }
        return UiKitRoundButtonType.f36161k;
    }
}
