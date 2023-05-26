package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final boolean D = Log.isLoggable("Request", 2);
    private int A;
    private boolean B;
    private RuntimeException C;

    /* renamed from: a  reason: collision with root package name */
    private final String f10682a;

    /* renamed from: b  reason: collision with root package name */
    private final StateVerifier f10683b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f10684c;

    /* renamed from: d  reason: collision with root package name */
    private final RequestListener<R> f10685d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestCoordinator f10686e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f10687f;

    /* renamed from: g  reason: collision with root package name */
    private final GlideContext f10688g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f10689h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<R> f10690i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseRequestOptions<?> f10691j;

    /* renamed from: k  reason: collision with root package name */
    private final int f10692k;

    /* renamed from: l  reason: collision with root package name */
    private final int f10693l;

    /* renamed from: m  reason: collision with root package name */
    private final Priority f10694m;

    /* renamed from: n  reason: collision with root package name */
    private final Target<R> f10695n;

    /* renamed from: o  reason: collision with root package name */
    private final List<RequestListener<R>> f10696o;

    /* renamed from: p  reason: collision with root package name */
    private final TransitionFactory<? super R> f10697p;

    /* renamed from: q  reason: collision with root package name */
    private final Executor f10698q;

    /* renamed from: r  reason: collision with root package name */
    private Resource<R> f10699r;

    /* renamed from: s  reason: collision with root package name */
    private Engine.LoadStatus f10700s;

    /* renamed from: t  reason: collision with root package name */
    private long f10701t;

    /* renamed from: u  reason: collision with root package name */
    private volatile Engine f10702u;

    /* renamed from: v  reason: collision with root package name */
    private Status f10703v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f10704w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f10705x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f10706y;

    /* renamed from: z  reason: collision with root package name */
    private int f10707z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, GlideContext glideContext, @NonNull Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i8, int i9, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.f10682a = D ? String.valueOf(super.hashCode()) : null;
        this.f10683b = StateVerifier.a();
        this.f10684c = obj;
        this.f10687f = context;
        this.f10688g = glideContext;
        this.f10689h = obj2;
        this.f10690i = cls;
        this.f10691j = baseRequestOptions;
        this.f10692k = i8;
        this.f10693l = i9;
        this.f10694m = priority;
        this.f10695n = target;
        this.f10685d = requestListener;
        this.f10696o = list;
        this.f10686e = requestCoordinator;
        this.f10702u = engine;
        this.f10697p = transitionFactory;
        this.f10698q = executor;
        this.f10703v = Status.PENDING;
        if (this.C == null && glideContext.g().a(GlideBuilder.LogRequestOrigins.class)) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    private void A(Resource<R> resource, R r7, DataSource dataSource, boolean z7) {
        boolean z8;
        boolean s7 = s();
        this.f10703v = Status.COMPLETE;
        this.f10699r = resource;
        if (this.f10688g.h() <= 3) {
            Log.d("Glide", "Finished loading " + r7.getClass().getSimpleName() + " from " + dataSource + " for " + this.f10689h + " with size [" + this.f10707z + "x" + this.A + "] in " + LogTime.a(this.f10701t) + " ms");
        }
        boolean z9 = true;
        this.B = true;
        try {
            List<RequestListener<R>> list = this.f10696o;
            if (list != null) {
                z8 = false;
                for (RequestListener<R> requestListener : list) {
                    z8 |= requestListener.j(r7, this.f10689h, this.f10695n, dataSource, s7);
                }
            } else {
                z8 = false;
            }
            RequestListener<R> requestListener2 = this.f10685d;
            if (requestListener2 == null || !requestListener2.j(r7, this.f10689h, this.f10695n, dataSource, s7)) {
                z9 = false;
            }
            if (!(z9 | z8)) {
                this.f10695n.e(r7, this.f10697p.a(dataSource, s7));
            }
            this.B = false;
            x();
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    private void B() {
        if (!m()) {
            return;
        }
        Drawable drawable = null;
        if (this.f10689h == null) {
            drawable = q();
        }
        if (drawable == null) {
            drawable = p();
        }
        if (drawable == null) {
            drawable = r();
        }
        this.f10695n.i(drawable);
    }

    private void k() {
        if (!this.B) {
            return;
        }
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f10686e;
        if (requestCoordinator != null && !requestCoordinator.k(this)) {
            return false;
        }
        return true;
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f10686e;
        if (requestCoordinator != null && !requestCoordinator.c(this)) {
            return false;
        }
        return true;
    }

    private boolean n() {
        RequestCoordinator requestCoordinator = this.f10686e;
        if (requestCoordinator != null && !requestCoordinator.d(this)) {
            return false;
        }
        return true;
    }

    private void o() {
        k();
        this.f10683b.c();
        this.f10695n.a(this);
        Engine.LoadStatus loadStatus = this.f10700s;
        if (loadStatus != null) {
            loadStatus.a();
            this.f10700s = null;
        }
    }

    private Drawable p() {
        if (this.f10704w == null) {
            Drawable n8 = this.f10691j.n();
            this.f10704w = n8;
            if (n8 == null && this.f10691j.m() > 0) {
                this.f10704w = t(this.f10691j.m());
            }
        }
        return this.f10704w;
    }

    private Drawable q() {
        if (this.f10706y == null) {
            Drawable o8 = this.f10691j.o();
            this.f10706y = o8;
            if (o8 == null && this.f10691j.p() > 0) {
                this.f10706y = t(this.f10691j.p());
            }
        }
        return this.f10706y;
    }

    private Drawable r() {
        if (this.f10705x == null) {
            Drawable u7 = this.f10691j.u();
            this.f10705x = u7;
            if (u7 == null && this.f10691j.v() > 0) {
                this.f10705x = t(this.f10691j.v());
            }
        }
        return this.f10705x;
    }

    private boolean s() {
        RequestCoordinator requestCoordinator = this.f10686e;
        if (requestCoordinator != null && requestCoordinator.getRoot().a()) {
            return false;
        }
        return true;
    }

    private Drawable t(int i8) {
        Resources.Theme theme;
        if (this.f10691j.C() != null) {
            theme = this.f10691j.C();
        } else {
            theme = this.f10687f.getTheme();
        }
        return DrawableDecoderCompat.a(this.f10688g, i8, theme);
    }

    private void u(String str) {
        Log.v("Request", str + " this: " + this.f10682a);
    }

    private static int v(int i8, float f8) {
        if (i8 != Integer.MIN_VALUE) {
            return Math.round(f8 * i8);
        }
        return i8;
    }

    private void w() {
        RequestCoordinator requestCoordinator = this.f10686e;
        if (requestCoordinator != null) {
            requestCoordinator.e(this);
        }
    }

    private void x() {
        RequestCoordinator requestCoordinator = this.f10686e;
        if (requestCoordinator != null) {
            requestCoordinator.g(this);
        }
    }

    public static <R> SingleRequest<R> y(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i8, int i9, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i8, i9, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private void z(GlideException glideException, int i8) {
        boolean z7;
        this.f10683b.c();
        synchronized (this.f10684c) {
            glideException.k(this.C);
            int h8 = this.f10688g.h();
            if (h8 <= i8) {
                Log.w("Glide", "Load failed for " + this.f10689h + " with size [" + this.f10707z + "x" + this.A + "]", glideException);
                if (h8 <= 4) {
                    glideException.g("Glide");
                }
            }
            this.f10700s = null;
            this.f10703v = Status.FAILED;
            boolean z8 = true;
            this.B = true;
            List<RequestListener<R>> list = this.f10696o;
            if (list != null) {
                z7 = false;
                for (RequestListener<R> requestListener : list) {
                    z7 |= requestListener.h(glideException, this.f10689h, this.f10695n, s());
                }
            } else {
                z7 = false;
            }
            RequestListener<R> requestListener2 = this.f10685d;
            if (requestListener2 == null || !requestListener2.h(glideException, this.f10689h, this.f10695n, s())) {
                z8 = false;
            }
            if (!(z7 | z8)) {
                B();
            }
            this.B = false;
            w();
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean a() {
        boolean z7;
        synchronized (this.f10684c) {
            if (this.f10703v == Status.COMPLETE) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public void b() {
        synchronized (this.f10684c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public void c(Resource<?> resource, DataSource dataSource, boolean z7) {
        Object obj;
        String str;
        this.f10683b.c();
        Resource<?> resource2 = null;
        try {
            synchronized (this.f10684c) {
                try {
                    this.f10700s = null;
                    if (resource == null) {
                        d(new GlideException("Expected to receive a Resource<R> with an object of " + this.f10690i + " inside, but instead got null."));
                        return;
                    }
                    Object obj2 = resource.get();
                    try {
                        if (obj2 != null && this.f10690i.isAssignableFrom(obj2.getClass())) {
                            if (!n()) {
                                this.f10699r = null;
                                this.f10703v = Status.COMPLETE;
                                this.f10702u.k(resource);
                                return;
                            }
                            A(resource, obj2, dataSource, z7);
                            return;
                        }
                        this.f10699r = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.f10690i);
                        sb.append(" but instead got ");
                        if (obj2 != null) {
                            obj = obj2.getClass();
                        } else {
                            obj = "";
                        }
                        sb.append(obj);
                        sb.append("{");
                        sb.append(obj2);
                        sb.append("} inside Resource{");
                        sb.append(resource);
                        sb.append("}.");
                        if (obj2 != null) {
                            str = "";
                        } else {
                            str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                        }
                        sb.append(str);
                        d(new GlideException(sb.toString()));
                        this.f10702u.k(resource);
                    } catch (Throwable th) {
                        resource2 = resource;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (resource2 != null) {
                this.f10702u.k(resource2);
            }
            throw th3;
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.f10684c) {
            k();
            this.f10683b.c();
            Status status = this.f10703v;
            Status status2 = Status.CLEARED;
            if (status == status2) {
                return;
            }
            o();
            Resource<R> resource = this.f10699r;
            if (resource != null) {
                this.f10699r = null;
            } else {
                resource = null;
            }
            if (l()) {
                this.f10695n.d(r());
            }
            this.f10703v = status2;
            if (resource != null) {
                this.f10702u.k(resource);
            }
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void d(GlideException glideException) {
        z(glideException, 5);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void e(int i8, int i9) {
        Object obj;
        this.f10683b.c();
        Object obj2 = this.f10684c;
        synchronized (obj2) {
            try {
                try {
                    boolean z7 = D;
                    if (z7) {
                        u("Got onSizeReady in " + LogTime.a(this.f10701t));
                    }
                    if (this.f10703v == Status.WAITING_FOR_SIZE) {
                        Status status = Status.RUNNING;
                        this.f10703v = status;
                        float B = this.f10691j.B();
                        this.f10707z = v(i8, B);
                        this.A = v(i9, B);
                        if (z7) {
                            u("finished setup for calling load in " + LogTime.a(this.f10701t));
                        }
                        obj = obj2;
                        try {
                            this.f10700s = this.f10702u.f(this.f10688g, this.f10689h, this.f10691j.A(), this.f10707z, this.A, this.f10691j.z(), this.f10690i, this.f10694m, this.f10691j.l(), this.f10691j.D(), this.f10691j.P(), this.f10691j.L(), this.f10691j.r(), this.f10691j.J(), this.f10691j.G(), this.f10691j.E(), this.f10691j.q(), this, this.f10698q);
                            if (this.f10703v != status) {
                                this.f10700s = null;
                            }
                            if (z7) {
                                u("finished onSizeReady in " + LogTime.a(this.f10701t));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean f() {
        boolean z7;
        synchronized (this.f10684c) {
            if (this.f10703v == Status.CLEARED) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public Object g() {
        this.f10683b.c();
        return this.f10684c;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean h() {
        boolean z7;
        synchronized (this.f10684c) {
            if (this.f10703v == Status.COMPLETE) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean i(Request request) {
        int i8;
        int i9;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int i10;
        int i11;
        int i12;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int i13;
        if (!(request instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f10684c) {
            i8 = this.f10692k;
            i9 = this.f10693l;
            obj = this.f10689h;
            cls = this.f10690i;
            baseRequestOptions = this.f10691j;
            priority = this.f10694m;
            List<RequestListener<R>> list = this.f10696o;
            if (list != null) {
                i10 = list.size();
            } else {
                i10 = 0;
            }
        }
        SingleRequest singleRequest = (SingleRequest) request;
        synchronized (singleRequest.f10684c) {
            i11 = singleRequest.f10692k;
            i12 = singleRequest.f10693l;
            obj2 = singleRequest.f10689h;
            cls2 = singleRequest.f10690i;
            baseRequestOptions2 = singleRequest.f10691j;
            priority2 = singleRequest.f10694m;
            List<RequestListener<R>> list2 = singleRequest.f10696o;
            if (list2 != null) {
                i13 = list2.size();
            } else {
                i13 = 0;
            }
        }
        if (i8 == i11 && i9 == i12 && Util.c(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && i10 == i13) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z7;
        synchronized (this.f10684c) {
            Status status = this.f10703v;
            if (status != Status.RUNNING && status != Status.WAITING_FOR_SIZE) {
                z7 = false;
            }
            z7 = true;
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public void j() {
        int i8;
        synchronized (this.f10684c) {
            k();
            this.f10683b.c();
            this.f10701t = LogTime.b();
            if (this.f10689h == null) {
                if (Util.t(this.f10692k, this.f10693l)) {
                    this.f10707z = this.f10692k;
                    this.A = this.f10693l;
                }
                if (q() == null) {
                    i8 = 5;
                } else {
                    i8 = 3;
                }
                z(new GlideException("Received null model"), i8);
                return;
            }
            Status status = this.f10703v;
            Status status2 = Status.RUNNING;
            if (status != status2) {
                if (status == Status.COMPLETE) {
                    c(this.f10699r, DataSource.MEMORY_CACHE, false);
                    return;
                }
                Status status3 = Status.WAITING_FOR_SIZE;
                this.f10703v = status3;
                if (Util.t(this.f10692k, this.f10693l)) {
                    e(this.f10692k, this.f10693l);
                } else {
                    this.f10695n.k(this);
                }
                Status status4 = this.f10703v;
                if ((status4 == status2 || status4 == status3) && m()) {
                    this.f10695n.b(r());
                }
                if (D) {
                    u("finished run method in " + LogTime.a(this.f10701t));
                }
                return;
            }
            throw new IllegalArgumentException("Cannot restart a running request");
        }
    }
}
