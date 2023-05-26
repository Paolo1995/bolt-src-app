package ee.mtakso.driver.ui.screens.work;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.utils.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkStatisticsLayoutDelegate.kt */
/* loaded from: classes5.dex */
public final class WorkStatisticsLayoutDelegate {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f33785j = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final View f33786a;

    /* renamed from: b  reason: collision with root package name */
    private final LoadingView f33787b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Integer> f33788c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f33789d;

    /* renamed from: e  reason: collision with root package name */
    private int f33790e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33791f;

    /* renamed from: g  reason: collision with root package name */
    private Function1<? super Integer, Unit> f33792g;

    /* renamed from: h  reason: collision with root package name */
    private final WorkStatisticsLayoutDelegate$globalLayoutListener$1 f33793h;

    /* renamed from: i  reason: collision with root package name */
    public Map<Integer, View> f33794i;

    /* compiled from: WorkStatisticsLayoutDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [ee.mtakso.driver.ui.screens.work.WorkStatisticsLayoutDelegate$globalLayoutListener$1] */
    public WorkStatisticsLayoutDelegate(View containerView, LoadingView innerLayoutDelegate, Function0<Integer> fullHeightProvider) {
        Lazy b8;
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(innerLayoutDelegate, "innerLayoutDelegate");
        Intrinsics.f(fullHeightProvider, "fullHeightProvider");
        this.f33794i = new LinkedHashMap();
        this.f33786a = containerView;
        this.f33787b = innerLayoutDelegate;
        this.f33788c = fullHeightProvider;
        b8 = LazyKt__LazyJVMKt.b(new Function0<BottomSheetBehavior<View>>() { // from class: ee.mtakso.driver.ui.screens.work.WorkStatisticsLayoutDelegate$mBottomSheetBehavior$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final BottomSheetBehavior<View> invoke() {
                return BottomSheetBehavior.k0(WorkStatisticsLayoutDelegate.this.f());
            }
        });
        this.f33789d = b8;
        this.f33790e = -1;
        this.f33793h = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ee.mtakso.driver.ui.screens.work.WorkStatisticsLayoutDelegate$globalLayoutListener$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                WorkStatisticsLayoutDelegate.this.x();
            }
        };
    }

    private final View j() {
        View childAt = ((NestedScrollView) a(R.id.contentScroller)).getChildAt(0);
        Intrinsics.e(childAt, "contentScroller.getChildAt(0)");
        return childAt;
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33794i;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View f8 = f();
            if (f8 == null || (findViewById = f8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void c() {
        h().Q0(4);
        this.f33790e = 4;
    }

    public final void d() {
        h().Q0(3);
        this.f33790e = 3;
    }

    public final int e() {
        return this.f33790e;
    }

    public View f() {
        return this.f33786a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int g() {
        /*
            r8 = this;
            r0 = 4
            java.lang.Integer[] r0 = new java.lang.Integer[r0]
            android.view.View r1 = r8.j()
            int r1 = r1.getHeight()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r1.intValue()
            android.view.View r2 = r8.j()
            int r2 = r2.getVisibility()
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L20
            r2 = 1
            goto L21
        L20:
            r2 = 0
        L21:
            r5 = 0
            if (r2 == 0) goto L25
            goto L26
        L25:
            r1 = r5
        L26:
            r0[r4] = r1
            int r1 = ee.mtakso.driver.R.id.startWorkBtn
            android.view.View r2 = r8.a(r1)
            ee.mtakso.driver.uicore.components.views.swipe.SwipeButton r2 = (ee.mtakso.driver.uicore.components.views.swipe.SwipeButton) r2
            if (r2 == 0) goto L3b
            int r2 = r2.getHeight()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L3c
        L3b:
            r2 = r5
        L3c:
            android.view.View r1 = r8.a(r1)
            ee.mtakso.driver.uicore.components.views.swipe.SwipeButton r1 = (ee.mtakso.driver.uicore.components.views.swipe.SwipeButton) r1
            java.lang.String r6 = "startWorkBtn"
            kotlin.jvm.internal.Intrinsics.e(r1, r6)
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L4f
            r1 = 1
            goto L50
        L4f:
            r1 = 0
        L50:
            if (r1 == 0) goto L53
            goto L54
        L53:
            r2 = r5
        L54:
            r0[r3] = r2
            r1 = 2
            int r2 = ee.mtakso.driver.R.id.workStatisticsProgressBar
            android.view.View r6 = r8.a(r2)
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            int r6 = r6.getHeight()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r6.intValue()
            android.view.View r2 = r8.a(r2)
            android.widget.ProgressBar r2 = (android.widget.ProgressBar) r2
            java.lang.String r7 = "workStatisticsProgressBar"
            kotlin.jvm.internal.Intrinsics.e(r2, r7)
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L7d
            r2 = 1
            goto L7e
        L7d:
            r2 = 0
        L7e:
            if (r2 == 0) goto L81
            goto L82
        L81:
            r6 = r5
        L82:
            r0[r1] = r6
            r1 = 3
            int r2 = ee.mtakso.driver.R.id.bottomSheetIndicatorImageView
            android.view.View r6 = r8.a(r2)
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            if (r6 == 0) goto L98
            int r6 = r6.getHeight()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L99
        L98:
            r6 = r5
        L99:
            android.view.View r2 = r8.a(r2)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            if (r2 == 0) goto Lb3
            java.lang.String r7 = "bottomSheetIndicatorImageView"
            kotlin.jvm.internal.Intrinsics.e(r2, r7)
            int r2 = r2.getVisibility()
            if (r2 != 0) goto Lae
            r2 = 1
            goto Laf
        Lae:
            r2 = 0
        Laf:
            if (r2 != r3) goto Lb3
            r2 = 1
            goto Lb4
        Lb3:
            r2 = 0
        Lb4:
            if (r2 == 0) goto Lbb
            boolean r2 = r8.f33791f
            if (r2 != 0) goto Lbb
            goto Lbc
        Lbb:
            r3 = 0
        Lbc:
            if (r3 == 0) goto Lbf
            r5 = r6
        Lbf:
            r0[r1] = r5
            java.util.List r0 = kotlin.collections.CollectionsKt.p(r0)
            int r0 = kotlin.collections.CollectionsKt.y0(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.work.WorkStatisticsLayoutDelegate.g():int");
    }

    public final BottomSheetBehavior<View> h() {
        return (BottomSheetBehavior) this.f33789d.getValue();
    }

    public final int i() {
        return h().o0();
    }

    public final void k() {
        int i8 = R.id.startWorkBtn;
        SwipeButton swipeButton = (SwipeButton) a(i8);
        if (swipeButton != null) {
            ViewExtKt.c(swipeButton, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkStatisticsLayoutDelegate$hideGoOnlineButton$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final void b() {
                    WorkStatisticsLayoutDelegate.this.x();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
        }
        SwipeButton swipeButton2 = (SwipeButton) a(i8);
        if (swipeButton2 != null) {
            ViewExtKt.e(swipeButton2, false, 0, 2, null);
        }
    }

    public final void l() {
        this.f33787b.a();
        ProgressBar workStatisticsProgressBar = (ProgressBar) a(R.id.workStatisticsProgressBar);
        Intrinsics.e(workStatisticsProgressBar, "workStatisticsProgressBar");
        ViewExtKt.e(workStatisticsProgressBar, false, 0, 2, null);
    }

    public final boolean m() {
        if (h().p0() == 3) {
            return true;
        }
        return false;
    }

    public final void n() {
        t(null);
    }

    public final void o() {
        ViewExtKt.c(j(), new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkStatisticsLayoutDelegate$scheduleScrollableUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                WorkStatisticsLayoutDelegate.this.x();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    public final void p(boolean z7, boolean z8) {
        if (z7 && Utils.g(f().getContext()) && !Utils.h(f().getContext())) {
            h().L0(Dimens.c(120));
        } else if (z8) {
            h().L0(Dimens.c(237));
        } else {
            h().L0(Dimens.c(220));
        }
    }

    public final void q(boolean z7) {
        if (Utils.g(f().getContext())) {
            if (z7) {
                h().L0(Dimens.c(142));
            } else {
                h().L0(Dimens.c(75));
            }
        } else if (z7) {
            h().L0(Dimens.c(191));
        } else {
            h().L0(Dimens.c(85));
        }
    }

    public final void r(int i8) {
        this.f33790e = i8;
    }

    public final void s(boolean z7) {
        int i8;
        this.f33791f = z7;
        ProgressBar workStatisticsProgressBar = (ProgressBar) a(R.id.workStatisticsProgressBar);
        Intrinsics.e(workStatisticsProgressBar, "workStatisticsProgressBar");
        ViewGroup.LayoutParams layoutParams = workStatisticsProgressBar.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (this.f33791f) {
                i8 = R.id.f594startWorkBtn;
            } else {
                i8 = R.id.f83bottomSheetIndicatorImageView;
            }
            layoutParams2.f5012j = i8;
            workStatisticsProgressBar.setLayoutParams(layoutParams2);
            x();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void t(Function1<? super Integer, Unit> function1) {
        Function1<? super Integer, Unit> function12 = this.f33792g;
        if (function12 == null && function1 == null) {
            return;
        }
        if (function12 == null) {
            j().getViewTreeObserver().addOnGlobalLayoutListener(this.f33793h);
        }
        if (function1 == null) {
            j().getViewTreeObserver().removeOnGlobalLayoutListener(this.f33793h);
        }
        this.f33792g = function1;
    }

    public final void u() {
        t(new Function1<Integer, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkStatisticsLayoutDelegate$setupBottomsheetGapUpdater$1

            /* renamed from: f  reason: collision with root package name */
            private int f33799f;

            public void b(int i8) {
                boolean z7;
                Function0 function0;
                if (this.f33799f == i8) {
                    return;
                }
                int p02 = WorkStatisticsLayoutDelegate.this.h().p0();
                SwipeButton swipeButton = (SwipeButton) WorkStatisticsLayoutDelegate.this.a(R.id.startWorkBtn);
                int i9 = 0;
                if (swipeButton != null && swipeButton.getVisibility() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    i9 = Dimens.c(70);
                }
                this.f33799f = i8;
                function0 = WorkStatisticsLayoutDelegate.this.f33788c;
                int min = Math.min(i8, ((Number) function0.invoke()).intValue() - i9);
                View f8 = WorkStatisticsLayoutDelegate.this.f();
                ViewGroup.LayoutParams layoutParams = WorkStatisticsLayoutDelegate.this.f().getLayoutParams();
                layoutParams.height = min;
                f8.setLayoutParams(layoutParams);
                if (WorkStatisticsLayoutDelegate.this.e() == 3) {
                    WorkStatisticsLayoutDelegate.this.h().Q0(3);
                } else if (WorkStatisticsLayoutDelegate.this.e() == 4) {
                    WorkStatisticsLayoutDelegate.this.h().Q0(4);
                } else if (p02 == 3) {
                    WorkStatisticsLayoutDelegate.this.h().Q0(3);
                } else if (p02 == 4) {
                    WorkStatisticsLayoutDelegate.this.h().Q0(4);
                }
                WorkStatisticsLayoutDelegate.this.r(-1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                b(num.intValue());
                return Unit.f50853a;
            }
        });
    }

    public final void v() {
        int i8 = R.id.startWorkBtn;
        SwipeButton swipeButton = (SwipeButton) a(i8);
        if (swipeButton != null) {
            ViewExtKt.c(swipeButton, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkStatisticsLayoutDelegate$showGoOnlineButton$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final void b() {
                    WorkStatisticsLayoutDelegate.this.x();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
        }
        SwipeButton swipeButton2 = (SwipeButton) a(i8);
        if (swipeButton2 != null) {
            ViewExtKt.e(swipeButton2, false, 0, 3, null);
        }
    }

    public final void w() {
        this.f33787b.b();
        ProgressBar workStatisticsProgressBar = (ProgressBar) a(R.id.workStatisticsProgressBar);
        Intrinsics.e(workStatisticsProgressBar, "workStatisticsProgressBar");
        ViewExtKt.e(workStatisticsProgressBar, false, 0, 3, null);
    }

    public final Unit x() {
        Function1<? super Integer, Unit> function1 = this.f33792g;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(g()));
            return Unit.f50853a;
        }
        return null;
    }
}
