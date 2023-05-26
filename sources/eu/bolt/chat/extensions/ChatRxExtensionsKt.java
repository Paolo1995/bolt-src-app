package eu.bolt.chat.extensions;

import eu.bolt.chat.tools.ToolsKit;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Subscription;

/* compiled from: ChatRxExtensions.kt */
/* loaded from: classes5.dex */
public final class ChatRxExtensionsKt {

    /* renamed from: a */
    private static final Function0<Unit> f39091a = new Function0<Unit>() { // from class: eu.bolt.chat.extensions.ChatRxExtensionsKt$emptyOnComplete$1
        public final void b() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    };

    /* renamed from: b */
    private static final Function1<Throwable, Unit> f39092b = new Function1<Throwable, Unit>() { // from class: eu.bolt.chat.extensions.ChatRxExtensionsKt$emptyOnError$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f50853a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable it) {
            Logger r7;
            Intrinsics.f(it, "it");
            r7 = ChatRxExtensionsKt.r();
            r7.a(it, "Default error handler");
        }
    };

    /* renamed from: c */
    private static final Function1<Disposable, Unit> f39093c = new Function1<Disposable, Unit>() { // from class: eu.bolt.chat.extensions.ChatRxExtensionsKt$emptyOnSubscribe$1
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
    private static final Function1<Subscription, Unit> f39094d = new Function1<Subscription, Unit>() { // from class: eu.bolt.chat.extensions.ChatRxExtensionsKt$emptyOnSubscribeFlowable$1
        public final void b(Subscription it) {
            Intrinsics.f(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            b(subscription);
            return Unit.f50853a;
        }
    };

    /* renamed from: e */
    private static final Function0<Unit> f39095e = new Function0<Unit>() { // from class: eu.bolt.chat.extensions.ChatRxExtensionsKt$emptyOnFinish$1
        public final void b() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    };

    public static /* synthetic */ Disposable A(Observable observable, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function0 function02, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = q();
        }
        if ((i8 & 2) != 0) {
            function12 = f39092b;
        }
        Function1 function14 = function12;
        if ((i8 & 4) != 0) {
            function0 = f39091a;
        }
        Function0 function03 = function0;
        if ((i8 & 8) != 0) {
            function13 = f39093c;
        }
        Function1 function15 = function13;
        if ((i8 & 16) != 0) {
            function02 = f39095e;
        }
        return v(observable, function1, function14, function03, function15, function02);
    }

    public static /* synthetic */ Disposable B(Single single, Function1 function1, Function1 function12, Function0 function0, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = q();
        }
        if ((i8 & 2) != 0) {
            function12 = f39092b;
        }
        if ((i8 & 4) != 0) {
            function0 = f39095e;
        }
        return w(single, function1, function12, function0);
    }

    public static final void C(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
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

    public static final void I(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void L(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void O(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void p(Disposable disposable, CompositeDisposable compositeDisposable) {
        Intrinsics.f(disposable, "<this>");
        Intrinsics.f(compositeDisposable, "compositeDisposable");
        compositeDisposable.b(disposable);
    }

    private static final <T> Function1<T, Unit> q() {
        return new Function1<T, Unit>() { // from class: eu.bolt.chat.extensions.ChatRxExtensionsKt$emptyOnNext$1
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

    public static final Logger r() {
        return ToolsKit.a();
    }

    public static final Disposable s(Completable completable, Function0<Unit> onComplete, Function1<? super Throwable, Unit> onError, Function0<Unit> onFinish) {
        Intrinsics.f(completable, "<this>");
        Intrinsics.f(onComplete, "onComplete");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onFinish, "onFinish");
        final ChatRxExtensionsKt$andThen$2 chatRxExtensionsKt$andThen$2 = new ChatRxExtensionsKt$andThen$2(onComplete, onFinish);
        Action action = new Action() { // from class: eu.bolt.chat.extensions.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                ChatRxExtensionsKt.C(Function0.this);
            }
        };
        final ChatRxExtensionsKt$andThen$1 chatRxExtensionsKt$andThen$1 = new ChatRxExtensionsKt$andThen$1(onError, onFinish);
        Disposable G = completable.G(action, new Consumer() { // from class: eu.bolt.chat.extensions.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.D(Function1.this, obj);
            }
        });
        Intrinsics.e(G, "this.subscribe(\n        …r.andThen(onFinish)\n    )");
        return G;
    }

    public static final <T> Disposable t(Flowable<T> flowable, final Function1<? super T, Unit> onNext, Function1<? super Throwable, Unit> onError, Function0<Unit> onComplete, Function0<Unit> onFinish) {
        Intrinsics.f(flowable, "<this>");
        Intrinsics.f(onNext, "onNext");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onComplete, "onComplete");
        Intrinsics.f(onFinish, "onFinish");
        Consumer<? super T> consumer = new Consumer() { // from class: eu.bolt.chat.extensions.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.J(Function1.this, obj);
            }
        };
        final ChatRxExtensionsKt$andThen$1 chatRxExtensionsKt$andThen$1 = new ChatRxExtensionsKt$andThen$1(onError, onFinish);
        Consumer<? super Throwable> consumer2 = new Consumer() { // from class: eu.bolt.chat.extensions.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.K(Function1.this, obj);
            }
        };
        final ChatRxExtensionsKt$andThen$2 chatRxExtensionsKt$andThen$2 = new ChatRxExtensionsKt$andThen$2(onComplete, onFinish);
        Disposable W = flowable.W(consumer, consumer2, new Action() { // from class: eu.bolt.chat.extensions.m
            @Override // io.reactivex.functions.Action
            public final void run() {
                ChatRxExtensionsKt.L(Function0.this);
            }
        });
        Intrinsics.e(W, "this.subscribe(\n        …e.andThen(onFinish)\n    )");
        return W;
    }

    public static final <T> Disposable u(Maybe<T> maybe, Function1<? super T, Unit> onSuccess, Function1<? super Throwable, Unit> onError, Function0<Unit> onComplete, Function0<Unit> onFinish) {
        Intrinsics.f(maybe, "<this>");
        Intrinsics.f(onSuccess, "onSuccess");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onComplete, "onComplete");
        Intrinsics.f(onFinish, "onFinish");
        final ChatRxExtensionsKt$andThen$1 chatRxExtensionsKt$andThen$1 = new ChatRxExtensionsKt$andThen$1(onSuccess, onFinish);
        Consumer<? super T> consumer = new Consumer() { // from class: eu.bolt.chat.extensions.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.G(Function1.this, obj);
            }
        };
        final ChatRxExtensionsKt$andThen$1 chatRxExtensionsKt$andThen$12 = new ChatRxExtensionsKt$andThen$1(onError, onFinish);
        Consumer<? super Throwable> consumer2 = new Consumer() { // from class: eu.bolt.chat.extensions.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.H(Function1.this, obj);
            }
        };
        final ChatRxExtensionsKt$andThen$2 chatRxExtensionsKt$andThen$2 = new ChatRxExtensionsKt$andThen$2(onComplete, onFinish);
        Disposable h8 = maybe.h(consumer, consumer2, new Action() { // from class: eu.bolt.chat.extensions.c
            @Override // io.reactivex.functions.Action
            public final void run() {
                ChatRxExtensionsKt.I(Function0.this);
            }
        });
        Intrinsics.e(h8, "this.subscribe(\n        …e.andThen(onFinish)\n    )");
        return h8;
    }

    public static final <T> Disposable v(Observable<T> observable, final Function1<? super T, Unit> onNext, Function1<? super Throwable, Unit> onError, Function0<Unit> onComplete, final Function1<? super Disposable, Unit> onSubscribe, Function0<Unit> onFinish) {
        Intrinsics.f(observable, "<this>");
        Intrinsics.f(onNext, "onNext");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onComplete, "onComplete");
        Intrinsics.f(onSubscribe, "onSubscribe");
        Intrinsics.f(onFinish, "onFinish");
        Consumer<? super T> consumer = new Consumer() { // from class: eu.bolt.chat.extensions.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.M(Function1.this, obj);
            }
        };
        final ChatRxExtensionsKt$andThen$1 chatRxExtensionsKt$andThen$1 = new ChatRxExtensionsKt$andThen$1(onError, onFinish);
        Consumer<? super Throwable> consumer2 = new Consumer() { // from class: eu.bolt.chat.extensions.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.N(Function1.this, obj);
            }
        };
        final ChatRxExtensionsKt$andThen$2 chatRxExtensionsKt$andThen$2 = new ChatRxExtensionsKt$andThen$2(onComplete, onFinish);
        Disposable subscribe = observable.subscribe(consumer, consumer2, new Action() { // from class: eu.bolt.chat.extensions.i
            @Override // io.reactivex.functions.Action
            public final void run() {
                ChatRxExtensionsKt.O(Function0.this);
            }
        }, new Consumer() { // from class: eu.bolt.chat.extensions.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.P(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "this.subscribe(\n        …        onSubscribe\n    )");
        return subscribe;
    }

    public static final <T> Disposable w(Single<T> single, Function1<? super T, Unit> onSuccess, Function1<? super Throwable, Unit> onError, Function0<Unit> onFinish) {
        Intrinsics.f(single, "<this>");
        Intrinsics.f(onSuccess, "onSuccess");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onFinish, "onFinish");
        final ChatRxExtensionsKt$andThen$1 chatRxExtensionsKt$andThen$1 = new ChatRxExtensionsKt$andThen$1(onSuccess, onFinish);
        Consumer<? super T> consumer = new Consumer() { // from class: eu.bolt.chat.extensions.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.E(Function1.this, obj);
            }
        };
        final ChatRxExtensionsKt$andThen$1 chatRxExtensionsKt$andThen$12 = new ChatRxExtensionsKt$andThen$1(onError, onFinish);
        Disposable I = single.I(consumer, new Consumer() { // from class: eu.bolt.chat.extensions.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatRxExtensionsKt.F(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "this.subscribe(\n        …r.andThen(onFinish)\n    )");
        return I;
    }

    public static /* synthetic */ Disposable x(Completable completable, Function0 function0, Function1 function1, Function0 function02, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function0 = f39091a;
        }
        if ((i8 & 2) != 0) {
            function1 = f39092b;
        }
        if ((i8 & 4) != 0) {
            function02 = f39095e;
        }
        return s(completable, function0, function1, function02);
    }

    public static /* synthetic */ Disposable y(Flowable flowable, Function1 function1, Function1 function12, Function0 function0, Function0 function02, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = q();
        }
        if ((i8 & 2) != 0) {
            function12 = f39092b;
        }
        if ((i8 & 4) != 0) {
            function0 = f39091a;
        }
        if ((i8 & 8) != 0) {
            function02 = f39095e;
        }
        return t(flowable, function1, function12, function0, function02);
    }

    public static /* synthetic */ Disposable z(Maybe maybe, Function1 function1, Function1 function12, Function0 function0, Function0 function02, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = q();
        }
        if ((i8 & 2) != 0) {
            function12 = f39092b;
        }
        if ((i8 & 4) != 0) {
            function0 = f39091a;
        }
        if ((i8 & 8) != 0) {
            function02 = f39095e;
        }
        return u(maybe, function1, function12, function0, function02);
    }
}
