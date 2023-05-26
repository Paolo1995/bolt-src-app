package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f1489c;

    /* renamed from: d  reason: collision with root package name */
    ViewPropertyAnimatorListener f1490d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1491e;

    /* renamed from: b  reason: collision with root package name */
    private long f1488b = -1;

    /* renamed from: f  reason: collision with root package name */
    private final ViewPropertyAnimatorListenerAdapter f1492f = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1

        /* renamed from: a  reason: collision with root package name */
        private boolean f1493a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f1494b = 0;

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void b(View view) {
            int i8 = this.f1494b + 1;
            this.f1494b = i8;
            if (i8 == ViewPropertyAnimatorCompatSet.this.f1487a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f1490d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.b(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void c(View view) {
            if (this.f1493a) {
                return;
            }
            this.f1493a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f1490d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.c(null);
            }
        }

        void d() {
            this.f1494b = 0;
            this.f1493a = false;
            ViewPropertyAnimatorCompatSet.this.b();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<ViewPropertyAnimatorCompat> f1487a = new ArrayList<>();

    public void a() {
        if (!this.f1491e) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> it = this.f1487a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.f1491e = false;
    }

    void b() {
        this.f1491e = false;
    }

    public ViewPropertyAnimatorCompatSet c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f1491e) {
            this.f1487a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f1487a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.j(viewPropertyAnimatorCompat.d());
        this.f1487a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet e(long j8) {
        if (!this.f1491e) {
            this.f1488b = j8;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet f(Interpolator interpolator) {
        if (!this.f1491e) {
            this.f1489c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet g(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f1491e) {
            this.f1490d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void h() {
        if (this.f1491e) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> it = this.f1487a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat next = it.next();
            long j8 = this.f1488b;
            if (j8 >= 0) {
                next.f(j8);
            }
            Interpolator interpolator = this.f1489c;
            if (interpolator != null) {
                next.g(interpolator);
            }
            if (this.f1490d != null) {
                next.h(this.f1492f);
            }
            next.l();
        }
        this.f1491e = true;
    }
}
