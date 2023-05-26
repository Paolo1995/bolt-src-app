package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class EditState extends UIThreadSet<Activity> {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f19458b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<ViewVisitor>> f19459c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Set<EditBinding> f19460d = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class EditBinding implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {

        /* renamed from: h  reason: collision with root package name */
        private final WeakReference<View> f19464h;

        /* renamed from: i  reason: collision with root package name */
        private final ViewVisitor f19465i;

        /* renamed from: j  reason: collision with root package name */
        private final Handler f19466j;

        /* renamed from: g  reason: collision with root package name */
        private boolean f19463g = true;

        /* renamed from: f  reason: collision with root package name */
        private volatile boolean f19462f = false;

        public EditBinding(View view, ViewVisitor viewVisitor, Handler handler) {
            this.f19465i = viewVisitor;
            this.f19464h = new WeakReference<>(view);
            this.f19466j = handler;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        private void a() {
            if (this.f19463g) {
                View view = this.f19464h.get();
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
                this.f19465i.b();
            }
            this.f19463g = false;
        }

        public void b() {
            this.f19462f = true;
            this.f19466j.post(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f19463g) {
                return;
            }
            View view = this.f19464h.get();
            if (view != null && !this.f19462f) {
                this.f19465i.e(view);
                this.f19466j.removeCallbacks(this);
                this.f19466j.postDelayed(this, 1000L);
                return;
            }
            a();
        }
    }

    private void f(View view, List<ViewVisitor> list) {
        synchronized (this.f19460d) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                this.f19460d.add(new EditBinding(view, list.get(i8), this.f19458b));
            }
        }
    }

    private void g() {
        if (Thread.currentThread() == this.f19458b.getLooper().getThread()) {
            h();
        } else {
            this.f19458b.post(new Runnable() { // from class: com.mixpanel.android.viewcrawler.EditState.1
                @Override // java.lang.Runnable
                public void run() {
                    EditState.this.h();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        List<ViewVisitor> list;
        List<ViewVisitor> list2;
        for (Activity activity : b()) {
            String canonicalName = activity.getClass().getCanonicalName();
            View rootView = activity.getWindow().getDecorView().getRootView();
            synchronized (this.f19459c) {
                list = this.f19459c.get(canonicalName);
                list2 = this.f19459c.get(null);
            }
            if (list != null) {
                f(rootView, list);
            }
            if (list2 != null) {
                f(rootView, list2);
            }
        }
    }

    public void e(Activity activity) {
        super.a(activity);
        g();
    }

    public void i(Activity activity) {
        super.c(activity);
    }

    public void j(Map<String, List<ViewVisitor>> map) {
        synchronized (this.f19460d) {
            for (EditBinding editBinding : this.f19460d) {
                editBinding.b();
            }
            this.f19460d.clear();
        }
        synchronized (this.f19459c) {
            this.f19459c.clear();
            this.f19459c.putAll(map);
        }
        g();
    }
}
