package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class ImageWriterCompatApi26Impl {

    /* renamed from: a  reason: collision with root package name */
    private static Method f3925a;

    static {
        try {
            Class cls = Integer.TYPE;
            f3925a = ImageWriter.class.getMethod("newInstance", Surface.class, cls, cls);
        } catch (NoSuchMethodException e8) {
            Log.i("ImageWriterCompatApi26", "Unable to initialize via reflection.", e8);
        }
    }

    private ImageWriterCompatApi26Impl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static ImageWriter a(@NonNull Surface surface, int i8, int i9) {
        Throwable th = null;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return (ImageWriter) Preconditions.g(f3925a.invoke(null, surface, Integer.valueOf(i8), Integer.valueOf(i9)));
            } catch (IllegalAccessException | InvocationTargetException e8) {
                th = e8;
            }
        }
        throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", th);
    }
}
