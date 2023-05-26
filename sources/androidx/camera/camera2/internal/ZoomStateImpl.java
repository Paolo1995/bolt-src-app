package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;

/* loaded from: classes.dex */
class ZoomStateImpl implements ZoomState {

    /* renamed from: a  reason: collision with root package name */
    private float f2725a;

    /* renamed from: b  reason: collision with root package name */
    private final float f2726b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2727c;

    /* renamed from: d  reason: collision with root package name */
    private float f2728d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoomStateImpl(float f8, float f9) {
        this.f2726b = f8;
        this.f2727c = f9;
    }

    private float e(float f8) {
        float f9 = this.f2726b;
        float f10 = this.f2727c;
        if (f9 == f10) {
            return 0.0f;
        }
        if (f8 == f9) {
            return 1.0f;
        }
        if (f8 == f10) {
            return 0.0f;
        }
        float f11 = 1.0f / f10;
        return ((1.0f / f8) - f11) / ((1.0f / f9) - f11);
    }

    @Override // androidx.camera.core.ZoomState
    public float a() {
        return this.f2726b;
    }

    @Override // androidx.camera.core.ZoomState
    public float b() {
        return this.f2728d;
    }

    @Override // androidx.camera.core.ZoomState
    public float c() {
        return this.f2727c;
    }

    @Override // androidx.camera.core.ZoomState
    public float d() {
        return this.f2725a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f8) throws IllegalArgumentException {
        if (f8 <= this.f2726b && f8 >= this.f2727c) {
            this.f2725a = f8;
            this.f2728d = e(f8);
            return;
        }
        throw new IllegalArgumentException("Requested zoomRatio " + f8 + " is not within valid range [" + this.f2727c + " , " + this.f2726b + "]");
    }
}
