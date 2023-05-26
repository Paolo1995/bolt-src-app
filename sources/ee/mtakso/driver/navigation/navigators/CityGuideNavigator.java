package ee.mtakso.driver.navigation.navigators;

import android.content.Intent;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.utils.AppResolver;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: CityGuideNavigator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class CityGuideNavigator extends ExternalNavigator {

    /* renamed from: h  reason: collision with root package name */
    private final int f21216h;

    /* renamed from: i  reason: collision with root package name */
    private final Navigator.Type f21217i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public CityGuideNavigator(AppResolver appResolver) {
        super(appResolver, "cityguide.probki.net", false, 4, null);
        Intrinsics.f(appResolver, "appResolver");
        this.f21216h = R.drawable.ic_navigation_cityguide;
        this.f21217i = Navigator.Type.CITY_GUIDE_NAVIGATION;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public int c() {
        return this.f21216h;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public int e() {
        return R.string.city_guide_navigation_v2;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public Navigator.Type getType() {
        return this.f21217i;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    protected Intent j(GeoCoordinate latLng) {
        Intrinsics.f(latLng, "latLng");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("vnd.android.cursor.item/vnd.net.probki.cityguide.cmd");
        intent.setPackage("cityguide.probki.net");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("cgcmd delroute setroute 1 %s %s", Arrays.copyOf(new Object[]{Double.valueOf(latLng.a()), Double.valueOf(latLng.b())}, 2));
        Intrinsics.e(format, "format(format, *args)");
        intent.putExtra("android.intent.extra.TEXT", format);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        return intent;
    }
}
