package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class CamcorderProfileResolutionValidator {

    /* renamed from: a  reason: collision with root package name */
    private final CamcorderProfileResolutionQuirk f2891a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Size> f2892b;

    public CamcorderProfileResolutionValidator(CamcorderProfileResolutionQuirk camcorderProfileResolutionQuirk) {
        Set<Size> emptySet;
        this.f2891a = camcorderProfileResolutionQuirk;
        if (camcorderProfileResolutionQuirk != null) {
            emptySet = new HashSet<>(camcorderProfileResolutionQuirk.a());
        } else {
            emptySet = Collections.emptySet();
        }
        this.f2892b = emptySet;
    }
}
