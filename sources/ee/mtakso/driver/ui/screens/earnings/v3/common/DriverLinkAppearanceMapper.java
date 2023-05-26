package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Color;
import eu.bolt.driver.earnings.network.DriverLink;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverLinkAppearanceMapper.kt */
/* loaded from: classes3.dex */
public final class DriverLinkAppearanceMapper {

    /* compiled from: DriverLinkAppearanceMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29045a;

        static {
            int[] iArr = new int[DriverLink.Appearance.values().length];
            try {
                iArr[DriverLink.Appearance.ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverLink.Appearance.PRIMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f29045a = iArr;
        }
    }

    public final Color a(DriverLink.Appearance appearance) {
        Intrinsics.f(appearance, "appearance");
        int i8 = WhenMappings.f29045a[appearance.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return new Color.Res(R.color.selector_link);
            }
            throw new NoWhenBranchMatchedException();
        }
        return new Color.Res(R.color.selector_link_alternative);
    }
}
