package ee.mtakso.driver.uicore.components.views.chart;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bar.kt */
/* loaded from: classes5.dex */
public final class Bar {

    /* renamed from: a  reason: collision with root package name */
    private final float f35497a;

    /* renamed from: b  reason: collision with root package name */
    private final float f35498b;

    /* renamed from: c  reason: collision with root package name */
    private final float f35499c;

    /* renamed from: d  reason: collision with root package name */
    private final float f35500d;

    /* renamed from: e  reason: collision with root package name */
    private final BarType f35501e;

    /* renamed from: f  reason: collision with root package name */
    private final Label f35502f;

    /* renamed from: g  reason: collision with root package name */
    private final List<BarSector> f35503g;

    public Bar(float f8, float f9, float f10, float f11, BarType barType, Label label, List<BarSector> sectors) {
        Intrinsics.f(barType, "barType");
        Intrinsics.f(sectors, "sectors");
        this.f35497a = f8;
        this.f35498b = f9;
        this.f35499c = f10;
        this.f35500d = f11;
        this.f35501e = barType;
        this.f35502f = label;
        this.f35503g = sectors;
    }

    public final BarType a() {
        return this.f35501e;
    }

    public final float b() {
        return this.f35500d;
    }

    public final Label c() {
        return this.f35502f;
    }

    public final float d() {
        return this.f35497a;
    }

    public final float e() {
        return this.f35498b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Bar) {
            Bar bar = (Bar) obj;
            return Float.compare(this.f35497a, bar.f35497a) == 0 && Float.compare(this.f35498b, bar.f35498b) == 0 && Float.compare(this.f35499c, bar.f35499c) == 0 && Float.compare(this.f35500d, bar.f35500d) == 0 && this.f35501e == bar.f35501e && Intrinsics.a(this.f35502f, bar.f35502f) && Intrinsics.a(this.f35503g, bar.f35503g);
        }
        return false;
    }

    public final List<BarSector> f() {
        return this.f35503g;
    }

    public final float g() {
        return this.f35499c;
    }

    public int hashCode() {
        int floatToIntBits = ((((((((Float.floatToIntBits(this.f35497a) * 31) + Float.floatToIntBits(this.f35498b)) * 31) + Float.floatToIntBits(this.f35499c)) * 31) + Float.floatToIntBits(this.f35500d)) * 31) + this.f35501e.hashCode()) * 31;
        Label label = this.f35502f;
        return ((floatToIntBits + (label == null ? 0 : label.hashCode())) * 31) + this.f35503g.hashCode();
    }

    public String toString() {
        float f8 = this.f35497a;
        float f9 = this.f35498b;
        float f10 = this.f35499c;
        float f11 = this.f35500d;
        BarType barType = this.f35501e;
        Label label = this.f35502f;
        List<BarSector> list = this.f35503g;
        return "Bar(left=" + f8 + ", right=" + f9 + ", top=" + f10 + ", bottom=" + f11 + ", barType=" + barType + ", label=" + label + ", sectors=" + list + ")";
    }
}
