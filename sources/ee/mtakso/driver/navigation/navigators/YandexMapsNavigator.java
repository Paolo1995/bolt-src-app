package ee.mtakso.driver.navigation.navigators;

import android.content.Intent;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.utils.AppResolver;
import java.util.Arrays;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: YandexMapsNavigator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class YandexMapsNavigator extends ExternalNavigator {

    /* renamed from: h  reason: collision with root package name */
    private final int f21271h;

    /* renamed from: i  reason: collision with root package name */
    private final Navigator.Type f21272i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public YandexMapsNavigator(AppResolver appResolver) {
        super(appResolver, "ru.yandex.yandexmaps", false, 4, null);
        Intrinsics.f(appResolver, "appResolver");
        this.f21271h = R.drawable.ic_navigation_yandexmaps;
        this.f21272i = Navigator.Type.YANDEX_MAPS;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public int c() {
        return this.f21271h;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public int e() {
        return R.string.yandex_maps_v2;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public Navigator.Type getType() {
        return this.f21272i;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    protected Intent j(GeoCoordinate latLng) {
        Intrinsics.f(latLng, "latLng");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format(Locale.ENGLISH, "ru.yandex.yandexmaps.action.BUILD_ROUTE_ON_MAP", Arrays.copyOf(new Object[0], 0));
        Intrinsics.e(format, "format(locale, format, *args)");
        Intent intent = new Intent(format);
        intent.setPackage("ru.yandex.yandexmaps");
        intent.putExtra("lat_to", latLng.a());
        intent.putExtra("lon_to", latLng.b());
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        return intent;
    }
}
