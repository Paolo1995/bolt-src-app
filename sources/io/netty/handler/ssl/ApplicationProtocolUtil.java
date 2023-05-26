package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
final class ApplicationProtocolUtil {
    private ApplicationProtocolUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> toList(Iterable<String> iterable) {
        return toList(2, iterable);
    }

    static List<String> toList(int i8, Iterable<String> iterable) {
        if (iterable == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i8);
        for (String str : iterable) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            } else {
                throw new IllegalArgumentException("protocol cannot be null or empty");
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("protocols cannot empty");
        }
        return arrayList;
    }
}
