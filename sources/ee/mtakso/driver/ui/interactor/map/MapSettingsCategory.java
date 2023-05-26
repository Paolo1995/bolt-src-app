package ee.mtakso.driver.ui.interactor.map;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapSettingsCategory.kt */
/* loaded from: classes3.dex */
public final class MapSettingsCategory {

    /* renamed from: a  reason: collision with root package name */
    private final String f26643a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26644b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f26645c;

    public MapSettingsCategory(String id, String title, boolean z7) {
        Intrinsics.f(id, "id");
        Intrinsics.f(title, "title");
        this.f26643a = id;
        this.f26644b = title;
        this.f26645c = z7;
    }

    public final String a() {
        return this.f26643a;
    }

    public final boolean b() {
        return this.f26645c;
    }

    public final String c() {
        return this.f26644b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapSettingsCategory) {
            MapSettingsCategory mapSettingsCategory = (MapSettingsCategory) obj;
            return Intrinsics.a(this.f26643a, mapSettingsCategory.f26643a) && Intrinsics.a(this.f26644b, mapSettingsCategory.f26644b) && this.f26645c == mapSettingsCategory.f26645c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f26643a.hashCode() * 31) + this.f26644b.hashCode()) * 31;
        boolean z7 = this.f26645c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f26643a;
        String str2 = this.f26644b;
        boolean z7 = this.f26645c;
        return "MapSettingsCategory(id=" + str + ", title=" + str2 + ", selected=" + z7 + ")";
    }
}
