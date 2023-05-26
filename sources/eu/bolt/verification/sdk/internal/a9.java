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
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.rx2.RxAwaitKt;

/* loaded from: classes5.dex */
public final class a9 {

    /* renamed from: a  reason: collision with root package name */
    private final rc f41962a;

    /* renamed from: b  reason: collision with root package name */
    private final d2 f41963b;

    /* renamed from: c  reason: collision with root package name */
    private final x8 f41964c;

    /* renamed from: d  reason: collision with root package name */
    private final sk f41965d;

    /* renamed from: e  reason: collision with root package name */
    private final wk f41966e;

    /* renamed from: f  reason: collision with root package name */
    private final uk f41967f;

    /* renamed from: g  reason: collision with root package name */
    private final bh f41968g;

    /* renamed from: h  reason: collision with root package name */
    private final xn f41969h;

    /* renamed from: i  reason: collision with root package name */
    private final x1 f41970i;

    /* renamed from: j  reason: collision with root package name */
    private final v8 f41971j;

    /* renamed from: k  reason: collision with root package name */
    private final mn f41972k;

    /* renamed from: l  reason: collision with root package name */
    private final tl f41973l;

    /* renamed from: m  reason: collision with root package name */
    private final s f41974m;

    /* renamed from: n  reason: collision with root package name */
    private final j9 f41975n;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b1.a> f41976a;

        public a(List<b1.a> actions) {
            Intrinsics.f(actions, "actions");
            this.f41976a = actions;
        }

