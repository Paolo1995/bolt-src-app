package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.ExifData;

/* loaded from: classes.dex */
public interface CameraCaptureResult {
    void a(@NonNull ExifData.Builder builder);

    @NonNull
    TagBundle b();

    @NonNull
    CameraCaptureMetaData$FlashState c();

    long d();

    @NonNull
    CaptureResult e();

    @NonNull
    CameraCaptureMetaData$AfState f();

    @NonNull
    CameraCaptureMetaData$AwbState g();

    @NonNull
    CameraCaptureMetaData$AeState h();
}
