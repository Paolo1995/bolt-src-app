package j$.util;

import j$.util.stream.AbstractC0254w0;
import j$.util.stream.Stream;

/* loaded from: classes2.dex */
public class DesugarArrays {
    public static <T> Stream<T> stream(T[] tArr) {
        return AbstractC0254w0.u1(Spliterators.spliterator(tArr, 0, tArr.length, 1040), false);
    }
}
