package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.settings.SearchCategory;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapSetting.kt */
/* loaded from: classes3.dex */
public final class HeatmapSetting {

    /* renamed from: a  reason: collision with root package name */
    private final MapsConfigs f24826a;

    /* renamed from: b  reason: collision with root package name */
    private final List<SearchCategory> f24827b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24828c;

    /* renamed from: d  reason: collision with root package name */
    private final String f24829d;

    public HeatmapSetting() {
        this(null, null, null, null, 15, null);
    }

    public HeatmapSetting(MapsConfigs mapsConfigs, List<SearchCategory> list, String str, String str2) {
        this.f24826a = mapsConfigs;
        this.f24827b = list;
        this.f24828c = str;
        this.f24829d = str2;
    }

    public final HeatmapSetting a(MapsConfigs mapsConfigs, List<SearchCategory> list, String str, String str2) {
        return new HeatmapSetting(mapsConfigs, list, str, str2);
    }

    public final List<SearchCategory> b() {
        return this.f24827b;
    }

    public final String c() {
        return this.f24829d;
    }

    public final String d() {
        return this.f24828c;
    }

    public final MapsConfigs e() {
        return this.f24826a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeatmapSetting) {
            HeatmapSetting heatmapSetting = (HeatmapSetting) obj;
            return Intrinsics.a(this.f24826a, heatmapSetting.f24826a) && Intrinsics.a(this.f24827b, heatmapSetting.f24827b) && Intrinsics.a(this.f24828c, heatmapSetting.f24828c) && Intrinsics.a(this.f24829d, heatmapSetting.f24829d);
        }
        return false;
    }

    public int hashCode() {
        MapsConfigs mapsConfigs = this.f24826a;
        int hashCode = (mapsConfigs == null ? 0 : mapsConfigs.hashCode()) * 31;
        List<SearchCategory> list = this.f24827b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.f24828c;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f24829d;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        MapsConfigs mapsConfigs = this.f24826a;
        List<SearchCategory> list = this.f24827b;
        String str = this.f24828c;
        String str2 = this.f24829d;
        return "HeatmapSetting(mapsConfigs=" + mapsConfigs + ", categories=" + list + ", heatmapId=" + str + ", categoryId=" + str2 + ")";
    }

    public /* synthetic */ HeatmapSetting(MapsConfigs mapsConfigs, List list, String str, String str2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : mapsConfigs, (i8 & 2) != 0 ? null : list, (i8 & 4) != 0 ? null : str, (i8 & 8) != 0 ? null : str2);
    }
}
