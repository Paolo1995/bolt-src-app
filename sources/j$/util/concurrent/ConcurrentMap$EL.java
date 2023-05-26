package j$.util.concurrent;

import j$.util.function.Function;
import java.util.concurrent.ConcurrentMap;

/* renamed from: j$.util.concurrent.ConcurrentMap$-EL  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ConcurrentMap$EL {
    public static Object computeIfAbsent(ConcurrentMap concurrentMap, Object obj, Function function) {
        Object apply;
        if (concurrentMap instanceof v) {
            return ((v) concurrentMap).computeIfAbsent(obj, function);
        }
        function.getClass();
        Object obj2 = concurrentMap.get(obj);
        return (obj2 == null && (apply = function.apply(obj)) != null && (obj2 = concurrentMap.putIfAbsent(obj, apply)) == null) ? apply : obj2;
    }
}
