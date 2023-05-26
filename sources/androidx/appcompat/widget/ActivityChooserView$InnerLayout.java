package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f1808f = {16842964};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray u7 = TintTypedArray.u(context, attributeSet, f1808f);
        setBackgroundDrawable(u7.g(0));
        u7.w();
    }
}
