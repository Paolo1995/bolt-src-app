package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.android.rib.RibExtensionsKt;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.R$color;
import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.b1;
import eu.bolt.verification.sdk.internal.b7;
import eu.bolt.verification.sdk.internal.c8;
import eu.bolt.verification.sdk.internal.d;
import eu.bolt.verification.sdk.internal.d9;
import eu.bolt.verification.sdk.internal.em;
import eu.bolt.verification.sdk.internal.f9;
import eu.bolt.verification.sdk.internal.h9;
import eu.bolt.verification.sdk.internal.j9;
import eu.bolt.verification.sdk.internal.k7;
import eu.bolt.verification.sdk.internal.l9;
import eu.bolt.verification.sdk.internal.mg;
import eu.bolt.verification.sdk.internal.n7;
import eu.bolt.verification.sdk.internal.nh;
import eu.bolt.verification.sdk.internal.o2;
import eu.bolt.verification.sdk.internal.q;
import eu.bolt.verification.sdk.internal.u;
import eu.bolt.verification.sdk.internal.z8;
import eu.bolt.verification.sdk.internal.zc;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx2.RxAwaitKt;
import kotlinx.coroutines.rx2.RxConvertKt;

/* loaded from: classes5.dex */
public final class r7 extends BaseRibInteractor<u7> implements s2 {
    public static final b K = new b(null);
    private final v8 A;
    private final zc B;
    private final mg C;
    private final xf D;
    private final bg E;
    private final dl F;
    private a G;
    private String H;
    private mg.a I;
    private final String J;

    /* renamed from: n  reason: collision with root package name */
    private final q7 f44731n;

    /* renamed from: o  reason: collision with root package name */
    private final t7 f44732o;

    /* renamed from: p  reason: collision with root package name */
    private final xg f44733p;

    /* renamed from: q  reason: collision with root package name */
    private final n7 f44734q;

    /* renamed from: r  reason: collision with root package name */
    private final z8 f44735r;

    /* renamed from: s  reason: collision with root package name */
    private final a9 f44736s;

    /* renamed from: t  reason: collision with root package name */
    private final j9 f44737t;

    /* renamed from: u  reason: collision with root package name */
    private final c8 f44738u;

    /* renamed from: v  reason: collision with root package name */
    private final d9 f44739v;

    /* renamed from: w  reason: collision with root package name */
    private final l9 f44740w;

    /* renamed from: x  reason: collision with root package name */
    private final f9 f44741x;

    /* renamed from: y  reason: collision with root package name */
    private final h9 f44742y;

    /* renamed from: z  reason: collision with root package name */
    private final x1 f44743z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final k7.a f44744f;

        /* renamed from: g  reason: collision with root package name */
        private final eu.bolt.verification.sdk.internal.e f44745g;

        public a(k7.a action, eu.bolt.verification.sdk.internal.e eVar) {
            Intrinsics.f(action, "action");
            this.f44744f = action;
            this.f44745g = eVar;
        }

        public final k7.a a() {
            return this.f44744f;
        }

        public final eu.bolt.verification.sdk.internal.e b() {
            return this.f44745g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f44744f == aVar.f44744f && Intrinsics.a(this.f44745g, aVar.f44745g);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f44744f.hashCode() * 31;
            eu.bolt.verification.sdk.internal.e eVar = this.f44745g;
            return hashCode + (eVar == null ? 0 : eVar.hashCode());
        }

