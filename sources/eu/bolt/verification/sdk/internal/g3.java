package eu.bolt.verification.sdk.internal;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.verification.sdk.internal.e8;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class g3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements e8.b.a {

        /* renamed from: a  reason: collision with root package name */
        private m8 f43083a;

        /* renamed from: b  reason: collision with root package name */
        private h8 f43084b;

        /* renamed from: c  reason: collision with root package name */
        private e8.d f43085c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.e8.b.a
        public e8.b build() {
            Preconditions.checkBuilderRequirement(this.f43083a, m8.class);
            Preconditions.checkBuilderRequirement(this.f43084b, h8.class);
            Preconditions.checkBuilderRequirement(this.f43085c, e8.d.class);
            return new b(this.f43085c, this.f43083a, this.f43084b);
        }

        @Override // eu.bolt.verification.sdk.internal.e8.b.a
        /* renamed from: d */
        public a a(e8.d dVar) {
            this.f43085c = (e8.d) Preconditions.checkNotNull(dVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.e8.b.a
        /* renamed from: e */
        public a c(h8 h8Var) {
            this.f43084b = (h8) Preconditions.checkNotNull(h8Var);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.e8.b.a
        /* renamed from: f */
        public a b(m8 m8Var) {
            this.f43083a = (m8) Preconditions.checkNotNull(m8Var);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements e8.b {

        /* renamed from: a  reason: collision with root package name */
        private final e8.d f43086a;

        /* renamed from: b  reason: collision with root package name */
        private final b f43087b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<e8.b> f43088c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<m8> f43089d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<n8> f43090e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<h8> f43091f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<y6> f43092g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<ib> f43093h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<i8> f43094i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<k8> f43095j;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<y6> {

            /* renamed from: a  reason: collision with root package name */
            private final e8.d f43096a;

            a(e8.d dVar) {
                this.f43096a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public y6 get() {
                return (y6) Preconditions.checkNotNullFromComponent(this.f43096a.c());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.g3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0055b implements Provider<ib> {

            /* renamed from: a  reason: collision with root package name */
            private final e8.d f43097a;

            C0055b(e8.d dVar) {
                this.f43097a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ib get() {
                return (ib) Preconditions.checkNotNullFromComponent(this.f43097a.b());
            }
        }

        private b(e8.d dVar, m8 m8Var, h8 h8Var) {
            this.f43087b = this;
            this.f43086a = dVar;
            c(dVar, m8Var, h8Var);
        }

        private void c(e8.d dVar, m8 m8Var, h8 h8Var) {
            this.f43088c = InstanceFactory.create(this.f43087b);
            Factory create = InstanceFactory.create(m8Var);
            this.f43089d = create;
            this.f43090e = DoubleCheck.provider(o8.c(create));
            this.f43091f = InstanceFactory.create(h8Var);
            this.f43092g = new a(dVar);
            C0055b c0055b = new C0055b(dVar);
            this.f43093h = c0055b;
            j8 c8 = j8.c(this.f43090e, this.f43091f, this.f43092g, c0055b);
            this.f43094i = c8;
            this.f43095j = DoubleCheck.provider(f8.a(this.f43088c, this.f43089d, c8));
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public RxActivityEvents B() {
            return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f43086a.B());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public v4 I() {
            return (v4) Preconditions.checkNotNullFromComponent(this.f43086a.I());
        }

        @Override // eu.bolt.verification.sdk.internal.n6.d
        public qj a() {
            return (qj) Preconditions.checkNotNullFromComponent(this.f43086a.a());
        }

        @Override // eu.bolt.verification.sdk.internal.n6.d
        public y6 c() {
            return (y6) Preconditions.checkNotNullFromComponent(this.f43086a.c());
        }

        @Override // eu.bolt.verification.sdk.internal.e8.a
        public k8 d() {
            return this.f43095j.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public Context k() {
            return (Context) Preconditions.checkNotNullFromComponent(this.f43086a.k());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public s n() {
            return (s) Preconditions.checkNotNullFromComponent(this.f43086a.n());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public dl p() {
            return (dl) Preconditions.checkNotNullFromComponent(this.f43086a.p());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public CoActivityEvents x() {
            return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f43086a.x());
        }
    }

    public static e8.b.a a() {
        return new a();
    }
}
