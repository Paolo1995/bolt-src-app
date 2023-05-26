package io.netty.handler.codec.http.websocketx;

/* loaded from: classes5.dex */
public class WebSocket07FrameDecoder extends WebSocket08FrameDecoder {
    public WebSocket07FrameDecoder(boolean z7, boolean z8, int i8, boolean z9) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z7).allowExtensions(z8).maxFramePayloadLength(i8).allowMaskMismatch(z9).build());
    }

    public WebSocket07FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        super(webSocketDecoderConfig);
    }
}
