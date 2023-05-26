package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractCoalescingBufferQueue;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ImmediateExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

/* loaded from: classes5.dex */
public class SslHandler extends ByteToMessageDecoder implements ChannelOutboundHandler {
    private boolean closeNotify;
    private volatile long closeNotifyFlushTimeoutMillis;
    private volatile long closeNotifyReadTimeoutMillis;
    private volatile ChannelHandlerContext ctx;
    private final Executor delegatedTaskExecutor;
    private final SSLEngine engine;
    private final SslEngineType engineType;
    private boolean firedChannelRead;
    private boolean flushedBeforeHandshake;
    private Promise<Channel> handshakePromise;
    private boolean handshakeStarted;
    private volatile long handshakeTimeoutMillis;
    private final boolean jdkCompatibilityMode;
    private boolean needsFlush;
    private boolean outboundClosed;
    private int packetLength;
    private SslHandlerCoalescingBufferQueue pendingUnencryptedWrites;
    private boolean processTask;
    private boolean readDuringHandshake;
    private boolean sentFirstMessage;
    private final ByteBuffer[] singleBuffer;
    private final LazyChannelPromise sslClosePromise;
    private final boolean startTls;
    volatile int wrapDataSize;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SslHandler.class);
    private static final Pattern IGNORABLE_CLASS_IN_STACK = Pattern.compile("^.*(?:Socket|Datagram|Sctp|Udt)Channel.*$");
    private static final Pattern IGNORABLE_ERROR_MESSAGE = Pattern.compile("^.*(?:connection.*(?:reset|closed|abort|broken)|broken.*pipe).*$", 2);

    /* renamed from: io.netty.handler.ssl.SslHandler$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Runnable {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.SslHandler$9  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;

        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = iArr;
            try {
                iArr[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr2;
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class LazyChannelPromise extends DefaultPromise<Channel> {
        private LazyChannelPromise() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
            if (SslHandler.this.ctx == null) {
                return;
            }
            super.checkDeadLock();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.DefaultPromise
        public EventExecutor executor() {
            if (SslHandler.this.ctx != null) {
                return SslHandler.this.ctx.executor();
            }
            throw new IllegalStateException();
        }

        /* synthetic */ LazyChannelPromise(SslHandler sslHandler, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum TCNATIVE uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static abstract class SslEngineType {
        private static final /* synthetic */ SslEngineType[] $VALUES;
        public static final SslEngineType CONSCRYPT;
        public static final SslEngineType JDK;
        public static final SslEngineType TCNATIVE;
        final ByteToMessageDecoder.Cumulator cumulator;
        final boolean wantsDirectBuffer;

        static {
            ByteToMessageDecoder.Cumulator cumulator = ByteToMessageDecoder.COMPOSITE_CUMULATOR;
            SslEngineType sslEngineType = new SslEngineType("TCNATIVE", 0, true, cumulator) { // from class: io.netty.handler.ssl.SslHandler.SslEngineType.1
                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                ByteBuf allocateWrapBuffer(SslHandler sslHandler, ByteBufAllocator byteBufAllocator, int i8, int i9) {
                    return byteBufAllocator.directBuffer(((ReferenceCountedOpenSslEngine) sslHandler.engine).calculateMaxLengthForWrap(i8, i9));
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int calculatePendingData(SslHandler sslHandler, int i8) {
                    int sslPending = ((ReferenceCountedOpenSslEngine) sslHandler.engine).sslPending();
                    if (sslPending > 0) {
                        return sslPending;
                    }
                    return i8;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                boolean jdkCompatibilityMode(SSLEngine sSLEngine) {
                    return ((ReferenceCountedOpenSslEngine) sSLEngine).jdkCompatibilityMode;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i8, int i9, ByteBuf byteBuf2) throws SSLException {
                    SSLEngineResult unwrap;
                    int nioBufferCount = byteBuf.nioBufferCount();
                    int writerIndex = byteBuf2.writerIndex();
                    if (nioBufferCount > 1) {
                        ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = (ReferenceCountedOpenSslEngine) sslHandler.engine;
                        try {
                            sslHandler.singleBuffer[0] = SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes());
                            unwrap = referenceCountedOpenSslEngine.unwrap(byteBuf.nioBuffers(i8, i9), sslHandler.singleBuffer);
                        } finally {
                            sslHandler.singleBuffer[0] = null;
                        }
                    } else {
                        unwrap = sslHandler.engine.unwrap(SslHandler.toByteBuffer(byteBuf, i8, i9), SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
                    }
                    byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
                    return unwrap;
                }
            };
            TCNATIVE = sslEngineType;
            SslEngineType sslEngineType2 = new SslEngineType("CONSCRYPT", 1, true, cumulator) { // from class: io.netty.handler.ssl.SslHandler.SslEngineType.2
                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                ByteBuf allocateWrapBuffer(SslHandler sslHandler, ByteBufAllocator byteBufAllocator, int i8, int i9) {
                    return byteBufAllocator.directBuffer(((ConscryptAlpnSslEngine) sslHandler.engine).calculateOutNetBufSize(i8, i9));
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int calculatePendingData(SslHandler sslHandler, int i8) {
                    return i8;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                boolean jdkCompatibilityMode(SSLEngine sSLEngine) {
                    return true;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i8, int i9, ByteBuf byteBuf2) throws SSLException {
                    SSLEngineResult unwrap;
                    int nioBufferCount = byteBuf.nioBufferCount();
                    int writerIndex = byteBuf2.writerIndex();
                    if (nioBufferCount > 1) {
                        try {
                            sslHandler.singleBuffer[0] = SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes());
                            unwrap = ((ConscryptAlpnSslEngine) sslHandler.engine).unwrap(byteBuf.nioBuffers(i8, i9), sslHandler.singleBuffer);
                        } finally {
                            sslHandler.singleBuffer[0] = null;
                        }
                    } else {
                        unwrap = sslHandler.engine.unwrap(SslHandler.toByteBuffer(byteBuf, i8, i9), SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
                    }
                    byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
                    return unwrap;
                }
            };
            CONSCRYPT = sslEngineType2;
            SslEngineType sslEngineType3 = new SslEngineType("JDK", 2, false, ByteToMessageDecoder.MERGE_CUMULATOR) { // from class: io.netty.handler.ssl.SslHandler.SslEngineType.3
                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                ByteBuf allocateWrapBuffer(SslHandler sslHandler, ByteBufAllocator byteBufAllocator, int i8, int i9) {
                    return byteBufAllocator.heapBuffer(sslHandler.engine.getSession().getPacketBufferSize());
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int calculatePendingData(SslHandler sslHandler, int i8) {
                    return i8;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                boolean jdkCompatibilityMode(SSLEngine sSLEngine) {
                    return true;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i8, int i9, ByteBuf byteBuf2) throws SSLException {
                    int position;
                    int writerIndex = byteBuf2.writerIndex();
                    ByteBuffer byteBuffer = SslHandler.toByteBuffer(byteBuf, i8, i9);
                    int position2 = byteBuffer.position();
                    SSLEngineResult unwrap = sslHandler.engine.unwrap(byteBuffer, SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
                    byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
                    if (unwrap.bytesConsumed() == 0 && (position = byteBuffer.position() - position2) != unwrap.bytesConsumed()) {
                        return new SSLEngineResult(unwrap.getStatus(), unwrap.getHandshakeStatus(), position, unwrap.bytesProduced());
                    }
                    return unwrap;
                }
            };
            JDK = sslEngineType3;
            $VALUES = new SslEngineType[]{sslEngineType, sslEngineType2, sslEngineType3};
        }

        /* synthetic */ SslEngineType(String str, int i8, boolean z7, ByteToMessageDecoder.Cumulator cumulator, AnonymousClass1 anonymousClass1) {
            this(str, i8, z7, cumulator);
        }

        static SslEngineType forEngine(SSLEngine sSLEngine) {
            if (sSLEngine instanceof ReferenceCountedOpenSslEngine) {
                return TCNATIVE;
            }
            if (sSLEngine instanceof ConscryptAlpnSslEngine) {
                return CONSCRYPT;
            }
            return JDK;
        }

        public static SslEngineType valueOf(String str) {
            return (SslEngineType) Enum.valueOf(SslEngineType.class, str);
        }

        public static SslEngineType[] values() {
            return (SslEngineType[]) $VALUES.clone();
        }

        abstract ByteBuf allocateWrapBuffer(SslHandler sslHandler, ByteBufAllocator byteBufAllocator, int i8, int i9);

        abstract int calculatePendingData(SslHandler sslHandler, int i8);

        abstract boolean jdkCompatibilityMode(SSLEngine sSLEngine);

        abstract SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i8, int i9, ByteBuf byteBuf2) throws SSLException;

        private SslEngineType(String str, int i8, boolean z7, ByteToMessageDecoder.Cumulator cumulator) {
            this.wantsDirectBuffer = z7;
            this.cumulator = cumulator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class SslHandlerCoalescingBufferQueue extends AbstractCoalescingBufferQueue {
        SslHandlerCoalescingBufferQueue(Channel channel, int i8) {
            super(channel, i8);
        }

        @Override // io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf compose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            int i8 = SslHandler.this.wrapDataSize;
            if (byteBuf instanceof CompositeByteBuf) {
                CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
                int numComponents = compositeByteBuf.numComponents();
                if (numComponents == 0 || !SslHandler.attemptCopyToCumulation(compositeByteBuf.internalComponent(numComponents - 1), byteBuf2, i8)) {
                    compositeByteBuf.addComponent(true, byteBuf2);
                }
                return compositeByteBuf;
            } else if (!SslHandler.attemptCopyToCumulation(byteBuf, byteBuf2, i8)) {
                return copyAndCompose(byteBufAllocator, byteBuf, byteBuf2);
            } else {
                return byteBuf;
            }
        }

        @Override // io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf composeFirst(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
            ByteBuf heapBuffer;
            if (byteBuf instanceof CompositeByteBuf) {
                CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
                if (SslHandler.this.engineType.wantsDirectBuffer) {
                    heapBuffer = byteBufAllocator.directBuffer(compositeByteBuf.readableBytes());
                } else {
                    heapBuffer = byteBufAllocator.heapBuffer(compositeByteBuf.readableBytes());
                }
                try {
                    heapBuffer.writeBytes(compositeByteBuf);
                } catch (Throwable th) {
                    heapBuffer.release();
                    PlatformDependent.throwException(th);
                }
                compositeByteBuf.release();
                return heapBuffer;
            }
            return byteBuf;
        }

        @Override // io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf removeEmptyValue() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class SslTasksRunner implements Runnable {
        private final boolean inUnwrap;

        SslTasksRunner(boolean z7) {
            this.inUnwrap = z7;
        }

        private void handleException(final Throwable th) {
            if (SslHandler.this.ctx.executor().inEventLoop()) {
                SslHandler.this.processTask = false;
                safeExceptionCaught(th);
                return;
            }
            try {
                SslHandler.this.ctx.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.SslTasksRunner.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SslHandler.this.processTask = false;
                        SslTasksRunner.this.safeExceptionCaught(th);
                    }
                });
            } catch (RejectedExecutionException unused) {
                SslHandler.this.processTask = false;
                SslHandler.this.ctx.fireExceptionCaught(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resumeOnEventExecutor() {
            SslHandler.this.processTask = false;
            try {
                int i8 = AnonymousClass9.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SslHandler.this.engine.getHandshakeStatus().ordinal()];
                if (i8 == 1) {
                    SslHandler.this.executeDelegatedTasks(this.inUnwrap);
                    return;
                }
                if (i8 == 2) {
                    SslHandler.this.setHandshakeSuccess();
                } else if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 == 5) {
                            try {
                                SslHandler sslHandler = SslHandler.this;
                                sslHandler.unwrapNonAppData(sslHandler.ctx);
                                tryDecodeAgain();
                                return;
                            } catch (SSLException e8) {
                                SslHandler sslHandler2 = SslHandler.this;
                                sslHandler2.handleUnwrapThrowable(sslHandler2.ctx, e8);
                                return;
                            }
                        }
                        throw new AssertionError();
                    }
                    SslHandler sslHandler3 = SslHandler.this;
                    if (!sslHandler3.wrapNonAppData(sslHandler3.ctx, false) && this.inUnwrap) {
                        SslHandler sslHandler4 = SslHandler.this;
                        sslHandler4.unwrapNonAppData(sslHandler4.ctx);
                    }
                    SslHandler sslHandler5 = SslHandler.this;
                    sslHandler5.forceFlush(sslHandler5.ctx);
                    tryDecodeAgain();
                    return;
                }
                SslHandler.this.setHandshakeSuccessIfStillHandshaking();
                SslHandler sslHandler6 = SslHandler.this;
                sslHandler6.wrap(sslHandler6.ctx, this.inUnwrap);
                if (this.inUnwrap) {
                    SslHandler sslHandler7 = SslHandler.this;
                    sslHandler7.unwrapNonAppData(sslHandler7.ctx);
                }
                SslHandler sslHandler8 = SslHandler.this;
                sslHandler8.forceFlush(sslHandler8.ctx);
                tryDecodeAgain();
            } catch (Throwable th) {
                safeExceptionCaught(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void safeExceptionCaught(Throwable th) {
            try {
                SslHandler sslHandler = SslHandler.this;
                sslHandler.exceptionCaught(sslHandler.ctx, wrapIfNeeded(th));
            } catch (Throwable th2) {
                SslHandler.this.ctx.fireExceptionCaught(th2);
            }
        }

        private void taskError(Throwable th) {
            if (this.inUnwrap) {
                try {
                    SslHandler sslHandler = SslHandler.this;
                    sslHandler.handleUnwrapThrowable(sslHandler.ctx, th);
                    return;
                } catch (Throwable th2) {
                    safeExceptionCaught(th2);
                    return;
                }
            }
            SslHandler sslHandler2 = SslHandler.this;
            sslHandler2.setHandshakeFailure(sslHandler2.ctx, th);
            SslHandler sslHandler3 = SslHandler.this;
            sslHandler3.forceFlush(sslHandler3.ctx);
        }

        private void tryDecodeAgain() {
            try {
                SslHandler sslHandler = SslHandler.this;
                sslHandler.channelRead(sslHandler.ctx, Unpooled.EMPTY_BUFFER);
            } finally {
                try {
                    SslHandler sslHandler2 = SslHandler.this;
                    sslHandler2.channelReadComplete0(sslHandler2.ctx);
                } catch (Throwable th) {
                }
            }
            SslHandler sslHandler22 = SslHandler.this;
            sslHandler22.channelReadComplete0(sslHandler22.ctx);
        }

        private Throwable wrapIfNeeded(Throwable th) {
            if (!this.inUnwrap) {
                return th;
            }
            if (!(th instanceof DecoderException)) {
                return new DecoderException(th);
            }
            return th;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SslHandler.runAllDelegatedTasks(SslHandler.this.engine);
                SslHandler.this.ctx.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.SslTasksRunner.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SslTasksRunner.this.resumeOnEventExecutor();
                    }
                });
            } catch (Throwable th) {
                handleException(th);
            }
        }
    }

    public SslHandler(SSLEngine sSLEngine, boolean z7) {
        this(sSLEngine, z7, ImmediateExecutor.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addCloseListener(ChannelFuture channelFuture, ChannelPromise channelPromise) {
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise));
    }

    private ByteBuf allocate(ChannelHandlerContext channelHandlerContext, int i8) {
        ByteBufAllocator alloc = channelHandlerContext.alloc();
        if (this.engineType.wantsDirectBuffer) {
            return alloc.directBuffer(i8);
        }
        return alloc.buffer(i8);
    }

    private ByteBuf allocateOutNetBuf(ChannelHandlerContext channelHandlerContext, int i8, int i9) {
        return this.engineType.allocateWrapBuffer(this, channelHandlerContext.alloc(), i8, i9);
    }

    private void applyHandshakeTimeout() {
        final Promise<Channel> promise = this.handshakePromise;
        final long j8 = this.handshakeTimeoutMillis;
        if (j8 > 0 && !promise.isDone()) {
            final ScheduledFuture<?> schedule = this.ctx.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    if (promise.isDone()) {
                        return;
                    }
                    SslHandshakeTimeoutException sslHandshakeTimeoutException = new SslHandshakeTimeoutException("handshake timed out after " + j8 + "ms");
                    try {
                        if (promise.tryFailure(sslHandshakeTimeoutException)) {
                            SslUtils.handleHandshakeFailure(SslHandler.this.ctx, sslHandshakeTimeoutException, true);
                        }
                    } finally {
                        SslHandler sslHandler = SslHandler.this;
                        sslHandler.releaseAndFailAll(sslHandler.ctx, sslHandshakeTimeoutException);
                    }
                }
            }, j8, TimeUnit.MILLISECONDS);
            promise.addListener(new GenericFutureListener() { // from class: io.netty.handler.ssl.SslHandler.6
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<Channel> future) throws Exception {
                    schedule.cancel(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean attemptCopyToCumulation(ByteBuf byteBuf, ByteBuf byteBuf2, int i8) {
        int readableBytes = byteBuf2.readableBytes();
        int capacity = byteBuf.capacity();
        if (i8 - byteBuf.readableBytes() < readableBytes || ((!byteBuf.isWritable(readableBytes) || capacity < i8) && (capacity >= i8 || !ByteBufUtil.ensureWritableSuccess(byteBuf.ensureWritable(readableBytes, false))))) {
            return false;
        }
        byteBuf.writeBytes(byteBuf2);
        byteBuf2.release();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void channelReadComplete0(ChannelHandlerContext channelHandlerContext) {
        discardSomeReadBytes();
        flushIfNeeded(channelHandlerContext);
        readIfNeeded(channelHandlerContext);
        this.firedChannelRead = false;
        channelHandlerContext.fireChannelReadComplete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.netty.channel.ChannelPromise] */
    /* JADX WARN: Type inference failed for: r7v2, types: [io.netty.channel.ChannelPromise] */
    private void closeOutboundAndChannel(ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise, boolean z7) throws Exception {
        this.outboundClosed = true;
        this.engine.closeOutbound();
        if (!channelHandlerContext.channel().isActive()) {
            if (z7) {
                channelHandlerContext.disconnect(channelPromise);
                return;
            } else {
                channelHandlerContext.close(channelPromise);
                return;
            }
        }
        ChannelPromise newPromise = channelHandlerContext.newPromise();
        try {
            flush(channelHandlerContext, newPromise);
            if (!this.closeNotify) {
                this.closeNotify = true;
                safeClose(channelHandlerContext, newPromise, channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise)));
                return;
            }
            this.sslClosePromise.addListener(new GenericFutureListener() { // from class: io.netty.handler.ssl.SslHandler.3
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<Channel> future) {
                    channelPromise.setSuccess();
                }
            });
        } catch (Throwable th) {
            if (!this.closeNotify) {
                this.closeNotify = true;
                safeClose(channelHandlerContext, newPromise, channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise)));
            } else {
                this.sslClosePromise.addListener(new GenericFutureListener() { // from class: io.netty.handler.ssl.SslHandler.3
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Channel> future) {
                        channelPromise.setSuccess();
                    }
                });
            }
            throw th;
        }
    }

    private void decodeJdkCompatible(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws NotSslRecordException {
        int i8 = this.packetLength;
        if (i8 > 0) {
            if (byteBuf.readableBytes() < i8) {
                return;
            }
        } else {
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes < 5) {
                return;
            }
            int encryptedPacketLength = SslUtils.getEncryptedPacketLength(byteBuf, byteBuf.readerIndex());
            if (encryptedPacketLength != -2) {
                if (encryptedPacketLength > readableBytes) {
                    this.packetLength = encryptedPacketLength;
                    return;
                }
                i8 = encryptedPacketLength;
            } else {
                NotSslRecordException notSslRecordException = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(byteBuf));
                byteBuf.skipBytes(byteBuf.readableBytes());
                setHandshakeFailure(channelHandlerContext, notSslRecordException);
                throw notSslRecordException;
            }
        }
        this.packetLength = 0;
        try {
            byteBuf.skipBytes(unwrap(channelHandlerContext, byteBuf, byteBuf.readerIndex(), i8));
        } catch (Throwable th) {
            handleUnwrapThrowable(channelHandlerContext, th);
        }
    }

    private void decodeNonJdkCompatible(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        try {
            byteBuf.skipBytes(unwrap(channelHandlerContext, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes()));
        } catch (Throwable th) {
            handleUnwrapThrowable(channelHandlerContext, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeDelegatedTasks(boolean z7) {
        this.processTask = true;
        try {
            this.delegatedTaskExecutor.execute(new SslTasksRunner(z7));
        } catch (RejectedExecutionException e8) {
            this.processTask = false;
            throw e8;
        }
    }

    private void finishWrap(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ChannelPromise channelPromise, boolean z7, boolean z8) {
        if (byteBuf == null) {
            byteBuf = Unpooled.EMPTY_BUFFER;
        } else if (!byteBuf.isReadable()) {
            byteBuf.release();
            byteBuf = Unpooled.EMPTY_BUFFER;
        }
        if (channelPromise != null) {
            channelHandlerContext.write(byteBuf, channelPromise);
        } else {
            channelHandlerContext.write(byteBuf);
        }
        if (z7) {
            this.needsFlush = true;
        }
        if (z8) {
            readIfNeeded(channelHandlerContext);
        }
    }

    private void flushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (this.needsFlush) {
            forceFlush(channelHandlerContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceFlush(ChannelHandlerContext channelHandlerContext) {
        this.needsFlush = false;
        channelHandlerContext.flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUnwrapThrowable(ChannelHandlerContext channelHandlerContext, Throwable th) {
        try {
            if (this.handshakePromise.tryFailure(th)) {
                channelHandlerContext.fireUserEventTriggered(new SslHandshakeCompletionEvent(th));
            }
            wrapAndFlush(channelHandlerContext);
        } catch (SSLException e8) {
            logger.debug("SSLException during trying to call SSLEngine.wrap(...) because of an previous SSLException, ignoring...", (Throwable) e8);
        } finally {
            setHandshakeFailure(channelHandlerContext, th, true, false, true);
        }
        PlatformDependent.throwException(th);
    }

    private void handshake() {
        if (this.engine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || this.handshakePromise.isDone()) {
            return;
        }
        ChannelHandlerContext channelHandlerContext = this.ctx;
        try {
            this.engine.beginHandshake();
            wrapNonAppData(channelHandlerContext, false);
        } finally {
            try {
            } finally {
            }
        }
    }

    private boolean ignoreException(Throwable th) {
        StackTraceElement[] stackTrace;
        if (!(th instanceof SSLException) && (th instanceof IOException) && this.sslClosePromise.isDone()) {
            String message = th.getMessage();
            if (message != null && IGNORABLE_ERROR_MESSAGE.matcher(message).matches()) {
                return true;
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                String methodName = stackTraceElement.getMethodName();
                if (!className.startsWith("io.netty.") && "read".equals(methodName)) {
                    if (IGNORABLE_CLASS_IN_STACK.matcher(className).matches()) {
                        return true;
                    }
                    try {
                        Class<?> loadClass = PlatformDependent.getClassLoader(getClass()).loadClass(className);
                        if (!SocketChannel.class.isAssignableFrom(loadClass)) {
                            if (!DatagramChannel.class.isAssignableFrom(loadClass)) {
                                if (PlatformDependent.javaVersion() >= 7 && "com.sun.nio.sctp.SctpChannel".equals(loadClass.getSuperclass().getName())) {
                                }
                            }
                        }
                        return true;
                    } catch (Throwable th2) {
                        InternalLogger internalLogger = logger;
                        if (internalLogger.isDebugEnabled()) {
                            internalLogger.debug("Unexpected exception while loading class {} classname {}", getClass(), className, th2);
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean inEventLoop(Executor executor) {
        if ((executor instanceof EventExecutor) && ((EventExecutor) executor).inEventLoop()) {
            return true;
        }
        return false;
    }

    private static IllegalStateException newPendingWritesNullException() {
        return new IllegalStateException("pendingUnencryptedWrites is null, handlerRemoved0 called?");
    }

    private void notifyClosePromise(Throwable th) {
        if (th == null) {
            if (this.sslClosePromise.trySuccess(this.ctx.channel())) {
                this.ctx.fireUserEventTriggered(SslCloseCompletionEvent.SUCCESS);
            }
        } else if (this.sslClosePromise.tryFailure(th)) {
            this.ctx.fireUserEventTriggered(new SslCloseCompletionEvent(th));
        }
    }

    private void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (!channelHandlerContext.channel().config().isAutoRead()) {
            if (!this.firedChannelRead || !this.handshakePromise.isDone()) {
                channelHandlerContext.read();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseAndFailAll(ChannelHandlerContext channelHandlerContext, Throwable th) {
        SslHandlerCoalescingBufferQueue sslHandlerCoalescingBufferQueue = this.pendingUnencryptedWrites;
        if (sslHandlerCoalescingBufferQueue != null) {
            sslHandlerCoalescingBufferQueue.releaseAndFailAll(channelHandlerContext, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void runAllDelegatedTasks(SSLEngine sSLEngine) {
        while (true) {
            Runnable delegatedTask = sSLEngine.getDelegatedTask();
            if (delegatedTask == null) {
                return;
            }
            delegatedTask.run();
        }
    }

    private boolean runDelegatedTasks(boolean z7) {
        Executor executor = this.delegatedTaskExecutor;
        if (executor != ImmediateExecutor.INSTANCE && !inEventLoop(executor)) {
            executeDelegatedTasks(z7);
            return false;
        }
        runAllDelegatedTasks(this.engine);
        return true;
    }

    private void safeClose(final ChannelHandlerContext channelHandlerContext, final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        if (!channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        final ScheduledFuture<?> scheduledFuture = null;
        if (!channelFuture.isDone()) {
            long j8 = this.closeNotifyFlushTimeoutMillis;
            if (j8 > 0) {
                scheduledFuture = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!channelFuture.isDone()) {
                            SslHandler.logger.warn("{} Last write attempt timed out; force-closing the connection.", channelHandlerContext.channel());
                            ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                            SslHandler.addCloseListener(channelHandlerContext2.close(channelHandlerContext2.newPromise()), channelPromise);
                        }
                    }
                }, j8, TimeUnit.MILLISECONDS);
            }
        }
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.ssl.SslHandler.8
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                java.util.concurrent.ScheduledFuture scheduledFuture2 = scheduledFuture;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                }
                final long j9 = SslHandler.this.closeNotifyReadTimeoutMillis;
                if (j9 <= 0) {
                    ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                    SslHandler.addCloseListener(channelHandlerContext2.close(channelHandlerContext2.newPromise()), channelPromise);
                    return;
                }
                final ScheduledFuture<?> schedule = !SslHandler.this.sslClosePromise.isDone() ? channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!SslHandler.this.sslClosePromise.isDone()) {
                            SslHandler.logger.debug("{} did not receive close_notify in {}ms; force-closing the connection.", channelHandlerContext.channel(), Long.valueOf(j9));
                            ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
                            SslHandler.addCloseListener(channelHandlerContext3.close(channelHandlerContext3.newPromise()), channelPromise);
                        }
                    }
                }, j9, TimeUnit.MILLISECONDS) : null;
                SslHandler.this.sslClosePromise.addListener(new GenericFutureListener() { // from class: io.netty.handler.ssl.SslHandler.8.2
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Channel> future) throws Exception {
                        java.util.concurrent.ScheduledFuture scheduledFuture3 = schedule;
                        if (scheduledFuture3 != null) {
                            scheduledFuture3.cancel(false);
                        }
                        ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
                        SslHandler.addCloseListener(channelHandlerContext3.close(channelHandlerContext3.newPromise()), channelPromise);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th) {
        setHandshakeFailure(channelHandlerContext, th, true, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandshakeFailureTransportFailure(ChannelHandlerContext channelHandlerContext, Throwable th) {
        try {
            SSLException sSLException = new SSLException("failure when writing TLS control frames", th);
            releaseAndFailAll(channelHandlerContext, sSLException);
            if (this.handshakePromise.tryFailure(sSLException)) {
                channelHandlerContext.fireUserEventTriggered(new SslHandshakeCompletionEvent(sSLException));
            }
        } finally {
            channelHandlerContext.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandshakeSuccess() {
        this.handshakePromise.trySuccess(this.ctx.channel());
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} HANDSHAKEN: {}", this.ctx.channel(), this.engine.getSession().getCipherSuite());
        }
        this.ctx.fireUserEventTriggered(SslHandshakeCompletionEvent.SUCCESS);
        if (this.readDuringHandshake && !this.ctx.channel().config().isAutoRead()) {
            this.readDuringHandshake = false;
            this.ctx.read();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setHandshakeSuccessIfStillHandshaking() {
        if (!this.handshakePromise.isDone()) {
            setHandshakeSuccess();
            return true;
        }
        return false;
    }

    private void startHandshakeProcessing() {
        if (!this.handshakeStarted) {
            this.handshakeStarted = true;
            if (this.engine.getUseClientMode()) {
                handshake();
            }
            applyHandshakeTimeout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteBuffer toByteBuffer(ByteBuf byteBuf, int i8, int i9) {
        if (byteBuf.nioBufferCount() == 1) {
            return byteBuf.internalNioBuffer(i8, i9);
        }
        return byteBuf.nioBuffer(i8, i9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b3, code lost:
        if (r3 != javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b5, code lost:
        readIfNeeded(r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0118, code lost:
        throw new java.lang.IllegalStateException("Two consecutive overflows but no content was consumed. " + javax.net.ssl.SSLSession.class.getSimpleName() + " getApplicationBufferSize: " + r18.engine.getSession().getApplicationBufferSize() + " maybe too small.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int unwrap(io.netty.channel.ChannelHandlerContext r19, io.netty.buffer.ByteBuf r20, int r21, int r22) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.unwrap(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unwrapNonAppData(ChannelHandlerContext channelHandlerContext) throws SSLException {
        unwrap(channelHandlerContext, Unpooled.EMPTY_BUFFER, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:36|37|(5:(2:39|(10:41|(3:63|64|(1:66)(2:69|70))|43|44|(1:46)(1:59)|47|48|49|50|51))(1:72)|48|49|50|51)|71|43|44|(0)(0)|47) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
        r3.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        r0 = new javax.net.ssl.SSLException("SSLEngine closed already");
        r2.tryFailure(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        r10.pendingUnencryptedWrites.releaseAndFailAll(r11, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
        finishWrap(r11, r4, r5, r12, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d7, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d8, code lost:
        r3 = r4;
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ee, code lost:
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0102, code lost:
        r4 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void wrap(io.netty.channel.ChannelHandlerContext r11, boolean r12) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.wrap(io.netty.channel.ChannelHandlerContext, boolean):void");
    }

    private void wrapAndFlush(ChannelHandlerContext channelHandlerContext) throws SSLException {
        if (this.pendingUnencryptedWrites.isEmpty()) {
            this.pendingUnencryptedWrites.add(Unpooled.EMPTY_BUFFER, channelHandlerContext.newPromise());
        }
        if (!this.handshakePromise.isDone()) {
            this.flushedBeforeHandshake = true;
        }
        try {
            wrap(channelHandlerContext, false);
        } finally {
            forceFlush(channelHandlerContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wrapNonAppData(final ChannelHandlerContext channelHandlerContext, boolean z7) throws SSLException {
        ByteBufAllocator alloc = channelHandlerContext.alloc();
        ByteBuf byteBuf = null;
        while (!channelHandlerContext.isRemoved()) {
            try {
                if (byteBuf == null) {
                    byteBuf = allocateOutNetBuf(channelHandlerContext, 2048, 1);
                }
                SSLEngineResult wrap = wrap(alloc, this.engine, Unpooled.EMPTY_BUFFER, byteBuf);
                if (wrap.bytesProduced() > 0) {
                    channelHandlerContext.write(byteBuf).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.ssl.SslHandler.2
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(ChannelFuture channelFuture) {
                            Throwable cause = channelFuture.cause();
                            if (cause != null) {
                                SslHandler.this.setHandshakeFailureTransportFailure(channelHandlerContext, cause);
                            }
                        }
                    });
                    if (z7) {
                        this.needsFlush = true;
                    }
                    byteBuf = null;
                }
                SSLEngineResult.HandshakeStatus handshakeStatus = wrap.getHandshakeStatus();
                int i8 = AnonymousClass9.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 != 4) {
                                if (i8 == 5) {
                                    if (z7) {
                                        return false;
                                    }
                                    unwrapNonAppData(channelHandlerContext);
                                } else {
                                    throw new IllegalStateException("Unknown handshake status: " + wrap.getHandshakeStatus());
                                }
                            }
                        } else {
                            setHandshakeSuccessIfStillHandshaking();
                            if (!z7) {
                                unwrapNonAppData(channelHandlerContext);
                            }
                            if (byteBuf != null) {
                                byteBuf.release();
                            }
                            return true;
                        }
                    } else {
                        setHandshakeSuccess();
                        if (byteBuf != null) {
                            byteBuf.release();
                        }
                        return false;
                    }
                } else if (!runDelegatedTasks(z7)) {
                    break;
                }
                if ((wrap.bytesProduced() == 0 && handshakeStatus != SSLEngineResult.HandshakeStatus.NEED_TASK) || (wrap.bytesConsumed() == 0 && wrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)) {
                    break;
                }
            } finally {
                if (byteBuf != null) {
                    byteBuf.release();
                }
            }
        }
        if (byteBuf != null) {
            byteBuf.release();
        }
        return false;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.startTls) {
            startHandshakeProcessing();
        }
        channelHandlerContext.fireChannelActive();
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        ClosedChannelException closedChannelException = new ClosedChannelException();
        setHandshakeFailure(channelHandlerContext, closedChannelException, !this.outboundClosed, this.handshakeStarted, false);
        notifyClosePromise(closedChannelException);
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelReadComplete0(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        closeOutboundAndChannel(channelHandlerContext, channelPromise, false);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws SSLException {
        if (this.processTask) {
            return;
        }
        if (this.jdkCompatibilityMode) {
            decodeJdkCompatible(channelHandlerContext, byteBuf);
        } else {
            decodeNonJdkCompatible(channelHandlerContext, byteBuf);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        closeOutboundAndChannel(channelHandlerContext, channelPromise, true);
    }

    public SSLEngine engine() {
        return this.engine;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (ignoreException(th)) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("{} Swallowing a harmless 'connection reset by peer / broken pipe' error that occurred while writing close_notify in response to the peer's close_notify", channelHandlerContext.channel(), th);
            }
            if (channelHandlerContext.channel().isActive()) {
                channelHandlerContext.close();
                return;
            }
            return;
        }
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.startTls && !this.sentFirstMessage) {
            this.sentFirstMessage = true;
            this.pendingUnencryptedWrites.writeAndRemoveAll(channelHandlerContext);
            forceFlush(channelHandlerContext);
            startHandshakeProcessing();
        } else if (this.processTask) {
        } else {
            try {
                wrapAndFlush(channelHandlerContext);
            } catch (Throwable th) {
                setHandshakeFailure(channelHandlerContext, th);
                PlatformDependent.throwException(th);
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        this.pendingUnencryptedWrites = new SslHandlerCoalescingBufferQueue(channelHandlerContext.channel(), 16);
        if (channelHandlerContext.channel().isActive()) {
            startHandshakeProcessing();
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.pendingUnencryptedWrites.isEmpty()) {
            this.pendingUnencryptedWrites.releaseAndFailAll(channelHandlerContext, new ChannelException("Pending write on removal of SslHandler"));
        }
        this.pendingUnencryptedWrites = null;
        SSLEngine sSLEngine = this.engine;
        if (sSLEngine instanceof ReferenceCounted) {
            ((ReferenceCounted) sSLEngine).release();
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.handshakePromise.isDone()) {
            this.readDuringHandshake = true;
        }
        channelHandlerContext.read();
    }

    public void setHandshakeTimeoutMillis(long j8) {
        if (j8 >= 0) {
            this.handshakeTimeoutMillis = j8;
            return;
        }
        throw new IllegalArgumentException("handshakeTimeoutMillis: " + j8 + " (expected: >= 0)");
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (!(obj instanceof ByteBuf)) {
            UnsupportedMessageTypeException unsupportedMessageTypeException = new UnsupportedMessageTypeException(obj, ByteBuf.class);
            ReferenceCountUtil.safeRelease(obj);
            channelPromise.setFailure((Throwable) unsupportedMessageTypeException);
            return;
        }
        SslHandlerCoalescingBufferQueue sslHandlerCoalescingBufferQueue = this.pendingUnencryptedWrites;
        if (sslHandlerCoalescingBufferQueue == null) {
            ReferenceCountUtil.safeRelease(obj);
            channelPromise.setFailure((Throwable) newPendingWritesNullException());
            return;
        }
        sslHandlerCoalescingBufferQueue.add((ByteBuf) obj, channelPromise);
    }

    public SslHandler(SSLEngine sSLEngine, boolean z7, Executor executor) {
        this.singleBuffer = new ByteBuffer[1];
        this.handshakePromise = new LazyChannelPromise(this, null);
        this.sslClosePromise = new LazyChannelPromise(this, null);
        this.handshakeTimeoutMillis = 10000L;
        this.closeNotifyFlushTimeoutMillis = 3000L;
        this.wrapDataSize = 16384;
        this.engine = (SSLEngine) ObjectUtil.checkNotNull(sSLEngine, "engine");
        this.delegatedTaskExecutor = (Executor) ObjectUtil.checkNotNull(executor, "delegatedTaskExecutor");
        SslEngineType forEngine = SslEngineType.forEngine(sSLEngine);
        this.engineType = forEngine;
        this.startTls = z7;
        this.jdkCompatibilityMode = forEngine.jdkCompatibilityMode(sSLEngine);
        setCumulator(forEngine.cumulator);
    }

    private void setHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th, boolean z7, boolean z8, boolean z9) {
        String message;
        try {
            this.outboundClosed = true;
            this.engine.closeOutbound();
            if (z7) {
                try {
                    this.engine.closeInbound();
                } catch (SSLException e8) {
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isDebugEnabled() && ((message = e8.getMessage()) == null || (!message.contains("possible truncation attack") && !message.contains("closing inbound before receiving peer's close_notify")))) {
                        internalLogger.debug("{} SSLEngine.closeInbound() raised an exception.", channelHandlerContext.channel(), e8);
                    }
                }
            }
            if (this.handshakePromise.tryFailure(th) || z9) {
                SslUtils.handleHandshakeFailure(channelHandlerContext, th, z8);
            }
        } finally {
            releaseAndFailAll(channelHandlerContext, th);
        }
    }

    private void flush(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        SslHandlerCoalescingBufferQueue sslHandlerCoalescingBufferQueue = this.pendingUnencryptedWrites;
        if (sslHandlerCoalescingBufferQueue != null) {
            sslHandlerCoalescingBufferQueue.add(Unpooled.EMPTY_BUFFER, channelPromise);
        } else {
            channelPromise.setFailure((Throwable) newPendingWritesNullException());
        }
        flush(channelHandlerContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[Catch: all -> 0x008c, LOOP:0: B:18:0x0045->B:24:0x0080, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x008c, blocks: (B:9:0x001c, B:18:0x0045, B:24:0x0080), top: B:34:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076 A[EDGE_INSN: B:37:0x0076->B:20:0x0076 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private javax.net.ssl.SSLEngineResult wrap(io.netty.buffer.ByteBufAllocator r8, javax.net.ssl.SSLEngine r9, io.netty.buffer.ByteBuf r10, io.netty.buffer.ByteBuf r11) throws javax.net.ssl.SSLException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            int r2 = r10.readerIndex()     // Catch: java.lang.Throwable -> L8e
            int r3 = r10.readableBytes()     // Catch: java.lang.Throwable -> L8e
            boolean r4 = r10.isDirect()     // Catch: java.lang.Throwable -> L8e
            r5 = 1
            if (r4 != 0) goto L2c
            io.netty.handler.ssl.SslHandler$SslEngineType r4 = r7.engineType     // Catch: java.lang.Throwable -> L8e
            boolean r4 = r4.wantsDirectBuffer     // Catch: java.lang.Throwable -> L8e
            if (r4 != 0) goto L18
            goto L2c
        L18:
            io.netty.buffer.ByteBuf r8 = r8.directBuffer(r3)     // Catch: java.lang.Throwable -> L8e
            r8.writeBytes(r10, r2, r3)     // Catch: java.lang.Throwable -> L8c
            java.nio.ByteBuffer[] r2 = r7.singleBuffer     // Catch: java.lang.Throwable -> L8c
            int r4 = r8.readerIndex()     // Catch: java.lang.Throwable -> L8c
            java.nio.ByteBuffer r3 = r8.internalNioBuffer(r4, r3)     // Catch: java.lang.Throwable -> L8c
            r2[r1] = r3     // Catch: java.lang.Throwable -> L8c
            goto L45
        L2c:
            boolean r8 = r10 instanceof io.netty.buffer.CompositeByteBuf     // Catch: java.lang.Throwable -> L8e
            if (r8 != 0) goto L40
            int r8 = r10.nioBufferCount()     // Catch: java.lang.Throwable -> L8e
            if (r8 != r5) goto L40
            java.nio.ByteBuffer[] r8 = r7.singleBuffer     // Catch: java.lang.Throwable -> L8e
            java.nio.ByteBuffer r2 = r10.internalNioBuffer(r2, r3)     // Catch: java.lang.Throwable -> L8e
            r8[r1] = r2     // Catch: java.lang.Throwable -> L8e
            r2 = r8
            goto L44
        L40:
            java.nio.ByteBuffer[] r2 = r10.nioBuffers()     // Catch: java.lang.Throwable -> L8e
        L44:
            r8 = r0
        L45:
            int r3 = r11.writerIndex()     // Catch: java.lang.Throwable -> L8c
            int r4 = r11.writableBytes()     // Catch: java.lang.Throwable -> L8c
            java.nio.ByteBuffer r3 = r11.nioBuffer(r3, r4)     // Catch: java.lang.Throwable -> L8c
            javax.net.ssl.SSLEngineResult r3 = r9.wrap(r2, r3)     // Catch: java.lang.Throwable -> L8c
            int r4 = r3.bytesConsumed()     // Catch: java.lang.Throwable -> L8c
            r10.skipBytes(r4)     // Catch: java.lang.Throwable -> L8c
            int r4 = r11.writerIndex()     // Catch: java.lang.Throwable -> L8c
            int r6 = r3.bytesProduced()     // Catch: java.lang.Throwable -> L8c
            int r4 = r4 + r6
            r11.writerIndex(r4)     // Catch: java.lang.Throwable -> L8c
            int[] r4 = io.netty.handler.ssl.SslHandler.AnonymousClass9.$SwitchMap$javax$net$ssl$SSLEngineResult$Status     // Catch: java.lang.Throwable -> L8c
            javax.net.ssl.SSLEngineResult$Status r6 = r3.getStatus()     // Catch: java.lang.Throwable -> L8c
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L8c
            r4 = r4[r6]     // Catch: java.lang.Throwable -> L8c
            if (r4 == r5) goto L80
            java.nio.ByteBuffer[] r9 = r7.singleBuffer
            r9[r1] = r0
            if (r8 == 0) goto L7f
            r8.release()
        L7f:
            return r3
        L80:
            javax.net.ssl.SSLSession r3 = r9.getSession()     // Catch: java.lang.Throwable -> L8c
            int r3 = r3.getPacketBufferSize()     // Catch: java.lang.Throwable -> L8c
            r11.ensureWritable(r3)     // Catch: java.lang.Throwable -> L8c
            goto L45
        L8c:
            r9 = move-exception
            goto L90
        L8e:
            r9 = move-exception
            r8 = r0
        L90:
            java.nio.ByteBuffer[] r10 = r7.singleBuffer
            r10[r1] = r0
            if (r8 == 0) goto L99
            r8.release()
        L99:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.wrap(io.netty.buffer.ByteBufAllocator, javax.net.ssl.SSLEngine, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):javax.net.ssl.SSLEngineResult");
    }
}
