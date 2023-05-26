package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.AutoFlashUnderExposedQuirk;
import androidx.camera.core.impl.Quirks;

/* loaded from: classes.dex */
public class OverrideAeModeForStillCapture {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2901a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2902b = false;

    public OverrideAeModeForStillCapture(@NonNull Quirks quirks) {
        this.f2901a = quirks.b(AutoFlashUnderExposedQuirk.class) != null;
    }

    public void a() {
        this.f2902b = false;
    }

    public void b() {
        this.f2902b = true;
    }

    public boolean c(int i8) {
        if (this.f2902b && i8 == 0 && this.f2901a) {
            return true;
        }
        return false;
    }
}
