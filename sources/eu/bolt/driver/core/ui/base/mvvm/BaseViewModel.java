package eu.bolt.driver.core.ui.base.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import eu.bolt.driver.core.ui.base.mvvm.BaseViewModel;
import eu.bolt.driver.core.ui.common.lifecycle.LiveEvent;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseViewModel.kt */
/* loaded from: classes5.dex */
public abstract class BaseViewModel extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private boolean f41046a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f41047b;

    /* renamed from: c  reason: collision with root package name */
    private final LiveEvent<Throwable> f41048c = new LiveEvent<>();

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<Boolean> f41049d = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private final CompositeDisposable f41050e = new CompositeDisposable();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void m(BaseViewModel baseViewModel, Throwable th, String str, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 2) != 0) {
                str = "Error handled with UI";
            }
            baseViewModel.l(th, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleError");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> Single<T> d(Single<T> single) {
        Intrinsics.f(single, "<this>");
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: eu.bolt.driver.core.ui.base.mvvm.BaseViewModel$applyProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                BaseViewModel.this.k().m(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single<T> n8 = single.n(new Consumer() { // from class: e7.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.e(Function1.this, obj);
            }
        });
        final Function1<T, Unit> function12 = new Function1<T, Unit>() { // from class: eu.bolt.driver.core.ui.base.mvvm.BaseViewModel$applyProgress$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(T t7) {
                BaseViewModel.this.k().m(Boolean.FALSE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b(obj);
                return Unit.f50853a;
            }
        };
        Single<T> o8 = n8.o(new Consumer() { // from class: e7.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.f(Function1.this, obj);
            }
        });
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: eu.bolt.driver.core.ui.base.mvvm.BaseViewModel$applyProgress$3
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
                BaseViewModel.this.k().m(Boolean.FALSE);
            }
        };
        Single<T> l8 = o8.l(new Consumer() { // from class: e7.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseViewModel.g(Function1.this, obj);
            }
        });
        Intrinsics.e(l8, "protected fun <T> Single…ssData.postValue(false) }");
        return l8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(Disposable disposable) {
        Intrinsics.f(disposable, "<this>");
        Kalev.b("Autodispose called");
        if (this.f41047b) {
            m(this, new IllegalStateException("AutoDispose invoked on cleared view model"), null, 2, null);
        }
        this.f41050e.b(disposable);
    }

    public final LiveData<Throwable> i() {
        return this.f41048c;
    }

    public final LiveData<Boolean> j() {
        return this.f41049d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<Boolean> k() {
        return this.f41049d;
    }

    public final void l(Throwable error, String message) {
        Intrinsics.f(error, "error");
        Intrinsics.f(message, "message");
        Kalev.e(error, message);
        this.f41048c.m(error);
    }

    public abstract void n();

    public final void o() {
        if (this.f41046a) {
            return;
        }
        this.f41046a = true;
        this.f41047b = false;
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f41047b = true;
        this.f41050e.dispose();
    }
}
