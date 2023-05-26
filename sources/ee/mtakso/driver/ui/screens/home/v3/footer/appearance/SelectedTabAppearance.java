package ee.mtakso.driver.ui.screens.home.v3.footer.appearance;

import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.ui.screens.home.v3.footer.FooterAppearance;
import ee.mtakso.driver.ui.screens.home.v3.footer.FooterContainer;
import ee.mtakso.driver.ui.screens.home.v3.footer.HomeTab;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectedTabAppearance.kt */
/* loaded from: classes3.dex */
public final class SelectedTabAppearance implements FooterAppearance {

    /* renamed from: a  reason: collision with root package name */
    private final HomeTab f30018a;

    /* compiled from: SelectedTabAppearance.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30019a;

        static {
            int[] iArr = new int[HomeTab.values().length];
            try {
                iArr[HomeTab.WORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HomeTab.NEWS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HomeTab.HISTORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HomeTab.SETTINGS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f30019a = iArr;
        }
    }

    public SelectedTabAppearance(HomeTab selectedTab) {
        Intrinsics.f(selectedTab, "selectedTab");
        this.f30018a = selectedTab;
    }

    @Override // ee.mtakso.driver.ui.screens.home.v3.footer.FooterAppearance
    public void a(FooterContainer container, DriverStatus driverState) {
        Intrinsics.f(container, "container");
        Intrinsics.f(driverState, "driverState");
        ViewExtKt.e(container.b(), false, 0, 3, null);
        ((ConstraintLayout) container.a(R.id.bottomFooterWorkButtonLayout)).setActivated(false);
        int i8 = WhenMappings.f30019a[this.f30018a.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        ((ConstraintLayout) container.a(R.id.bottomFooterInboxButtonLayout)).setActivated(false);
                        ((ConstraintLayout) container.a(R.id.bottomFooterHistoryButtonLayout)).setActivated(false);
                        ((ConstraintLayout) container.a(R.id.bottomFooterSettingsButtonLayout)).setActivated(true);
                    }
                } else {
                    ((ConstraintLayout) container.a(R.id.bottomFooterInboxButtonLayout)).setActivated(false);
                    ((ConstraintLayout) container.a(R.id.bottomFooterHistoryButtonLayout)).setActivated(true);
                    ((ConstraintLayout) container.a(R.id.bottomFooterSettingsButtonLayout)).setActivated(false);
                }
            } else {
                ((ConstraintLayout) container.a(R.id.bottomFooterInboxButtonLayout)).setActivated(true);
                ((ConstraintLayout) container.a(R.id.bottomFooterHistoryButtonLayout)).setActivated(false);
                ((ConstraintLayout) container.a(R.id.bottomFooterSettingsButtonLayout)).setActivated(false);
            }
            ImageView imageView = (ImageView) container.a(R.id.homeButtonIndicator);
            if (imageView != null) {
                ViewExtKt.e(imageView, DriverStatusKt.b(driverState), 0, 2, null);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }
}
