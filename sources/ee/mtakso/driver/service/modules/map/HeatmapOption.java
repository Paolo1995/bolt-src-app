package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.driver.map.TileCollectionOption;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapOption.kt */
/* loaded from: classes3.dex */
public final class HeatmapOption {

    /* renamed from: a  reason: collision with root package name */
    private final TileCollectionOption f24820a;

    /* renamed from: b  reason: collision with root package name */
    private final List<HeatmapCategory> f24821b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24822c;

    public HeatmapOption(TileCollectionOption data, List<HeatmapCategory> categories, boolean z7) {
        Intrinsics.f(data, "data");
        Intrinsics.f(categories, "categories");
        this.f24820a = data;
        this.f24821b = categories;
        this.f24822c = z7;
    }

    public final List<HeatmapCategory> a() {
        return this.f24821b;
    }

    public final TileCollectionOption b() {
        return this.f24820a;
    }

    public final boolean c() {
        return this.f24822c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeatmapOption) {
            HeatmapOption heatmapOption = (HeatmapOption) obj;
            return Intrinsics.a(this.f24820a, heatmapOption.f24820a) && Intrinsics.a(this.f24821b, heatmapOption.f24821b) && this.f24822c == heatmapOption.f24822c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f24820a.hashCode() * 31) + this.f24821b.hashCode()) * 31;
        boolean z7 = this.f24822c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        TileCollectionOption tileCollectionOption = this.f24820a;
        List<HeatmapCategory> list = this.f24821b;
        boolean z7 = this.f24822c;
        return "HeatmapOption(data=" + tileCollectionOption + ", categories=" + list + ", visible=" + z7 + ")";
    }
}
