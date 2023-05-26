package ee.mtakso.driver.ui.base.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseViewModel.kt */
/* loaded from: classes3.dex */
public abstract class BaseViewModel extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26267a;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26270d;

    /* renamed from: b  reason: collision with root package name */
    private final LiveEvent<Throwable> f26268b = new LiveEvent<>();

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Boolean> f26269c = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private final CompositeDisposable f26271e = new CompositeDisposable();

    public static /* synthetic */ void A(BaseViewModel baseViewModel, Throwable th, String str, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 2) != 0) {
                str = "Error handled with UI";
            }
            baseViewModel.z(th, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleError");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(BaseViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f26269c.m(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public abstract void B();

    public final void C() {
        if (this.f26267a) {
            return;
        }
        this.f26267a = true;
        this.f26270d = false;
        B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Completable j(Completable completable) {
        Intrinsics.f(completable, "<this>");
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.BaseViewModel$applyProgress$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                BaseViewModel.this.y().m(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Completable n8 = completable.r(new Consumer() { // from class: l2.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.s(Function1.this, obj);
            }
        }).n(new Action() { // from class: l2.m
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseViewModel.t(BaseViewModel.this);
            }
        });
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.BaseViewModel$applyProgress$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BaseViewModel.this.y().m(Boolean.FALSE);
            }
        };
        Completable p8 = n8.p(new Consumer() { // from class: l2.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.u(Function1.this, obj);
            }
        });
        Intrinsics.e(p8, "protected fun Completabl…ssData.postValue(false) }");
        return p8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> Observable<T> k(Observable<T> observable) {
        Intrinsics.f(observable, "<this>");
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.BaseViewModel$applyProgress$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                BaseViewModel.this.y().m(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Observable<T> doOnSubscribe = observable.doOnSubscribe(new Consumer() { // from class: l2.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.p(Function1.this, obj);
            }
        });
        final Function1<T, Unit> function12 = new Function1<T, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.BaseViewModel$applyProgress$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(T t7) {
                BaseViewModel.this.y().m(Boolean.FALSE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b(obj);
                return Unit.f50853a;
            }
        };
        Observable<T> doOnNext = doOnSubscribe.doOnNext(new Consumer() { // from class: l2.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.q(Function1.this, obj);
            }
        });
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.BaseViewModel$applyProgress$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BaseViewModel.this.y().m(Boolean.FALSE);
            }
        };
        Observable<T> doOnError = doOnNext.doOnError(new Consumer() { // from class: l2.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.r(Function1.this, obj);
            }
        });
        Intrinsics.e(doOnError, "protected fun <T> Observ…ssData.postValue(false) }");
        return doOnError;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> Single<T> l(Single<T> single) {
        Intrinsics.f(single, "<this>");
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.BaseViewModel$applyProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                BaseViewModel.this.y().m(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single<T> n8 = single.n(new Consumer() { // from class: l2.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.m(Function1.this, obj);
            }
        });
        final Function1<T, Unit> function12 = new Function1<T, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.BaseViewModel$applyProgress$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(T t7) {
                BaseViewModel.this.y().m(Boolean.FALSE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b(obj);
                return Unit.f50853a;
            }
        };
        Single<T> o8 = n8.o(new Consumer() { // from class: l2.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.n(Function1.this, obj);
            }
        });
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.BaseViewModel$applyProgress$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BaseViewModel.this.y().m(Boolean.FALSE);
            }
        };
        Single<T> l8 = o8.l(new Consumer() { // from class: l2.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.o(Function1.this, obj);
            }
        });
        Intrinsics.e(l8, "protected fun <T> Single…ssData.postValue(false) }");
        return l8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f26270d = true;
        this.f26271e.dispose();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void v(Disposable disposable) {
        Intrinsics.f(disposable, "<this>");
        if (this.f26270d) {
            A(this, new IllegalStateException("AutoDispose invoked on cleared view model"), null, 2, null);
        }
        this.f26271e.b(disposable);
    }

    public final LiveData<Throwable> w() {
        return this.f26268b;
    }

    public final LiveData<Boolean> x() {
        return this.f26269c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<Boolean> y() {
        return this.f26269c;
    }

    public final void z(Throwable error, String message) {
        Intrinsics.f(error, "error");
        Intrinsics.f(message, "message");
        Kalev.e(error, message);
        this.f26268b.m(error);
    }
}