        public String toString() {
            k7.a aVar = this.f44744f;
            eu.bolt.verification.sdk.internal.e eVar = this.f44745g;
            return "BackNavigation(action=" + aVar + ", analytics=" + eVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44746a;

        static {
            int[] iArr = new int[k7.a.values().length];
            try {
                iArr[k7.a.CLOSE_FORM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[k7.a.GO_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f44746a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$closeForm$1", f = "FormBuilderRibInteractor.kt", l = {362}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44747g;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44747g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable b8 = r7.this.f44743z.b();
                this.f44747g = 1;
                if (RxAwaitKt.a(b8, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$goBack$1", f = "FormBuilderRibInteractor.kt", l = {374}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44749g;

        e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44749g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable e8 = r7.this.A.e();
                this.f44749g = 1;
                if (RxAwaitKt.a(e8, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$handleButtonClicks$1", f = "FormBuilderRibInteractor.kt", l = {301}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44751g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f44752h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ b1 f44754j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(b1 b1Var, Continuation<? super f> continuation) {
            super(2, continuation);
            this.f44754j = b1Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(this.f44754j, continuation);
            fVar.f44752h = obj;
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r1 = r4.f44751g
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.b(r5)     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                goto L49
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                kotlin.ResultKt.b(r5)
                java.lang.Object r5 = r4.f44752h
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                eu.bolt.verification.sdk.internal.r7 r5 = eu.bolt.verification.sdk.internal.r7.this
                eu.bolt.verification.sdk.internal.n7 r5 = eu.bolt.verification.sdk.internal.r7.z0(r5)
                eu.bolt.verification.sdk.internal.b1 r1 = r4.f44754j
                java.lang.String r1 = r1.a()
                r5.w(r1, r2)
                eu.bolt.verification.sdk.internal.r7 r5 = eu.bolt.verification.sdk.internal.r7.this
                eu.bolt.verification.sdk.internal.b1 r1 = r4.f44754j
                kotlin.Result$Companion r3 = kotlin.Result.f50818g     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                eu.bolt.verification.sdk.internal.a9 r5 = eu.bolt.verification.sdk.internal.r7.s0(r5)     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                eu.bolt.verification.sdk.internal.a9$a r3 = new eu.bolt.verification.sdk.internal.a9$a     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                java.util.List r1 = r1.b()     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                r3.<init>(r1)     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                r4.f44751g = r2     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                java.lang.Object r5 = r5.d(r3, r4)     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                if (r5 != r0) goto L49
                return r0
            L49:
                kotlin.Unit r5 = kotlin.Unit.f50853a     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L52 kotlinx.coroutines.TimeoutCancellationException -> L54
                goto L5f
            L50:
                r5 = move-exception
                goto L55
            L52:
                r5 = move-exception
                throw r5
            L54:
                r5 = move-exception
            L55:
                kotlin.Result$Companion r0 = kotlin.Result.f50818g
                java.lang.Object r5 = kotlin.ResultKt.a(r5)
                java.lang.Object r5 = kotlin.Result.b(r5)
            L5f:
                eu.bolt.verification.sdk.internal.r7 r0 = eu.bolt.verification.sdk.internal.r7.this
                java.lang.Throwable r5 = kotlin.Result.e(r5)
                if (r5 == 0) goto L6e
                eu.bolt.verification.sdk.internal.t7 r5 = eu.bolt.verification.sdk.internal.r7.A0(r0)
                r5.f(r2)
            L6e:
                eu.bolt.verification.sdk.internal.r7 r5 = eu.bolt.verification.sdk.internal.r7.this
                eu.bolt.verification.sdk.internal.n7 r5 = eu.bolt.verification.sdk.internal.r7.z0(r5)
                eu.bolt.verification.sdk.internal.b1 r0 = r4.f44754j
                java.lang.String r0 = r0.a()
                r1 = 0
                r5.w(r0, r1)
                kotlin.Unit r5 = kotlin.Unit.f50853a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.r7.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g extends Lambda implements Function1<Disposable, Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ b1 f44756g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(b1 b1Var) {
            super(1);
            this.f44756g = b1Var;
        }

        public final void b(Disposable disposable) {
            r7.this.f44734q.w(this.f44756g.a(), true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
            b(disposable);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class h extends Lambda implements Function1<Throwable, Unit> {
        h() {
            super(1);
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            r7.this.f44732o.f(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$handleCheckBoxOptionClicks$1", f = "FormBuilderRibInteractor.kt", l = {287}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44758g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ud f44760i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(ud udVar, Continuation<? super i> continuation) {
            super(2, continuation);
            this.f44760i = udVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new i(this.f44760i, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44758g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable e8 = r7.this.f44739v.e(new d9.a(this.f44760i));
                this.f44758g = 1;
                if (RxAwaitKt.a(e8, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$handleDateInput$1", f = "FormBuilderRibInteractor.kt", l = {334}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44761g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f44763i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Date f44764j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, Date date, Continuation<? super j> continuation) {
            super(2, continuation);
            this.f44763i = str;
            this.f44764j = date;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new j(this.f44763i, this.f44764j, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44761g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable b8 = r7.this.f44742y.b(new h9.a(this.f44763i, this.f44764j));
                this.f44761g = 1;
                if (RxAwaitKt.a(b8, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$handleParagraphUrlClick$2$1", f = "FormBuilderRibInteractor.kt", l = {257, 258}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        Object f44765g;

        /* renamed from: h  reason: collision with root package name */
        int f44766h;

        /* renamed from: i  reason: collision with root package name */
        private /* synthetic */ Object f44767i;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ em.e f44769k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ cm f44770l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(em.e eVar, cm cmVar, Continuation<? super k> continuation) {
            super(2, continuation);
            this.f44769k = eVar;
            this.f44770l = cmVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            k kVar = new k(this.f44769k, this.f44770l, continuation);
            kVar.f44767i = obj;
            return kVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r1 = r8.f44766h
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                goto L77
            L12:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1a:
                java.lang.Object r1 = r8.f44765g
                eu.bolt.verification.sdk.internal.cm r1 = (eu.bolt.verification.sdk.internal.cm) r1
                java.lang.Object r4 = r8.f44767i
                eu.bolt.verification.sdk.internal.r7 r4 = (eu.bolt.verification.sdk.internal.r7) r4
                kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                goto L53
            L26:
                kotlin.ResultKt.b(r9)
                java.lang.Object r9 = r8.f44767i
                kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
                eu.bolt.verification.sdk.internal.r7 r4 = eu.bolt.verification.sdk.internal.r7.this
                eu.bolt.verification.sdk.internal.em$e r9 = r8.f44769k
                eu.bolt.verification.sdk.internal.cm r1 = r8.f44770l
                kotlin.Result$Companion r5 = kotlin.Result.f50818g     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                eu.bolt.verification.sdk.internal.j9 r5 = eu.bolt.verification.sdk.internal.r7.x0(r4)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                eu.bolt.verification.sdk.internal.j9$a r6 = new eu.bolt.verification.sdk.internal.j9$a     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                java.lang.String r7 = r9.a()     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                r6.<init>(r7, r9)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                io.reactivex.Completable r9 = r5.b(r6)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                r8.f44767i = r4     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                r8.f44765g = r1     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                r8.f44766h = r3     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                java.lang.Object r9 = kotlinx.coroutines.rx2.RxAwaitKt.a(r9, r8)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                if (r9 != r0) goto L53
                return r0
            L53:
                eu.bolt.verification.sdk.internal.a9 r9 = eu.bolt.verification.sdk.internal.r7.s0(r4)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                eu.bolt.verification.sdk.internal.a9$a r4 = new eu.bolt.verification.sdk.internal.a9$a     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                eu.bolt.verification.sdk.internal.b1$a r5 = new eu.bolt.verification.sdk.internal.b1$a     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                eu.bolt.verification.sdk.internal.d r1 = r1.a()     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                r6 = 0
                r5.<init>(r1, r6)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                java.util.List r1 = kotlin.collections.CollectionsKt.e(r5)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                r4.<init>(r1)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                r8.f44767i = r6     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                r8.f44765g = r6     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                r8.f44766h = r2     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                java.lang.Object r9 = r9.d(r4, r8)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                if (r9 != r0) goto L77
                return r0
            L77:
                kotlin.Unit r9 = kotlin.Unit.f50853a     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                java.lang.Object r9 = kotlin.Result.b(r9)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L80 kotlinx.coroutines.TimeoutCancellationException -> L82
                goto L8d
            L7e:
                r9 = move-exception
                goto L83
            L80:
                r9 = move-exception
                throw r9
            L82:
                r9 = move-exception
            L83:
                kotlin.Result$Companion r0 = kotlin.Result.f50818g
                java.lang.Object r9 = kotlin.ResultKt.a(r9)
                java.lang.Object r9 = kotlin.Result.b(r9)
            L8d:
                eu.bolt.verification.sdk.internal.r7 r0 = eu.bolt.verification.sdk.internal.r7.this
                java.lang.Throwable r9 = kotlin.Result.e(r9)
                if (r9 == 0) goto L9c
                eu.bolt.verification.sdk.internal.t7 r9 = eu.bolt.verification.sdk.internal.r7.A0(r0)
                r9.f(r3)
            L9c:
                kotlin.Unit r9 = kotlin.Unit.f50853a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.r7.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class l extends Lambda implements Function1<Throwable, Unit> {
        l() {
            super(1);
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            r7.this.f44732o.f(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$handleTextInput$1", f = "FormBuilderRibInteractor.kt", l = {322}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44772g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f44774i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f44775j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, String str2, Continuation<? super m> continuation) {
            super(2, continuation);
            this.f44774i = str;
            this.f44775j = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new m(this.f44774i, this.f44775j, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44772g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable b8 = r7.this.f44740w.b(new l9.a(this.f44774i, this.f44775j));
                this.f44772g = 1;
                if (RxAwaitKt.a(b8, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$observeUiEvents$1", f = "FormBuilderRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class n extends SuspendLambda implements Function2<n7.b, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44776g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f44777h;

        n(Continuation<? super n> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            n nVar = new n(continuation);
            nVar.f44777h = obj;
            return nVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(n7.b bVar, Continuation<? super Unit> continuation) {
            return ((n) create(bVar, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f44776g == 0) {
                ResultKt.b(obj);
                n7.b bVar = (n7.b) this.f44777h;
                if (bVar instanceof n7.b.C0075b) {
                    r7.this.c0(((n7.b.C0075b) bVar).a());
                } else if (bVar instanceof n7.b.a) {
                    x.a(Boxing.a(r7.this.z(false)));
                } else if (bVar instanceof n7.b.c) {
                    r7.this.i0(((n7.b.c) bVar).a());
                } else if (bVar instanceof n7.b.g) {
                    n7.b.g gVar = (n7.b.g) bVar;
                    r7.this.j0(gVar.a(), gVar.b());
                } else if (bVar instanceof n7.b.d) {
                    n7.b.d dVar = (n7.b.d) bVar;
                    r7.this.l0(dVar.a().a(), dVar.a().b());
                } else if (bVar instanceof n7.b.e) {
                    n7.b.e eVar = (n7.b.e) bVar;
                    r7.this.k0(eVar.a(), eVar.b());
                } else if (bVar instanceof n7.b.f) {
                    n7.b.f fVar = (n7.b.f) bVar;
                    r7.this.r0(fVar.a(), fVar.b());
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* loaded from: classes5.dex */
    public static final class o implements Flow<b8> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f44779f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ r7 f44780g;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f44781f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ r7 f44782g;

            @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$observeUiModel$$inlined$map$1$2", f = "FormBuilderRibInteractor.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.r7$o$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0084a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f44783f;

                /* renamed from: g  reason: collision with root package name */
                int f44784g;

                public C0084a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f44783f = obj;
                    this.f44784g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector, r7 r7Var) {
                this.f44781f = flowCollector;
                this.f44782g = r7Var;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof eu.bolt.verification.sdk.internal.r7.o.a.C0084a
                    if (r0 == 0) goto L13
                    r0 = r7
                    eu.bolt.verification.sdk.internal.r7$o$a$a r0 = (eu.bolt.verification.sdk.internal.r7.o.a.C0084a) r0
                    int r1 = r0.f44784g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f44784g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.r7$o$a$a r0 = new eu.bolt.verification.sdk.internal.r7$o$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.f44783f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f44784g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r7)
                    goto L67
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    kotlin.ResultKt.b(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r5.f44781f
                    eu.bolt.verification.sdk.internal.zc$b r6 = (eu.bolt.verification.sdk.internal.zc.b) r6
                    boolean r2 = r6 instanceof eu.bolt.verification.sdk.internal.zc.b.a
                    if (r2 == 0) goto L4a
                    eu.bolt.verification.sdk.internal.r7 r2 = r5.f44782g
                    java.lang.String r4 = "result"
                    kotlin.jvm.internal.Intrinsics.e(r6, r4)
                    eu.bolt.verification.sdk.internal.zc$b$a r6 = (eu.bolt.verification.sdk.internal.zc.b.a) r6
                    eu.bolt.verification.sdk.internal.b8 r6 = eu.bolt.verification.sdk.internal.r7.Z(r2, r6)
                    goto L5e
                L4a:
                    boolean r2 = r6 instanceof eu.bolt.verification.sdk.internal.zc.b.C0101b
                    if (r2 == 0) goto L6a
                    eu.bolt.verification.sdk.internal.ac$b r2 = eu.bolt.verification.sdk.internal.ac.b.f42045b
                    eu.bolt.logger.Logger r2 = r2.d()
                    eu.bolt.verification.sdk.internal.zc$b$b r6 = (eu.bolt.verification.sdk.internal.zc.b.C0101b) r6
                    java.lang.Throwable r6 = r6.a()
                    r2.c(r6)
                    r6 = 0
                L5e:
                    r0.f44784g = r3
                    java.lang.Object r6 = r7.b(r6, r0)
                    if (r6 != r1) goto L67
                    return r1
                L67:
                    kotlin.Unit r6 = kotlin.Unit.f50853a
                    return r6
                L6a:
                    kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                    r6.<init>()
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.r7.o.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public o(Flow flow, r7 r7Var) {
            this.f44779f = flow;
            this.f44780g = r7Var;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super b8> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f44779f.a(new a(flowCollector, this.f44780g), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$observeUiModel$2", f = "FormBuilderRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class p extends SuspendLambda implements Function2<b8, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44786g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f44787h;

        p(Continuation<? super p> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            p pVar = new p(continuation);
            pVar.f44787h = obj;
            return pVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(b8 b8Var, Continuation<? super Unit> continuation) {
            return ((p) create(b8Var, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f44786g == 0) {
                ResultKt.b(obj);
                r7.this.f44734q.v((b8) this.f44787h);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class q extends Lambda implements Function1<zc.b, ObservableSource<? extends zc.b.a>> {

        /* renamed from: f  reason: collision with root package name */
        public static final q f44789f = new q();

        q() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final ObservableSource<? extends zc.b.a> invoke(zc.b result) {
            Intrinsics.f(result, "result");
            if (result instanceof zc.b.a) {
                return Observable.just(result);
            }
            if (result instanceof zc.b.C0101b) {
                ac.b.f42045b.d().c(((zc.b.C0101b) result).a());
                return Observable.never();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class r extends Lambda implements Function1<zc.b.a, b8> {
        r() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final b8 invoke(zc.b.a it) {
            Intrinsics.f(it, "it");
            return r7.this.a0(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class s extends Lambda implements Function1<b8, Unit> {
        s() {
            super(1);
        }

        public final void b(b8 uiModel) {
            n7 n7Var = r7.this.f44734q;
            Intrinsics.e(uiModel, "uiModel");
            n7Var.v(uiModel);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(b8 b8Var) {
            b(b8Var);
            return Unit.f50853a;
        }
    }

    @DebugMetadata(c = "eu.bolt.verification.core.rib.formbuilder.FormBuilderRibInteractor$onCountrySelected$1", f = "FormBuilderRibInteractor.kt", l = {216}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class t extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44792g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f44794i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ h2 f44795j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(String str, h2 h2Var, Continuation<? super t> continuation) {
            super(2, continuation);
            this.f44794i = str;
            this.f44795j = h2Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new t(this.f44794i, this.f44795j, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((t) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44792g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable b8 = r7.this.f44741x.b(new f9.a(this.f44794i, this.f44795j));
                this.f44792g = 1;
                if (RxAwaitKt.a(b8, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            DynamicStateController.g(((u7) r7.this.L()).f1(), false, 1, null);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    /* synthetic */ class u extends AdaptedFunctionReference implements Function0<Unit> {
        u(Object obj) {
            super(0, obj, DynamicStateController1Arg.class, "detach", "detach(Z)V", 0);
        }

        public final void c() {
            DynamicStateController.g((DynamicStateController1Arg) this.f50976f, false, 1, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            c();
            return Unit.f50853a;
        }
    }

    @Inject
    public r7(q7 args, t7 ribListener, xg rxSchedulers, n7 presenter, z8 handleButtonActionInteractor, a9 handleButtonActionInteractorCo, j9 handlePredefinedDataInteractor, c8 formUiModelMapper, d9 handleCheckBoxOptionSelectedInteractor, l9 handleTextInputInteractor, f9 handleCountrySelectedInteractor, h9 handleDateInputInteractor, x1 closeFormInteractor, v8 goBackInteractor, zc observeFormModelInteractor, mg windowController, xf resourcesProvider, bg analyticsManager, dl targetingManager) {
        Intrinsics.f(args, "args");
        Intrinsics.f(ribListener, "ribListener");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(presenter, "presenter");
        Intrinsics.f(handleButtonActionInteractor, "handleButtonActionInteractor");
        Intrinsics.f(handleButtonActionInteractorCo, "handleButtonActionInteractorCo");
        Intrinsics.f(handlePredefinedDataInteractor, "handlePredefinedDataInteractor");
        Intrinsics.f(formUiModelMapper, "formUiModelMapper");
        Intrinsics.f(handleCheckBoxOptionSelectedInteractor, "handleCheckBoxOptionSelectedInteractor");
        Intrinsics.f(handleTextInputInteractor, "handleTextInputInteractor");
        Intrinsics.f(handleCountrySelectedInteractor, "handleCountrySelectedInteractor");
        Intrinsics.f(handleDateInputInteractor, "handleDateInputInteractor");
        Intrinsics.f(closeFormInteractor, "closeFormInteractor");
        Intrinsics.f(goBackInteractor, "goBackInteractor");
        Intrinsics.f(observeFormModelInteractor, "observeFormModelInteractor");
        Intrinsics.f(windowController, "windowController");
        Intrinsics.f(resourcesProvider, "resourcesProvider");
        Intrinsics.f(analyticsManager, "analyticsManager");
        Intrinsics.f(targetingManager, "targetingManager");
        this.f44731n = args;
        this.f44732o = ribListener;
        this.f44733p = rxSchedulers;
        this.f44734q = presenter;
        this.f44735r = handleButtonActionInteractor;
        this.f44736s = handleButtonActionInteractorCo;
        this.f44737t = handlePredefinedDataInteractor;
        this.f44738u = formUiModelMapper;
        this.f44739v = handleCheckBoxOptionSelectedInteractor;
        this.f44740w = handleTextInputInteractor;
        this.f44741x = handleCountrySelectedInteractor;
        this.f44742y = handleDateInputInteractor;
        this.f44743z = closeFormInteractor;
        this.A = goBackInteractor;
        this.B = observeFormModelInteractor;
        this.C = windowController;
        this.D = resourcesProvider;
        this.E = analyticsManager;
        this.F = targetingManager;
        this.J = "FormBuilder";
    }

    private final void a() {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new d(null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.f44743z.b(), null, null, null, 7, null), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b8 a0(zc.b.a aVar) {
        this.G = new a(aVar.a().b(), aVar.a().c());
        c8 c8Var = this.f44738u;
        nh d8 = aVar.a().d();
        Intrinsics.d(d8, "null cannot be cast to non-null type eu.bolt.verification.core.domain.model.StepLayout.FormLayout");
        return c8Var.a(new c8.a((nh.b) d8, aVar.b(), aVar.a().b(), aVar.a().f().a()));
    }

    private final void b() {
        this.C.e(mg.c.SOFT_INPUT_ADJUST_RESIZE);
        this.C.c(true);
        this.C.f(true);
        this.C.a();
        this.C.d(Integer.valueOf(this.D.d(R$color.F)));
        this.C.h(this.D.d(R$color.A), true);
    }

    private final void c() {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new e(null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.A.e(), null, null, null, 7, null), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(final b1 b1Var) {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new f(b1Var, null), 3, null);
            return;
        }
        Completable z7 = this.f44735r.n(new z8.a(b1Var.b())).z(this.f44733p.c());
        final g gVar = new g(b1Var);
        Completable m8 = z7.r(new Consumer() { // from class: eu.bolt.verification.sdk.internal.qv
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r7.m0(Function1.this, obj);
            }
        }).m(new Action() { // from class: eu.bolt.verification.sdk.internal.rv
            @Override // io.reactivex.functions.Action
            public final void run() {
                r7.p0(r7.this, b1Var);
            }
        });
        Intrinsics.e(m8, "private fun handleButton…osables()\n        }\n    }");
        BaseRibInteractor.S(this, ug.p(m8, null, new h(), null, 5, null), null, 1, null);
    }

    private final void e() {
        BaseScopeOwner.H(this, this.f44734q.p(), new n(null), null, null, null, false, 30, null);
    }

    private final void g() {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, FlowKt.o(new o(RxConvertKt.b(this.B.h(new zc.a(this.f44731n.d(), this.f44731n.e()))), this)), new p(null), null, null, null, false, 30, null);
            return;
        }
        Observable<zc.b> h8 = this.B.h(new zc.a(this.f44731n.d(), this.f44731n.e()));
        final q qVar = q.f44789f;
        Observable<R> switchMap = h8.switchMap(new Function() { // from class: eu.bolt.verification.sdk.internal.sv
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource o02;
                o02 = r7.o0(Function1.this, obj);
                return o02;
            }
        });
        final r rVar = new r();
        Observable observeOn = switchMap.map(new Function() { // from class: eu.bolt.verification.sdk.internal.tv
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                b8 t02;
                t02 = r7.t0(Function1.this, obj);
                return t02;
            }
        }).observeOn(this.f44733p.c());
        Intrinsics.e(observeOn, "private fun observeUiMod…osables()\n        }\n    }");
        BaseRibInteractor.S(this, ug.r(observeOn, new s(), null, null, null, null, 30, null), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(ud udVar) {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new i(udVar, null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.f44739v.e(new d9.a(udVar)), null, null, null, 7, null), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(String str, String str2) {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new m(str, str2, null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.f44740w.b(new l9.a(str, str2)), null, null, null, 7, null), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(String str, Date date) {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new j(str, date, null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.f44742y.b(new h9.a(str, date)), null, null, null, 7, null), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(String str, List<? extends h2> list) {
        Set L0;
        o2.a bVar;
        this.H = str;
        if (list == null || list.isEmpty()) {
            bVar = o2.a.C0078a.f44375f;
        } else {
            L0 = CollectionsKt___CollectionsKt.L0(list);
            bVar = new o2.a.b(L0);
        }
        DynamicStateController1Arg.k(((u7) L()).f1(), new o2(o2.b.C0079b.f44380g, bVar, false, false, 8, null), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource o0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(r7 this$0, b1 button) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(button, "$button");
        this$0.f44734q.w(button.a(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(String str, List<cm> list) {
        Object obj;
        List e8;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.a(str, ((cm) obj).b())) {
                break;
            }
        }
        cm cmVar = (cm) obj;
        if (cmVar != null) {
            eu.bolt.verification.sdk.internal.d a8 = cmVar.a();
            Intrinsics.d(a8, "null cannot be cast to non-null type eu.bolt.verification.core.domain.model.Action.SubmitPredefinedData");
            em b8 = ((d.h) a8).b();
            Intrinsics.d(b8, "null cannot be cast to non-null type eu.bolt.verification.core.domain.model.UserInput.PredefinedValue");
            em.e eVar = (em.e) b8;
            if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
                BaseScopeOwner.F(this, null, null, new k(eVar, cmVar, null), 3, null);
                return;
            }
            Completable b9 = this.f44737t.b(new j9.a(eVar.a(), eVar));
            z8 z8Var = this.f44735r;
            e8 = CollectionsKt__CollectionsJVMKt.e(new b1.a(cmVar.a(), null));
            Completable z7 = b9.d(z8Var.n(new z8.a(e8))).z(this.f44733p.c());
            Intrinsics.e(z7, "handlePredefinedDataInte…erveOn(rxSchedulers.main)");
            BaseRibInteractor.S(this, ug.p(z7, null, new l(), null, 5, null), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b8 t0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (b8) tmp0.invoke(obj);
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        mg.a b8;
        super.K(bundle);
        this.G = bundle != null ? (a) RibExtensionsKt.b(bundle, "back_navigation") : new a(this.f44731n.a(), this.f44731n.b());
        this.H = bundle != null ? bundle.d("select_country_field_id") : null;
        if (bundle == null || (b8 = (mg.a) RibExtensionsKt.b(bundle, "window_config")) == null) {
            b8 = this.C.b();
        }
        this.I = b8;
        b();
        g();
        e();
        k7.b c8 = this.f44731n.c();
        if (c8 != null) {
            this.E.b(this, new u.d(c8.b(), c8.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void P() {
        mg.a aVar = this.I;
        if (aVar != null) {
            this.C.g(aVar);
        }
        super.P();
    }

    @Override // eu.bolt.verification.sdk.internal.s2
    public void f(boolean z7) {
        DynamicStateController.g(((u7) L()).f1(), false, 1, null);
    }

    @Override // eu.bolt.verification.sdk.internal.s2
    public void n(h2 country) {
        Intrinsics.f(country, "country");
        String str = this.H;
        if (str == null) {
            DynamicStateController.g(((u7) L()).f1(), false, 1, null);
        } else if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new t(str, country, null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.f44741x.b(new f9.a(str, country)), new u(((u7) L()).f1()), null, null, 6, null), null, 1, null);
        }
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public void x(Bundle outState) {
        Intrinsics.f(outState, "outState");
        outState.h("back_navigation", this.G);
        outState.i("select_country_field_id", this.H);
        outState.h("window_config", this.I);
        super.x(outState);
    }

    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        eu.bolt.verification.sdk.internal.e b8;
        a aVar = this.G;
        if (aVar != null && (b8 = aVar.b()) != null) {
            this.E.d(new q.i(b8.a(), b8.b()));
        }
        a aVar2 = this.G;
        k7.a a8 = aVar2 != null ? aVar2.a() : null;
        int i8 = a8 == null ? -1 : c.f44746a[a8.ordinal()];
        if (i8 == 1) {
            a();
        } else if (i8 == 2) {
            c();
        }
        return true;
    }
}
