package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import java.nio.BufferUnderflowException;

/* loaded from: classes.dex */
public class Camera2CameraCaptureResult implements CameraCaptureResult {

    /* renamed from: a  reason: collision with root package name */
    private final TagBundle f2386a;

    /* renamed from: b  reason: collision with root package name */
    private final CaptureResult f2387b;

    public Camera2CameraCaptureResult(@NonNull TagBundle tagBundle, @NonNull CaptureResult captureResult) {
        this.f2386a = tagBundle;
        this.f2387b = captureResult;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public void a(@NonNull ExifData.Builder builder) {
        Integer num;
        androidx.camera.core.impl.a.a(this, builder);
        Rect rect = (Rect) this.f2387b.get(CaptureResult.SCALER_CROP_REGION);
        if (rect != null) {
            builder.j(rect.width()).i(rect.height());
        }
        try {
            Integer num2 = (Integer) this.f2387b.get(CaptureResult.JPEG_ORIENTATION);
            if (num2 != null) {
                builder.m(num2.intValue());
            }
        } catch (BufferUnderflowException unused) {
            Logger.k("C2CameraCaptureResult", "Failed to get JPEG orientation.");
        }
        Long l8 = (Long) this.f2387b.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l8 != null) {
            builder.f(l8.longValue());
        }
        Float f8 = (Float) this.f2387b.get(CaptureResult.LENS_APERTURE);
        if (f8 != null) {
            builder.l(f8.floatValue());
        }
        Integer num3 = (Integer) this.f2387b.get(CaptureResult.SENSOR_SENSITIVITY);
        if (num3 != null) {
            if (Build.VERSION.SDK_INT >= 24 && (num = (Integer) this.f2387b.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)) != null) {
                num3 = Integer.valueOf(num3.intValue() * ((int) (num.intValue() / 100.0f)));
            }
            builder.k(num3.intValue());
        }
        Float f9 = (Float) this.f2387b.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f9 != null) {
            builder.h(f9.floatValue());
        }
        Integer num4 = (Integer) this.f2387b.get(CaptureResult.CONTROL_AWB_MODE);
        if (num4 != null) {
            ExifData.WhiteBalanceMode whiteBalanceMode = ExifData.WhiteBalanceMode.AUTO;
            if (num4.intValue() == 0) {
                whiteBalanceMode = ExifData.WhiteBalanceMode.MANUAL;
            }
            builder.n(whiteBalanceMode);
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public TagBundle b() {
        return this.f2386a;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData$FlashState c() {
        Integer num = (Integer) this.f2387b.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return CameraCaptureMetaData$FlashState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0 && intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3 && intValue != 4) {
                    Logger.c("C2CameraCaptureResult", "Undefined flash state: " + num);
                    return CameraCaptureMetaData$FlashState.UNKNOWN;
                }
                return CameraCaptureMetaData$FlashState.FIRED;
            }
            return CameraCaptureMetaData$FlashState.READY;
        }
        return CameraCaptureMetaData$FlashState.NONE;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long d() {
        Long l8 = (Long) this.f2387b.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l8 == null) {
            return -1L;
        }
        return l8.longValue();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CaptureResult e() {
        return this.f2387b;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData$AfState f() {
        Integer num = (Integer) this.f2387b.get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AfState.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData$AfState.INACTIVE;
            case 1:
            case 3:
                return CameraCaptureMetaData$AfState.SCANNING;
            case 2:
                return CameraCaptureMetaData$AfState.PASSIVE_FOCUSED;
            case 4:
                return CameraCaptureMetaData$AfState.LOCKED_FOCUSED;
            case 5:
                return CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED;
            case 6:
                return CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED;
            default:
                Logger.c("C2CameraCaptureResult", "Undefined af state: " + num);
                return CameraCaptureMetaData$AfState.UNKNOWN;
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData$AwbState g() {
        Integer num = (Integer) this.f2387b.get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AwbState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        Logger.c("C2CameraCaptureResult", "Undefined awb state: " + num);
                        return CameraCaptureMetaData$AwbState.UNKNOWN;
                    }
                    return CameraCaptureMetaData$AwbState.LOCKED;
                }
                return CameraCaptureMetaData$AwbState.CONVERGED;
            }
            return CameraCaptureMetaData$AwbState.METERING;
        }
        return CameraCaptureMetaData$AwbState.INACTIVE;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData$AeState h() {
        Integer num = (Integer) this.f2387b.get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AeState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        if (intValue != 4) {
                            if (intValue != 5) {
                                Logger.c("C2CameraCaptureResult", "Undefined ae state: " + num);
                                return CameraCaptureMetaData$AeState.UNKNOWN;
                            }
                        } else {
                            return CameraCaptureMetaData$AeState.FLASH_REQUIRED;
                        }
                    } else {
                        return CameraCaptureMetaData$AeState.LOCKED;
                    }
                } else {
                    return CameraCaptureMetaData$AeState.CONVERGED;
                }
            }
            return CameraCaptureMetaData$AeState.SEARCHING;
        }
        return CameraCaptureMetaData$AeState.INACTIVE;
    }

    @NonNull
    public CameraCaptureMetaData$AfMode i() {
        Integer num = (Integer) this.f2387b.get(CaptureResult.CONTROL_AF_MODE);
        if (num == null) {
            return CameraCaptureMetaData$AfMode.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue != 1 && intValue != 2) {
                if (intValue != 3 && intValue != 4) {
                    if (intValue != 5) {
                        Logger.c("C2CameraCaptureResult", "Undefined af mode: " + num);
                        return CameraCaptureMetaData$AfMode.UNKNOWN;
                    }
                } else {
                    return CameraCaptureMetaData$AfMode.ON_CONTINUOUS_AUTO;
                }
            } else {
                return CameraCaptureMetaData$AfMode.ON_MANUAL_AUTO;
            }
        }
        return CameraCaptureMetaData$AfMode.OFF;
    }

    public Camera2CameraCaptureResult(@NonNull CaptureResult captureResult) {
        this(TagBundle.a(), captureResult);
    }
}
