package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;

/* loaded from: classes5.dex */
public class CombinedChannelDuplexHandler<I extends ChannelInboundHandler, O extends ChannelOutboundHandler> extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(CombinedChannelDuplexHandler.class);
    private volatile boolean handlerAdded;
    private DelegatingChannelHandlerContext inboundCtx;
    private I inboundHandler;
    private DelegatingChannelHandlerContext outboundCtx;
    private O outboundHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DelegatingChannelHandlerContext implements ChannelHandlerContext {
        private final ChannelHandlerContext ctx;
        private final ChannelHandler handler;
        boolean removed;

        DelegatingChannelHandlerContext(ChannelHandlerContext channelHandlerContext, ChannelHandler channelHandler) {
            this.ctx = channelHandlerContext;
            this.handler = channelHandler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove0() {
            if (!this.removed) {
                this.removed = true;
                try {
                    this.handler.handlerRemoved(this);
                } catch (Throwable th) {
                    fireExceptionCaught(new ChannelPipelineException(this.handler.getClass().getName() + ".handlerRemoved() has thrown an exception.", th));
                }
            }
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ByteBufAllocator alloc() {
            return this.ctx.alloc();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public Channel channel() {
            return this.ctx.channel();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close() {
            return this.ctx.close();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
            return this.ctx.connect(socketAddress, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture disconnect(ChannelPromise channelPromise) {
            return this.ctx.disconnect(channelPromise);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public EventExecutor executor() {
            return this.ctx.executor();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelActive() {
            this.ctx.fireChannelActive();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelInactive() {
            this.ctx.fireChannelInactive();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelRead(Object obj) {
            this.ctx.fireChannelRead(obj);
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelReadComplete() {
            this.ctx.fireChannelReadComplete();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelRegistered() {
            this.ctx.fireChannelRegistered();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelUnregistered() {
            this.ctx.fireChannelUnregistered();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelWritabilityChanged() {
            this.ctx.fireChannelWritabilityChanged();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireExceptionCaught(Throwable th) {
            this.ctx.fireExceptionCaught(th);
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireUserEventTriggered(Object obj) {
            this.ctx.fireUserEventTriggered(obj);
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext flush() {
            this.ctx.flush();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this.ctx.handler();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public boolean isRemoved() {
            if (!this.removed && !this.ctx.isRemoved()) {
                return false;
            }
            return true;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public String name() {
            return this.ctx.name();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture newFailedFuture(Throwable th) {
            return this.ctx.newFailedFuture(th);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise newPromise() {
            return this.ctx.newPromise();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelPipeline pipeline() {
            return this.ctx.pipeline();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext read() {
            this.ctx.read();
            return this;
        }

        final void remove() {
            EventExecutor executor = executor();
            if (executor.inEventLoop()) {
                remove0();
            } else {
                executor.execute(new Runnable() { // from class: io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelegatingChannelHandlerContext.this.remove0();
                    }
                });
            }
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise voidPromise() {
            return this.ctx.voidPromise();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object obj) {
            return this.ctx.write(obj);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
            return this.ctx.writeAndFlush(obj, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close(ChannelPromise channelPromise) {
            return this.ctx.close(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            return this.ctx.connect(socketAddress, socketAddress2, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
            return this.ctx.write(obj, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object obj) {
            return this.ctx.writeAndFlush(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CombinedChannelDuplexHandler() {
        ensureNotSharable();
    }

    private void checkAdded() {
        if (this.handlerAdded) {
            return;
        }
        throw new IllegalStateException("handler not added to pipeline yet");
    }

    private void validate(I i8, O o8) {
        if (this.inboundHandler == null) {
            ObjectUtil.checkNotNull(i8, "inboundHandler");
            ObjectUtil.checkNotNull(o8, "outboundHandler");
            if (!(i8 instanceof ChannelOutboundHandler)) {
                if (!(o8 instanceof ChannelInboundHandler)) {
                    return;
                }
                throw new IllegalArgumentException("outboundHandler must not implement " + ChannelInboundHandler.class.getSimpleName() + " to get combined.");
            }
            throw new IllegalArgumentException("inboundHandler must not implement " + ChannelOutboundHandler.class.getSimpleName() + " to get combined.");
        }
        throw new IllegalStateException("init() can not be invoked if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with non-default constructor.");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelActive(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelActive();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelInactive(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelInactive();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelRead(delegatingChannelHandlerContext, obj);
        } else {
            delegatingChannelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelReadComplete(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelReadComplete();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelRegistered(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelRegistered();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelUnregistered(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelUnregistered();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelWritabilityChanged(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelWritabilityChanged();
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.close(delegatingChannelHandlerContext, channelPromise);
        } else {
            delegatingChannelHandlerContext.close(channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.connect(delegatingChannelHandlerContext, socketAddress, socketAddress2, channelPromise);
        } else {
            delegatingChannelHandlerContext.connect(socketAddress2, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.disconnect(delegatingChannelHandlerContext, channelPromise);
        } else {
            delegatingChannelHandlerContext.disconnect(channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.exceptionCaught(delegatingChannelHandlerContext, th);
        } else {
            delegatingChannelHandlerContext.fireExceptionCaught(th);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.flush(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.flush();
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.inboundHandler != null) {
            this.outboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.outboundHandler);
            this.inboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.inboundHandler) { // from class: io.netty.channel.CombinedChannelDuplexHandler.1
                @Override // io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext, io.netty.channel.ChannelHandlerContext
                public ChannelHandlerContext fireExceptionCaught(Throwable th) {
                    if (!CombinedChannelDuplexHandler.this.outboundCtx.removed) {
                        try {
                            CombinedChannelDuplexHandler.this.outboundHandler.exceptionCaught(CombinedChannelDuplexHandler.this.outboundCtx, th);
                        } catch (Throwable th2) {
                            if (CombinedChannelDuplexHandler.logger.isDebugEnabled()) {
                                CombinedChannelDuplexHandler.logger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                            } else if (CombinedChannelDuplexHandler.logger.isWarnEnabled()) {
                                CombinedChannelDuplexHandler.logger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                            }
                        }
                    } else {
                        super.fireExceptionCaught(th);
                    }
                    return this;
                }
            };
            this.handlerAdded = true;
            try {
                this.inboundHandler.handlerAdded(this.inboundCtx);
                return;
            } finally {
                this.outboundHandler.handlerAdded(this.outboundCtx);
            }
        }
        throw new IllegalStateException("init() must be invoked before being added to a " + ChannelPipeline.class.getSimpleName() + " if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with the default constructor.");
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            this.inboundCtx.remove();
        } finally {
            this.outboundCtx.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void init(I i8, O o8) {
        validate(i8, o8);
        this.inboundHandler = i8;
        this.outboundHandler = o8;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.read(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.read();
        }
    }

    public final void removeOutboundHandler() {
        checkAdded();
        this.outboundCtx.remove();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.userEventTriggered(delegatingChannelHandlerContext, obj);
        } else {
            delegatingChannelHandlerContext.fireUserEventTriggered(obj);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.write(delegatingChannelHandlerContext, obj, channelPromise);
        } else {
            delegatingChannelHandlerContext.write(obj, channelPromise);
        }
    }
}
