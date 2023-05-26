package io.reactivex.internal.subscriptions;

import androidx.camera.view.e;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    public static boolean a(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription != subscriptionHelper && (andSet = atomicReference.getAndSet(subscriptionHelper)) != subscriptionHelper) {
            if (andSet != null) {
                andSet.cancel();
                return true;
            }
            return true;
        }
        return false;
    }

    public static void c(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j8) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.f(j8);
        } else if (m(j8)) {
            BackpressureHelper.a(atomicLong, j8);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription2.f(andSet);
                }
            }
        }
    }

    public static boolean e(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (k(atomicReference, subscription)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                subscription.f(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    public static void h(long j8) {
        RxJavaPlugins.s(new ProtocolViolationException("More produced than requested: " + j8));
    }

    public static void j() {
        RxJavaPlugins.s(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean k(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        ObjectHelper.e(subscription, "s is null");
        if (!e.a(atomicReference, null, subscription)) {
            subscription.cancel();
            if (atomicReference.get() != CANCELLED) {
                j();
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean l(AtomicReference<Subscription> atomicReference, Subscription subscription, long j8) {
        if (k(atomicReference, subscription)) {
            subscription.f(j8);
            return true;
        }
        return false;
    }

    public static boolean m(long j8) {
        if (j8 <= 0) {
            RxJavaPlugins.s(new IllegalArgumentException("n > 0 required but it was " + j8));
            return false;
        }
        return true;
    }

    public static boolean p(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.s(new NullPointerException("next is null"));
            return false;
        } else if (subscription != null) {
            subscription2.cancel();
            j();
            return false;
        } else {
            return true;
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
    }
}
