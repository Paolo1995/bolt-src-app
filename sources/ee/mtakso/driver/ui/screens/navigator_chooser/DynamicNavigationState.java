package ee.mtakso.driver.ui.screens.navigator_chooser;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicNavigationState.kt */
/* loaded from: classes3.dex */
public final class DynamicNavigationState {

    /* renamed from: a  reason: collision with root package name */
    private final List<NavigationOption> f30893a;

    /* renamed from: b  reason: collision with root package name */
    private final NavigationOption f30894b;

    public DynamicNavigationState(List<NavigationOption> navigationOptions, NavigationOption navigationOption) {
        Intrinsics.f(navigationOptions, "navigationOptions");
        this.f30893a = navigationOptions;
        this.f30894b = navigationOption;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DynamicNavigationState b(DynamicNavigationState dynamicNavigationState, List list, NavigationOption navigationOption, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            list = dynamicNavigationState.f30893a;
        }
        if ((i8 & 2) != 0) {
            navigationOption = dynamicNavigationState.f30894b;
        }
        return dynamicNavigationState.a(list, navigationOption);
    }

    public final DynamicNavigationState a(List<NavigationOption> navigationOptions, NavigationOption navigationOption) {
        Intrinsics.f(navigationOptions, "navigationOptions");
        return new DynamicNavigationState(navigationOptions, navigationOption);
    }

    public final List<NavigationOption> c() {
        return this.f30893a;
    }

    public final NavigationOption d() {
        return this.f30894b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DynamicNavigationState) {
            DynamicNavigationState dynamicNavigationState = (DynamicNavigationState) obj;
            return Intrinsics.a(this.f30893a, dynamicNavigationState.f30893a) && Intrinsics.a(this.f30894b, dynamicNavigationState.f30894b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f30893a.hashCode() * 31;
        NavigationOption navigationOption = this.f30894b;
        return hashCode + (navigationOption == null ? 0 : navigationOption.hashCode());
    }

    public String toString() {
        List<NavigationOption> list = this.f30893a;
        NavigationOption navigationOption = this.f30894b;
        return "DynamicNavigationState(navigationOptions=" + list + ", selectedItem=" + navigationOption + ")";
    }
}
