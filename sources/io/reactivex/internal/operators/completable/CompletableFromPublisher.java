package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class CompletableFromPublisher<T> extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final Publisher<T> f47744f;

    /* loaded from: classes5.dex */
    static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47745f;

        /* renamed from: g  reason: collision with root package name */
        Subscription f47746g;

        FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.f47745f = completableObserver;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f47746g, subscription)) {
                this.f47746g = subscription;
                this.f47745f.onSubscribe(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47746g.cancel();
            this.f47746g = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f47746g == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f47745f.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f47745f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
        }
    }

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.f47744f = publisher;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f47744f.a(new FromPublisherSubscriber(completableObserver));
    }
}
