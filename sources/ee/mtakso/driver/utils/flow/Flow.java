package ee.mtakso.driver.utils.flow;

import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.flow.Flow;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Flow.kt */
/* loaded from: classes5.dex */
public abstract class Flow<T> {

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorSubject<T> f36428a;

    /* renamed from: b  reason: collision with root package name */
    private final Observable<T> f36429b;

    /* renamed from: c  reason: collision with root package name */
    private Disposable f36430c;

    public Flow() {
        BehaviorSubject<T> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<T>()");
        this.f36428a = e8;
        this.f36429b = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T e(Throwable th);

    public final void f() {
        Disposable disposable = this.f36430c;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(T item) {
        Intrinsics.f(item, "item");
        this.f36428a.onNext(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(Observable<T> observable) {
        Intrinsics.f(observable, "<this>");
        Observable<T> observeOn = observable.observeOn(AndroidSchedulers.a());
        final Function1<T, Unit> function1 = new Function1<T, Unit>(this) { // from class: ee.mtakso.driver.utils.flow.Flow$execute$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Flow<T> f36431f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f36431f = this;
            }

            public final void b(T t7) {
                this.f36431f.l().onNext(t7);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b(obj);
                return Unit.f50853a;
            }
        };
        Consumer<? super T> consumer = new Consumer() { // from class: a6.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Flow.i(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>(this) { // from class: ee.mtakso.driver.utils.flow.Flow$execute$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Flow<T> f36432f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f36432f = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                this.f36432f.l().onError(th);
            }
        };
        this.f36430c = observeOn.subscribe(consumer, new Consumer() { // from class: a6.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Flow.j(Function1.this, obj);
            }
        });
    }

    public final Observable<T> k() {
        return this.f36429b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BehaviorSubject<T> l() {
        return this.f36428a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract FlowStep<T> m(T t7);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Observable<T> n(FlowStep<T> step) {
        Intrinsics.f(step, "step");
        Observable<T> call = step.call();
        final Function1<Throwable, T> function1 = new Function1<Throwable, T>(this) { // from class: ee.mtakso.driver.utils.flow.Flow$runStep$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Flow<T> f36433f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f36433f = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final T invoke(Throwable it) {
                Intrinsics.f(it, "it");
                return this.f36433f.e(it);
            }
        };
        Observable<T> onErrorReturn = call.onErrorReturn(new Function() { // from class: a6.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Object o8;
                o8 = Flow.o(Function1.this, obj);
                return o8;
            }
        });
        final Function1<T, ObservableSource<? extends T>> function12 = new Function1<T, ObservableSource<? extends T>>(this) { // from class: ee.mtakso.driver.utils.flow.Flow$runStep$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Flow<T> f36434f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f36434f = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends T> invoke(T it) {
                Intrinsics.f(it, "it");
                FlowStep<T> m8 = this.f36434f.m(it);
                if (m8 == null) {
                    return Observable.just(it);
                }
                return Observable.just(it).mergeWith(this.f36434f.n(m8));
            }
        };
        Observable<T> observable = (Observable<T>) onErrorReturn.flatMap(new Function() { // from class: a6.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource p8;
                p8 = Flow.p(Function1.this, obj);
                return p8;
            }
        });
        Intrinsics.e(observable, "protected fun runStep(st…    }\n            }\n    }");
        return observable;
    }
}
