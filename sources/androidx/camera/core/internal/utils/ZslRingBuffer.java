package androidx.camera.core.internal.utils;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;

/* loaded from: classes.dex */
public final class ZslRingBuffer extends ArrayRingBuffer<ImageProxy> {
    public ZslRingBuffer(int i8, @NonNull RingBuffer$OnRemoveCallback<ImageProxy> ringBuffer$OnRemoveCallback) {
        super(i8, ringBuffer$OnRemoveCallback);
    }

    private boolean e(@NonNull ImageInfo imageInfo) {
        CameraCaptureResult a8 = CameraCaptureResults.a(imageInfo);
        if ((a8.f() != CameraCaptureMetaData$AfState.LOCKED_FOCUSED && a8.f() != CameraCaptureMetaData$AfState.PASSIVE_FOCUSED) || a8.h() != CameraCaptureMetaData$AeState.CONVERGED || a8.g() != CameraCaptureMetaData$AwbState.CONVERGED) {
            return false;
        }
        return true;
    }

    public void d(@NonNull ImageProxy imageProxy) {
        if (e(imageProxy.O0())) {
            super.b(imageProxy);
        } else {
            this.f3931d.a(imageProxy);
        }
    }
}
