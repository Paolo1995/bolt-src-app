package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.verification.sdk.internal.yq;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class o3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements yq.b.a {

        /* renamed from: a  reason: collision with root package name */
        private hr f44381a;

        /* renamed from: b  reason: collision with root package name */
        private td f44382b;

        /* renamed from: c  reason: collision with root package name */
        private yq.d f44383c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.yq.b.a
        public yq.b build() {
            Preconditions.checkBuilderRequirement(this.f44381a, hr.class);
            Preconditions.checkBuilderRequirement(this.f44382b, td.class);
            Preconditions.checkBuilderRequirement(this.f44383c, yq.d.class);
            return new b(this.f44383c, this.f44381a, this.f44382b);
        }

        @Override // eu.bolt.verification.sdk.internal.yq.b.a
        /* renamed from: d */
        public a b(hr hrVar) {
            this.f44381a = (hr) Preconditions.checkNotNull(hrVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.yq.b.a
        /* renamed from: e */
        public a a(td tdVar) {
            this.f44382b = (td) Preconditions.checkNotNull(tdVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.yq.b.a
        /* renamed from: f */
        public a c(yq.d dVar) {
            this.f44383c = (yq.d) Preconditions.checkNotNull(dVar);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements yq.b {

        /* renamed from: a  reason: collision with root package name */
        private final b f44384a;

        /* renamed from: b  reason: collision with root package name */
        private Provider<hr> f44385b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<lr> f44386c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<er> f44387d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<td> f44388e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<cr> f44389f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<Activity> f44390g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<RxActivityEvents> f44391h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<pd> f44392i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<dl> f44393j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<s> f44394k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<CoActivityEvents> f44395l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<bg> f44396m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<jc> f44397n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<xf> f44398o;

        /* renamed from: p  reason: collision with root package name */
        private Provider<ar> f44399p;

        /* renamed from: q  reason: collision with root package name */
        private Provider<gr> f44400q;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<Activity> {

            /* renamed from: a  reason: collision with root package name */
            private final yq.d f44401a;

            a(yq.d dVar) {
                this.f44401a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Activity get() {
                return (Activity) Preconditions.checkNotNullFromComponent(this.f44401a.f());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.o3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0080b implements Provider<s> {

            /* renamed from: a  reason: collision with root package name */
            private final yq.d f44402a;

            C0080b(yq.d dVar) {
                this.f44402a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public s get() {
                return (s) Preconditions.checkNotNullFromComponent(this.f44402a.n());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<cr> {

            /* renamed from: a  reason: collision with root package name */
            private final yq.d f44403a;

            c(yq.d dVar) {
                this.f44403a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public cr get() {
                return (cr) Preconditions.checkNotNullFromComponent(this.f44403a.t());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class d implements Provider<CoActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final yq.d f44404a;

            d(yq.d dVar) {
                this.f44404a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CoActivityEvents get() {
                return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f44404a.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class e implements Provider<jc> {

            /* renamed from: a  reason: collision with root package name */
            private final yq.d f44405a;

            e(yq.d dVar) {
                this.f44405a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public jc get() {
                return (jc) Preconditions.checkNotNullFromComponent(this.f44405a.e());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class f implements Provider<xf> {

            /* renamed from: a  reason: collision with root package name */
            private final yq.d f44406a;

            f(yq.d dVar) {
                this.f44406a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xf get() {
                return (xf) Preconditions.checkNotNullFromComponent(this.f44406a.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class g implements Provider<RxActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final yq.d f44407a;

            g(yq.d dVar) {
                this.f44407a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RxActivityEvents get() {
                return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f44407a.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class h implements Provider<dl> {

            /* renamed from: a  reason: collision with root package name */
            private final yq.d f44408a;

            h(yq.d dVar) {
                this.f44408a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public dl get() {
                return (dl) Preconditions.checkNotNullFromComponent(this.f44408a.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class i implements Provider<lr> {

            /* renamed from: a  reason: collision with root package name */
            private final yq.d f44409a;

            i(yq.d dVar) {
                this.f44409a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public lr get() {
                return (lr) Preconditions.checkNotNullFromComponent(this.f44409a.h());
            }
        }

        private b(yq.d dVar, hr hrVar, td tdVar) {
            this.f44384a = this;
            b(dVar, hrVar, tdVar);
        }

        private void b(yq.d dVar, hr hrVar, td tdVar) {
            this.f44385b = InstanceFactory.create(hrVar);
            i iVar = new i(dVar);
            this.f44386c = iVar;
            this.f44387d = DoubleCheck.provider(fr.c(this.f44385b, iVar));
            this.f44388e = InstanceFactory.create(tdVar);
            this.f44389f = new c(dVar);
            this.f44390g = new a(dVar);
            g gVar = new g(dVar);
            this.f44391h = gVar;
            this.f44392i = qd.c(this.f44390g, gVar);
            this.f44393j = new h(dVar);
            this.f44394k = new C0080b(dVar);
            d dVar2 = new d(dVar);
            this.f44395l = dVar2;
            this.f44396m = cg.c(this.f44393j, this.f44394k, dVar2, this.f44391h);
            this.f44397n = new e(dVar);
            f fVar = new f(dVar);
            this.f44398o = fVar;
            br c8 = br.c(this.f44387d, this.f44388e, this.f44389f, this.f44392i, this.f44396m, this.f44397n, fVar);
            this.f44399p = c8;
            this.f44400q = DoubleCheck.provider(zq.c(this.f44385b, c8));
        }

        @Override // eu.bolt.verification.sdk.internal.yq.a
        public gr a() {
            return this.f44400q.get();
        }
    }

    public static yq.b.a a() {
        return new a();
    }
}
