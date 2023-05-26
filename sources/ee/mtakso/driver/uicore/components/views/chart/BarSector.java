package ee.mtakso.driver.uicore.components.views.chart;

/* compiled from: Bar.kt */
/* loaded from: classes5.dex */
public final class BarSector {

    /* renamed from: a  reason: collision with root package name */
    private final int f35536a;

    /* renamed from: b  reason: collision with root package name */
    private final float f35537b;

    public BarSector(int i8, float f8) {
        this.f35536a = i8;
        this.f35537b = f8;
    }

    public final int a() {
        return this.f35536a;
    }

    public final float b() {
        return this.f35537b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BarSector) {
            BarSector barSector = (BarSector) obj;
            return this.f35536a == barSector.f35536a && Float.compare(this.f35537b, barSector.f35537b) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (this.f35536a * 31) + Float.floatToIntBits(this.f35537b);
    }

    public String toString() {
        int i8 = this.f35536a;
        float f8 = this.f35537b;
        return "BarSector(colorAttr=" + i8 + ", heightRatio=" + f8 + ")";
    }
}
