package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class ModelToResourceClassCache {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<MultiClassKey> f10627a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<MultiClassKey, List<Class<?>>> f10628b = new ArrayMap<>();

    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        MultiClassKey andSet = this.f10627a.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f10628b) {
            list = this.f10628b.get(andSet);
        }
        this.f10627a.set(andSet);
        return list;
    }

    public void b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f10628b) {
            this.f10628b.put(new MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
