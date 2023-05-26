package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class Camera2CaptureRequestBuilder {

    /* loaded from: classes.dex */
    static class Api23Impl {
        private Api23Impl() {
        }

        static CaptureRequest.Builder a(@NonNull CameraDevice cameraDevice, @NonNull TotalCaptureResult totalCaptureResult) throws CameraAccessException {
            CaptureRequest.Builder createReprocessCaptureRequest;
            createReprocessCaptureRequest = cameraDevice.createReprocessCaptureRequest(totalCaptureResult);
            return createReprocessCaptureRequest;
        }
    }

    private Camera2CaptureRequestBuilder() {
    }

    private static void a(CaptureRequest.Builder builder, Config config) {
        CaptureRequestOptions d8 = CaptureRequestOptions.Builder.e(config).d();
        for (Config.Option option : d8.c()) {
            CaptureRequest.Key key = (CaptureRequest.Key) option.d();
            try {
                builder.set(key, d8.a(option));
            } catch (IllegalArgumentException unused) {
                Logger.c("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    public static CaptureRequest b(@NonNull CaptureConfig captureConfig, CameraDevice cameraDevice, @NonNull Map<DeferrableSurface, Surface> map) throws CameraAccessException {
        CaptureRequest.Builder createCaptureRequest;
        if (cameraDevice == null) {
            return null;
        }
        List<Surface> d8 = d(captureConfig.e(), map);
        if (d8.isEmpty()) {
            return null;
        }
        CameraCaptureResult c8 = captureConfig.c();
        if (Build.VERSION.SDK_INT >= 23 && captureConfig.g() == 5 && c8 != null && (c8.e() instanceof TotalCaptureResult)) {
            Logger.a("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
            createCaptureRequest = Api23Impl.a(cameraDevice, (TotalCaptureResult) c8.e());
        } else {
            Logger.a("Camera2CaptureRequestBuilder", "createCaptureRequest");
            createCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.g());
        }
        a(createCaptureRequest, captureConfig.d());
        Config d9 = captureConfig.d();
        Config.Option<Integer> option = CaptureConfig.f3613h;
        if (d9.b(option)) {
            createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) captureConfig.d().a(option));
        }
        Config d10 = captureConfig.d();
        Config.Option<Integer> option2 = CaptureConfig.f3614i;
        if (d10.b(option2)) {
            createCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) captureConfig.d().a(option2)).byteValue()));
        }
        for (Surface surface : d8) {
            createCaptureRequest.addTarget(surface);
        }
        createCaptureRequest.setTag(captureConfig.f());
        return createCaptureRequest.build();
    }

    public static CaptureRequest c(@NonNull CaptureConfig captureConfig, CameraDevice cameraDevice) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.g());
        a(createCaptureRequest, captureConfig.d());
        return createCaptureRequest.build();
    }

    @NonNull
    private static List<Surface> d(List<DeferrableSurface> list, Map<DeferrableSurface, Surface> map) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface deferrableSurface : list) {
            Surface surface = map.get(deferrableSurface);
            if (surface != null) {
                arrayList.add(surface);
            } else {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
        }
        return arrayList;
    }
}
