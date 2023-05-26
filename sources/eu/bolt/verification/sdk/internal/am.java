package eu.bolt.verification.sdk.internal;

import io.reactivex.Completable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class am {

    /* renamed from: a  reason: collision with root package name */
    private final vb f42095a;

    /* renamed from: b  reason: collision with root package name */
    private final ke f42096b;

    /* loaded from: classes5.dex */
    public static abstract class a {

        /* renamed from: eu.bolt.verification.sdk.internal.am$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0029a extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0029a f42097a = new C0029a();

            private C0029a() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            private final boolean f42098a;

            /* renamed from: b  reason: collision with root package name */
            private final boolean f42099b;

            public final boolean a() {
                return this.f42098a;
            }

            public final boolean b() {
                return this.f42099b;
            }
        }

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
        private final boolean f42100a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f42101b;

        public b(boolean z7, boolean z8) {
            this.f42100a = z7;
            this.f42101b = z8;
        }

        public final boolean a() {
            return this.f42100a;
        }

        public final boolean b() {
            return this.f42101b;
        }
    }

    @Inject
    public am(vb locationPermissionProvider, ke permissionHelper) {
        Intrinsics.f(locationPermissionProvider, "locationPermissionProvider");
        Intrinsics.f(permissionHelper, "permissionHelper");
        this.f42095a = locationPermissionProvider;
        this.f42096b = permissionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(am this$0, a args) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(args, "$args");
        b d8 = this$0.d(args);
        boolean a8 = d8.a();
        vb vbVar = this$0.f42095a;
        if (a8) {
            vbVar.f(d8.b());
        } else {
            vbVar.a();
        }
        return Unit.f50853a;
    }

    private final b d(a aVar) {
        if (aVar instanceof a.b) {
            a.b bVar = (a.b) aVar;
            return new b(bVar.a(), bVar.b());
        } else if (aVar instanceof a.C0029a) {
            return new b(this.f42096b.b(), this.f42096b.c());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public Completable b(final a args) {
        Intrinsics.f(args, "args");
        Completable v7 = Completable.v(new Callable() { // from class: eu.bolt.verification.sdk.internal.da
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit c8;
                c8 = am.c(am.this, args);
                return c8;
            }
        });
        Intrinsics.e(v7, "fromCallable {\n        v…nDenied()\n        }\n    }");
        return v7;
    }
}
