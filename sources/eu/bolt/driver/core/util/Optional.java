package eu.bolt.driver.core.util;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Optional.kt */
/* loaded from: classes5.dex */
public final class Optional<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f41306b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final T f41307a;

    /* compiled from: Optional.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> Optional<T> a() {
            return new Optional<>(null, null);
        }

        public final <T> Optional<T> b(T t7) {
            return new Optional<>(t7, null);
        }
    }

    private Optional(T t7) {
        this.f41307a = t7;
    }

    public /* synthetic */ Optional(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    public final T a() {
        T t7 = this.f41307a;
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException("value == null");
    }

    public final T b() {
        return this.f41307a;
    }

    public final boolean c() {
        if (this.f41307a == null) {
            return true;
        }
        return false;
    }
}
