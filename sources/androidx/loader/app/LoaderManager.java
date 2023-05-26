package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class LoaderManager {

    /* loaded from: classes.dex */
    public interface LoaderCallbacks<D> {
        @NonNull
        Loader<D> onCreateLoader(int i8, Bundle bundle);

        void onLoadFinished(@NonNull Loader<D> loader, D d8);

        void onLoaderReset(@NonNull Loader<D> loader);
    }

    @NonNull
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager b(@NonNull T t7) {
        return new LoaderManagerImpl(t7, t7.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract <D> Loader<D> c(int i8, Bundle bundle, @NonNull LoaderCallbacks<D> loaderCallbacks);

    public abstract void d();
}
