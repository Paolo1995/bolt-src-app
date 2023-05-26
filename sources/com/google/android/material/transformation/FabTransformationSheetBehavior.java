package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: i  reason: collision with root package name */
    private Map<View, Integer> f14558i;

    public FabTransformationSheetBehavior() {
    }

    private void g0(@NonNull View view, boolean z7) {
        boolean z8;
        ViewParent parent = view.getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z7) {
            this.f14558i = new HashMap(childCount);
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = coordinatorLayout.getChildAt(i8);
            if ((childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior)) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (childAt != view && !z8) {
                if (!z7) {
                    Map<View, Integer> map = this.f14558i;
                    if (map != null && map.containsKey(childAt)) {
                        ViewCompat.D0(childAt, this.f14558i.get(childAt).intValue());
                    }
                } else {
                    this.f14558i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.D0(childAt, 4);
                }
            }
        }
        if (!z7) {
            this.f14558i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean H(@NonNull View view, @NonNull View view2, boolean z7, boolean z8) {
        g0(view2, z7);
        return super.H(view, view2, z7, z8);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @NonNull
    protected FabTransformationBehavior.FabTransformationSpec e0(Context context, boolean z7) {
        int i8;
        if (z7) {
            i8 = R$animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i8 = R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.f14551a = MotionSpec.d(context, i8);
        fabTransformationSpec.f14552b = new Positioning(17, 0.0f, 0.0f);
        return fabTransformationSpec;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
