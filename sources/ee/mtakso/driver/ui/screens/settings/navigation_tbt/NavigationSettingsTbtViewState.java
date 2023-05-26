package ee.mtakso.driver.ui.screens.settings.navigation_tbt;

import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationSettingsTbtViewState.kt */
/* loaded from: classes5.dex */
public final class NavigationSettingsTbtViewState {

    /* renamed from: a  reason: collision with root package name */
    private final List<ListModel> f33226a;

    /* JADX WARN: Multi-variable type inference failed */
    public NavigationSettingsTbtViewState(List<? extends ListModel> viewItems) {
        Intrinsics.f(viewItems, "viewItems");
        this.f33226a = viewItems;
    }

    public final List<ListModel> a() {
        return this.f33226a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NavigationSettingsTbtViewState) && Intrinsics.a(this.f33226a, ((NavigationSettingsTbtViewState) obj).f33226a);
    }

    public int hashCode() {
        return this.f33226a.hashCode();
    }

    public String toString() {
        List<ListModel> list = this.f33226a;
        return "NavigationSettingsTbtViewState(viewItems=" + list + ")";
    }
}
