package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class AddressResolverGroup<T extends SocketAddress> implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AddressResolverGroup.class);
    private final Map<EventExecutor, AddressResolver<T>> resolvers = new IdentityHashMap();
    private final Map<EventExecutor, GenericFutureListener<Future<Object>>> executorTerminationListeners = new IdentityHashMap();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i8;
        AddressResolver[] addressResolverArr;
        Map.Entry[] entryArr;
        synchronized (this.resolvers) {
            addressResolverArr = (AddressResolver[]) this.resolvers.values().toArray(new AddressResolver[0]);
            this.resolvers.clear();
            entryArr = (Map.Entry[]) this.executorTerminationListeners.entrySet().toArray(new Map.Entry[0]);
            this.executorTerminationListeners.clear();
        }
        for (Map.Entry entry : entryArr) {
            ((EventExecutor) entry.getKey()).terminationFuture().removeListener((GenericFutureListener) entry.getValue());
        }
        for (AddressResolver addressResolver : addressResolverArr) {
            try {
                addressResolver.close();
            } catch (Throwable th) {
                logger.warn("Failed to close a resolver:", th);
            }
        }
    }

    public AddressResolver<T> getResolver(final EventExecutor eventExecutor) {
        final AddressResolver<T> addressResolver;
        ObjectUtil.checkNotNull(eventExecutor, "executor");
        if (!eventExecutor.isShuttingDown()) {
            synchronized (this.resolvers) {
                addressResolver = this.resolvers.get(eventExecutor);
                if (addressResolver == null) {
                    try {
                        addressResolver = newResolver(eventExecutor);
                        this.resolvers.put(eventExecutor, addressResolver);
                        GenericFutureListener<Future<Object>> genericFutureListener = new GenericFutureListener() { // from class: io.netty.resolver.AddressResolverGroup.1
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(Future<Object> future) {
                                synchronized (AddressResolverGroup.this.resolvers) {
                                    AddressResolverGroup.this.resolvers.remove(eventExecutor);
                                    AddressResolverGroup.this.executorTerminationListeners.remove(eventExecutor);
                                }
                                addressResolver.close();
                            }
                        };
                        this.executorTerminationListeners.put(eventExecutor, genericFutureListener);
                        eventExecutor.terminationFuture().addListener(genericFutureListener);
                    } catch (Exception e8) {
                        throw new IllegalStateException("failed to create a new resolver", e8);
                    }
                }
            }
            return addressResolver;
        }
        throw new IllegalStateException("executor not accepting a task");
    }

    protected abstract AddressResolver<T> newResolver(EventExecutor eventExecutor) throws Exception;
}
