package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.core.impl.Quirks;

/* loaded from: classes.dex */
public class AeFpsRange {

    /* renamed from: a  reason: collision with root package name */
    private final Range<Integer> f2888a;

    public AeFpsRange(@NonNull Quirks quirks) {
        AeFpsRangeLegacyQuirk aeFpsRangeLegacyQuirk = (AeFpsRangeLegacyQuirk) quirks.b(AeFpsRangeLegacyQuirk.class);
        if (aeFpsRangeLegacyQuirk == null) {
            this.f2888a = null;
        } else {
            this.f2888a = aeFpsRangeLegacyQuirk.b();
        }
    }

    public void a(@NonNull Camera2ImplConfig.Builder builder) {
        Range<Integer> range = this.f2888a;
        if (range != null) {
            builder.e(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
        }
    }
}
