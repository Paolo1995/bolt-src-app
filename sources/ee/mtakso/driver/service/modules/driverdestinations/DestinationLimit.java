package ee.mtakso.driver.service.modules.driverdestinations;

/* compiled from: DestinationLimit.kt */
/* loaded from: classes3.dex */
public final class DestinationLimit {

    /* renamed from: a  reason: collision with root package name */
    private final int f24607a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24608b;

    public DestinationLimit(int i8, int i9) {
        this.f24607a = i8;
        this.f24608b = i9;
    }

    public final int a() {
        return this.f24608b;
    }

    public final int b() {
        return this.f24607a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DestinationLimit) {
            DestinationLimit destinationLimit = (DestinationLimit) obj;
            return this.f24607a == destinationLimit.f24607a && this.f24608b == destinationLimit.f24608b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f24607a * 31) + this.f24608b;
    }

    public String toString() {
        int i8 = this.f24607a;
        int i9 = this.f24608b;
        return "DestinationLimit(used=" + i8 + ", max=" + i9 + ")";
    }
}
