package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import java.util.ArrayList;
import java.util.Comparator;

/* loaded from: classes.dex */
public class SupportedRepeatingSurfaceSize {

    /* renamed from: b  reason: collision with root package name */
    private static final Size f2905b = new Size(320, 240);

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<Size> f2906c = new CompareSizesByArea();

    /* renamed from: a  reason: collision with root package name */
    private final RepeatingStreamConstraintForVideoRecordingQuirk f2907a = (RepeatingStreamConstraintForVideoRecordingQuirk) DeviceQuirks.a(RepeatingStreamConstraintForVideoRecordingQuirk.class);

    @NonNull
    public Size[] a(@NonNull Size[] sizeArr) {
        if (this.f2907a != null && RepeatingStreamConstraintForVideoRecordingQuirk.a()) {
            ArrayList arrayList = new ArrayList();
            for (Size size : sizeArr) {
                if (f2906c.compare(size, f2905b) >= 0) {
                    arrayList.add(size);
                }
            }
            return (Size[]) arrayList.toArray(new Size[0]);
        }
        return sizeArr;
    }
}
