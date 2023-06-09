package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public interface Transformation<T> extends Key {
    @NonNull
    Resource<T> a(@NonNull Context context, @NonNull Resource<T> resource, int i8, int i9);
}
