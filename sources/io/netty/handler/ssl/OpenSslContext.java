package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.security.cert.Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;

/* loaded from: classes5.dex */
public abstract class OpenSslContext extends ReferenceCountedOpenSslContext {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j8, long j9, int i8, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z7, boolean z8) throws SSLException {
        super(iterable, cipherSuiteFilter, applicationProtocolConfig, j8, j9, i8, certificateArr, clientAuth, strArr, z7, z8, false);
    }

    protected final void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    final SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i8, boolean z7) {
        return new OpenSslEngine(this, byteBufAllocator, str, i8, z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j8, long j9, int i8, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z7, boolean z8) throws SSLException {
        super(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, j8, j9, i8, certificateArr, clientAuth, strArr, z7, z8, false);
    }
}
