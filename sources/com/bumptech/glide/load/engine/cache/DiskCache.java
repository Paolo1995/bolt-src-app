package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.io.File;

/* loaded from: classes.dex */
public interface DiskCache {

    /* loaded from: classes.dex */
    public interface Factory {
        DiskCache build();
    }

    /* loaded from: classes.dex */
    public interface Writer {
        boolean a(@NonNull File file);
    }

    void a(Key key, Writer writer);

    File b(Key key);
}
