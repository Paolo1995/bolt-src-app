package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseDeferrableSurface;
import androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SynchronizedCaptureSessionOpener {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final OpenerImpl f2700a;

    /* loaded from: classes.dex */
    static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f2701a;

        /* renamed from: b  reason: collision with root package name */
        private final ScheduledExecutorService f2702b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f2703c;

        /* renamed from: d  reason: collision with root package name */
        private final CaptureSessionRepository f2704d;

        /* renamed from: e  reason: collision with root package name */
        private final Quirks f2705e;

        /* renamed from: f  reason: collision with root package name */
        private final Quirks f2706f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f2707g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler, @NonNull CaptureSessionRepository captureSessionRepository, @NonNull Quirks quirks, @NonNull Quirks quirks2) {
            boolean z7;
            this.f2701a = executor;
            this.f2702b = scheduledExecutorService;
            this.f2703c = handler;
            this.f2704d = captureSessionRepository;
            this.f2705e = quirks;
            this.f2706f = quirks2;
            if (!new ForceCloseDeferrableSurface(quirks, quirks2).b() && !new WaitForRepeatingRequestStart(quirks).i() && !new ForceCloseCaptureSession(quirks2).d()) {
                z7 = false;
            } else {
                z7 = true;
            }
            this.f2707g = z7;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public SynchronizedCaptureSessionOpener a() {
            OpenerImpl synchronizedCaptureSessionBaseImpl;
            if (this.f2707g) {
                synchronizedCaptureSessionBaseImpl = new SynchronizedCaptureSessionImpl(this.f2705e, this.f2706f, this.f2704d, this.f2701a, this.f2702b, this.f2703c);
            } else {
                synchronizedCaptureSessionBaseImpl = new SynchronizedCaptureSessionBaseImpl(this.f2704d, this.f2701a, this.f2702b, this.f2703c);
            }
            return new SynchronizedCaptureSessionOpener(synchronizedCaptureSessionBaseImpl);
        }
    }

    /* loaded from: classes.dex */
    interface OpenerImpl {
        @NonNull
        ListenableFuture<Void> a(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat, @NonNull List<DeferrableSurface> list);

        @NonNull
        SessionConfigurationCompat g(int i8, @NonNull List<OutputConfigurationCompat> list, @NonNull SynchronizedCaptureSession.StateCallback stateCallback);

        @NonNull
        Executor getExecutor();

        @NonNull
        ListenableFuture<List<Surface>> h(@NonNull List<DeferrableSurface> list, long j8);

        boolean stop();
    }

    SynchronizedCaptureSessionOpener(@NonNull OpenerImpl openerImpl) {
        this.f2700a = openerImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public SessionConfigurationCompat a(int i8, @NonNull List<OutputConfigurationCompat> list, @NonNull SynchronizedCaptureSession.StateCallback stateCallback) {
        return this.f2700a.g(i8, list, stateCallback);
    }

    @NonNull
    public Executor b() {
        return this.f2700a.getExecutor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ListenableFuture<Void> c(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat, @NonNull List<DeferrableSurface> list) {
        return this.f2700a.a(cameraDevice, sessionConfigurationCompat, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ListenableFuture<List<Surface>> d(@NonNull List<DeferrableSurface> list, long j8) {
        return this.f2700a.h(list, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f2700a.stop();
    }
}
