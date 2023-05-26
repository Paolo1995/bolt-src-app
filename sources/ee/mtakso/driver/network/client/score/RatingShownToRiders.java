package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class RatingShownToRiders {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22740a;
    @SerializedName("description")

    /* renamed from: b  reason: collision with root package name */
    private final String f22741b;
    @SerializedName("formatted_value")

    /* renamed from: c  reason: collision with root package name */
    private final String f22742c;

    public final String a() {
        return this.f22741b;
    }

    public final String b() {
        return this.f22742c;
    }

    public final String c() {
        return this.f22740a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RatingShownToRiders) {
            RatingShownToRiders ratingShownToRiders = (RatingShownToRiders) obj;
            return Intrinsics.a(this.f22740a, ratingShownToRiders.f22740a) && Intrinsics.a(this.f22741b, ratingShownToRiders.f22741b) && Intrinsics.a(this.f22742c, ratingShownToRiders.f22742c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f22740a.hashCode() * 31) + this.f22741b.hashCode()) * 31) + this.f22742c.hashCode();
    }

    public String toString() {
        String str = this.f22740a;
        String str2 = this.f22741b;
        String str3 = this.f22742c;
        return "RatingShownToRiders(title=" + str + ", description=" + str2 + ", formattedValue=" + str3 + ")";
    }
}
