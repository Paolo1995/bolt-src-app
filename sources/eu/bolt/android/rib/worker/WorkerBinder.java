package eu.bolt.android.rib.worker;

import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.android.rib.RibInteractor;
import eu.bolt.android.rib.lifecycle.InteractorEvent;
import eu.bolt.coroutines.base.BaseScopeKt;
import eu.bolt.coroutines.extensions.FlowExtensionsKt;
import eu.bolt.coroutines.flows.PublishFlow;
import eu.bolt.logger.StaticLogger;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx2.RxConvertKt;

/* compiled from: WorkerBinder.kt */
/* loaded from: classes5.dex */
public final class WorkerBinder {

    /* renamed from: a  reason: collision with root package name */
    public static final WorkerBinder f37350a = new WorkerBinder();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f37351b;

    private WorkerBinder() {
    }

    private final WorkerUnbinder h(Observable<InteractorEvent> observable, Flow<? extends InteractorEvent> flow, Worker worker, Function1<? super InteractorEvent, ? extends WorkerEvent> function1) {
        if (f37351b) {
            return j(flow, worker, function1);
        }
        return m(observable, worker, function1);
    }

    private final WorkerUnbinder j(final Flow<? extends InteractorEvent> flow, Worker worker, final Function1<? super InteractorEvent, ? extends WorkerEvent> function1) {
        CoroutineScope b8 = BaseScopeKt.b(null, null, null, null, Dispatchers.c().R0(), 15, null);
        final PublishFlow publishFlow = new PublishFlow();
        final Flow h8 = FlowExtensionsKt.h(FlowKt.D(new Flow<WorkerEvent>() { // from class: eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37359f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ Function1 f37360g;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1$2", f = "WorkerBinder.kt", l = {225}, m = "emit")
                /* renamed from: eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37361f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37362g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37361f = obj;
                        this.f37362g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Function1 function1) {
                    this.f37359f = flowCollector;
                    this.f37360g = function1;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1$2$1 r0 = (eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37362g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37362g = r1
                        goto L18
                    L13:
                        eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1$2$1 r0 = new eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f37361f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37362g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f37359f
                        eu.bolt.android.rib.lifecycle.InteractorEvent r5 = (eu.bolt.android.rib.lifecycle.InteractorEvent) r5
                        kotlin.jvm.functions.Function1 r2 = r4.f37360g
                        java.lang.Object r5 = r2.invoke(r5)
                        if (r5 == 0) goto L49
                        r0.f37362g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$mapNotNull$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super WorkerEvent> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector, function1), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        }, publishFlow), new Function1<WorkerEvent, Boolean>() { // from class: eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$shouldStartWorkerFlow$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(WorkerEvent it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it == WorkerEvent.DESTROY) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        });
        FlowExtensionsKt.f(FlowKt.j(new Flow<Boolean>() { // from class: eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37353f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1$2", f = "WorkerBinder.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37354f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37355g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37354f = obj;
                        this.f37355g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f37353f = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1$2$1 r0 = (eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37355g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37355g = r1
                        goto L18
                    L13:
                        eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1$2$1 r0 = new eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f37354f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37355g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L4c
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f37353f
                        eu.bolt.android.rib.worker.WorkerEvent r5 = (eu.bolt.android.rib.worker.WorkerEvent) r5
                        eu.bolt.android.rib.worker.WorkerEvent r2 = eu.bolt.android.rib.worker.WorkerEvent.START
                        if (r5 != r2) goto L3e
                        r5 = 1
                        goto L3f
                    L3e:
                        r5 = 0
                    L3f:
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
                        r0.f37355g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L4c
                        return r1
                    L4c:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        }), b8, new WorkerBinder$bindUsingCoroutines$1(worker, null), new WorkerBinder$bindUsingCoroutines$2(StaticLogger.f41686a), null, null, false, 56, null);
        return new WorkerUnbinder() { // from class: eu.bolt.android.rib.worker.a
            @Override // eu.bolt.android.rib.worker.WorkerUnbinder
            public final void a() {
                WorkerBinder.l(PublishFlow.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object k(StaticLogger staticLogger, Throwable th, Continuation continuation) {
        staticLogger.c(th);
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(PublishFlow unbindSignalFlow) {
        Intrinsics.f(unbindSignalFlow, "$unbindSignalFlow");
        unbindSignalFlow.f(WorkerEvent.DESTROY);
    }

    private final WorkerUnbinder m(Observable<InteractorEvent> observable, final Worker worker, final Function1<? super InteractorEvent, ? extends WorkerEvent> function1) {
        final PublishRelay e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<WorkerEvent>()");
        final Function1<InteractorEvent, ObservableSource<? extends WorkerEvent>> function12 = new Function1<InteractorEvent, ObservableSource<? extends WorkerEvent>>() { // from class: eu.bolt.android.rib.worker.WorkerBinder$bindUsingRx$workerLifecycle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends WorkerEvent> invoke(InteractorEvent interactorEvent) {
                Intrinsics.f(interactorEvent, "interactorEvent");
                WorkerEvent invoke = function1.invoke(interactorEvent);
                if (invoke != null) {
                    return Observable.just(invoke);
                }
                return Observable.empty();
            }
        };
        Observable mergeWith = observable.switchMap(new Function() { // from class: eu.bolt.android.rib.worker.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource n8;
                n8 = WorkerBinder.n(Function1.this, obj);
                return n8;
            }
        }).mergeWith(e8);
        final WorkerBinder$bindUsingRx$workerLifecycle$2 workerBinder$bindUsingRx$workerLifecycle$2 = new Function1<WorkerEvent, Boolean>() { // from class: eu.bolt.android.rib.worker.WorkerBinder$bindUsingRx$workerLifecycle$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(WorkerEvent workerEvent) {
                boolean z7;
                Intrinsics.f(workerEvent, "workerEvent");
                if (workerEvent == WorkerEvent.DESTROY) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable takeUntil = mergeWith.takeUntil(new Predicate() { // from class: eu.bolt.android.rib.worker.c
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean o8;
                o8 = WorkerBinder.o(Function1.this, obj);
                return o8;
            }
        });
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Function1<WorkerEvent, Unit> function13 = new Function1<WorkerEvent, Unit>() { // from class: eu.bolt.android.rib.worker.WorkerBinder$bindUsingRx$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(WorkerEvent workerEvent) {
                WorkerEvent workerEvent2 = WorkerEvent.START;
                if (workerEvent == workerEvent2 && !Ref$BooleanRef.this.f51012f) {
                    worker.onStart();
                    Ref$BooleanRef.this.f51012f = true;
                } else if (workerEvent != workerEvent2 && Ref$BooleanRef.this.f51012f) {
                    worker.onStop();
                    Ref$BooleanRef.this.f51012f = false;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WorkerEvent workerEvent) {
                b(workerEvent);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: eu.bolt.android.rib.worker.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkerBinder.p(Function1.this, obj);
            }
        };
        final WorkerBinder$bindUsingRx$2 workerBinder$bindUsingRx$2 = new WorkerBinder$bindUsingRx$2(StaticLogger.f41686a);
        takeUntil.subscribe(consumer, new Consumer() { // from class: eu.bolt.android.rib.worker.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkerBinder.q(Function1.this, obj);
            }
        });
        return new WorkerUnbinder() { // from class: eu.bolt.android.rib.worker.f
            @Override // eu.bolt.android.rib.worker.WorkerUnbinder
            public final void a() {
                WorkerBinder.r(PublishRelay.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(PublishRelay unbindSubject) {
        Intrinsics.f(unbindSubject, "$unbindSubject");
        unbindSubject.accept(WorkerEvent.DESTROY);
    }

    public final WorkerUnbinder i(RibInteractor<?> ribInteractor, Worker worker) {
        Intrinsics.f(ribInteractor, "ribInteractor");
        Intrinsics.f(worker, "worker");
        return h(ribInteractor.M(), RxConvertKt.b(ribInteractor.M()), worker, new Function1<InteractorEvent, WorkerEvent>() { // from class: eu.bolt.android.rib.worker.WorkerBinder$bindToFocusEvents$1

            /* compiled from: WorkerBinder.kt */
            /* loaded from: classes5.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f37365a;

                static {
                    int[] iArr = new int[InteractorEvent.values().length];
                    try {
                        iArr[InteractorEvent.STACK_FOCUS_RECEIVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[InteractorEvent.STACK_FOCUS_LOST.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[InteractorEvent.INACTIVE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f37365a = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final WorkerEvent invoke(InteractorEvent interactorEvent) {
                Intrinsics.f(interactorEvent, "interactorEvent");
                int i8 = WhenMappings.f37365a[interactorEvent.ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            return null;
                        }
                        return WorkerEvent.DESTROY;
                    }
                    return WorkerEvent.STOP;
                }
                return WorkerEvent.START;
            }
        });
    }
}
