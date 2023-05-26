package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;

/* loaded from: classes.dex */
public interface Operation<I, O> {
    @NonNull
    O apply(@NonNull I i8) throws ImageCaptureException;
}
