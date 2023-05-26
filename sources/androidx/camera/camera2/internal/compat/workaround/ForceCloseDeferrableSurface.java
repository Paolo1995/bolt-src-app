package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import java.util.List;

/* loaded from: classes.dex */
public class ForceCloseDeferrableSurface {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2896a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2897b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2898c;

    public ForceCloseDeferrableSurface(@NonNull Quirks quirks, @NonNull Quirks quirks2) {
        this.f2896a = quirks2.a(TextureViewIsClosedQuirk.class);
        this.f2897b = quirks.a(PreviewOrientationIncorrectQuirk.class);
        this.f2898c = quirks.a(ConfigureSurfaceToSecondarySessionFailQuirk.class);
    }

    public void a(List<DeferrableSurface> list) {
        if (b() && list != null) {
            for (DeferrableSurface deferrableSurface : list) {
                deferrableSurface.c();
            }
            Logger.a("ForceCloseDeferrableSurface", "deferrableSurface closed");
        }
    }

    public boolean b() {
        if (!this.f2896a && !this.f2897b && !this.f2898c) {
            return false;
        }
        return true;
    }
}
