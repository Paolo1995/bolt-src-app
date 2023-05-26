package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.b;
import j$.time.temporal.k;

/* loaded from: classes2.dex */
public interface ChronoZonedDateTime<D extends b> extends k, Comparable<ChronoZonedDateTime<?>> {
    j$.time.k a();

    e b();

    ZoneOffset c();

    LocalDateTime f();

    ZoneId m();

    long p();

    Instant toInstant();
}
