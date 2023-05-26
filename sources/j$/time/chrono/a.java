package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.g;
import j$.time.temporal.p;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class a implements e {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new Locale("ja", "JP", "JP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(HashMap hashMap, j$.time.temporal.a aVar, long j8) {
        Long l8 = (Long) hashMap.get(aVar);
        if (l8 == null || l8.longValue() == j8) {
            hashMap.put(aVar, Long.valueOf(j8));
            return;
        }
        throw new DateTimeException("Conflict found: " + aVar + " " + l8 + " differs from " + aVar + " " + j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g e(g gVar, long j8, long j9, long j10) {
        long j11;
        g i8 = gVar.i(j8, j$.time.temporal.b.MONTHS);
        j$.time.temporal.b bVar = j$.time.temporal.b.WEEKS;
        g i9 = i8.i(j9, bVar);
        if (j10 <= 7) {
            if (j10 < 1) {
                i9 = i9.i(j$.time.a.g(j10, 7L) / 7, bVar);
                j11 = j10 + 6;
            }
            return i9.g(new p(j$.time.d.r((int) j10).q()));
        }
        j11 = j10 - 1;
        i9 = i9.i(j11 / 7, bVar);
        j10 = (j11 % 7) + 1;
        return i9.g(new p(j$.time.d.r((int) j10).q()));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ((e) obj).getClass();
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            ((a) obj).getClass();
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ 72805;
    }

    public final String toString() {
        return "ISO";
    }
}
