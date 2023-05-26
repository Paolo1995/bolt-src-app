package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.settings.SearchCategory;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapCategory.kt */
/* loaded from: classes3.dex */
public final class HeatmapCategory {

    /* renamed from: a  reason: collision with root package name */
    private final SearchCategory f24813a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f24814b;

    public HeatmapCategory(SearchCategory data, boolean z7) {
        Intrinsics.f(data, "data");
        this.f24813a = data;
        this.f24814b = z7;
    }

    public final SearchCategory a() {
        return this.f24813a;
    }

    public final boolean b() {
        return this.f24814b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeatmapCategory) {
            HeatmapCategory heatmapCategory = (HeatmapCategory) obj;
            return Intrinsics.a(this.f24813a, heatmapCategory.f24813a) && this.f24814b == heatmapCategory.f24814b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f24813a.hashCode() * 31;
        boolean z7 = this.f24814b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        SearchCategory searchCategory = this.f24813a;
        boolean z7 = this.f24814b;
        return "HeatmapCategory(data=" + searchCategory + ", visible=" + z7 + ")";
    }
}
