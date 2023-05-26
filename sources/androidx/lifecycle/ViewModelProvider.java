package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public class ViewModelProvider {

    /* renamed from: a  reason: collision with root package name */
    private final ViewModelStore f6792a;

    /* renamed from: b  reason: collision with root package name */
    private final Factory f6793b;

    /* renamed from: c  reason: collision with root package name */
    private final CreationExtras f6794c;

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public interface Factory {
        <T extends ViewModel> T create(Class<T> cls);

        <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras);
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class NewInstanceFactory implements Factory {

        /* renamed from: b  reason: collision with root package name */
        private static NewInstanceFactory f6801b;

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f6800a = new Companion(null);

        /* renamed from: c  reason: collision with root package name */
        public static final CreationExtras.Key<String> f6802c = Companion.ViewModelKeyImpl.f6803a;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: classes.dex */
        public static final class Companion {

            /* compiled from: ViewModelProvider.kt */
            /* loaded from: classes.dex */
            private static final class ViewModelKeyImpl implements CreationExtras.Key<String> {

                /* renamed from: a  reason: collision with root package name */
                public static final ViewModelKeyImpl f6803a = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final NewInstanceFactory a() {
                if (NewInstanceFactory.f6801b == null) {
                    NewInstanceFactory.f6801b = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory.f6801b;
                Intrinsics.c(newInstanceFactory);
                return newInstanceFactory;
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.f(modelClass, "modelClass");
            try {
                T newInstance = modelClass.newInstance();
                Intrinsics.e(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e8);
            } catch (InstantiationException e9) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e9);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return d.b(this, cls, creationExtras);
        }
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class OnRequeryFactory {
        public void a(ViewModel viewModel) {
            Intrinsics.f(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore store, Factory factory) {
        this(store, factory, null, 4, null);
        Intrinsics.f(store, "store");
        Intrinsics.f(factory, "factory");
    }

    public ViewModelProvider(ViewModelStore store, Factory factory, CreationExtras defaultCreationExtras) {
        Intrinsics.f(store, "store");
        Intrinsics.f(factory, "factory");
        Intrinsics.f(defaultCreationExtras, "defaultCreationExtras");
        this.f6792a = store;
        this.f6793b = factory;
        this.f6794c = defaultCreationExtras;
    }

    public <T extends ViewModel> T a(Class<T> modelClass) {
        Intrinsics.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends ViewModel> T b(String key, Class<T> modelClass) {
        T t7;
        OnRequeryFactory onRequeryFactory;
        Intrinsics.f(key, "key");
        Intrinsics.f(modelClass, "modelClass");
        T viewModel = (T) this.f6792a.b(key);
        if (modelClass.isInstance(viewModel)) {
            Factory factory = this.f6793b;
            if (factory instanceof OnRequeryFactory) {
                onRequeryFactory = (OnRequeryFactory) factory;
            } else {
                onRequeryFactory = null;
            }
            if (onRequeryFactory != null) {
                Intrinsics.e(viewModel, "viewModel");
                onRequeryFactory.a(viewModel);
            }
            if (viewModel != null) {
                return viewModel;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.f6794c);
        mutableCreationExtras.c(NewInstanceFactory.f6802c, key);
        try {
            t7 = (T) this.f6793b.create(modelClass, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t7 = (T) this.f6793b.create(modelClass);
        }
        this.f6792a.d(key, t7);
        return t7;
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {

        /* renamed from: f  reason: collision with root package name */
        private static AndroidViewModelFactory f6796f;

        /* renamed from: d  reason: collision with root package name */
        private final Application f6798d;

        /* renamed from: e  reason: collision with root package name */
        public static final Companion f6795e = new Companion(null);

        /* renamed from: g  reason: collision with root package name */
        public static final CreationExtras.Key<Application> f6797g = Companion.ApplicationKeyImpl.f6799a;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: classes.dex */
        public static final class Companion {

            /* compiled from: ViewModelProvider.kt */
            /* loaded from: classes.dex */
            private static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {

                /* renamed from: a  reason: collision with root package name */
                public static final ApplicationKeyImpl f6799a = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final AndroidViewModelFactory a(Application application) {
                Intrinsics.f(application, "application");
                if (AndroidViewModelFactory.f6796f == null) {
                    AndroidViewModelFactory.f6796f = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.f6796f;
                Intrinsics.c(androidViewModelFactory);
                return androidViewModelFactory;
            }
        }

        private AndroidViewModelFactory(Application application, int i8) {
            this.f6798d = application;
        }

        private final <T extends ViewModel> T e(Class<T> cls, Application application) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    T newInstance = cls.getConstructor(Application.class).newInstance(application);
                    Intrinsics.e(newInstance, "{\n                try {\n…          }\n            }");
                    return newInstance;
                } catch (IllegalAccessException e8) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e8);
                } catch (InstantiationException e9) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e9);
                } catch (NoSuchMethodException e10) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e10);
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e11);
                }
            }
            return (T) super.create(cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            Intrinsics.f(modelClass, "modelClass");
            Intrinsics.f(extras, "extras");
            if (this.f6798d != null) {
                return (T) create(modelClass);
            }
            Application application = (Application) extras.a(f6797g);
            if (application != null) {
                return (T) e(modelClass, application);
            }
            if (!AndroidViewModel.class.isAssignableFrom(modelClass)) {
                return (T) super.create(modelClass);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application) {
            this(application, 0);
            Intrinsics.f(application, "application");
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.f(modelClass, "modelClass");
            Application application = this.f6798d;
            if (application != null) {
                return (T) e(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, factory, (i8 & 4) != 0 ? CreationExtras.Empty.f6812b : creationExtras);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner r3, androidx.lifecycle.ViewModelProvider.Factory r4) {
        /*
            r2 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            androidx.lifecycle.ViewModelStore r0 = r3.getViewModelStore()
            java.lang.String r1 = "owner.viewModelStore"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            androidx.lifecycle.viewmodel.CreationExtras r3 = androidx.lifecycle.ViewModelProviderGetKt.a(r3)
            r2.<init>(r0, r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner, androidx.lifecycle.ViewModelProvider$Factory):void");
    }
}
