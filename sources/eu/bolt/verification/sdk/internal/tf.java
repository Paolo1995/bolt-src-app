package eu.bolt.verification.sdk.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.android.rib.lifecycle.ActivityCallbackEvent;
import eu.bolt.logger.Logger;
import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.am;
import eu.bolt.verification.sdk.internal.gc;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.subjects.SingleSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class tf implements sf {

    /* renamed from: h  reason: collision with root package name */
    public static final a f45171h = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final FragmentActivity f45172a;

    /* renamed from: b  reason: collision with root package name */
    private final qf f45173b;

    /* renamed from: c  reason: collision with root package name */
    private final yg f45174c;

    /* renamed from: d  reason: collision with root package name */
    private final am f45175d;

    /* renamed from: e  reason: collision with root package name */
    private final RxActivityEvents f45176e;

    /* renamed from: f  reason: collision with root package name */
    private b f45177f;

    /* renamed from: g  reason: collision with root package name */
    private final Logger f45178g;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<je> f45179a;

        /* renamed from: b  reason: collision with root package name */
        private final SingleSubject<Boolean> f45180b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends je> permissions, SingleSubject<Boolean> signaller) {
            Intrinsics.f(permissions, "permissions");
            Intrinsics.f(signaller, "signaller");
            this.f45179a = permissions;
            this.f45180b = signaller;
        }

        public final List<je> a() {
            return this.f45179a;
        }

        public final SingleSubject<Boolean> b() {
            return this.f45180b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<Boolean, vf> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f45181f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final vf invoke(Boolean it) {
            Intrinsics.f(it, "it");
            return new vf(it.booleanValue(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<Boolean, vf> {

        /* renamed from: f  reason: collision with root package name */
        public static final d f45182f = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final vf invoke(Boolean it) {
            Intrinsics.f(it, "it");
            return new vf(it.booleanValue(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<ActivityCallbackEvent, Unit> {
        e() {
            super(1);
        }

        public final void b(ActivityCallbackEvent it) {
            Intrinsics.f(it, "it");
            if ((it instanceof ActivityCallbackEvent.ActivityResult) && ((ActivityCallbackEvent.ActivityResult) it).f() == 129) {
                b bVar = tf.this.f45177f;
                if (bVar == null) {
                    tf.this.K();
                    return;
                }
                boolean A = tf.this.A(bVar.a());
                Logger logger = tf.this.f45178g;
                List<je> a8 = bVar.a();
                logger.b("Checking permissions on resume: " + a8 + " granted=[" + A + "]");
                bVar.b().onSuccess(Boolean.valueOf(A));
                tf.this.f45177f = null;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityCallbackEvent activityCallbackEvent) {
            b(activityCallbackEvent);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class f extends Lambda implements Function1<Boolean, SingleSource<? extends Boolean>> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ List<je> f45185g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(List<? extends je> list) {
            super(1);
            this.f45185g = list;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends Boolean> invoke(Boolean openSettings) {
            Intrinsics.f(openSettings, "openSettings");
            Logger logger = tf.this.f45178g;
            List<je> list = this.f45185g;
            logger.b("Can open settings [" + openSettings + "] for " + list);
            if (openSettings.booleanValue()) {
                SingleSubject Z = SingleSubject.Z();
                Intrinsics.e(Z, "create<Boolean>()");
                tf.this.f45177f = new b(this.f45185g, Z);
                tf.this.F();
                return Z;
            }
            return Single.w(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g extends Lambda implements Function1<Boolean, SingleSource<? extends vf>> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ List<je> f45187g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ pe f45188h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(List<? extends je> list, pe peVar) {
            super(1);
            this.f45187g = list;
            this.f45188h = peVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends vf> invoke(Boolean granted) {
            Intrinsics.f(granted, "granted");
            return tf.this.t(this.f45187g, this.f45188h, granted.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class h extends Lambda implements Function1<List<vf>, Boolean> {

        /* renamed from: f  reason: collision with root package name */
        public static final h f45189f = new h();

        h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(List<vf> result) {
            boolean z7;
            Intrinsics.f(result, "result");
            if (!(result instanceof Collection) || !result.isEmpty()) {
                for (vf vfVar : result) {
                    if (vfVar.a()) {
                        z7 = true;
                        break;
                    }
                }
            }
            z7 = false;
            return Boolean.valueOf(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class i extends Lambda implements Function1<Boolean, SingleSource<? extends vf>> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ List<je> f45191g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ pe f45192h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        i(List<? extends je> list, pe peVar) {
            super(1);
            this.f45191g = list;
            this.f45192h = peVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends vf> invoke(Boolean granted) {
            Intrinsics.f(granted, "granted");
            return tf.this.t(this.f45191g, this.f45192h, granted.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class j extends Lambda implements Function1<Unit, SingleSource<? extends vf>> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ List<je> f45194g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f45195h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        j(List<? extends je> list, boolean z7) {
            super(1);
            this.f45194g = list;
            this.f45195h = z7;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends vf> invoke(Unit it) {
            Intrinsics.f(it, "it");
            return tf.this.u(this.f45194g, this.f45195h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class k extends Lambda implements Function1<Boolean, vf> {

        /* renamed from: f  reason: collision with root package name */
        public static final k f45196f = new k();

        k() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final vf invoke(Boolean it) {
            Intrinsics.f(it, "it");
            return new vf(it.booleanValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class l extends Lambda implements Function1<List<vf>, Boolean> {

        /* renamed from: f  reason: collision with root package name */
        public static final l f45197f = new l();

        l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(List<vf> result) {
            boolean z7;
            Intrinsics.f(result, "result");
            if (!(result instanceof Collection) || !result.isEmpty()) {
                for (vf vfVar : result) {
                    if (vfVar.a()) {
                        z7 = true;
                        break;
                    }
                }
            }
            z7 = false;
            return Boolean.valueOf(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class m extends Lambda implements Function1<Boolean, vf> {

        /* renamed from: f  reason: collision with root package name */
        public static final m f45198f = new m();

        m() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final vf invoke(Boolean it) {
            Intrinsics.f(it, "it");
            return new vf(it.booleanValue(), true);
        }
    }

    @Inject
    public tf(FragmentActivity activity, qf permissionDelegate, yg rxSharedPreferences, am updateLocationPermissionStateInteractor, RxActivityEvents rxActivityEvents) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(permissionDelegate, "permissionDelegate");
        Intrinsics.f(rxSharedPreferences, "rxSharedPreferences");
        Intrinsics.f(updateLocationPermissionStateInteractor, "updateLocationPermissionStateInteractor");
        Intrinsics.f(rxActivityEvents, "rxActivityEvents");
        this.f45172a = activity;
        this.f45173b = permissionDelegate;
        this.f45174c = rxSharedPreferences;
        this.f45175d = updateLocationPermissionStateInteractor;
        this.f45176e = rxActivityEvents;
        this.f45178g = ac.b.f42045b.c();
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(List<? extends je> list) {
        boolean z7;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (je jeVar : list) {
                if (ContextCompat.checkSelfPermission(this.f45172a, jeVar.c()) == 0) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (!z7) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vf C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (vf) tmp0.invoke(obj);
    }

    private final Single<vf> D(List<? extends je> list, pe peVar) {
        Single<Boolean> d8 = this.f45173b.d(list);
        final g gVar = new g(list, peVar);
        Single r7 = d8.r(new Function() { // from class: eu.bolt.verification.sdk.internal.mw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource N;
                N = tf.N(Function1.this, obj);
                return N;
            }
        });
        Intrinsics.e(r7, "private fun requestAllDe…ndler, granted)\n        }");
        return r7;
    }

    private final Single<vf> E(List<? extends je> list, pe peVar, boolean z7) {
        if (Build.VERSION.SDK_INT > 29) {
            return z7 ? D(list, peVar) : M(list, peVar);
        }
        Single<Boolean> s7 = s(list, peVar);
        final d dVar = d.f45182f;
        Single x7 = s7.x(new Function() { // from class: eu.bolt.verification.sdk.internal.lw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                vf C;
                C = tf.C(Function1.this, obj);
                return C;
            }
        });
        Intrinsics.e(x7, "openSettingsIfAllowed(pe…issionResult(it, false) }");
        return x7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f45172a.getPackageName(), null));
        this.f45172a.startActivityForResult(intent, 129);
    }

    private final boolean G(List<? extends je> list) {
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            je jeVar = (je) it.next();
            af<Boolean> d8 = this.f45174c.d(v(jeVar), Boolean.FALSE);
            Intrinsics.e(d8, "rxSharedPreferences.getB…uestedPrefKey(it), false)");
            boolean z7 = !d8.get().booleanValue();
            if (ActivityCompat.j(this.f45172a, jeVar.c()) || z7) {
                d8.set(Boolean.TRUE);
                return true;
            }
            return false;
        }
        return true;
    }

    private final Single<vf> I(final List<? extends je> list, final pe peVar, boolean z7) {
        Single<vf> r7;
        String str;
        if (A(list)) {
            Logger logger = this.f45178g;
            logger.b("Permissions are granted: " + list);
            r7 = Single.w(new vf(true, false));
            str = "{\n            logger.i(\"…ialog = false))\n        }";
        } else if (!G(list)) {
            Logger logger2 = this.f45178g;
            logger2.b("Permissions are denied: " + list);
            return E(list, peVar, z7);
        } else {
            Logger logger3 = this.f45178g;
            logger3.b("Permissions can be requested via system dialog: " + list);
            Single u7 = Single.u(new Callable() { // from class: eu.bolt.verification.sdk.internal.fw
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Unit w7;
                    w7 = tf.w(pe.this, list);
                    return w7;
                }
            });
            final j jVar = new j(list, z7);
            r7 = u7.r(new Function() { // from class: eu.bolt.verification.sdk.internal.hw
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    SingleSource R;
                    R = tf.R(Function1.this, obj);
                    return R;
                }
            });
            str = "private fun requestPermi…Required)\n        }\n    }";
        }
        Intrinsics.e(r7, str);
        return r7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        ug.p(this.f45175d.b(am.a.C0029a.f42097a), null, null, null, 7, null);
    }

    private final Single<vf> M(List<? extends je> list, pe peVar) {
        Single<List<vf>> f8 = this.f45173b.f(list);
        final h hVar = h.f45189f;
        Single<R> x7 = f8.x(new Function() { // from class: eu.bolt.verification.sdk.internal.ow
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean P;
                P = tf.P(Function1.this, obj);
                return P;
            }
        });
        final i iVar = new i(list, peVar);
        Single<vf> r7 = x7.r(new Function() { // from class: eu.bolt.verification.sdk.internal.pw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource Q;
                Q = tf.Q(Function1.this, obj);
                return Q;
            }
        });
        Intrinsics.e(r7, "private fun requestAtLea…ndler, granted)\n        }");
        return r7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vf S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (vf) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vf U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (vf) tmp0.invoke(obj);
    }

    private final pe n(gc gcVar) {
        if (gcVar instanceof gc.a) {
            return new x3(this.f45172a, ((gc.a) gcVar).a());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vf o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (vf) tmp0.invoke(obj);
    }

    private final Single<Boolean> s(List<? extends je> list, pe peVar) {
        Single<Boolean> l8 = peVar.l(list);
        final f fVar = new f(list);
        Single r7 = l8.r(new Function() { // from class: eu.bolt.verification.sdk.internal.nw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource J;
                J = tf.J(Function1.this, obj);
                return J;
            }
        });
        Intrinsics.e(r7, "private fun openSettings…)\n            }\n        }");
        return r7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<vf> t(List<? extends je> list, pe peVar, boolean z7) {
        String str;
        Single single;
        boolean z8;
        boolean z9 = false;
        if (!z7) {
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (je jeVar : list) {
                    if (!ActivityCompat.j(this.f45172a, jeVar.c())) {
                        z8 = false;
                        break;
                    }
                }
            }
            z8 = true;
            if (z8) {
                z9 = true;
            }
        }
        Logger logger = this.f45178g;
        logger.b("Requested permissions with result [" + z7 + "]: " + list);
        if (z7 || z9) {
            str = "{\n            Single.jus…granted, true))\n        }";
            single = Single.w(new vf(z7, true));
        } else {
            Single<Boolean> s7 = s(list, peVar);
            final c cVar = c.f45181f;
            str = "{\n            openSettin…lt(it, false) }\n        }";
            single = s7.x(new Function() { // from class: eu.bolt.verification.sdk.internal.gw
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    vf o8;
                    o8 = tf.o(Function1.this, obj);
                    return o8;
                }
            });
        }
        Intrinsics.e(single, str);
        return single;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<vf> u(List<? extends je> list, boolean z7) {
        Single x7;
        Function function;
        if (z7) {
            x7 = this.f45173b.d(list);
            final k kVar = k.f45196f;
            function = new Function() { // from class: eu.bolt.verification.sdk.internal.iw
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    vf S;
                    S = tf.S(Function1.this, obj);
                    return S;
                }
            };
        } else {
            Single<List<vf>> f8 = this.f45173b.f(list);
            final l lVar = l.f45197f;
            x7 = f8.x(new Function() { // from class: eu.bolt.verification.sdk.internal.jw
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Boolean T;
                    T = tf.T(Function1.this, obj);
                    return T;
                }
            });
            final m mVar = m.f45198f;
            function = new Function() { // from class: eu.bolt.verification.sdk.internal.kw
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    vf U;
                    U = tf.U(Function1.this, obj);
                    return U;
                }
            };
        }
        Single<vf> x8 = x7.x(function);
        Intrinsics.e(x8, "{\n        permissionDele…nResult(it, true) }\n    }");
        return x8;
    }

    private final String v(je jeVar) {
        String c8 = jeVar.c();
        return "requested_" + c8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(pe permissionHandler, List permissions) {
        Intrinsics.f(permissionHandler, "$permissionHandler");
        Intrinsics.f(permissions, "$permissions");
        permissionHandler.k(permissions);
        return Unit.f50853a;
    }

    private final void x() {
        ug.r(this.f45176e.t(), new e(), null, null, null, null, 30, null);
    }

    public Single<vf> H(List<? extends je> permissions, pe permissionHandler) {
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(permissionHandler, "permissionHandler");
        return I(permissions, permissionHandler, true);
    }

    @Override // eu.bolt.verification.sdk.internal.sf
    public Single<vf> a(je permission, gc missingPermissionAction) {
        Intrinsics.f(permission, "permission");
        Intrinsics.f(missingPermissionAction, "missingPermissionAction");
        return p(permission, n(missingPermissionAction));
    }

    public Single<vf> p(je permission, pe permissionHandler) {
        List<? extends je> e8;
        Intrinsics.f(permission, "permission");
        Intrinsics.f(permissionHandler, "permissionHandler");
        e8 = CollectionsKt__CollectionsJVMKt.e(permission);
        return H(e8, permissionHandler);
    }
}
