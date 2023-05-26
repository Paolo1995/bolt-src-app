package ee.mtakso.driver.navigation.navigators;

import android.content.Context;
import android.content.Intent;
import ee.mtakso.driver.R;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.routing.command.CustomTabsNavigationCommand;
import ee.mtakso.driver.routing.command.IntentContextNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import java.util.Arrays;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: YandexNavigationNavigator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class YandexNavigationNavigator extends ExternalNavigator {

    /* renamed from: h  reason: collision with root package name */
    private final Context f21274h;

    /* renamed from: i  reason: collision with root package name */
    private final ChromeCustomTabsUrlLauncher f21275i;

    /* renamed from: j  reason: collision with root package name */
    private final AppResolver f21276j;

    /* renamed from: k  reason: collision with root package name */
    private final Features f21277k;

    /* renamed from: l  reason: collision with root package name */
    private final int f21278l;

    /* renamed from: m  reason: collision with root package name */
    private final Navigator.Type f21279m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public YandexNavigationNavigator(Context context, ChromeCustomTabsUrlLauncher customTabsUrlLauncher, AppResolver appResolver, Features features) {
        super(appResolver, "ru.yandex.yandexnavi", false, 4, null);
        Intrinsics.f(context, "context");
        Intrinsics.f(customTabsUrlLauncher, "customTabsUrlLauncher");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(features, "features");
        this.f21274h = context;
        this.f21275i = customTabsUrlLauncher;
        this.f21276j = appResolver;
        this.f21277k = features;
        this.f21278l = R.drawable.ic_navigation_yandexnav;
        this.f21279m = Navigator.Type.YANDEX_NAVIGATION;
    }

    private final String m(GeoCoordinate geoCoordinate) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("https://taxify-android-driver.web.app/?platform=android&lat_to=%1$s&lon_to=%2$s&linkText=%3$s&descriptionText=%4$s", Arrays.copyOf(new Object[]{Double.valueOf(geoCoordinate.a()), Double.valueOf(geoCoordinate.b()), this.f21274h.getString(R.string.navigation_workaround_link_text), this.f21274h.getString(R.string.navigation_workaround_description_text)}, 4));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    private final Intent n(GeoCoordinate geoCoordinate) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format(Locale.ENGLISH, "ru.yandex.yandexnavi.action.BUILD_ROUTE_ON_MAP", Arrays.copyOf(new Object[0], 0));
        Intrinsics.e(format, "format(locale, format, *args)");
        Intent intent = new Intent(format);
        intent.setPackage("ru.yandex.yandexnavi");
        intent.putExtra("lat_to", geoCoordinate.a());
        intent.putExtra("lon_to", geoCoordinate.b());
        return intent;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator, ee.mtakso.driver.navigation.navigators.Navigator
    public boolean b() {
        return this.f21276j.c(n(ExternalNavigator.f21219f.a()));
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public int c() {
        return this.f21278l;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public int e() {
        return R.string.yandex_navigation_v2;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public Navigator.Type getType() {
        return this.f21279m;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    protected Intent j(GeoCoordinate latLng) {
        Intrinsics.f(latLng, "latLng");
        Intent n8 = n(latLng);
        n8.addFlags(67108864);
        n8.addFlags(268435456);
        return n8;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public NavigationCommand<Context> l(GeoCoordinate latLng) {
        Intrinsics.f(latLng, "latLng");
        if (this.f21277k.b(Feature.Type.YANDEX_MAPS_IN_BROWSER)) {
            return new CustomTabsNavigationCommand(m(latLng), this.f21275i);
        }
        return new IntentContextNavigationCommand(n(latLng), new int[]{67108864, 268435456});
    }
}
