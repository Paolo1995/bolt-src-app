package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.settings.SearchCategory;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapsConfigsAndCategories.kt */
/* loaded from: classes3.dex */
public final class MapsConfigsAndCategories {

    /* renamed from: a  reason: collision with root package name */
    private final MapsConfigs f24848a;

    /* renamed from: b  reason: collision with root package name */
    private final List<SearchCategory> f24849b;

    public MapsConfigsAndCategories(MapsConfigs mapsConfigs, List<SearchCategory> list) {
        this.f24848a = mapsConfigs;
        this.f24849b = list;
    }

    public final List<SearchCategory> a() {
        return this.f24849b;
    }

    public final MapsConfigs b() {
        return this.f24848a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapsConfigsAndCategories) {
            MapsConfigsAndCategories mapsConfigsAndCategories = (MapsConfigsAndCategories) obj;
            return Intrinsics.a(this.f24848a, mapsConfigsAndCategories.f24848a) && Intrinsics.a(this.f24849b, mapsConfigsAndCategories.f24849b);
        }
        return false;
    }

    public int hashCode() {
        MapsConfigs mapsConfigs = this.f24848a;
        int hashCode = (mapsConfigs == null ? 0 : mapsConfigs.hashCode()) * 31;
        List<SearchCategory> list = this.f24849b;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        MapsConfigs mapsConfigs = this.f24848a;
        List<SearchCategory> list = this.f24849b;
        return "MapsConfigsAndCategories(mapsConfigs=" + mapsConfigs + ", categories=" + list + ")";
    }
}
