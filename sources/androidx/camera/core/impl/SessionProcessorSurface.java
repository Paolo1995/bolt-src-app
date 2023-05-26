package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public final class SessionProcessorSurface extends DeferrableSurface {

    /* renamed from: m  reason: collision with root package name */
    private final Surface f3692m;

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    public ListenableFuture<Surface> n() {
        return Futures.h(this.f3692m);
    }
}
