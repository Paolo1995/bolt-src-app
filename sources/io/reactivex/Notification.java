package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

/* loaded from: classes5.dex */
public final class Notification<T> {

    /* renamed from: b  reason: collision with root package name */
    static final Notification<Object> f47570b = new Notification<>(null);

    /* renamed from: a  reason: collision with root package name */
    final Object f47571a;

    private Notification(Object obj) {
        this.f47571a = obj;
    }

    public static <T> Notification<T> a() {
        return (Notification<T>) f47570b;
    }

    public static <T> Notification<T> b(Throwable th) {
        ObjectHelper.e(th, "error is null");
        return new Notification<>(NotificationLite.j(th));
    }

    public static <T> Notification<T> c(T t7) {
        ObjectHelper.e(t7, "value is null");
        return new Notification<>(t7);
    }

    public Throwable d() {
        Object obj = this.f47571a;
        if (NotificationLite.p(obj)) {
            return NotificationLite.k(obj);
        }
        return null;
    }

    public T e() {
        Object obj = this.f47571a;
        if (obj != null && !NotificationLite.p(obj)) {
            return (T) this.f47571a;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.c(this.f47571a, ((Notification) obj).f47571a);
        }
        return false;
    }

    public boolean f() {
        if (this.f47571a == null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return NotificationLite.p(this.f47571a);
    }

    public boolean h() {
        Object obj = this.f47571a;
        if (obj != null && !NotificationLite.p(obj)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f47571a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f47571a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.p(obj)) {
            return "OnErrorNotification[" + NotificationLite.k(obj) + "]";
        }
        return "OnNextNotification[" + this.f47571a + "]";
    }
}
