package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.GenericItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutResponce.kt */
/* loaded from: classes3.dex */
public final class DetailsSection {
    @SerializedName("items")

    /* renamed from: a  reason: collision with root package name */
    private final List<GenericItem> f22092a;
    @SerializedName("error")

    /* renamed from: b  reason: collision with root package name */
    private final String f22093b;

    public final String a() {
        return this.f22093b;
    }

    public final List<GenericItem> b() {
        return this.f22092a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DetailsSection) {
            DetailsSection detailsSection = (DetailsSection) obj;
            return Intrinsics.a(this.f22092a, detailsSection.f22092a) && Intrinsics.a(this.f22093b, detailsSection.f22093b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22092a.hashCode() * 31;
        String str = this.f22093b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        List<GenericItem> list = this.f22092a;
        String str = this.f22093b;
        return "DetailsSection(items=" + list + ", error=" + str + ")";
    }
}
