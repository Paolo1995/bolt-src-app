package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;

/* loaded from: classes.dex */
public class MaxPreviewSize {

    /* renamed from: a  reason: collision with root package name */
    private final ExtraCroppingQuirk f2899a;

    public MaxPreviewSize() {
        this((ExtraCroppingQuirk) DeviceQuirks.a(ExtraCroppingQuirk.class));
    }

    @NonNull
    public Size a(@NonNull Size size) {
        boolean z7;
        ExtraCroppingQuirk extraCroppingQuirk = this.f2899a;
        if (extraCroppingQuirk == null) {
            return size;
        }
        Size a8 = extraCroppingQuirk.a(SurfaceConfig.ConfigType.PRIV);
        if (a8 == null) {
            return size;
        }
        if (a8.getWidth() * a8.getHeight() > size.getWidth() * size.getHeight()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return a8;
        }
        return size;
    }

    MaxPreviewSize(ExtraCroppingQuirk extraCroppingQuirk) {
        this.f2899a = extraCroppingQuirk;
    }
}
