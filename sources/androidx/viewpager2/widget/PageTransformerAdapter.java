package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f8153a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager2.PageTransformer f8154b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f8153a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void a(int i8) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void b(int i8, float f8, int i9) {
        if (this.f8154b == null) {
            return;
        }
        float f9 = -f8;
        for (int i10 = 0; i10 < this.f8153a.U(); i10++) {
            View T = this.f8153a.T(i10);
            if (T != null) {
                this.f8154b.a(T, (this.f8153a.o0(T) - i8) + f9);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i10), Integer.valueOf(this.f8153a.U())));
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void c(int i8) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPager2.PageTransformer d() {
        return this.f8154b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ViewPager2.PageTransformer pageTransformer) {
        this.f8154b = pageTransformer;
    }
}
