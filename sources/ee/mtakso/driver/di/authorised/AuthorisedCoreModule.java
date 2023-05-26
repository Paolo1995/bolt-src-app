package ee.mtakso.driver.di.authorised;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.language.LanguageListProviderImpl;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.language.LanguageManager;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.ThemeManager;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import eu.bolt.driver.core.ui.theme.DriverThemeProvider;
import eu.bolt.driver.core.ui.theme.ThemeProvider;
import eu.bolt.driver.core.ui.translation.v2.TranslationHelper;
import java.util.Map;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorisedCoreModule.kt */
@Module
/* loaded from: classes3.dex */
public final class AuthorisedCoreModule {
    @Provides
    public final BaseFragmentParams a(PermissionManager permissionManager) {
        Intrinsics.f(permissionManager, "permissionManager");
        return new BaseFragmentParams(permissionManager);
    }

    @Provides
    public final CoreFragmentFactory b(Map<Class<? extends Fragment>, Provider<Fragment>> fragmentFactories) {
        Intrinsics.f(fragmentFactories, "fragmentFactories");
        return new CoreFragmentFactory(fragmentFactories);
    }

    @Provides
    public final LanguageManager c(DriverProvider driverProvider, Context context, LanguageListProviderImpl languageProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(context, "context");
        Intrinsics.f(languageProvider, "languageProvider");
        return new LanguageManager(driverProvider.v().w(), context, languageProvider.a(), languageProvider.b());
    }

    @Provides
    public final ThemeManager d(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        return new ThemeManager(driverProvider.v().d(), driverProvider.q().q());
    }

    @Provides
    public final ThemeProvider e(DriverThemeProvider driverThemeProvider) {
        Intrinsics.f(driverThemeProvider, "driverThemeProvider");
        return driverThemeProvider;
    }

    @Provides
    public final TranslationHelper f() {
        return new TranslationHelper(true);
    }

    @Provides
    public final ViewModelFactory g(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelFactories) {
        Intrinsics.f(viewModelFactories, "viewModelFactories");
        return new ViewModelFactory(viewModelFactories);
    }
}
