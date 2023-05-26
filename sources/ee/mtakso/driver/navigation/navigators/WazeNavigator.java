package ee.mtakso.driver.navigation.navigators;

import android.content.Intent;
import android.net.Uri;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import java.util.Arrays;
import java.util.Locale;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: WazeNavigator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class WazeNavigator extends ExternalNavigator {

    /* renamed from: h  reason: collision with root package name */
    private final boolean f21265h;

    /* renamed from: i  reason: collision with root package name */
    private final int f21266i;

    /* renamed from: j  reason: collision with root package name */
    private final Navigator.Type f21267j;

    /* JADX WARN: Illegal instructions before constructor call */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WazeNavigator(ee.mtakso.driver.platform.core.PlatformManager r3, ee.mtakso.driver.utils.AppResolver r4) {
        /*
            r2 = this;
            java.lang.String r0 = "platformManager"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "appResolver"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.util.List r0 = ee.mtakso.driver.navigation.navigators.WazeNavigatorKt.a()
            ee.mtakso.driver.platform.core.PlatformType r1 = r3.getType()
            boolean r0 = r0.contains(r1)
            java.lang.String r1 = "com.waze"
            r2.<init>(r4, r1, r0)
            java.util.List r4 = ee.mtakso.driver.navigation.navigators.WazeNavigatorKt.a()
            ee.mtakso.driver.platform.core.PlatformType r3 = r3.getType()
            boolean r3 = r4.contains(r3)
            r2.f21265h = r3
            r3 = 2131232114(0x7f080572, float:1.8080328E38)
            r2.f21266i = r3
            ee.mtakso.driver.navigation.navigators.Navigator$Type r3 = ee.mtakso.driver.navigation.navigators.Navigator.Type.WAZE
            r2.f21267j = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.navigation.navigators.WazeNavigator.<init>(ee.mtakso.driver.platform.core.PlatformManager, ee.mtakso.driver.utils.AppResolver):void");
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public int c() {
        return this.f21266i;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public int e() {
        return R.string.waze_v2;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public Navigator.Type getType() {
        return this.f21267j;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    public boolean h() {
        return this.f21265h;
    }

    @Override // ee.mtakso.driver.navigation.navigators.ExternalNavigator
    protected Intent j(GeoCoordinate latLng) {
        Intrinsics.f(latLng, "latLng");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format(Locale.ENGLISH, "waze://?ll=%f,%f&navigate=yes", Arrays.copyOf(new Object[]{Double.valueOf(latLng.a()), Double.valueOf(latLng.b())}, 2));
        Intrinsics.e(format, "format(locale, format, *args)");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage("com.waze");
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        return intent;
    }
}
