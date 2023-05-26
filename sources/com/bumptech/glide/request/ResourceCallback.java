package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public interface ResourceCallback {
    void c(Resource<?> resource, DataSource dataSource, boolean z7);

    void d(GlideException glideException);

    Object g();
}
