package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public final class ImmediateSurface extends DeferrableSurface {

    /* renamed from: m  reason: collision with root package name */
    private final Surface f3660m;

    public ImmediateSurface(@NonNull Surface surface, @NonNull Size size, int i8) {
        super(size, i8);
        this.f3660m = surface;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    public ListenableFuture<Surface> n() {
        return Futures.h(this.f3660m);
    }

    public ImmediateSurface(@NonNull Surface surface) {
        this.f3660m = surface;
    }
}