        public final List<b1.a> a() {
            return this.f41976a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f41976a, ((a) obj).f41976a);
        }

        public int hashCode() {
            return this.f41976a.hashCode();
        }

        public String toString() {
            List<b1.a> list = this.f41976a;
            return "Args(actions=" + list + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.domain.interactor.HandleButtonActionInteractorCo", f = "HandleButtonActionInteractorCo.kt", l = {36, 38}, m = "execute")
    /* loaded from: classes5.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: f  reason: collision with root package name */
        Object f41977f;

        /* renamed from: g  reason: collision with root package name */
        /* synthetic */ Object f41978g;

        /* renamed from: i  reason: collision with root package name */
        int f41980i;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f41978g = obj;
            this.f41980i |= Integer.MIN_VALUE;
            return a9.this.d(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.domain.interactor.HandleButtonActionInteractorCo", f = "HandleButtonActionInteractorCo.kt", l = {117}, m = "getActionByCondition")
    /* loaded from: classes5.dex */
    public static final class c extends ContinuationImpl {

        /* renamed from: f  reason: collision with root package name */
        Object f41981f;

        /* renamed from: g  reason: collision with root package name */
        Object f41982g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f41983h;

        /* renamed from: j  reason: collision with root package name */
        int f41985j;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f41983h = obj;
            this.f41985j |= Integer.MIN_VALUE;
            return a9.this.l(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<qn.b, CompletableSource> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d.g f41987g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(d.g gVar) {
            super(1);
            this.f41987g = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final CompletableSource invoke(qn.b flow) {
            Intrinsics.f(flow, "flow");
            sk skVar = a9.this.f41965d;
            String b8 = this.f41987g.b();
            String c8 = flow.c();
            Uri fromFile = Uri.fromFile(a9.this.f41972k.c(this.f41987g.b()));
            Intrinsics.e(fromFile, "fromFile(fileProvider.imageFile(action.stepId))");
            return skVar.c(new sk.a(b8, c8, fromFile));
        }
    }

    @Inject
    public a9(rc observeCurrentFlowInteractor, d2 conditionIsFeasibleChecker, x8 goToNextStepInteractor, sk submitMultiFormRequestInteractor, wk submitUserDataInteractor, uk submitUserDataAndCloseInteractor, bh sendPostRequestInteractor, xn verificationFlowRepository, x1 closeFormInteractor, v8 goBackInteractor, mn fileProvider, tl tryAgainInteractor, s analyticsManager, j9 handlePredefinedDataInteractor) {
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
        this.f41962a = observeCurrentFlowInteractor;
        this.f41963b = conditionIsFeasibleChecker;
        this.f41964c = goToNextStepInteractor;
        this.f41965d = submitMultiFormRequestInteractor;
        this.f41966e = submitUserDataInteractor;
        this.f41967f = submitUserDataAndCloseInteractor;
        this.f41968g = sendPostRequestInteractor;
        this.f41969h = verificationFlowRepository;
        this.f41970i = closeFormInteractor;
        this.f41971j = goBackInteractor;
        this.f41972k = fileProvider;
        this.f41973l = tryAgainInteractor;
        this.f41974m = analyticsManager;
        this.f41975n = handlePredefinedDataInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    private final Object f(d.f fVar, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = RxAwaitKt.a(this.f41968g.c(new bh.a(fVar.c(), fVar.b())), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        return a8 == d8 ? a8 : Unit.f50853a;
    }

    private final Object g(d.g gVar, Continuation<? super Unit> continuation) {
        Object d8;
        Single<qn.b> firstOrError = this.f41962a.a().firstOrError();
        final d dVar = new d(gVar);
        Completable s7 = firstOrError.s(new Function() { // from class: eu.bolt.verification.sdk.internal.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource c8;
                c8 = a9.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(s7, "private suspend fun hand…          }.await()\n    }");
        Object a8 = RxAwaitKt.a(s7, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        return a8 == d8 ? a8 : Unit.f50853a;
    }

    private final Object h(d.h hVar, Continuation<? super Unit> continuation) {
        Object d8;
        em b8 = hVar.b();
        Intrinsics.d(b8, "null cannot be cast to non-null type eu.bolt.verification.core.domain.model.UserInput.PredefinedValue");
        em.e eVar = (em.e) b8;
        Completable d9 = this.f41975n.b(new j9.a(eVar.a(), new em.e(eVar.a(), eVar.b()))).d(this.f41966e.f(new wk.a(null)));
        Intrinsics.e(d9, "handlePredefinedDataInte…          )\n            )");
        Object a8 = RxAwaitKt.a(d9, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        return a8 == d8 ? a8 : Unit.f50853a;
    }

    private final Object i(d.i iVar, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = RxAwaitKt.a(this.f41966e.f(new wk.a(iVar.b())), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        return a8 == d8 ? a8 : Unit.f50853a;
    }

    private final Object j(d.j jVar, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = RxAwaitKt.a(this.f41967f.f(new uk.a(jVar.b())), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        return a8 == d8 ? a8 : Unit.f50853a;
    }

    private final Object k(eu.bolt.verification.sdk.internal.d dVar, Continuation<? super Unit> continuation) {
        Object d8;
        Object d9;
        Object d10;
        Object d11;
        Object d12;
        Object d13;
        Object d14;
        Object d15;
        Object d16;
        e a8 = dVar.a();
        if (a8 != null) {
            this.f41974m.a(new q.i(a8.a(), a8.b()));
        }
        if (dVar instanceof d.c) {
            Object a9 = RxAwaitKt.a(this.f41964c.b(new x8.a(((d.c) dVar).b())), continuation);
            d16 = IntrinsicsKt__IntrinsicsKt.d();
            return a9 == d16 ? a9 : Unit.f50853a;
        } else if (dVar instanceof d.b) {
            Object a10 = RxAwaitKt.a(this.f41970i.b(), continuation);
            d15 = IntrinsicsKt__IntrinsicsKt.d();
            return a10 == d15 ? a10 : Unit.f50853a;
        } else {
            if (dVar instanceof d.C0042d) {
                this.f41969h.g((d.C0042d) dVar);
            } else if (!(dVar instanceof d.e)) {
                if (dVar instanceof d.g) {
                    Object g8 = g((d.g) dVar, continuation);
                    d14 = IntrinsicsKt__IntrinsicsKt.d();
                    return g8 == d14 ? g8 : Unit.f50853a;
                } else if (dVar instanceof d.i) {
                    Object i8 = i((d.i) dVar, continuation);
                    d13 = IntrinsicsKt__IntrinsicsKt.d();
                    return i8 == d13 ? i8 : Unit.f50853a;
                } else if (dVar instanceof d.j) {
                    Object j8 = j((d.j) dVar, continuation);
                    d12 = IntrinsicsKt__IntrinsicsKt.d();
                    return j8 == d12 ? j8 : Unit.f50853a;
                } else if (dVar instanceof d.f) {
                    Object f8 = f((d.f) dVar, continuation);
                    d11 = IntrinsicsKt__IntrinsicsKt.d();
                    return f8 == d11 ? f8 : Unit.f50853a;
                } else if (dVar instanceof d.a) {
                    Object a11 = RxAwaitKt.a(this.f41971j.e(), continuation);
                    d10 = IntrinsicsKt__IntrinsicsKt.d();
                    return a11 == d10 ? a11 : Unit.f50853a;
                } else if (dVar instanceof d.k) {
                    Object m8 = m(continuation);
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    return m8 == d9 ? m8 : Unit.f50853a;
                } else if (dVar instanceof d.h) {
                    Object h8 = h((d.h) dVar, continuation);
                    d8 = IntrinsicsKt__IntrinsicsKt.d();
                    return h8 == d8 ? h8 : Unit.f50853a;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                this.f41969h.h((d.e) dVar);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0074 A[EDGE_INSN: B:33:0x0074->B:24:0x0074 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(java.util.List<eu.bolt.verification.sdk.internal.b1.a> r6, kotlin.coroutines.Continuation<? super eu.bolt.verification.sdk.internal.vd<eu.bolt.verification.sdk.internal.d>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.verification.sdk.internal.a9.c
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.verification.sdk.internal.a9$c r0 = (eu.bolt.verification.sdk.internal.a9.c) r0
            int r1 = r0.f41985j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f41985j = r1
            goto L18
        L13:
            eu.bolt.verification.sdk.internal.a9$c r0 = new eu.bolt.verification.sdk.internal.a9$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f41983h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f41985j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f41982g
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r0 = r0.f41981f
            eu.bolt.verification.sdk.internal.a9 r0 = (eu.bolt.verification.sdk.internal.a9) r0
            kotlin.ResultKt.b(r7)
            goto L51
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.b(r7)
            eu.bolt.verification.sdk.internal.xn r7 = r5.f41969h
            io.reactivex.Observable r7 = eu.bolt.verification.sdk.internal.xn.c(r7, r4, r3, r4)
            r0.f41981f = r5
            r0.f41982g = r6
            r0.f41985j = r3
            java.lang.Object r7 = kotlinx.coroutines.rx2.RxAwaitKt.c(r7, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r0 = r5
        L51:
            java.util.Map r7 = (java.util.Map) r7
            java.util.Iterator r6 = r6.iterator()
        L57:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L74
            java.lang.Object r1 = r6.next()
            r2 = r1
            eu.bolt.verification.sdk.internal.b1$a r2 = (eu.bolt.verification.sdk.internal.b1.a) r2
            eu.bolt.verification.sdk.internal.c2 r2 = r2.b()
            java.lang.String r3 = "userInputs"
            kotlin.jvm.internal.Intrinsics.e(r7, r3)
            boolean r2 = r0.n(r2, r7)
            if (r2 == 0) goto L57
            r4 = r1
        L74:
            eu.bolt.verification.sdk.internal.b1$a r4 = (eu.bolt.verification.sdk.internal.b1.a) r4
            if (r4 == 0) goto L83
            eu.bolt.verification.sdk.internal.d r6 = r4.a()
            eu.bolt.verification.sdk.internal.vd r6 = eu.bolt.verification.sdk.internal.vd.c(r6)
            if (r6 == 0) goto L83
            goto L87
        L83:
            eu.bolt.verification.sdk.internal.vd r6 = eu.bolt.verification.sdk.internal.vd.a()
        L87:
            java.lang.String r7 = "verificationFlowReposito…al.absent()\n            }"
            kotlin.jvm.internal.Intrinsics.e(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.a9.l(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object m(Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = RxAwaitKt.a(this.f41973l.f(), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        return a8 == d8 ? a8 : Unit.f50853a;
    }

    private final boolean n(c2 c2Var, Map<String, ? extends em> map) {
        if (c2Var != null) {
            return this.f41963b.b(new d2.a(c2Var, map));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(eu.bolt.verification.sdk.internal.a9.a r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.verification.sdk.internal.a9.b
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.verification.sdk.internal.a9$b r0 = (eu.bolt.verification.sdk.internal.a9.b) r0
            int r1 = r0.f41980i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f41980i = r1
            goto L18
        L13:
            eu.bolt.verification.sdk.internal.a9$b r0 = new eu.bolt.verification.sdk.internal.a9$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f41978g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f41980i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L6e
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f41977f
            eu.bolt.verification.sdk.internal.a9 r6 = (eu.bolt.verification.sdk.internal.a9) r6
            kotlin.ResultKt.b(r7)
            goto L4f
        L3c:
            kotlin.ResultKt.b(r7)
            java.util.List r6 = r6.a()
            r0.f41977f = r5
            r0.f41980i = r4
            java.lang.Object r7 = r5.l(r6, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            r6 = r5
        L4f:
            eu.bolt.verification.sdk.internal.vd r7 = (eu.bolt.verification.sdk.internal.vd) r7
            boolean r2 = r7.f()
            if (r2 == 0) goto L71
            java.lang.Object r7 = r7.d()
            java.lang.String r2 = "action.get()"
            kotlin.jvm.internal.Intrinsics.e(r7, r2)
            eu.bolt.verification.sdk.internal.d r7 = (eu.bolt.verification.sdk.internal.d) r7
            r2 = 0
            r0.f41977f = r2
            r0.f41980i = r3
            java.lang.Object r6 = r6.k(r7, r0)
            if (r6 != r1) goto L6e
            return r1
        L6e:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L71:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.a9.d(eu.bolt.verification.sdk.internal.a9$a, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
