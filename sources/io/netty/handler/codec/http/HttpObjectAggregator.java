package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageAggregator;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.Spliterator;

/* loaded from: classes5.dex */
public class HttpObjectAggregator extends MessageAggregator<HttpObject, HttpMessage, HttpContent, FullHttpMessage> {
    private static final FullHttpResponse CONTINUE;
    private static final FullHttpResponse EXPECTATION_FAILED;
    private static final FullHttpResponse TOO_LARGE;
    private static final FullHttpResponse TOO_LARGE_CLOSE;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(HttpObjectAggregator.class);
    private final boolean closeOnExpectationFailed;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class AggregatedFullHttpMessage implements FullHttpMessage {
        private final ByteBuf content;
        protected final HttpMessage message;
        private HttpHeaders trailingHeaders;

        AggregatedFullHttpMessage(HttpMessage httpMessage, ByteBuf byteBuf, HttpHeaders httpHeaders) {
            this.message = httpMessage;
            this.content = byteBuf;
            this.trailingHeaders = httpHeaders;
        }

        @Override // io.netty.buffer.ByteBufHolder
        public ByteBuf content() {
            return this.content;
        }

        @Override // io.netty.handler.codec.DecoderResultProvider
        public DecoderResult decoderResult() {
            return this.message.decoderResult();
        }

        public HttpVersion getProtocolVersion() {
            return this.message.protocolVersion();
        }

        @Override // io.netty.handler.codec.http.HttpMessage
        public HttpHeaders headers() {
            return this.message.headers();
        }

        @Override // io.netty.handler.codec.http.HttpMessage
        public HttpVersion protocolVersion() {
            return this.message.protocolVersion();
        }

        @Override // io.netty.util.ReferenceCounted
        public int refCnt() {
            return this.content.refCnt();
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release() {
            return this.content.release();
        }

        @Override // io.netty.handler.codec.DecoderResultProvider
        public void setDecoderResult(DecoderResult decoderResult) {
            this.message.setDecoderResult(decoderResult);
        }

        void setTrailingHeaders(HttpHeaders httpHeaders) {
            this.trailingHeaders = httpHeaders;
        }

        @Override // io.netty.handler.codec.http.LastHttpContent
        public HttpHeaders trailingHeaders() {
            HttpHeaders httpHeaders = this.trailingHeaders;
            if (httpHeaders == null) {
                return EmptyHttpHeaders.INSTANCE;
            }
            return httpHeaders;
        }

        @Override // io.netty.util.ReferenceCounted
        public FullHttpMessage touch(Object obj) {
            this.content.touch(obj);
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public FullHttpMessage retain() {
            this.content.retain();
            return this;
        }
    }

    static {
        HttpVersion httpVersion = HttpVersion.HTTP_1_1;
        HttpResponseStatus httpResponseStatus = HttpResponseStatus.CONTINUE;
        ByteBuf byteBuf = Unpooled.EMPTY_BUFFER;
        CONTINUE = new DefaultFullHttpResponse(httpVersion, httpResponseStatus, byteBuf);
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(httpVersion, HttpResponseStatus.EXPECTATION_FAILED, byteBuf);
        EXPECTATION_FAILED = defaultFullHttpResponse;
        HttpResponseStatus httpResponseStatus2 = HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE;
        DefaultFullHttpResponse defaultFullHttpResponse2 = new DefaultFullHttpResponse(httpVersion, httpResponseStatus2, byteBuf);
        TOO_LARGE_CLOSE = defaultFullHttpResponse2;
        DefaultFullHttpResponse defaultFullHttpResponse3 = new DefaultFullHttpResponse(httpVersion, httpResponseStatus2, byteBuf);
        TOO_LARGE = defaultFullHttpResponse3;
        HttpHeaders headers = defaultFullHttpResponse.headers();
        AsciiString asciiString = HttpHeaderNames.CONTENT_LENGTH;
        headers.set((CharSequence) asciiString, (Object) 0);
        defaultFullHttpResponse3.headers().set((CharSequence) asciiString, (Object) 0);
        defaultFullHttpResponse2.headers().set((CharSequence) asciiString, (Object) 0);
        defaultFullHttpResponse2.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
    }

    public HttpObjectAggregator(int i8) {
        this(i8, false);
    }

    private static Object continueResponse(HttpMessage httpMessage, int i8, ChannelPipeline channelPipeline) {
        if (HttpUtil.isUnsupportedExpectation(httpMessage)) {
            channelPipeline.fireUserEventTriggered(HttpExpectationFailedEvent.INSTANCE);
            return EXPECTATION_FAILED.retainedDuplicate();
        } else if (HttpUtil.is100ContinueExpected(httpMessage)) {
            if (HttpUtil.getContentLength(httpMessage, -1L) <= i8) {
                return CONTINUE.retainedDuplicate();
            }
            channelPipeline.fireUserEventTriggered(HttpExpectationFailedEvent.INSTANCE);
            return TOO_LARGE.retainedDuplicate();
        } else {
            return null;
        }
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean closeAfterContinueResponse(Object obj) {
        if (this.closeOnExpectationFailed && ignoreContentAfterContinueResponse(obj)) {
            return true;
        }
        return false;
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean ignoreContentAfterContinueResponse(Object obj) {
        if (obj instanceof HttpResponse) {
            return ((HttpResponse) obj).status().codeClass().equals(HttpStatusClass.CLIENT_ERROR);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AggregatedFullHttpRequest extends AggregatedFullHttpMessage implements FullHttpRequest {
        AggregatedFullHttpRequest(HttpRequest httpRequest, ByteBuf byteBuf, HttpHeaders httpHeaders) {
            super(httpRequest, byteBuf, httpHeaders);
        }

        public HttpMethod getMethod() {
            return ((HttpRequest) this.message).method();
        }

        public String getUri() {
            return ((HttpRequest) this.message).uri();
        }

        @Override // io.netty.handler.codec.http.HttpRequest
        public HttpMethod method() {
            return getMethod();
        }

        public String toString() {
            return HttpMessageUtil.appendFullRequest(new StringBuilder((int) Spliterator.NONNULL), this).toString();
        }

        @Override // io.netty.handler.codec.http.HttpRequest
        public String uri() {
            return getUri();
        }

        @Override // io.netty.handler.codec.http.HttpObjectAggregator.AggregatedFullHttpMessage, io.netty.util.ReferenceCounted
        public FullHttpRequest touch(Object obj) {
            super.touch(obj);
            return this;
        }

        @Override // io.netty.handler.codec.http.HttpObjectAggregator.AggregatedFullHttpMessage, io.netty.util.ReferenceCounted
        public FullHttpRequest retain() {
            super.retain();
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AggregatedFullHttpResponse extends AggregatedFullHttpMessage implements FullHttpResponse {
        AggregatedFullHttpResponse(HttpResponse httpResponse, ByteBuf byteBuf, HttpHeaders httpHeaders) {
            super(httpResponse, byteBuf, httpHeaders);
        }

        public HttpResponseStatus getStatus() {
            return ((HttpResponse) this.message).status();
        }

        public FullHttpResponse replace(ByteBuf byteBuf) {
            DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(getProtocolVersion(), getStatus(), byteBuf, headers().copy(), trailingHeaders().copy());
            defaultFullHttpResponse.setDecoderResult(decoderResult());
            return defaultFullHttpResponse;
        }

        @Override // io.netty.handler.codec.http.FullHttpResponse
        public FullHttpResponse retainedDuplicate() {
            return replace(content().retainedDuplicate());
        }

        @Override // io.netty.handler.codec.http.HttpResponse
        public HttpResponseStatus status() {
            return getStatus();
        }

        public String toString() {
            return HttpMessageUtil.appendFullResponse(new StringBuilder((int) Spliterator.NONNULL), this).toString();
        }

        @Override // io.netty.handler.codec.http.HttpObjectAggregator.AggregatedFullHttpMessage, io.netty.util.ReferenceCounted
        public FullHttpResponse touch(Object obj) {
            super.touch(obj);
            return this;
        }

        @Override // io.netty.handler.codec.http.HttpObjectAggregator.AggregatedFullHttpMessage, io.netty.util.ReferenceCounted
        public FullHttpResponse retain() {
            super.retain();
            return this;
        }
    }

    public HttpObjectAggregator(int i8, boolean z7) {
        super(i8);
        this.closeOnExpectationFailed = z7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public void aggregate(FullHttpMessage fullHttpMessage, HttpContent httpContent) throws Exception {
        if (httpContent instanceof LastHttpContent) {
            ((AggregatedFullHttpMessage) fullHttpMessage).setTrailingHeaders(((LastHttpContent) httpContent).trailingHeaders());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public FullHttpMessage beginAggregation(HttpMessage httpMessage, ByteBuf byteBuf) throws Exception {
        HttpUtil.setTransferEncodingChunked(httpMessage, false);
        if (httpMessage instanceof HttpRequest) {
            return new AggregatedFullHttpRequest((HttpRequest) httpMessage, byteBuf, null);
        }
        if (httpMessage instanceof HttpResponse) {
            return new AggregatedFullHttpResponse((HttpResponse) httpMessage, byteBuf, null);
        }
        throw new Error();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public void finishAggregation(FullHttpMessage fullHttpMessage) throws Exception {
        if (HttpUtil.isContentLengthSet(fullHttpMessage)) {
            return;
        }
        fullHttpMessage.headers().set(HttpHeaderNames.CONTENT_LENGTH, String.valueOf(fullHttpMessage.content().readableBytes()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public void handleOversizedMessage(final ChannelHandlerContext channelHandlerContext, HttpMessage httpMessage) throws Exception {
        if (httpMessage instanceof HttpRequest) {
            if (!(httpMessage instanceof FullHttpMessage) && (HttpUtil.is100ContinueExpected(httpMessage) || HttpUtil.isKeepAlive(httpMessage))) {
                channelHandlerContext.writeAndFlush(TOO_LARGE.retainedDuplicate()).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.HttpObjectAggregator.2
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            return;
                        }
                        HttpObjectAggregator.logger.debug("Failed to send a 413 Request Entity Too Large.", channelFuture.cause());
                        channelHandlerContext.close();
                    }
                });
            } else {
                channelHandlerContext.writeAndFlush(TOO_LARGE_CLOSE.retainedDuplicate()).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.HttpObjectAggregator.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (!channelFuture.isSuccess()) {
                            HttpObjectAggregator.logger.debug("Failed to send a 413 Request Entity Too Large.", channelFuture.cause());
                        }
                        channelHandlerContext.close();
                    }
                });
            }
        } else if (httpMessage instanceof HttpResponse) {
            channelHandlerContext.close();
            throw new TooLongFrameException("Response entity too large: " + httpMessage);
        } else {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isAggregated(HttpObject httpObject) throws Exception {
        return httpObject instanceof FullHttpMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentLengthInvalid(HttpMessage httpMessage, int i8) {
        try {
            return HttpUtil.getContentLength(httpMessage, -1L) > ((long) i8);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentMessage(HttpObject httpObject) throws Exception {
        return httpObject instanceof HttpContent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isLastContentMessage(HttpContent httpContent) throws Exception {
        return httpContent instanceof LastHttpContent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isStartMessage(HttpObject httpObject) throws Exception {
        return httpObject instanceof HttpMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public Object newContinueResponse(HttpMessage httpMessage, int i8, ChannelPipeline channelPipeline) {
        Object continueResponse = continueResponse(httpMessage, i8, channelPipeline);
        if (continueResponse != null) {
            httpMessage.headers().remove(HttpHeaderNames.EXPECT);
        }
        return continueResponse;
    }
}
