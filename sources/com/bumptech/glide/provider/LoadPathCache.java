package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class LoadPathCache {

    /* renamed from: c  reason: collision with root package name */
    private static final LoadPath<?, ?, ?> f10624c = new LoadPath<>(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);

    /* renamed from: a  reason: collision with root package name */
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> f10625a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<MultiClassKey> f10626b = new AtomicReference<>();

    private MultiClassKey b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey andSet = this.f10626b.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey b8 = b(cls, cls2, cls3);
        synchronized (this.f10625a) {
            loadPath = (LoadPath<Data, TResource, Transcode>) this.f10625a.get(b8);
        }
        this.f10626b.set(b8);
        return loadPath;
    }

    public boolean c(LoadPath<?, ?, ?> loadPath) {
        return f10624c.equals(loadPath);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, LoadPath<?, ?, ?> loadPath) {
        synchronized (this.f10625a) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.f10625a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f10624c;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
