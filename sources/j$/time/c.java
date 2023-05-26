package j$.time;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c extends Clock implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final ZoneId f49975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ZoneOffset zoneOffset) {
        this.f49975a = zoneOffset;
    }

    @Override // j$.time.Clock
    public final long a() {
        return System.currentTimeMillis();
    }

    @Override // j$.time.Clock
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f49975a.equals(((c) obj).f49975a);
        }
        return false;
    }

    @Override // j$.time.Clock
    public final int hashCode() {
        return this.f49975a.hashCode() + 1;
    }

    @Override // j$.time.Clock
    public final Instant instant() {
        return Instant.ofEpochMilli(System.currentTimeMillis());
    }

    public final String toString() {
        StringBuilder a8 = b.a("SystemClock[");
        a8.append(this.f49975a);
        a8.append("]");
        return a8.toString();
    }
}
