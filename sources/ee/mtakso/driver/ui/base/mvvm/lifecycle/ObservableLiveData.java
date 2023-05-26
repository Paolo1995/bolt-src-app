package ee.mtakso.driver.ui.base.mvvm.lifecycle;

import androidx.lifecycle.LiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObservableLiveData.kt */
/* loaded from: classes3.dex */
public final class ObservableLiveData<T> extends LiveData<T> implements Disposable {

    /* renamed from: q */
    private Disposable f26298q;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void t(ObservableLiveData observableLiveData, Observable observable, Function1 function1, Function1 function12, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            function1 = new Function1<T, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData$subscribe$1
                public final void b(T t7) {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                    b(obj2);
                    return Unit.f50853a;
                }
            };
        }
        observableLiveData.s(observable, function1, function12);
    }

    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Disposable disposable = this.f26298q;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Disposable disposable = this.f26298q;
        if (disposable != null) {
            return disposable.isDisposed();
        }
        return false;
    }

    public final void s(Observable<T> source, final Function1<? super T, Unit> valueHandler, final Function1<? super Throwable, Unit> errorHandler) {
        Intrinsics.f(source, "source");
        Intrinsics.f(valueHandler, "valueHandler");
        Intrinsics.f(errorHandler, "errorHandler");
        if (this.f26298q == null) {
            final Function1<T, Unit> function1 = new Function1<T, Unit>(this) { // from class: ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData$subscribe$2

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ ObservableLiveData<T> f26300f;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.f26300f = this;
                }

                public final void b(T t7) {
                    this.f26300f.m(t7);
                    valueHandler.invoke(t7);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    b(obj);
                    return Unit.f50853a;
                }
            };
            Consumer<? super T> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.base.mvvm.lifecycle.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ObservableLiveData.u(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData$subscribe$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Function1<Throwable, Unit> function13 = errorHandler;
                    Intrinsics.e(it, "it");
                    function13.invoke(it);
                }
            };
            this.f26298q = source.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.base.mvvm.lifecycle.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ObservableLiveData.v(Function1.this, obj);
                }
            });
            return;
        }
        throw new IllegalStateException("ObservableLiveData already subscribed");
    }
}
