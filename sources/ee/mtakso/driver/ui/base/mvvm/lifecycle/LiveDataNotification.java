package ee.mtakso.driver.ui.base.mvvm.lifecycle;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveDataNotification.kt */
/* loaded from: classes3.dex */
public final class LiveDataNotification<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f26294d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f26295a;

    /* renamed from: b  reason: collision with root package name */
    private Throwable f26296b;

    /* renamed from: c  reason: collision with root package name */
    private T f26297c;

    /* compiled from: LiveDataNotification.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> LiveDataNotification<T> a(Throwable error) {
            Intrinsics.f(error, "error");
            LiveDataNotification<T> liveDataNotification = new LiveDataNotification<>(null);
            liveDataNotification.d(error);
            return liveDataNotification;
        }

        public final <T> LiveDataNotification<T> b() {
            LiveDataNotification<T> liveDataNotification = new LiveDataNotification<>(null);
            liveDataNotification.e(true);
            return liveDataNotification;
        }

        public final <T> LiveDataNotification<T> c(T t7) {
            LiveDataNotification<T> liveDataNotification = new LiveDataNotification<>(null);
            liveDataNotification.f(t7);
            return liveDataNotification;
        }
    }

    private LiveDataNotification() {
    }

    public /* synthetic */ LiveDataNotification(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Throwable a() {
        return this.f26296b;
    }

    public final T b() {
        return this.f26297c;
    }

    public final boolean c() {
        return this.f26295a;
    }

    public final void d(Throwable th) {
        this.f26296b = th;
    }

    public final void e(boolean z7) {
        this.f26295a = z7;
    }

    public final void f(T t7) {
        this.f26297c = t7;
    }

    public String toString() {
        boolean z7 = this.f26295a;
        Throwable th = this.f26296b;
        T t7 = this.f26297c;
        return "State(isLoading=" + z7 + ", error=" + th + ", result=" + t7 + ")";
    }
}
