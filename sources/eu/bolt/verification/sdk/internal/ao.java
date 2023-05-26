package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.android.rib.multistack.BaseMultiStackRouter;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.R$string;
import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import eu.bolt.verification.sdk.internal.a9;
import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.ao;
import eu.bolt.verification.sdk.internal.b1;
import eu.bolt.verification.sdk.internal.b7;
import eu.bolt.verification.sdk.internal.cr;
import eu.bolt.verification.sdk.internal.d;
import eu.bolt.verification.sdk.internal.db;
import eu.bolt.verification.sdk.internal.ia;
import eu.bolt.verification.sdk.internal.kp;
import eu.bolt.verification.sdk.internal.l6;
import eu.bolt.verification.sdk.internal.ld;
import eu.bolt.verification.sdk.internal.ll;
import eu.bolt.verification.sdk.internal.m6;
import eu.bolt.verification.sdk.internal.nh;
import eu.bolt.verification.sdk.internal.of;
import eu.bolt.verification.sdk.internal.oh;
import eu.bolt.verification.sdk.internal.qn;
import eu.bolt.verification.sdk.internal.x8;
import eu.bolt.verification.sdk.internal.y6;
import eu.bolt.verification.sdk.internal.z8;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx2.RxAwaitKt;
import kotlinx.coroutines.rx2.RxConvertKt;

/* loaded from: classes5.dex */
public final class ao extends zn<eo> implements hn, t7, v0, aj, cr, y6 {
    private static final a P = new a(null);
    private final a9 A;
    private final dd B;
    private final fd C;
    private final eu.bolt.verification.sdk.internal.l0 D;
    private final db E;
    private final hd F;
    private final of G;
    private final dl H;
    private final jd I;
    private final oh J;
    private VerificationFlowStatus K;
    private kp L;
    private Job M;
    private Disposable N;
    private final String O;

    /* renamed from: n  reason: collision with root package name */
    private final yn f42122n;

    /* renamed from: o  reason: collision with root package name */
    private final co f42123o;

    /* renamed from: p  reason: collision with root package name */
    private final xg f42124p;

    /* renamed from: q  reason: collision with root package name */
    private final ia f42125q;

    /* renamed from: r  reason: collision with root package name */
    private final rc f42126r;

    /* renamed from: s  reason: collision with root package name */
    private final vc f42127s;

    /* renamed from: t  reason: collision with root package name */
    private final xc f42128t;

    /* renamed from: u  reason: collision with root package name */
    private final ld f42129u;

    /* renamed from: v  reason: collision with root package name */
    private final pc f42130v;

    /* renamed from: w  reason: collision with root package name */
    private final mn f42131w;

    /* renamed from: x  reason: collision with root package name */
    private final x8 f42132x;

    /* renamed from: y  reason: collision with root package name */
    private final nc f42133y;

