package androidx.camera.camera2.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MultiValueSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class CameraEventCallbacks extends MultiValueSet<CameraEventCallback> {

    /* loaded from: classes.dex */
    public static final class ComboCameraEventCallback {

        /* renamed from: a  reason: collision with root package name */
        private final List<CameraEventCallback> f2372a = new ArrayList();

        ComboCameraEventCallback(List<CameraEventCallback> list) {
            for (CameraEventCallback cameraEventCallback : list) {
                this.f2372a.add(cameraEventCallback);
            }
        }

        public void a() {
            for (CameraEventCallback cameraEventCallback : this.f2372a) {
                cameraEventCallback.a();
            }
        }

        @NonNull
        public List<CaptureConfig> b() {
            ArrayList arrayList = new ArrayList();
            for (CameraEventCallback cameraEventCallback : this.f2372a) {
                CaptureConfig b8 = cameraEventCallback.b();
                if (b8 != null) {
                    arrayList.add(b8);
                }
            }
            return arrayList;
        }

        @NonNull
        public List<CaptureConfig> c() {
            ArrayList arrayList = new ArrayList();
            for (CameraEventCallback cameraEventCallback : this.f2372a) {
                CaptureConfig c8 = cameraEventCallback.c();
                if (c8 != null) {
                    arrayList.add(c8);
                }
            }
            return arrayList;
        }

        @NonNull
        public List<CaptureConfig> d() {
            ArrayList arrayList = new ArrayList();
            for (CameraEventCallback cameraEventCallback : this.f2372a) {
                CaptureConfig d8 = cameraEventCallback.d();
                if (d8 != null) {
                    arrayList.add(d8);
                }
            }
            return arrayList;
        }

        @NonNull
        public List<CaptureConfig> e() {
            ArrayList arrayList = new ArrayList();
            for (CameraEventCallback cameraEventCallback : this.f2372a) {
                CaptureConfig e8 = cameraEventCallback.e();
                if (e8 != null) {
                    arrayList.add(e8);
                }
            }
            return arrayList;
        }
    }

    public CameraEventCallbacks(@NonNull CameraEventCallback... cameraEventCallbackArr) {
        a(Arrays.asList(cameraEventCallbackArr));
    }

    @NonNull
    public static CameraEventCallbacks e() {
        return new CameraEventCallbacks(new CameraEventCallback[0]);
    }

    @Override // androidx.camera.core.impl.MultiValueSet
    @NonNull
    /* renamed from: b */
    public MultiValueSet<CameraEventCallback> clone() {
        CameraEventCallbacks e8 = e();
        e8.a(c());
        return e8;
    }

    @NonNull
    public ComboCameraEventCallback d() {
        return new ComboCameraEventCallback(c());
    }
}
