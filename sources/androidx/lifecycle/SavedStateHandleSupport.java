package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleSupport {

    /* renamed from: a  reason: collision with root package name */
    public static final CreationExtras.Key<SavedStateRegistryOwner> f6758a = new CreationExtras.Key<SavedStateRegistryOwner>() { // from class: androidx.lifecycle.SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1
    };

    /* renamed from: b  reason: collision with root package name */
    public static final CreationExtras.Key<ViewModelStoreOwner> f6759b = new CreationExtras.Key<ViewModelStoreOwner>() { // from class: androidx.lifecycle.SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1
    };

    /* renamed from: c  reason: collision with root package name */
    public static final CreationExtras.Key<Bundle> f6760c = new CreationExtras.Key<Bundle>() { // from class: androidx.lifecycle.SavedStateHandleSupport$DEFAULT_ARGS_KEY$1
    };

    public static final SavedStateHandle a(CreationExtras creationExtras) {
        Intrinsics.f(creationExtras, "<this>");
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) creationExtras.a(f6758a);
        if (savedStateRegistryOwner != null) {
            ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) creationExtras.a(f6759b);
            if (viewModelStoreOwner != null) {
                Bundle bundle = (Bundle) creationExtras.a(f6760c);
                String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.f6802c);
                if (str != null) {
                    return b(savedStateRegistryOwner, viewModelStoreOwner, str, bundle);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    private static final SavedStateHandle b(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, String str, Bundle bundle) {
        SavedStateHandlesProvider d8 = d(savedStateRegistryOwner);
        SavedStateHandlesVM e8 = e(viewModelStoreOwner);
        SavedStateHandle savedStateHandle = e8.a().get(str);
        if (savedStateHandle == null) {
            SavedStateHandle a8 = SavedStateHandle.f6747f.a(d8.a(str), bundle);
            e8.a().put(str, a8);
            return a8;
        }
        return savedStateHandle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void c(T t7) {
        boolean z7;
        Intrinsics.f(t7, "<this>");
        Lifecycle.State b8 = t7.getLifecycle().b();
        Intrinsics.e(b8, "lifecycle.currentState");
        if (b8 != Lifecycle.State.INITIALIZED && b8 != Lifecycle.State.CREATED) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            if (t7.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
                SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t7.getSavedStateRegistry(), t7);
                t7.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
                t7.getLifecycle().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final SavedStateHandlesProvider d(SavedStateRegistryOwner savedStateRegistryOwner) {
        SavedStateHandlesProvider savedStateHandlesProvider;
        Intrinsics.f(savedStateRegistryOwner, "<this>");
        SavedStateRegistry.SavedStateProvider c8 = savedStateRegistryOwner.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        if (c8 instanceof SavedStateHandlesProvider) {
            savedStateHandlesProvider = (SavedStateHandlesProvider) c8;
        } else {
            savedStateHandlesProvider = null;
        }
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final SavedStateHandlesVM e(ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.f(viewModelStoreOwner, "<this>");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.a(Reflection.b(SavedStateHandlesVM.class), new Function1<CreationExtras, SavedStateHandlesVM>() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SavedStateHandlesVM invoke(CreationExtras initializer) {
                Intrinsics.f(initializer, "$this$initializer");
                return new SavedStateHandlesVM();
            }
        });
        return (SavedStateHandlesVM) new ViewModelProvider(viewModelStoreOwner, initializerViewModelFactoryBuilder.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", SavedStateHandlesVM.class);
    }
}
