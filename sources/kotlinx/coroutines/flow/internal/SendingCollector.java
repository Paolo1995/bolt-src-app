package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SendingCollector.kt */
/* loaded from: classes5.dex */
public final class SendingCollector<T> implements FlowCollector<T> {

    /* renamed from: f  reason: collision with root package name */
    private final SendChannel<T> f51761f;

    /* JADX WARN: Multi-variable type inference failed */
    public SendingCollector(SendChannel<? super T> sendChannel) {
        this.f51761f = sendChannel;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object b(T t7, Continuation<? super Unit> continuation) {
        Object d8;
        Object D = this.f51761f.D(t7, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (D == d8) {
            return D;
        }
        return Unit.f50853a;
    }
}
