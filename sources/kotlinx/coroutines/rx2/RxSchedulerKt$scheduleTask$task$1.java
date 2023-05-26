package kotlinx.coroutines.rx2;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxScheduler.kt */
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxSchedulerKt", f = "RxScheduler.kt", l = {126}, m = "scheduleTask$task")
/* loaded from: classes5.dex */
public final class RxSchedulerKt$scheduleTask$task$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51914f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f51915g;

    /* renamed from: h  reason: collision with root package name */
    int f51916h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxSchedulerKt$scheduleTask$task$1(Continuation<? super RxSchedulerKt$scheduleTask$task$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g8;
        this.f51915g = obj;
        this.f51916h |= Integer.MIN_VALUE;
        g8 = RxSchedulerKt.g(null, null, null, this);
        return g8;
    }
}
