package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;

/* loaded from: classes.dex */
public interface CaptureStage {

    /* loaded from: classes.dex */
    public static final class DefaultCaptureStage implements CaptureStage {

        /* renamed from: a  reason: collision with root package name */
        private final CaptureConfig f3629a = new CaptureConfig.Builder().h();

        @Override // androidx.camera.core.impl.CaptureStage
        @NonNull
        public CaptureConfig a() {
            return this.f3629a;
        }

        @Override // androidx.camera.core.impl.CaptureStage
        public int getId() {
            return 0;
        }
    }

    @NonNull
    CaptureConfig a();

    int getId();
}
