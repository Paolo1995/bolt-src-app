package io.reactivex.internal.operators.observable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class ObservableFromPublisher<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Publisher<? extends T> f48708f;

    /* loaded from: classes5.dex */
    static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48709f;

        /* renamed from: g  reason: collision with root package name */
        Subscription f48710g;

        PublisherSubscriber(Observer<? super T> observer) {
            this.f48709f = observer;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48710g, subscription)) {
                this.f48710g = subscription;
                this.f48709f.onSubscribe(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48710g.cancel();
            this.f48710g = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f48710g == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f48709f.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f48709f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            this.f48709f.onNext(t7);
        }
    }

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.f48708f = publisher;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48708f.a(new PublisherSubscriber(observer));
    }
}
