package eu.bolt.android.rib.worker;

import eu.bolt.logger.StaticLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkerBinder.kt */
/* loaded from: classes5.dex */
/* synthetic */ class WorkerBinder$bindUsingRx$2 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkerBinder$bindUsingRx$2(Object obj) {
        super(1, obj, StaticLogger.class, "e", "e(Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        j(th);
        return Unit.f50853a;
    }

    public final void j(Throwable p02) {
        Intrinsics.f(p02, "p0");
        ((StaticLogger) this.f50989g).c(p02);
    }
}
