package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.verification.sdk.internal.vi;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class k3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements vi.b.a {

        /* renamed from: a  reason: collision with root package name */
        private vi.d f43799a;

        /* renamed from: b  reason: collision with root package name */
        private ViewGroup f43800b;

        /* renamed from: c  reason: collision with root package name */
        private xi f43801c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.vi.b.a
        public vi.b build() {
            Preconditions.checkBuilderRequirement(this.f43799a, vi.d.class);
            Preconditions.checkBuilderRequirement(this.f43800b, ViewGroup.class);
            Preconditions.checkBuilderRequirement(this.f43801c, xi.class);
            return new b(this.f43799a, this.f43800b, this.f43801c);
        }

        @Override // eu.bolt.verification.sdk.internal.vi.b.a
        /* renamed from: d */
        public a a(ViewGroup viewGroup) {
            this.f43800b = (ViewGroup) Preconditions.checkNotNull(viewGroup);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.vi.b.a
        /* renamed from: e */
        public a b(vi.d dVar) {
            this.f43799a = (vi.d) Preconditions.checkNotNull(dVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.vi.b.a
        /* renamed from: f */
        public a c(xi xiVar) {
            this.f43801c = (xi) Preconditions.checkNotNull(xiVar);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements vi.b {

        /* renamed from: a  reason: collision with root package name */
        private final vi.d f43802a;

        /* renamed from: b  reason: collision with root package name */
        private final b f43803b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<ViewGroup> f43804c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<vi.b> f43805d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<xi> f43806e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<aj> f43807f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<yi> f43808g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<bj> f43809h;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<aj> {

            /* renamed from: a  reason: collision with root package name */
            private final vi.d f43810a;

            a(vi.d dVar) {
                this.f43810a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public aj get() {
                return (aj) Preconditions.checkNotNullFromComponent(this.f43810a.j());
            }
        }

        private b(vi.d dVar, ViewGroup viewGroup, xi xiVar) {
            this.f43803b = this;
            this.f43802a = dVar;
            c(dVar, viewGroup, xiVar);
        }

        private void c(vi.d dVar, ViewGroup viewGroup, xi xiVar) {
            this.f43804c = InstanceFactory.create(viewGroup);
            this.f43805d = InstanceFactory.create(this.f43803b);
            this.f43806e = InstanceFactory.create(xiVar);
            a aVar = new a(dVar);
            this.f43807f = aVar;
            Provider<yi> provider = DoubleCheck.provider(zi.c(this.f43806e, aVar));
            this.f43808g = provider;
            this.f43809h = DoubleCheck.provider(wi.c(this.f43804c, this.f43805d, provider));
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public RxActivityEvents B() {
            return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f43802a.B());
        }

        @Override // eu.bolt.verification.sdk.internal.pi.d
        public nj K() {
            return this.f43808g.get();
        }

        @Override // eu.bolt.verification.sdk.internal.vi.a
        public bj d() {
            return this.f43809h.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public mg m() {
            return (mg) Preconditions.checkNotNullFromComponent(this.f43802a.m());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public s n() {
            return (s) Preconditions.checkNotNullFromComponent(this.f43802a.n());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public dl p() {
            return (dl) Preconditions.checkNotNullFromComponent(this.f43802a.p());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public xf r() {
            return (xf) Preconditions.checkNotNullFromComponent(this.f43802a.r());
        }

        @Override // eu.bolt.verification.sdk.internal.sh.d
        public gi u() {
            return this.f43808g.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public CoActivityEvents x() {
            return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f43802a.x());
        }
    }

    public static vi.b.a a() {
        return new a();
    }
}
