package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* loaded from: classes.dex */
public interface ResourceDecoder<T, Z> {
    boolean a(@NonNull T t7, @NonNull Options options) throws IOException;

    Resource<Z> b(@NonNull T t7, int i8, int i9, @NonNull Options options) throws IOException;
}
