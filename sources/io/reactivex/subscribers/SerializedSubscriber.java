package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: f  reason: collision with root package name */
    final Subscriber<? super T> f49950f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f49951g;

    /* renamed from: h  reason: collision with root package name */
    Subscription f49952h;

    /* renamed from: i  reason: collision with root package name */
    boolean f49953i;

    /* renamed from: j  reason: collision with root package name */
    AppendOnlyLinkedArrayList<Object> f49954j;

    /* renamed from: k  reason: collision with root package name */
    volatile boolean f49955k;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f49954j;
                if (appendOnlyLinkedArrayList == null) {
                    this.f49953i = false;
                    return;
                }
                this.f49954j = null;
            }
        } while (!appendOnlyLinkedArrayList.b((Subscriber<? super T>) this.f49950f));
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void c(Subscription subscription) {
        if (SubscriptionHelper.p(this.f49952h, subscription)) {
            this.f49952h = subscription;
            this.f49950f.c(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f49952h.cancel();
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        this.f49952h.f(j8);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f49955k) {
            return;
        }
        synchronized (this) {
            if (this.f49955k) {
                return;
            }
            if (this.f49953i) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49954j;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f49954j = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.f());
                return;
            }
            this.f49955k = true;
            this.f49953i = true;
            this.f49950f.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f49955k) {
            RxJavaPlugins.s(th);
            return;
        }
        synchronized (this) {
            boolean z7 = true;
            if (!this.f49955k) {
                if (this.f49953i) {
                    this.f49955k = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49954j;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.f49954j = appendOnlyLinkedArrayList;
                    }
                    Object j8 = NotificationLite.j(th);
                    if (this.f49951g) {
                        appendOnlyLinkedArrayList.c(j8);
                    } else {
                        appendOnlyLinkedArrayList.e(j8);
                    }
                    return;
                }
                this.f49955k = true;
                this.f49953i = true;
                z7 = false;
            }
            if (z7) {
                RxJavaPlugins.s(th);
            } else {
                this.f49950f.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t7) {
        if (this.f49955k) {
            return;
        }
        if (t7 == null) {
            this.f49952h.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f49955k) {
                return;
            }
            if (this.f49953i) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49954j;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f49954j = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.q(t7));
                return;
            }
            this.f49953i = true;
            this.f49950f.onNext(t7);
            a();
        }
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z7) {
        this.f49950f = subscriber;
        this.f49951g = z7;
    }
}
