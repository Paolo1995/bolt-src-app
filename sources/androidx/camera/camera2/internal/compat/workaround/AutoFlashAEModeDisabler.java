package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.core.impl.Quirks;

/* loaded from: classes.dex */
public class AutoFlashAEModeDisabler {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2889a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2890b;

    public AutoFlashAEModeDisabler(@NonNull Quirks quirks) {
        boolean z7;
        this.f2889a = quirks.a(ImageCaptureFailWithAutoFlashQuirk.class);
        if (DeviceQuirks.a(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f2890b = z7;
    }

    public int a(int i8) {
        if ((this.f2889a || this.f2890b) && i8 == 2) {
            return 1;
        }
        return i8;
    }
}
