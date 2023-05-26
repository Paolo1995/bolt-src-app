package ee.mtakso.driver.navigation.navigators;

import android.content.Intent;
import android.net.Uri;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.utils.AppResolver;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: TwoGisNavigator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class TwoGisNavigator extends ExternalNavigator {

    /* renamed from: h  reason: collision with root package name */
    private final DriverProvider f21258h;

    /* renamed from: i  reason: collision with root package name */
    private final int f21259i;

    /* renamed from: j  reason: collision with root package name */
    private final Navigator.Type f21260j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public TwoGisNavigator(DriverProvider driverProvider, AppResolver appResolver) {
        super(appResolver, "ru.dublgis.dgismobile", false, 4, null);
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(appResolver, "appResolver");
        this.f21258h = driverProvider;
        this.f21259i = R.drawable.ic_navigation_2gis;
        this.f21260j = Navigator.Type.TWO_GIS_NAVIGATION;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public int c() {
        return this.f21259i;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public int e() {
        return R.string.two_gis_navigation_v2;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public boolean g() {
        List list;
        list = TwoGisNavigatorKt.f21262b;
        return list.contains(this.f21258h.m().j());
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public Navigator.Type getType() {
        return this.f21260j;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public boolean h() {
        List list;
        list = TwoGisNavigatorKt.f21261a;
        return list.contains(this.f21258h.m().j());
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    protected Intent j(GeoCoordinate latLng) {
        Intrinsics.f(latLng, "latLng");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("dgis://2gis.ru/routeSearch/rsType/car/to/%s,%s", Arrays.copyOf(new Object[]{Double.valueOf(latLng.b()), Double.valueOf(latLng.a())}, 2));
        Intrinsics.e(format, "format(format, *args)");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage("ru.dublgis.dgismobile");
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        return intent;
    }
}
