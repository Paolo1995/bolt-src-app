package kotlinx.coroutines.rx2;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxScheduler.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class RxSchedulerKt$scheduleTask$toSchedule$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: o  reason: collision with root package name */
    final /* synthetic */ Disposable f51918o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ CoroutineContext f51919p;

    /* renamed from: q  reason: collision with root package name */
    final /* synthetic */ Runnable f51920q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxSchedulerKt$scheduleTask$toSchedule$1(Disposable disposable, CoroutineContext coroutineContext, Runnable runnable) {
        super(1, Intrinsics.Kotlin.class, "task", "scheduleTask$task(Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        this.f51918o = disposable;
        this.f51919p = coroutineContext;
        this.f51920q = runnable;
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final Object invoke(Continuation<? super Unit> continuation) {
        Object g8;
        g8 = RxSchedulerKt.g(this.f51918o, this.f51919p, this.f51920q, continuation);
        return g8;
    }
}
