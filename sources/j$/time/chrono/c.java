package j$.time.chrono;

import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.s;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class c {
    public static int a(ChronoZonedDateTime chronoZonedDateTime, o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            int i8 = d.f49976a[((j$.time.temporal.a) oVar).ordinal()];
            if (i8 != 1) {
                return i8 != 2 ? chronoZonedDateTime.f().e(oVar) : chronoZonedDateTime.c().s();
            }
            throw new s("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }
        return n.a(chronoZonedDateTime, oVar);
    }
}
