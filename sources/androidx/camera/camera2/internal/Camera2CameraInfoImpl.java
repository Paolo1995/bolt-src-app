package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.CameraState;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CamcorderProfileProvider;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class Camera2CameraInfoImpl implements CameraInfoInternal {

    /* renamed from: a  reason: collision with root package name */
    private final String f2470a;

    /* renamed from: b  reason: collision with root package name */
    private final CameraCharacteristicsCompat f2471b;

    /* renamed from: c  reason: collision with root package name */
    private final Camera2CameraInfo f2472c;

    /* renamed from: e  reason: collision with root package name */
    private Camera2CameraControlImpl f2474e;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final RedirectableLiveData<CameraState> f2477h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final Quirks f2479j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final CamcorderProfileProvider f2480k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final CameraManagerCompat f2481l;

    /* renamed from: d  reason: collision with root package name */
    private final Object f2473d = new Object();

    /* renamed from: f  reason: collision with root package name */
    private RedirectableLiveData<Integer> f2475f = null;

    /* renamed from: g  reason: collision with root package name */
    private RedirectableLiveData<ZoomState> f2476g = null;

    /* renamed from: i  reason: collision with root package name */
    private List<Pair<CameraCaptureCallback, Executor>> f2478i = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RedirectableLiveData<T> extends MediatorLiveData<T> {

        /* renamed from: r  reason: collision with root package name */
        private LiveData<T> f2482r;

        /* renamed from: s  reason: collision with root package name */
        private final T f2483s;

        RedirectableLiveData(T t7) {
            this.f2483s = t7;
        }

        @Override // androidx.lifecycle.LiveData
        public T f() {
            LiveData<T> liveData = this.f2482r;
            if (liveData == null) {
                return this.f2483s;
            }
            return liveData.f();
        }

        @Override // androidx.lifecycle.MediatorLiveData
        public <S> void p(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void r(@NonNull LiveData<T> liveData) {
            LiveData liveData2 = (LiveData<T>) this.f2482r;
            if (liveData2 != null) {
                super.q(liveData2);
            }
            this.f2482r = liveData;
            super.p(liveData, new Observer() { // from class: androidx.camera.camera2.internal.a0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Camera2CameraInfoImpl.RedirectableLiveData.this.o(obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Camera2CameraInfoImpl(@NonNull String str, @NonNull CameraManagerCompat cameraManagerCompat) throws CameraAccessExceptionCompat {
        String str2 = (String) Preconditions.g(str);
        this.f2470a = str2;
        this.f2481l = cameraManagerCompat;
        CameraCharacteristicsCompat c8 = cameraManagerCompat.c(str2);
        this.f2471b = c8;
        this.f2472c = new Camera2CameraInfo(this);
        this.f2479j = CameraQuirks.a(str, c8);
        this.f2480k = new Camera2CamcorderProfileProvider(str, c8);
        this.f2477h = new RedirectableLiveData<>(CameraState.a(CameraState.Type.CLOSED));
    }

    private void l() {
        m();
    }

    private void m() {
        String str;
        int j8 = j();
        if (j8 != 0) {
            if (j8 != 1) {
                if (j8 != 2) {
                    if (j8 != 3) {
                        if (j8 != 4) {
                            str = "Unknown value: " + j8;
                        } else {
                            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
                        }
                    } else {
                        str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
                    }
                } else {
                    str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
                }
            } else {
                str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
            }
        } else {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        }
        Logger.e("Camera2CameraInfo", "Device Level: " + str);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    @NonNull
    public String a() {
        return this.f2470a;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void b(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback) {
        synchronized (this.f2473d) {
            Camera2CameraControlImpl camera2CameraControlImpl = this.f2474e;
            if (camera2CameraControlImpl == null) {
                if (this.f2478i == null) {
                    this.f2478i = new ArrayList();
                }
                this.f2478i.add(new Pair<>(cameraCaptureCallback, executor));
                return;
            }
            camera2CameraControlImpl.t(executor, cameraCaptureCallback);
        }
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Integer c() {
        Integer num = (Integer) this.f2471b.a(CameraCharacteristics.LENS_FACING);
        Preconditions.g(num);
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                return null;
            }
            return 1;
        }
        return 0;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    @NonNull
    public Quirks d() {
        return this.f2479j;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void e(@NonNull CameraCaptureCallback cameraCaptureCallback) {
        synchronized (this.f2473d) {
            Camera2CameraControlImpl camera2CameraControlImpl = this.f2474e;
            if (camera2CameraControlImpl == null) {
                List<Pair<CameraCaptureCallback, Executor>> list = this.f2478i;
                if (list == null) {
                    return;
                }
                Iterator<Pair<CameraCaptureCallback, Executor>> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().first == cameraCaptureCallback) {
                        it.remove();
                    }
                }
                return;
            }
            camera2CameraControlImpl.X(cameraCaptureCallback);
        }
    }

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    public String f() {
        if (j() == 2) {
            return "androidx.camera.camera2.legacy";
        }
        return "androidx.camera.camera2";
    }

    @Override // androidx.camera.core.CameraInfo
    public int g(int i8) {
        int i9 = i();
        int b8 = CameraOrientationUtil.b(i8);
        Integer c8 = c();
        boolean z7 = true;
        return CameraOrientationUtil.a(b8, i9, (c8 == null || 1 != c8.intValue()) ? false : false);
    }

    @NonNull
    public CameraCharacteristicsCompat h() {
        return this.f2471b;
    }

    int i() {
        Integer num = (Integer) this.f2471b.a(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.g(num);
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        Integer num = (Integer) this.f2471b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        Preconditions.g(num);
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@NonNull Camera2CameraControlImpl camera2CameraControlImpl) {
        synchronized (this.f2473d) {
            this.f2474e = camera2CameraControlImpl;
            RedirectableLiveData<ZoomState> redirectableLiveData = this.f2476g;
            if (redirectableLiveData != null) {
                redirectableLiveData.r(camera2CameraControlImpl.F().d());
            }
            RedirectableLiveData<Integer> redirectableLiveData2 = this.f2475f;
            if (redirectableLiveData2 != null) {
                redirectableLiveData2.r(this.f2474e.D().f());
            }
            List<Pair<CameraCaptureCallback, Executor>> list = this.f2478i;
            if (list != null) {
                for (Pair<CameraCaptureCallback, Executor> pair : list) {
                    this.f2474e.t((Executor) pair.second, (CameraCaptureCallback) pair.first);
                }
                this.f2478i = null;
            }
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(@NonNull LiveData<CameraState> liveData) {
        this.f2477h.r(liveData);
    }
}
