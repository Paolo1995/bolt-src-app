package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public abstract class BasicFuseableConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, QueueSubscription<R> {

    /* renamed from: f  reason: collision with root package name */
    protected final ConditionalSubscriber<? super R> f49759f;

    /* renamed from: g  reason: collision with root package name */
    protected Subscription f49760g;

    /* renamed from: h  reason: collision with root package name */
    protected QueueSubscription<T> f49761h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f49762i;

    /* renamed from: j  reason: collision with root package name */
    protected int f49763j;

    public BasicFuseableConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber) {
        this.f49759f = conditionalSubscriber;
    }

    protected void b() {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void c(Subscription subscription) {
        if (SubscriptionHelper.p(this.f49760g, subscription)) {
            this.f49760g = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f49761h = (QueueSubscription) subscription;
            }
            if (d()) {
                this.f49759f.c(this);
                b();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f49760g.cancel();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.f49761h.clear();
    }

    protected boolean d() {
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        this.f49760g.f(j8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(Throwable th) {
        Exceptions.b(th);
        this.f49760g.cancel();
        onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int i(int i8) {
        QueueSubscription<T> queueSubscription = this.f49761h;
        if (queueSubscription != null && (i8 & 4) == 0) {
            int a8 = queueSubscription.a(i8);
            if (a8 != 0) {
                this.f49763j = a8;
            }
            return a8;
        }
        return 0;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.f49761h.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r7) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f49762i) {
            return;
        }
        this.f49762i = true;
        this.f49759f.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f49762i) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f49762i = true;
        this.f49759f.onError(th);
    }
}
