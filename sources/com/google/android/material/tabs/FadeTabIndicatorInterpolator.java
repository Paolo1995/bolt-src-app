package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FadeTabIndicatorInterpolator extends TabIndicatorInterpolator {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public void d(TabLayout tabLayout, View view, View view2, float f8, @NonNull Drawable drawable) {
        float b8;
        int i8 = (f8 > 0.5f ? 1 : (f8 == 0.5f ? 0 : -1));
        if (i8 >= 0) {
            view = view2;
        }
        RectF a8 = TabIndicatorInterpolator.a(tabLayout, view);
        if (i8 < 0) {
            b8 = AnimationUtils.b(1.0f, 0.0f, 0.0f, 0.5f, f8);
        } else {
            b8 = AnimationUtils.b(0.0f, 1.0f, 0.5f, 1.0f, f8);
        }
        drawable.setBounds((int) a8.left, drawable.getBounds().top, (int) a8.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (b8 * 255.0f));
    }
}
