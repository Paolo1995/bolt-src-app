package ee.mtakso.driver.ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NonSwipeableViewPager.kt */
/* loaded from: classes5.dex */
public final class NonSwipeableViewPager extends ViewPager {

    /* renamed from: q0  reason: collision with root package name */
    private boolean f34338q0;

    /* renamed from: r0  reason: collision with root package name */
    public Map<Integer, View> f34339r0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonSwipeableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        this.f34339r0 = new LinkedHashMap();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.f(event, "event");
        if (this.f34338q0) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.f(event, "event");
        if (this.f34338q0) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    public final void setIsSwipeEnabled(boolean z7) {
        this.f34338q0 = z7;
    }
}
