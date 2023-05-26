package eu.bolt.verification.sdk.internal;

import android.net.Uri;
import eu.bolt.verification.sdk.internal.b1;
import eu.bolt.verification.sdk.internal.bh;
import eu.bolt.verification.sdk.internal.d;
import eu.bolt.verification.sdk.internal.d2;
import eu.bolt.verification.sdk.internal.em;
import eu.bolt.verification.sdk.internal.j9;
import eu.bolt.verification.sdk.internal.q;
import eu.bolt.verification.sdk.internal.qn;
import eu.bolt.verification.sdk.internal.sk;
import eu.bolt.verification.sdk.internal.uk;
import eu.bolt.verification.sdk.internal.wk;
import eu.bolt.verification.sdk.internal.x8;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class z8 {

    /* renamed from: a  reason: collision with root package name */
    private final rc f45823a;

    /* renamed from: b  reason: collision with root package name */
    private final d2 f45824b;

    /* renamed from: c  reason: collision with root package name */
    private final x8 f45825c;

    /* renamed from: d  reason: collision with root package name */
    private final sk f45826d;

    /* renamed from: e  reason: collision with root package name */
    private final wk f45827e;

    /* renamed from: f  reason: collision with root package name */
    private final uk f45828f;

    /* renamed from: g  reason: collision with root package name */
    private final bh f45829g;

    /* renamed from: h  reason: collision with root package name */
    private final xn f45830h;

    /* renamed from: i  reason: collision with root package name */
    private final x1 f45831i;

    /* renamed from: j  reason: collision with root package name */
    private final v8 f45832j;

    /* renamed from: k  reason: collision with root package name */
    private final mn f45833k;

    /* renamed from: l  reason: collision with root package name */
    private final tl f45834l;

    /* renamed from: m  reason: collision with root package name */
    private final s f45835m;

    /* renamed from: n  reason: collision with root package name */
    private final j9 f45836n;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b1.a> f45837a;

        public a(List<b1.a> actions) {
            Intrinsics.f(actions, "actions");
            this.f45837a = actions;
        }

        public final List<b1.a> a() {
            return this.f45837a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f45837a, ((a) obj).f45837a);
        }

        public int hashCode() {
            return this.f45837a.hashCode();
        }

        public String toString() {
            List<b1.a> list = this.f45837a;
            return "Args(actions=" + list + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<vd<eu.bolt.verification.sdk.internal.d>, CompletableSource> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final CompletableSource invoke(vd<eu.bolt.verification.sdk.internal.d> actionOptional) {
            Intrinsics.f(actionOptional, "actionOptional");
            if (actionOptional.f()) {
                eu.bolt.verification.sdk.internal.d action = actionOptional.d();
                z8 z8Var = z8.this;
                Intrinsics.e(action, "action");
                return z8Var.m(action);
            }
            return Completable.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<Map<String, ? extends em>, vd<eu.bolt.verification.sdk.internal.d>> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ List<b1.a> f45839f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ z8 f45840g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List<b1.a> list, z8 z8Var) {
            super(1);
            this.f45839f = list;
            this.f45840g = z8Var;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final vd<eu.bolt.verification.sdk.internal.d> invoke(Map<String, ? extends em> userInputs) {
            Object obj;
            vd<eu.bolt.verification.sdk.internal.d> c8;
            Intrinsics.f(userInputs, "userInputs");
            List<b1.a> list = this.f45839f;
            z8 z8Var = this.f45840g;
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (z8Var.r(((b1.a) obj).b(), userInputs)) {
                    break;
                }
            }
            b1.a aVar = (b1.a) obj;
            return (aVar == null || (c8 = vd.c(aVar.a())) == null) ? vd.a() : c8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<qn.b, CompletableSource> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d.g f45842g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(d.g gVar) {
            super(1);
            this.f45842g = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final CompletableSource invoke(qn.b flow) {
            Intrinsics.f(flow, "flow");
            sk skVar = z8.this.f45826d;
            String b8 = this.f45842g.b();
            String c8 = flow.c();
            Uri fromFile = Uri.fromFile(z8.this.f45833k.c(this.f45842g.b()));
            Intrinsics.e(fromFile, "fromFile(fileProvider.imageFile(action.stepId))");
            return skVar.c(new sk.a(b8, c8, fromFile));
        }
    }

    @Inject
    public z8(rc observeCurrentFlowInteractor, d2 conditionIsFeasibleChecker, x8 goToNextStepInteractor, sk submitMultiFormRequestInteractor, wk submitUserDataInteractor, uk submitUserDataAndCloseInteractor, bh sendPostRequestInteractor, xn verificationFlowRepository, x1 closeFormInteractor, v8 goBackInteractor, mn fileProvider, tl tryAgainInteractor, s analyticsManager, j9 handlePredefinedDataInteractor) {
        Intrinsics.f(observeCurrentFlowInteractor, "observeCurrentFlowInteractor");
        Intrinsics.f(conditionIsFeasibleChecker, "conditionIsFeasibleChecker");
        Intrinsics.f(goToNextStepInteractor, "goToNextStepInteractor");
        Intrinsics.f(submitMultiFormRequestInteractor, "submitMultiFormRequestInteractor");
        Intrinsics.f(submitUserDataInteractor, "submitUserDataInteractor");
        Intrinsics.f(submitUserDataAndCloseInteractor, "submitUserDataAndCloseInteractor");
        Intrinsics.f(sendPostRequestInteractor, "sendPostRequestInteractor");
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        Intrinsics.f(closeFormInteractor, "closeFormInteractor");
        Intrinsics.f(goBackInteractor, "goBackInteractor");
        Intrinsics.f(fileProvider, "fileProvider");
        Intrinsics.f(tryAgainInteractor, "tryAgainInteractor");
        Intrinsics.f(analyticsManager, "analyticsManager");
        Intrinsics.f(handlePredefinedDataInteractor, "handlePredefinedDataInteractor");
        this.f45823a = observeCurrentFlowInteractor;
        this.f45824b = conditionIsFeasibleChecker;
        this.f45825c = goToNextStepInteractor;
        this.f45826d = submitMultiFormRequestInteractor;
        this.f45827e = submitUserDataInteractor;
        this.f45828f = submitUserDataAndCloseInteractor;
        this.f45829g = sendPostRequestInteractor;
        this.f45830h = verificationFlowRepository;
        this.f45831i = closeFormInteractor;
        this.f45832j = goBackInteractor;
        this.f45833k = fileProvider;
        this.f45834l = tryAgainInteractor;
        this.f45835m = analyticsManager;
        this.f45836n = handlePredefinedDataInteractor;
    }

    private final Completable g() {
        return this.f45834l.f();
    }

    private final Completable h(d.f fVar) {
        return this.f45829g.c(new bh.a(fVar.c(), fVar.b()));
    }

    private final Completable i(d.g gVar) {
        Single<qn.b> firstOrError = this.f45823a.a().firstOrError();
        final d dVar = new d(gVar);
        Completable s7 = firstOrError.s(new Function() { // from class: eu.bolt.verification.sdk.internal.my
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource w7;
                w7 = z8.w(Function1.this, obj);
                return w7;
            }
        });
        Intrinsics.e(s7, "private fun handleSumbit…    )\n            }\n    }");
        return s7;
    }

    private final Completable j(d.h hVar) {
        em b8 = hVar.b();
        Intrinsics.d(b8, "null cannot be cast to non-null type eu.bolt.verification.core.domain.model.UserInput.PredefinedValue");
        em.e eVar = (em.e) b8;
        Completable d8 = this.f45836n.b(new j9.a(eVar.a(), new em.e(eVar.a(), eVar.b()))).d(this.f45827e.f(new wk.a(null)));
        Intrinsics.e(d8, "handlePredefinedDataInte…          )\n            )");
        return d8;
    }

    private final Completable k(d.i iVar) {
        return this.f45827e.f(new wk.a(iVar.b()));
    }

    private final Completable l(d.j jVar) {
        return this.f45828f.f(new uk.a(jVar.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable m(final eu.bolt.verification.sdk.internal.d dVar) {
        Completable u7;
        String str;
        e a8 = dVar.a();
        if (a8 != null) {
            this.f45835m.a(new q.i(a8.a(), a8.b()));
        }
        if (dVar instanceof d.c) {
            return this.f45825c.b(new x8.a(((d.c) dVar).b()));
        }
        if (dVar instanceof d.b) {
            return this.f45831i.b();
        }
        if (dVar instanceof d.C0042d) {
            u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.jy
                @Override // io.reactivex.functions.Action
                public final void run() {
                    z8.v(z8.this, dVar);
                }
            });
            str = "fromAction { verificatio…OpenBottomSheet(action) }";
        } else if (!(dVar instanceof d.e)) {
            if (dVar instanceof d.g) {
                return i((d.g) dVar);
            }
            if (dVar instanceof d.i) {
                return k((d.i) dVar);
            }
            if (dVar instanceof d.j) {
                return l((d.j) dVar);
            }
            if (dVar instanceof d.f) {
                return h((d.f) dVar);
            }
            if (dVar instanceof d.a) {
                return this.f45832j.e();
            }
            if (dVar instanceof d.k) {
                return g();
            }
            if (dVar instanceof d.h) {
                return j((d.h) dVar);
            }
            throw new NoWhenBranchMatchedException();
        } else {
            u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.ky
                @Override // io.reactivex.functions.Action
                public final void run() {
                    z8.x(z8.this, dVar);
                }
            });
            str = "fromAction { verificatio…uireOpenWebView(action) }";
        }
        Intrinsics.e(u7, str);
        return u7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    private final Single<vd<eu.bolt.verification.sdk.internal.d>> q(List<b1.a> list) {
        Single firstOrError = xn.c(this.f45830h, null, 1, null).firstOrError();
        final c cVar = new c(list, this);
        Single<vd<eu.bolt.verification.sdk.internal.d>> x7 = firstOrError.x(new Function() { // from class: eu.bolt.verification.sdk.internal.ly
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                vd u7;
                u7 = z8.u(Function1.this, obj);
                return u7;
            }
        });
        Intrinsics.e(x7, "private fun getActionByC…ent()\n            }\n    }");
        return x7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r(c2 c2Var, Map<String, ? extends em> map) {
        if (c2Var != null) {
            return this.f45824b.b(new d2.a(c2Var, map));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vd u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (vd) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(z8 this$0, eu.bolt.verification.sdk.internal.d action) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(action, "$action");
        this$0.f45830h.g((d.C0042d) action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(z8 this$0, eu.bolt.verification.sdk.internal.d action) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(action, "$action");
        this$0.f45830h.h((d.e) action);
    }

    public Completable n(a args) {
        Intrinsics.f(args, "args");
        Single<vd<eu.bolt.verification.sdk.internal.d>> q8 = q(args.a());
        final b bVar = new b();
        Completable s7 = q8.s(new Function() { // from class: eu.bolt.verification.sdk.internal.iy
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource p8;
                p8 = z8.p(Function1.this, obj);
                return p8;
            }
        });
        Intrinsics.e(s7, "override fun execute(arg…    }\n            }\n    }");
        return s7;
    }
}
