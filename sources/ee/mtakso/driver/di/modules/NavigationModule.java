package ee.mtakso.driver.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ee.mtakso.driver.navigation.navigators.CityGuideNavigator;
import ee.mtakso.driver.navigation.navigators.MapsMeNavigator;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.navigation.navigators.NoDefaultNavigator;
import ee.mtakso.driver.navigation.navigators.TaxifyNavigator;
import ee.mtakso.driver.navigation.navigators.TwoGisNavigator;
import ee.mtakso.driver.navigation.navigators.YandexMapsNavigator;
import ee.mtakso.driver.navigation.navigators.YandexNavigationNavigator;

/* compiled from: NavigationModule.kt */
@Module
/* loaded from: classes3.dex */
public interface NavigationModule {
    @Binds
    @IntoMap
    Navigator a(YandexMapsNavigator yandexMapsNavigator);

    @Binds
    @IntoMap
    Navigator b(YandexNavigationNavigator yandexNavigationNavigator);

    @Binds
    @IntoMap
    Navigator c(CityGuideNavigator cityGuideNavigator);

    @Binds
    @IntoMap
    Navigator d(TwoGisNavigator twoGisNavigator);

    @Binds
    @IntoMap
    Navigator e(NoDefaultNavigator noDefaultNavigator);

    @Binds
    @IntoMap
    Navigator f(TaxifyNavigator taxifyNavigator);

    @Binds
    @IntoMap
    Navigator g(MapsMeNavigator mapsMeNavigator);
}
