package ee.mtakso.driver.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.screens.launch.LauncherViewModel;

/* compiled from: ViewModelModule.kt */
@Module
/* loaded from: classes3.dex */
public interface ViewModelModule {
    @Binds
    ViewModelProvider.Factory a(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    ViewModel b(LauncherViewModel launcherViewModel);
}
