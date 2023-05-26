package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public enum HashMapSupplier implements Callable<Map<Object, Object>> {
    INSTANCE;

    public static <K, V> Callable<Map<K, V>> a() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: c */
    public Map<Object, Object> call() throws Exception {
        return new HashMap();
    }
}
