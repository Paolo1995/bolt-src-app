package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import eu.bolt.verification.sdk.internal.eh;
import eu.bolt.verification.sdk.internal.ia;
import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class ia {

    /* renamed from: a  reason: collision with root package name */
    private final eh f43517a;

    /* renamed from: b  reason: collision with root package name */
    private final bd f43518b;

    /* renamed from: c  reason: collision with root package name */
    private final q8 f43519c;

    /* renamed from: d  reason: collision with root package name */
    private final x1 f43520d;

    /* renamed from: e  reason: collision with root package name */
    private final xn f43521e;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f43522a;

        public a(String flowRunUuid) {
            Intrinsics.f(flowRunUuid, "flowRunUuid");
            this.f43522a = flowRunUuid;
        }

        public final String a() {
            return this.f43522a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f43522a, ((a) obj).f43522a);
        }

        public int hashCode() {
            return this.f43522a.hashCode();
        }

        public String toString() {
            String str = this.f43522a;
            return "Args(flowRunUuid=" + str + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<qn, CompletableSource> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<VerificationFlowStatus, CompletableSource> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ ia f43524f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ia iaVar) {
                super(1);
                this.f43524f = iaVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(VerificationFlowStatus it) {
                Intrinsics.f(it, "it");
                return this.f43524f.f43520d.b();
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
                return ia.this.f43517a.b(new eh.a((qn.b) flow));
            }
            if (flow instanceof qn.a) {
                ia.this.f43521e.f(((qn.a) flow).a());
                Observable<VerificationFlowStatus> r7 = ia.this.f43521e.r();
                final a aVar = new a(ia.this);
                return r7.flatMapCompletable(new Function() { // from class: eu.bolt.verification.sdk.internal.et
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        CompletableSource d8;
                        d8 = ia.b.d(Function1.this, obj);
                        return d8;
                    }
                });
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<Boolean, SingleSource<? extends qn>> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f43526g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.f43526g = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends qn> invoke(Boolean isFirstRequest) {
            Intrinsics.f(isFirstRequest, "isFirstRequest");
            return ia.this.f43519c.c(new p8(this.f43526g, null, isFirstRequest.booleanValue()));
        }
    }

    @Inject
    public ia(eh setCurrentFlowInteractor, bd observeIsFirstRequestInteractor, q8 getFlowDetailsInteractor, x1 closeFormInteractor, xn verificationFlowRepository) {
        Intrinsics.f(setCurrentFlowInteractor, "setCurrentFlowInteractor");
        Intrinsics.f(observeIsFirstRequestInteractor, "observeIsFirstRequestInteractor");
        Intrinsics.f(getFlowDetailsInteractor, "getFlowDetailsInteractor");
        Intrinsics.f(closeFormInteractor, "closeFormInteractor");
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f43517a = setCurrentFlowInteractor;
        this.f43518b = observeIsFirstRequestInteractor;
        this.f43519c = getFlowDetailsInteractor;
        this.f43520d = closeFormInteractor;
        this.f43521e = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    private final Single<qn> f(String str) {
        Single<Boolean> firstOrError = this.f43518b.a().firstOrError();
        final c cVar = new c(str);
        Single r7 = firstOrError.r(new Function() { // from class: eu.bolt.verification.sdk.internal.dt
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource h8;
                h8 = ia.h(Function1.this, obj);
                return h8;
            }
        });
        Intrinsics.e(r7, "private fun initVerifica…    )\n            }\n    }");
        return r7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public Completable d(a args) {
        Intrinsics.f(args, "args");
        Single<qn> f8 = f(args.a());
        final b bVar = new b();
        Completable s7 = f8.s(new Function() { // from class: eu.bolt.verification.sdk.internal.ct
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource e8;
                e8 = ia.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(s7, "override fun execute(arg…    }\n            }\n    }");
        return s7;
    }
}
