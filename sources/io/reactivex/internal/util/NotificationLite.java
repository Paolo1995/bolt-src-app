package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public enum NotificationLite {
    COMPLETE;

    /* loaded from: classes5.dex */
    static final class DisposableNotification implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        final Disposable f49813f;

        DisposableNotification(Disposable disposable) {
            this.f49813f = disposable;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f49813f + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ErrorNotification implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        final Throwable f49814f;

        ErrorNotification(Throwable th) {
            this.f49814f = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return ObjectHelper.c(this.f49814f, ((ErrorNotification) obj).f49814f);
            }
            return false;
        }

        public int hashCode() {
            return this.f49814f.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f49814f + "]";
        }
    }

    /* loaded from: classes5.dex */
    static final class SubscriptionNotification implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        final Subscription f49815f;

        SubscriptionNotification(Subscription subscription) {
            this.f49815f = subscription;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f49815f + "]";
        }
    }

    public static <T> boolean a(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f49814f);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean c(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f49814f);
            return true;
        } else if (obj instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification) obj).f49813f);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean e(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f49814f);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            subscriber.c(((SubscriptionNotification) obj).f49815f);
            return false;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static Object f() {
        return COMPLETE;
    }

    public static Object h(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static Object j(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Throwable k(Object obj) {
        return ((ErrorNotification) obj).f49814f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T l(Object obj) {
        return obj;
    }

    public static boolean m(Object obj) {
        if (obj == COMPLETE) {
            return true;
        }
        return false;
    }

    public static boolean p(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static <T> Object q(T t7) {
        return t7;
    }

    public static Object r(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
