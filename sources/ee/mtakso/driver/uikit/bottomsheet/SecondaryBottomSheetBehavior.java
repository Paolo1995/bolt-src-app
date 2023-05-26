package ee.mtakso.driver.uikit.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ee.mtakso.driver.uikit.utils.Dimens;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecondaryBottomSheetBehavior.kt */
/* loaded from: classes5.dex */
public class SecondaryBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    /* renamed from: i0  reason: collision with root package name */
    private int f35915i0;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f35916j0;

    public /* synthetic */ SecondaryBottomSheetBehavior(Context context, AttributeSet attributeSet, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i8 & 2) != 0 ? null : attributeSet);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void F0(boolean z7) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void I0(boolean z7) {
    }

    public final void f1(boolean z7) {
        this.f35916j0 = z7;
    }

    public final void g1(int i8) {
        this.f35915i0 = i8;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(final CoordinatorLayout parent, final V child, final int i8) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        if (this.f35916j0) {
            return BottomSheetAnimation.f35905a.a(parent, child, new Function0<Boolean>() { // from class: ee.mtakso.driver.uikit.bottomsheet.SecondaryBottomSheetBehavior$onLayoutChild$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Lee/mtakso/driver/uikit/bottomsheet/SecondaryBottomSheetBehavior<TV;>;Landroidx/coordinatorlayout/widget/CoordinatorLayout;TV;I)V */
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
        return super.l(parent, child, i8);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout parent, V child, int i8, int i9, int i10, int i11) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (parent.getHeight() - this.f35915i0 > size) {
            size = Math.min(parent.getHeight() - this.f35915i0, size);
        }
        parent.K(child, i8, i9, View.MeasureSpec.makeMeasureSpec(size, mode), i11);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecondaryBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        this.f35915i0 = Dimens.c(56);
        this.f35916j0 = true;
        super.F0(true);
        super.I0(true);
    }
}
