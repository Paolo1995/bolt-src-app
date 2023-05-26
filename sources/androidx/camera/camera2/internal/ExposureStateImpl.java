package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;

/* loaded from: classes.dex */
class ExposureStateImpl {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2596a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final CameraCharacteristicsCompat f2597b;

    /* renamed from: c  reason: collision with root package name */
    private int f2598c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExposureStateImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat, int i8) {
        this.f2597b = cameraCharacteristicsCompat;
        this.f2598c = i8;
    }

    public int a() {
        int i8;
        synchronized (this.f2596a) {
            i8 = this.f2598c;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i8) {
        synchronized (this.f2596a) {
            this.f2598c = i8;
        }
    }
}
