package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Flowable<T> f48076f;

    /* renamed from: g  reason: collision with root package name */
    final T f48077g;

    /* loaded from: classes5.dex */
    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f48078f;

        /* renamed from: g  reason: collision with root package name */
        final T f48079g;

        /* renamed from: h  reason: collision with root package name */
        Subscription f48080h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48081i;

        /* renamed from: j  reason: collision with root package name */
        T f48082j;

        SingleElementSubscriber(SingleObserver<? super T> singleObserver, T t7) {
            this.f48078f = singleObserver;
            this.f48079g = t7;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48080h, subscription)) {
                this.f48080h = subscription;
                this.f48078f.onSubscribe(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48080h.cancel();
            this.f48080h = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f48080h == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f48081i) {
                return;
            }
            this.f48081i = true;
            this.f48080h = SubscriptionHelper.CANCELLED;
            T t7 = this.f48082j;
            this.f48082j = null;
            if (t7 == null) {
                t7 = this.f48079g;
            }
            if (t7 != null) {
                this.f48078f.onSuccess(t7);
            } else {
                this.f48078f.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f48081i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48081i = true;
            this.f48080h = SubscriptionHelper.CANCELLED;
            this.f48078f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f48081i) {
                return;
            }
            if (this.f48082j != null) {
                this.f48081i = true;
                this.f48080h.cancel();
                this.f48080h = SubscriptionHelper.CANCELLED;
                this.f48078f.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f48082j = t7;
        }
    }

    public FlowableSingleSingle(Flowable<T> flowable, T t7) {
        this.f48076f = flowable;
        this.f48077g = t7;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f48076f.Y(new SingleElementSubscriber(singleObserver, this.f48077g));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> c() {
        return RxJavaPlugins.l(new FlowableSingle(this.f48076f, this.f48077g, true));
    }
}
