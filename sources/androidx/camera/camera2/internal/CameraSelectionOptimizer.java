package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class CameraSelectionOptimizer {
    private CameraSelectionOptimizer() {
    }

    private static String a(CameraManagerCompat cameraManagerCompat, Integer num, List<String> list) throws CameraAccessExceptionCompat {
        if (num == null || !list.contains("0") || !list.contains("1")) {
            return null;
        }
        if (num.intValue() == 1) {
            if (((Integer) cameraManagerCompat.c("0").a(CameraCharacteristics.LENS_FACING)).intValue() != 1) {
                return null;
            }
            return "1";
        } else if (num.intValue() != 0 || ((Integer) cameraManagerCompat.c("1").a(CameraCharacteristics.LENS_FACING)).intValue() != 0) {
            return null;
        } else {
            return "0";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> b(@NonNull Camera2CameraFactory camera2CameraFactory, CameraSelector cameraSelector) throws InitializationException {
        String str;
        try {
            ArrayList arrayList = new ArrayList();
            List<String> asList = Arrays.asList(camera2CameraFactory.c().d());
            if (cameraSelector == null) {
                for (String str2 : asList) {
                    arrayList.add(str2);
                }
                return arrayList;
            }
            try {
                str = a(camera2CameraFactory.c(), cameraSelector.d(), asList);
            } catch (IllegalStateException unused) {
                str = null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str3 : asList) {
                if (!str3.equals(str)) {
                    arrayList2.add(camera2CameraFactory.e(str3));
                }
            }
            Iterator<CameraInfo> it = cameraSelector.b(arrayList2).iterator();
            while (it.hasNext()) {
                arrayList.add(((CameraInfoInternal) it.next()).a());
            }
            return arrayList;
        } catch (CameraAccessExceptionCompat e8) {
            throw new InitializationException(CameraUnavailableExceptionHelper.a(e8));
        } catch (CameraUnavailableException e9) {
            throw new InitializationException(e9);
        }
    }
}
