package io.reactivex.processors;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
final class SerializedProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: g  reason: collision with root package name */
    final FlowableProcessor<T> f49870g;

    /* renamed from: h  reason: collision with root package name */
    boolean f49871h;

    /* renamed from: i  reason: collision with root package name */
    AppendOnlyLinkedArrayList<Object> f49872i;

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f49873j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SerializedProcessor(FlowableProcessor<T> flowableProcessor) {
        this.f49870g = flowableProcessor;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f49870g.a(subscriber);
    }

    @Override // org.reactivestreams.Subscriber
    public void c(Subscription subscription) {
        boolean z7 = true;
        if (!this.f49873j) {
            synchronized (this) {
                if (!this.f49873j) {
                    if (this.f49871h) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49872i;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f49872i = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.c(NotificationLite.r(subscription));
                        return;
                    }
                    this.f49871h = true;
                    z7 = false;
                }
            }
        }
        if (z7) {
            subscription.cancel();
            return;
        }
        this.f49870g.c(subscription);
        i0();
    }

    void i0() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f49872i;
                if (appendOnlyLinkedArrayList == null) {
                    this.f49871h = false;
                    return;
                }
                this.f49872i = null;
            }
            appendOnlyLinkedArrayList.b(this.f49870g);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f49873j) {
            return;
        }
        synchronized (this) {
            if (this.f49873j) {
                return;
            }
            this.f49873j = true;
            if (this.f49871h) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49872i;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f49872i = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.f());
                return;
            }
            this.f49871h = true;
            this.f49870g.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f49873j) {
            RxJavaPlugins.s(th);
            return;
        }
        synchronized (this) {
            boolean z7 = true;
            if (!this.f49873j) {
                this.f49873j = true;
                if (this.f49871h) {
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49872i;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.f49872i = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.e(NotificationLite.j(th));
                    return;
                }
                this.f49871h = true;
                z7 = false;
            }
            if (z7) {
                RxJavaPlugins.s(th);
            } else {
                this.f49870g.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t7) {
        if (this.f49873j) {
            return;
        }
        synchronized (this) {
            if (this.f49873j) {
                return;
            }
            if (this.f49871h) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49872i;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f49872i = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.q(t7));
                return;
            }
            this.f49871h = true;
            this.f49870g.onNext(t7);
            i0();
        }
    }
}
