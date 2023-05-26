package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;

/* loaded from: classes.dex */
public final class Camera2ImplConfig extends CaptureRequestOptions {
    public static final Config.Option<Integer> B = Config.Option.a("camera2.captureRequest.templateType", Integer.TYPE);
    public static final Config.Option<Long> C = Config.Option.a("camera2.cameraCaptureSession.streamUseCase", Long.TYPE);
    public static final Config.Option<CameraDevice.StateCallback> D = Config.Option.a("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);
    public static final Config.Option<CameraCaptureSession.StateCallback> E = Config.Option.a("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);
    public static final Config.Option<CameraCaptureSession.CaptureCallback> F = Config.Option.a("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);
    public static final Config.Option<CameraEventCallbacks> G = Config.Option.a("camera2.cameraEvent.callback", CameraEventCallbacks.class);
    public static final Config.Option<Object> H = Config.Option.a("camera2.captureRequest.tag", Object.class);
    public static final Config.Option<String> I = Config.Option.a("camera2.cameraCaptureSession.physicalCameraId", String.class);

    /* loaded from: classes.dex */
    public static final class Builder implements ExtendableBuilder<Camera2ImplConfig> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableOptionsBundle f2371a = MutableOptionsBundle.L();

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public MutableConfig a() {
            return this.f2371a;
        }

        @NonNull
        public Camera2ImplConfig c() {
            return new Camera2ImplConfig(OptionsBundle.J(this.f2371a));
        }

        @NonNull
        public Builder d(@NonNull Config config) {
            for (Config.Option<?> option : config.c()) {
                this.f2371a.o(option, config.a(option));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public <ValueT> Builder e(@NonNull CaptureRequest.Key<ValueT> key, @NonNull ValueT valuet) {
            this.f2371a.o(Camera2ImplConfig.H(key), valuet);
            return this;
        }
    }

    public Camera2ImplConfig(@NonNull Config config) {
        super(config);
    }

    @NonNull
    public static Config.Option<Object> H(@NonNull CaptureRequest.Key<?> key) {
        return Config.Option.b("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }

    public CameraEventCallbacks I(CameraEventCallbacks cameraEventCallbacks) {
        return (CameraEventCallbacks) d().e(G, cameraEventCallbacks);
    }

    @NonNull
    public CaptureRequestOptions J() {
        return CaptureRequestOptions.Builder.e(d()).d();
    }

    public Object K(Object obj) {
        return d().e(H, obj);
    }

    public int L(int i8) {
        return ((Integer) d().e(B, Integer.valueOf(i8))).intValue();
    }

    public CameraDevice.StateCallback M(CameraDevice.StateCallback stateCallback) {
        return (CameraDevice.StateCallback) d().e(D, stateCallback);
    }

    public String N(String str) {
        return (String) d().e(I, str);
    }

    public CameraCaptureSession.CaptureCallback O(CameraCaptureSession.CaptureCallback captureCallback) {
        return (CameraCaptureSession.CaptureCallback) d().e(F, captureCallback);
    }

    public CameraCaptureSession.StateCallback P(CameraCaptureSession.StateCallback stateCallback) {
        return (CameraCaptureSession.StateCallback) d().e(E, stateCallback);
    }

    public long Q(long j8) {
        return ((Long) d().e(C, Long.valueOf(j8))).longValue();
    }
}
