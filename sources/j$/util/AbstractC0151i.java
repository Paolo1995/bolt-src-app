package j$.util;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* renamed from: j$.util.i  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0151i {
    public static Optional a(java.util.Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.b(optional.get()) : Optional.a();
    }

    public static C0152j b(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? C0152j.d(optionalDouble.getAsDouble()) : C0152j.a();
    }

    public static C0153k c(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? C0153k.d(optionalInt.getAsInt()) : C0153k.a();
    }

    public static C0154l d(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? C0154l.d(optionalLong.getAsLong()) : C0154l.a();
    }

    public static java.util.Optional e(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? java.util.Optional.of(optional.get()) : java.util.Optional.empty();
    }

    public static OptionalDouble f(C0152j c0152j) {
        if (c0152j == null) {
            return null;
        }
        return c0152j.c() ? OptionalDouble.of(c0152j.b()) : OptionalDouble.empty();
    }

    public static OptionalInt g(C0153k c0153k) {
        if (c0153k == null) {
            return null;
        }
        return c0153k.c() ? OptionalInt.of(c0153k.b()) : OptionalInt.empty();
    }

    public static OptionalLong h(C0154l c0154l) {
        if (c0154l == null) {
            return null;
        }
        return c0154l.c() ? OptionalLong.of(c0154l.b()) : OptionalLong.empty();
    }
}
