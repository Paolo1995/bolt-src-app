package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Result.kt */
/* loaded from: classes5.dex */
public final class Result<T> implements Serializable {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f50818g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final Object f50819f;

    /* compiled from: Result.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Result.kt */
    /* loaded from: classes5.dex */
    public static final class Failure implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        public final Throwable f50820f;

        public Failure(Throwable exception) {
            Intrinsics.f(exception, "exception");
            this.f50820f = exception;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Failure) && Intrinsics.a(this.f50820f, ((Failure) obj).f50820f)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f50820f.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f50820f + ')';
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.f50819f = obj;
    }

    public static final /* synthetic */ Result a(Object obj) {
        return new Result(obj);
    }

    public static <T> Object b(Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.a(obj, ((Result) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return Intrinsics.a(obj, obj2);
    }

    public static final Throwable e(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).f50820f;
        }
        return null;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean g(Object obj) {
        return obj instanceof Failure;
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof Failure);
    }

    public static String i(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f50819f, obj);
    }

    public int hashCode() {
        return f(this.f50819f);
    }

    public final /* synthetic */ Object j() {
        return this.f50819f;
    }

    public String toString() {
        return i(this.f50819f);
    }
}
