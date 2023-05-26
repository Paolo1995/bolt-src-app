package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener {

    /* renamed from: q  reason: collision with root package name */
    private static final RequestOptions f9792q = RequestOptions.q0(Bitmap.class).S();

    /* renamed from: r  reason: collision with root package name */
    private static final RequestOptions f9793r = RequestOptions.q0(GifDrawable.class).S();

    /* renamed from: s  reason: collision with root package name */
    private static final RequestOptions f9794s = RequestOptions.r0(DiskCacheStrategy.f10071c).c0(Priority.LOW).k0(true);

    /* renamed from: f  reason: collision with root package name */
    protected final Glide f9795f;

    /* renamed from: g  reason: collision with root package name */
    protected final Context f9796g;

    /* renamed from: h  reason: collision with root package name */
    final Lifecycle f9797h;

    /* renamed from: i  reason: collision with root package name */
    private final RequestTracker f9798i;

    /* renamed from: j  reason: collision with root package name */
    private final RequestManagerTreeNode f9799j;

    /* renamed from: k  reason: collision with root package name */
    private final TargetTracker f9800k;

    /* renamed from: l  reason: collision with root package name */
    private final Runnable f9801l;

    /* renamed from: m  reason: collision with root package name */
    private final ConnectivityMonitor f9802m;

    /* renamed from: n  reason: collision with root package name */
    private final CopyOnWriteArrayList<RequestListener<Object>> f9803n;

    /* renamed from: o  reason: collision with root package name */
    private RequestOptions f9804o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9805p;

    /* loaded from: classes.dex */
    private static class ClearTarget extends CustomViewTarget<View, Object> {
        ClearTarget(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void e(@NonNull Object obj, Transition<? super Object> transition) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void i(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        protected void m(Drawable drawable) {
        }
    }

    /* loaded from: classes.dex */
    private class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {

        /* renamed from: a  reason: collision with root package name */
        private final RequestTracker f9807a;

        RequestManagerConnectivityListener(@NonNull RequestTracker requestTracker) {
            this.f9807a = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void a(boolean z7) {
            if (z7) {
                synchronized (RequestManager.this) {
                    this.f9807a.e();
                }
            }
        }
    }

    public RequestManager(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.g(), context);
    }

    private void A(@NonNull Target<?> target) {
        boolean z7 = z(target);
        Request c8 = target.c();
        if (!z7 && !this.f9795f.p(target) && c8 != null) {
            target.g(null);
            c8.clear();
        }
    }

    @NonNull
    public <ResourceType> RequestBuilder<ResourceType> f(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.f9795f, this, cls, this.f9796g);
    }

    @NonNull
    public RequestBuilder<Bitmap> h() {
        return f(Bitmap.class).a(f9792q);
    }

    @NonNull
    public RequestBuilder<Drawable> j() {
        return f(Drawable.class);
    }

    @NonNull
    public RequestBuilder<GifDrawable> l() {
        return f(GifDrawable.class).a(f9793r);
    }

    public void m(@NonNull View view) {
        n(new ClearTarget(view));
    }

    public void n(Target<?> target) {
        if (target == null) {
            return;
        }
        A(target);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<RequestListener<Object>> o() {
        return this.f9803n;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        this.f9800k.onDestroy();
        for (Target<?> target : this.f9800k.h()) {
            n(target);
        }
        this.f9800k.f();
        this.f9798i.b();
        this.f9797h.a(this);
        this.f9797h.a(this.f9802m);
        Util.v(this.f9801l);
        this.f9795f.s(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        w();
        this.f9800k.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        v();
        this.f9800k.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i8) {
        if (i8 == 60 && this.f9805p) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized RequestOptions p() {
        return this.f9804o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public <T> TransitionOptions<?, T> q(Class<T> cls) {
        return this.f9795f.i().e(cls);
    }

    @NonNull
    public RequestBuilder<Drawable> r(Integer num) {
        return j().E0(num);
    }

    @NonNull
    public RequestBuilder<Drawable> s(String str) {
        return j().G0(str);
    }

    public synchronized void t() {
        this.f9798i.c();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f9798i + ", treeNode=" + this.f9799j + "}";
    }

    public synchronized void u() {
        t();
        for (RequestManager requestManager : this.f9799j.a()) {
            requestManager.t();
        }
    }

    public synchronized void v() {
        this.f9798i.d();
    }

    public synchronized void w() {
        this.f9798i.f();
    }

    protected synchronized void x(@NonNull RequestOptions requestOptions) {
        this.f9804o = requestOptions.clone().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void y(@NonNull Target<?> target, @NonNull Request request) {
        this.f9800k.j(target);
        this.f9798i.g(request);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean z(@NonNull Target<?> target) {
        Request c8 = target.c();
        if (c8 == null) {
            return true;
        }
        if (this.f9798i.a(c8)) {
            this.f9800k.l(target);
            target.g(null);
            return true;
        }
        return false;
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f9800k = new TargetTracker();
        Runnable runnable = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.f9797h.b(requestManager);
            }
        };
        this.f9801l = runnable;
        this.f9795f = glide;
        this.f9797h = lifecycle;
        this.f9799j = requestManagerTreeNode;
        this.f9798i = requestTracker;
        this.f9796g = context;
        ConnectivityMonitor a8 = connectivityMonitorFactory.a(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        this.f9802m = a8;
        if (Util.q()) {
            Util.u(runnable);
        } else {
            lifecycle.b(this);
        }
        lifecycle.b(a8);
        this.f9803n = new CopyOnWriteArrayList<>(glide.i().c());
        x(glide.i().d());
        glide.o(this);
    }
}
