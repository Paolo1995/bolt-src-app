package ee.mtakso.driver.navigation.navigators;

import android.content.Intent;
import android.net.Uri;
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

/* compiled from: GoogleMapsNavigator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class GoogleMapsNavigator extends ExternalNavigator {

    /* renamed from: h  reason: collision with root package name */
    private final boolean f21226h;

    /* renamed from: i  reason: collision with root package name */
    private final int f21227i;

    /* renamed from: j  reason: collision with root package name */
    private final Navigator.Type f21228j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GoogleMapsNavigator(AppResolver appResolver) {
        super(appResolver, "com.google.android.apps.maps", true);
        Intrinsics.f(appResolver, "appResolver");
        this.f21226h = true;
        this.f21227i = R.drawable.ic_navigation_google_maps;
        this.f21228j = Navigator.Type.GOOGLE_MAPS;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public int c() {
        return this.f21227i;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public int e() {
        return R.string.google_maps_v2;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public Navigator.Type getType() {
        return this.f21228j;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public boolean h() {
        return this.f21226h;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    protected Intent j(GeoCoordinate latLng) {
        Intrinsics.f(latLng, "latLng");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format(Locale.ENGLISH, "google.navigation:q=%f,%f", Arrays.copyOf(new Object[]{Double.valueOf(latLng.a()), Double.valueOf(latLng.b())}, 2));
        Intrinsics.e(format, "format(locale, format, *args)");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage("com.google.android.apps.maps");
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        return intent;
    }
}
