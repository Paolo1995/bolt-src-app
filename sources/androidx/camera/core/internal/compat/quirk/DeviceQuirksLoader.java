package androidx.camera.core.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static List<Quirk> a() {
        ArrayList arrayList = new ArrayList();
        if (ImageCaptureRotationOptionQuirk.d()) {
            arrayList.add(new ImageCaptureRotationOptionQuirk());
        }
        if (SurfaceOrderQuirk.a()) {
            arrayList.add(new SurfaceOrderQuirk());
        }
        return arrayList;
    }
}
