package io.netty.channel;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ChannelHandlerMask {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelHandlerMask.class);
    private static final FastThreadLocal<Map<Class<? extends ChannelHandler>, Integer>> MASKS = new FastThreadLocal<Map<Class<? extends ChannelHandler>, Integer>>() { // from class: io.netty.channel.ChannelHandlerMask.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Map<Class<? extends ChannelHandler>, Integer> initialValue() {
            return new WeakHashMap(32);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes5.dex */
    public @interface Skip {
    }

    private ChannelHandlerMask() {
    }

    private static boolean isSkippable(final Class<?> cls, final String str, final Class<?>... clsArr) throws Exception {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() { // from class: io.netty.channel.ChannelHandlerMask.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedExceptionAction
            public Boolean run() throws Exception {
                boolean z7 = true;
                try {
                    Method method = cls.getMethod(str, clsArr);
                    return Boolean.valueOf((method == null || !method.isAnnotationPresent(Skip.class)) ? false : false);
                } catch (NoSuchMethodException e8) {
                    if (ChannelHandlerMask.logger.isDebugEnabled()) {
                        ChannelHandlerMask.logger.debug("Class {} missing method {}, assume we can not skip execution", cls, str, e8);
                    }
                    return Boolean.FALSE;
                }
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mask(Class<? extends ChannelHandler> cls) {
        Map<Class<? extends ChannelHandler>, Integer> map = MASKS.get();
        Integer num = map.get(cls);
        if (num == null) {
            num = Integer.valueOf(mask0(cls));
            map.put(cls, num);
        }
        return num.intValue();
    }

    private static int mask0(Class<? extends ChannelHandler> cls) {
        int i8;
        int i9 = 1;
        try {
            if (ChannelInboundHandler.class.isAssignableFrom(cls)) {
                i8 = 511;
                try {
                    if (isSkippable(cls, "channelRegistered", ChannelHandlerContext.class)) {
                        i8 = 509;
                    }
                } catch (Exception e8) {
                    e = e8;
                    i9 = 511;
                    PlatformDependent.throwException(e);
                    return i9;
                }
                try {
                    if (isSkippable(cls, "channelUnregistered", ChannelHandlerContext.class)) {
                        i8 &= -5;
                    }
                    if (isSkippable(cls, "channelActive", ChannelHandlerContext.class)) {
                        i8 &= -9;
                    }
                    if (isSkippable(cls, "channelInactive", ChannelHandlerContext.class)) {
                        i8 &= -17;
                    }
                    if (isSkippable(cls, "channelRead", ChannelHandlerContext.class, Object.class)) {
                        i8 &= -33;
                    }
                    if (isSkippable(cls, "channelReadComplete", ChannelHandlerContext.class)) {
                        i8 &= -65;
                    }
                    if (isSkippable(cls, "channelWritabilityChanged", ChannelHandlerContext.class)) {
                        i8 &= -257;
                    }
                    if (isSkippable(cls, "userEventTriggered", ChannelHandlerContext.class, Object.class)) {
                        i8 &= -129;
                    }
                } catch (Exception e9) {
                    e = e9;
                    i9 = i8;
                    PlatformDependent.throwException(e);
                    return i9;
                }
            } else {
                i8 = 1;
            }
            if (ChannelOutboundHandler.class.isAssignableFrom(cls)) {
                i8 |= 130561;
                if (isSkippable(cls, "bind", ChannelHandlerContext.class, SocketAddress.class, ChannelPromise.class)) {
                    i8 &= -513;
                }
                if (isSkippable(cls, "connect", ChannelHandlerContext.class, SocketAddress.class, SocketAddress.class, ChannelPromise.class)) {
                    i8 &= -1025;
                }
                if (isSkippable(cls, "disconnect", ChannelHandlerContext.class, ChannelPromise.class)) {
                    i8 &= -2049;
                }
                if (isSkippable(cls, "close", ChannelHandlerContext.class, ChannelPromise.class)) {
                    i8 &= -4097;
                }
                if (isSkippable(cls, "deregister", ChannelHandlerContext.class, ChannelPromise.class)) {
                    i8 &= -8193;
                }
                if (isSkippable(cls, "read", ChannelHandlerContext.class)) {
                    i8 &= -16385;
                }
                if (isSkippable(cls, "write", ChannelHandlerContext.class, Object.class, ChannelPromise.class)) {
                    i8 = (-32769) & i8;
                }
                if (isSkippable(cls, "flush", ChannelHandlerContext.class)) {
                    i8 &= -65537;
                }
            }
            if (isSkippable(cls, "exceptionCaught", ChannelHandlerContext.class, Throwable.class)) {
                return i8 & (-2);
            }
            return i8;
        } catch (Exception e10) {
            e = e10;
        }
    }
}
