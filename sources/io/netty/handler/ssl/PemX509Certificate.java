package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class PemX509Certificate extends X509Certificate implements PemEncoded {
    private static final byte[] BEGIN_CERT;
    private static final byte[] END_CERT;

    static {
        Charset charset = CharsetUtil.US_ASCII;
        BEGIN_CERT = "-----BEGIN CERTIFICATE-----\n".getBytes(charset);
        END_CERT = "\n-----END CERTIFICATE-----\n".getBytes(charset);
    }

    private static ByteBuf append(ByteBufAllocator byteBufAllocator, boolean z7, PemEncoded pemEncoded, int i8, ByteBuf byteBuf) {
        ByteBuf content = pemEncoded.content();
        if (byteBuf == null) {
            byteBuf = newBuffer(byteBufAllocator, z7, content.readableBytes() * i8);
        }
        byteBuf.writeBytes(content.slice());
        return byteBuf;
    }

    private static ByteBuf newBuffer(ByteBufAllocator byteBufAllocator, boolean z7, int i8) {
        if (z7) {
            return byteBufAllocator.directBuffer(i8);
        }
        return byteBufAllocator.buffer(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PemEncoded toPEM(ByteBufAllocator byteBufAllocator, boolean z7, X509Certificate... x509CertificateArr) throws CertificateEncodingException {
        if (x509CertificateArr != null && x509CertificateArr.length != 0) {
            if (x509CertificateArr.length == 1) {
                X509Certificate x509Certificate = x509CertificateArr[0];
                if (x509Certificate instanceof PemEncoded) {
                    return ((PemEncoded) x509Certificate).retain();
                }
            }
            ByteBuf byteBuf = null;
            try {
                for (X509Certificate x509Certificate2 : x509CertificateArr) {
                    if (x509Certificate2 != null) {
                        if (x509Certificate2 instanceof PemEncoded) {
                            byteBuf = append(byteBufAllocator, z7, (PemEncoded) x509Certificate2, x509CertificateArr.length, byteBuf);
                        } else {
                            byteBuf = append(byteBufAllocator, z7, x509Certificate2, x509CertificateArr.length, byteBuf);
                        }
                    } else {
                        throw new IllegalArgumentException("Null element in chain: " + Arrays.toString(x509CertificateArr));
                    }
                }
                return new PemValue(byteBuf, false);
            } catch (Throwable th) {
                if (0 != 0) {
                    byteBuf.release();
                }
                throw th;
            }
        }
        throw new IllegalArgumentException("X.509 certificate chain can't be null or empty");
    }

    private static ByteBuf append(ByteBufAllocator byteBufAllocator, boolean z7, X509Certificate x509Certificate, int i8, ByteBuf byteBuf) throws CertificateEncodingException {
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(x509Certificate.getEncoded());
        try {
            ByteBuf base64 = SslUtils.toBase64(byteBufAllocator, wrappedBuffer);
            if (byteBuf == null) {
                byteBuf = newBuffer(byteBufAllocator, z7, (BEGIN_CERT.length + base64.readableBytes() + END_CERT.length) * i8);
            }
            byteBuf.writeBytes(BEGIN_CERT);
            byteBuf.writeBytes(base64);
            byteBuf.writeBytes(END_CERT);
            base64.release();
            return byteBuf;
        } finally {
            wrappedBuffer.release();
        }
    }
}
