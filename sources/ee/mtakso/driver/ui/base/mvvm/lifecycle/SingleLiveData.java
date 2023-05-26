package ee.mtakso.driver.ui.base.mvvm.lifecycle;

import androidx.lifecycle.LiveData;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingleLiveData.kt */
/* loaded from: classes3.dex */
public class SingleLiveData<T> extends LiveData<T> implements Disposable {

    /* renamed from: q  reason: collision with root package name */
    private Disposable f26303q;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Disposable disposable = this.f26303q;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Disposable disposable = this.f26303q;
        if (disposable != null) {
            return disposable.isDisposed();
        }
        return false;
    }

    public final boolean s() {
        if (this.f26303q != null) {
            return true;
        }
        return false;
    }

    public final void t(Single<T> source, final Function1<? super Throwable, Unit> errorHandler) {
        Intrinsics.f(source, "source");
        Intrinsics.f(errorHandler, "errorHandler");
        if (!s()) {
            final Function1<T, Unit> function1 = new Function1<T, Unit>(this) { // from class: ee.mtakso.driver.ui.base.mvvm.lifecycle.SingleLiveData$subscribe$1

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ SingleLiveData<T> f26304f;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.f26304f = this;
                }

                public final void b(T t7) {
                    this.f26304f.m(t7);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    b(obj);
                    return Unit.f50853a;
                }
            };
            Consumer<? super T> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.base.mvvm.lifecycle.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SingleLiveData.u(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.base.mvvm.lifecycle.SingleLiveData$subscribe$2
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
            this.f26303q = source.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.base.mvvm.lifecycle.d
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SingleLiveData.v(Function1.this, obj);
                }
            });
            return;
        }
        throw new IllegalStateException("SingleLiveData already subscribed".toString());
    }
}
