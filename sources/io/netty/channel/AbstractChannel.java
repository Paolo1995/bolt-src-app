package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelOutputShutdownEvent;
import io.netty.channel.socket.ChannelOutputShutdownException;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes5.dex */
public abstract class AbstractChannel extends DefaultAttributeMap implements Channel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractChannel.class);
    private final CloseFuture closeFuture;
    private boolean closeInitiated;
    private volatile EventLoop eventLoop;
    private final ChannelId id;
    private Throwable initialCloseCause;
    private volatile SocketAddress localAddress;
    private final Channel parent;
    private final DefaultChannelPipeline pipeline;
    private volatile boolean registered;
    private volatile SocketAddress remoteAddress;
    private String strVal;
    private boolean strValActive;
    private final Channel.Unsafe unsafe;
    private final VoidChannelPromise unsafeVoidPromise;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AnnotatedConnectException extends ConnectException {
        AnnotatedConnectException(ConnectException connectException, SocketAddress socketAddress) {
            super(connectException.getMessage() + ": " + socketAddress);
            initCause(connectException);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AnnotatedNoRouteToHostException extends NoRouteToHostException {
        AnnotatedNoRouteToHostException(NoRouteToHostException noRouteToHostException, SocketAddress socketAddress) {
            super(noRouteToHostException.getMessage() + ": " + socketAddress);
            initCause(noRouteToHostException);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AnnotatedSocketException extends SocketException {
        AnnotatedSocketException(SocketException socketException, SocketAddress socketAddress) {
            super(socketException.getMessage() + ": " + socketAddress);
            initCause(socketException);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class CloseFuture extends DefaultChannelPromise {
        CloseFuture(AbstractChannel abstractChannel) {
            super(abstractChannel);
        }

        boolean setClosed() {
            return super.trySuccess();
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.channel.ChannelPromise
        public ChannelPromise setSuccess() {
            throw new IllegalStateException();
        }

        @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
        public boolean tryFailure(Throwable th) {
            throw new IllegalStateException();
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.channel.ChannelPromise
        public boolean trySuccess() {
            throw new IllegalStateException();
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
        public ChannelPromise setFailure(Throwable th) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractChannel(Channel channel) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = channel;
        this.id = newId();
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }

    @Override // io.netty.channel.Channel
    public ByteBufAllocator alloc() {
        return config().getAllocator();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return this.pipeline.close();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.pipeline.connect(socketAddress, channelPromise);
    }

    protected abstract void doBeginRead() throws Exception;

    protected abstract void doClose() throws Exception;

    protected void doDeregister() throws Exception {
    }

    protected abstract void doDisconnect() throws Exception;

    protected void doRegister() throws Exception {
    }

    protected void doShutdownOutput() throws Exception {
        doClose();
    }

    protected abstract void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception;

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.channel.Channel
    public EventLoop eventLoop() {
        EventLoop eventLoop = this.eventLoop;
        if (eventLoop != null) {
            return eventLoop;
        }
        throw new IllegalStateException("channel not registered to an event loop");
    }

    protected Object filterOutboundMessage(Object obj) throws Exception {
        return obj;
    }

    public final int hashCode() {
        return this.id.hashCode();
    }

    @Override // io.netty.channel.Channel
    public final ChannelId id() {
        return this.id;
    }

    protected abstract boolean isCompatible(EventLoop eventLoop);

    @Override // io.netty.channel.Channel
    public boolean isRegistered() {
        return this.registered;
    }

    @Override // io.netty.channel.Channel
    public boolean isWritable() {
        ChannelOutboundBuffer outboundBuffer = this.unsafe.outboundBuffer();
        if (outboundBuffer != null && outboundBuffer.isWritable()) {
            return true;
        }
        return false;
    }

    public SocketAddress localAddress() {
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress == null) {
            try {
                SocketAddress localAddress = unsafe().localAddress();
                this.localAddress = localAddress;
                return localAddress;
            } catch (Error e8) {
                throw e8;
            } catch (Throwable unused) {
                return null;
            }
        }
        return socketAddress;
    }

    protected abstract SocketAddress localAddress0();

    protected DefaultChannelPipeline newChannelPipeline() {
        return new DefaultChannelPipeline(this);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable th) {
        return this.pipeline.newFailedFuture(th);
    }

    protected ChannelId newId() {
        return DefaultChannelId.newInstance();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return this.pipeline.newPromise();
    }

    protected abstract AbstractUnsafe newUnsafe();

    @Override // io.netty.channel.Channel
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // io.netty.channel.Channel
    public Channel read() {
        this.pipeline.read();
        return this;
    }

    public SocketAddress remoteAddress() {
        SocketAddress socketAddress = this.remoteAddress;
        if (socketAddress == null) {
            try {
                SocketAddress remoteAddress = unsafe().remoteAddress();
                this.remoteAddress = remoteAddress;
                return remoteAddress;
            } catch (Error e8) {
                throw e8;
            } catch (Throwable unused) {
                return null;
            }
        }
        return socketAddress;
    }

    protected abstract SocketAddress remoteAddress0();

    public String toString() {
        String str;
        String str2;
        boolean isActive = isActive();
        if (this.strValActive == isActive && (str2 = this.strVal) != null) {
            return str2;
        }
        SocketAddress remoteAddress = remoteAddress();
        SocketAddress localAddress = localAddress();
        if (remoteAddress != null) {
            StringBuilder sb = new StringBuilder(96);
            sb.append("[id: 0x");
            sb.append(this.id.asShortText());
            sb.append(", L:");
            sb.append(localAddress);
            if (isActive) {
                str = " - ";
            } else {
                str = " ! ";
            }
            sb.append(str);
            sb.append("R:");
            sb.append(remoteAddress);
            sb.append(']');
            this.strVal = sb.toString();
        } else if (localAddress != null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("[id: 0x");
            sb2.append(this.id.asShortText());
            sb2.append(", L:");
            sb2.append(localAddress);
            sb2.append(']');
            this.strVal = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder(16);
            sb3.append("[id: 0x");
            sb3.append(this.id.asShortText());
            sb3.append(']');
            this.strVal = sb3.toString();
        }
        this.strValActive = isActive;
        return this.strVal;
    }

    @Override // io.netty.channel.Channel
    public Channel.Unsafe unsafe() {
        return this.unsafe;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise voidPromise() {
        return this.pipeline.voidPromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj) {
        return this.pipeline.writeAndFlush(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public abstract class AbstractUnsafe implements Channel.Unsafe {
        private boolean inFlush0;
        private boolean neverRegistered = true;
        private volatile ChannelOutboundBuffer outboundBuffer;
        private RecvByteBufAllocator.Handle recvHandle;

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractUnsafe() {
            this.outboundBuffer = new ChannelOutboundBuffer(AbstractChannel.this);
        }

        private void assertEventLoop() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeOutboundBufferForShutdown(ChannelPipeline channelPipeline, ChannelOutboundBuffer channelOutboundBuffer, Throwable th) {
            channelOutboundBuffer.failFlushed(th, false);
            channelOutboundBuffer.close(th, true);
            channelPipeline.fireUserEventTriggered(ChannelOutputShutdownEvent.INSTANCE);
        }

        private void deregister(final ChannelPromise channelPromise, final boolean z7) {
            if (!channelPromise.setUncancellable()) {
                return;
            }
            if (!AbstractChannel.this.registered) {
                safeSetSuccess(channelPromise);
            } else {
                invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.8
                    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
                        if (r4.this$1.this$0.registered == false) goto L10;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
                        return;
                     */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void run() {
                        /*
                            r4 = this;
                            r0 = 0
                            io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this     // Catch: java.lang.Throwable -> L3b
                            io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this     // Catch: java.lang.Throwable -> L3b
                            r1.doDeregister()     // Catch: java.lang.Throwable -> L3b
                            boolean r1 = r2
                            if (r1 == 0) goto L17
                            io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                            io.netty.channel.DefaultChannelPipeline r1 = io.netty.channel.AbstractChannel.access$500(r1)
                            r1.fireChannelInactive()
                        L17:
                            io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                            boolean r1 = io.netty.channel.AbstractChannel.access$000(r1)
                            if (r1 == 0) goto L33
                        L21:
                            io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                            io.netty.channel.AbstractChannel.access$002(r1, r0)
                            io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r0 = io.netty.channel.AbstractChannel.this
                            io.netty.channel.DefaultChannelPipeline r0 = io.netty.channel.AbstractChannel.access$500(r0)
                            r0.fireChannelUnregistered()
                        L33:
                            io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.ChannelPromise r1 = r3
                            r0.safeSetSuccess(r1)
                            goto L5f
                        L3b:
                            r1 = move-exception
                            io.netty.util.internal.logging.InternalLogger r2 = io.netty.channel.AbstractChannel.access$300()     // Catch: java.lang.Throwable -> L60
                            java.lang.String r3 = "Unexpected exception occurred while deregistering a channel."
                            r2.warn(r3, r1)     // Catch: java.lang.Throwable -> L60
                            boolean r1 = r2
                            if (r1 == 0) goto L54
                            io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                            io.netty.channel.DefaultChannelPipeline r1 = io.netty.channel.AbstractChannel.access$500(r1)
                            r1.fireChannelInactive()
                        L54:
                            io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                            boolean r1 = io.netty.channel.AbstractChannel.access$000(r1)
                            if (r1 == 0) goto L33
                            goto L21
                        L5f:
                            return
                        L60:
                            r1 = move-exception
                            boolean r2 = r2
                            if (r2 == 0) goto L70
                            io.netty.channel.AbstractChannel$AbstractUnsafe r2 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                            io.netty.channel.DefaultChannelPipeline r2 = io.netty.channel.AbstractChannel.access$500(r2)
                            r2.fireChannelInactive()
                        L70:
                            io.netty.channel.AbstractChannel$AbstractUnsafe r2 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                            boolean r2 = io.netty.channel.AbstractChannel.access$000(r2)
                            if (r2 == 0) goto L8c
                            io.netty.channel.AbstractChannel$AbstractUnsafe r2 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                            io.netty.channel.AbstractChannel.access$002(r2, r0)
                            io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.AbstractChannel r0 = io.netty.channel.AbstractChannel.this
                            io.netty.channel.DefaultChannelPipeline r0 = io.netty.channel.AbstractChannel.access$500(r0)
                            r0.fireChannelUnregistered()
                        L8c:
                            io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                            io.netty.channel.ChannelPromise r2 = r3
                            r0.safeSetSuccess(r2)
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.AbstractChannel.AbstractUnsafe.AnonymousClass8.run():void");
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doClose0(ChannelPromise channelPromise) {
            try {
                AbstractChannel.this.doClose();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetSuccess(channelPromise);
            } catch (Throwable th) {
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(channelPromise, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fireChannelInactiveAndDeregister(boolean z7) {
            boolean z8;
            ChannelPromise voidPromise = voidPromise();
            if (z7 && !AbstractChannel.this.isActive()) {
                z8 = true;
            } else {
                z8 = false;
            }
            deregister(voidPromise, z8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invokeLater(Runnable runnable) {
            try {
                AbstractChannel.this.eventLoop().execute(runnable);
            } catch (RejectedExecutionException e8) {
                AbstractChannel.logger.warn("Can't invoke task later as EventLoop rejected it", (Throwable) e8);
            }
        }

        private ClosedChannelException newClosedChannelException(Throwable th) {
            ClosedChannelException closedChannelException = new ClosedChannelException();
            if (th != null) {
                closedChannelException.initCause(th);
            }
            return closedChannelException;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void register0(ChannelPromise channelPromise) {
            try {
                if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                    boolean z7 = this.neverRegistered;
                    AbstractChannel.this.doRegister();
                    this.neverRegistered = false;
                    AbstractChannel.this.registered = true;
                    AbstractChannel.this.pipeline.invokeHandlerAddedIfNeeded();
                    safeSetSuccess(channelPromise);
                    AbstractChannel.this.pipeline.fireChannelRegistered();
                    if (AbstractChannel.this.isActive()) {
                        if (z7) {
                            AbstractChannel.this.pipeline.fireChannelActive();
                        } else if (AbstractChannel.this.config().isAutoRead()) {
                            beginRead();
                        }
                    }
                }
            } catch (Throwable th) {
                closeForcibly();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(channelPromise, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final Throwable annotateConnectException(Throwable th, SocketAddress socketAddress) {
            if (th instanceof ConnectException) {
                return new AnnotatedConnectException((ConnectException) th, socketAddress);
            }
            if (th instanceof NoRouteToHostException) {
                return new AnnotatedNoRouteToHostException((NoRouteToHostException) th, socketAddress);
            }
            if (th instanceof SocketException) {
                return new AnnotatedSocketException((SocketException) th, socketAddress);
            }
            return th;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void beginRead() {
            assertEventLoop();
            if (!AbstractChannel.this.isActive()) {
                return;
            }
            try {
                AbstractChannel.this.doBeginRead();
            } catch (Exception e8) {
                invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.9
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractChannel.this.pipeline.fireExceptionCaught(e8);
                    }
                });
                close(voidPromise());
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void close(ChannelPromise channelPromise) {
            assertEventLoop();
            ClosedChannelException closedChannelException = new ClosedChannelException();
            close(channelPromise, closedChannelException, closedChannelException, false);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void closeForcibly() {
            assertEventLoop();
            try {
                AbstractChannel.this.doClose();
            } catch (Exception e8) {
                AbstractChannel.logger.warn("Failed to close a channel.", (Throwable) e8);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void closeIfClosed() {
            if (AbstractChannel.this.isOpen()) {
                return;
            }
            close(voidPromise());
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void disconnect(ChannelPromise channelPromise) {
            assertEventLoop();
            if (!channelPromise.setUncancellable()) {
                return;
            }
            boolean isActive = AbstractChannel.this.isActive();
            try {
                AbstractChannel.this.doDisconnect();
                AbstractChannel.this.remoteAddress = null;
                AbstractChannel.this.localAddress = null;
                if (isActive && !AbstractChannel.this.isActive()) {
                    invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.3
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractChannel.this.pipeline.fireChannelInactive();
                        }
                    });
                }
                safeSetSuccess(channelPromise);
                closeIfClosed();
            } catch (Throwable th) {
                safeSetFailure(channelPromise, th);
                closeIfClosed();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final boolean ensureOpen(ChannelPromise channelPromise) {
            if (AbstractChannel.this.isOpen()) {
                return true;
            }
            safeSetFailure(channelPromise, newClosedChannelException(AbstractChannel.this.initialCloseCause));
            return false;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void flush() {
            assertEventLoop();
            ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
            if (channelOutboundBuffer == null) {
                return;
            }
            channelOutboundBuffer.addFlush();
            flush0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void flush0() {
            ChannelOutboundBuffer channelOutboundBuffer;
            if (!this.inFlush0 && (channelOutboundBuffer = this.outboundBuffer) != null && !channelOutboundBuffer.isEmpty()) {
                this.inFlush0 = true;
                if (!AbstractChannel.this.isActive()) {
                    try {
                        if (AbstractChannel.this.isOpen()) {
                            channelOutboundBuffer.failFlushed(new NotYetConnectedException(), true);
                        } else {
                            channelOutboundBuffer.failFlushed(newClosedChannelException(AbstractChannel.this.initialCloseCause), false);
                        }
                        return;
                    } finally {
                    }
                }
                try {
                    AbstractChannel.this.doWrite(channelOutboundBuffer);
                } catch (Throwable th) {
                    try {
                        if ((th instanceof IOException) && AbstractChannel.this.config().isAutoClose()) {
                            AbstractChannel.this.initialCloseCause = th;
                            close(voidPromise(), th, newClosedChannelException(th), false);
                        } else {
                            shutdownOutput(voidPromise(), th);
                        }
                    } finally {
                    }
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final SocketAddress localAddress() {
            return AbstractChannel.this.localAddress0();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final ChannelOutboundBuffer outboundBuffer() {
            return this.outboundBuffer;
        }

        protected Executor prepareToClose() {
            return null;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public RecvByteBufAllocator.Handle recvBufAllocHandle() {
            if (this.recvHandle == null) {
                this.recvHandle = AbstractChannel.this.config().getRecvByteBufAllocator().newHandle();
            }
            return this.recvHandle;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void register(EventLoop eventLoop, final ChannelPromise channelPromise) {
            ObjectUtil.checkNotNull(eventLoop, "eventLoop");
            if (AbstractChannel.this.isRegistered()) {
                channelPromise.setFailure((Throwable) new IllegalStateException("registered to an event loop already"));
            } else if (AbstractChannel.this.isCompatible(eventLoop)) {
                AbstractChannel.this.eventLoop = eventLoop;
                if (eventLoop.inEventLoop()) {
                    register0(channelPromise);
                    return;
                }
                try {
                    eventLoop.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractUnsafe.this.register0(channelPromise);
                        }
                    });
                } catch (Throwable th) {
                    AbstractChannel.logger.warn("Force-closing a channel whose registration task was not accepted by an event loop: {}", AbstractChannel.this, th);
                    closeForcibly();
                    AbstractChannel.this.closeFuture.setClosed();
                    safeSetFailure(channelPromise, th);
                }
            } else {
                channelPromise.setFailure((Throwable) new IllegalStateException("incompatible event loop type: " + eventLoop.getClass().getName()));
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final SocketAddress remoteAddress() {
            return AbstractChannel.this.remoteAddress0();
        }

        protected final void safeSetFailure(ChannelPromise channelPromise, Throwable th) {
            if (!(channelPromise instanceof VoidChannelPromise) && !channelPromise.tryFailure(th)) {
                AbstractChannel.logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void safeSetSuccess(ChannelPromise channelPromise) {
            if (!(channelPromise instanceof VoidChannelPromise) && !channelPromise.trySuccess()) {
                AbstractChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", channelPromise);
            }
        }

        public final void shutdownOutput(ChannelPromise channelPromise) {
            assertEventLoop();
            shutdownOutput(channelPromise, null);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final ChannelPromise voidPromise() {
            assertEventLoop();
            return AbstractChannel.this.unsafeVoidPromise;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void write(Object obj, ChannelPromise channelPromise) {
            assertEventLoop();
            ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
            if (channelOutboundBuffer == null) {
                safeSetFailure(channelPromise, newClosedChannelException(AbstractChannel.this.initialCloseCause));
                ReferenceCountUtil.release(obj);
                return;
            }
            try {
                obj = AbstractChannel.this.filterOutboundMessage(obj);
                int size = AbstractChannel.this.pipeline.estimatorHandle().size(obj);
                if (size < 0) {
                    size = 0;
                }
                channelOutboundBuffer.addMessage(obj, size, channelPromise);
            } catch (Throwable th) {
                safeSetFailure(channelPromise, th);
                ReferenceCountUtil.release(obj);
            }
        }

        private void shutdownOutput(final ChannelPromise channelPromise, Throwable th) {
            if (channelPromise.setUncancellable()) {
                final ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
                if (channelOutboundBuffer == null) {
                    channelPromise.setFailure((Throwable) new ClosedChannelException());
                    return;
                }
                this.outboundBuffer = null;
                final ChannelOutputShutdownException channelOutputShutdownException = th == null ? new ChannelOutputShutdownException("Channel output shutdown") : new ChannelOutputShutdownException("Channel output shutdown", th);
                Executor prepareToClose = prepareToClose();
                if (prepareToClose != null) {
                    prepareToClose.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4
                        @Override // java.lang.Runnable
                        public void run() {
                            EventLoop eventLoop;
                            Runnable runnable;
                            try {
                                AbstractChannel.this.doShutdownOutput();
                                channelPromise.setSuccess();
                                eventLoop = AbstractChannel.this.eventLoop();
                                runnable = new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AbstractUnsafe abstractUnsafe = AbstractUnsafe.this;
                                        DefaultChannelPipeline defaultChannelPipeline = AbstractChannel.this.pipeline;
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        abstractUnsafe.closeOutboundBufferForShutdown(defaultChannelPipeline, channelOutboundBuffer, channelOutputShutdownException);
                                    }
                                };
                            } catch (Throwable th2) {
                                try {
                                    channelPromise.setFailure(th2);
                                    eventLoop = AbstractChannel.this.eventLoop();
                                    runnable = new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AbstractUnsafe abstractUnsafe = AbstractUnsafe.this;
                                            DefaultChannelPipeline defaultChannelPipeline = AbstractChannel.this.pipeline;
                                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                            abstractUnsafe.closeOutboundBufferForShutdown(defaultChannelPipeline, channelOutboundBuffer, channelOutputShutdownException);
                                        }
                                    };
                                } catch (Throwable th3) {
                                    AbstractChannel.this.eventLoop().execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AbstractUnsafe abstractUnsafe = AbstractUnsafe.this;
                                            DefaultChannelPipeline defaultChannelPipeline = AbstractChannel.this.pipeline;
                                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                            abstractUnsafe.closeOutboundBufferForShutdown(defaultChannelPipeline, channelOutboundBuffer, channelOutputShutdownException);
                                        }
                                    });
                                    throw th3;
                                }
                            }
                            eventLoop.execute(runnable);
                        }
                    });
                    return;
                }
                try {
                    AbstractChannel.this.doShutdownOutput();
                    channelPromise.setSuccess();
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        private void close(final ChannelPromise channelPromise, final Throwable th, final ClosedChannelException closedChannelException, final boolean z7) {
            if (channelPromise.setUncancellable()) {
                if (AbstractChannel.this.closeInitiated) {
                    if (AbstractChannel.this.closeFuture.isDone()) {
                        safeSetSuccess(channelPromise);
                        return;
                    } else if (channelPromise instanceof VoidChannelPromise) {
                        return;
                    } else {
                        AbstractChannel.this.closeFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.5
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                channelPromise.setSuccess();
                            }
                        });
                        return;
                    }
                }
                AbstractChannel.this.closeInitiated = true;
                final boolean isActive = AbstractChannel.this.isActive();
                final ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
                this.outboundBuffer = null;
                Executor prepareToClose = prepareToClose();
                if (prepareToClose != null) {
                    prepareToClose.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.6
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AbstractUnsafe.this.doClose0(channelPromise);
                            } finally {
                                AbstractUnsafe.this.invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.6.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                        ChannelOutboundBuffer channelOutboundBuffer2 = channelOutboundBuffer;
                                        if (channelOutboundBuffer2 != null) {
                                            channelOutboundBuffer2.failFlushed(th, z7);
                                            AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                                            channelOutboundBuffer.close(closedChannelException);
                                        }
                                        AnonymousClass6 anonymousClass63 = AnonymousClass6.this;
                                        AbstractUnsafe.this.fireChannelInactiveAndDeregister(isActive);
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                try {
                    doClose0(channelPromise);
                    if (this.inFlush0) {
                        invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.7
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractUnsafe.this.fireChannelInactiveAndDeregister(isActive);
                            }
                        });
                    } else {
                        fireChannelInactiveAndDeregister(isActive);
                    }
                } finally {
                    if (channelOutboundBuffer != null) {
                        channelOutboundBuffer.failFlushed(th, z7);
                        channelOutboundBuffer.close(closedChannelException);
                    }
                }
            }
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(ChannelPromise channelPromise) {
        return this.pipeline.close(channelPromise);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Channel channel) {
        if (this == channel) {
            return 0;
        }
        return id().compareTo(channel.id());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        return this.pipeline.connect(socketAddress, socketAddress2, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractChannel(Channel channel, ChannelId channelId) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = channel;
        this.id = channelId;
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }
}
