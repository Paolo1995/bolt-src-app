package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Entry<Y>> f10776a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f10777b;

    /* renamed from: c  reason: collision with root package name */
    private long f10778c;

    /* renamed from: d  reason: collision with root package name */
    private long f10779d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Entry<Y> {

        /* renamed from: a  reason: collision with root package name */
        final Y f10780a;

        /* renamed from: b  reason: collision with root package name */
        final int f10781b;

        Entry(Y y7, int i8) {
            this.f10780a = y7;
            this.f10781b = i8;
        }
    }

    public LruCache(long j8) {
        this.f10777b = j8;
        this.f10778c = j8;
    }

    private void f() {
        m(this.f10778c);
    }

    public void b() {
        m(0L);
    }

    public synchronized Y g(@NonNull T t7) {
        Y y7;
        Entry<Y> entry = this.f10776a.get(t7);
        if (entry != null) {
            y7 = entry.f10780a;
        } else {
            y7 = null;
        }
        return y7;
    }

    public synchronized long h() {
        return this.f10778c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int i(Y y7) {
        return 1;
    }

    protected void j(@NonNull T t7, Y y7) {
    }

    public synchronized Y k(@NonNull T t7, Y y7) {
        Entry<Y> entry;
        int i8 = i(y7);
        long j8 = i8;
        Y y8 = null;
        if (j8 >= this.f10778c) {
            j(t7, y7);
            return null;
        }
        if (y7 != null) {
            this.f10779d += j8;
        }
        Map<T, Entry<Y>> map = this.f10776a;
        if (y7 == null) {
            entry = null;
        } else {
            entry = new Entry<>(y7, i8);
        }
        Entry<Y> put = map.put(t7, entry);
        if (put != null) {
            this.f10779d -= put.f10781b;
            if (!put.f10780a.equals(y7)) {
                j(t7, put.f10780a);
            }
        }
        f();
        if (put != null) {
            y8 = put.f10780a;
        }
        return y8;
    }

    public synchronized Y l(@NonNull T t7) {
        Entry<Y> remove = this.f10776a.remove(t7);
        if (remove == null) {
            return null;
        }
        this.f10779d -= remove.f10781b;
        return remove.f10780a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void m(long j8) {
        while (this.f10779d > j8) {
            Iterator<Map.Entry<T, Entry<Y>>> it = this.f10776a.entrySet().iterator();
            Map.Entry<T, Entry<Y>> next = it.next();
            Entry<Y> value = next.getValue();
            this.f10779d -= value.f10781b;
            T key = next.getKey();
            it.remove();
            j(key, value.f10780a);
        }
    }
}
