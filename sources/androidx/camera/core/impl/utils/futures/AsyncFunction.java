package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;

@FunctionalInterface
/* loaded from: classes.dex */
public interface AsyncFunction<I, O> {
    @NonNull
    ListenableFuture<O> apply(I i8) throws Exception;
}
