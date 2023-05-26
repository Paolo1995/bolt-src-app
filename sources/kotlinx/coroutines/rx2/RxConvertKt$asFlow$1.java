package kotlinx.coroutines.rx2;

import androidx.camera.view.e;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: RxConvert.kt */
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asFlow$1", f = "RxConvert.kt", l = {95}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class RxConvertKt$asFlow$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f51903g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f51904h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ObservableSource<T> f51905i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asFlow$1(ObservableSource<T> observableSource, Continuation<? super RxConvertKt$asFlow$1> continuation) {
        super(2, continuation);
        this.f51905i = observableSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxConvertKt$asFlow$1 rxConvertKt$asFlow$1 = new RxConvertKt$asFlow$1(this.f51905i, continuation);
        rxConvertKt$asFlow$1.f51904h = obj;
        return rxConvertKt$asFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f51903g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f51904h;
            final AtomicReference atomicReference = new AtomicReference();
            this.f51905i.subscribe(new Observer<T>() { // from class: kotlinx.coroutines.rx2.RxConvertKt$asFlow$1$observer$1
                @Override // io.reactivex.Observer
                public void onComplete() {
                    SendChannel.DefaultImpls.a(producerScope, null, 1, null);
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    producerScope.b(th);
                }

                @Override // io.reactivex.Observer
                public void onNext(T t7) {
                    try {
                        ChannelsKt.b(producerScope, t7);
                    } catch (InterruptedException unused) {
                    }
                }

                @Override // io.reactivex.Observer
                public void onSubscribe(Disposable disposable) {
                    if (!e.a(atomicReference, null, disposable)) {
                        disposable.dispose();
                    }
                }
            });
            Function0<Unit> function0 = new Function0<Unit>() { // from class: kotlinx.coroutines.rx2.RxConvertKt$asFlow$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final void b() {
                    Disposable andSet = atomicReference.getAndSet(Disposables.a());
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            };
            this.f51903g = 1;
            if (ProduceKt.a(producerScope, function0, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
