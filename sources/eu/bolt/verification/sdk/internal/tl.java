package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import eu.bolt.verification.sdk.internal.qn;
import eu.bolt.verification.sdk.internal.tl;
import eu.bolt.verification.sdk.internal.ye;
import eu.bolt.verification.sdk.internal.yl;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class tl {

    /* renamed from: a  reason: collision with root package name */
    private final ip f45212a;

    /* renamed from: b  reason: collision with root package name */
    private final xn f45213b;

    /* renamed from: c  reason: collision with root package name */
    private final q8 f45214c;

    /* renamed from: d  reason: collision with root package name */
    private final ye f45215d;

    /* renamed from: e  reason: collision with root package name */
    private final yl f45216e;

    /* renamed from: f  reason: collision with root package name */
    private final x1 f45217f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function1<qn.b, String> {

        /* renamed from: f  reason: collision with root package name */
        public static final a f45218f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final String invoke(qn.b it) {
            Intrinsics.f(it, "it");
            return it.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<String, Single<String>> {
        b(Object obj) {
            super(1, obj, ip.class, "triggerFlow", "triggerFlow(Ljava/lang/String;)Lio/reactivex/Single;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: j */
        public final Single<String> invoke(String p02) {
            Intrinsics.f(p02, "p0");
            return ((ip) this.f50989g).v(p02);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<String, SingleSource<? extends qn>> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends qn> invoke(String flowRunUuid) {
            Intrinsics.f(flowRunUuid, "flowRunUuid");
            return tl.this.f45214c.c(new p8(flowRunUuid, null, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<qn, CompletableSource> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<VerificationFlowStatus, CompletableSource> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ tl f45221f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(tl tlVar) {
                super(1);
                this.f45221f = tlVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(VerificationFlowStatus it) {
                Intrinsics.f(it, "it");
                return this.f45221f.f45217f.b();
            }
        }

        d() {
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
                return tl.this.g((qn.b) flow);
            }
            if (flow instanceof qn.a) {
                tl.this.f45213b.f(((qn.a) flow).a());
                Observable<VerificationFlowStatus> r7 = tl.this.f45213b.r();
                final a aVar = new a(tl.this);
                return r7.flatMapCompletable(new Function() { // from class: eu.bolt.verification.sdk.internal.uw
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        CompletableSource d8;
                        d8 = tl.d.d(Function1.this, obj);
                        return d8;
                    }
                });
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public tl(ip verificationNetworkRepository, xn verificationFlowRepository, q8 getFlowDetailsInteractor, ye predefineDefaultValuesForStepInteractor, yl updateCurrentFlowInteractor, x1 closeFormInteractor) {
        Intrinsics.f(verificationNetworkRepository, "verificationNetworkRepository");
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        Intrinsics.f(getFlowDetailsInteractor, "getFlowDetailsInteractor");
        Intrinsics.f(predefineDefaultValuesForStepInteractor, "predefineDefaultValuesForStepInteractor");
        Intrinsics.f(updateCurrentFlowInteractor, "updateCurrentFlowInteractor");
        Intrinsics.f(closeFormInteractor, "closeFormInteractor");
        this.f45212a = verificationNetworkRepository;
        this.f45213b = verificationFlowRepository;
        this.f45214c = getFlowDetailsInteractor;
        this.f45215d = predefineDefaultValuesForStepInteractor;
        this.f45216e = updateCurrentFlowInteractor;
        this.f45217f = closeFormInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable g(qn.b bVar) {
        Completable d8 = this.f45216e.b(new yl.a(bVar)).d(this.f45215d.c(new ye.a(bVar.f())));
        Intrinsics.e(d8, "updateCurrentFlowInterac…tor.Args(newFlow.steps)))");
        return d8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    public Completable f() {
        Single<qn.b> firstOrError = this.f45213b.p().firstOrError();
        final a aVar = a.f45218f;
        Single<R> x7 = firstOrError.x(new Function() { // from class: eu.bolt.verification.sdk.internal.qw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String i8;
                i8 = tl.i(Function1.this, obj);
                return i8;
            }
        });
        final b bVar = new b(this.f45212a);
        Single r7 = x7.r(new Function() { // from class: eu.bolt.verification.sdk.internal.rw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource k8;
                k8 = tl.k(Function1.this, obj);
                return k8;
            }
        });
        final c cVar = new c();
        Single r8 = r7.r(new Function() { // from class: eu.bolt.verification.sdk.internal.sw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource m8;
                m8 = tl.m(Function1.this, obj);
                return m8;
            }
        });
        final d dVar = new d();
        Completable s7 = r8.s(new Function() { // from class: eu.bolt.verification.sdk.internal.tw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource n8;
                n8 = tl.n(Function1.this, obj);
                return n8;
            }
        });
        Intrinsics.e(s7, "override fun execute(): …    }\n            }\n    }");
        return s7;
    }
}
