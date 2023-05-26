package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;

/* compiled from: CameraManagerCompat.java */
/* loaded from: classes.dex */
public final /* synthetic */ class v {
    @NonNull
    public static CameraManagerCompat.CameraManagerCompatImpl a(@NonNull Context context, @NonNull Handler handler) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            return new CameraManagerCompatApi29Impl(context);
        }
        if (i8 >= 28) {
            return CameraManagerCompatApi28Impl.g(context);
        }
        return CameraManagerCompatBaseImpl.f(context, handler);
    }
}
