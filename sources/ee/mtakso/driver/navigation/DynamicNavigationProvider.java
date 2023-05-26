package ee.mtakso.driver.navigation;

import android.content.Context;
import android.content.Intent;
import ee.mtakso.driver.R;
import ee.mtakso.driver.routing.command.CustomTabsNavigationCommand;
import ee.mtakso.driver.routing.command.IntentContextNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: DynamicNavigationProvider.kt */
/* loaded from: classes3.dex */
public final class DynamicNavigationProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21196a;

    /* renamed from: b  reason: collision with root package name */
    private final ChromeCustomTabsUrlLauncher f21197b;

    @Inject
    public DynamicNavigationProvider(Context context, ChromeCustomTabsUrlLauncher chromeCustomTabsUrlLauncher) {
        Intrinsics.f(context, "context");
        Intrinsics.f(chromeCustomTabsUrlLauncher, "chromeCustomTabsUrlLauncher");
        this.f21196a = context;
        this.f21197b = chromeCustomTabsUrlLauncher;
    }

    private final String a(String str, GeoCoordinate geoCoordinate) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format(str, Arrays.copyOf(new Object[]{Double.valueOf(geoCoordinate.a()), Double.valueOf(geoCoordinate.b()), this.f21196a.getString(R.string.navigation_workaround_link_text), this.f21196a.getString(R.string.navigation_workaround_description_text)}, 4));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    private final Intent b(NavigationOption navigationOption, GeoCoordinate geoCoordinate) {
        return new AndroidIntentBuilder(navigationOption, geoCoordinate).a();
    }

    public final NavigationCommand<Context> c(NavigationOption navigationOption, GeoCoordinate latLng) {
        String startNavigationLink;
        Intrinsics.f(navigationOption, "navigationOption");
        Intrinsics.f(latLng, "latLng");
        NavigationOption.IntentDataHolder intentDataHolder = navigationOption.getIntentDataHolder();
        if (intentDataHolder != null && (startNavigationLink = intentDataHolder.getStartNavigationLink()) != null) {
            return new CustomTabsNavigationCommand(a(startNavigationLink, latLng), this.f21197b);
        }
        return new IntentContextNavigationCommand(b(navigationOption, latLng), new int[]{67108864, 268435456});
    }
}
