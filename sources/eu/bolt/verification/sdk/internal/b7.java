package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.d7;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public abstract class b7<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d7<T> f42286a;

    /* loaded from: classes5.dex */
    public static abstract class a extends b7<Boolean> {

        /* renamed from: eu.bolt.verification.sdk.internal.b7$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0036a extends a {

            /* renamed from: b  reason: collision with root package name */
            public static final C0036a f42287b = new C0036a();

            private C0036a() {
                super(new d7.b(c7.PER_USER, "android_rider_coroutines_migration", Boolean.FALSE, "Coroutines migration", false, false, e7.PLATFORM, 16, null), null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends a {

            /* renamed from: b  reason: collision with root package name */
            public static final b f42288b = new b();

            private b() {
                super(new d7.a("verification_real_api", Boolean.TRUE, "Verification SDK API not mocks", false, false, e7.HACKS, 24, null), null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class c extends a {

            /* renamed from: b  reason: collision with root package name */
            public static final c f42289b = new c();

            private c() {
                super(new d7.b(c7.PER_USER, "worker_binder_coroutines", Boolean.FALSE, "Use coroutines for WorkerBinder", false, true, e7.PLATFORM, 16, null), null);
            }
        }

        private a(d7<Boolean> d7Var) {
            super(d7Var, null);
        }

        public /* synthetic */ a(d7 d7Var, DefaultConstructorMarker defaultConstructorMarker) {
            this(d7Var);
        }
    }

    private b7(d7<T> d7Var) {
        this.f42286a = d7Var;
    }

    public /* synthetic */ b7(d7 d7Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(d7Var);
    }
}
