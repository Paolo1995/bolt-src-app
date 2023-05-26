package ee.mtakso.driver.ui.screens.order.v2.driver;

import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverData.kt */
/* loaded from: classes3.dex */
public final class DriverData {

    /* renamed from: a  reason: collision with root package name */
    private final Navigator f32071a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32072b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f32073c;

    /* renamed from: d  reason: collision with root package name */
    private final NavigationOption f32074d;

    public DriverData(Navigator navigator, boolean z7, boolean z8, NavigationOption navigationOption) {
        Intrinsics.f(navigator, "navigator");
        this.f32071a = navigator;
        this.f32072b = z7;
        this.f32073c = z8;
        this.f32074d = navigationOption;
    }

    public final NavigationOption a() {
        return this.f32074d;
    }

    public final Navigator b() {
        return this.f32071a;
    }

    public final boolean c() {
        return this.f32073c;
    }

    public final boolean d() {
        return this.f32072b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverData) {
            DriverData driverData = (DriverData) obj;
            return Intrinsics.a(this.f32071a, driverData.f32071a) && this.f32072b == driverData.f32072b && this.f32073c == driverData.f32073c && Intrinsics.a(this.f32074d, driverData.f32074d);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f32071a.hashCode() * 31;
        boolean z7 = this.f32072b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        boolean z8 = this.f32073c;
        int i10 = (i9 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        NavigationOption navigationOption = this.f32074d;
        return i10 + (navigationOption == null ? 0 : navigationOption.hashCode());
    }

    public String toString() {
        Navigator navigator = this.f32071a;
        boolean z7 = this.f32072b;
        boolean z8 = this.f32073c;
        NavigationOption navigationOption = this.f32074d;
        return "DriverData(navigator=" + navigator + ", isSosEnabled=" + z7 + ", isSafetyToolkitEnabled=" + z8 + ", navigationOption=" + navigationOption + ")";
    }
}
