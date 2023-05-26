package ee.mtakso.driver.ui.screens.home.v3.header;

import android.view.View;
import android.widget.ImageView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.ui.screens.home.v3.header.HomeHeaderViewController;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeHeaderViewController.kt */
/* loaded from: classes3.dex */
public final class HomeHeaderViewController {

    /* renamed from: a  reason: collision with root package name */
    private final View f30028a;

    /* renamed from: b  reason: collision with root package name */
    private final HeaderContainer f30029b;

    /* renamed from: c  reason: collision with root package name */
    private HeaderAppearance f30030c;

    /* renamed from: d  reason: collision with root package name */
    private DriverStatus f30031d;

    /* renamed from: e  reason: collision with root package name */
    private DriverStatus f30032e;

    public HomeHeaderViewController(View root, View destinationHint, View destinationHintDismissTouchArea, View progressContainer, final Function0<Unit> swipeCallback, final Function0<Unit> goBack) {
        Intrinsics.f(root, "root");
        Intrinsics.f(destinationHint, "destinationHint");
        Intrinsics.f(destinationHintDismissTouchArea, "destinationHintDismissTouchArea");
        Intrinsics.f(progressContainer, "progressContainer");
        Intrinsics.f(swipeCallback, "swipeCallback");
        Intrinsics.f(goBack, "goBack");
        this.f30028a = progressContainer;
        HeaderContainer headerContainer = new HeaderContainer(root, destinationHint, destinationHintDismissTouchArea);
        this.f30029b = headerContainer;
        ((SwipeButton) headerContainer.a(R.id.homeSwipe)).setOnRequestStateChangeListener(new Function1<SwipeButton.State, SwipeButton.State>() { // from class: ee.mtakso.driver.ui.screens.home.v3.header.HomeHeaderViewController.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SwipeButton.State invoke(SwipeButton.State state) {
                Intrinsics.f(state, "state");
                SwipeButton.State state2 = SwipeButton.State.SWIPABLE;
                if (state == state2) {
                    swipeCallback.invoke();
                    return state2;
                }
                return null;
            }
        });
        ((ImageView) headerContainer.a(R.id.homeButtonBack)).setOnClickListener(new View.OnClickListener() { // from class: z3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeHeaderViewController.b(Function0.this, view);
            }
        });
        DriverStatus driverStatus = DriverStatus.UNDEFINED;
        this.f30031d = driverStatus;
        this.f30032e = driverStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function0 goBack, View view) {
        Intrinsics.f(goBack, "$goBack");
        goBack.invoke();
    }

    public final void c(HeaderAppearance appearance) {
        Intrinsics.f(appearance, "appearance");
        this.f30030c = appearance;
        appearance.a(this.f30029b, this.f30032e, this.f30031d);
    }

    public final void d(DriverStatus state) {
        Intrinsics.f(state, "state");
        DriverStatus driverStatus = this.f30031d;
        if (driverStatus == state) {
            return;
        }
        if (driverStatus != DriverStatus.PENDING) {
            this.f30032e = driverStatus;
        }
        this.f30031d = state;
        ViewExtKt.e(this.f30028a, DriverStatusKt.b(state), 0, 2, null);
        HeaderAppearance headerAppearance = this.f30030c;
        if (headerAppearance != null) {
            headerAppearance.a(this.f30029b, this.f30032e, this.f30031d);
        }
    }
}
