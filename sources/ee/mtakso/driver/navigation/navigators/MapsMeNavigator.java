package ee.mtakso.driver.navigation.navigators;

import android.content.Intent;
import ee.mtakso.driver.R;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapsMeNavigator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class MapsMeNavigator extends ExternalNavigator {

    /* renamed from: h  reason: collision with root package name */
    private final Features f21231h;

    /* renamed from: i  reason: collision with root package name */
    private final Navigator.Type f21232i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f21233j;

    /* renamed from: k  reason: collision with root package name */
    private final int f21234k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MapsMeNavigator(AppResolver appResolver, Features features) {
        super(appResolver, "com.mapswithme.maps.pro", false);
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(features, "features");
        this.f21231h = features;
        this.f21232i = Navigator.Type.MAPS_ME;
        this.f21234k = R.drawable.ic_maps_me_nav;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator, ee.mtakso.driver.navigation.navigators.Navigator
    public boolean b() {
        if (!this.f21231h.b(Feature.Type.MAPS_ME)) {
            return false;
        }
        return super.b();
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public int c() {
        return this.f21234k;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public int e() {
        return R.string.maps_me_navigation_v2;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public Navigator.Type getType() {
        return this.f21232i;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public boolean h() {
        return this.f21233j;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    protected Intent j(GeoCoordinate latLng) {
        Intrinsics.f(latLng, "latLng");
        Intent intent = new Intent("com.mapswithme.maps.pro.action.BUILD_ROUTE");
        intent.setPackage("com.mapswithme.maps.pro");
        intent.putExtra("lat_to", latLng.a());
        intent.putExtra("lon_to", latLng.b());
        intent.putExtra("router", "vehicle");
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        return intent;
    }
}
