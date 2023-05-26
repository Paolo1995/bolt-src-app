package androidx.camera.camera2.internal;

import android.content.Context;
import android.media.CamcorderProfile;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class Camera2DeviceSurfaceManager implements CameraDeviceSurfaceManager {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, SupportedSurfaceCombination> f2525a;

    /* renamed from: b  reason: collision with root package name */
    private final CamcorderProfileHelper f2526b;

    public Camera2DeviceSurfaceManager(@NonNull Context context, Object obj, @NonNull Set<String> set) throws CameraUnavailableException {
        this(context, new CamcorderProfileHelper() { // from class: androidx.camera.camera2.internal.Camera2DeviceSurfaceManager.1
            @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
            public CamcorderProfile a(int i8, int i9) {
                return CamcorderProfile.get(i8, i9);
            }

            @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
            public boolean b(int i8, int i9) {
                return CamcorderProfile.hasProfile(i8, i9);
            }
        }, obj, set);
    }

    private void c(@NonNull Context context, @NonNull CameraManagerCompat cameraManagerCompat, @NonNull Set<String> set) throws CameraUnavailableException {
        Preconditions.g(context);
        for (String str : set) {
            this.f2525a.put(str, new SupportedSurfaceCombination(context, str, cameraManagerCompat, this.f2526b));
        }
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public SurfaceConfig a(@NonNull String str, int i8, @NonNull Size size) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.f2525a.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.A(i8, size);
        }
        return null;
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    @NonNull
    public Map<UseCaseConfig<?>, Size> b(@NonNull String str, @NonNull List<AttachedSurfaceInfo> list, @NonNull List<UseCaseConfig<?>> list2) {
        Preconditions.b(!list2.isEmpty(), "No new use cases to be bound.");
        SupportedSurfaceCombination supportedSurfaceCombination = this.f2525a.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.q(list, list2);
        }
        throw new IllegalArgumentException("No such camera id in supported combination list: " + str);
    }

    Camera2DeviceSurfaceManager(@NonNull Context context, @NonNull CamcorderProfileHelper camcorderProfileHelper, Object obj, @NonNull Set<String> set) throws CameraUnavailableException {
        CameraManagerCompat a8;
        this.f2525a = new HashMap();
        Preconditions.g(camcorderProfileHelper);
        this.f2526b = camcorderProfileHelper;
        if (obj instanceof CameraManagerCompat) {
            a8 = (CameraManagerCompat) obj;
        } else {
            a8 = CameraManagerCompat.a(context);
        }
        c(context, a8, set);
    }
}
