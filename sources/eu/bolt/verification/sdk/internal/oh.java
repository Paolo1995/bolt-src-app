package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import eu.bolt.verification.sdk.internal.oh;
import eu.bolt.verification.sdk.internal.qn;
import eu.bolt.verification.sdk.internal.yl;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class oh {

    /* renamed from: h  reason: collision with root package name */
    private static final b f44459h = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private final tc f44460a;

    /* renamed from: b  reason: collision with root package name */
    private final yl f44461b;

    /* renamed from: c  reason: collision with root package name */
    private final xg f44462c;

    /* renamed from: d  reason: collision with root package name */
    private final bd f44463d;

    /* renamed from: e  reason: collision with root package name */
    private final q8 f44464e;

    /* renamed from: f  reason: collision with root package name */
    private final xn f44465f;

    /* renamed from: g  reason: collision with root package name */
    private final x1 f44466g;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f44467a;

        public a(int i8) {
            this.f44467a = i8;
        }

        public final int a() {
            return this.f44467a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f44467a == ((a) obj).f44467a;
        }

        public int hashCode() {
            return this.f44467a;
        }

        public String toString() {
            int i8 = this.f44467a;
            return "Args(intervalSec=" + i8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<Long, CompletableSource> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final CompletableSource invoke(Long it) {
            Intrinsics.f(it, "it");
            return oh.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function2<String, Boolean, p8> {

        /* renamed from: f  reason: collision with root package name */
        public static final d f44469f = new d();

        d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final p8 s(String flowRunUuid, Boolean isFirstRequest) {
            Intrinsics.f(flowRunUuid, "flowRunUuid");
            Intrinsics.f(isFirstRequest, "isFirstRequest");
            return new p8(flowRunUuid, null, isFirstRequest.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<p8, SingleSource<? extends qn>> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends qn> invoke(p8 getFlowDetailsData) {
            Intrinsics.f(getFlowDetailsData, "getFlowDetailsData");
            return oh.this.f44464e.c(getFlowDetailsData).F(new ag(3, 1000, oh.this.f44462c.b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class f extends Lambda implements Function1<qn, CompletableSource> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<VerificationFlowStatus, CompletableSource> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ oh f44472f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(oh ohVar) {
                super(1);
                this.f44472f = ohVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(VerificationFlowStatus it) {
                Intrinsics.f(it, "it");
                return this.f44472f.f44466g.b();
            }
        }

        f() {
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
                return oh.this.f44461b.b(new yl.a((qn.b) flow));
            }
            if (flow instanceof qn.a) {
                oh.this.f44465f.f(((qn.a) flow).a());
                Observable<VerificationFlowStatus> r7 = oh.this.f44465f.r();
                final a aVar = new a(oh.this);
                return r7.flatMapCompletable(new Function() { // from class: eu.bolt.verification.sdk.internal.iv
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        CompletableSource d8;
                        d8 = oh.f.d(Function1.this, obj);
                        return d8;
                    }
                });
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public oh(tc observeCurrentFlowRunUuidInteractor, yl updateCurrentFlowInteractor, xg rxSchedulers, bd observeIsFirstRequestInteractor, q8 getFlowDetailsInteractor, xn verificationFlowRepository, x1 closeFormInteractor) {
        Intrinsics.f(observeCurrentFlowRunUuidInteractor, "observeCurrentFlowRunUuidInteractor");
        Intrinsics.f(updateCurrentFlowInteractor, "updateCurrentFlowInteractor");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(observeIsFirstRequestInteractor, "observeIsFirstRequestInteractor");
        Intrinsics.f(getFlowDetailsInteractor, "getFlowDetailsInteractor");
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        Intrinsics.f(closeFormInteractor, "closeFormInteractor");
        this.f44460a = observeCurrentFlowRunUuidInteractor;
        this.f44461b = updateCurrentFlowInteractor;
        this.f44462c = rxSchedulers;
        this.f44463d = observeIsFirstRequestInteractor;
        this.f44464e = getFlowDetailsInteractor;
        this.f44465f = verificationFlowRepository;
        this.f44466g = closeFormInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p8 e(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (p8) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable g() {
        Observable<String> b8 = this.f44460a.b();
        Observable<Boolean> a8 = this.f44463d.a();
        final d dVar = d.f44469f;
        Single firstOrError = Observable.combineLatest(b8, a8, new BiFunction() { // from class: eu.bolt.verification.sdk.internal.fv
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                p8 e8;
                e8 = oh.e(Function2.this, obj, obj2);
                return e8;
            }
        }).firstOrError();
        final e eVar = new e();
        Single r7 = firstOrError.r(new Function() { // from class: eu.bolt.verification.sdk.internal.gv
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource k8;
                k8 = oh.k(Function1.this, obj);
                return k8;
            }
        });
        final f fVar = new f();
        Completable s7 = r7.s(new Function() { // from class: eu.bolt.verification.sdk.internal.hv
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource m8;
                m8 = oh.m(Function1.this, obj);
                return m8;
            }
        });
        Intrinsics.e(s7, "private fun refreshVerif…}\n            }\n        }");
        return s7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    public Completable h(a args) {
        Intrinsics.f(args, "args");
        Observable<Long> interval = Observable.interval(args.a(), args.a(), TimeUnit.SECONDS, this.f44462c.b());
        final c cVar = new c();
        Completable switchMapCompletable = interval.switchMapCompletable(new Function() { // from class: eu.bolt.verification.sdk.internal.ev
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource i8;
                i8 = oh.i(Function1.this, obj);
                return i8;
            }
        });
        Intrinsics.e(switchMapCompletable, "override fun execute(arg…freshVerificationFlow() }");
        return switchMapCompletable;
    }
}
