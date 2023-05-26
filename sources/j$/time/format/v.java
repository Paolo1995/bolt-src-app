package j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final Map f50049a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f50050b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Map map) {
        Comparator comparator;
        Comparator comparator2;
        this.f50049a = map;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                int i8 = b.f49996c;
                hashMap2.put((String) entry2.getValue(), new AbstractMap.SimpleImmutableEntry((String) entry2.getValue(), (Long) entry2.getKey()));
            }
            ArrayList arrayList2 = new ArrayList(hashMap2.values());
            comparator2 = b.f49995b;
            Collections.sort(arrayList2, comparator2);
            hashMap.put((A) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            hashMap.put(null, arrayList);
        }
        comparator = b.f49995b;
        Collections.sort(arrayList, comparator);
        this.f50050b = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(long j8, A a8) {
        Map map = (Map) this.f50049a.get(a8);
        if (map != null) {
            return (String) map.get(Long.valueOf(j8));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator b(A a8) {
        List list = (List) this.f50050b.get(a8);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
