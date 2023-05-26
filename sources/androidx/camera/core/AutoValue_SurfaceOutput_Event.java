package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;

/* loaded from: classes.dex */
final class AutoValue_SurfaceOutput_Event extends SurfaceOutput.Event {

    /* renamed from: a  reason: collision with root package name */
    private final int f3037a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceOutput f3038b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SurfaceOutput_Event(int i8, SurfaceOutput surfaceOutput) {
        this.f3037a = i8;
        if (surfaceOutput != null) {
            this.f3038b = surfaceOutput;
            return;
        }
        throw new NullPointerException("Null surfaceOutput");
    }

    @Override // androidx.camera.core.SurfaceOutput.Event
    public int a() {
        return this.f3037a;
    }

    @Override // androidx.camera.core.SurfaceOutput.Event
    @NonNull
    public SurfaceOutput b() {
        return this.f3038b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceOutput.Event)) {
            return false;
        }
        SurfaceOutput.Event event = (SurfaceOutput.Event) obj;
        if (this.f3037a == event.a() && this.f3038b.equals(event.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3037a ^ 1000003) * 1000003) ^ this.f3038b.hashCode();
    }

    public String toString() {
        return "Event{eventCode=" + this.f3037a + ", surfaceOutput=" + this.f3038b + "}";
    }
}
