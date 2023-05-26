package androidx.camera.core.internal;

/* loaded from: classes.dex */
final class AutoValue_ImmutableZoomState extends ImmutableZoomState {

    /* renamed from: a  reason: collision with root package name */
    private final float f3887a;

    /* renamed from: b  reason: collision with root package name */
    private final float f3888b;

    /* renamed from: c  reason: collision with root package name */
    private final float f3889c;

    /* renamed from: d  reason: collision with root package name */
    private final float f3890d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableZoomState(float f8, float f9, float f10, float f11) {
        this.f3887a = f8;
        this.f3888b = f9;
        this.f3889c = f10;
        this.f3890d = f11;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float a() {
        return this.f3888b;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float b() {
        return this.f3890d;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float c() {
        return this.f3889c;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float d() {
        return this.f3887a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableZoomState)) {
            return false;
        }
        ImmutableZoomState immutableZoomState = (ImmutableZoomState) obj;
        if (Float.floatToIntBits(this.f3887a) == Float.floatToIntBits(immutableZoomState.d()) && Float.floatToIntBits(this.f3888b) == Float.floatToIntBits(immutableZoomState.a()) && Float.floatToIntBits(this.f3889c) == Float.floatToIntBits(immutableZoomState.c()) && Float.floatToIntBits(this.f3890d) == Float.floatToIntBits(immutableZoomState.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.f3887a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.f3888b)) * 1000003) ^ Float.floatToIntBits(this.f3889c)) * 1000003) ^ Float.floatToIntBits(this.f3890d);
    }

    public String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.f3887a + ", maxZoomRatio=" + this.f3888b + ", minZoomRatio=" + this.f3889c + ", linearZoom=" + this.f3890d + "}";
    }
}
