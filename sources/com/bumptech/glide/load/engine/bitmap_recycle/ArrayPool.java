package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public interface ArrayPool {
    void a(int i8);

    void b();

    <T> T c(int i8, Class<T> cls);

    <T> T d(int i8, Class<T> cls);

    <T> void put(T t7);
}
