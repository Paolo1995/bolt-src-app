package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: NopCollector.kt */
/* loaded from: classes5.dex */
public final class NopCollector implements FlowCollector<Object> {

    /* renamed from: f  reason: collision with root package name */
    public static final NopCollector f51748f = new NopCollector();

    private NopCollector() {
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object b(Object obj, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }
}
