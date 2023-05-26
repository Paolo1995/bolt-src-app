package ee.mtakso.driver.ui.screens.navigator_chooser;

import ee.mtakso.driver.navigation.navigators.ExternalNavigator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigatorItem.kt */
/* loaded from: classes3.dex */
public final class NavigatorItem {

    /* renamed from: a  reason: collision with root package name */
    private final ExternalNavigator f30947a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30948b;

    public NavigatorItem(ExternalNavigator navigator, boolean z7) {
        Intrinsics.f(navigator, "navigator");
        this.f30947a = navigator;
        this.f30948b = z7;
    }

    public static /* synthetic */ NavigatorItem b(NavigatorItem navigatorItem, ExternalNavigator externalNavigator, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            externalNavigator = navigatorItem.f30947a;
        }
        if ((i8 & 2) != 0) {
            z7 = navigatorItem.f30948b;
        }
        return navigatorItem.a(externalNavigator, z7);
    }

    public final NavigatorItem a(ExternalNavigator navigator, boolean z7) {
        Intrinsics.f(navigator, "navigator");
        return new NavigatorItem(navigator, z7);
    }

    public final ExternalNavigator c() {
        return this.f30947a;
    }

    public final boolean d() {
        return this.f30948b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NavigatorItem) {
            NavigatorItem navigatorItem = (NavigatorItem) obj;
            return Intrinsics.a(this.f30947a, navigatorItem.f30947a) && this.f30948b == navigatorItem.f30948b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f30947a.hashCode() * 31;
        boolean z7 = this.f30948b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        ExternalNavigator externalNavigator = this.f30947a;
        boolean z7 = this.f30948b;
        return "NavigatorItem(navigator=" + externalNavigator + ", isSelected=" + z7 + ")";
    }
}
