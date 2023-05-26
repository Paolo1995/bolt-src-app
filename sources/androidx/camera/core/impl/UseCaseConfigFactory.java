package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.core.InitializationException;

/* loaded from: classes.dex */
public interface UseCaseConfigFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final UseCaseConfigFactory f3724a = new UseCaseConfigFactory() { // from class: androidx.camera.core.impl.UseCaseConfigFactory.1
        @Override // androidx.camera.core.impl.UseCaseConfigFactory
        public Config a(@NonNull CaptureType captureType, int i8) {
            return null;
        }
    };

    /* loaded from: classes.dex */
    public enum CaptureType {
        IMAGE_CAPTURE,
        PREVIEW,
        IMAGE_ANALYSIS,
        VIDEO_CAPTURE
    }

    /* loaded from: classes.dex */
    public interface Provider {
        @NonNull
        UseCaseConfigFactory a(@NonNull Context context) throws InitializationException;
    }

    Config a(@NonNull CaptureType captureType, int i8);
}
