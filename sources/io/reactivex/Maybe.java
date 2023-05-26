package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.maybe.MaybeToSingle;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public abstract class Maybe<T> implements MaybeSource<T> {
    public static <T> Maybe<T> e(Callable<? extends T> callable) {
        ObjectHelper.e(callable, "callable is null");
        return RxJavaPlugins.m(new MaybeFromCallable(callable));
    }

    @Override // io.reactivex.MaybeSource
    public final void a(MaybeObserver<? super T> maybeObserver) {
        ObjectHelper.e(maybeObserver, "observer is null");
        MaybeObserver<? super T> x7 = RxJavaPlugins.x(this, maybeObserver);
        ObjectHelper.e(x7, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            i(x7);
        } catch (NullPointerException e8) {
            throw e8;
        } catch (Throwable th) {
            Exceptions.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final T c() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        a(blockingMultiObserver);
        return (T) blockingMultiObserver.a();
    }

    public final Completable d(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.k(new MaybeFlatMapCompletable(this, function));
    }

    public final <R> Maybe<R> f(Function<? super T, ? extends R> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.m(new MaybeMap(this, function));
    }

    public final Disposable g(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return h(consumer, consumer2, Functions.f47618c);
    }

    public final Disposable h(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.e(consumer, "onSuccess is null");
        ObjectHelper.e(consumer2, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        return (Disposable) j(new MaybeCallbackObserver(consumer, consumer2, action));
    }

    protected abstract void i(MaybeObserver<? super T> maybeObserver);

    public final <E extends MaybeObserver<? super T>> E j(E e8) {
        a(e8);
        return e8;
    }

    public final Flowable<T> k() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).c();
        }
        return RxJavaPlugins.l(new MaybeToFlowable(this));
    }

    public final Observable<T> l() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).b();
        }
        return RxJavaPlugins.n(new MaybeToObservable(this));
    }

    public final Single<T> m() {
        return RxJavaPlugins.o(new MaybeToSingle(this, null));
    }
}
