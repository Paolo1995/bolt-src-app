package eu.bolt.verification.sdk.internal;

import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import eu.bolt.coroutines.base.LifecycleBoundScopeKt;
import eu.bolt.coroutines.extensions.FlowExtensionsKt;
import eu.bolt.logger.Logger;
import eu.bolt.verification.sdk.internal.ac;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes5.dex */
public final class ib {

    /* renamed from: h  reason: collision with root package name */
    private static final c f43527h = new c(null);

    /* renamed from: a  reason: collision with root package name */
    private final ComponentActivity f43528a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f43529b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineScope f43530c;

    /* renamed from: d  reason: collision with root package name */
    private final jb f43531d;

    /* renamed from: e  reason: collision with root package name */
    private final hb f43532e;

    /* renamed from: f  reason: collision with root package name */
    private final MutableStateFlow<Boolean> f43533f;

    /* renamed from: g  reason: collision with root package name */
    private final Flow<Boolean> f43534g;

    @DebugMetadata(c = "eu.bolt.client.keyboard.KeyboardManager$1", f = "KeyboardManager.kt", l = {40}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43535g;

        /* renamed from: eu.bolt.verification.sdk.internal.ib$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0062a implements Flow<Integer> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Flow f43537f;

            /* renamed from: eu.bolt.verification.sdk.internal.ib$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0063a<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f43538f;

                @DebugMetadata(c = "eu.bolt.client.keyboard.KeyboardManager$1$invokeSuspend$$inlined$filter$1$2", f = "KeyboardManager.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.verification.sdk.internal.ib$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public static final class C0064a extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f43539f;

                    /* renamed from: g  reason: collision with root package name */
                    int f43540g;

                    public C0064a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f43539f = obj;
                        this.f43540g |= Integer.MIN_VALUE;
                        return C0063a.this.b(null, this);
                    }
                }

                public C0063a(FlowCollector flowCollector) {
                    this.f43538f = flowCollector;
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
                        boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.ib.a.C0062a.C0063a.C0064a
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.verification.sdk.internal.ib$a$a$a$a r0 = (eu.bolt.verification.sdk.internal.ib.a.C0062a.C0063a.C0064a) r0
                        int r1 = r0.f43540g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f43540g = r1
                        goto L18
                    L13:
                        eu.bolt.verification.sdk.internal.ib$a$a$a$a r0 = new eu.bolt.verification.sdk.internal.ib$a$a$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f43539f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f43540g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L4d
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f43538f
                        r2 = r5
                        java.lang.Number r2 = (java.lang.Number) r2
                        int r2 = r2.intValue()
                        if (r2 <= 0) goto L41
                        r2 = 1
                        goto L42
                    L41:
                        r2 = 0
                    L42:
                        if (r2 == 0) goto L4d
                        r0.f43540g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L4d
                        return r1
                    L4d:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ib.a.C0062a.C0063a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            public C0062a(Flow flow) {
                this.f43537f = flow;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = this.f43537f.a(new C0063a(flowCollector), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                return a8 == d8 ? a8 : Unit.f50853a;
            }
        }

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43535g;
            if (i8 == 0) {
                ResultKt.b(obj);
                C0062a c0062a = new C0062a(ib.this.f43533f.e());
                this.f43535g = 1;
                if (FlowKt.p(c0062a, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            if (gb.c(ib.this.f43528a)) {
                return Unit.f50853a;
            }
            throw new IllegalStateException("Activity window SoftInputMethod must be ADJUST_RESIZE");
        }
    }

    @DebugMetadata(c = "eu.bolt.client.keyboard.KeyboardManager$2", f = "KeyboardManager.kt", l = {49}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class b extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43542g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ boolean f43543h;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.f43543h = ((Boolean) obj).booleanValue();
            return bVar;
        }

        public final Object h(boolean z7, Continuation<? super Unit> continuation) {
            return ((b) create(Boolean.valueOf(z7), continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43542g;
            if (i8 == 0) {
                ResultKt.b(obj);
                boolean z7 = this.f43543h;
                MutableStateFlow mutableStateFlow = ib.this.f43533f;
                Boolean a8 = Boxing.a(z7);
                this.f43542g = 1;
                if (mutableStateFlow.b(a8, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object s(Boolean bool, Continuation<? super Unit> continuation) {
            return h(bool.booleanValue(), continuation);
        }
    }

    /* loaded from: classes5.dex */
    private static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.keyboard.KeyboardManager$awaitCloseKeyboard$2", f = "KeyboardManager.kt", l = {66}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43545g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f43546h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ib f43547i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ boolean f43548j;

        /* loaded from: classes5.dex */
        public static final class a implements Flow<Boolean> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Flow f43549f;

            /* renamed from: eu.bolt.verification.sdk.internal.ib$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0065a<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f43550f;

                @DebugMetadata(c = "eu.bolt.client.keyboard.KeyboardManager$awaitCloseKeyboard$2$invokeSuspend$$inlined$filter$1$2", f = "KeyboardManager.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.verification.sdk.internal.ib$d$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public static final class C0066a extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f43551f;

                    /* renamed from: g  reason: collision with root package name */
                    int f43552g;

                    public C0066a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f43551f = obj;
                        this.f43552g |= Integer.MIN_VALUE;
                        return C0065a.this.b(null, this);
                    }
                }

                public C0065a(FlowCollector flowCollector) {
                    this.f43550f = flowCollector;
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
                        boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.ib.d.a.C0065a.C0066a
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.verification.sdk.internal.ib$d$a$a$a r0 = (eu.bolt.verification.sdk.internal.ib.d.a.C0065a.C0066a) r0
                        int r1 = r0.f43552g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f43552g = r1
                        goto L18
                    L13:
                        eu.bolt.verification.sdk.internal.ib$d$a$a$a r0 = new eu.bolt.verification.sdk.internal.ib$d$a$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f43551f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f43552g
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
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f43550f
                        r2 = r5
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        boolean r2 = r2.booleanValue()
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L49
                        r0.f43552g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ib.d.a.C0065a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            public a(Flow flow) {
                this.f43549f = flow;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = this.f43549f.a(new C0065a(flowCollector), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                return a8 == d8 ? a8 : Unit.f50853a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Function0<Unit> function0, ib ibVar, boolean z7, Continuation<? super d> continuation) {
            super(2, continuation);
            this.f43546h = function0;
            this.f43547i = ibVar;
            this.f43548j = z7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.f43546h, this.f43547i, this.f43548j, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            Unit unit;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43545g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Function0<Unit> function0 = this.f43546h;
                if (function0 != null) {
                    function0.invoke();
                    unit = Unit.f50853a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    ib.f(this.f43547i, null, this.f43548j, 1, null);
                }
                a aVar = new a(this.f43547i.h());
                this.f43545g = 1;
                obj = FlowKt.p(aVar, this);
                if (obj == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.keyboard.KeyboardManager", f = "KeyboardManager.kt", l = {80, 81}, m = "awaitCloseKeyboardWithDelay")
    /* loaded from: classes5.dex */
    public static final class e extends ContinuationImpl {

        /* renamed from: f  reason: collision with root package name */
        long f43554f;

        /* renamed from: g  reason: collision with root package name */
        /* synthetic */ Object f43555g;

        /* renamed from: i  reason: collision with root package name */
        int f43557i;

        e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f43555g = obj;
            this.f43557i |= Integer.MIN_VALUE;
            return ib.this.c(false, null, 0L, 0L, this);
        }
    }

    @DebugMetadata(c = "eu.bolt.client.keyboard.KeyboardManager$isKeyboardOpenFlow$1", f = "KeyboardManager.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class f extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43558g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ boolean f43559h;

        f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(continuation);
            fVar.f43559h = ((Boolean) obj).booleanValue();
            return fVar;
        }

        public final Object h(boolean z7, Continuation<? super Unit> continuation) {
            return ((f) create(Boolean.valueOf(z7), continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f43558g == 0) {
                ResultKt.b(obj);
                boolean z7 = this.f43559h;
                Logger logger = ib.this.f43529b;
                logger.b("Is keyboard open=" + z7);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object s(Boolean bool, Continuation<? super Unit> continuation) {
            return h(bool.booleanValue(), continuation);
        }
    }

    public ib(ComponentActivity activity) {
        Intrinsics.f(activity, "activity");
        this.f43528a = activity;
        Logger f8 = ac.a.f42020b.f();
        this.f43529b = f8;
        Lifecycle lifecycle = activity.getLifecycle();
        Intrinsics.e(lifecycle, "activity.lifecycle");
        CoroutineScope a8 = LifecycleBoundScopeKt.a(lifecycle, "KeyboardManager", f8);
        this.f43530c = a8;
        this.f43531d = new jb(f8, activity);
        hb hbVar = new hb(f8, activity);
        this.f43532e = hbVar;
        MutableStateFlow<Boolean> a9 = StateFlowKt.a(Boolean.valueOf(hbVar.f()));
        this.f43533f = a9;
        this.f43534g = FlowKt.F(a9, new f(null));
        BuildersKt__Builders_commonKt.d(a8, null, null, new a(null), 3, null);
        FlowExtensionsKt.f(FlowKt.j(hbVar.h()), a8, new b(null), null, null, null, false, 60, null);
    }

    public static /* synthetic */ void f(ib ibVar, View view, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            view = null;
        }
        if ((i8 & 2) != 0) {
            z7 = true;
        }
        ibVar.e(view, z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(boolean r14, kotlin.jvm.functions.Function0<kotlin.Unit> r15, long r16, long r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r13 = this;
            r0 = r20
            boolean r1 = r0 instanceof eu.bolt.verification.sdk.internal.ib.e
            if (r1 == 0) goto L16
            r1 = r0
            eu.bolt.verification.sdk.internal.ib$e r1 = (eu.bolt.verification.sdk.internal.ib.e) r1
            int r2 = r1.f43557i
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f43557i = r2
            r8 = r13
            goto L1c
        L16:
            eu.bolt.verification.sdk.internal.ib$e r1 = new eu.bolt.verification.sdk.internal.ib$e
            r8 = r13
            r1.<init>(r0)
        L1c:
            java.lang.Object r0 = r1.f43555g
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r1.f43557i
            r10 = 2
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 == r3) goto L38
            if (r2 != r10) goto L30
            kotlin.ResultKt.b(r0)
            goto L5e
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            long r2 = r1.f43554f
            kotlin.ResultKt.b(r0)
            r11 = r2
            goto L55
        L3f:
            kotlin.ResultKt.b(r0)
            r11 = r18
            r1.f43554f = r11
            r1.f43557i = r3
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r7 = r1
            java.lang.Object r0 = r2.d(r3, r4, r5, r7)
            if (r0 != r9) goto L55
            return r9
        L55:
            r1.f43557i = r10
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.a(r11, r1)
            if (r0 != r9) goto L5e
            return r9
        L5e:
            kotlin.Unit r0 = kotlin.Unit.f50853a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ib.c(boolean, kotlin.jvm.functions.Function0, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object d(boolean z7, Function0<Unit> function0, long j8, Continuation<? super Unit> continuation) {
        Object d8;
        if (g()) {
            Object c8 = TimeoutKt.c(j8, new d(function0, this, z7, null), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return c8 == d8 ? c8 : Unit.f50853a;
        }
        return Unit.f50853a;
    }

    public final void e(View view, boolean z7) {
        this.f43531d.c(view, z7);
    }

    public final boolean g() {
        Boolean value = this.f43533f.getValue();
        boolean booleanValue = value.booleanValue();
        Logger logger = this.f43529b;
        logger.b("Is keyboard open=" + booleanValue);
        return value.booleanValue();
    }

    public final Flow<Boolean> h() {
        return this.f43534g;
    }
}
