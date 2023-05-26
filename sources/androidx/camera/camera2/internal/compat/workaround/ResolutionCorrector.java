package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ResolutionCorrector {

    /* renamed from: a  reason: collision with root package name */
    private final ExtraCroppingQuirk f2903a;

    public ResolutionCorrector() {
        this((ExtraCroppingQuirk) DeviceQuirks.a(ExtraCroppingQuirk.class));
    }

    @NonNull
    public List<Size> a(@NonNull SurfaceConfig.ConfigType configType, @NonNull List<Size> list) {
        ExtraCroppingQuirk extraCroppingQuirk = this.f2903a;
        if (extraCroppingQuirk == null) {
            return list;
        }
        Size a8 = extraCroppingQuirk.a(configType);
        if (a8 == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(a8);
        for (Size size : list) {
            if (!size.equals(a8)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    ResolutionCorrector(ExtraCroppingQuirk extraCroppingQuirk) {
        this.f2903a = extraCroppingQuirk;
    }
}
