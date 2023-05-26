package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
/* loaded from: classes5.dex */
public class CollectionsKt__CollectionsJVMKt {
    public static <E> List<E> a(List<E> builder) {
        Intrinsics.f(builder, "builder");
        return ((ListBuilder) builder).o();
    }

    public static final <T> Object[] b(T[] tArr, boolean z7) {
        Intrinsics.f(tArr, "<this>");
        if (!z7 || !Intrinsics.a(tArr.getClass(), Object[].class)) {
            Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
            Intrinsics.e(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
            return copyOf;
        }
        return tArr;
    }

    public static <E> List<E> c() {
        return new ListBuilder();
    }

    public static <E> List<E> d(int i8) {
        return new ListBuilder(i8);
    }

    public static <T> List<T> e(T t7) {
        List<T> singletonList = Collections.singletonList(t7);
        Intrinsics.e(singletonList, "singletonList(element)");
        return singletonList;
    }
}
