package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class AppLocalesMetadataHolderService extends Service {

    /* loaded from: classes.dex */
    private static class Api24Impl {
        private Api24Impl() {
        }

        static int a() {
            return 512;
        }
    }

    @NonNull
    public static ServiceInfo a(@NonNull Context context) throws PackageManager.NameNotFoundException {
        int i8;
        if (Build.VERSION.SDK_INT >= 24) {
            i8 = Api24Impl.a() | 128;
        } else {
            i8 = 640;
        }
        return context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), i8);
    }

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@NonNull Intent intent) {
        throw new UnsupportedOperationException();
    }
}
