package io.netty.handler.codec.http.websocketx;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes5.dex */
public final class WebSocketDecoderConfig {
    static final WebSocketDecoderConfig DEFAULT = new WebSocketDecoderConfig(65536, true, false, false, true, true);
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private final boolean closeOnProtocolViolation;
    private final boolean expectMaskedFrames;
    private final int maxFramePayloadLength;
    private final boolean withUTF8Validator;

    /* loaded from: classes5.dex */
    public static final class Builder {
        private boolean allowExtensions;
        private boolean allowMaskMismatch;
        private boolean closeOnProtocolViolation;
        private boolean expectMaskedFrames;
        private int maxFramePayloadLength;
        private boolean withUTF8Validator;

        public Builder allowExtensions(boolean z7) {
            this.allowExtensions = z7;
            return this;
        }

        public Builder allowMaskMismatch(boolean z7) {
            this.allowMaskMismatch = z7;
            return this;
        }

        public WebSocketDecoderConfig build() {
            return new WebSocketDecoderConfig(this.maxFramePayloadLength, this.expectMaskedFrames, this.allowMaskMismatch, this.allowExtensions, this.closeOnProtocolViolation, this.withUTF8Validator);
        }

        public Builder expectMaskedFrames(boolean z7) {
            this.expectMaskedFrames = z7;
            return this;
        }

        public Builder maxFramePayloadLength(int i8) {
            this.maxFramePayloadLength = i8;
            return this;
        }

        private Builder(WebSocketDecoderConfig webSocketDecoderConfig) {
            ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
            this.maxFramePayloadLength = webSocketDecoderConfig.maxFramePayloadLength();
            this.expectMaskedFrames = webSocketDecoderConfig.expectMaskedFrames();
            this.allowMaskMismatch = webSocketDecoderConfig.allowMaskMismatch();
            this.allowExtensions = webSocketDecoderConfig.allowExtensions();
            this.closeOnProtocolViolation = webSocketDecoderConfig.closeOnProtocolViolation();
            this.withUTF8Validator = webSocketDecoderConfig.withUTF8Validator();
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean allowExtensions() {
        return this.allowExtensions;
    }

    public boolean allowMaskMismatch() {
        return this.allowMaskMismatch;
    }

    public boolean closeOnProtocolViolation() {
        return this.closeOnProtocolViolation;
    }

    public boolean expectMaskedFrames() {
        return this.expectMaskedFrames;
    }

    public int maxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public String toString() {
        return "WebSocketDecoderConfig [maxFramePayloadLength=" + this.maxFramePayloadLength + ", expectMaskedFrames=" + this.expectMaskedFrames + ", allowMaskMismatch=" + this.allowMaskMismatch + ", allowExtensions=" + this.allowExtensions + ", closeOnProtocolViolation=" + this.closeOnProtocolViolation + ", withUTF8Validator=" + this.withUTF8Validator + "]";
    }

    public boolean withUTF8Validator() {
        return this.withUTF8Validator;
    }

    private WebSocketDecoderConfig(int i8, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        this.maxFramePayloadLength = i8;
        this.expectMaskedFrames = z7;
        this.allowMaskMismatch = z8;
        this.allowExtensions = z9;
        this.closeOnProtocolViolation = z10;
        this.withUTF8Validator = z11;
    }
}
