package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* renamed from: a  reason: collision with root package name */
    private int f14527a;

    public ExpandableBehavior() {
        this.f14527a = 0;
    }

    private boolean F(boolean z7) {
        if (z7) {
            int i8 = this.f14527a;
            if (i8 != 0 && i8 != 2) {
                return false;
            }
            return true;
        } else if (this.f14527a != 1) {
            return false;
        } else {
            return true;
        }
    }

    protected ExpandableWidget G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> s7 = coordinatorLayout.s(view);
        int size = s7.size();
        for (int i8 = 0; i8 < size; i8++) {
            View view2 = s7.get(i8);
            if (e(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    protected abstract boolean H(View view, View view2, boolean z7, boolean z8);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i8;
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (F(expandableWidget.a())) {
            if (expandableWidget.a()) {
                i8 = 1;
            } else {
                i8 = 2;
            }
            this.f14527a = i8;
            return H((View) expandableWidget, view, expandableWidget.a(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull final View view, int i8) {
        final ExpandableWidget G;
        final int i9;
        if (!ViewCompat.W(view) && (G = G(coordinatorLayout, view)) != null && F(G.a())) {
            if (G.a()) {
                i9 = 1;
            } else {
                i9 = 2;
            }
            this.f14527a = i9;
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    view.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (ExpandableBehavior.this.f14527a == i9) {
                        ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                        ExpandableWidget expandableWidget = G;
                        expandableBehavior.H((View) expandableWidget, view, expandableWidget.a(), false);
                    }
                    return false;
                }
            });
            return false;
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14527a = 0;
    }
}
