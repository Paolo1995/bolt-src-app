package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class kh {

    /* renamed from: c  reason: collision with root package name */
    public static final a f43870c = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final float f43871a;

    /* renamed from: b  reason: collision with root package name */
    private final float f43872b;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public kh(float f8, float f9) {
        this.f43871a = f8;
        this.f43872b = f9;
    }

    public final float a() {
        return this.f43871a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kh) {
            kh khVar = (kh) obj;
            return Float.compare(this.f43871a, khVar.f43871a) == 0 && Float.compare(this.f43872b, khVar.f43872b) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f43871a) * 31) + Float.floatToIntBits(this.f43872b);
    }

    public String toString() {
        float f8 = this.f43871a;
        float f9 = this.f43872b;
        return "SlideOffset(internalOffset=" + f8 + ", totalOffset=" + f9 + ")";
    }
}
