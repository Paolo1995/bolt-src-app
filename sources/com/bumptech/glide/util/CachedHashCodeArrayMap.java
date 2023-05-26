package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: n  reason: collision with root package name */
    private int f10767n;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map, j$.util.Map
    public void clear() {
        this.f10767n = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map, j$.util.Map
    public int hashCode() {
        if (this.f10767n == 0) {
            this.f10767n = super.hashCode();
        }
        return this.f10767n;
    }

    @Override // androidx.collection.SimpleArrayMap
    public void k(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f10767n = 0;
        super.k(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V l(int i8) {
        this.f10767n = 0;
        return (V) super.l(i8);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V m(int i8, V v7) {
        this.f10767n = 0;
        return (V) super.m(i8, v7);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map, j$.util.Map
    public V put(K k8, V v7) {
        this.f10767n = 0;
        return (V) super.put(k8, v7);
    }
}
