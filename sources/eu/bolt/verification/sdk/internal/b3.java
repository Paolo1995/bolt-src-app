package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.verification.sdk.internal.o0;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class b3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements o0.b.a {

        /* renamed from: a  reason: collision with root package name */
        private x0 f42258a;

        /* renamed from: b  reason: collision with root package name */
        private ga f42259b;

        /* renamed from: c  reason: collision with root package name */
        private o0.d f42260c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.o0.b.a
        public o0.b build() {
            Preconditions.checkBuilderRequirement(this.f42258a, x0.class);
            Preconditions.checkBuilderRequirement(this.f42259b, ga.class);
            Preconditions.checkBuilderRequirement(this.f42260c, o0.d.class);
            return new b(this.f42260c, this.f42258a, this.f42259b);
        }

        @Override // eu.bolt.verification.sdk.internal.o0.b.a
        /* renamed from: d */
        public a b(ga gaVar) {
            this.f42259b = (ga) Preconditions.checkNotNull(gaVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.o0.b.a
        /* renamed from: e */
        public a c(o0.d dVar) {
            this.f42260c = (o0.d) Preconditions.checkNotNull(dVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.o0.b.a
        /* renamed from: f */
        public a a(x0 x0Var) {
            this.f42258a = (x0) Preconditions.checkNotNull(x0Var);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements o0.b {

        /* renamed from: a  reason: collision with root package name */
        private final b f42261a;

        /* renamed from: b  reason: collision with root package name */
        private Provider<x0> f42262b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<jc> f42263c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<r0> f42264d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<ga> f42265e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<v0> f42266f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<t0> f42267g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<qj> f42268h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<w0> f42269i;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<v0> {

            /* renamed from: a  reason: collision with root package name */
            private final o0.d f42270a;

            a(o0.d dVar) {
                this.f42270a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public v0 get() {
                return (v0) Preconditions.checkNotNullFromComponent(this.f42270a.F());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.b3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0035b implements Provider<jc> {

            /* renamed from: a  reason: collision with root package name */
            private final o0.d f42271a;

            C0035b(o0.d dVar) {
                this.f42271a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public jc get() {
                return (jc) Preconditions.checkNotNullFromComponent(this.f42271a.d());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<qj> {

            /* renamed from: a  reason: collision with root package name */
            private final o0.d f42272a;

            c(o0.d dVar) {
                this.f42272a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public qj get() {
                return (qj) Preconditions.checkNotNullFromComponent(this.f42272a.a());
            }
        }

        private b(o0.d dVar, x0 x0Var, ga gaVar) {
            this.f42261a = this;
            b(dVar, x0Var, gaVar);
        }

        private void b(o0.d dVar, x0 x0Var, ga gaVar) {
            this.f42262b = InstanceFactory.create(x0Var);
            C0035b c0035b = new C0035b(dVar);
            this.f42263c = c0035b;
            this.f42264d = DoubleCheck.provider(s0.c(this.f42262b, c0035b));
            this.f42265e = InstanceFactory.create(gaVar);
            a aVar = new a(dVar);
            this.f42266f = aVar;
            this.f42267g = DoubleCheck.provider(u0.c(this.f42264d, this.f42265e, aVar));
            c cVar = new c(dVar);
            this.f42268h = cVar;
            this.f42269i = DoubleCheck.provider(p0.a(this.f42262b, this.f42267g, cVar));
        }

        @Override // eu.bolt.verification.sdk.internal.o0.a
        public w0 a() {
            return this.f42269i.get();
        }
    }

    public static o0.b.a a() {
        return new a();
    }
}
