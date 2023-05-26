package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.sdk.internal.o2;
import eu.bolt.verification.sdk.internal.qe;
import eu.bolt.verification.sdk.internal.t2;
import eu.bolt.verification.sdk.internal.u;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes5.dex */
public final class q2 extends BaseRibInteractor<w2> {

    /* renamed from: n  reason: collision with root package name */
    private final o2 f44592n;

    /* renamed from: o  reason: collision with root package name */
    private final t2 f44593o;

    /* renamed from: p  reason: collision with root package name */
    private final qe f44594p;

    /* renamed from: q  reason: collision with root package name */
    private final bg f44595q;

    /* renamed from: r  reason: collision with root package name */
    private final s2 f44596r;

    /* renamed from: s  reason: collision with root package name */
    private final ib f44597s;

    /* renamed from: t  reason: collision with root package name */
    private final String f44598t;

    /* renamed from: u  reason: collision with root package name */
    private final i2 f44599u;

    /* renamed from: v  reason: collision with root package name */
    private final List<h2> f44600v;

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibInteractor$handleCloseClick$1", f = "CountryPickerRibInteractor.kt", l = {73}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44601g;

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
            Object c8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44601g;
            if (i8 == 0) {
                ResultKt.b(obj);
                ib ibVar = q2.this.f44597s;
                this.f44601g = 1;
                c8 = ibVar.c((r17 & 1) != 0, (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? 500L : 0L, (r17 & 8) != 0 ? 100L : 0L, this);
                if (c8 == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            q2.this.f44596r.f(false);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibInteractor$handlePickerItemClick$1", f = "CountryPickerRibInteractor.kt", l = {80}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44603g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ h2 f44605i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(h2 h2Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f44605i = h2Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f44605i, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            Object c8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44603g;
            if (i8 == 0) {
                ResultKt.b(obj);
                ib ibVar = q2.this.f44597s;
                this.f44603g = 1;
                c8 = ibVar.c((r17 & 1) != 0, (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? 500L : 0L, (r17 & 8) != 0 ? 100L : 0L, this);
                if (c8 == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            q2.this.f44596r.n(this.f44605i);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibInteractor$observeUiEvents$1", f = "CountryPickerRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class c extends SuspendLambda implements Function2<t2.b, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44606g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f44607h;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(continuation);
            cVar.f44607h = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(t2.b bVar, Continuation<? super Unit> continuation) {
            return ((c) create(bVar, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f44606g == 0) {
                ResultKt.b(obj);
                t2.b bVar = (t2.b) this.f44607h;
                if (Intrinsics.a(bVar, t2.b.a.f45109a)) {
                    q2.this.a();
                } else if (bVar instanceof t2.b.C0091b) {
                    q2.this.n(((t2.b.C0091b) bVar).a());
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibInteractor$observeUiEvents$2", f = "CountryPickerRibInteractor.kt", l = {63}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class d extends SuspendLambda implements Function2<CharSequence, Continuation<? super List<? extends sb>>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44609g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f44610h;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(continuation);
            dVar.f44610h = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CharSequence charSequence, Continuation<? super List<? extends sb>> continuation) {
            return ((d) create(charSequence, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44609g;
            if (i8 == 0) {
                ResultKt.b(obj);
                qe qeVar = q2.this.f44594p;
                qe.a aVar = new qe.a((CharSequence) this.f44610h, q2.this.f44600v);
                this.f44609g = 1;
                obj = qeVar.a(aVar, this);
                if (obj == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return q2.this.f44599u.e((List) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.countrypicker.CountryPickerRibInteractor$observeUiEvents$3", f = "CountryPickerRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class e extends SuspendLambda implements Function2<List<? extends sb>, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44612g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f44613h;

        e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e eVar = new e(continuation);
            eVar.f44613h = obj;
            return eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(List<? extends sb> list, Continuation<? super Unit> continuation) {
            return ((e) create(list, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f44612g == 0) {
                ResultKt.b(obj);
                q2.this.f44593o.k((List) this.f44613h);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Inject
    public q2(o2 args, t2 presenter, qe prefixCodeQueryInteractor, bg ribAnalyticsManager, s2 ribListener, ib keyboardManager) {
        ArrayList arrayList;
        List<h2> list;
        Intrinsics.f(args, "args");
        Intrinsics.f(presenter, "presenter");
        Intrinsics.f(prefixCodeQueryInteractor, "prefixCodeQueryInteractor");
        Intrinsics.f(ribAnalyticsManager, "ribAnalyticsManager");
        Intrinsics.f(ribListener, "ribListener");
        Intrinsics.f(keyboardManager, "keyboardManager");
        this.f44592n = args;
        this.f44593o = presenter;
        this.f44594p = prefixCodeQueryInteractor;
        this.f44595q = ribAnalyticsManager;
        this.f44596r = ribListener;
        this.f44597s = keyboardManager;
        this.f44598t = "CountryPickerRibInteractor";
        this.f44599u = new i2(args.d());
        o2.a a8 = args.a();
        if (a8 instanceof o2.a.C0078a) {
            list = ArraysKt___ArraysKt.f0(h2.values());
        } else {
            int i8 = 0;
            if (a8 instanceof o2.a.b) {
                h2[] values = h2.values();
                arrayList = new ArrayList();
                int length = values.length;
                while (i8 < length) {
                    h2 h2Var = values[i8];
                    if (((o2.a.b) this.f44592n.a()).a().contains(h2Var)) {
                        arrayList.add(h2Var);
                    }
                    i8++;
                }
            } else if (!(a8 instanceof o2.a.c)) {
                throw new NoWhenBranchMatchedException();
            } else {
                h2[] values2 = h2.values();
                arrayList = new ArrayList();
                int length2 = values2.length;
                while (i8 < length2) {
                    h2 h2Var2 = values2[i8];
                    if (!((o2.a.c) this.f44592n.a()).a().contains(h2Var2)) {
                        arrayList.add(h2Var2);
                    }
                    i8++;
                }
            }
            list = arrayList;
        }
        this.f44600v = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        BaseScopeOwner.F(this, null, null, new a(null), 3, null);
    }

    private final void b() {
        BaseScopeOwner.H(this, this.f44593o.p(), new c(null), null, null, null, false, 30, null);
        BaseScopeOwner.H(this, FlowKt.B(this.f44593o.g(), new d(null)), new e(null), null, null, null, false, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(h2 h2Var) {
        BaseScopeOwner.F(this, null, null, new b(h2Var, null), 3, null);
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.f44598t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        super.K(bundle);
        this.f44595q.b(this, new u.a());
        this.f44593o.k(this.f44599u.e(this.f44600v));
        b();
    }

    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        this.f44596r.f(this.f44592n.c());
        return true;
    }
}
