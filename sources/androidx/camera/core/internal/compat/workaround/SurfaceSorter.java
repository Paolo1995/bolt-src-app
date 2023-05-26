package androidx.camera.core.internal.compat.workaround;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.camera.core.Preview;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class SurfaceSorter {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3927a;

    public SurfaceSorter() {
        boolean z7;
        if (DeviceQuirks.a(SurfaceOrderQuirk.class) != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f3927a = z7;
    }

    private int b(@NonNull DeferrableSurface deferrableSurface) {
        if (deferrableSurface.e() != MediaCodec.class && deferrableSurface.e() != VideoCapture.class) {
            if (deferrableSurface.e() == Preview.class) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int c(SessionConfig.OutputConfig outputConfig, SessionConfig.OutputConfig outputConfig2) {
        return b(outputConfig.d()) - b(outputConfig2.d());
    }

    public void d(@NonNull List<SessionConfig.OutputConfig> list) {
        if (!this.f3927a) {
            return;
        }
        Collections.sort(list, new Comparator() { // from class: h.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int c8;
                c8 = SurfaceSorter.this.c((SessionConfig.OutputConfig) obj, (SessionConfig.OutputConfig) obj2);
                return c8;
            }
        });
    }
}
