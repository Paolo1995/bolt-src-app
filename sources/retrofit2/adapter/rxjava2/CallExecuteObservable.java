package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes4.dex */
final class CallExecuteObservable<T> extends Observable<Response<T>> {
    private final Call<T> originalCall;

    /* loaded from: classes4.dex */
    private static final class CallDisposable implements Disposable {
        private final Call<?> call;
        private volatile boolean disposed;

        CallDisposable(Call<?> call) {
            this.call = call;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Response<T>> observer) {
        boolean z7;
        Call<T> mo152clone = this.originalCall.mo152clone();
        CallDisposable callDisposable = new CallDisposable(mo152clone);
        observer.onSubscribe(callDisposable);
        if (callDisposable.isDisposed()) {
            return;
        }
        try {
            Response<T> execute = mo152clone.execute();
            if (!callDisposable.isDisposed()) {
                observer.onNext(execute);
            }
            if (!callDisposable.isDisposed()) {
                try {
                    observer.onComplete();
                } catch (Throwable th) {
                    th = th;
                    z7 = true;
                    Exceptions.b(th);
                    if (z7) {
                        RxJavaPlugins.s(th);
                    } else if (!callDisposable.isDisposed()) {
                        try {
                            observer.onError(th);
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            RxJavaPlugins.s(new CompositeException(th, th2));
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z7 = false;
        }
    }
}
