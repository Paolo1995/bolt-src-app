package ee.mtakso.driver.utils.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ControllableBottomSheetBehavior.kt */
/* loaded from: classes5.dex */
public class ControllableBottomSheetBehavior<V extends View> extends ComponentBottomSheetBehavior<V> {
    public static final Companion H = new Companion(null);
    private final List<ComponentBottomSheetBehavior.BottomSheetCallback> F;
    private boolean G;

    /* compiled from: ControllableBottomSheetBehavior.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <V extends View> ControllableBottomSheetBehavior<V> a(V view) {
            Intrinsics.f(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.e(layoutParams, "view.getLayoutParams()");
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior f8 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
                if (f8 instanceof ControllableBottomSheetBehavior) {
                    return (ControllableBottomSheetBehavior) f8;
                }
                throw new IllegalArgumentException("The view is not associated with ControllableBottomSheetBehavior");
            }
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
    }

    public ControllableBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new ArrayList();
        this.G = true;
        super.T(new ComponentBottomSheetBehavior.BottomSheetCallback(this) { // from class: ee.mtakso.driver.utils.bottomsheet.ControllableBottomSheetBehavior.1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ControllableBottomSheetBehavior<V> f36381a;

            {
                this.f36381a = this;
            }

            @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.BottomSheetCallback
            public void a(View p02, float f8) {
                Intrinsics.f(p02, "p0");
                for (ComponentBottomSheetBehavior.BottomSheetCallback bottomSheetCallback : this.f36381a.e0()) {
                    bottomSheetCallback.a(p02, f8);
                }
            }

            @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.BottomSheetCallback
            public void b(View p02, int i8) {
                Intrinsics.f(p02, "p0");
                for (ComponentBottomSheetBehavior.BottomSheetCallback bottomSheetCallback : this.f36381a.e0()) {
                    bottomSheetCallback.b(p02, i8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ComponentBottomSheetBehavior.BottomSheetCallback> e0() {
        List<ComponentBottomSheetBehavior.BottomSheetCallback> H0;
        H0 = CollectionsKt___CollectionsKt.H0(this.F);
        return H0;
    }

    @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean A(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int i8, int i9) {
        Intrinsics.f(coordinatorLayout, "coordinatorLayout");
        Intrinsics.f(child, "child");
        Intrinsics.f(directTargetChild, "directTargetChild");
        Intrinsics.f(target, "target");
        if (this.G) {
            return super.A(coordinatorLayout, child, directTargetChild, target, i8, i9);
        }
        return false;
    }

    @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void C(CoordinatorLayout coordinatorLayout, V child, View target, int i8) {
        Intrinsics.f(coordinatorLayout, "coordinatorLayout");
        Intrinsics.f(child, "child");
        Intrinsics.f(target, "target");
        if (!this.G) {
            return;
        }
        super.C(coordinatorLayout, child, target, i8);
    }

    @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(CoordinatorLayout parent, V child, MotionEvent event) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        Intrinsics.f(event, "event");
        if (this.G) {
            return super.D(parent, child, event);
        }
        return false;
    }

    public final void d0(ComponentBottomSheetBehavior.BottomSheetCallback observer) {
        Intrinsics.f(observer, "observer");
        this.F.add(observer);
    }

    public final boolean f0() {
        return this.G;
    }

    public final void g0(ComponentBottomSheetBehavior.BottomSheetCallback observer) {
        Intrinsics.f(observer, "observer");
        this.F.remove(observer);
    }

    public final void h0(boolean z7) {
        this.G = z7;
    }

    @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout parent, V child, MotionEvent event) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        Intrinsics.f(event, "event");
        if (this.G) {
            return super.k(parent, child, event);
        }
        return false;
    }

    @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean o(CoordinatorLayout coordinatorLayout, V child, View target, float f8, float f9) {
        Intrinsics.f(coordinatorLayout, "coordinatorLayout");
        Intrinsics.f(child, "child");
        Intrinsics.f(target, "target");
        if (this.G) {
            return super.o(coordinatorLayout, child, target, f8, f9);
        }
        return false;
    }

    @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void q(CoordinatorLayout coordinatorLayout, V child, View target, int i8, int i9, int[] consumed, int i10) {
        Intrinsics.f(coordinatorLayout, "coordinatorLayout");
        Intrinsics.f(child, "child");
        Intrinsics.f(target, "target");
        Intrinsics.f(consumed, "consumed");
        if (!this.G) {
            return;
        }
        super.q(coordinatorLayout, child, target, i8, i9, consumed, i10);
    }
}
