package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    private static float e(float f8) {
        return (float) (1.0d - Math.cos((f8 * 3.141592653589793d) / 2.0d));
    }

    private static float f(float f8) {
        return (float) Math.sin((f8 * 3.141592653589793d) / 2.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public void d(TabLayout tabLayout, View view, View view2, float f8, @NonNull Drawable drawable) {
        boolean z7;
        float f9;
        float e8;
        RectF a8 = TabIndicatorInterpolator.a(tabLayout, view);
        RectF a9 = TabIndicatorInterpolator.a(tabLayout, view2);
        if (a8.left < a9.left) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            f9 = e(f8);
            e8 = f(f8);
        } else {
            f9 = f(f8);
            e8 = e(f8);
        }
        drawable.setBounds(AnimationUtils.c((int) a8.left, (int) a9.left, f9), drawable.getBounds().top, AnimationUtils.c((int) a8.right, (int) a9.right, e8), drawable.getBounds().bottom);
    }
}
