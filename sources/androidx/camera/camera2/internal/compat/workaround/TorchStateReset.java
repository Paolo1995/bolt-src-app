package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.List;

/* loaded from: classes.dex */
public class TorchStateReset {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2908a;

    public TorchStateReset() {
        boolean z7;
        if (DeviceQuirks.a(TorchIsClosedAfterImageCapturingQuirk.class) != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f2908a = z7;
    }

    @NonNull
    public CaptureConfig a(@NonNull CaptureConfig captureConfig) {
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.p(captureConfig.g());
        for (DeferrableSurface deferrableSurface : captureConfig.e()) {
            builder.f(deferrableSurface);
        }
        builder.e(captureConfig.d());
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.e(CaptureRequest.FLASH_MODE, 0);
        builder.e(builder2.c());
        return builder.h();
    }

    public boolean b(@NonNull List<CaptureRequest> list, boolean z7) {
        if (this.f2908a && z7) {
            for (CaptureRequest captureRequest : list) {
                Integer num = (Integer) captureRequest.get(CaptureRequest.FLASH_MODE);
                if (num != null && num.intValue() == 2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
