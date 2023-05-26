package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.qn;
import eu.bolt.verification.sdk.internal.v8;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class v8 {

    /* renamed from: a  reason: collision with root package name */
    private final vc f45434a;

    /* renamed from: b  reason: collision with root package name */
    private final rc f45435b;

    /* renamed from: c  reason: collision with root package name */
    private final xn f45436c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f45437a;

        /* renamed from: b  reason: collision with root package name */
        private final qn.b f45438b;

        public a(String stepId, qn.b flow) {
            Intrinsics.f(stepId, "stepId");
            Intrinsics.f(flow, "flow");
            this.f45437a = stepId;
            this.f45438b = flow;
        }

        public final qn.b a() {
            return this.f45438b;
        }

        public final String b() {
            return this.f45437a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f45437a, aVar.f45437a) && Intrinsics.a(this.f45438b, aVar.f45438b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f45437a.hashCode() * 31) + this.f45438b.hashCode();
        }

        public String toString() {
            String str = this.f45437a;
            qn.b bVar = this.f45438b;
            return "Result(stepId=" + str + ", flow=" + bVar + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function2<String, qn.b, a> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f45439f = new b();

        b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final a s(String stepId, qn.b flow) {
            Intrinsics.f(stepId, "stepId");
            Intrinsics.f(flow, "flow");
            return new a(stepId, flow);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<a, CompletableSource> {
        c() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(a result, v8 this$0) {
            Intrinsics.f(result, "$result");
            Intrinsics.f(this$0, "this$0");
            if (Intrinsics.a(result.b(), result.a().b())) {
                this$0.f45436c.v();
            }
            this$0.f45436c.w();
            this$0.f45436c.x();
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c */
        public final CompletableSource invoke(final a result) {
            Intrinsics.f(result, "result");
            final v8 v8Var = v8.this;
            return Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.qx
                @Override // io.reactivex.functions.Action
                public final void run() {
                    v8.c.d(v8.a.this, v8Var);
                }
            });
        }
    }

    @Inject
    public v8(vc observeCurrentStepIdInteractor, rc observeCurrentFlowInteractor, xn verificationFlowRepository) {
        Intrinsics.f(observeCurrentStepIdInteractor, "observeCurrentStepIdInteractor");
        Intrinsics.f(observeCurrentFlowInteractor, "observeCurrentFlowInteractor");
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f45434a = observeCurrentStepIdInteractor;
        this.f45435b = observeCurrentFlowInteractor;
        this.f45436c = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a c(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (a) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    public Completable e() {
        Observable<String> a8 = this.f45434a.a();
        Observable<qn.b> a9 = this.f45435b.a();
        final b bVar = b.f45439f;
        Single firstOrError = Observable.combineLatest(a8, a9, new BiFunction() { // from class: eu.bolt.verification.sdk.internal.ox
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                v8.a c8;
                c8 = v8.c(Function2.this, obj, obj2);
                return c8;
            }
        }).firstOrError();
        final c cVar = new c();
        Completable s7 = firstOrError.s(new Function() { // from class: eu.bolt.verification.sdk.internal.px
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource f8;
                f8 = v8.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(s7, "override fun execute(): …    }\n            }\n    }");
        return s7;
    }
}
