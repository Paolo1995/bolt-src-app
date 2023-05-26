package ee.mtakso.driver.ui.screens.navigator_chooser;

import ee.mtakso.driver.navigation.navigators.Navigator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigatorChooserState.kt */
/* loaded from: classes3.dex */
public final class NavigatorChooserState {

    /* renamed from: a  reason: collision with root package name */
    private final List<NavigatorItem> f30928a;

    /* renamed from: b  reason: collision with root package name */
    private final Navigator.Type f30929b;

    public NavigatorChooserState(List<NavigatorItem> navigatorItems, Navigator.Type selectedItem) {
        Intrinsics.f(navigatorItems, "navigatorItems");
        Intrinsics.f(selectedItem, "selectedItem");
        this.f30928a = navigatorItems;
        this.f30929b = selectedItem;
    }

    public final NavigatorChooserState a(List<NavigatorItem> navigatorItems, Navigator.Type selectedItem) {
        Intrinsics.f(navigatorItems, "navigatorItems");
        Intrinsics.f(selectedItem, "selectedItem");
        return new NavigatorChooserState(navigatorItems, selectedItem);
    }

    public final List<NavigatorItem> b() {
        return this.f30928a;
    }

    public final Navigator.Type c() {
        return this.f30929b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NavigatorChooserState) {
            NavigatorChooserState navigatorChooserState = (NavigatorChooserState) obj;
            return Intrinsics.a(this.f30928a, navigatorChooserState.f30928a) && this.f30929b == navigatorChooserState.f30929b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f30928a.hashCode() * 31) + this.f30929b.hashCode();
    }

    public String toString() {
        List<NavigatorItem> list = this.f30928a;
        Navigator.Type type = this.f30929b;
        return "NavigatorChooserState(navigatorItems=" + list + ", selectedItem=" + type + ")";
    }
}
