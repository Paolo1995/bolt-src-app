package ee.mtakso.driver.ui.base.mvvm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.d;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModelFactory.kt */
/* loaded from: classes3.dex */
public final class ViewModelFactory implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> f26293a;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelFactories) {
        Intrinsics.f(viewModelFactories, "viewModelFactories");
        this.f26293a = viewModelFactories;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.f(modelClass, "modelClass");
        Provider<ViewModel> provider = this.f26293a.get(modelClass);
        if (provider != null) {
            ViewModel viewModel = provider.get();
            Intrinsics.d(viewModel, "null cannot be cast to non-null type T of ee.mtakso.driver.ui.base.mvvm.ViewModelFactory.create");
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown view  model class " + modelClass);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return d.b(this, cls, creationExtras);
    }
}
