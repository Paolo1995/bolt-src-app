package io.netty.resolver;

import io.netty.util.concurrent.Future;
import java.io.Closeable;

/* loaded from: classes5.dex */
public interface NameResolver<T> extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Future<T> resolve(String str);
}
