package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class LambdaSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription, Disposable {

    /* renamed from: f  reason: collision with root package name */
    final Consumer<? super T> f49769f;

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super Throwable> f49770g;

    /* renamed from: h  reason: collision with root package name */
    final Action f49771h;

    /* renamed from: i  reason: collision with root package name */
    final Consumer<? super Subscription> f49772i;

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        this.f49769f = consumer;
        this.f49770g = consumer2;
        this.f49771h = action;
        this.f49772i = consumer3;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void c(Subscription subscription) {
        if (SubscriptionHelper.k(this, subscription)) {
            try {
                this.f49772i.accept(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                subscription.cancel();
                onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        cancel();
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        get().f(j8);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f49771h.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f49770g.accept(th);
                return;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.s(new CompositeException(th, th2));
                return;
            }
        }
        RxJavaPlugins.s(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t7) {
        if (!isDisposed()) {
            try {
                this.f49769f.accept(t7);
            } catch (Throwable th) {
                Exceptions.b(th);
                get().cancel();
                onError(th);
            }
        }
    }
}
