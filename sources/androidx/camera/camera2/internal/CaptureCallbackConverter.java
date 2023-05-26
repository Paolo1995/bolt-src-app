package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks$ComboCameraCaptureCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class CaptureCallbackConverter {
    private CaptureCallbackConverter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CameraCaptureSession.CaptureCallback a(CameraCaptureCallback cameraCaptureCallback) {
        if (cameraCaptureCallback == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        b(cameraCaptureCallback, arrayList);
        if (arrayList.size() == 1) {
            return (CameraCaptureSession.CaptureCallback) arrayList.get(0);
        }
        return Camera2CaptureCallbacks.a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(CameraCaptureCallback cameraCaptureCallback, List<CameraCaptureSession.CaptureCallback> list) {
        if (cameraCaptureCallback instanceof CameraCaptureCallbacks$ComboCameraCaptureCallback) {
            for (CameraCaptureCallback cameraCaptureCallback2 : ((CameraCaptureCallbacks$ComboCameraCaptureCallback) cameraCaptureCallback).d()) {
                b(cameraCaptureCallback2, list);
            }
        } else if (cameraCaptureCallback instanceof CaptureCallbackContainer) {
            list.add(((CaptureCallbackContainer) cameraCaptureCallback).e());
        } else {
            list.add(new CaptureCallbackAdapter(cameraCaptureCallback));
        }
    }
}
