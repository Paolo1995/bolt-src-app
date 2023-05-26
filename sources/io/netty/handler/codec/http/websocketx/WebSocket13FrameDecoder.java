package io.netty.handler.codec.http.websocketx;

/* loaded from: classes5.dex */
public class WebSocket13FrameDecoder extends WebSocket08FrameDecoder {
    public WebSocket13FrameDecoder(boolean z7, boolean z8, int i8, boolean z9) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z7).allowExtensions(z8).maxFramePayloadLength(i8).allowMaskMismatch(z9).build());
    }

    public WebSocket13FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        super(webSocketDecoderConfig);
    }
}
