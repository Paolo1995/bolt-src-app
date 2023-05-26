package ee.mtakso.driver.platform.check;

/* compiled from: PlatformServicesState.kt */
/* loaded from: classes3.dex */
public final class PlatformServicesState {

    /* renamed from: a  reason: collision with root package name */
    private final int f23277a;

    public PlatformServicesState(int i8) {
        this.f23277a = i8;
    }

    public final int a() {
        return this.f23277a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlatformServicesState) && this.f23277a == ((PlatformServicesState) obj).f23277a;
    }

    public int hashCode() {
        return this.f23277a;
    }

    public String toString() {
        int i8 = this.f23277a;
        return "PlatformServicesState(code=" + i8 + ")";
    }
}
