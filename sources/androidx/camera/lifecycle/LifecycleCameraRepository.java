package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
final class LifecycleCameraRepository {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4059a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Key, LifecycleCamera> f4060b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<LifecycleCameraRepositoryObserver, Set<Key>> f4061c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<LifecycleOwner> f4062d = new ArrayDeque<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Key {
        static Key a(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraUseCaseAdapter.CameraId cameraId) {
            return new AutoValue_LifecycleCameraRepository_Key(lifecycleOwner, cameraId);
        }

        @NonNull
        public abstract CameraUseCaseAdapter.CameraId b();

        @NonNull
        public abstract LifecycleOwner c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LifecycleCameraRepositoryObserver implements LifecycleObserver {

        /* renamed from: f  reason: collision with root package name */
        private final LifecycleCameraRepository f4063f;

        /* renamed from: g  reason: collision with root package name */
        private final LifecycleOwner f4064g;

        LifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner, LifecycleCameraRepository lifecycleCameraRepository) {
            this.f4064g = lifecycleOwner;
            this.f4063f = lifecycleCameraRepository;
        }

        LifecycleOwner b() {
            return this.f4064g;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            this.f4063f.l(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart(LifecycleOwner lifecycleOwner) {
            this.f4063f.h(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop(LifecycleOwner lifecycleOwner) {
            this.f4063f.i(lifecycleOwner);
        }
    }

    private LifecycleCameraRepositoryObserver d(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4059a) {
            for (LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver : this.f4061c.keySet()) {
                if (lifecycleOwner.equals(lifecycleCameraRepositoryObserver.b())) {
                    return lifecycleCameraRepositoryObserver;
                }
            }
            return null;
        }
    }

    private boolean f(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4059a) {
            LifecycleCameraRepositoryObserver d8 = d(lifecycleOwner);
            if (d8 == null) {
                return false;
            }
            for (Key key : this.f4061c.get(d8)) {
                if (!((LifecycleCamera) Preconditions.g(this.f4060b.get(key))).o().isEmpty()) {
                    return true;
                }
            }
            return false;
        }
    }

    private void g(LifecycleCamera lifecycleCamera) {
        Set<Key> hashSet;
        synchronized (this.f4059a) {
            LifecycleOwner n8 = lifecycleCamera.n();
            Key a8 = Key.a(n8, lifecycleCamera.k().x());
            LifecycleCameraRepositoryObserver d8 = d(n8);
            if (d8 != null) {
                hashSet = this.f4061c.get(d8);
            } else {
                hashSet = new HashSet<>();
            }
            hashSet.add(a8);
            this.f4060b.put(a8, lifecycleCamera);
            if (d8 == null) {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = new LifecycleCameraRepositoryObserver(n8, this);
                this.f4061c.put(lifecycleCameraRepositoryObserver, hashSet);
                n8.getLifecycle().a(lifecycleCameraRepositoryObserver);
            }
        }
    }

    private void j(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4059a) {
            LifecycleCameraRepositoryObserver d8 = d(lifecycleOwner);
            if (d8 == null) {
                return;
            }
            for (Key key : this.f4061c.get(d8)) {
                ((LifecycleCamera) Preconditions.g(this.f4060b.get(key))).q();
            }
        }
    }

    private void m(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4059a) {
            for (Key key : this.f4061c.get(d(lifecycleOwner))) {
                LifecycleCamera lifecycleCamera = this.f4060b.get(key);
                if (!((LifecycleCamera) Preconditions.g(lifecycleCamera)).o().isEmpty()) {
                    lifecycleCamera.s();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull LifecycleCamera lifecycleCamera, ViewPort viewPort, @NonNull List<CameraEffect> list, @NonNull Collection<UseCase> collection) {
        boolean z7;
        synchronized (this.f4059a) {
            if (!collection.isEmpty()) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.a(z7);
            LifecycleOwner n8 = lifecycleCamera.n();
            for (Key key : this.f4061c.get(d(n8))) {
                LifecycleCamera lifecycleCamera2 = (LifecycleCamera) Preconditions.g(this.f4060b.get(key));
                if (!lifecycleCamera2.equals(lifecycleCamera) && !lifecycleCamera2.o().isEmpty()) {
                    throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                }
            }
            try {
                lifecycleCamera.k().K(viewPort);
                lifecycleCamera.k().J(list);
                lifecycleCamera.c(collection);
                if (n8.getLifecycle().b().a(Lifecycle.State.STARTED)) {
                    h(n8);
                }
            } catch (CameraUseCaseAdapter.CameraException e8) {
                throw new IllegalArgumentException(e8.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LifecycleCamera b(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraUseCaseAdapter cameraUseCaseAdapter) {
        boolean z7;
        LifecycleCamera lifecycleCamera;
        synchronized (this.f4059a) {
            if (this.f4060b.get(Key.a(lifecycleOwner, cameraUseCaseAdapter.x())) == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.b(z7, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
            if (lifecycleOwner.getLifecycle().b() != Lifecycle.State.DESTROYED) {
                lifecycleCamera = new LifecycleCamera(lifecycleOwner, cameraUseCaseAdapter);
                if (cameraUseCaseAdapter.z().isEmpty()) {
                    lifecycleCamera.q();
                }
                g(lifecycleCamera);
            } else {
                throw new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
            }
        }
        return lifecycleCamera;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LifecycleCamera c(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.f4059a) {
            lifecycleCamera = this.f4060b.get(Key.a(lifecycleOwner, cameraId));
        }
        return lifecycleCamera;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<LifecycleCamera> e() {
        Collection<LifecycleCamera> unmodifiableCollection;
        synchronized (this.f4059a) {
            unmodifiableCollection = Collections.unmodifiableCollection(this.f4060b.values());
        }
        return unmodifiableCollection;
    }

    void h(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4059a) {
            if (!f(lifecycleOwner)) {
                return;
            }
            if (this.f4062d.isEmpty()) {
                this.f4062d.push(lifecycleOwner);
            } else {
                LifecycleOwner peek = this.f4062d.peek();
                if (!lifecycleOwner.equals(peek)) {
                    j(peek);
                    this.f4062d.remove(lifecycleOwner);
                    this.f4062d.push(lifecycleOwner);
                }
            }
            m(lifecycleOwner);
        }
    }

    void i(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4059a) {
            this.f4062d.remove(lifecycleOwner);
            j(lifecycleOwner);
            if (!this.f4062d.isEmpty()) {
                m(this.f4062d.peek());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        synchronized (this.f4059a) {
            for (Key key : this.f4060b.keySet()) {
                LifecycleCamera lifecycleCamera = this.f4060b.get(key);
                lifecycleCamera.r();
                i(lifecycleCamera.n());
            }
        }
    }

    void l(LifecycleOwner lifecycleOwner) {
        synchronized (this.f4059a) {
            LifecycleCameraRepositoryObserver d8 = d(lifecycleOwner);
            if (d8 == null) {
                return;
            }
            i(lifecycleOwner);
            for (Key key : this.f4061c.get(d8)) {
                this.f4060b.remove(key);
            }
            this.f4061c.remove(d8);
            d8.b().getLifecycle().c(d8);
        }
    }
}
