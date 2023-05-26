package j$.util;

import j$.util.function.Function;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class Optional<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final Optional f50153b = new Optional();

    /* renamed from: a  reason: collision with root package name */
    private final Object f50154a;

    private Optional() {
        this.f50154a = null;
    }

    private Optional(Object obj) {
        obj.getClass();
        this.f50154a = obj;
    }

    public static Optional a() {
        return f50153b;
    }

    public static Optional b(Object obj) {
        return new Optional(obj);
    }

    public static <T> Optional<T> ofNullable(T t7) {
        return t7 == null ? f50153b : new Optional<>(t7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Optional) {
            return AbstractC0156n.l(this.f50154a, ((Optional) obj).f50154a);
        }
        return false;
    }

    public T get() {
        T t7 = (T) this.f50154a;
        if (t7 != null) {
            return t7;
        }
        throw new NoSuchElementException("No value present");
    }

    public final int hashCode() {
        Object obj = this.f50154a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean isPresent() {
        return this.f50154a != null;
    }

    public <U> Optional<U> map(Function<? super T, ? extends U> function) {
        function.getClass();
        return !isPresent() ? f50153b : ofNullable(function.apply((Object) this.f50154a));
    }

    public T orElse(T t7) {
        T t8 = (T) this.f50154a;
        return t8 != null ? t8 : t7;
    }

    public final String toString() {
        Object obj = this.f50154a;
        return obj != null ? String.format("Optional[%s]", obj) : "Optional.empty";
    }
}
