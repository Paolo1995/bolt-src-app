package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public class AeFpsRangeLegacyQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    private final Range<Integer> f2858a;

    public AeFpsRangeLegacyQuirk(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.f2858a = d((Range[]) cameraCharacteristicsCompat.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    @NonNull
    private Range<Integer> a(@NonNull Range<Integer> range) {
        int intValue = range.getUpper().intValue();
        int intValue2 = range.getLower().intValue();
        if (range.getUpper().intValue() >= 1000) {
            intValue = range.getUpper().intValue() / 1000;
        }
        if (range.getLower().intValue() >= 1000) {
            intValue2 = range.getLower().intValue() / 1000;
        }
        return new Range<>(Integer.valueOf(intValue2), Integer.valueOf(intValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    private Range<Integer> d(Range<Integer>[] rangeArr) {
        Range<Integer> range = null;
        if (rangeArr != null && rangeArr.length != 0) {
            for (Range<Integer> range2 : rangeArr) {
                Range<Integer> a8 = a(range2);
                if (a8.getUpper().intValue() == 30 && (range == null || a8.getLower().intValue() < range.getLower().intValue())) {
                    range = a8;
                }
            }
        }
        return range;
    }

    public Range<Integer> b() {
        return this.f2858a;
    }
}
