package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public enum ArrayListSupplier implements Callable<List<Object>>, Function<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> c() {
        return INSTANCE;
    }

    public static <T, O> Function<O, List<T>> e() {
        return INSTANCE;
    }

    @Override // io.reactivex.functions.Function
    /* renamed from: a */
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: f */
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
