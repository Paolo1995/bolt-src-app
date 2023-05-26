package j$.time.zone;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final CopyOnWriteArrayList f50132a;

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap f50133b;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f50132a = copyOnWriteArrayList;
        f50133b = new ConcurrentHashMap(512, 0.75f, 2);
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new d(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    public static HashSet a() {
        return new HashSet(f50133b.keySet());
    }

    public static ZoneRules b(String str, boolean z7) {
        if (str != null) {
            ConcurrentHashMap concurrentHashMap = f50133b;
            f fVar = (f) concurrentHashMap.get(str);
            if (fVar == null) {
                if (concurrentHashMap.isEmpty()) {
                    throw new c("No time-zone data files registered");
                }
                throw new c("Unknown time-zone ID: " + str);
            }
            return fVar.c(str);
        }
        throw new NullPointerException("zoneId");
    }

    public static void e(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("provider");
        }
        for (String str : fVar.d()) {
            if (str == null) {
                throw new NullPointerException("zoneId");
            }
            if (((f) f50133b.putIfAbsent(str, fVar)) != null) {
                throw new c("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + fVar);
            }
        }
        f50132a.add(fVar);
    }

    protected abstract ZoneRules c(String str);

    protected abstract Set d();
}
