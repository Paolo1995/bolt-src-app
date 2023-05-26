package com.hivemq.client.internal.netty;

import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.netty.NettyEventLoopProvider;
import com.hivemq.client.internal.util.ClassUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class NettyEventLoopProvider {

    /* renamed from: d  reason: collision with root package name */
    private static final InternalLogger f18634d = InternalLoggerFactory.a(NettyEventLoopProvider.class);

    /* renamed from: e  reason: collision with root package name */
    public static final NettyEventLoopProvider f18635e;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Executor, Entry> f18636a;

    /* renamed from: b  reason: collision with root package name */
    private final BiFunction<Integer, Executor, MultithreadEventLoopGroup> f18637b;

    /* renamed from: c  reason: collision with root package name */
    private final ChannelFactory<?> f18638c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Entry {

        /* renamed from: a  reason: collision with root package name */
        final MultithreadEventLoopGroup f18639a;

        /* renamed from: b  reason: collision with root package name */
        int f18640b;

        private Entry(MultithreadEventLoopGroup multithreadEventLoopGroup) {
            this.f18640b = 1;
            this.f18639a = multithreadEventLoopGroup;
        }
    }

    /* loaded from: classes3.dex */
    private static class EpollHolder {
        private EpollHolder() {
        }

        public static /* synthetic */ EpollEventLoopGroup a(int i8, Executor executor) {
            return new EpollEventLoopGroup(i8, executor);
        }

        public static /* synthetic */ EpollSocketChannel b() {
            return new EpollSocketChannel();
        }

        static /* synthetic */ NettyEventLoopProvider c() {
            return d();
        }

        private static NettyEventLoopProvider d() {
            if (Epoll.isAvailable()) {
                return new NettyEventLoopProvider(new BiFunction() { // from class: com.hivemq.client.internal.netty.a
                    @Override // j$.util.function.BiFunction
                    public /* synthetic */ BiFunction andThen(Function function) {
                        return BiFunction.CC.$default$andThen(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return NettyEventLoopProvider.EpollHolder.a(((Integer) obj).intValue(), (Executor) obj2);
                    }
                }, new ChannelFactory() { // from class: com.hivemq.client.internal.netty.b
                    @Override // io.netty.bootstrap.ChannelFactory
                    public final Channel newChannel() {
                        return NettyEventLoopProvider.EpollHolder.b();
                    }
                });
            }
            return NettyEventLoopProvider.a();
        }
    }

    static {
        if (ClassUtil.a("io.netty.channel.epoll.Epoll")) {
            f18635e = EpollHolder.c();
        } else {
            f18635e = d();
        }
    }

    static /* synthetic */ NettyEventLoopProvider a() {
        return d();
    }

    private static NettyEventLoopProvider d() {
        return new NettyEventLoopProvider(new BiFunction() { // from class: m0.b
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return new NioEventLoopGroup(((Integer) obj).intValue(), (Executor) obj2);
            }
        }, new ChannelFactory() { // from class: m0.c
            @Override // io.netty.bootstrap.ChannelFactory
            public final Channel newChannel() {
                return new NioSocketChannel();
            }
        });
    }

    public synchronized EventLoop b(Executor executor, int i8) {
        Entry entry;
        MultithreadEventLoopGroup apply;
        entry = this.f18636a.get(executor);
        if (entry == null) {
            if (executor == null) {
                apply = this.f18637b.apply(Integer.valueOf(i8), new ThreadPerTaskExecutor(new DefaultThreadFactory("com.hivemq.client.mqtt", 10)));
            } else if (executor instanceof MultithreadEventLoopGroup) {
                MultithreadEventLoopGroup multithreadEventLoopGroup = (MultithreadEventLoopGroup) executor;
                if (i8 != 0 && multithreadEventLoopGroup.executorCount() != i8) {
                    f18634d.warn("Tried to use a different amount of Netty threads for the provided event loop. Using {} threads instead of {}", Integer.valueOf(multithreadEventLoopGroup.executorCount()), Integer.valueOf(i8));
                }
                apply = multithreadEventLoopGroup;
            } else {
                apply = this.f18637b.apply(Integer.valueOf(i8), executor);
            }
            entry = new Entry(apply);
            this.f18636a.put(executor, entry);
        } else {
            if (i8 != 0 && entry.f18639a.executorCount() != i8) {
                f18634d.warn("Tried to use a different amount of Netty threads for the same executor. Using {} threads instead of {}", Integer.valueOf(entry.f18639a.executorCount()), Integer.valueOf(i8));
            }
            entry.f18640b++;
        }
        return entry.f18639a.next();
    }

    public ChannelFactory<?> c() {
        return this.f18638c;
    }

    public synchronized void e(Executor executor) {
        Entry entry = this.f18636a.get(executor);
        int i8 = entry.f18640b - 1;
        entry.f18640b = i8;
        if (i8 == 0) {
            this.f18636a.remove(executor);
            if (!(executor instanceof MultithreadEventLoopGroup)) {
                entry.f18639a.shutdownGracefully(0L, 0L, TimeUnit.MILLISECONDS);
            }
        }
    }

    private NettyEventLoopProvider(BiFunction<Integer, Executor, MultithreadEventLoopGroup> biFunction, ChannelFactory<?> channelFactory) {
        this.f18636a = new HashMap();
        this.f18637b = biFunction;
        this.f18638c = channelFactory;
    }
}
