package ee.mtakso.driver.ui.screens.home.v3.header.appearance;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.client.work_time.WorkingTimeInfo;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.screens.home.v3.header.HeaderContainer;
import ee.mtakso.driver.ui.screens.home.v3.header.appearance.RightButton;
import ee.mtakso.driver.ui.screens.home.v3.header.appearance.WorkPageAppearance;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyUIUtils;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkPageAppearance.kt */
/* loaded from: classes3.dex */
public final class WorkPageAppearance extends CachedViewHeaderAppearance {

    /* renamed from: b  reason: collision with root package name */
    private final OfflineButtonsHolder f30044b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f30045c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f30046d;

    /* renamed from: e  reason: collision with root package name */
    private final Function0<Unit> f30047e;

    /* renamed from: f  reason: collision with root package name */
    private final Function2<RoundButton, Boolean, Unit> f30048f;

    /* renamed from: g  reason: collision with root package name */
    private final Function1<RoundButton, Unit> f30049g;

    /* renamed from: h  reason: collision with root package name */
    private final Function1<Boolean, Unit> f30050h;

    /* renamed from: i  reason: collision with root package name */
    private WorkingTimeInfo f30051i;

    /* renamed from: j  reason: collision with root package name */
    private int f30052j;

    /* renamed from: k  reason: collision with root package name */
    private DriverStatus f30053k;

    /* renamed from: l  reason: collision with root package name */
    private int f30054l;

