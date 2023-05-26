package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.d;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoaderManagerImpl extends LoaderManager {

    /* renamed from: c  reason: collision with root package name */
    static boolean f6818c = false;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleOwner f6819a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final LoaderViewModel f6820b;

    /* loaded from: classes.dex */
    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        /* renamed from: q  reason: collision with root package name */
        private final int f6821q;

        /* renamed from: r  reason: collision with root package name */
        private final Bundle f6822r;
        @NonNull

        /* renamed from: s  reason: collision with root package name */
        private final Loader<D> f6823s;

        /* renamed from: t  reason: collision with root package name */
        private LifecycleOwner f6824t;

        /* renamed from: u  reason: collision with root package name */
        private LoaderObserver<D> f6825u;

        /* renamed from: v  reason: collision with root package name */
        private Loader<D> f6826v;

        LoaderInfo(int i8, Bundle bundle, @NonNull Loader<D> loader, Loader<D> loader2) {
            this.f6821q = i8;
            this.f6822r = bundle;
            this.f6823s = loader;
            this.f6826v = loader2;
            loader.registerListener(i8, this);
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void a(@NonNull Loader<D> loader, D d8) {
            if (LoaderManagerImpl.f6818c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                o(d8);
                return;
            }
            if (LoaderManagerImpl.f6818c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            m(d8);
        }

        @Override // androidx.lifecycle.LiveData
        protected void k() {
            if (LoaderManagerImpl.f6818c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f6823s.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        protected void l() {
            if (LoaderManagerImpl.f6818c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f6823s.stopLoading();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void n(@NonNull Observer<? super D> observer) {
            super.n(observer);
            this.f6824t = null;
            this.f6825u = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void o(D d8) {
            super.o(d8);
            Loader<D> loader = this.f6826v;
            if (loader != null) {
                loader.reset();
                this.f6826v = null;
            }
        }

        Loader<D> p(boolean z7) {
            if (LoaderManagerImpl.f6818c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f6823s.cancelLoad();
            this.f6823s.abandon();
            LoaderObserver<D> loaderObserver = this.f6825u;
            if (loaderObserver != null) {
                n(loaderObserver);
                if (z7) {
                    loaderObserver.c();
                }
            }
            this.f6823s.unregisterListener(this);
            if ((loaderObserver != null && !loaderObserver.b()) || z7) {
                this.f6823s.reset();
                return this.f6826v;
            }
            return this.f6823s;
        }

        public void q(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f6821q);
            printWriter.print(" mArgs=");
            printWriter.println(this.f6822r);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f6823s);
            Loader<D> loader = this.f6823s;
            loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f6825u != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f6825u);
                LoaderObserver<D> loaderObserver = this.f6825u;
                loaderObserver.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(r().dataToString(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        @NonNull
        Loader<D> r() {
            return this.f6823s;
        }

        void s() {
            LifecycleOwner lifecycleOwner = this.f6824t;
            LoaderObserver<D> loaderObserver = this.f6825u;
            if (lifecycleOwner != null && loaderObserver != null) {
                super.n(loaderObserver);
                i(lifecycleOwner, loaderObserver);
            }
        }

        @NonNull
        Loader<D> t(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.f6823s, loaderCallbacks);
            i(lifecycleOwner, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.f6825u;
            if (loaderObserver2 != null) {
                n(loaderObserver2);
            }
            this.f6824t = lifecycleOwner;
            this.f6825u = loaderObserver;
            return this.f6823s;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f6821q);
            sb.append(" : ");
            DebugUtils.a(this.f6823s, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LoaderObserver<D> implements Observer<D> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Loader<D> f6827a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final LoaderManager.LoaderCallbacks<D> f6828b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6829c = false;

        LoaderObserver(@NonNull Loader<D> loader, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.f6827a = loader;
            this.f6828b = loaderCallbacks;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f6829c);
        }

        boolean b() {
            return this.f6829c;
        }

        void c() {
            if (this.f6829c) {
                if (LoaderManagerImpl.f6818c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f6827a);
                }
                this.f6828b.onLoaderReset(this.f6827a);
            }
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(D d8) {
            if (LoaderManagerImpl.f6818c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f6827a + ": " + this.f6827a.dataToString(d8));
            }
            this.f6828b.onLoadFinished(this.f6827a, d8);
            this.f6829c = true;
        }

        public String toString() {
            return this.f6828b.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LoaderViewModel extends ViewModel {

        /* renamed from: c  reason: collision with root package name */
        private static final ViewModelProvider.Factory f6830c = new ViewModelProvider.Factory() { // from class: androidx.loader.app.LoaderManagerImpl.LoaderViewModel.1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                return new LoaderViewModel();
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return d.b(this, cls, creationExtras);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private SparseArrayCompat<LoaderInfo> f6831a = new SparseArrayCompat<>();

        /* renamed from: b  reason: collision with root package name */
        private boolean f6832b = false;

        LoaderViewModel() {
        }

        @NonNull
        static LoaderViewModel c(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, f6830c).a(LoaderViewModel.class);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f6831a.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i8 = 0; i8 < this.f6831a.k(); i8++) {
                    LoaderInfo l8 = this.f6831a.l(i8);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f6831a.i(i8));
                    printWriter.print(": ");
                    printWriter.println(l8.toString());
                    l8.q(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void b() {
            this.f6832b = false;
        }

        <D> LoaderInfo<D> d(int i8) {
            return this.f6831a.e(i8);
        }

        boolean e() {
            return this.f6832b;
        }

        void f() {
            int k8 = this.f6831a.k();
            for (int i8 = 0; i8 < k8; i8++) {
                this.f6831a.l(i8).s();
            }
        }

        void g(int i8, @NonNull LoaderInfo loaderInfo) {
            this.f6831a.j(i8, loaderInfo);
        }

        void h() {
            this.f6832b = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int k8 = this.f6831a.k();
            for (int i8 = 0; i8 < k8; i8++) {
                this.f6831a.l(i8).p(true);
            }
            this.f6831a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoaderManagerImpl(@NonNull LifecycleOwner lifecycleOwner, @NonNull ViewModelStore viewModelStore) {
        this.f6819a = lifecycleOwner;
        this.f6820b = LoaderViewModel.c(viewModelStore);
    }

    @NonNull
    private <D> Loader<D> e(int i8, Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks, Loader<D> loader) {
        try {
            this.f6820b.h();
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i8, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                }
                LoaderInfo loaderInfo = new LoaderInfo(i8, bundle, onCreateLoader, loader);
                if (f6818c) {
                    Log.v("LoaderManager", "  Created new loader " + loaderInfo);
                }
                this.f6820b.g(i8, loaderInfo);
                this.f6820b.b();
                return loaderInfo.t(this.f6819a, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f6820b.b();
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f6820b.a(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    public <D> Loader<D> c(int i8, Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (!this.f6820b.e()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                LoaderInfo<D> d8 = this.f6820b.d(i8);
                if (f6818c) {
                    Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
                }
                if (d8 == null) {
                    return e(i8, bundle, loaderCallbacks, null);
                }
                if (f6818c) {
                    Log.v("LoaderManager", "  Re-using existing loader " + d8);
                }
                return d8.t(this.f6819a, loaderCallbacks);
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public void d() {
        this.f6820b.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.a(this.f6819a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
