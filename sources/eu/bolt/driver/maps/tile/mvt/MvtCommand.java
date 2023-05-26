package eu.bolt.driver.maps.tile.mvt;

/* compiled from: MvtCommand.kt */
/* loaded from: classes5.dex */
public final class MvtCommand {

    /* renamed from: a  reason: collision with root package name */
    private final int f41513a;

    /* renamed from: b  reason: collision with root package name */
    private final int f41514b;

    /* renamed from: c  reason: collision with root package name */
    private final int f41515c;

    public MvtCommand(int i8, int i9, int i10) {
        this.f41513a = i8;
        this.f41514b = i9;
        this.f41515c = i10;
    }

    public final int a() {
        return this.f41513a;
    }

    public final int b() {
        return this.f41514b;
    }

    public final int c() {
        return this.f41515c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MvtCommand) {
            MvtCommand mvtCommand = (MvtCommand) obj;
            return this.f41513a == mvtCommand.f41513a && this.f41514b == mvtCommand.f41514b && this.f41515c == mvtCommand.f41515c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f41513a * 31) + this.f41514b) * 31) + this.f41515c;
    }

    public String toString() {
        int i8 = this.f41513a;
        int i9 = this.f41514b;
        int i10 = this.f41515c;
        return "MvtCommand(id=" + i8 + ", x=" + i9 + ", y=" + i10 + ")";
    }
}
