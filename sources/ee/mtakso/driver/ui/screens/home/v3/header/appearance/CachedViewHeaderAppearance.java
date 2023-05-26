package ee.mtakso.driver.ui.screens.home.v3.header.appearance;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.ui.screens.home.v3.header.HeaderAppearance;
import ee.mtakso.driver.ui.screens.home.v3.header.HeaderContainer;
import ee.mtakso.driver.utils.AssertUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CachedViewHeaderAppearance.kt */
/* loaded from: classes3.dex */
public abstract class CachedViewHeaderAppearance implements HeaderAppearance {

    /* renamed from: a  reason: collision with root package name */
    private HeaderContainer f30034a;

    @Override // ee.mtakso.driver.ui.screens.home.v3.header.HeaderAppearance
    public void a(HeaderContainer target, DriverStatus previousState, DriverStatus driverStatus) {
        Intrinsics.f(target, "target");
        Intrinsics.f(previousState, "previousState");
        Intrinsics.f(driverStatus, "driverStatus");
        if (!Intrinsics.a(target, this.f30034a)) {
            this.f30034a = target;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final HeaderContainer b() {
        AssertUtils.d(this.f30034a, null, 2, null);
        return this.f30034a;
    }
}
