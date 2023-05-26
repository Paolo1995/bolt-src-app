package kotlin.ranges;

/* compiled from: Ranges.kt */
/* loaded from: classes5.dex */
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {

    /* renamed from: f  reason: collision with root package name */
    private final float f51049f;

    /* renamed from: g  reason: collision with root package name */
    private final float f51050g;

    public ClosedFloatRange(float f8, float f9) {
        this.f51049f = f8;
        this.f51050g = f9;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: a */
    public Float d() {
        return Float.valueOf(this.f51050g);
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: c */
    public Float b() {
        return Float.valueOf(this.f51049f);
    }

    public boolean e() {
        if (this.f51049f > this.f51050g) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        boolean z7;
        boolean z8;
        if (obj instanceof ClosedFloatRange) {
            if (e() && ((ClosedFloatRange) obj).e()) {
                return true;
            }
            ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
            if (this.f51049f == closedFloatRange.f51049f) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                if (this.f51050g == closedFloatRange.f51050g) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f51049f) * 31) + Float.floatToIntBits(this.f51050g);
    }

    public String toString() {
        return this.f51049f + ".." + this.f51050g;
    }
}
