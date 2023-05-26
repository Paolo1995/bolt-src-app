package eu.bolt.android.maps.core.plugin.driver;

import android.graphics.Bitmap;
import android.graphics.PointF;
import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkerParams.kt */
/* loaded from: classes5.dex */
public final class MarkerParams {

    /* renamed from: a  reason: collision with root package name */
    private final Locatable f36987a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f36988b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f36989c;

    /* renamed from: d  reason: collision with root package name */
    private final PointF f36990d;

    /* renamed from: e  reason: collision with root package name */
    private final float f36991e;

    /* renamed from: f  reason: collision with root package name */
    private final int f36992f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f36993g;

    public MarkerParams(Locatable position, Integer num, Bitmap bitmap, PointF anchor, float f8, int i8, boolean z7) {
        Intrinsics.f(position, "position");
        Intrinsics.f(anchor, "anchor");
        this.f36987a = position;
        this.f36988b = num;
        this.f36989c = bitmap;
        this.f36990d = anchor;
        this.f36991e = f8;
        this.f36992f = i8;
        this.f36993g = z7;
    }

    public static /* synthetic */ MarkerParams b(MarkerParams markerParams, Locatable locatable, Integer num, Bitmap bitmap, PointF pointF, float f8, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            locatable = markerParams.f36987a;
        }
        if ((i9 & 2) != 0) {
            num = markerParams.f36988b;
        }
        Integer num2 = num;
        if ((i9 & 4) != 0) {
            bitmap = markerParams.f36989c;
        }
        Bitmap bitmap2 = bitmap;
        if ((i9 & 8) != 0) {
            pointF = markerParams.f36990d;
        }
        PointF pointF2 = pointF;
        if ((i9 & 16) != 0) {
            f8 = markerParams.f36991e;
        }
        float f9 = f8;
        if ((i9 & 32) != 0) {
            i8 = markerParams.f36992f;
        }
        int i10 = i8;
        if ((i9 & 64) != 0) {
            z7 = markerParams.f36993g;
        }
        return markerParams.a(locatable, num2, bitmap2, pointF2, f9, i10, z7);
    }

    public final MarkerParams a(Locatable position, Integer num, Bitmap bitmap, PointF anchor, float f8, int i8, boolean z7) {
        Intrinsics.f(position, "position");
        Intrinsics.f(anchor, "anchor");
        return new MarkerParams(position, num, bitmap, anchor, f8, i8, z7);
    }

    public final PointF c() {
        return this.f36990d;
    }

    public final Bitmap d() {
        return this.f36989c;
    }

    public final boolean e() {
        return this.f36993g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MarkerParams) {
            MarkerParams markerParams = (MarkerParams) obj;
            return Intrinsics.a(this.f36987a, markerParams.f36987a) && Intrinsics.a(this.f36988b, markerParams.f36988b) && Intrinsics.a(this.f36989c, markerParams.f36989c) && Intrinsics.a(this.f36990d, markerParams.f36990d) && Float.compare(this.f36991e, markerParams.f36991e) == 0 && this.f36992f == markerParams.f36992f && this.f36993g == markerParams.f36993g;
        }
        return false;
    }

    public final Integer f() {
        return this.f36988b;
    }

    public final Locatable g() {
        return this.f36987a;
    }

    public final float h() {
        return this.f36991e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f36987a.hashCode() * 31;
        Integer num = this.f36988b;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Bitmap bitmap = this.f36989c;
        int hashCode3 = (((((((hashCode2 + (bitmap != null ? bitmap.hashCode() : 0)) * 31) + this.f36990d.hashCode()) * 31) + Float.floatToIntBits(this.f36991e)) * 31) + this.f36992f) * 31;
        boolean z7 = this.f36993g;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode3 + i8;
    }

    public final int i() {
        return this.f36992f;
    }

    public String toString() {
        return "MarkerParams(position=" + this.f36987a + ", iconResId=" + this.f36988b + ", bitmap=" + this.f36989c + ", anchor=" + this.f36990d + ", rotation=" + this.f36991e + ", zIndex=" + this.f36992f + ", flat=" + this.f36993g + ')';
    }

    public /* synthetic */ MarkerParams(Locatable locatable, Integer num, Bitmap bitmap, PointF pointF, float f8, int i8, boolean z7, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(locatable, (i9 & 2) != 0 ? null : num, (i9 & 4) == 0 ? bitmap : null, (i9 & 8) != 0 ? new PointF(0.5f, 0.5f) : pointF, (i9 & 16) != 0 ? 0.0f : f8, (i9 & 32) != 0 ? 0 : i8, (i9 & 64) != 0 ? true : z7);
    }
}
