package eu.bolt.android.rib.rx;

import eu.bolt.logger.StaticLogger;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RxExt.kt */
/* loaded from: classes5.dex */
public final class RxExtKt {

    /* renamed from: a */
    private static final Function0<Unit> f37239a = new Function0<Unit>() { // from class: eu.bolt.android.rib.rx.RxExtKt$emptyOnComplete$1
        public final void b() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    };

    /* renamed from: b */
    private static final Function1<Throwable, Unit> f37240b = new Function1<Throwable, Unit>() { // from class: eu.bolt.android.rib.rx.RxExtKt$emptyOnError$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f50853a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable it) {
            StaticLogger g8;
            Intrinsics.f(it, "it");
            g8 = RxExtKt.g();
            g8.a(it, "Default error handler");
        }
    };

    /* renamed from: c */
    private static final Function1<Disposable, Unit> f37241c = new Function1<Disposable, Unit>() { // from class: eu.bolt.android.rib.rx.RxExtKt$emptyOnSubscribe$1
        public final void b(Disposable it) {
            Intrinsics.f(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
            b(disposable);
            return Unit.f50853a;
        }
    };

    /* renamed from: d */
    private static final Function0<Unit> f37242d = new Function0<Unit>() { // from class: eu.bolt.android.rib.rx.RxExtKt$emptyOnFinish$1
        public final void b() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    };

    private static final <T> Function1<T, Unit> f() {
        return new Function1<T, Unit>() { // from class: eu.bolt.android.rib.rx.RxExtKt$emptyOnNext$1
            public final void b(T t7) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b(obj);
                return Unit.f50853a;
            }
        };
    }

    public static final StaticLogger g() {
        return StaticLogger.f41686a;
    }

    public static final <T> Disposable h(Observable<T> observable, final Function1<? super T, Unit> onNext, final Function1<? super Throwable, Unit> onError, final Function0<Unit> onComplete, final Function1<? super Disposable, Unit> onSubscribe, final Function0<Unit> onFinish) {
        Intrinsics.f(observable, "<this>");
        Intrinsics.f(onNext, "onNext");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onComplete, "onComplete");
        Intrinsics.f(onSubscribe, "onSubscribe");
        Intrinsics.f(onFinish, "onFinish");
        Consumer<? super T> consumer = new Consumer() { // from class: eu.bolt.android.rib.rx.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxExtKt.j(Function1.this, obj);
            }
        };
        final Function1<Object, Object> function1 = new Function1<Object, Object>() { // from class: eu.bolt.android.rib.rx.RxExtKt$andThen$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object invoke = onError.invoke(obj);
                onFinish.invoke();
                return invoke;
            }
        };
        Consumer<? super Throwable> consumer2 = new Consumer() { // from class: eu.bolt.android.rib.rx.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxExtKt.k(Function1.this, obj);
            }
        };
        final Function0<Object> function0 = new Function0<Object>() { // from class: eu.bolt.android.rib.rx.RxExtKt$andThen$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object invoke = onComplete.invoke();
                onFinish.invoke();
                return invoke;
            }
        };
        Disposable subscribe = observable.subscribe(consumer, consumer2, new Action() { // from class: eu.bolt.android.rib.rx.c
            @Override // io.reactivex.functions.Action
            public final void run() {
                RxExtKt.l(Function0.this);
            }
        }, new Consumer() { // from class: eu.bolt.android.rib.rx.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxExtKt.m(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "this.subscribe(\n        …        onSubscribe\n    )");
        return subscribe;
    }

    public static /* synthetic */ Disposable i(Observable observable, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function0 function02, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = f();
        }
        if ((i8 & 2) != 0) {
            function12 = f37240b;
        }
        Function1 function14 = function12;
        if ((i8 & 4) != 0) {
            function0 = f37239a;
        }
        Function0 function03 = function0;
        if ((i8 & 8) != 0) {
            function13 = f37241c;
        }
        Function1 function15 = function13;
        if ((i8 & 16) != 0) {
            function02 = f37242d;
        }
        return h(observable, function1, function14, function03, function15, function02);
    }

    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
