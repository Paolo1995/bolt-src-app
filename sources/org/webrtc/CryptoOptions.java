package org.webrtc;

/* loaded from: classes4.dex */
public final class CryptoOptions {
    private final SFrame sframe;
    private final Srtp srtp;

    /* loaded from: classes4.dex */
    public static class Builder {
        private boolean enableAes128Sha1_32CryptoCipher;
        private boolean enableEncryptedRtpHeaderExtensions;
        private boolean enableGcmCryptoSuites;
        private boolean requireFrameEncryption;

        private Builder() {
        }

        public CryptoOptions createCryptoOptions() {
            return new CryptoOptions(this.enableGcmCryptoSuites, this.enableAes128Sha1_32CryptoCipher, this.enableEncryptedRtpHeaderExtensions, this.requireFrameEncryption);
        }

        public Builder setEnableAes128Sha1_32CryptoCipher(boolean z7) {
            this.enableAes128Sha1_32CryptoCipher = z7;
            return this;
        }

        public Builder setEnableEncryptedRtpHeaderExtensions(boolean z7) {
            this.enableEncryptedRtpHeaderExtensions = z7;
            return this;
        }

        public Builder setEnableGcmCryptoSuites(boolean z7) {
            this.enableGcmCryptoSuites = z7;
            return this;
        }

        public Builder setRequireFrameEncryption(boolean z7) {
            this.requireFrameEncryption = z7;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public final class SFrame {
        private final boolean requireFrameEncryption;

        private SFrame(boolean z7) {
            this.requireFrameEncryption = z7;
        }

        @CalledByNative("SFrame")
        public boolean getRequireFrameEncryption() {
            return this.requireFrameEncryption;
        }
    }

    /* loaded from: classes4.dex */
    public final class Srtp {
        private final boolean enableAes128Sha1_32CryptoCipher;
        private final boolean enableEncryptedRtpHeaderExtensions;
        private final boolean enableGcmCryptoSuites;

        private Srtp(boolean z7, boolean z8, boolean z9) {
            this.enableGcmCryptoSuites = z7;
            this.enableAes128Sha1_32CryptoCipher = z8;
            this.enableEncryptedRtpHeaderExtensions = z9;
        }

        @CalledByNative("Srtp")
        public boolean getEnableAes128Sha1_32CryptoCipher() {
            return this.enableAes128Sha1_32CryptoCipher;
        }

        @CalledByNative("Srtp")
        public boolean getEnableEncryptedRtpHeaderExtensions() {
            return this.enableEncryptedRtpHeaderExtensions;
        }

        @CalledByNative("Srtp")
        public boolean getEnableGcmCryptoSuites() {
            return this.enableGcmCryptoSuites;
        }
    }

    private CryptoOptions(boolean z7, boolean z8, boolean z9, boolean z10) {
        this.srtp = new Srtp(z7, z8, z9);
        this.sframe = new SFrame(z10);
    }

    public static Builder builder() {
        return new Builder();
    }

    @CalledByNative
    public SFrame getSFrame() {
        return this.sframe;
    }

    @CalledByNative
    public Srtp getSrtp() {
        return this.srtp;
    }
}
