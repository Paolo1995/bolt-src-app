package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class CameraAccessExceptionCompat extends Exception {

    /* renamed from: h  reason: collision with root package name */
    static final Set<Integer> f2753h = Collections.unmodifiableSet(new HashSet(Arrays.asList(4, 5, 1, 2, 3)));

    /* renamed from: i  reason: collision with root package name */
    static final Set<Integer> f2754i = Collections.unmodifiableSet(new HashSet(Arrays.asList(10001, 10002)));

    /* renamed from: f  reason: collision with root package name */
    private final int f2755f;

    /* renamed from: g  reason: collision with root package name */
    private final CameraAccessException f2756g;

    public CameraAccessExceptionCompat(int i8, String str, Throwable th) {
        super(a(i8, str), th);
        this.f2755f = i8;
        this.f2756g = f2753h.contains(Integer.valueOf(i8)) ? new CameraAccessException(i8, str, th) : null;
    }

    private static String a(int i8, String str) {
        return String.format("%s (%d): %s", c(i8), Integer.valueOf(i8), str);
    }

    private static String b(int i8) {
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 != 5) {
                            if (i8 != 10001) {
                                if (i8 != 10002) {
                                    return null;
                                }
                                return "Failed to create CameraCharacteristics.";
                            }
                            return "Some API 28 devices cannot access the camera when the device is in \"Do Not Disturb\" mode. The camera will not be accessible until \"Do Not Disturb\" mode is disabled.";
                        }
                        return "The system-wide limit for number of open cameras has been reached, and more camera devices cannot be opened until previous instances are closed.";
                    }
                    return "The camera device is in use already";
                }
                return "The camera device is currently in the error state; no further calls to it will succeed.";
            }
            return "The camera device is removable and has been disconnected from the Android device, or the camera service has shut down the connection due to a higher-priority access request for the camera device.";
        }
        return "The camera is disabled due to a device policy, and cannot be opened.";
    }

    @NonNull
    private static String c(int i8) {
        return i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? i8 != 1000 ? i8 != 10001 ? i8 != 10002 ? "<UNKNOWN ERROR>" : "CAMERA_CHARACTERISTICS_CREATION_ERROR" : "CAMERA_UNAVAILABLE_DO_NOT_DISTURB" : "CAMERA_DEPRECATED_HAL" : "MAX_CAMERAS_IN_USE" : "CAMERA_IN_USE" : "CAMERA_ERROR" : "CAMERA_DISCONNECTED" : "CAMERA_DISABLED";
    }

    @NonNull
    public static CameraAccessExceptionCompat e(@NonNull CameraAccessException cameraAccessException) {
        if (cameraAccessException != null) {
            return new CameraAccessExceptionCompat(cameraAccessException);
        }
        throw new NullPointerException("cameraAccessException should not be null");
    }

    public final int d() {
        return this.f2755f;
    }

    public CameraAccessExceptionCompat(int i8, Throwable th) {
        super(b(i8), th);
        this.f2755f = i8;
        this.f2756g = f2753h.contains(Integer.valueOf(i8)) ? new CameraAccessException(i8, null, th) : null;
    }

    private CameraAccessExceptionCompat(@NonNull CameraAccessException cameraAccessException) {
        super(cameraAccessException.getMessage(), cameraAccessException.getCause());
        this.f2755f = cameraAccessException.getReason();
        this.f2756g = cameraAccessException;
    }
}
