package j$.time.chrono;

import j$.time.chrono.b;
import j$.time.g;
import j$.time.temporal.k;
import j$.time.temporal.m;

/* loaded from: classes2.dex */
public interface ChronoLocalDateTime<D extends b> extends k, m, Comparable<ChronoLocalDateTime<?>> {
    j$.time.k a();

    e b();

    int compareTo(ChronoLocalDateTime chronoLocalDateTime);

    g l();
}
