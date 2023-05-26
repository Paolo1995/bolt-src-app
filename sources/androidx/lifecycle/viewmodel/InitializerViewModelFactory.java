package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.d;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final ViewModelInitializer<?>[] f6813a;

    public InitializerViewModelFactory(ViewModelInitializer<?>... initializers) {
        Intrinsics.f(initializers, "initializers");
        this.f6813a = initializers;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(Class cls) {
        return d.a(this, cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        ViewModelInitializer<?>[] viewModelInitializerArr;
        Intrinsics.f(modelClass, "modelClass");
        Intrinsics.f(extras, "extras");
        T t7 = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.f6813a) {
            if (Intrinsics.a(viewModelInitializer.a(), modelClass)) {
                Object invoke = viewModelInitializer.b().invoke(extras);
                t7 = invoke instanceof ViewModel ? (T) invoke : null;
            }
        }
        if (t7 != null) {
            return t7;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
