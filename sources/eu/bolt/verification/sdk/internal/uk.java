package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import eu.bolt.verification.sdk.internal.uk;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class uk {

    /* renamed from: a  reason: collision with root package name */
    private final tc f45376a;

    /* renamed from: b  reason: collision with root package name */
    private final ip f45377b;

    /* renamed from: c  reason: collision with root package name */
    private final xn f45378c;

    /* renamed from: d  reason: collision with root package name */
    private final rq f45379d;

    /* renamed from: e  reason: collision with root package name */
    private final x1 f45380e;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f45381a;

        public a(String stepId) {
            Intrinsics.f(stepId, "stepId");
            this.f45381a = stepId;
        }

        public final String a() {
            return this.f45381a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f45381a, ((a) obj).f45381a);
        }

        public int hashCode() {
            return this.f45381a.hashCode();
        }

        public String toString() {
            String str = this.f45381a;
            return "Args(stepId=" + str + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f45382a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, em> f45383b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(String flowRunUuid, Map<String, ? extends em> userInputs) {
            Intrinsics.f(flowRunUuid, "flowRunUuid");
            Intrinsics.f(userInputs, "userInputs");
            this.f45382a = flowRunUuid;
            this.f45383b = userInputs;
        }

        public final String a() {
            return this.f45382a;
        }

        public final Map<String, em> b() {
            return this.f45383b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(this.f45382a, bVar.f45382a) && Intrinsics.a(this.f45383b, bVar.f45383b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f45382a.hashCode() * 31) + this.f45383b.hashCode();
        }

        public String toString() {
            String str = this.f45382a;
            Map<String, em> map = this.f45383b;
            return "Result(flowRunUuid=" + str + ", userInputs=" + map + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function2<String, Map<String, ? extends em>, b> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f45384f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final b s(String flowRunUuid, Map<String, ? extends em> userInputs) {
            Intrinsics.f(flowRunUuid, "flowRunUuid");
            Intrinsics.f(userInputs, "userInputs");
            return new b(flowRunUuid, userInputs);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<b, SingleSource<? extends VerificationFlowStatus>> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f45386g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(1);
            this.f45386g = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends VerificationFlowStatus> invoke(b result) {
            Intrinsics.f(result, "result");
            return uk.this.f45377b.q(result.a(), uk.this.f45379d.b(result.b()), this.f45386g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<VerificationFlowStatus, CompletableSource> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final CompletableSource invoke(VerificationFlowStatus flowStatus) {
            Intrinsics.f(flowStatus, "flowStatus");
            uk.this.f45378c.f(flowStatus);
            return uk.this.f45380e.b();
        }
    }

    @Inject
    public uk(tc observeCurrentFlowRunUuidInteractor, ip verificationNetworkRepository, xn verificationFlowRepository, rq userInputMapper, x1 closeFormInteractor) {
        Intrinsics.f(observeCurrentFlowRunUuidInteractor, "observeCurrentFlowRunUuidInteractor");
        Intrinsics.f(verificationNetworkRepository, "verificationNetworkRepository");
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        Intrinsics.f(userInputMapper, "userInputMapper");
        Intrinsics.f(closeFormInteractor, "closeFormInteractor");
        this.f45376a = observeCurrentFlowRunUuidInteractor;
        this.f45377b = verificationNetworkRepository;
        this.f45378c = verificationFlowRepository;
        this.f45379d = userInputMapper;
        this.f45380e = closeFormInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b d(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (b) tmp0.s(obj, obj2);
    }

    private final Completable g(String str) {
        Observable<String> b8 = this.f45376a.b();
        Observable<Map<String, em>> d8 = this.f45378c.d(str);
        final c cVar = c.f45384f;
        Single firstOrError = Observable.combineLatest(b8, d8, new BiFunction() { // from class: eu.bolt.verification.sdk.internal.ix
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                uk.b d9;
                d9 = uk.d(Function2.this, obj, obj2);
                return d9;
            }
        }).firstOrError();
        final d dVar = new d(str);
        Single r7 = firstOrError.r(new Function() { // from class: eu.bolt.verification.sdk.internal.jx
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource h8;
                h8 = uk.h(Function1.this, obj);
                return h8;
            }
        });
        final e eVar = new e();
        Completable s7 = r7.s(new Function() { // from class: eu.bolt.verification.sdk.internal.kx
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource j8;
                j8 = uk.j(Function1.this, obj);
                return j8;
            }
        });
        Intrinsics.e(s7, "private fun refreshVerif…r.execute()\n            }");
        return s7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    public Completable f(a args) {
        Intrinsics.f(args, "args");
        return g(args.a());
    }
}
