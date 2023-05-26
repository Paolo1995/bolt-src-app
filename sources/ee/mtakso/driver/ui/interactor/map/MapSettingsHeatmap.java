package ee.mtakso.driver.ui.interactor.map;

import ee.mtakso.driver.uikit.utils.Image;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapSettingsHeatmap.kt */
/* loaded from: classes3.dex */
public final class MapSettingsHeatmap {

    /* renamed from: a  reason: collision with root package name */
    private final String f26646a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26647b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26648c;

    /* renamed from: d  reason: collision with root package name */
    private final Image f26649d;

    /* renamed from: e  reason: collision with root package name */
    private final List<MapSettingsCategory> f26650e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f26651f;

    public MapSettingsHeatmap(String id, String title, String description, Image image, List<MapSettingsCategory> categories, boolean z7) {
        Intrinsics.f(id, "id");
        Intrinsics.f(title, "title");
        Intrinsics.f(description, "description");
        Intrinsics.f(categories, "categories");
        this.f26646a = id;
        this.f26647b = title;
        this.f26648c = description;
        this.f26649d = image;
        this.f26650e = categories;
        this.f26651f = z7;
    }

    public final List<MapSettingsCategory> a() {
        return this.f26650e;
    }

    public final String b() {
        return this.f26648c;
    }

    public final String c() {
        return this.f26646a;
    }

    public final Image d() {
        return this.f26649d;
    }

    public final boolean e() {
        return this.f26651f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapSettingsHeatmap) {
            MapSettingsHeatmap mapSettingsHeatmap = (MapSettingsHeatmap) obj;
            return Intrinsics.a(this.f26646a, mapSettingsHeatmap.f26646a) && Intrinsics.a(this.f26647b, mapSettingsHeatmap.f26647b) && Intrinsics.a(this.f26648c, mapSettingsHeatmap.f26648c) && Intrinsics.a(this.f26649d, mapSettingsHeatmap.f26649d) && Intrinsics.a(this.f26650e, mapSettingsHeatmap.f26650e) && this.f26651f == mapSettingsHeatmap.f26651f;
        }
        return false;
    }

    public final String f() {
        return this.f26647b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f26646a.hashCode() * 31) + this.f26647b.hashCode()) * 31) + this.f26648c.hashCode()) * 31;
        Image image = this.f26649d;
        int hashCode2 = (((hashCode + (image == null ? 0 : image.hashCode())) * 31) + this.f26650e.hashCode()) * 31;
        boolean z7 = this.f26651f;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode2 + i8;
    }

    public String toString() {
        String str = this.f26646a;
        String str2 = this.f26647b;
        String str3 = this.f26648c;
        Image image = this.f26649d;
        List<MapSettingsCategory> list = this.f26650e;
        boolean z7 = this.f26651f;
        return "MapSettingsHeatmap(id=" + str + ", title=" + str2 + ", description=" + str3 + ", preview=" + image + ", categories=" + list + ", selected=" + z7 + ")";
    }
}
