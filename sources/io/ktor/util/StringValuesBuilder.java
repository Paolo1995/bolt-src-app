package io.ktor.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: StringValues.kt */
/* loaded from: classes5.dex */
public interface StringValuesBuilder {
    Set<Map.Entry<String, List<String>>> a();

    boolean b();

    List<String> c(String str);

    void clear();

    boolean contains(String str);

    void d(StringValues stringValues);

    void e(String str, Iterable<String> iterable);

    void f(String str, String str2);

    boolean isEmpty();

    Set<String> names();
}
