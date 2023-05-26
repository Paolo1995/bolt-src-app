package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Builders.kt */
/* loaded from: classes5.dex */
final class EmptyFlow implements Flow {

    /* renamed from: f  reason: collision with root package name */
    public static final EmptyFlow f51448f = new EmptyFlow();

    private EmptyFlow() {
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<?> flowCollector, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }
}
