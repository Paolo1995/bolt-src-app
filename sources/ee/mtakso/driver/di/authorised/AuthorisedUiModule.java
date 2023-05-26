package ee.mtakso.driver.di.authorised;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.ViewModel;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.di.modules.ThemeModule;
import ee.mtakso.driver.ui.base.FragmentFactoryImpl;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import java.util.Map;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorisedUiModule.kt */
@Module(includes = {AuthorisedUiBindings.class, ThemeModule.class})
/* loaded from: classes3.dex */
public final class AuthorisedUiModule {
    @Provides
    public final FragmentFactory a(Map<Class<? extends Fragment>, Provider<Fragment>> fragmentFactories) {
        Intrinsics.f(fragmentFactories, "fragmentFactories");
        return new FragmentFactoryImpl(fragmentFactories);
    }

    @Provides
    public final ViewModelFactory b(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelFactories) {
        Intrinsics.f(viewModelFactories, "viewModelFactories");
        return new ViewModelFactory(viewModelFactories);
    }
}
