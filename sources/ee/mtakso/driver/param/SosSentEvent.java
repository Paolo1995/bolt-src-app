package ee.mtakso.driver.param;

/* compiled from: SosSentEvent.kt */
/* loaded from: classes3.dex */
public final class SosSentEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f23234a;

    public SosSentEvent(long j8) {
        this.f23234a = j8;
    }

    public final long a() {
        return this.f23234a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SosSentEvent) && this.f23234a == ((SosSentEvent) obj).f23234a;
    }

    public int hashCode() {
        return i0.a.a(this.f23234a);
    }

    public String toString() {
        long j8 = this.f23234a;
        return "SosSentEvent(sentTimeStamp=" + j8 + ")";
    }
}
