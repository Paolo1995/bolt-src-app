package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CameraThreadConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class Camera2CameraFactory implements CameraFactory {

    /* renamed from: a  reason: collision with root package name */
    private final CameraThreadConfig f2415a;

    /* renamed from: c  reason: collision with root package name */
    private final CameraManagerCompat f2417c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f2418d;

    /* renamed from: e  reason: collision with root package name */
    private final DisplayInfoManager f2419e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Camera2CameraInfoImpl> f2420f = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final CameraStateRegistry f2416b = new CameraStateRegistry(1);

    public Camera2CameraFactory(@NonNull Context context, @NonNull CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) throws InitializationException {
        this.f2415a = cameraThreadConfig;
        this.f2417c = CameraManagerCompat.b(context, cameraThreadConfig.c());
        this.f2419e = DisplayInfoManager.b(context);
        this.f2418d = d(CameraSelectionOptimizer.b(this, cameraSelector));
    }

    private List<String> d(@NonNull List<String> list) throws InitializationException {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.equals("0") && !str.equals("1")) {
                if (g(str)) {
                    arrayList.add(str);
                } else {
                    Logger.a("Camera2CameraFactory", "Camera " + str + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
                }
            } else {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private boolean g(@NonNull String str) throws InitializationException {
        if ("robolectric".equals(Build.FINGERPRINT)) {
            return true;
        }
        try {
            int[] iArr = (int[]) this.f2417c.c(str).a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i8 : iArr) {
                    if (i8 == 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (CameraAccessExceptionCompat e8) {
            throw new InitializationException(CameraUnavailableExceptionHelper.a(e8));
        }
    }

    @Override // androidx.camera.core.impl.CameraFactory
    @NonNull
    public CameraInternal a(@NonNull String str) throws CameraUnavailableException {
        if (this.f2418d.contains(str)) {
            return new Camera2CameraImpl(this.f2417c, str, e(str), this.f2416b, this.f2415a.b(), this.f2415a.c(), this.f2419e);
        }
        throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
    }

    @Override // androidx.camera.core.impl.CameraFactory
    @NonNull
    public Set<String> b() {
        return new LinkedHashSet(this.f2418d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Camera2CameraInfoImpl e(@NonNull String str) throws CameraUnavailableException {
        try {
            Camera2CameraInfoImpl camera2CameraInfoImpl = this.f2420f.get(str);
            if (camera2CameraInfoImpl == null) {
                Camera2CameraInfoImpl camera2CameraInfoImpl2 = new Camera2CameraInfoImpl(str, this.f2417c);
                this.f2420f.put(str, camera2CameraInfoImpl2);
                return camera2CameraInfoImpl2;
            }
            return camera2CameraInfoImpl;
        } catch (CameraAccessExceptionCompat e8) {
            throw CameraUnavailableExceptionHelper.a(e8);
        }
    }

    @Override // androidx.camera.core.impl.CameraFactory
    @NonNull
    /* renamed from: f */
    public CameraManagerCompat c() {
        return this.f2417c;
    }
}
