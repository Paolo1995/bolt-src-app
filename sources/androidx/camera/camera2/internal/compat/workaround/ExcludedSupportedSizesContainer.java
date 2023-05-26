package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ExcludedSupportedSizesContainer {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f2893a;

    public ExcludedSupportedSizesContainer(@NonNull String str) {
        this.f2893a = str;
    }

    @NonNull
    public List<Size> a(int i8) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk = (ExcludedSupportedSizesQuirk) DeviceQuirks.a(ExcludedSupportedSizesQuirk.class);
        if (excludedSupportedSizesQuirk == null) {
            return new ArrayList();
        }
        return excludedSupportedSizesQuirk.a(this.f2893a, i8);
    }
}
