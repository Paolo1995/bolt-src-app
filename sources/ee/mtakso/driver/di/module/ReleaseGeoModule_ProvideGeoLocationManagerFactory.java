package ee.mtakso.driver.di.module;

import android.content.Context;
import android.content.pm.PackageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.geo.GeoLocationSource;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.mock.ReleaseMockChecker;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReleaseGeoModule_ProvideGeoLocationManagerFactory implements Factory<GeoLocationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final ReleaseGeoModule f20735a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<GeoLocationSource> f20736b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Context> f20737c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AnchoredTrueTimeProvider> f20738d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ReleaseMockChecker> f20739e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PackageManager> f20740f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<PermissionManager> f20741g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<EnvironmentDataProvider> f20742h;

    public ReleaseGeoModule_ProvideGeoLocationManagerFactory(ReleaseGeoModule releaseGeoModule, Provider<GeoLocationSource> provider, Provider<Context> provider2, Provider<AnchoredTrueTimeProvider> provider3, Provider<ReleaseMockChecker> provider4, Provider<PackageManager> provider5, Provider<PermissionManager> provider6, Provider<EnvironmentDataProvider> provider7) {
        this.f20735a = releaseGeoModule;
        this.f20736b = provider;
        this.f20737c = provider2;
        this.f20738d = provider3;
        this.f20739e = provider4;
        this.f20740f = provider5;
        this.f20741g = provider6;
        this.f20742h = provider7;
    }

    public static ReleaseGeoModule_ProvideGeoLocationManagerFactory a(ReleaseGeoModule releaseGeoModule, Provider<GeoLocationSource> provider, Provider<Context> provider2, Provider<AnchoredTrueTimeProvider> provider3, Provider<ReleaseMockChecker> provider4, Provider<PackageManager> provider5, Provider<PermissionManager> provider6, Provider<EnvironmentDataProvider> provider7) {
        return new ReleaseGeoModule_ProvideGeoLocationManagerFactory(releaseGeoModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static GeoLocationManager c(ReleaseGeoModule releaseGeoModule, GeoLocationSource geoLocationSource, Context context, AnchoredTrueTimeProvider anchoredTrueTimeProvider, ReleaseMockChecker releaseMockChecker, PackageManager packageManager, PermissionManager permissionManager, EnvironmentDataProvider environmentDataProvider) {
        return (GeoLocationManager) Preconditions.checkNotNullFromProvides(releaseGeoModule.a(geoLocationSource, context, anchoredTrueTimeProvider, releaseMockChecker, packageManager, permissionManager, environmentDataProvider));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GeoLocationManager get() {
        return c(this.f20735a, this.f20736b.get(), this.f20737c.get(), this.f20738d.get(), this.f20739e.get(), this.f20740f.get(), this.f20741g.get(), this.f20742h.get());
    }
}
