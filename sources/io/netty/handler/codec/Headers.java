package io.netty.handler.codec;

import io.netty.handler.codec.Headers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public interface Headers<K, V, T extends Headers<K, V, T>> extends Iterable<Map.Entry<K, V>> {
    V get(K k8);

    List<V> getAll(K k8);

    @Override // java.lang.Iterable
    Iterator<Map.Entry<K, V>> iterator();

    int size();
}
