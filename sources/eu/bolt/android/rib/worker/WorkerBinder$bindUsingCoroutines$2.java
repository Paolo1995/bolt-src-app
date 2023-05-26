package eu.bolt.android.rib.worker;

import eu.bolt.logger.StaticLogger;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkerBinder.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class WorkerBinder$bindUsingCoroutines$2 extends AdaptedFunctionReference implements Function2<Throwable, Continuation<? super Unit>, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkerBinder$bindUsingCoroutines$2(Object obj) {
        super(2, obj, StaticLogger.class, "e", "e(Ljava/lang/Throwable;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: c */
    public final Object s(Throwable th, Continuation<? super Unit> continuation) {
        Object k8;
        k8 = WorkerBinder.k((StaticLogger) this.f50976f, th, continuation);
        return k8;
    }
}
