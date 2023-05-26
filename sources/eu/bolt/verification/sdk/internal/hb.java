package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import eu.bolt.logger.Logger;
import eu.bolt.verification.sdk.internal.hb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes5.dex */
public final class hb {

    /* renamed from: e  reason: collision with root package name */
    private static final a f43373e = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Logger f43374a;

    /* renamed from: b  reason: collision with root package name */
    private final Activity f43375b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f43376c;

    /* renamed from: d  reason: collision with root package name */
    private final int f43377d;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.keyboard.KeyboardLayoutManager$awaitActivityRoot$2", f = "KeyboardLayoutManager.kt", l = {44}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super View>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43378g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f43379h;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.f43379h = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super View> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            CoroutineScope coroutineScope;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43378g;
            if (i8 == 0) {
                ResultKt.b(obj);
                coroutineScope = (CoroutineScope) this.f43379h;
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                coroutineScope = (CoroutineScope) this.f43379h;
                ResultKt.b(obj);
            }
            while (CoroutineScopeKt.f(coroutineScope) && !hb.this.f43375b.isFinishing()) {
                View a8 = gb.a(hb.this.f43375b);
                if (a8 != null) {
                    return a8;
                }
                this.f43379h = coroutineScope;
                this.f43378g = 1;
                if (YieldKt.a(this) == d8) {
                    return d8;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.keyboard.KeyboardLayoutManager$observeKeyboardState$1", f = "KeyboardLayoutManager.kt", l = {27, 38}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class c extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        Object f43381g;

        /* renamed from: h  reason: collision with root package name */
        int f43382h;

        /* renamed from: i  reason: collision with root package name */
        private /* synthetic */ Object f43383i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function0<Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ hb f43385f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f43386g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(hb hbVar, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                super(0);
                this.f43385f = hbVar;
                this.f43386g = onGlobalLayoutListener;
            }

            public final void b() {
                this.f43385f.i(this.f43386g);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(View view, hb hbVar, ProducerScope producerScope) {
            producerScope.u(Boolean.valueOf(gb.b(view, hbVar.f43376c, hbVar.f43377d)));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(continuation);
            cVar.f43383i = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            final ProducerScope producerScope;
            ProducerScope producerScope2;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43382h;
            if (i8 == 0) {
                ResultKt.b(obj);
                producerScope = (ProducerScope) this.f43383i;
                hb hbVar = hb.this;
                this.f43383i = producerScope;
                this.f43381g = producerScope;
                this.f43382h = 1;
                obj = hbVar.c(this);
                if (obj == d8) {
                    return d8;
                }
                producerScope2 = producerScope;
            } else if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                producerScope = (ProducerScope) this.f43381g;
                producerScope2 = (ProducerScope) this.f43383i;
                ResultKt.b(obj);
            }
            final View view = (View) obj;
            if (view != null) {
                producerScope.u(Boxing.a(gb.b(view, hb.this.f43376c, hb.this.f43377d)));
                final hb hbVar2 = hb.this;
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: eu.bolt.verification.sdk.internal.xs
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        hb.c.k(view, hbVar2, producerScope);
                    }
                };
                hb.this.d(onGlobalLayoutListener);
                a aVar = new a(hb.this, onGlobalLayoutListener);
                this.f43383i = null;
                this.f43381g = null;
                this.f43382h = 2;
                if (ProduceKt.a(producerScope2, aVar, this) == d8) {
                    return d8;
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("Activity root couldn't be retrieved");
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: j */
        public final Object s(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
            return ((c) create(producerScope, continuation)).invokeSuspend(Unit.f50853a);
        }
    }

    public hb(Logger logger, Activity activity) {
        Intrinsics.f(logger, "logger");
        Intrinsics.f(activity, "activity");
        this.f43374a = logger;
        this.f43375b = activity;
        this.f43376c = new Rect();
        this.f43377d = f2.a(activity, 100.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c(Continuation<? super View> continuation) {
        return TimeoutKt.c(50L, new b(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        View a8;
        ViewTreeObserver viewTreeObserver;
        this.f43374a.b("Add keyboard layout tree observer");
        if (onGlobalLayoutListener == null || (a8 = gb.a(this.f43375b)) == null || (viewTreeObserver = a8.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        View a8;
        ViewTreeObserver viewTreeObserver;
        this.f43374a.b("Remove keyboard layout tree observer");
        if (onGlobalLayoutListener == null || (a8 = gb.a(this.f43375b)) == null || (viewTreeObserver = a8.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public final boolean f() {
        View a8 = gb.a(this.f43375b);
        if (a8 != null) {
            return gb.b(a8, this.f43376c, this.f43377d);
        }
        return false;
    }

    public final Flow<Boolean> h() {
        return FlowKt.d(new c(null));
    }
}
