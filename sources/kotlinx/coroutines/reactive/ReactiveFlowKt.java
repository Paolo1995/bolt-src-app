package kotlinx.coroutines.reactive;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import org.reactivestreams.Publisher;

/* compiled from: ReactiveFlow.kt */
/* loaded from: classes5.dex */
public final class ReactiveFlowKt {

    /* renamed from: a  reason: collision with root package name */
    private static final ContextInjector[] f51862a;

    static {
        Sequence c8;
        List D;
        c8 = SequencesKt__SequencesKt.c(ServiceLoader.load(ContextInjector.class, ContextInjector.class.getClassLoader()).iterator());
        D = SequencesKt___SequencesKt.D(c8);
        Object[] array = D.toArray(new ContextInjector[0]);
        if (array != null) {
            f51862a = (ContextInjector[]) array;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final <T> Publisher<T> a(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        return new FlowAsPublisher(flow, Dispatchers.d().s0(coroutineContext));
    }
}
