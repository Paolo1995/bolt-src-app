package ee.mtakso.driver.service.modules.map;

/* compiled from: TilePosition.kt */
/* loaded from: classes3.dex */
public final class TilePosition {

    /* renamed from: a  reason: collision with root package name */
    private final int f24865a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24866b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24867c;

    public TilePosition(int i8, int i9, int i10) {
        this.f24865a = i8;
        this.f24866b = i9;
        this.f24867c = i10;
    }

    public final int a() {
        return this.f24865a;
    }

    public final int b() {
        return this.f24866b;
    }

    public final int c() {
        return this.f24867c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TilePosition) {
            TilePosition tilePosition = (TilePosition) obj;
            return this.f24865a == tilePosition.f24865a && this.f24866b == tilePosition.f24866b && this.f24867c == tilePosition.f24867c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f24865a * 31) + this.f24866b) * 31) + this.f24867c;
    }

    public String toString() {
        int i8 = this.f24865a;
        int i9 = this.f24866b;
        int i10 = this.f24867c;
        return "TilePosition(x=" + i8 + ", y=" + i9 + ", zoom=" + i10 + ")";
    }
}
