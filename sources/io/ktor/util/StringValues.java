package io.ktor.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
/* loaded from: classes5.dex */
public interface StringValues {

    /* compiled from: StringValues.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void a(StringValues stringValues, Function2<? super String, ? super List<String>, Unit> body) {
            Intrinsics.f(body, "body");
            Iterator<T> it = stringValues.a().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                body.s((String) entry.getKey(), (List) entry.getValue());
            }
        }

        public static String b(StringValues stringValues, String name) {
            Intrinsics.f(name, "name");
            List<String> c8 = stringValues.c(name);
            if (c8 != null) {
                return (String) CollectionsKt___CollectionsKt.Y(c8);
            }
            return null;
        }
    }

    Set<Map.Entry<String, List<String>>> a();

    boolean b();

    List<String> c(String str);

    void d(Function2<? super String, ? super List<String>, Unit> function2);

    String get(String str);

    boolean isEmpty();

    Set<String> names();
}
