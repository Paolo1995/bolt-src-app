package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class BundleCompat {

    /* loaded from: classes.dex */
    static class Api18Impl {
        private Api18Impl() {
        }

        static IBinder a(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        static void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }

    private BundleCompat() {
    }

    public static void a(@NonNull Bundle bundle, String str, IBinder iBinder) {
        Api18Impl.b(bundle, str, iBinder);
    }
}
