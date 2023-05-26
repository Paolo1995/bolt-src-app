package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class CameraStateRegistry {

    /* renamed from: c  reason: collision with root package name */
    private final int f3607c;

    /* renamed from: e  reason: collision with root package name */
    private int f3609e;

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f3605a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private final Object f3606b = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Camera, CameraRegistration> f3608d = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CameraRegistration {

        /* renamed from: a  reason: collision with root package name */
        private CameraInternal.State f3610a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f3611b;

        /* renamed from: c  reason: collision with root package name */
        private final OnOpenAvailableListener f3612c;

        CameraRegistration(CameraInternal.State state, @NonNull Executor executor, @NonNull OnOpenAvailableListener onOpenAvailableListener) {
            this.f3610a = state;
            this.f3611b = executor;
            this.f3612c = onOpenAvailableListener;
        }

        CameraInternal.State a() {
            return this.f3610a;
        }

        void b() {
            try {
                Executor executor = this.f3611b;
                final OnOpenAvailableListener onOpenAvailableListener = this.f3612c;
                Objects.requireNonNull(onOpenAvailableListener);
                executor.execute(new Runnable() { // from class: androidx.camera.core.impl.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraStateRegistry.OnOpenAvailableListener.this.a();
                    }
                });
            } catch (RejectedExecutionException e8) {
                Logger.d("CameraStateRegistry", "Unable to notify camera.", e8);
            }
        }

        CameraInternal.State c(CameraInternal.State state) {
            CameraInternal.State state2 = this.f3610a;
            this.f3610a = state;
            return state2;
        }
    }

    /* loaded from: classes.dex */
    public interface OnOpenAvailableListener {
        void a();
    }

    public CameraStateRegistry(int i8) {
        this.f3607c = i8;
        synchronized ("mLock") {
            this.f3609e = i8;
        }
    }

    private static boolean b(CameraInternal.State state) {
        if (state != null && state.a()) {
            return true;
        }
        return false;
    }

    private void d() {
        String str;
        if (Logger.f("CameraStateRegistry")) {
            this.f3605a.setLength(0);
            this.f3605a.append("Recalculating open cameras:\n");
            this.f3605a.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            this.f3605a.append("-------------------------------------------------------------------\n");
        }
        int i8 = 0;
        for (Map.Entry<Camera, CameraRegistration> entry : this.f3608d.entrySet()) {
            if (Logger.f("CameraStateRegistry")) {
                if (entry.getValue().a() != null) {
                    str = entry.getValue().a().toString();
                } else {
                    str = "UNKNOWN";
                }
                this.f3605a.append(String.format(Locale.US, "%-45s%-22s\n", entry.getKey().toString(), str));
            }
            if (b(entry.getValue().a())) {
                i8++;
            }
        }
        if (Logger.f("CameraStateRegistry")) {
            this.f3605a.append("-------------------------------------------------------------------\n");
            this.f3605a.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", Integer.valueOf(i8), Integer.valueOf(this.f3607c)));
            Logger.a("CameraStateRegistry", this.f3605a.toString());
        }
        this.f3609e = Math.max(this.f3607c - i8, 0);
    }

    private CameraInternal.State g(Camera camera) {
        CameraRegistration remove = this.f3608d.remove(camera);
        if (remove != null) {
            d();
            return remove.a();
        }
        return null;
    }

    private CameraInternal.State h(@NonNull Camera camera, @NonNull CameraInternal.State state) {
        boolean z7;
        CameraInternal.State c8 = ((CameraRegistration) Preconditions.h(this.f3608d.get(camera), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).c(state);
        CameraInternal.State state2 = CameraInternal.State.OPENING;
        if (state == state2) {
            if (!b(state) && c8 != state2) {
                z7 = false;
            } else {
                z7 = true;
            }
            Preconditions.j(z7, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
        }
        if (c8 != state) {
            d();
        }
        return c8;
    }

    public boolean a() {
        synchronized (this.f3606b) {
            for (Map.Entry<Camera, CameraRegistration> entry : this.f3608d.entrySet()) {
                if (entry.getValue().a() == CameraInternal.State.CLOSING) {
                    return true;
                }
            }
            return false;
        }
    }

    public void c(@NonNull Camera camera, @NonNull CameraInternal.State state, boolean z7) {
        CameraInternal.State h8;
        HashMap hashMap;
        synchronized (this.f3606b) {
            int i8 = this.f3609e;
            if (state == CameraInternal.State.RELEASED) {
                h8 = g(camera);
            } else {
                h8 = h(camera, state);
            }
            if (h8 == state) {
                return;
            }
            if (i8 < 1 && this.f3609e > 0) {
                hashMap = new HashMap();
                for (Map.Entry<Camera, CameraRegistration> entry : this.f3608d.entrySet()) {
                    if (entry.getValue().a() == CameraInternal.State.PENDING_OPEN) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            } else if (state == CameraInternal.State.PENDING_OPEN && this.f3609e > 0) {
                hashMap = new HashMap();
                hashMap.put(camera, this.f3608d.get(camera));
            } else {
                hashMap = null;
            }
            if (hashMap != null && !z7) {
                hashMap.remove(camera);
            }
            if (hashMap != null) {
                for (CameraRegistration cameraRegistration : hashMap.values()) {
                    cameraRegistration.b();
                }
            }
        }
    }

    public void e(@NonNull Camera camera, @NonNull Executor executor, @NonNull OnOpenAvailableListener onOpenAvailableListener) {
        boolean z7;
        synchronized (this.f3606b) {
            if (!this.f3608d.containsKey(camera)) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "Camera is already registered: " + camera);
            this.f3608d.put(camera, new CameraRegistration(null, executor, onOpenAvailableListener));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071 A[Catch: all -> 0x009b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x001d, B:7:0x0052, B:9:0x0056, B:14:0x0069, B:16:0x0071, B:20:0x0080, B:22:0x0096, B:23:0x0099, B:13:0x0063), top: B:28:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096 A[Catch: all -> 0x009b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x001d, B:7:0x0052, B:9:0x0056, B:14:0x0069, B:16:0x0071, B:20:0x0080, B:22:0x0096, B:23:0x0099, B:13:0x0063), top: B:28:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean f(@androidx.annotation.NonNull androidx.camera.core.Camera r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f3606b
            monitor-enter(r0)
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r1 = r9.f3608d     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r1 = r1.get(r10)     // Catch: java.lang.Throwable -> L9b
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = "Camera must first be registered with registerCamera()"
            java.lang.Object r1 = androidx.core.util.Preconditions.h(r1, r2)     // Catch: java.lang.Throwable -> L9b
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = "CameraStateRegistry"
            boolean r2 = androidx.camera.core.Logger.f(r2)     // Catch: java.lang.Throwable -> L9b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L52
            java.lang.StringBuilder r2 = r9.f3605a     // Catch: java.lang.Throwable -> L9b
            r2.setLength(r4)     // Catch: java.lang.Throwable -> L9b
            java.lang.StringBuilder r2 = r9.f3605a     // Catch: java.lang.Throwable -> L9b
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L9b
            java.lang.String r6 = "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]"
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L9b
            r7[r4] = r10     // Catch: java.lang.Throwable -> L9b
            int r10 = r9.f3609e     // Catch: java.lang.Throwable -> L9b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L9b
            r7[r3] = r10     // Catch: java.lang.Throwable -> L9b
            r10 = 2
            androidx.camera.core.impl.CameraInternal$State r8 = r1.a()     // Catch: java.lang.Throwable -> L9b
            boolean r8 = b(r8)     // Catch: java.lang.Throwable -> L9b
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L9b
            r7[r10] = r8     // Catch: java.lang.Throwable -> L9b
            r10 = 3
            androidx.camera.core.impl.CameraInternal$State r8 = r1.a()     // Catch: java.lang.Throwable -> L9b
            r7[r10] = r8     // Catch: java.lang.Throwable -> L9b
            java.lang.String r10 = java.lang.String.format(r5, r6, r7)     // Catch: java.lang.Throwable -> L9b
            r2.append(r10)     // Catch: java.lang.Throwable -> L9b
        L52:
            int r10 = r9.f3609e     // Catch: java.lang.Throwable -> L9b
            if (r10 > 0) goto L63
            androidx.camera.core.impl.CameraInternal$State r10 = r1.a()     // Catch: java.lang.Throwable -> L9b
            boolean r10 = b(r10)     // Catch: java.lang.Throwable -> L9b
            if (r10 == 0) goto L61
            goto L63
        L61:
            r10 = 0
            goto L69
        L63:
            androidx.camera.core.impl.CameraInternal$State r10 = androidx.camera.core.impl.CameraInternal.State.OPENING     // Catch: java.lang.Throwable -> L9b
            r1.c(r10)     // Catch: java.lang.Throwable -> L9b
            r10 = 1
        L69:
            java.lang.String r1 = "CameraStateRegistry"
            boolean r1 = androidx.camera.core.Logger.f(r1)     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto L94
            java.lang.StringBuilder r1 = r9.f3605a     // Catch: java.lang.Throwable -> L9b
            java.util.Locale r2 = java.util.Locale.US     // Catch: java.lang.Throwable -> L9b
            java.lang.String r5 = " --> %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9b
            if (r10 == 0) goto L7e
            java.lang.String r6 = "SUCCESS"
            goto L80
        L7e:
            java.lang.String r6 = "FAIL"
        L80:
            r3[r4] = r6     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = java.lang.String.format(r2, r5, r3)     // Catch: java.lang.Throwable -> L9b
            r1.append(r2)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = "CameraStateRegistry"
            java.lang.StringBuilder r2 = r9.f3605a     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9b
            androidx.camera.core.Logger.a(r1, r2)     // Catch: java.lang.Throwable -> L9b
        L94:
            if (r10 == 0) goto L99
            r9.d()     // Catch: java.lang.Throwable -> L9b
        L99:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r10
        L9b:
            r10 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.f(androidx.camera.core.Camera):boolean");
    }
}
