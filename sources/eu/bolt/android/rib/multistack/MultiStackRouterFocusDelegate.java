package eu.bolt.android.rib.multistack;

import eu.bolt.android.rib.Router;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiStackRouterFocusDelegate.kt */
/* loaded from: classes5.dex */
public final class MultiStackRouterFocusDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final BaseMultiStackRouter<?, ?> f37227a;

    /* renamed from: b  reason: collision with root package name */
    private final MultiStackRouterEventsRepository f37228b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37229c;

    public MultiStackRouterFocusDelegate(BaseMultiStackRouter<?, ?> router, MultiStackRouterEventsRepository eventsRepository) {
        Intrinsics.f(router, "router");
        Intrinsics.f(eventsRepository, "eventsRepository");
        this.f37227a = router;
        this.f37228b = eventsRepository;
    }

    private final void g(String str) {
        Router router;
        if (str != null) {
            router = this.f37227a.o0(str);
        } else {
            router = null;
        }
        if (router == null) {
            this.f37227a.p().v();
        } else {
            router.k();
        }
    }

    private final Router k() {
        String j8 = j();
        if (j8 != null) {
            return this.f37227a.o0(j8);
        }
        return null;
    }

    public final void a() {
        this.f37229c = false;
    }

    public final void b(String stackKey, String str) {
        Intrinsics.f(stackKey, "stackKey");
        if (this.f37229c) {
            String j8 = j();
            if (Intrinsics.a(stackKey, str) && !Intrinsics.a(stackKey, j8)) {
                Router o02 = this.f37227a.o0(stackKey);
                if (o02 != null) {
                    o02.k();
                }
                i();
            }
        }
    }

    public final void c(String newFocusedKey, String str) {
        Intrinsics.f(newFocusedKey, "newFocusedKey");
        if (this.f37229c && !Intrinsics.a(newFocusedKey, str)) {
            g(str);
            i();
        }
    }

    public final void d(String poppedStackKey, String str) {
        Intrinsics.f(poppedStackKey, "poppedStackKey");
        if (this.f37229c && Intrinsics.a(poppedStackKey, str)) {
            i();
        }
    }

    public final void e(String newFocusedKey, String str) {
        Intrinsics.f(newFocusedKey, "newFocusedKey");
        if (this.f37229c) {
            if (!Intrinsics.a(newFocusedKey, str)) {
                g(str);
            }
            i();
        }
    }

    public final void f(String modifiedStackKey, String str) {
        Intrinsics.f(modifiedStackKey, "modifiedStackKey");
        if (!this.f37229c) {
            return;
        }
        if (!Intrinsics.a(str, modifiedStackKey)) {
            if (this.f37227a.o0(modifiedStackKey) != null) {
                g(str);
                i();
                return;
            }
            return;
        }
        i();
    }

    public final void h() {
        this.f37229c = false;
        this.f37227a.p().v();
        Router k8 = k();
        if (k8 != null) {
            k8.k();
        }
    }

    public final void i() {
        this.f37229c = true;
        this.f37227a.p().w();
        Router k8 = k();
        if (k8 != null) {
            k8.l();
        }
    }

    public final String j() {
        if (this.f37228b.f()) {
            return this.f37228b.d().a();
        }
        return null;
    }
}
