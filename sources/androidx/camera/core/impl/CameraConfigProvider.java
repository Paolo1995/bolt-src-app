package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraInfo;

/* loaded from: classes.dex */
public interface CameraConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final CameraConfigProvider f3589a = new CameraConfigProvider() { // from class: androidx.camera.core.impl.c
        @Override // androidx.camera.core.impl.CameraConfigProvider
        public final CameraConfig a(CameraInfo cameraInfo, Context context) {
            return d.a(cameraInfo, context);
        }
    };

    CameraConfig a(@NonNull CameraInfo cameraInfo, @NonNull Context context);
}
