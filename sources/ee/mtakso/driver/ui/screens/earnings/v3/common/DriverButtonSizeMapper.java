package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import eu.bolt.driver.earnings.network.DriverButton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverButtonSizeMapper.kt */
/* loaded from: classes3.dex */
public final class DriverButtonSizeMapper {

    /* compiled from: DriverButtonSizeMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29028a;

        static {
            int[] iArr = new int[DriverButton.Size.values().length];
            try {
                iArr[DriverButton.Size.LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverButton.Size.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f29028a = iArr;
        }
    }

    public final UiKitRoundButtonSize a(DriverButton.Size size) {
        Intrinsics.f(size, "size");
        int i8 = WhenMappings.f29028a[size.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                return UiKitRoundButtonSize.f36155i;
            }
            return UiKitRoundButtonSize.f36155i;
        }
        return UiKitRoundButtonSize.f36156j;
    }
}
