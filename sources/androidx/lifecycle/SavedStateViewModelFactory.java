package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedStateViewModelFactory.kt */
/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    private Application f6768a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewModelProvider.Factory f6769b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f6770c;

    /* renamed from: d  reason: collision with root package name */
    private Lifecycle f6771d;

    /* renamed from: e  reason: collision with root package name */
    private SavedStateRegistry f6772e;

    public SavedStateViewModelFactory() {
        this.f6769b = new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public void a(ViewModel viewModel) {
        Intrinsics.f(viewModel, "viewModel");
        Lifecycle lifecycle = this.f6771d;
        if (lifecycle != null) {
            LegacySavedStateHandleController.a(viewModel, this.f6772e, lifecycle);
        }
    }

    public final <T extends ViewModel> T b(String key, Class<T> modelClass) {
        List list;
        Constructor c8;
        T t7;
        Application application;
        List list2;
        Intrinsics.f(key, "key");
        Intrinsics.f(modelClass, "modelClass");
        if (this.f6771d != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
            if (!isAssignableFrom || this.f6768a == null) {
                list = SavedStateViewModelFactoryKt.f6774b;
                c8 = SavedStateViewModelFactoryKt.c(modelClass, list);
            } else {
                list2 = SavedStateViewModelFactoryKt.f6773a;
                c8 = SavedStateViewModelFactoryKt.c(modelClass, list2);
            }
            if (c8 == null) {
                if (this.f6768a != null) {
                    return (T) this.f6769b.create(modelClass);
                }
                return (T) ViewModelProvider.NewInstanceFactory.f6800a.a().create(modelClass);
            }
            SavedStateHandleController b8 = LegacySavedStateHandleController.b(this.f6772e, this.f6771d, key, this.f6770c);
            if (isAssignableFrom && (application = this.f6768a) != null) {
                Intrinsics.c(application);
                SavedStateHandle c9 = b8.c();
                Intrinsics.e(c9, "controller.handle");
                t7 = (T) SavedStateViewModelFactoryKt.d(modelClass, c8, application, c9);
            } else {
                SavedStateHandle c10 = b8.c();
                Intrinsics.e(c10, "controller.handle");
                t7 = (T) SavedStateViewModelFactoryKt.d(modelClass, c8, c10);
            }
            t7.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", b8);
            return t7;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        List list;
        Constructor c8;
        List list2;
        Intrinsics.f(modelClass, "modelClass");
        Intrinsics.f(extras, "extras");
        String str = (String) extras.a(ViewModelProvider.NewInstanceFactory.f6802c);
        if (str != null) {
            if (extras.a(SavedStateHandleSupport.f6758a) != null && extras.a(SavedStateHandleSupport.f6759b) != null) {
                Application application = (Application) extras.a(ViewModelProvider.AndroidViewModelFactory.f6797g);
                boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
                if (!isAssignableFrom || application == null) {
                    list = SavedStateViewModelFactoryKt.f6774b;
                    c8 = SavedStateViewModelFactoryKt.c(modelClass, list);
                } else {
                    list2 = SavedStateViewModelFactoryKt.f6773a;
                    c8 = SavedStateViewModelFactoryKt.c(modelClass, list2);
                }
                if (c8 == null) {
                    return (T) this.f6769b.create(modelClass, extras);
                }
                return (!isAssignableFrom || application == null) ? (T) SavedStateViewModelFactoryKt.d(modelClass, c8, SavedStateHandleSupport.a(extras)) : (T) SavedStateViewModelFactoryKt.d(modelClass, c8, application, SavedStateHandleSupport.a(extras));
            } else if (this.f6771d != null) {
                return (T) b(str, modelClass);
            } else {
                throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            }
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner owner, Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        Intrinsics.f(owner, "owner");
        this.f6772e = owner.getSavedStateRegistry();
        this.f6771d = owner.getLifecycle();
        this.f6770c = bundle;
        this.f6768a = application;
        if (application != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.f6795e.a(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.f6769b = androidViewModelFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) b(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
