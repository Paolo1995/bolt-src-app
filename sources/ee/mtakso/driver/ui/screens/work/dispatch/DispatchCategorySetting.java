package ee.mtakso.driver.ui.screens.work.dispatch;

import ee.mtakso.driver.network.client.settings.SearchCategory;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchSettingsState.kt */
/* loaded from: classes5.dex */
public final class DispatchCategorySetting {

    /* renamed from: a  reason: collision with root package name */
    private final SearchCategory f33964a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33965b;

    /* renamed from: c  reason: collision with root package name */
    private final Boolean f33966c;

    public DispatchCategorySetting(SearchCategory data, String str, Boolean bool) {
        Intrinsics.f(data, "data");
        this.f33964a = data;
        this.f33965b = str;
        this.f33966c = bool;
    }

    public final SearchCategory a() {
        return this.f33964a;
    }

    public final String b() {
        return this.f33965b;
    }

    public final Boolean c() {
        return this.f33966c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispatchCategorySetting) {
            DispatchCategorySetting dispatchCategorySetting = (DispatchCategorySetting) obj;
            return Intrinsics.a(this.f33964a, dispatchCategorySetting.f33964a) && Intrinsics.a(this.f33965b, dispatchCategorySetting.f33965b) && Intrinsics.a(this.f33966c, dispatchCategorySetting.f33966c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f33964a.hashCode() * 31;
        String str = this.f33965b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.f33966c;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        SearchCategory searchCategory = this.f33964a;
        String str = this.f33965b;
        Boolean bool = this.f33966c;
        return "DispatchCategorySetting(data=" + searchCategory + ", surgeLabel=" + str + ", surgeVisible=" + bool + ")";
    }
}