    /* renamed from: z  reason: collision with root package name */
    private final z8 f42134z;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$onCloseWebPageRib$1$1$1", f = "VerificationFlowRibInteractorImpl.kt", l = {250}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class a0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42135g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f42136h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f42138j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a0(String str, Continuation<? super a0> continuation) {
            super(2, continuation);
            this.f42138j = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a0 a0Var = new a0(this.f42138j, continuation);
            a0Var.f42136h = obj;
            return a0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a0) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r1 = r4.f42135g
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.b(r5)     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                goto L3a
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                kotlin.ResultKt.b(r5)
                java.lang.Object r5 = r4.f42136h
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                eu.bolt.verification.sdk.internal.ao r5 = eu.bolt.verification.sdk.internal.ao.this
                java.lang.String r1 = r4.f42138j
                kotlin.Result$Companion r3 = kotlin.Result.f50818g     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                eu.bolt.verification.sdk.internal.of r5 = eu.bolt.verification.sdk.internal.ao.S0(r5)     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                eu.bolt.verification.sdk.internal.of$a r3 = new eu.bolt.verification.sdk.internal.of$a     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                r3.<init>(r1)     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                io.reactivex.Completable r5 = r5.a(r3)     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                r4.f42135g = r2     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                java.lang.Object r5 = kotlinx.coroutines.rx2.RxAwaitKt.a(r5, r4)     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                if (r5 != r0) goto L3a
                return r0
            L3a:
                kotlin.Unit r5 = kotlin.Unit.f50853a     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Exception -> L41 java.util.concurrent.CancellationException -> L43 kotlinx.coroutines.TimeoutCancellationException -> L45
                goto L50
            L41:
                r5 = move-exception
                goto L46
            L43:
                r5 = move-exception
                throw r5
            L45:
                r5 = move-exception
            L46:
                kotlin.Result$Companion r0 = kotlin.Result.f50818g
                java.lang.Object r5 = kotlin.ResultKt.a(r5)
                java.lang.Object r5 = kotlin.Result.b(r5)
            L50:
                eu.bolt.verification.sdk.internal.ao r0 = eu.bolt.verification.sdk.internal.ao.this
                java.lang.Throwable r5 = kotlin.Result.e(r5)
                if (r5 == 0) goto L5b
                r0.f(r2)
            L5b:
                kotlin.Unit r5 = kotlin.Unit.f50853a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ao.a0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f42139a;

        /* renamed from: b  reason: collision with root package name */
        private final long f42140b;

        public b(boolean z7, long j8) {
            this.f42139a = z7;
            this.f42140b = j8;
        }

        public /* synthetic */ b(boolean z7, long j8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(z7, (i8 & 2) != 0 ? 0L : j8);
        }

        public final long a() {
            return this.f42140b;
        }

        public final boolean b() {
            return this.f42139a;
        }
    }

    /* loaded from: classes5.dex */
    static final class b0 extends Lambda implements Function1<Throwable, Unit> {
        b0() {
            super(1);
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            ao.this.f(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$initFlow$1", f = "VerificationFlowRibInteractorImpl.kt", l = {361}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42142g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f42143h;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(continuation);
            cVar.f42143h = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r1 = r4.f42142g
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.b(r5)     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                goto L40
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                kotlin.ResultKt.b(r5)
                java.lang.Object r5 = r4.f42143h
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                eu.bolt.verification.sdk.internal.ao r5 = eu.bolt.verification.sdk.internal.ao.this
                kotlin.Result$Companion r1 = kotlin.Result.f50818g     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                eu.bolt.verification.sdk.internal.ia r1 = eu.bolt.verification.sdk.internal.ao.I0(r5)     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                eu.bolt.verification.sdk.internal.ia$a r3 = new eu.bolt.verification.sdk.internal.ia$a     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                eu.bolt.verification.sdk.internal.yn r5 = eu.bolt.verification.sdk.internal.ao.D0(r5)     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                java.lang.String r5 = r5.a()     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                r3.<init>(r5)     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                io.reactivex.Completable r5 = r1.d(r3)     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                r4.f42142g = r2     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                java.lang.Object r5 = kotlinx.coroutines.rx2.RxAwaitKt.a(r5, r4)     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                if (r5 != r0) goto L40
                return r0
            L40:
                kotlin.Unit r5 = kotlin.Unit.f50853a     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Exception -> L47 java.util.concurrent.CancellationException -> L49 kotlinx.coroutines.TimeoutCancellationException -> L4b
                goto L56
            L47:
                r5 = move-exception
                goto L4c
            L49:
                r5 = move-exception
                throw r5
            L4b:
                r5 = move-exception
            L4c:
                kotlin.Result$Companion r0 = kotlin.Result.f50818g
                java.lang.Object r5 = kotlin.ResultKt.a(r5)
                java.lang.Object r5 = kotlin.Result.b(r5)
            L56:
                eu.bolt.verification.sdk.internal.ao r0 = eu.bolt.verification.sdk.internal.ao.this
                java.lang.Throwable r5 = kotlin.Result.e(r5)
                if (r5 == 0) goto L6b
                eu.bolt.verification.sdk.internal.ac$b r1 = eu.bolt.verification.sdk.internal.ac.b.f42045b
                eu.bolt.logger.Logger r1 = r1.d()
                r1.c(r5)
                r5 = 0
                eu.bolt.verification.sdk.internal.ao.p0(r0, r5)
            L6b:
                kotlin.Unit r5 = kotlin.Unit.f50853a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ao.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$onImagePicked$1", f = "VerificationFlowRibInteractorImpl.kt", l = {142}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class c0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42145g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f42147i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c0(String str, Continuation<? super c0> continuation) {
            super(2, continuation);
            this.f42147i = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c0(this.f42147i, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c0) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f42145g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable b8 = ao.this.f42132x.b(new x8.a(this.f42147i));
                this.f42145g = 1;
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
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<Throwable, Unit> {
        d() {
            super(1);
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            ac.b.f42045b.d().c(it);
            ao.this.C0(false);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$onPageLoaded$$inlined$flatMapLatest$1", f = "VerificationFlowRibInteractorImpl.kt", l = {190}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class d0 extends SuspendLambda implements Function3<FlowCollector<? super b>, b, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42149g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f42150h;

        /* renamed from: i  reason: collision with root package name */
        /* synthetic */ Object f42151i;

        public d0(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: h */
        public final Object l(FlowCollector<? super b> flowCollector, b bVar, Continuation<? super Unit> continuation) {
            d0 d0Var = new d0(continuation);
            d0Var.f42150h = flowCollector;
            d0Var.f42151i = bVar;
            return d0Var.invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f42149g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Flow y7 = FlowKt.y(new f0((b) this.f42151i, null));
                this.f42149g = 1;
                if (FlowKt.l((FlowCollector) this.f42150h, y7, this) == d8) {
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
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$invokeTryAgainAction$1", f = "VerificationFlowRibInteractorImpl.kt", l = {408}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42152g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ List<b1.a> f42154i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(List<b1.a> list, Continuation<? super e> continuation) {
            super(2, continuation);
            this.f42154i = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.f42154i, continuation);
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
            int i8 = this.f42152g;
            if (i8 == 0) {
                ResultKt.b(obj);
                a9 a9Var = ao.this.A;
                a9.a aVar = new a9.a(this.f42154i);
                this.f42152g = 1;
                if (a9Var.d(aVar, this) == d8) {
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

    /* loaded from: classes5.dex */
    public static final class e0 implements Flow<b> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f42155f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ao f42156g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f42157h;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f42158f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ ao f42159g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ String f42160h;

            @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$onPageLoaded$$inlined$map$1$2", f = "VerificationFlowRibInteractorImpl.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.ao$e0$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0033a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f42161f;

                /* renamed from: g  reason: collision with root package name */
                int f42162g;

                public C0033a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f42161f = obj;
                    this.f42162g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector, ao aoVar, String str) {
                this.f42158f = flowCollector;
                this.f42159g = aoVar;
                this.f42160h = str;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof eu.bolt.verification.sdk.internal.ao.e0.a.C0033a
                    if (r0 == 0) goto L13
                    r0 = r8
                    eu.bolt.verification.sdk.internal.ao$e0$a$a r0 = (eu.bolt.verification.sdk.internal.ao.e0.a.C0033a) r0
                    int r1 = r0.f42162g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f42162g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.ao$e0$a$a r0 = new eu.bolt.verification.sdk.internal.ao$e0$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.f42161f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f42162g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r8)
                    goto L4e
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    kotlin.ResultKt.b(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r6.f42158f
                    eu.bolt.verification.sdk.internal.vd r7 = (eu.bolt.verification.sdk.internal.vd) r7
                    eu.bolt.verification.sdk.internal.ao r2 = r6.f42159g
                    java.lang.String r4 = r6.f42160h
                    java.lang.String r5 = "it"
                    kotlin.jvm.internal.Intrinsics.e(r7, r5)
                    eu.bolt.verification.sdk.internal.ao$b r7 = eu.bolt.verification.sdk.internal.ao.Z(r2, r4, r7)
                    r0.f42162g = r3
                    java.lang.Object r7 = r8.b(r7, r0)
                    if (r7 != r1) goto L4e
                    return r1
                L4e:
                    kotlin.Unit r7 = kotlin.Unit.f50853a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ao.e0.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public e0(Flow flow, ao aoVar, String str) {
            this.f42155f = flow;
            this.f42156g = aoVar;
            this.f42157h = str;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super b> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f42155f.a(new a(flowCollector, this.f42156g, this.f42157h), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$observeBack$1", f = "VerificationFlowRibInteractorImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class f extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42164g;

        f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(Unit unit, Continuation<? super Unit> continuation) {
            return ((f) create(unit, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42164g == 0) {
                ResultKt.b(obj);
                db.a.a(ao.this.E, null, false, 3, null);
                if (!ao.this.Z0()) {
                    BaseMultiStackRouter.s0((BaseMultiStackRouter) ao.this.L(), false, null, 3, null);
                    if (!((eo) ao.this.L()).t()) {
                        ao.this.c();
                    }
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$onPageLoaded$2$1", f = "VerificationFlowRibInteractorImpl.kt", l = {277, 280}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class f0 extends SuspendLambda implements Function2<FlowCollector<? super b>, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42166g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f42167h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ b f42168i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f0(b bVar, Continuation<? super f0> continuation) {
            super(2, continuation);
            this.f42168i = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f0 f0Var = new f0(this.f42168i, continuation);
            f0Var.f42167h = obj;
            return f0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(FlowCollector<? super b> flowCollector, Continuation<? super Unit> continuation) {
            return ((f0) create(flowCollector, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            FlowCollector flowCollector;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f42166g;
            if (i8 == 0) {
                ResultKt.b(obj);
                flowCollector = (FlowCollector) this.f42167h;
                if (this.f42168i.b()) {
                    long a8 = this.f42168i.a();
                    this.f42167h = flowCollector;
                    this.f42166g = 1;
                    if (DelayKt.a(a8, this) == d8) {
                        return d8;
                    }
                }
            } else if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                flowCollector = (FlowCollector) this.f42167h;
                ResultKt.b(obj);
            }
            if (JobKt.l(getContext())) {
                b bVar = this.f42168i;
                this.f42167h = null;
                this.f42166g = 2;
                if (flowCollector.b(bVar, this) == d8) {
                    return d8;
                }
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g extends Lambda implements Function1<Unit, Unit> {
        g() {
            super(1);
        }

        public final void b(Unit unit) {
            db.a.a(ao.this.E, null, false, 3, null);
            if (ao.this.Z0()) {
                return;
            }
            BaseMultiStackRouter.s0((BaseMultiStackRouter) ao.this.L(), false, null, 3, null);
            if (((eo) ao.this.L()).t()) {
                return;
            }
            ao.this.c();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            b(unit);
            return Unit.f50853a;
        }
    }

    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$onPageLoaded$3", f = "VerificationFlowRibInteractorImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class g0 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42170g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f42171h;

        g0(Continuation<? super g0> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            g0 g0Var = new g0(continuation);
            g0Var.f42171h = obj;
            return g0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(b bVar, Continuation<? super Unit> continuation) {
            return ((g0) create(bVar, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42170g == 0) {
                ResultKt.b(obj);
                if (((b) this.f42171h).b()) {
                    ao.this.e();
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$observeCloseForm$1", f = "VerificationFlowRibInteractorImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class h extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42173g;

        h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(Unit unit, Continuation<? super Unit> continuation) {
            return ((h) create(unit, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42173g == 0) {
                ResultKt.b(obj);
                db.a.a(ao.this.E, null, false, 3, null);
                if (!ao.this.Z0()) {
                    ao.this.c();
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$onPageLoaded$4", f = "VerificationFlowRibInteractorImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class h0 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42175g;

        h0(Continuation<? super h0> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h0(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(Throwable th, Continuation<? super Unit> continuation) {
            return ((h0) create(th, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42175g == 0) {
                ResultKt.b(obj);
                ao.this.f(true);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class i extends Lambda implements Function1<Unit, Unit> {
        i() {
            super(1);
        }

        public final void b(Unit unit) {
            db.a.a(ao.this.E, null, false, 3, null);
            if (ao.this.Z0()) {
                return;
            }
            ao.this.c();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            b(unit);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class i0 extends Lambda implements Function1<vd<kp>, b> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f42179g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i0(String str) {
            super(1);
            this.f42179g = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final b invoke(vd<kp> it) {
            Intrinsics.f(it, "it");
            return ao.this.a0(this.f42179g, it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$observeCurrentFlowStatus$1", f = "VerificationFlowRibInteractorImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class j extends SuspendLambda implements Function2<VerificationFlowStatus, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42180g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f42181h;

        j(Continuation<? super j> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            j jVar = new j(continuation);
            jVar.f42181h = obj;
            return jVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(VerificationFlowStatus verificationFlowStatus, Continuation<? super Unit> continuation) {
            return ((j) create(verificationFlowStatus, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42180g == 0) {
                ResultKt.b(obj);
                VerificationFlowStatus flowStatus = (VerificationFlowStatus) this.f42181h;
                ao aoVar = ao.this;
                Intrinsics.e(flowStatus, "flowStatus");
                aoVar.K = flowStatus;
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* loaded from: classes5.dex */
    static final class j0 extends Lambda implements Function1<b, SingleSource<? extends b>> {

        /* renamed from: f  reason: collision with root package name */
        public static final j0 f42183f = new j0();

        j0() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final SingleSource<? extends b> invoke(b needToCloseWebview) {
            Intrinsics.f(needToCloseWebview, "needToCloseWebview");
            return needToCloseWebview.b() ? Single.w(needToCloseWebview).h(needToCloseWebview.a(), TimeUnit.MILLISECONDS) : Single.w(needToCloseWebview);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class k extends Lambda implements Function1<VerificationFlowStatus, Unit> {
        k() {
            super(1);
        }

        public final void b(VerificationFlowStatus flowStatus) {
            ao aoVar = ao.this;
            Intrinsics.e(flowStatus, "flowStatus");
            aoVar.K = flowStatus;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VerificationFlowStatus verificationFlowStatus) {
            b(verificationFlowStatus);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class k0 extends Lambda implements Function1<b, Unit> {
        k0() {
            super(1);
        }

        public final void b(b bVar) {
            if (bVar.b()) {
                ao.this.e();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
            b(bVar);
            return Unit.f50853a;
        }
    }

    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$observeCurrentVerificationStep$$inlined$flatMapLatest$1", f = "VerificationFlowRibInteractorImpl.kt", l = {190}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class l extends SuspendLambda implements Function3<FlowCollector<? super k7>, String, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42186g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f42187h;

        /* renamed from: i  reason: collision with root package name */
        /* synthetic */ Object f42188i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ ao f42189j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Continuation continuation, ao aoVar) {
            super(3, continuation);
            this.f42189j = aoVar;
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: h */
        public final Object l(FlowCollector<? super k7> flowCollector, String str, Continuation<? super Unit> continuation) {
            l lVar = new l(continuation, this.f42189j);
            lVar.f42187h = flowCollector;
            lVar.f42188i = str;
            return lVar.invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f42186g;
            if (i8 == 0) {
                ResultKt.b(obj);
                String it = (String) this.f42188i;
                ld ldVar = this.f42189j.f42129u;
                Intrinsics.e(it, "it");
                Flow e8 = FlowKt.e(RxConvertKt.b(ldVar.b(new ld.a(it))), new m(null));
                this.f42186g = 1;
                if (FlowKt.l((FlowCollector) this.f42187h, e8, this) == d8) {
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

    /* loaded from: classes5.dex */
    static final class l0 extends Lambda implements Function1<Throwable, Unit> {
        l0() {
            super(1);
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            ao.this.f(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$observeCurrentVerificationStep$1$1", f = "VerificationFlowRibInteractorImpl.kt", l = {551}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class m extends SuspendLambda implements Function3<FlowCollector<? super k7>, Throwable, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42191g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f42192h;

        m(Continuation<? super m> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: h */
        public final Object l(FlowCollector<? super k7> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            m mVar = new m(continuation);
            mVar.f42192h = flowCollector;
            return mVar.invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f42191g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Flow m8 = FlowKt.m();
                this.f42191g = 1;
                if (FlowKt.l((FlowCollector) this.f42192h, m8, this) == d8) {
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
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$showError$1", f = "VerificationFlowRibInteractorImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class m0 extends SuspendLambda implements Function2<qn.b, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42193g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f42194h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ boolean f42196j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m0(boolean z7, Continuation<? super m0> continuation) {
            super(2, continuation);
            this.f42196j = z7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m0 m0Var = new m0(this.f42196j, continuation);
            m0Var.f42194h = obj;
            return m0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(qn.b bVar, Continuation<? super Unit> continuation) {
            return ((m0) create(bVar, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42193g == 0) {
                ResultKt.b(obj);
                qn.b it = (qn.b) this.f42194h;
                ao aoVar = ao.this;
                Intrinsics.e(it, "it");
                aoVar.u0(it, this.f42196j);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class n extends AdaptedFunctionReference implements Function2<k7, Continuation<? super Unit>, Object> {
        n(Object obj) {
            super(2, obj, ao.class, "handleStepChanges", "handleStepChanges(Leu/bolt/verification/core/domain/model/FlowStep;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: c */
        public final Object s(k7 k7Var, Continuation<? super Unit> continuation) {
            return ao.A0((ao) this.f50976f, k7Var, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$showError$2", f = "VerificationFlowRibInteractorImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class n0 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42197g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f42199i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n0(boolean z7, Continuation<? super n0> continuation) {
            super(2, continuation);
            this.f42199i = z7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new n0(this.f42199i, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(Throwable th, Continuation<? super Unit> continuation) {
            return ((n0) create(th, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42197g == 0) {
                ResultKt.b(obj);
                ao.this.C0(this.f42199i);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class o extends Lambda implements Function1<String, ObservableSource<? extends k7>> {
        o() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final ObservableSource<? extends k7> invoke(String it) {
            Intrinsics.f(it, "it");
            return ao.this.f42129u.b(new ld.a(it)).onErrorResumeNext(Observable.empty());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class o0 extends Lambda implements Function1<qn.b, Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f42202g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o0(boolean z7) {
            super(1);
            this.f42202g = z7;
        }

        public final void b(qn.b it) {
            ao aoVar = ao.this;
            Intrinsics.e(it, "it");
            aoVar.u0(it, this.f42202g);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(qn.b bVar) {
            b(bVar);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class p extends FunctionReferenceImpl implements Function1<k7, Unit> {
        p(Object obj) {
            super(1, obj, ao.class, "handleStepChanges", "handleStepChanges(Leu/bolt/verification/core/domain/model/FlowStep;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(k7 k7Var) {
            j(k7Var);
            return Unit.f50853a;
        }

        public final void j(k7 p02) {
            Intrinsics.f(p02, "p0");
            ((ao) this.f50989g).s0(p02);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class p0 extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f42204g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p0(boolean z7) {
            super(1);
            this.f42204g = z7;
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            ao.this.C0(this.f42204g);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class q extends AdaptedFunctionReference implements Function2<d.C0042d, Continuation<? super Unit>, Object> {
        q(Object obj) {
            super(2, obj, ao.class, "showBottomSheet", "showBottomSheet(Leu/bolt/verification/core/domain/model/Action$OpenBottomSheet;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: c */
        public final Object s(d.C0042d c0042d, Continuation<? super Unit> continuation) {
            return ao.y0((ao) this.f50976f, c0042d, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$startPolling$1", f = "VerificationFlowRibInteractorImpl.kt", l = {633}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class q0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42205g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ int f42207i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q0(int i8, Continuation<? super q0> continuation) {
            super(2, continuation);
            this.f42207i = i8;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new q0(this.f42207i, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((q0) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f42205g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable h8 = ao.this.J.h(new oh.a(this.f42207i));
                this.f42205g = 1;
                if (RxAwaitKt.a(h8, this) == d8) {
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
    /* loaded from: classes5.dex */
    public /* synthetic */ class r extends FunctionReferenceImpl implements Function1<d.C0042d, Unit> {
        r(Object obj) {
            super(1, obj, ao.class, "showBottomSheet", "showBottomSheet(Leu/bolt/verification/core/domain/model/Action$OpenBottomSheet;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(d.C0042d c0042d) {
            j(c0042d);
            return Unit.f50853a;
        }

        public final void j(d.C0042d p02) {
            Intrinsics.f(p02, "p0");
            ((ao) this.f50989g).q0(p02);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class s extends AdaptedFunctionReference implements Function2<d.e, Continuation<? super Unit>, Object> {
        s(Object obj) {
            super(2, obj, ao.class, "showWebView", "showWebView(Leu/bolt/verification/core/domain/model/Action$OpenWebView;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: c */
        public final Object s(d.e eVar, Continuation<? super Unit> continuation) {
            return ao.z0((ao) this.f50976f, eVar, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class t extends FunctionReferenceImpl implements Function1<d.e, Unit> {
        t(Object obj) {
            super(1, obj, ao.class, "showWebView", "showWebView(Leu/bolt/verification/core/domain/model/Action$OpenWebView;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(d.e eVar) {
            j(eVar);
            return Unit.f50853a;
        }

        public final void j(d.e p02) {
            Intrinsics.f(p02, "p0");
            ((ao) this.f50989g).r0(p02);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$observePollingInfo$1", f = "VerificationFlowRibInteractorImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class u extends SuspendLambda implements Function2<vd<Integer>, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42208g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f42209h;

        u(Continuation<? super u> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            u uVar = new u(continuation);
            uVar.f42209h = obj;
            return uVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(vd<Integer> vdVar, Continuation<? super Unit> continuation) {
            return ((u) create(vdVar, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42208g == 0) {
                ResultKt.b(obj);
                vd vdVar = (vd) this.f42209h;
                if (vdVar.f()) {
                    ao aoVar = ao.this;
                    Object d8 = vdVar.d();
                    Intrinsics.e(d8, "intervalSecOptional.get()");
                    aoVar.g0(((Number) d8).intValue());
                } else {
                    Job job = ao.this.M;
                    if (job != null) {
                        Job.DefaultImpls.a(job, null, 1, null);
                    }
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class v extends Lambda implements Function1<vd<Integer>, Unit> {
        v() {
            super(1);
        }

        public final void b(vd<Integer> vdVar) {
            if (!vdVar.f()) {
                ao.this.N.dispose();
                return;
            }
            ao aoVar = ao.this;
            Integer d8 = vdVar.d();
            Intrinsics.e(d8, "intervalSecOptional.get()");
            aoVar.g0(d8.intValue());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(vd<Integer> vdVar) {
            b(vdVar);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$observeVerificationOpenWebViewModel$1", f = "VerificationFlowRibInteractorImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class w extends SuspendLambda implements Function2<vd<kp>, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42212g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f42213h;

        w(Continuation<? super w> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            w wVar = new w(continuation);
            wVar.f42213h = obj;
            return wVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(vd<kp> vdVar, Continuation<? super Unit> continuation) {
            return ((w) create(vdVar, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42212g == 0) {
                ResultKt.b(obj);
                ao.this.L = (kp) ((vd) this.f42213h).g();
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class x extends Lambda implements Function1<vd<kp>, Unit> {
        x() {
            super(1);
        }

        public final void b(vd<kp> vdVar) {
            ao.this.L = vdVar.g();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(vd<kp> vdVar) {
            b(vdVar);
            return Unit.f50853a;
        }
    }

    @DebugMetadata(c = "eu.bolt.verification.core.rib.VerificationFlowRibInteractorImpl$onBottomSheetButtonClick$1", f = "VerificationFlowRibInteractorImpl.kt", l = {220}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42216g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f42217h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Object f42219j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(Object obj, Continuation<? super y> continuation) {
            super(2, continuation);
            this.f42219j = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            y yVar = new y(this.f42219j, continuation);
            yVar.f42217h = obj;
            return yVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((y) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r1 = r4.f42216g
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.b(r5)     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                goto L3c
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                kotlin.ResultKt.b(r5)
                java.lang.Object r5 = r4.f42217h
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                eu.bolt.verification.sdk.internal.ao r5 = eu.bolt.verification.sdk.internal.ao.this
                java.lang.Object r1 = r4.f42219j
                kotlin.Result$Companion r3 = kotlin.Result.f50818g     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                eu.bolt.verification.sdk.internal.a9 r5 = eu.bolt.verification.sdk.internal.ao.H0(r5)     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                eu.bolt.verification.sdk.internal.a9$a r3 = new eu.bolt.verification.sdk.internal.a9$a     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                eu.bolt.verification.sdk.internal.k0 r1 = (eu.bolt.verification.sdk.internal.k0) r1     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                java.util.List r1 = r1.a()     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                r3.<init>(r1)     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                r4.f42216g = r2     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                java.lang.Object r5 = r5.d(r3, r4)     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                if (r5 != r0) goto L3c
                return r0
            L3c:
                kotlin.Unit r5 = kotlin.Unit.f50853a     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Exception -> L43 java.util.concurrent.CancellationException -> L45 kotlinx.coroutines.TimeoutCancellationException -> L47
                goto L52
            L43:
                r5 = move-exception
                goto L48
            L45:
                r5 = move-exception
                throw r5
            L47:
                r5 = move-exception
            L48:
                kotlin.Result$Companion r0 = kotlin.Result.f50818g
                java.lang.Object r5 = kotlin.ResultKt.a(r5)
                java.lang.Object r5 = kotlin.Result.b(r5)
            L52:
                eu.bolt.verification.sdk.internal.ao r0 = eu.bolt.verification.sdk.internal.ao.this
                java.lang.Throwable r5 = kotlin.Result.e(r5)
                if (r5 == 0) goto L5d
                r0.f(r2)
            L5d:
                kotlin.Unit r5 = kotlin.Unit.f50853a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ao.y.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* loaded from: classes5.dex */
    static final class z extends Lambda implements Function1<Throwable, Unit> {
        z() {
            super(1);
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            ao.this.f(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    @Inject
    public ao(yn args, co ribListener, xg rxSchedulers, ia initVerificationFlowInteractor, rc observeCurrentFlowInteractor, vc observeCurrentStepIdInteractor, xc observeFlowStatusInteractor, ld observeStepByIdInteractor, pc observeCloseFormRequiredInteractor, mn fileProvider, x8 goToNextStepInteractor, nc observeBackActionInteractor, z8 handleButtonActionInteractor, a9 handleButtonActionInteractorCo, dd observeOpenVerificationBottomSheetActionInteractor, fd observeOpenWebViewActionInteractor, eu.bolt.verification.sdk.internal.l0 bottomSheetConfigMapper, db keyboardController, hd observeOpenedWebviewModelInteractor, of reportSdkEventInteractor, dl targetingManager, jd observePollingInfoInteractor, oh stepPollingInteractor) {
        Intrinsics.f(args, "args");
        Intrinsics.f(ribListener, "ribListener");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(initVerificationFlowInteractor, "initVerificationFlowInteractor");
        Intrinsics.f(observeCurrentFlowInteractor, "observeCurrentFlowInteractor");
        Intrinsics.f(observeCurrentStepIdInteractor, "observeCurrentStepIdInteractor");
        Intrinsics.f(observeFlowStatusInteractor, "observeFlowStatusInteractor");
        Intrinsics.f(observeStepByIdInteractor, "observeStepByIdInteractor");
        Intrinsics.f(observeCloseFormRequiredInteractor, "observeCloseFormRequiredInteractor");
        Intrinsics.f(fileProvider, "fileProvider");
        Intrinsics.f(goToNextStepInteractor, "goToNextStepInteractor");
        Intrinsics.f(observeBackActionInteractor, "observeBackActionInteractor");
        Intrinsics.f(handleButtonActionInteractor, "handleButtonActionInteractor");
        Intrinsics.f(handleButtonActionInteractorCo, "handleButtonActionInteractorCo");
        Intrinsics.f(observeOpenVerificationBottomSheetActionInteractor, "observeOpenVerificationBottomSheetActionInteractor");
        Intrinsics.f(observeOpenWebViewActionInteractor, "observeOpenWebViewActionInteractor");
        Intrinsics.f(bottomSheetConfigMapper, "bottomSheetConfigMapper");
        Intrinsics.f(keyboardController, "keyboardController");
        Intrinsics.f(observeOpenedWebviewModelInteractor, "observeOpenedWebviewModelInteractor");
        Intrinsics.f(reportSdkEventInteractor, "reportSdkEventInteractor");
        Intrinsics.f(targetingManager, "targetingManager");
        Intrinsics.f(observePollingInfoInteractor, "observePollingInfoInteractor");
        Intrinsics.f(stepPollingInteractor, "stepPollingInteractor");
        this.f42122n = args;
        this.f42123o = ribListener;
        this.f42124p = rxSchedulers;
        this.f42125q = initVerificationFlowInteractor;
        this.f42126r = observeCurrentFlowInteractor;
        this.f42127s = observeCurrentStepIdInteractor;
        this.f42128t = observeFlowStatusInteractor;
        this.f42129u = observeStepByIdInteractor;
        this.f42130v = observeCloseFormRequiredInteractor;
        this.f42131w = fileProvider;
        this.f42132x = goToNextStepInteractor;
        this.f42133y = observeBackActionInteractor;
        this.f42134z = handleButtonActionInteractor;
        this.A = handleButtonActionInteractorCo;
        this.B = observeOpenVerificationBottomSheetActionInteractor;
        this.C = observeOpenWebViewActionInteractor;
        this.D = bottomSheetConfigMapper;
        this.E = keyboardController;
        this.F = observeOpenedWebviewModelInteractor;
        this.G = reportSdkEventInteractor;
        this.H = targetingManager;
        this.I = observePollingInfoInteractor;
        this.J = stepPollingInteractor;
        this.K = VerificationFlowStatus.UNKNOWN;
        Disposable a8 = Disposables.a();
        Intrinsics.e(a8, "disposed()");
        this.N = a8;
        this.O = "VerificationFlow";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object A0(ao aoVar, k7 k7Var, Continuation continuation) {
        aoVar.s0(k7Var);
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(boolean z7) {
        db.a.a(this.E, null, false, 3, null);
        ll.a aVar = ll.f44093f;
        DynamicStateController1Arg.k(((eo) L()).l1(), new x6(null, null, false, ll.a.b(aVar, R$string.generic_error_title, null, 2, null), u4.f45317s, ll.a.b(aVar, R$string.generic_error_message, null, 2, null), null, null, new j6(ll.a.b(aVar, z7 ? R$string.try_again_button : R$string.generic_error_button, null, 2, null), l6.b.f44014f, m6.a.f44156g), null, null, null, z7 ? new z6("retry", null, 2, null) : new z6("generic", null, 2, null), null, 11971, null), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource E0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void J0() {
        List e8;
        e8 = CollectionsKt__CollectionsJVMKt.e(new b1.a(d.k.f42570f, null));
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new e(e8, null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.f42134z.n(new z8.a(e8)), null, null, null, 7, null), null, 1, null);
        }
    }

    private final void L0() {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, RxConvertKt.b(this.f42133y.a()), new f(null), null, null, null, false, 30, null);
            return;
        }
        Observable<Unit> observeOn = this.f42133y.a().observeOn(this.f42124p.c());
        Intrinsics.e(observeOn, "observeBackActionInterac…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.r(observeOn, new g(), null, null, null, null, 30, null), null, 1, null);
    }

    private final void N0() {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, RxConvertKt.b(this.f42130v.a()), new h(null), null, null, null, false, 30, null);
            return;
        }
        Observable<Unit> observeOn = this.f42130v.a().observeOn(this.f42124p.c());
        Intrinsics.e(observeOn, "observeCloseFormRequired…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.r(observeOn, new i(), null, null, null, null, 30, null), null, 1, null);
    }

    private final void P0() {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, RxConvertKt.b(this.f42128t.a()), new j(null), null, null, null, false, 30, null);
            return;
        }
        Observable<VerificationFlowStatus> observeOn = this.f42128t.a().observeOn(this.f42124p.c());
        Intrinsics.e(observeOn, "observeFlowStatusInterac…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.r(observeOn, new k(), null, null, null, null, 30, null), null, 1, null);
    }

    private final void R0() {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, FlowKt.I(RxConvertKt.b(this.f42127s.a()), new l(null, this)), new n(this), null, null, null, false, 30, null);
            return;
        }
        Observable<String> a8 = this.f42127s.a();
        final o oVar = new o();
        Observable observeOn = a8.switchMap(new Function() { // from class: eu.bolt.verification.sdk.internal.nb
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource c02;
                c02 = ao.c0(Function1.this, obj);
                return c02;
            }
        }).observeOn(this.f42124p.c());
        Intrinsics.e(observeOn, "private fun observeCurre…osables()\n        }\n    }");
        BaseRibInteractor.S(this, ug.r(observeOn, new p(this), null, null, null, null, 30, null), null, 1, null);
    }

    private final void T0() {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, RxConvertKt.b(this.B.a()), new q(this), null, null, null, false, 30, null);
            return;
        }
        Observable<d.C0042d> observeOn = this.B.a().observeOn(this.f42124p.c());
        Intrinsics.e(observeOn, "observeOpenVerificationB…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.r(observeOn, new r(this), null, null, null, null, 30, null), null, 1, null);
    }

    private final void V0() {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, RxConvertKt.b(this.C.a()), new s(this), null, null, null, false, 30, null);
            return;
        }
        Observable<d.e> observeOn = this.C.a().observeOn(this.f42124p.c());
        Intrinsics.e(observeOn, "observeOpenWebViewAction…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.r(observeOn, new t(this), null, null, null, null, 30, null), null, 1, null);
    }

    private final void W0() {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, RxConvertKt.b(this.I.c()), new u(null), null, null, null, false, 30, null);
            return;
        }
        Observable<vd<Integer>> observeOn = this.I.c().observeOn(this.f42124p.c());
        Intrinsics.e(observeOn, "observePollingInfoIntera…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.r(observeOn, new v(), null, null, null, null, 30, null), null, 1, null);
    }

    private final void Y0() {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, RxConvertKt.b(this.F.a()), new w(null), null, null, null, false, 30, null);
            return;
        }
        Observable<vd<kp>> observeOn = this.F.a().observeOn(this.f42124p.c());
        Intrinsics.e(observeOn, "observeOpenedWebviewMode…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.r(observeOn, new x(), null, null, null, null, 30, null), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Z0() {
        return ((eo) L()).s1() || ((eo) L()).v1() || ((eo) L()).u1() || ((eo) L()).w1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b a0(String str, vd<kp> vdVar) {
        b bVar;
        kp d8 = vdVar.d();
        Intrinsics.e(d8, "openWebViewModelContainer.get()");
        kp.a b02 = b0(str, d8);
        if (b02 != null) {
            Long a8 = b02.a();
            bVar = new b(true, a8 != null ? a8.longValue() : 0L);
        } else {
            bVar = new b(false, 0L, 2, null);
        }
        return bVar;
    }

    private final kp.a b0(String str, kp kpVar) {
        List<kp.a> c8 = kpVar.c();
        if (c8 != null) {
            for (kp.a aVar : c8) {
                if (Intrinsics.a(aVar.b(), str)) {
                    return aVar;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        this.f42123o.v(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        DynamicStateController.g(((eo) L()).p1(), false, 1, null);
    }

    private final void g() {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new c(null), 3, null);
            return;
        }
        Completable z7 = this.f42125q.d(new ia.a(this.f42122n.a())).z(this.f42124p.c());
        Intrinsics.e(z7, "initVerificationFlowInte…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.p(z7, null, new d(), null, 5, null), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(int i8) {
        if (!((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            this.N.dispose();
            this.N = ug.p(this.J.h(new oh.a(i8)), null, null, null, 7, null);
            return;
        }
        Job job = this.M;
        if (job != null) {
            Job.DefaultImpls.a(job, null, 1, null);
        }
        this.M = BaseScopeOwner.F(this, null, null, new q0(i8, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(d.C0042d c0042d) {
        db.a.a(this.E, null, false, 3, null);
        DynamicStateController1Arg.k(((eo) L()).n1(), new ga(true, this.D.b(c0042d), f7.WHEN_EXPANDED), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(d.e eVar) {
        DynamicStateController1Arg.k(((eo) L()).p1(), eVar.b().e(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(k7 k7Var) {
        db.a.a(this.E, null, false, 3, null);
        DynamicStateController.g(((eo) L()).n1(), false, 1, null);
        nh d8 = k7Var.d();
        if (d8 instanceof nh.b) {
            t0(k7Var, false);
        } else if (!(d8 instanceof nh.a)) {
            throw new NoWhenBranchMatchedException();
        } else {
            v0(this.f42122n.a(), k7Var, (nh.a) k7Var.d());
        }
        Unit unit = Unit.f50853a;
    }

    private final void t0(k7 k7Var, boolean z7) {
        DynamicStateController1Arg.k(((eo) L()).j1(), new q7(k7Var.e(), k7Var.a(), k7Var.b(), k7Var.c(), z7), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(qn.b bVar, boolean z7) {
        if (bVar.a() != null) {
            t0(bVar.a(), true);
        } else {
            C0(z7);
        }
    }

    private final void v0(String str, k7 k7Var, nh.a aVar) {
        DynamicStateController1Arg.k(((eo) L()).h1(), new en(str, k7Var.e(), k7Var.a(), aVar.c(), k7Var.f().a(), aVar.b(), aVar.f(), aVar.d(), aVar.e(), aVar.g(), aVar.a(), this.f42131w.c(k7Var.e()), k7Var.b(), k7Var.c()), false, 2, null);
    }

    private final boolean w0(kp kpVar) {
        Boolean a8;
        kp.b d8 = kpVar.d();
        if (d8 == null || (a8 = d8.a()) == null) {
            return false;
        }
        a8.booleanValue();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b x0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (b) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object y0(ao aoVar, d.C0042d c0042d, Continuation continuation) {
        aoVar.q0(c0042d);
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object z0(ao aoVar, d.e eVar, Continuation continuation) {
        aoVar.r0(eVar);
        return Unit.f50853a;
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void A(z6 z6Var) {
        if (Intrinsics.a(z6Var != null ? z6Var.a() : null, "retry")) {
            J0();
        } else {
            this.f42123o.v(this.K);
        }
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        super.K(bundle);
        N0();
        L0();
        W0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void P() {
        this.N.dispose();
        Job job = this.M;
        if (job != null) {
            Job.DefaultImpls.a(job, null, 1, null);
        }
        super.P();
    }

    @Override // eu.bolt.verification.sdk.internal.cr
    public void a() {
        String b8;
        e();
        kp kpVar = this.L;
        if (kpVar == null || !w0(kpVar)) {
            return;
        }
        c();
        kp.b d8 = kpVar.d();
        if (d8 == null || (b8 = d8.b()) == null) {
            return;
        }
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new a0(b8, null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.G.a(new of.a(b8)), null, new b0(), null, 5, null), null, 1, null);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.aj
    public void b() {
        DynamicStateController.g(((eo) L()).f1(), false, 1, null);
    }

    @Override // eu.bolt.verification.sdk.internal.cr
    public boolean c(String str) {
        return cr.a.a(this, str);
    }

    @Override // eu.bolt.verification.sdk.internal.v0
    public void d(Object payload) {
        Intrinsics.f(payload, "payload");
        if (payload instanceof eu.bolt.verification.sdk.internal.k0) {
            if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
                BaseScopeOwner.F(this, null, null, new y(payload, null), 3, null);
                return;
            }
            Completable z7 = this.f42134z.n(new z8.a(((eu.bolt.verification.sdk.internal.k0) payload).a())).z(this.f42124p.c());
            Intrinsics.e(z7, "handleButtonActionIntera…erveOn(rxSchedulers.main)");
            BaseRibInteractor.S(this, ug.p(z7, null, new z(), null, 5, null), null, 1, null);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.t7
    public void f(boolean z7) {
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, RxConvertKt.b(this.f42126r.a()), new m0(z7, null), new n0(z7, null), null, null, false, 28, null);
            return;
        }
        Single<qn.b> z8 = this.f42126r.a().firstOrError().z(this.f42124p.c());
        Intrinsics.e(z8, "observeCurrentFlowIntera…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.t(z8, new o0(z7), new p0(z7), null, 4, null), null, 1, null);
    }

    @Override // eu.bolt.verification.sdk.internal.hn
    public void i(String nextStepId) {
        Intrinsics.f(nextStepId, "nextStepId");
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new c0(nextStepId, null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.f42132x.b(new x8.a(nextStepId)), null, null, null, 7, null), null, 1, null);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.cr
    public void j(String url) {
        Intrinsics.f(url, "url");
        if (((Boolean) this.H.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, FlowKt.I(new e0(RxConvertKt.b(this.F.a()), this, url), new d0(null)), new g0(null), new h0(null), null, null, false, 28, null);
            return;
        }
        Single<vd<kp>> firstOrError = this.F.a().firstOrError();
        final i0 i0Var = new i0(url);
        Single<R> x7 = firstOrError.x(new Function() { // from class: eu.bolt.verification.sdk.internal.ea
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ao.b x02;
                x02 = ao.x0(Function1.this, obj);
                return x02;
            }
        });
        final j0 j0Var = j0.f42183f;
        Single z7 = x7.r(new Function() { // from class: eu.bolt.verification.sdk.internal.ab
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource E0;
                E0 = ao.E0(Function1.this, obj);
                return E0;
            }
        }).z(this.f42124p.c());
        final k0 k0Var = new k0();
        Single o8 = z7.o(new Consumer() { // from class: eu.bolt.verification.sdk.internal.bb
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ao.G0(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "override fun onPageLoade…osables()\n        }\n    }");
        BaseRibInteractor.S(this, ug.t(o8, null, new l0(), null, 5, null), null, 1, null);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void m(z6 z6Var) {
        if (Intrinsics.a(z6Var != null ? z6Var.a() : null, "generic")) {
            this.f42123o.v(this.K);
            return;
        }
        if (Intrinsics.a(z6Var != null ? z6Var.a() : null, "retry")) {
            DynamicStateController.g(((eo) L()).l1(), false, 1, null);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void o(Serializable serializable) {
        y6.a.b(this, serializable);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public Flow<k6> p(z6 z6Var) {
        return y6.a.d(this, z6Var);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void q(z6 z6Var) {
        y6.a.e(this, z6Var);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public Flow<k6> r(z6 z6Var) {
        return y6.a.c(this, z6Var);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void t(z6 z6Var) {
        y6.a.a(this, z6Var);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void u(z6 z6Var) {
        y6.a.f(this, z6Var);
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public void y() {
        super.y();
        g();
        R0();
        T0();
        V0();
        P0();
        Y0();
    }
}
