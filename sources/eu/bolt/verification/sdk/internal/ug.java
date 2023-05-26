package eu.bolt.verification.sdk.internal;

import eu.bolt.logger.StaticLogger;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class ug {

    /* renamed from: a */
    private static final Function0<Unit> f45358a = a.f45363f;

    /* renamed from: b */
    private static Function1<? super Throwable, Unit> f45359b = b.f45364f;

    /* renamed from: c */
    private static final Function1<Disposable, Unit> f45360c = e.f45367f;

    /* renamed from: d */
    private static final Function1<Subscription, Unit> f45361d = f.f45368f;

    /* renamed from: e */
    private static final Function0<Unit> f45362e = c.f45365f;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function0<Unit> {

        /* renamed from: f */
        public static final a f45363f = new a();

        a() {
            super(0);
        }

        public final void b() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: f */
        public static final b f45364f = new b();

        b() {
            super(1);
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            ug.l().a(it, "Default error handler");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function0<Unit> {

        /* renamed from: f */
        public static final c f45365f = new c();

        c() {
            super(0);
        }

        public final void b() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d<T> extends Lambda implements Function1<T, Unit> {

        /* renamed from: f */
        public static final d f45366f = new d();

        d() {
            super(1);
        }

        public final void b(T t7) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            b(obj);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class e extends Lambda implements Function1<Disposable, Unit> {

        /* renamed from: f */
        public static final e f45367f = new e();

        e() {
            super(1);
        }

        public final void b(Disposable it) {
            Intrinsics.f(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
            b(disposable);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class f extends Lambda implements Function1<Subscription, Unit> {

        /* renamed from: f */
        public static final f f45368f = new f();

        f() {
            super(1);
        }

        public final void b(Subscription it) {
            Intrinsics.f(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            b(subscription);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class g<T> extends Lambda implements Function1<vd<T>, Boolean> {

        /* renamed from: f */
        public static final g f45369f = new g();

        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(vd<T> it) {
            Intrinsics.f(it, "it");
            return Boolean.valueOf(it.f());
        }
    }

    /* loaded from: classes5.dex */
    public static final class h<T> extends Lambda implements Function1<vd<T>, T> {

        /* renamed from: f */
        public static final h f45370f = new h();

        h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final T invoke(vd<T> it) {
            Intrinsics.f(it, "it");
            return it.d();
        }
    }

    /* loaded from: classes5.dex */
    public static final class i<R, T> extends Lambda implements Function1<T, vd<R>> {

        /* renamed from: f */
        final /* synthetic */ Function1<T, R> f45371f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        i(Function1<? super T, ? extends R> function1) {
            super(1);
            this.f45371f = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final vd<R> invoke(T it) {
            Intrinsics.f(it, "it");
            return vd.b(this.f45371f.invoke(it));
        }
    }

    private static final StaticLogger A() {
        return StaticLogger.f41686a;
    }

    public static final vd B(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (vd) tmp0.invoke(obj);
    }

    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void G(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final /* synthetic */ StaticLogger l() {
        return A();
    }

    public static final <T> Observable<T> m(Observable<vd<T>> observable) {
        Intrinsics.f(observable, "<this>");
        final g gVar = g.f45369f;
        Observable<vd<T>> filter = observable.filter(new Predicate() { // from class: eu.bolt.verification.sdk.internal.hx
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean w7;
                w7 = ug.w(Function1.this, obj);
                return w7;
            }
        });
        final h hVar = h.f45370f;
        Observable<T> observable2 = (Observable<T>) filter.map(new Function() { // from class: eu.bolt.verification.sdk.internal.yw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Object x7;
                x7 = ug.x(Function1.this, obj);
                return x7;
            }
        });
        Intrinsics.e(observable2, "filter { it.isPresent }\n    .map { it.get() }");
        return observable2;
    }

    public static final <T, R> Observable<R> n(Observable<T> observable, Function1<? super T, ? extends R> mapper) {
        Intrinsics.f(observable, "<this>");
        Intrinsics.f(mapper, "mapper");
        final i iVar = new i(mapper);
        Observable<R> map = observable.map(new Function() { // from class: eu.bolt.verification.sdk.internal.gx
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                vd B;
                B = ug.B(Function1.this, obj);
                return B;
            }
        });
        Intrinsics.e(map, "mapper: (T) -> R?): Obse…romNullable(mapper(it)) }");
        return m(map);
    }

    public static final Disposable o(Completable completable, Function0<Unit> onComplete, Function1<? super Throwable, Unit> onError, Function0<Unit> onFinish) {
        Intrinsics.f(completable, "<this>");
        Intrinsics.f(onComplete, "onComplete");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onFinish, "onFinish");
        final tg tgVar = new tg(onComplete, onFinish);
        Action action = new Action() { // from class: eu.bolt.verification.sdk.internal.xw
            @Override // io.reactivex.functions.Action
            public final void run() {
                ug.v(Function0.this);
            }
        };
        final sg sgVar = new sg(onError, onFinish);
        Disposable G = completable.G(action, new Consumer() { // from class: eu.bolt.verification.sdk.internal.zw
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ug.C(Function1.this, obj);
            }
        });
        Intrinsics.e(G, "this.subscribe(\n        …r.andThen(onFinish)\n    )");
        return G;
    }

    public static /* synthetic */ Disposable p(Completable completable, Function0 function0, Function1 function1, Function0 function02, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function0 = f45358a;
        }
        if ((i8 & 2) != 0) {
            function1 = f45359b;
        }
        if ((i8 & 4) != 0) {
            function02 = f45362e;
        }
        return o(completable, function0, function1, function02);
    }

    public static final <T> Disposable q(Observable<T> observable, final Function1<? super T, Unit> onNext, Function1<? super Throwable, Unit> onError, Function0<Unit> onComplete, final Function1<? super Disposable, Unit> onSubscribe, Function0<Unit> onFinish) {
        Intrinsics.f(observable, "<this>");
        Intrinsics.f(onNext, "onNext");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onComplete, "onComplete");
        Intrinsics.f(onSubscribe, "onSubscribe");
        Intrinsics.f(onFinish, "onFinish");
        Consumer<? super T> consumer = new Consumer() { // from class: eu.bolt.verification.sdk.internal.ax
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ug.F(Function1.this, obj);
            }
        };
        final sg sgVar = new sg(onError, onFinish);
        Consumer<? super Throwable> consumer2 = new Consumer() { // from class: eu.bolt.verification.sdk.internal.bx
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ug.G(Function1.this, obj);
            }
        };
        final tg tgVar = new tg(onComplete, onFinish);
        Disposable subscribe = observable.subscribe(consumer, consumer2, new Action() { // from class: eu.bolt.verification.sdk.internal.cx
            @Override // io.reactivex.functions.Action
            public final void run() {
                ug.z(Function0.this);
            }
        }, new Consumer() { // from class: eu.bolt.verification.sdk.internal.dx
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ug.H(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "this.subscribe(\n        …        onSubscribe\n    )");
        return subscribe;
    }

    public static /* synthetic */ Disposable r(Observable observable, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function0 function02, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = y();
        }
        if ((i8 & 2) != 0) {
            function12 = f45359b;
        }
        Function1 function14 = function12;
        if ((i8 & 4) != 0) {
            function0 = f45358a;
        }
        Function0 function03 = function0;
        if ((i8 & 8) != 0) {
            function13 = f45360c;
        }
        Function1 function15 = function13;
        if ((i8 & 16) != 0) {
            function02 = f45362e;
        }
        return q(observable, function1, function14, function03, function15, function02);
    }

    public static final <T> Disposable s(Single<T> single, Function1<? super T, Unit> onSuccess, Function1<? super Throwable, Unit> onError, Function0<Unit> onFinish) {
        Intrinsics.f(single, "<this>");
        Intrinsics.f(onSuccess, "onSuccess");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onFinish, "onFinish");
        final sg sgVar = new sg(onSuccess, onFinish);
        Consumer<? super T> consumer = new Consumer() { // from class: eu.bolt.verification.sdk.internal.ex
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ug.D(Function1.this, obj);
            }
        };
        final sg sgVar2 = new sg(onError, onFinish);
        Disposable I = single.I(consumer, new Consumer() { // from class: eu.bolt.verification.sdk.internal.fx
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ug.E(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "this.subscribe(\n        …r.andThen(onFinish)\n    )");
        return I;
    }

    public static /* synthetic */ Disposable t(Single single, Function1 function1, Function1 function12, Function0 function0, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = y();
        }
        if ((i8 & 2) != 0) {
            function12 = f45359b;
        }
        if ((i8 & 4) != 0) {
            function0 = f45362e;
        }
        return s(single, function1, function12, function0);
    }

    public static final void u(Disposable disposable, CompositeDisposable compositeDisposable) {
        Intrinsics.f(disposable, "<this>");
        Intrinsics.f(compositeDisposable, "compositeDisposable");
        compositeDisposable.b(disposable);
    }

    public static final void v(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final boolean w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final Object x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return tmp0.invoke(obj);
    }

    private static final <T> Function1<T, Unit> y() {
        return d.f45366f;
    }

    public static final void z(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
