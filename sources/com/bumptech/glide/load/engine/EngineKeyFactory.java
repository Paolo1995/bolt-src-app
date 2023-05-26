package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.util.Map;

/* loaded from: classes.dex */
class EngineKeyFactory {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineKey a(Object obj, Key key, int i8, int i9, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        return new EngineKey(obj, key, i8, i9, map, cls, cls2, options);
    }
}
