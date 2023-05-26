package ee.mtakso.driver.di;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ee.mtakso.driver.navigation.navigators.GoogleMapsNavigator;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.navigation.navigators.WazeNavigator;
import ee.mtakso.driver.platform.google.network.store_integrity.PlayStoreVerificationResultToRequestMapper;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultToRequestMapper;

/* compiled from: PlatformModule.kt */
@Module
/* loaded from: classes3.dex */
public interface PlatformBindings {
    @Binds
    StoreIntegrityVerificationResultToRequestMapper a(PlayStoreVerificationResultToRequestMapper playStoreVerificationResultToRequestMapper);

    @Binds
    @IntoMap
    Navigator b(GoogleMapsNavigator googleMapsNavigator);

    @Binds
    @IntoMap
    Navigator c(WazeNavigator wazeNavigator);
}
