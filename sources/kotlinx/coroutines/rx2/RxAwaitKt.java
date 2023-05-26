package kotlinx.coroutines.rx2;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: RxAwait.kt */
/* loaded from: classes5.dex */
public final class RxAwaitKt {
    public static final Object a(CompletableSource completableSource, Continuation<? super Unit> continuation) {
        Continuation c8;
        Object d8;
        Object d9;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        completableSource.a(new CompletableObserver() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$await$2$1
            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f50818g;
                cancellableContinuation.resumeWith(Result.b(Unit.f50853a));
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f50818g;
                cancellableContinuation.resumeWith(Result.b(ResultKt.a(th)));
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                RxAwaitKt.f(cancellableContinuationImpl, disposable);
            }
        });
        Object v7 = cancellableContinuationImpl.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d9) {
            return v7;
        }
        return Unit.f50853a;
    }

    public static final <T> Object b(SingleSource<T> singleSource, Continuation<? super T> continuation) {
        Continuation c8;
        Object d8;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        singleSource.a(new SingleObserver<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$await$5$1
            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f50818g;
                cancellableContinuation.resumeWith(Result.b(ResultKt.a(th)));
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                RxAwaitKt.f(cancellableContinuationImpl, disposable);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
            public void onSuccess(T t7) {
                cancellableContinuationImpl.resumeWith(Result.b(t7));
            }
        });
        Object v7 = cancellableContinuationImpl.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        return v7;
    }

    public static final <T> Object c(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return e(observableSource, Mode.FIRST, null, continuation, 2, null);
    }

    private static final <T> Object d(ObservableSource<T> observableSource, final Mode mode, final T t7, Continuation<? super T> continuation) {
        Continuation c8;
        Object d8;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        observableSource.subscribe(new Observer<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitOne$2$1

            /* renamed from: f  reason: collision with root package name */
            private Disposable f51892f;

            /* renamed from: g  reason: collision with root package name */
            private T f51893g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f51894h;

            /* compiled from: RxAwait.kt */
            /* loaded from: classes5.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f51898a;

                static {
                    int[] iArr = new int[Mode.values().length];
                    iArr[Mode.FIRST.ordinal()] = 1;
                    iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
                    iArr[Mode.LAST.ordinal()] = 3;
                    iArr[Mode.SINGLE.ordinal()] = 4;
                    f51898a = iArr;
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.f51894h) {
                    if (cancellableContinuationImpl.isActive()) {
                        CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.f50818g;
                        cancellableContinuation.resumeWith(Result.b(this.f51893g));
                    }
                } else if (mode == Mode.FIRST_OR_DEFAULT) {
                    CancellableContinuation<T> cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.f50818g;
                    cancellableContinuation2.resumeWith(Result.b(t7));
                } else if (cancellableContinuationImpl.isActive()) {
                    CancellableContinuation<T> cancellableContinuation3 = cancellableContinuationImpl;
                    Result.Companion companion3 = Result.f50818g;
                    cancellableContinuation3.resumeWith(Result.b(ResultKt.a(new NoSuchElementException("No value received via onNext for " + mode))));
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f50818g;
                cancellableContinuation.resumeWith(Result.b(ResultKt.a(th)));
            }

            @Override // io.reactivex.Observer
            public void onNext(T t8) {
                int i8 = WhenMappings.f51898a[mode.ordinal()];
                Disposable disposable = null;
                if (i8 != 1 && i8 != 2) {
                    if (i8 == 3 || i8 == 4) {
                        if (mode == Mode.SINGLE && this.f51894h) {
                            if (cancellableContinuationImpl.isActive()) {
                                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                                Result.Companion companion = Result.f50818g;
                                cancellableContinuation.resumeWith(Result.b(ResultKt.a(new IllegalArgumentException("More than one onNext value for " + mode))));
                            }
                            Disposable disposable2 = this.f51892f;
                            if (disposable2 == null) {
                                Intrinsics.w("subscription");
                            } else {
                                disposable = disposable2;
                            }
                            disposable.dispose();
                            return;
                        }
                        this.f51893g = t8;
                        this.f51894h = true;
                    }
                } else if (!this.f51894h) {
                    this.f51894h = true;
                    cancellableContinuationImpl.resumeWith(Result.b(t8));
                    Disposable disposable3 = this.f51892f;
                    if (disposable3 == null) {
                        Intrinsics.w("subscription");
                    } else {
                        disposable = disposable3;
                    }
                    disposable.dispose();
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(final Disposable disposable) {
                this.f51892f = disposable;
                cancellableContinuationImpl.o(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitOne$2$1$onSubscribe$1
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
                        Disposable.this.dispose();
                    }
                });
            }
        });
        Object v7 = cancellableContinuationImpl.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        return v7;
    }

    static /* synthetic */ Object e(ObservableSource observableSource, Mode mode, Object obj, Continuation continuation, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            obj = null;
        }
        return d(observableSource, mode, obj, continuation);
    }

    public static final void f(CancellableContinuation<?> cancellableContinuation, final Disposable disposable) {
        cancellableContinuation.o(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$disposeOnCancellation$1
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
                Disposable.this.dispose();
            }
        });
    }
}
