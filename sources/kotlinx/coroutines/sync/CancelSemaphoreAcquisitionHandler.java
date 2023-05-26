package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlinx.coroutines.CancelHandler;

/* compiled from: Semaphore.kt */
/* loaded from: classes5.dex */
final class CancelSemaphoreAcquisitionHandler extends CancelHandler {

    /* renamed from: f  reason: collision with root package name */
    private final SemaphoreSegment f51995f;

    /* renamed from: g  reason: collision with root package name */
    private final int f51996g;

    public CancelSemaphoreAcquisitionHandler(SemaphoreSegment semaphoreSegment, int i8) {
        this.f51995f = semaphoreSegment;
        this.f51996g = i8;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void b(Throwable th) {
        this.f51995f.q(this.f51996g);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        b(th);
        return Unit.f50853a;
    }

    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.f51995f + ", " + this.f51996g + ']';
    }
}
