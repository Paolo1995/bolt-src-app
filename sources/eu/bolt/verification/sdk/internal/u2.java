package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseViewRibPresenterExtKt;
import eu.bolt.coroutines.flows.PublishFlow;
import eu.bolt.verification.R$string;
import eu.bolt.verification.sdk.internal.t2;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx2.RxConvertKt;
import reactivecircus.flowbinding.android.widget.EditorActionEvent;
import reactivecircus.flowbinding.android.widget.TextViewEditorActionEventFlowKt;
import reactivecircus.flowbinding.android.widget.TextViewTextChangeFlowKt;

/* loaded from: classes5.dex */
public final class u2 implements t2 {

    /* renamed from: a  reason: collision with root package name */
    private final y2 f45251a;

    /* renamed from: b  reason: collision with root package name */
    private final PublishFlow<h2> f45252b;

    /* renamed from: c  reason: collision with root package name */
    private final l2 f45253c;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<j2, Unit> {
        a() {
            super(1);
        }

        public final void b(j2 item) {
            Intrinsics.f(item, "item");
            u2.this.f45252b.f(item.b());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(j2 j2Var) {
            b(j2Var);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Flow<t2.b.a> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f45255f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f45256f;

            @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibPresenterImpl$observeCloseClicks$$inlined$map$1$2", f = "CountryPickerRibPresenterImpl.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.u2$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0092a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f45257f;

                /* renamed from: g  reason: collision with root package name */
                int f45258g;

                public C0092a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f45257f = obj;
                    this.f45258g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f45256f = flowCollector;
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
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.u2.b.a.C0092a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.u2$b$a$a r0 = (eu.bolt.verification.sdk.internal.u2.b.a.C0092a) r0
                    int r1 = r0.f45258g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f45258g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.u2$b$a$a r0 = new eu.bolt.verification.sdk.internal.u2$b$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f45257f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f45258g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f45256f
                    kotlin.Unit r5 = (kotlin.Unit) r5
                    eu.bolt.verification.sdk.internal.t2$b$a r5 = eu.bolt.verification.sdk.internal.t2.b.a.f45109a
                    r0.f45258g = r3
                    java.lang.Object r5 = r6.b(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u2.b.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public b(Flow flow) {
            this.f45255f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super t2.b.a> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f45255f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Flow<EditorActionEvent> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f45260f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f45261f;

            @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibPresenterImpl$observeKeyboardUpdates$$inlined$filter$1$2", f = "CountryPickerRibPresenterImpl.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.u2$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0093a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f45262f;

                /* renamed from: g  reason: collision with root package name */
                int f45263g;

                public C0093a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f45262f = obj;
                    this.f45263g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f45261f = flowCollector;
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
                    boolean r0 = r8 instanceof eu.bolt.verification.sdk.internal.u2.c.a.C0093a
                    if (r0 == 0) goto L13
                    r0 = r8
                    eu.bolt.verification.sdk.internal.u2$c$a$a r0 = (eu.bolt.verification.sdk.internal.u2.c.a.C0093a) r0
                    int r1 = r0.f45263g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f45263g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.u2$c$a$a r0 = new eu.bolt.verification.sdk.internal.u2$c$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.f45262f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f45263g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r8)
                    goto L6a
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    kotlin.ResultKt.b(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r6.f45261f
                    r2 = r7
                    reactivecircus.flowbinding.android.widget.EditorActionEvent r2 = (reactivecircus.flowbinding.android.widget.EditorActionEvent) r2
                    android.view.KeyEvent r4 = r2.getKeyEvent()
                    r5 = 0
                    if (r4 == 0) goto L48
                    int r4 = r4.getAction()
                    if (r4 != 0) goto L48
                    r4 = 1
                    goto L49
                L48:
                    r4 = 0
                L49:
                    if (r4 == 0) goto L5f
                    android.view.KeyEvent r2 = r2.getKeyEvent()
                    if (r2 == 0) goto L5b
                    int r2 = r2.getKeyCode()
                    r4 = 66
                    if (r2 != r4) goto L5b
                    r2 = 1
                    goto L5c
                L5b:
                    r2 = 0
                L5c:
                    if (r2 == 0) goto L5f
                    r5 = 1
                L5f:
                    if (r5 == 0) goto L6a
                    r0.f45263g = r3
                    java.lang.Object r7 = r8.b(r7, r0)
                    if (r7 != r1) goto L6a
                    return r1
                L6a:
                    kotlin.Unit r7 = kotlin.Unit.f50853a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u2.c.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public c(Flow flow) {
            this.f45260f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super EditorActionEvent> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f45260f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements Flow<t2.b.C0091b> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f45265f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f45266f;

            @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibPresenterImpl$observeKeyboardUpdates$$inlined$map$1$2", f = "CountryPickerRibPresenterImpl.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.u2$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0094a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f45267f;

                /* renamed from: g  reason: collision with root package name */
                int f45268g;

                public C0094a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f45267f = obj;
                    this.f45268g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f45266f = flowCollector;
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
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.u2.d.a.C0094a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.u2$d$a$a r0 = (eu.bolt.verification.sdk.internal.u2.d.a.C0094a) r0
                    int r1 = r0.f45268g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f45268g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.u2$d$a$a r0 = new eu.bolt.verification.sdk.internal.u2$d$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f45267f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f45268g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L46
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f45266f
                    eu.bolt.verification.sdk.internal.h2 r5 = (eu.bolt.verification.sdk.internal.h2) r5
                    eu.bolt.verification.sdk.internal.t2$b$b r2 = new eu.bolt.verification.sdk.internal.t2$b$b
                    r2.<init>(r5)
                    r0.f45268g = r3
                    java.lang.Object r5 = r6.b(r2, r0)
                    if (r5 != r1) goto L46
                    return r1
                L46:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u2.d.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public d(Flow flow) {
            this.f45265f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super t2.b.C0091b> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f45265f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements Flow<h2> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f45270f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ u2 f45271g;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f45272f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ u2 f45273g;

            @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibPresenterImpl$observeKeyboardUpdates$$inlined$mapNotNull$1$2", f = "CountryPickerRibPresenterImpl.kt", l = {226}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.u2$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0095a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f45274f;

                /* renamed from: g  reason: collision with root package name */
                int f45275g;

                public C0095a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f45274f = obj;
                    this.f45275g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector, u2 u2Var) {
                this.f45272f = flowCollector;
                this.f45273g = u2Var;
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
                    boolean r0 = r8 instanceof eu.bolt.verification.sdk.internal.u2.e.a.C0095a
                    if (r0 == 0) goto L13
                    r0 = r8
                    eu.bolt.verification.sdk.internal.u2$e$a$a r0 = (eu.bolt.verification.sdk.internal.u2.e.a.C0095a) r0
                    int r1 = r0.f45275g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f45275g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.u2$e$a$a r0 = new eu.bolt.verification.sdk.internal.u2$e$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.f45274f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f45275g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r8)
                    goto L75
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    kotlin.ResultKt.b(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r6.f45272f
                    reactivecircus.flowbinding.android.widget.EditorActionEvent r7 = (reactivecircus.flowbinding.android.widget.EditorActionEvent) r7
                    eu.bolt.verification.sdk.internal.u2 r7 = r6.f45273g
                    eu.bolt.verification.sdk.internal.l2 r7 = eu.bolt.verification.sdk.internal.u2.z(r7)
                    java.util.List r7 = r7.P()
                    java.lang.String r2 = "adapter.items"
                    kotlin.jvm.internal.Intrinsics.e(r7, r2)
                    java.util.Iterator r7 = r7.iterator()
                L4b:
                    boolean r2 = r7.hasNext()
                    r4 = 0
                    if (r2 == 0) goto L63
                    java.lang.Object r2 = r7.next()
                    eu.bolt.verification.sdk.internal.sb r2 = (eu.bolt.verification.sdk.internal.sb) r2
                    boolean r5 = r2 instanceof eu.bolt.verification.sdk.internal.j2
                    if (r5 == 0) goto L5f
                    eu.bolt.verification.sdk.internal.j2 r2 = (eu.bolt.verification.sdk.internal.j2) r2
                    goto L60
                L5f:
                    r2 = r4
                L60:
                    if (r2 == 0) goto L4b
                    goto L64
                L63:
                    r2 = r4
                L64:
                    if (r2 == 0) goto L6a
                    eu.bolt.verification.sdk.internal.h2 r4 = r2.b()
                L6a:
                    if (r4 == 0) goto L75
                    r0.f45275g = r3
                    java.lang.Object r7 = r8.b(r4, r0)
                    if (r7 != r1) goto L75
                    return r1
                L75:
                    kotlin.Unit r7 = kotlin.Unit.f50853a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u2.e.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public e(Flow flow, u2 u2Var) {
            this.f45270f = flow;
            this.f45271g = u2Var;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super h2> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f45270f.a(new a(flowCollector, this.f45271g), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class f implements Flow<t2.b.C0091b> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f45277f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f45278f;

            @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibPresenterImpl$observePickerItemClicks$$inlined$map$1$2", f = "CountryPickerRibPresenterImpl.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.u2$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0096a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f45279f;

                /* renamed from: g  reason: collision with root package name */
                int f45280g;

                public C0096a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f45279f = obj;
                    this.f45280g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f45278f = flowCollector;
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
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.u2.f.a.C0096a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.u2$f$a$a r0 = (eu.bolt.verification.sdk.internal.u2.f.a.C0096a) r0
                    int r1 = r0.f45280g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f45280g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.u2$f$a$a r0 = new eu.bolt.verification.sdk.internal.u2$f$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f45279f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f45280g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L46
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f45278f
                    eu.bolt.verification.sdk.internal.h2 r5 = (eu.bolt.verification.sdk.internal.h2) r5
                    eu.bolt.verification.sdk.internal.t2$b$b r2 = new eu.bolt.verification.sdk.internal.t2$b$b
                    r2.<init>(r5)
                    r0.f45280g = r3
                    java.lang.Object r5 = r6.b(r2, r0)
                    if (r5 != r1) goto L46
                    return r1
                L46:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u2.f.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public f(Flow flow) {
            this.f45277f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super t2.b.C0091b> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f45277f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements Flow<CharSequence> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f45282f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f45283f;

            @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibPresenterImpl$observeQueryUpdates$$inlined$map$1$2", f = "CountryPickerRibPresenterImpl.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.u2$g$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0097a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f45284f;

                /* renamed from: g  reason: collision with root package name */
                int f45285g;

                public C0097a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f45284f = obj;
                    this.f45285g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f45283f = flowCollector;
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
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.u2.g.a.C0097a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.u2$g$a$a r0 = (eu.bolt.verification.sdk.internal.u2.g.a.C0097a) r0
                    int r1 = r0.f45285g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f45285g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.u2$g$a$a r0 = new eu.bolt.verification.sdk.internal.u2$g$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f45284f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f45285g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L41
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f45283f
                    java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                    r0.f45285g = r3
                    java.lang.Object r5 = r6.b(r5, r0)
                    if (r5 != r1) goto L41
                    return r1
                L41:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u2.g.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public g(Flow flow) {
            this.f45282f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super CharSequence> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f45282f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    @Inject
    public u2(y2 view, o2 args) {
        Intrinsics.f(view, "view");
        Intrinsics.f(args, "args");
        this.f45251a = view;
        this.f45252b = BaseViewRibPresenterExtKt.a(this);
        l2 l2Var = new l2(new a(), args.d());
        this.f45253c = l2Var;
        view.getToolbar().setTitle(b());
        view.getToolbar().setHomeButtonIcon(args.b().a());
        view.getCountryRecycler().setAdapter(l2Var);
        view.getCountryRecycler().setItemAnimator(null);
    }

    private final Flow<t2.b> B() {
        return new b(RxConvertKt.b(this.f45251a.getToolbar().a0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(u2 this$0) {
        Intrinsics.f(this$0, "this$0");
        nf.a(this$0.f45251a.getCountryRecycler(), false);
    }

    private final Flow<t2.b> D() {
        return new d(new e(new c(TextViewEditorActionEventFlowKt.editorActionEvents$default(this.f45251a.getSearchField().getInputView(), (Function1) null, 1, (Object) null)), this));
    }

    private final Flow<t2.b> E() {
        return new f(this.f45252b);
    }

    private final int b() {
        return R$string.phone_prefix_picker_select_country;
    }

    @Override // eu.bolt.verification.sdk.internal.t2
    public Flow<CharSequence> g() {
        return new g(TextViewTextChangeFlowKt.textChanges(this.f45251a.getSearchField().getInputView()));
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Observable<t2.b> h() {
        return t2.a.a(this);
    }

    @Override // eu.bolt.verification.sdk.internal.t2
    public void k(List<? extends sb> items) {
        Intrinsics.f(items, "items");
        this.f45253c.Q(items);
        this.f45251a.getCountryRecycler().setVisibility(items.isEmpty() ? 8 : 0);
        this.f45251a.getCountryNotFound().setVisibility(items.isEmpty() ? 0 : 8);
        this.f45251a.post(new Runnable() { // from class: eu.bolt.verification.sdk.internal.ww
            @Override // java.lang.Runnable
            public final void run() {
                u2.C(u2.this);
            }
        });
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Flow<t2.b> p() {
        return FlowKt.D(E(), B(), D());
    }
}
