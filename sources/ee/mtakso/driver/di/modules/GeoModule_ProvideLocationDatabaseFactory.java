package ee.mtakso.driver.di.modules;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.storage.db.LocationDatabase;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GeoModule_ProvideLocationDatabaseFactory implements Factory<LocationDatabase> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f20752a;

    public GeoModule_ProvideLocationDatabaseFactory(Provider<Context> provider) {
        this.f20752a = provider;
    }

    public static GeoModule_ProvideLocationDatabaseFactory a(Provider<Context> provider) {
        return new GeoModule_ProvideLocationDatabaseFactory(provider);
    }

    public static LocationDatabase c(Context context) {
        return (LocationDatabase) Preconditions.checkNotNullFromProvides(GeoModule.e(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocationDatabase get() {
        return c(this.f20752a.get());
    }
}
