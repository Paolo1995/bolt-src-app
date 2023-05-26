package kotlinx.coroutines.reactive;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.Flow;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReactiveFlow.kt */
/* loaded from: classes5.dex */
public final class FlowAsPublisher<T> implements Publisher<T> {

    /* renamed from: f  reason: collision with root package name */
    private final Flow<T> f51849f;

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineContext f51850g;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowAsPublisher(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        this.f51849f = flow;
        this.f51850g = coroutineContext;
    }

    @Override // org.reactivestreams.Publisher
    public void a(Subscriber<? super T> subscriber) {
        subscriber.getClass();
        subscriber.c(new FlowSubscription(this.f51849f, subscriber, this.f51850g));
    }
}
