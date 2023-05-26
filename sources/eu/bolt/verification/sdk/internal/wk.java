package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import eu.bolt.verification.sdk.internal.eh;
import eu.bolt.verification.sdk.internal.qn;
import eu.bolt.verification.sdk.internal.wk;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class wk {

    /* renamed from: a  reason: collision with root package name */
    private final tc f45558a;

    /* renamed from: b  reason: collision with root package name */
    private final xn f45559b;

    /* renamed from: c  reason: collision with root package name */
    private final eh f45560c;

    /* renamed from: d  reason: collision with root package name */
    private final bd f45561d;

    /* renamed from: e  reason: collision with root package name */
    private final q8 f45562e;

    /* renamed from: f  reason: collision with root package name */
    private final x1 f45563f;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f45564a;

        public a(String str) {
            this.f45564a = str;
        }

        public final String a() {
            return this.f45564a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f45564a, ((a) obj).f45564a);
        }

        public int hashCode() {
            String str = this.f45564a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            String str = this.f45564a;
            return "Args(stepId=" + str + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<qn, CompletableSource> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<VerificationFlowStatus, CompletableSource> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ wk f45566f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(wk wkVar) {
                super(1);
                this.f45566f = wkVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(VerificationFlowStatus it) {
                Intrinsics.f(it, "it");
                return this.f45566f.f45563f.b();
            }
        }

        b() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CompletableSource d(Function1 tmp0, Object obj) {
            Intrinsics.f(tmp0, "$tmp0");
            return (CompletableSource) tmp0.invoke(obj);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c */
        public final CompletableSource invoke(qn flow) {
            Intrinsics.f(flow, "flow");
            if (flow instanceof qn.b) {
                return wk.this.f45560c.b(new eh.a((qn.b) flow));
            }
            if (flow instanceof qn.a) {
                wk.this.f45559b.f(((qn.a) flow).a());
                Observable<VerificationFlowStatus> r7 = wk.this.f45559b.r();
                final a aVar = new a(wk.this);
                return r7.flatMapCompletable(new Function() { // from class: eu.bolt.verification.sdk.internal.ux
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        CompletableSource d8;
                        d8 = wk.b.d(Function1.this, obj);
                        return d8;
                    }
                });
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function3<String, Map<String, ? extends em>, Boolean, p8> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f45567f = new c();

        c() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: b */
        public final p8 l(String flowRunUuid, Map<String, ? extends em> userInputs, Boolean isFirstRequest) {
            Intrinsics.f(flowRunUuid, "flowRunUuid");
            Intrinsics.f(userInputs, "userInputs");
            Intrinsics.f(isFirstRequest, "isFirstRequest");
            return new p8(flowRunUuid, userInputs, isFirstRequest.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<p8, SingleSource<? extends qn>> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends qn> invoke(p8 getFlowDetailsData) {
            Intrinsics.f(getFlowDetailsData, "getFlowDetailsData");
            return wk.this.f45562e.c(getFlowDetailsData);
        }
    }

    @Inject
    public wk(tc observeCurrentFlowRunUuidInteractor, xn verificationFlowRepository, eh setCurrentFlowInteractor, bd observeIsFirstRequestInteractor, q8 getFlowDetailsInteractor, x1 closeFormInteractor) {
        Intrinsics.f(observeCurrentFlowRunUuidInteractor, "observeCurrentFlowRunUuidInteractor");
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        Intrinsics.f(setCurrentFlowInteractor, "setCurrentFlowInteractor");
        Intrinsics.f(observeIsFirstRequestInteractor, "observeIsFirstRequestInteractor");
        Intrinsics.f(getFlowDetailsInteractor, "getFlowDetailsInteractor");
        Intrinsics.f(closeFormInteractor, "closeFormInteractor");
        this.f45558a = observeCurrentFlowRunUuidInteractor;
        this.f45559b = verificationFlowRepository;
        this.f45560c = setCurrentFlowInteractor;
        this.f45561d = observeIsFirstRequestInteractor;
        this.f45562e = getFlowDetailsInteractor;
        this.f45563f = closeFormInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p8 d(Function3 tmp0, Object obj, Object obj2, Object obj3) {
        Intrinsics.f(tmp0, "$tmp0");
        return (p8) tmp0.l(obj, obj2, obj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    private final Single<qn> h(String str) {
        Observable<String> b8 = this.f45558a.b();
        Observable<Map<String, em>> d8 = this.f45559b.d(str);
        Observable<Boolean> a8 = this.f45561d.a();
        final c cVar = c.f45567f;
        Single firstOrError = Observable.combineLatest(b8, d8, a8, new io.reactivex.functions.Function3() { // from class: eu.bolt.verification.sdk.internal.sx
            @Override // io.reactivex.functions.Function3
            public final Object a(Object obj, Object obj2, Object obj3) {
                p8 d9;
                d9 = wk.d(Function3.this, obj, obj2, obj3);
                return d9;
            }
        }).firstOrError();
        final d dVar = new d();
        Single<qn> r7 = firstOrError.r(new Function() { // from class: eu.bolt.verification.sdk.internal.tx
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource j8;
                j8 = wk.j(Function1.this, obj);
                return j8;
            }
        });
        Intrinsics.e(r7, "private fun refreshVerif…etailsData)\n            }");
        return r7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public Completable f(a args) {
        Intrinsics.f(args, "args");
        Single<qn> h8 = h(args.a());
        final b bVar = new b();
        Completable s7 = h8.s(new Function() { // from class: eu.bolt.verification.sdk.internal.rx
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource g8;
                g8 = wk.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(s7, "override fun execute(arg…    }\n            }\n    }");
        return s7;
    }
}
