package androidx.camera.lifecycle;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class LifecycleCamera implements LifecycleObserver, Camera {

    /* renamed from: g  reason: collision with root package name */
    private final LifecycleOwner f4054g;

    /* renamed from: h  reason: collision with root package name */
    private final CameraUseCaseAdapter f4055h;

    /* renamed from: f  reason: collision with root package name */
    private final Object f4053f = new Object();

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f4056i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4057j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4058k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter) {
        this.f4054g = lifecycleOwner;
        this.f4055h = cameraUseCaseAdapter;
        if (lifecycleOwner.getLifecycle().b().a(Lifecycle.State.STARTED)) {
            cameraUseCaseAdapter.n();
        } else {
            cameraUseCaseAdapter.v();
        }
        lifecycleOwner.getLifecycle().a(this);
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraControl b() {
        return this.f4055h.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Collection<UseCase> collection) throws CameraUseCaseAdapter.CameraException {
        synchronized (this.f4053f) {
            this.f4055h.k(collection);
        }
    }

    @NonNull
    public CameraInfo g() {
        return this.f4055h.g();
    }

    public CameraUseCaseAdapter k() {
        return this.f4055h;
    }

    public void l(CameraConfig cameraConfig) {
        this.f4055h.l(cameraConfig);
    }

    public LifecycleOwner n() {
        LifecycleOwner lifecycleOwner;
        synchronized (this.f4053f) {
            lifecycleOwner = this.f4054g;
        }
        return lifecycleOwner;
    }

    @NonNull
    public List<UseCase> o() {
        List<UseCase> unmodifiableList;
        synchronized (this.f4053f) {
            unmodifiableList = Collections.unmodifiableList(this.f4055h.z());
        }
        return unmodifiableList;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4053f) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.f4055h;
            cameraUseCaseAdapter.H(cameraUseCaseAdapter.z());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(LifecycleOwner lifecycleOwner) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f4055h.f(false);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(LifecycleOwner lifecycleOwner) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f4055h.f(true);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4053f) {
            if (!this.f4057j && !this.f4058k) {
                this.f4055h.n();
                this.f4056i = true;
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4053f) {
            if (!this.f4057j && !this.f4058k) {
                this.f4055h.v();
                this.f4056i = false;
            }
        }
    }

    public boolean p(@NonNull UseCase useCase) {
        boolean contains;
        synchronized (this.f4053f) {
            contains = this.f4055h.z().contains(useCase);
        }
        return contains;
    }

    public void q() {
        synchronized (this.f4053f) {
            if (this.f4057j) {
                return;
            }
            onStop(this.f4054g);
            this.f4057j = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        synchronized (this.f4053f) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.f4055h;
            cameraUseCaseAdapter.H(cameraUseCaseAdapter.z());
        }
    }

    public void s() {
        synchronized (this.f4053f) {
            if (!this.f4057j) {
                return;
            }
            this.f4057j = false;
            if (this.f4054g.getLifecycle().b().a(Lifecycle.State.STARTED)) {
                onStart(this.f4054g);
            }
        }
    }
}
