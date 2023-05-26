package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.core.impl.SurfaceCombination;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ExtraSupportedSurfaceCombinationsContainer {

    /* renamed from: a  reason: collision with root package name */
    private final ExtraSupportedSurfaceCombinationsQuirk f2894a = (ExtraSupportedSurfaceCombinationsQuirk) DeviceQuirks.a(ExtraSupportedSurfaceCombinationsQuirk.class);

    @NonNull
    public List<SurfaceCombination> a(@NonNull String str, int i8) {
        ExtraSupportedSurfaceCombinationsQuirk extraSupportedSurfaceCombinationsQuirk = this.f2894a;
        if (extraSupportedSurfaceCombinationsQuirk == null) {
            return new ArrayList();
        }
        return extraSupportedSurfaceCombinationsQuirk.c(str, i8);
    }
}
