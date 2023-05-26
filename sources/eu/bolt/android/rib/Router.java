package eu.bolt.android.rib;

import android.os.Looper;
import eu.bolt.android.rib.flipper.FlipperRibEventBus;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Router.kt */
/* loaded from: classes5.dex */
public class Router {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f37075h = new Companion(null);

    /* renamed from: i  reason: collision with root package name */
    private static final String f37076i = "Router.childRouters";

    /* renamed from: a  reason: collision with root package name */
    private final RibLifecycleSubject f37077a;

    /* renamed from: b  reason: collision with root package name */
    private final Thread f37078b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Router> f37079c;

    /* renamed from: d  reason: collision with root package name */
    private String f37080d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f37081e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37082f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f37083g;

    /* compiled from: Router.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Thread c() {
            try {
                Thread thread = Looper.getMainLooper().getThread();
                Intrinsics.e(thread, "{\n                Looper…er().thread\n            }");
                return thread;
            } catch (Exception unused) {
                Thread currentThread = Thread.currentThread();
                Intrinsics.e(currentThread, "{\n                Thread…entThread()\n            }");
                return currentThread;
            }
        }

        protected final String b() {
            return Router.f37076i;
        }
    }

    public Router(RibLifecycleSubject interactor, Thread mainThread) {
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(mainThread, "mainThread");
        this.f37077a = interactor;
        this.f37078b = mainThread;
        this.f37079c = new CopyOnWriteArrayList();
    }

    private final void d() {
        if (this.f37078b == Thread.currentThread()) {
            return;
        }
        throw new RequiresMainThreadException("Call must happen on the main thread", new IllegalStateException("Call must happen on the main thread"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final String m() {
        return f37075h.b();
    }

    private final void u(Bundle bundle) {
        if (x()) {
            if (bundle == null && !this.f37083g) {
                this.f37077a.s();
            } else {
                this.f37077a.k();
            }
            this.f37077a.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Router childRouter, String tag) {
        Intrinsics.f(childRouter, "childRouter");
        Intrinsics.f(tag, "tag");
        Preconditions.b();
        for (Router router : this.f37079c) {
            if (Intrinsics.a(tag, router.r())) {
                RibLogger.f37068a.b("There is already a child router with tag: %s");
            }
        }
        this.f37079c.add(childRouter);
        childRouter.i(n(this.f37081e, tag), tag);
        FlipperRibEventBus.f37128a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Bundle savedState, String tag) {
        Intrinsics.f(savedState, "savedState");
        Intrinsics.f(tag, "tag");
        Object a8 = Preconditions.a(savedState.c(f37076i));
        Intrinsics.e(a8, "checkNotNull(savedState.…leExtra(childRoutersKey))");
        ((Bundle) a8).g(tag, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(Router childRouter, boolean z7) {
        Intrinsics.f(childRouter, "childRouter");
        Preconditions.b();
        this.f37079c.remove(childRouter);
        Bundle bundle = this.f37081e;
        if (bundle != null) {
            e(bundle, childRouter.r());
        }
        childRouter.j(z7);
        FlipperRibEventBus.f37128a.a();
    }

    protected final void g() {
    }

    public final void h(Bundle bundle) {
        i(bundle, getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Bundle bundle, String str) {
        d();
        if (!this.f37082f) {
            this.f37082f = true;
            g();
        }
        this.f37081e = bundle;
        w(str);
        y();
        Bundle bundle2 = null;
        Bundle bundle3 = this.f37081e;
        if (bundle3 != null) {
            bundle2 = bundle3.c("Router.interactor");
            this.f37083g = true;
        }
        this.f37077a.l(bundle2);
        u(bundle);
    }

    public void j(boolean z7) {
        d();
        this.f37083g = true;
        this.f37077a.h();
        z();
        for (Router router : this.f37079c) {
            f(router, z7);
        }
    }

    public void k() {
        this.f37077a.v();
    }

    public void l() {
        this.f37077a.w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle n(Bundle bundle, String tag) {
        Bundle c8;
        Intrinsics.f(tag, "tag");
        if (bundle == null || (c8 = bundle.c(f37076i)) == null) {
            return null;
        }
        return c8.c(tag);
    }

    public final List<Router> o() {
        return this.f37079c;
    }

    public final RibLifecycleSubject p() {
        return this.f37077a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<Router> q() {
        return this.f37079c;
    }

    public final String r() {
        String str = this.f37080d;
        if (str == null) {
            String simpleName = getClass().getSimpleName();
            int identityHashCode = System.identityHashCode(this);
            return simpleName + "_" + identityHashCode;
        }
        return str;
    }

    public boolean s() {
        boolean z7;
        RibLifecycleSubject ribLifecycleSubject = this.f37077a;
        if (this.f37079c.size() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        return ribLifecycleSubject.z(z7);
    }

    public final boolean t() {
        return !this.f37079c.isEmpty();
    }

    public void v(Bundle outState) {
        Intrinsics.f(outState, "outState");
        Bundle interactorSavedInstanceState = Bundle.a();
        RibLifecycleSubject ribLifecycleSubject = this.f37077a;
        Intrinsics.e(interactorSavedInstanceState, "interactorSavedInstanceState");
        ribLifecycleSubject.x(interactorSavedInstanceState);
        outState.g("Router.interactor", interactorSavedInstanceState);
        Bundle a8 = Bundle.a();
        for (Router router : this.f37079c) {
            Bundle childBundle = Bundle.a();
            Intrinsics.e(childBundle, "childBundle");
            router.v(childBundle);
            a8.g(router.r(), childBundle);
        }
        outState.g(f37076i, a8);
    }

    public final void w(String str) {
        this.f37080d = str;
    }

    protected boolean x() {
        return true;
    }

    protected final void y() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Router(RibLifecycleSubject interactor) {
        this(interactor, f37075h.c());
        Intrinsics.f(interactor, "interactor");
    }
}
