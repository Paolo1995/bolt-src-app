package ee.mtakso.driver.ui.screens.home.v3.header.appearance;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.ui.screens.home.v3.header.HeaderContainer;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubPageAppearance.kt */
/* loaded from: classes3.dex */
public final class SubPageAppearance extends CachedViewHeaderAppearance {

    /* renamed from: b  reason: collision with root package name */
    private final String f30043b;

    public SubPageAppearance(String title) {
        Intrinsics.f(title, "title");
        this.f30043b = title;
    }

    private final void c() {
        SwipeButton swipeButton;
        TextView textView;
        HeaderContainer b8 = b();
        if (b8 != null && (textView = (TextView) b8.a(R.id.homeTitle)) != null) {
            ViewExtKt.e(textView, false, 0, 3, null);
        }
        HeaderContainer b9 = b();
        if (b9 != null && (swipeButton = (SwipeButton) b9.a(R.id.homeSwipe)) != null) {
            ViewExtKt.e(swipeButton, false, 0, 2, null);
        }
    }

    private final void d() {
        SwipeButton swipeButton;
        TextView textView;
        HeaderContainer b8 = b();
        if (b8 != null && (textView = (TextView) b8.a(R.id.homeTitle)) != null) {
            ViewExtKt.e(textView, false, 0, 2, null);
        }
        HeaderContainer b9 = b();
        if (b9 != null && (swipeButton = (SwipeButton) b9.a(R.id.homeSwipe)) != null) {
            ViewExtKt.e(swipeButton, false, 0, 3, null);
        }
    }

    @Override // ee.mtakso.driver.ui.screens.home.v3.header.appearance.CachedViewHeaderAppearance, ee.mtakso.driver.ui.screens.home.v3.header.HeaderAppearance
    public void a(HeaderContainer target, DriverStatus previousState, DriverStatus driverStatus) {
        Intrinsics.f(target, "target");
        Intrinsics.f(previousState, "previousState");
        Intrinsics.f(driverStatus, "driverStatus");
        super.a(target, previousState, driverStatus);
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "Applying strategy " + driverStatus, null, 2, null);
        }
        if (DriverStatusKt.b(driverStatus)) {
            d();
        } else if (DriverStatusKt.a(driverStatus)) {
            c();
        } else {
            Kalev.d("Unexpected state: " + driverStatus);
        }
        ImageView imageView = (ImageView) target.a(R.id.homeButtonBack);
        Intrinsics.e(imageView, "target.homeButtonBack");
        boolean z7 = true;
        ViewExtKt.e(imageView, true, 0, 2, null);
        if (this.f30043b.length() <= 0) {
            z7 = false;
        }
        if (z7) {
            int i8 = R.id.homeTitle;
            if (!Intrinsics.a(((TextView) target.a(i8)).getText(), this.f30043b)) {
                ((TextView) target.a(i8)).setText(this.f30043b);
            }
        }
        TextView textView = (TextView) target.a(R.id.homeEndAction);
        Intrinsics.e(textView, "target.homeEndAction");
        ViewExtKt.e(textView, false, 0, 2, null);
        RoundButton roundButton = (RoundButton) target.a(R.id.homeDestinationButton);
        Intrinsics.e(roundButton, "target.homeDestinationButton");
        ViewExtKt.e(roundButton, false, 0, 2, null);
        LinearLayout linearLayout = (LinearLayout) target.a(R.id.homeFatigue);
        Intrinsics.e(linearLayout, "target.homeFatigue");
        ViewExtKt.e(linearLayout, false, 0, 2, null);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) target.a(R.id.audioInProgressAnimationView);
        Intrinsics.e(lottieAnimationView, "target.audioInProgressAnimationView");
        ViewExtKt.e(lottieAnimationView, false, 0, 2, null);
        LinearLayout linearLayout2 = (LinearLayout) target.a(R.id.homeFatigueRolling);
        Intrinsics.e(linearLayout2, "target.homeFatigueRolling");
        ViewExtKt.e(linearLayout2, false, 0, 2, null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) target.a(R.id.newBadge);
        Intrinsics.e(appCompatImageView, "target.newBadge");
        ViewExtKt.e(appCompatImageView, false, 0, 2, null);
        ViewExtKt.e(target.b(), false, 0, 3, null);
        ViewExtKt.e(target.c(), false, 0, 2, null);
    }
}
