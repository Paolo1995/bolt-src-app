package ee.mtakso.driver.uicore.components.views.chart;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridAxis.kt */
/* loaded from: classes5.dex */
public final class GridAxis {

    /* renamed from: a  reason: collision with root package name */
    private final float f35541a;

    /* renamed from: b  reason: collision with root package name */
    private final float f35542b;

    /* renamed from: c  reason: collision with root package name */
    private final String f35543c;

    public GridAxis(float f8, float f9, String str) {
        this.f35541a = f8;
        this.f35542b = f9;
        this.f35543c = str;
    }

    public final String a() {
        return this.f35543c;
    }

    public final float b() {
        return this.f35541a;
    }

    public final float c() {
        return this.f35542b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GridAxis) {
            GridAxis gridAxis = (GridAxis) obj;
            return Float.compare(this.f35541a, gridAxis.f35541a) == 0 && Float.compare(this.f35542b, gridAxis.f35542b) == 0 && Intrinsics.a(this.f35543c, gridAxis.f35543c);
        }
        return false;
    }

    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.f35541a) * 31) + Float.floatToIntBits(this.f35542b)) * 31;
        String str = this.f35543c;
        return floatToIntBits + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        float f8 = this.f35541a;
        float f9 = this.f35542b;
        String str = this.f35543c;
        return "GridAxis(positionY=" + f8 + ", startX=" + f9 + ", label=" + str + ")";
    }
}
