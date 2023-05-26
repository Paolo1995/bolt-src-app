package ee.mtakso.driver.uikit.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ee.mtakso.driver.uikit.R$styleable;
import ee.mtakso.driver.uikit.utils.Dimens;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimaryBottomSheetBehavior.kt */
/* loaded from: classes5.dex */
public final class PrimaryBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    /* renamed from: i0  reason: collision with root package name */
    private V f35907i0;

    /* renamed from: j0  reason: collision with root package name */
    private CoordinatorLayout f35908j0;

    /* renamed from: k0  reason: collision with root package name */
    private int f35909k0;

    /* renamed from: l0  reason: collision with root package name */
    private int f35910l0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimaryBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        this.f35909k0 = Dimens.c(200);
        this.f35910l0 = Dimens.c(56);
        super.F0(false);
        super.I0(false);
        super.E0(Dimens.c(0));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f35885v1);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…Behavior_Layout\n        )");
        this.f35909k0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35895x1, this.f35909k0);
        this.f35910l0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35890w1, this.f35910l0);
        obtainStyledAttributes.recycle();
    }

    private final void f1(V v7) {
        if (this.f35907i0 == null) {
            this.f35907i0 = v7;
        }
        if (Intrinsics.a(this.f35907i0, v7)) {
            return;
        }
        throw new IllegalStateException("Behaviour already attached to view");
    }

    private final void g1(CoordinatorLayout coordinatorLayout) {
        if (this.f35908j0 == null) {
            this.f35908j0 = coordinatorLayout;
        }
        if (Intrinsics.a(this.f35908j0, coordinatorLayout)) {
            return;
        }
        throw new IllegalStateException("Behaviour already attached to view");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void E0(int i8) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void F0(boolean z7) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void H0(float f8) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void I0(boolean z7) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(final CoordinatorLayout parent, final V child, final int i8) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        f1(child);
        g1(parent);
        if (child.getMeasuredHeight() < o0()) {
            super.E0(parent.getHeight() - o0());
        } else if (child.getMeasuredHeight() < this.f35909k0) {
            super.H0(child.getMeasuredHeight() / parent.getHeight());
            super.E0(parent.getHeight() - child.getMeasuredHeight());
        } else if (child.getMeasuredHeight() < parent.getHeight() - this.f35910l0) {
            super.H0(this.f35909k0 / parent.getHeight());
            super.E0(parent.getHeight() - child.getMeasuredHeight());
        } else {
            super.H0(this.f35909k0 / parent.getHeight());
            super.E0(this.f35910l0);
        }
        return BottomSheetAnimation.f35905a.a(parent, child, new Function0<Boolean>() { // from class: ee.mtakso.driver.uikit.bottomsheet.PrimaryBottomSheetBehavior$onLayoutChild$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lee/mtakso/driver/uikit/bottomsheet/PrimaryBottomSheetBehavior<TV;>;Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;I)V */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Boolean invoke() {
                boolean l8;
                l8 = super/*com.google.android.material.bottomsheet.BottomSheetBehavior*/.l(parent, child, i8);
                return Boolean.valueOf(l8);
            }
        });
    }
}
