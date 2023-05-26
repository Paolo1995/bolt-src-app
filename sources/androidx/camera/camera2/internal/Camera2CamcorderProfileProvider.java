package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.internal.compat.workaround.CamcorderProfileResolutionValidator;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProvider;

/* loaded from: classes.dex */
public class Camera2CamcorderProfileProvider implements CamcorderProfileProvider {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2383a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2384b;

    /* renamed from: c  reason: collision with root package name */
    private final CamcorderProfileResolutionValidator f2385c;

    public Camera2CamcorderProfileProvider(@NonNull String str, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean z7;
        int i8;
        try {
            i8 = Integer.parseInt(str);
            z7 = true;
        } catch (NumberFormatException unused) {
            Logger.k("Camera2CamcorderProfileProvider", "Camera id is not an integer: " + str + ", unable to create CamcorderProfileProvider");
            z7 = false;
            i8 = -1;
        }
        this.f2383a = z7;
        this.f2384b = i8;
        this.f2385c = new CamcorderProfileResolutionValidator((CamcorderProfileResolutionQuirk) CameraQuirks.a(str, cameraCharacteristicsCompat).b(CamcorderProfileResolutionQuirk.class));
    }
}
