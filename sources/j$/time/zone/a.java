package j$.time.zone;

import j$.time.Duration;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class a implements Comparable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f50127a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset f50128b;

    /* renamed from: c  reason: collision with root package name */
    private final ZoneOffset f50129c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j8, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f50127a = LocalDateTime.A(j8, 0, zoneOffset);
        this.f50128b = zoneOffset;
        this.f50129c = zoneOffset2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f50127a = localDateTime;
        this.f50128b = zoneOffset;
        this.f50129c = zoneOffset2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a aVar = (a) obj;
        return this.f50127a.G(this.f50128b).compareTo(aVar.f50127a.G(aVar.f50128b));
    }

    public final LocalDateTime d() {
        return this.f50127a.D(this.f50129c.s() - this.f50128b.s());
    }

    public final LocalDateTime e() {
        return this.f50127a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f50127a.equals(aVar.f50127a) && this.f50128b.equals(aVar.f50128b) && this.f50129c.equals(aVar.f50129c);
        }
        return false;
    }

    public final Duration g() {
        return Duration.i(this.f50129c.s() - this.f50128b.s());
    }

    public final ZoneOffset h() {
        return this.f50129c;
    }

    public final int hashCode() {
        return (this.f50127a.hashCode() ^ this.f50128b.hashCode()) ^ Integer.rotateLeft(this.f50129c.hashCode(), 16);
    }

    public final ZoneOffset i() {
        return this.f50128b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List j() {
        return k() ? Collections.emptyList() : Arrays.asList(this.f50128b, this.f50129c);
    }

    public final boolean k() {
        return this.f50129c.s() > this.f50128b.s();
    }

    public final long p() {
        return this.f50127a.F(this.f50128b);
    }

    public final String toString() {
        StringBuilder a8 = j$.time.b.a("Transition[");
        a8.append(k() ? "Gap" : "Overlap");
        a8.append(" at ");
        a8.append(this.f50127a);
        a8.append(this.f50128b);
        a8.append(" to ");
        a8.append(this.f50129c);
        a8.append(']');
        return a8.toString();
    }
}
