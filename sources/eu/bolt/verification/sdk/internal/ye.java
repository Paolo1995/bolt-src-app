package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.em;
import eu.bolt.verification.sdk.internal.nh;
import eu.bolt.verification.sdk.internal.ye;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class ye {

    /* renamed from: a  reason: collision with root package name */
    private final xn f45744a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<k7> f45745a;

        public a(List<k7> steps) {
            Intrinsics.f(steps, "steps");
            this.f45745a = steps;
        }

        public final List<k7> a() {
            return this.f45745a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f45745a, ((a) obj).f45745a);
        }

        public int hashCode() {
            return this.f45745a.hashCode();
        }

        public String toString() {
            List<k7> list = this.f45745a;
            return "Args(steps=" + list + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<Map<String, ? extends em>, CompletableSource> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ a f45746f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ye f45747g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar, ye yeVar) {
            super(1);
            this.f45746f = aVar;
            this.f45747g = yeVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(a args, ye this$0, Map userInputs) {
            Intrinsics.f(args, "$args");
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(userInputs, "$userInputs");
            for (k7 k7Var : args.a()) {
                this$0.f(k7Var, userInputs);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c */
        public final CompletableSource invoke(final Map<String, ? extends em> userInputs) {
            Intrinsics.f(userInputs, "userInputs");
            final a aVar = this.f45746f;
            final ye yeVar = this.f45747g;
            return Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.dy
                @Override // io.reactivex.functions.Action
                public final void run() {
                    ye.b.d(ye.a.this, yeVar, userInputs);
                }
            });
        }
    }

    @Inject
    public ye(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f45744a = verificationFlowRepository;
    }

    private final em b(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return new em.a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    private final void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(k7 k7Var, Map<String, ? extends em> map) {
        nh d8 = k7Var.d();
        if (d8 instanceof nh.b) {
            h(k7Var.e(), (nh.b) k7Var.d(), map);
        } else if (!(d8 instanceof nh.a)) {
            throw new NoWhenBranchMatchedException();
        } else {
            e();
        }
        Unit unit = Unit.f50853a;
    }

    private final void h(String str, nh.b bVar, Map<String, ? extends em> map) {
        for (ob obVar : bVar.c()) {
            if (!map.containsKey(obVar.a())) {
                i(str, obVar);
            }
        }
    }

    private final void i(String str, ob obVar) {
        this.f45744a.k(obVar.a(), obVar instanceof k2 ? new em.b(((k2) obVar).c().c()) : obVar instanceof r1 ? b(((r1) obVar).b()) : null, str);
    }

    public Completable c(a args) {
        Intrinsics.f(args, "args");
        Single firstOrError = xn.c(this.f45744a, null, 1, null).firstOrError();
        final b bVar = new b(args, this);
        Completable s7 = firstOrError.s(new Function() { // from class: eu.bolt.verification.sdk.internal.cy
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource d8;
                d8 = ye.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(s7, "override fun execute(arg…    }\n            }\n    }");
        return s7;
    }
}
