package androidx.viewpager2.widget;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.OnPageChangeCallback> f8149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeOnPageChangeCallback(int i8) {
        this.f8149a = new ArrayList(i8);
    }

    private void f(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void a(int i8) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.f8149a) {
                onPageChangeCallback.a(i8);
            }
        } catch (ConcurrentModificationException e8) {
            f(e8);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void b(int i8, float f8, int i9) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.f8149a) {
                onPageChangeCallback.b(i8, f8, i9);
            }
        } catch (ConcurrentModificationException e8) {
            f(e8);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void c(int i8) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.f8149a) {
                onPageChangeCallback.c(i8);
            }
        } catch (ConcurrentModificationException e8) {
            f(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f8149a.add(onPageChangeCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f8149a.remove(onPageChangeCallback);
    }
}
