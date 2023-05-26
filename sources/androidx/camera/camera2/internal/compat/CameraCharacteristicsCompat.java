package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CameraCharacteristicsCompat {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<CameraCharacteristics.Key<?>, Object> f2766a = new HashMap();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final CameraCharacteristicsCompatImpl f2767b;

    /* loaded from: classes.dex */
    public interface CameraCharacteristicsCompatImpl {
        <T> T a(@NonNull CameraCharacteristics.Key<T> key);
    }

    private CameraCharacteristicsCompat(@NonNull CameraCharacteristics cameraCharacteristics) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2767b = new CameraCharacteristicsApi28Impl(cameraCharacteristics);
        } else {
            this.f2767b = new CameraCharacteristicsBaseImpl(cameraCharacteristics);
        }
    }

    private boolean b(@NonNull CameraCharacteristics.Key<?> key) {
        if (key.equals(CameraCharacteristics.SENSOR_ORIENTATION)) {
            return true;
        }
        return false;
    }

    @NonNull
    public static CameraCharacteristicsCompat c(@NonNull CameraCharacteristics cameraCharacteristics) {
        return new CameraCharacteristicsCompat(cameraCharacteristics);
    }

    public <T> T a(@NonNull CameraCharacteristics.Key<T> key) {
        if (b(key)) {
            return (T) this.f2767b.a(key);
        }
        synchronized (this) {
            T t7 = (T) this.f2766a.get(key);
            if (t7 != null) {
                return t7;
            }
            T t8 = (T) this.f2767b.a(key);
            if (t8 != null) {
                this.f2766a.put(key, t8);
            }
            return t8;
        }
    }
}
