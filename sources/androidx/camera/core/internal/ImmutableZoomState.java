package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.ZoomState;

/* loaded from: classes.dex */
public abstract class ImmutableZoomState implements ZoomState {
    @NonNull
    public static ZoomState e(@NonNull ZoomState zoomState) {
        return new AutoValue_ImmutableZoomState(zoomState.d(), zoomState.a(), zoomState.c(), zoomState.b());
    }

    @Override // androidx.camera.core.ZoomState
    public abstract float a();

    @Override // androidx.camera.core.ZoomState
    public abstract float b();

    @Override // androidx.camera.core.ZoomState
    public abstract float c();

    @Override // androidx.camera.core.ZoomState
    public abstract float d();
}
