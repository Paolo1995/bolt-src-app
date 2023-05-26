package io.netty.resolver;

import io.netty.util.concurrent.Future;
import java.io.Closeable;
import java.net.SocketAddress;

/* loaded from: classes5.dex */
public interface AddressResolver<T extends SocketAddress> extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean isResolved(SocketAddress socketAddress);

    boolean isSupported(SocketAddress socketAddress);

    Future<T> resolve(SocketAddress socketAddress);
}
