package ee.mtakso.driver.utils;

import androidx.annotation.NonNull;
import io.reactivex.functions.Function;
import java.util.Objects;

/* loaded from: classes5.dex */
public class Optional<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f36312a;

    private Optional(T t7) {
        this.f36312a = t7;
    }

    public static <T> Optional<T> a() {
        return new Optional<>(null);
    }

    public static <T> Optional<T> f(T t7) {
        return new Optional<>(t7);
    }

    @NonNull
    public T b() {
        T t7 = this.f36312a;
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException("value == null");
    }

    public T c() {
        return this.f36312a;
    }

    public boolean d() {
        if (this.f36312a == null) {
            return true;
        }
        return false;
    }

    public <R> Optional<R> e(Function<T, R> function) throws Exception {
        if (d()) {
            return a();
        }
        return f(function.apply(b()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.f36312a, ((Optional) obj).f36312a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f36312a);
    }

    @NonNull
    public String toString() {
        T t7 = this.f36312a;
        if (t7 == null) {
            return "Optional: {empty}";
        }
        return String.format("Optional: %s", t7.toString());
    }
}
