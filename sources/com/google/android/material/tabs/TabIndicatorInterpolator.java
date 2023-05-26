package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TabIndicatorInterpolator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (!tabLayout.D() && (view instanceof TabLayout.TabView)) {
            return b((TabLayout.TabView) view, 24);
        }
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static RectF b(@NonNull TabLayout.TabView tabView, int i8) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int c8 = (int) ViewUtils.c(tabView.getContext(), i8);
        if (contentWidth < c8) {
            contentWidth = c8;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i9 = contentWidth / 2;
        return new RectF(left - i9, top - (contentHeight / 2), i9 + left, top + (left / 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF a8 = a(tabLayout, view);
        drawable.setBounds((int) a8.left, drawable.getBounds().top, (int) a8.right, drawable.getBounds().bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, View view2, float f8, @NonNull Drawable drawable) {
        RectF a8 = a(tabLayout, view);
        RectF a9 = a(tabLayout, view2);
        drawable.setBounds(AnimationUtils.c((int) a8.left, (int) a9.left, f8), drawable.getBounds().top, AnimationUtils.c((int) a8.right, (int) a9.right, f8), drawable.getBounds().bottom);
    }
}
