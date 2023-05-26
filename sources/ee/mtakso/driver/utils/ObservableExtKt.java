package ee.mtakso.driver.utils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObservableExt.kt */
/* loaded from: classes5.dex */
public final class ObservableExtKt {
    public static final <T> Observable<T> f(Observable<T> observable) {
        Intrinsics.f(observable, "<this>");
        Observable<T> observeOn = observable.subscribeOn(Schedulers.a()).observeOn(AndroidSchedulers.a());
        Intrinsics.e(observeOn, "subscribeOn(Schedulers.c…dSchedulers.mainThread())");
        return observeOn;
    }

    public static final <T> Observable<T> g(Observable<T> observable) {
        Intrinsics.f(observable, "<this>");
        Observable<T> observeOn = observable.subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a());
        Intrinsics.e(observeOn, "subscribeOn(Schedulers.i…dSchedulers.mainThread())");
        return observeOn;
    }

    public static final <T> Observable<T> h(Observable<Optional<T>> observable) {
        Intrinsics.f(observable, "<this>");
        final ObservableExtKt$exposeOptional$1 observableExtKt$exposeOptional$1 = new Function1<Optional<T>, Boolean>() { // from class: ee.mtakso.driver.utils.ObservableExtKt$exposeOptional$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Optional<T> it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(!it.d());
            }
        };
        Observable<Optional<T>> filter = observable.filter(new Predicate() { // from class: ee.mtakso.driver.utils.d
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean i8;
                i8 = ObservableExtKt.i(Function1.this, obj);
                return i8;
            }
        });
        final ObservableExtKt$exposeOptional$2 observableExtKt$exposeOptional$2 = new Function1<Optional<T>, T>() { // from class: ee.mtakso.driver.utils.ObservableExtKt$exposeOptional$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final T invoke(Optional<T> it) {
                Intrinsics.f(it, "it");
                return it.b();
            }
        };
        Observable<T> observable2 = (Observable<T>) filter.map(new Function() { // from class: ee.mtakso.driver.utils.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Object j8;
                j8 = ObservableExtKt.j(Function1.this, obj);
                return j8;
            }
        });
        Intrinsics.e(observable2, "filter { !it.isEmpty }\n        .map { it.value }");
        return observable2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return tmp0.invoke(obj);
    }

    public static final <T, R> Observable<R> k(Observable<T> observable, Function1<? super T, ? extends R> function) {
        Intrinsics.f(observable, "<this>");
        Intrinsics.f(function, "function");
        final ObservableExtKt$filMap$1 observableExtKt$filMap$1 = new ObservableExtKt$filMap$1(function);
        Observable<R> map = observable.map(new Function() { // from class: ee.mtakso.driver.utils.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional l8;
                l8 = ObservableExtKt.l(Function1.this, obj);
                return l8;
            }
        });
        final ObservableExtKt$filMap$2 observableExtKt$filMap$2 = new Function1<Optional<R>, Boolean>() { // from class: ee.mtakso.driver.utils.ObservableExtKt$filMap$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Optional<R> it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(!it.d());
            }
        };
        Observable<R> filter = map.filter(new Predicate() { // from class: ee.mtakso.driver.utils.b
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m8;
                m8 = ObservableExtKt.m(Function1.this, obj);
                return m8;
            }
        });
        final ObservableExtKt$filMap$3 observableExtKt$filMap$3 = new Function1<Optional<R>, R>() { // from class: ee.mtakso.driver.utils.ObservableExtKt$filMap$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final R invoke(Optional<R> it) {
                Intrinsics.f(it, "it");
                return it.b();
            }
        };
        Observable<R> map2 = filter.map(new Function() { // from class: ee.mtakso.driver.utils.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Object n8;
                n8 = ObservableExtKt.n(Function1.this, obj);
                return n8;
            }
        });
        Intrinsics.e(map2, "T, R> Observable<T>.filM…        .map { it.value }");
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return tmp0.invoke(obj);
    }
}
