package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {

    /* renamed from: f  reason: collision with root package name */
    protected final Subscriber<? super R> f49764f;

    /* renamed from: g  reason: collision with root package name */
    protected Subscription f49765g;

    /* renamed from: h  reason: collision with root package name */
    protected QueueSubscription<T> f49766h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f49767i;

    /* renamed from: j  reason: collision with root package name */
    protected int f49768j;

    public BasicFuseableSubscriber(Subscriber<? super R> subscriber) {
        this.f49764f = subscriber;
    }

    protected void b() {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void c(Subscription subscription) {
        if (SubscriptionHelper.p(this.f49765g, subscription)) {
            this.f49765g = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f49766h = (QueueSubscription) subscription;
            }
            if (d()) {
                this.f49764f.c(this);
                b();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f49765g.cancel();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.f49766h.clear();
    }

    protected boolean d() {
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        this.f49765g.f(j8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(Throwable th) {
        Exceptions.b(th);
        this.f49765g.cancel();
        onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int i(int i8) {
        QueueSubscription<T> queueSubscription = this.f49766h;
        if (queueSubscription != null && (i8 & 4) == 0) {
            int a8 = queueSubscription.a(i8);
            if (a8 != 0) {
                this.f49768j = a8;
            }
            return a8;
        }
        return 0;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.f49766h.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r7) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f49767i) {
            return;
        }
        this.f49767i = true;
        this.f49764f.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f49767i) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f49767i = true;
        this.f49764f.onError(th);
    }
}