    /* compiled from: WorkPageAppearance.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30055a;

        static {
            int[] iArr = new int[RightButton.SafetyType.values().length];
            try {
                iArr[RightButton.SafetyType.SOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RightButton.SafetyType.SAFETY_TOOLKIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f30055a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkPageAppearance(OfflineButtonsHolder offlineButtonsHolder, DriverProvider driverProvider, Function0<Unit> openDestinations, Function0<Unit> openWorkTime, Function2<? super RoundButton, ? super Boolean, Unit> openSosChanged, Function1<? super RoundButton, Unit> openSafetyToolkitMenu, Function1<? super Boolean, Unit> driverStateDrawer) {
        Intrinsics.f(offlineButtonsHolder, "offlineButtonsHolder");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(openDestinations, "openDestinations");
        Intrinsics.f(openWorkTime, "openWorkTime");
        Intrinsics.f(openSosChanged, "openSosChanged");
        Intrinsics.f(openSafetyToolkitMenu, "openSafetyToolkitMenu");
        Intrinsics.f(driverStateDrawer, "driverStateDrawer");
        this.f30044b = offlineButtonsHolder;
        this.f30045c = driverProvider;
        this.f30046d = openDestinations;
        this.f30047e = openWorkTime;
        this.f30048f = openSosChanged;
        this.f30049g = openSafetyToolkitMenu;
        this.f30050h = driverStateDrawer;
        this.f30052j = 8;
        this.f30053k = DriverStatus.UNDEFINED;
        this.f30054l = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A(HeaderContainer target, WorkPageAppearance this$0, View view, MotionEvent motionEvent) {
        Intrinsics.f(target, "$target");
        Intrinsics.f(this$0, "this$0");
        ViewExtKt.d(target.c(), false, 0, 2, null);
        ViewExtKt.d(target.d(), false, 0, 2, null);
        this$0.f30045c.t().o().b(true);
        view.performClick();
        return false;
    }

    private final boolean B(RoundButton roundButton, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f30048f.s(roundButton, Boolean.TRUE);
            return true;
        } else if (motionEvent.getAction() == 1) {
            this.f30048f.s(roundButton, Boolean.FALSE);
            return false;
        } else {
            return false;
        }
    }

    private final void C(final HeaderContainer headerContainer, boolean z7) {
        if (!v()) {
            RoundButton roundButton = (RoundButton) headerContainer.a(R.id.homeDestinationButton);
            Intrinsics.e(roundButton, "container.homeDestinationButton");
            ViewExtKt.d(roundButton, false, 0, 2, null);
            ViewExtKt.d(this.f30044b.a(), false, 0, 2, null);
        } else if (z7) {
            int i8 = R.id.homeDestinationButton;
            RoundButton roundButton2 = (RoundButton) headerContainer.a(i8);
            Intrinsics.e(roundButton2, "container.homeDestinationButton");
            ViewExtKt.d(roundButton2, false, 0, 3, null);
            ((RoundButton) headerContainer.a(i8)).setOnClickListener(new View.OnClickListener() { // from class: a4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WorkPageAppearance.D(WorkPageAppearance.this, view);
                }
            });
            ViewExtKt.d(this.f30044b.a(), false, 0, 2, null);
        } else {
            RoundButton roundButton3 = (RoundButton) headerContainer.a(R.id.homeDestinationButton);
            Intrinsics.e(roundButton3, "container.homeDestinationButton");
            ViewExtKt.d(roundButton3, false, 0, 2, null);
            if (w()) {
                ViewExtKt.d(this.f30044b.a(), false, 0, 3, null);
                this.f30044b.a().setOnClickListener(new View.OnClickListener() { // from class: a4.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WorkPageAppearance.E(WorkPageAppearance.this, view);
                    }
                });
            } else {
                ViewExtKt.d(this.f30044b.a(), false, 0, 2, null);
            }
        }
        int i9 = WhenMappings.f30055a[this.f30044b.b().b().ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                RoundButton roundButton4 = (RoundButton) headerContainer.a(R.id.homeSosButton);
                Intrinsics.e(roundButton4, "container.homeSosButton");
                ViewExtKt.d(roundButton4, false, 0, 2, null);
                if (z7) {
                    int i10 = R.id.homeSafetyToolkitButton;
                    RoundButton roundButton5 = (RoundButton) headerContainer.a(i10);
                    Intrinsics.e(roundButton5, "container.homeSafetyToolkitButton");
                    ViewExtKt.d(roundButton5, false, 0, 3, null);
                    ((RoundButton) headerContainer.a(i10)).setOnClickListener(new View.OnClickListener() { // from class: a4.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WorkPageAppearance.H(WorkPageAppearance.this, headerContainer, view);
                        }
                    });
                    ViewExtKt.d(this.f30044b.b().a(), false, 0, 2, null);
                    return;
                }
                RoundButton roundButton6 = (RoundButton) headerContainer.a(R.id.homeSafetyToolkitButton);
                Intrinsics.e(roundButton6, "container.homeSafetyToolkitButton");
                ViewExtKt.d(roundButton6, false, 0, 2, null);
                ViewExtKt.d(this.f30044b.b().a(), false, 0, 3, null);
                this.f30044b.b().a().setOnClickListener(new View.OnClickListener() { // from class: a4.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WorkPageAppearance.I(WorkPageAppearance.this, view);
                    }
                });
            }
        } else if (!x()) {
            RoundButton roundButton7 = (RoundButton) headerContainer.a(R.id.homeSosButton);
            Intrinsics.e(roundButton7, "container.homeSosButton");
            ViewExtKt.d(roundButton7, false, 0, 2, null);
            ViewExtKt.d(this.f30044b.b().a(), false, 0, 2, null);
        } else if (z7) {
            int i11 = R.id.homeSosButton;
            RoundButton roundButton8 = (RoundButton) headerContainer.a(i11);
            Intrinsics.e(roundButton8, "container.homeSosButton");
            ViewExtKt.d(roundButton8, false, 0, 3, null);
            ((RoundButton) headerContainer.a(i11)).setOnTouchListener(new View.OnTouchListener() { // from class: a4.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean F;
                    F = WorkPageAppearance.F(WorkPageAppearance.this, headerContainer, view, motionEvent);
                    return F;
                }
            });
            ViewExtKt.d(this.f30044b.b().a(), false, 0, 2, null);
        } else {
            RoundButton roundButton9 = (RoundButton) headerContainer.a(R.id.homeSosButton);
            Intrinsics.e(roundButton9, "container.homeSosButton");
            ViewExtKt.d(roundButton9, false, 0, 2, null);
            ViewExtKt.d(this.f30044b.b().a(), false, 0, 3, null);
            this.f30044b.b().a().setOnTouchListener(new View.OnTouchListener() { // from class: a4.d
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean G;
                    G = WorkPageAppearance.G(WorkPageAppearance.this, view, motionEvent);
                    return G;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(WorkPageAppearance this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f30046d.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(WorkPageAppearance this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f30046d.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F(WorkPageAppearance this$0, HeaderContainer container, View view, MotionEvent event) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(container, "$container");
        RoundButton roundButton = (RoundButton) container.a(R.id.homeSosButton);
        Intrinsics.e(roundButton, "container.homeSosButton");
        Intrinsics.e(event, "event");
        return this$0.B(roundButton, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(WorkPageAppearance this$0, View view, MotionEvent event) {
        Intrinsics.f(this$0, "this$0");
        RoundButton a8 = this$0.f30044b.b().a();
        Intrinsics.e(event, "event");
        return this$0.B(a8, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(WorkPageAppearance this$0, HeaderContainer container, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(container, "$container");
        Function1<RoundButton, Unit> function1 = this$0.f30049g;
        RoundButton roundButton = (RoundButton) container.a(R.id.homeSafetyToolkitButton);
        Intrinsics.e(roundButton, "container.homeSafetyToolkitButton");
        function1.invoke(roundButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(WorkPageAppearance this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f30049g.invoke(this$0.f30044b.b().a());
    }

    private final void K(int i8) {
        LottieAnimationView lottieAnimationView;
        HeaderContainer b8 = b();
        if (b8 != null && (lottieAnimationView = (LottieAnimationView) b8.a(R.id.audioInProgressAnimationView)) != null) {
            SafetyUIUtils.f32878a.b(lottieAnimationView, i8);
        }
    }

    private final void m(HeaderContainer headerContainer, DriverStatus driverStatus) {
        if (DriverStatusKt.a(driverStatus)) {
            o(headerContainer);
        } else if (DriverStatusKt.b(driverStatus)) {
            n(headerContainer);
        } else {
            Kalev.d("Unexpected previous state: " + driverStatus);
        }
    }

    private final void n(HeaderContainer headerContainer) {
        SwipeButton swipeButton = (SwipeButton) headerContainer.a(R.id.homeSwipe);
        Intrinsics.e(swipeButton, "target.homeSwipe");
        ViewExtKt.d(swipeButton, false, 0, 2, null);
        this.f30050h.invoke(Boolean.FALSE);
        ViewExtKt.d(headerContainer.c(), false, 0, 2, null);
        C(headerContainer, false);
        K(8);
        r(false);
        z(headerContainer);
    }

    private final void o(HeaderContainer headerContainer) {
        ViewExtKt.d(headerContainer.b(), false, 0, 3, null);
        SwipeButton swipeButton = (SwipeButton) headerContainer.a(R.id.homeSwipe);
        Intrinsics.e(swipeButton, "target.homeSwipe");
        ViewExtKt.d(swipeButton, false, 0, 3, null);
        this.f30050h.invoke(Boolean.TRUE);
        z(headerContainer);
        if (!this.f30045c.t().o().a() && v()) {
            ViewExtKt.d(headerContainer.c(), false, 0, 3, null);
            headerContainer.c().setOnClickListener(new View.OnClickListener() { // from class: a4.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WorkPageAppearance.p(WorkPageAppearance.this, view);
                }
            });
        }
        if (this.f30045c.n().Q()) {
            K(this.f30052j);
            L(this.f30054l);
        }
        C(headerContainer, true);
        r(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(WorkPageAppearance this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        ViewExtKt.d(it, false, 0, 2, null);
        this$0.f30045c.t().o().b(true);
    }

    private final String q(Context context, WorkingTimeInfo workingTimeInfo, boolean z7) {
        if (workingTimeInfo.g() <= 0) {
            return context.getString(R.string.working_time_exceeded);
        }
        if (z7) {
            return context.getString(R.string.working_time_warning);
        }
        if (!z7) {
            return context.getString(R.string.working_time_warning_expanded, workingTimeInfo.c(), workingTimeInfo.d());
        }
        return null;
    }

    private final void r(boolean z7) {
        HeaderContainer b8 = b();
        if (b8 == null) {
            return;
        }
        WorkingTimeInfo workingTimeInfo = this.f30051i;
        DriverFeaturesConfig.WorkingTimeMode M = this.f30045c.m().M();
        if (workingTimeInfo != null && M != DriverFeaturesConfig.WorkingTimeMode.DISABLED) {
            if (M == DriverFeaturesConfig.WorkingTimeMode.ACCUMULATING) {
                if (TimeUnit.SECONDS.toHours(workingTimeInfo.g()) < 1) {
                    ViewExtKt.d(b8.b(), z7, 0, 2, null);
                    TextView textView = (TextView) b8.a(R.id.homeFatigueTimer);
                    if (textView != null) {
                        textView.setText(workingTimeInfo.f());
                    }
                    int i8 = R.id.homeFatigue;
                    LinearLayout linearLayout = (LinearLayout) b8.a(i8);
                    if (linearLayout != null) {
                        ViewExtKt.d(linearLayout, false, 0, 3, null);
                    }
                    LinearLayout linearLayout2 = (LinearLayout) b8.a(R.id.homeFatigueRolling);
                    Intrinsics.e(linearLayout2, "target.homeFatigueRolling");
                    ViewExtKt.d(linearLayout2, false, 0, 2, null);
                    LinearLayout linearLayout3 = (LinearLayout) b8.a(i8);
                    if (linearLayout3 != null) {
                        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: a4.i
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                WorkPageAppearance.t(WorkPageAppearance.this, view);
                            }
                        });
                        return;
                    }
                    return;
                }
                LinearLayout linearLayout4 = (LinearLayout) b8.a(R.id.homeFatigue);
                Intrinsics.e(linearLayout4, "target.homeFatigue");
                ViewExtKt.d(linearLayout4, false, 0, 2, null);
                LinearLayout linearLayout5 = (LinearLayout) b8.a(R.id.homeFatigueRolling);
                Intrinsics.e(linearLayout5, "target.homeFatigueRolling");
                ViewExtKt.d(linearLayout5, false, 0, 2, null);
                ViewExtKt.d(b8.b(), z7, 0, 2, null);
                return;
            } else if (M == DriverFeaturesConfig.WorkingTimeMode.ROLLING) {
                if (TimeUnit.SECONDS.toHours(workingTimeInfo.g()) > 1) {
                    LinearLayout linearLayout6 = (LinearLayout) b8.a(R.id.homeFatigueRolling);
                    Intrinsics.e(linearLayout6, "target.homeFatigueRolling");
                    ViewExtKt.d(linearLayout6, false, 0, 2, null);
                    ViewExtKt.d(b8.b(), z7, 0, 2, null);
                    return;
                }
                ViewExtKt.d(b8.b(), false, 0, 3, null);
                int i9 = R.id.homeFatigueRolling;
                LinearLayout linearLayout7 = (LinearLayout) b8.a(i9);
                Intrinsics.e(linearLayout7, "target.homeFatigueRolling");
                ViewExtKt.d(linearLayout7, false, 0, 3, null);
                ((LinearLayout) b8.a(i9)).setOnClickListener(new View.OnClickListener() { // from class: a4.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WorkPageAppearance.u(WorkPageAppearance.this, view);
                    }
                });
                Context context = b8.b().getContext();
                Intrinsics.e(context, "target.containerView.context");
                ((TextView) b8.a(R.id.homeFatigueRollingDesc)).setText(q(context, workingTimeInfo, z7));
                ((TextView) b8.a(R.id.homeFatigueRollingValue)).setText(workingTimeInfo.f());
                return;
            } else {
                return;
            }
        }
        LinearLayout linearLayout8 = (LinearLayout) b8.a(R.id.homeFatigue);
        Intrinsics.e(linearLayout8, "target.homeFatigue");
        ViewExtKt.d(linearLayout8, false, 0, 2, null);
        LinearLayout linearLayout9 = (LinearLayout) b8.a(R.id.homeFatigueRolling);
        Intrinsics.e(linearLayout9, "target.homeFatigueRolling");
        ViewExtKt.d(linearLayout9, false, 0, 2, null);
    }

    static /* synthetic */ void s(WorkPageAppearance workPageAppearance, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = DriverStatusKt.b(workPageAppearance.f30053k);
        }
        workPageAppearance.r(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(WorkPageAppearance this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f30047e.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(WorkPageAppearance this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f30047e.invoke();
    }

    private final boolean v() {
        return this.f30045c.m().p();
    }

    private final boolean w() {
        WorkingTimeInfo workingTimeInfo = this.f30051i;
        if (workingTimeInfo == null || this.f30045c.m().M() == DriverFeaturesConfig.WorkingTimeMode.DISABLED || TimeUnit.SECONDS.toMinutes(workingTimeInfo.g()) >= 30) {
            return true;
        }
        return false;
    }

    private final boolean x() {
        return this.f30045c.m().I();
    }

    private final void z(final HeaderContainer headerContainer) {
        if (!this.f30045c.v().o().a() && v()) {
            ViewExtKt.d(headerContainer.c(), false, 0, 3, null);
            ViewExtKt.d(headerContainer.d(), false, 0, 3, null);
            headerContainer.d().setOnTouchListener(new View.OnTouchListener() { // from class: a4.h
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean A;
                    A = WorkPageAppearance.A(HeaderContainer.this, this, view, motionEvent);
                    return A;
                }
            });
        }
    }

    public final void J(Integer num, Integer num2, Integer num3, int i8, int i9) {
        RoundButton roundButton;
        this.f30052j = i9;
        HeaderContainer b8 = b();
        if (b8 != null && (roundButton = (RoundButton) b8.a(R.id.homeSafetyToolkitButton)) != null) {
            roundButton.setBgColor(i8);
            if (num3 != null) {
                roundButton.setIconTint(num3);
                this.f30044b.b().a().setIconTint(num3);
            } else {
                roundButton.setIconTint(null);
                this.f30044b.b().a().setIconTint(null);
            }
            if (num != null) {
                roundButton.b(num.intValue());
            } else if (num2 != null) {
                roundButton.b(num2.intValue());
            }
            if (DriverStatusKt.b(this.f30053k)) {
                K(this.f30052j);
            } else {
                K(8);
            }
        }
        if (num != null) {
            this.f30044b.b().a().b(num.intValue());
        } else if (num2 != null) {
            this.f30044b.b().a().b(num2.intValue());
        }
    }

    public final void L(int i8) {
        AppCompatImageView appCompatImageView;
        this.f30054l = i8;
        HeaderContainer b8 = b();
        if (b8 != null) {
            appCompatImageView = (AppCompatImageView) b8.a(R.id.newBadge);
        } else {
            appCompatImageView = null;
        }
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(this.f30054l);
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
            FastLog.DefaultImpls.c(g8, "Applying strategy " + previousState + " -> " + driverStatus, null, 2, null);
        }
        this.f30053k = driverStatus;
        if (DriverStatusKt.b(driverStatus)) {
            o(target);
        } else if (DriverStatusKt.a(driverStatus)) {
            n(target);
        } else if (driverStatus == DriverStatus.PENDING) {
            m(target, previousState);
        } else {
            Kalev.d("Unexpected state: " + driverStatus);
        }
        ImageView imageView = (ImageView) target.a(R.id.homeButtonBack);
        Intrinsics.e(imageView, "target.homeButtonBack");
        ViewExtKt.d(imageView, false, 0, 2, null);
        TextView textView = (TextView) target.a(R.id.homeTitle);
        Intrinsics.e(textView, "target.homeTitle");
        ViewExtKt.d(textView, false, 0, 2, null);
        TextView textView2 = (TextView) target.a(R.id.homeEndAction);
        Intrinsics.e(textView2, "target.homeEndAction");
        ViewExtKt.d(textView2, false, 0, 2, null);
    }

    public final void y(WorkingTimeInfo workingTimeInfo) {
        this.f30051i = workingTimeInfo;
        s(this, false, 1, null);
        HeaderContainer b8 = b();
        if (b8 == null) {
            return;
        }
        C(b8, DriverStatusKt.b(this.f30053k));
    }
}
