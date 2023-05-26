package ee.mtakso.driver.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.maps.core.MapProvider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PlatformModule_ProvideGoogleMapsV2ProviderFactory implements Factory<MapProvider> {
    public static MapProvider a(PlatformModule platformModule, Context context) {
        return (MapProvider) Preconditions.checkNotNullFromProvides(platformModule.a(context));
    }
}
