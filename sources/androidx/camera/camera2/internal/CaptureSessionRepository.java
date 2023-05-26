package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CaptureSessionRepository {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final Executor f2573a;

    /* renamed from: b  reason: collision with root package name */
    final Object f2574b = new Object();

    /* renamed from: c  reason: collision with root package name */
    final Set<SynchronizedCaptureSession> f2575c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    final Set<SynchronizedCaptureSession> f2576d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    final Set<SynchronizedCaptureSession> f2577e = new LinkedHashSet();

    /* renamed from: f  reason: collision with root package name */
    private final CameraDevice.StateCallback f2578f = new AnonymousClass1();

    /* renamed from: androidx.camera.camera2.internal.CaptureSessionRepository$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends CameraDevice.StateCallback {
        AnonymousClass1() {
        }

        private void b() {
            List<SynchronizedCaptureSession> g8;
            synchronized (CaptureSessionRepository.this.f2574b) {
                g8 = CaptureSessionRepository.this.g();
                CaptureSessionRepository.this.f2577e.clear();
                CaptureSessionRepository.this.f2575c.clear();
                CaptureSessionRepository.this.f2576d.clear();
            }
            for (SynchronizedCaptureSession synchronizedCaptureSession : g8) {
                synchronizedCaptureSession.c();
            }
        }

        private void c() {
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            synchronized (CaptureSessionRepository.this.f2574b) {
                linkedHashSet.addAll(CaptureSessionRepository.this.f2577e);
                linkedHashSet.addAll(CaptureSessionRepository.this.f2575c);
            }
            CaptureSessionRepository.this.f2573a.execute(new Runnable() { // from class: androidx.camera.camera2.internal.t0
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureSessionRepository.b(linkedHashSet);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull CameraDevice cameraDevice) {
            b();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            c();
            b();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i8) {
            c();
            b();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CaptureSessionRepository(@NonNull Executor executor) {
        this.f2573a = executor;
    }

    private void a(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        SynchronizedCaptureSession next;
        Iterator<SynchronizedCaptureSession> it = g().iterator();
        while (it.hasNext() && (next = it.next()) != synchronizedCaptureSession) {
            next.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.b().o(synchronizedCaptureSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CameraDevice.StateCallback c() {
        return this.f2578f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<SynchronizedCaptureSession> d() {
        ArrayList arrayList;
        synchronized (this.f2574b) {
            arrayList = new ArrayList(this.f2575c);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<SynchronizedCaptureSession> e() {
        ArrayList arrayList;
        synchronized (this.f2574b) {
            arrayList = new ArrayList(this.f2576d);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<SynchronizedCaptureSession> f() {
        ArrayList arrayList;
        synchronized (this.f2574b) {
            arrayList = new ArrayList(this.f2577e);
        }
        return arrayList;
    }

    @NonNull
    List<SynchronizedCaptureSession> g() {
        ArrayList arrayList;
        synchronized (this.f2574b) {
            arrayList = new ArrayList();
            arrayList.addAll(d());
            arrayList.addAll(f());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f2574b) {
            this.f2575c.remove(synchronizedCaptureSession);
            this.f2576d.remove(synchronizedCaptureSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f2574b) {
            this.f2576d.add(synchronizedCaptureSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        a(synchronizedCaptureSession);
        synchronized (this.f2574b) {
            this.f2577e.remove(synchronizedCaptureSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f2574b) {
            this.f2575c.add(synchronizedCaptureSession);
            this.f2577e.remove(synchronizedCaptureSession);
        }
        a(synchronizedCaptureSession);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f2574b) {
            this.f2577e.add(synchronizedCaptureSession);
        }
    }
}
