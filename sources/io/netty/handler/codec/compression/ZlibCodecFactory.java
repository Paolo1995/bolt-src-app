package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: classes5.dex */
public final class ZlibCodecFactory {
    private static final InternalLogger logger;
    private static final boolean noJdkZlibDecoder;
    private static final boolean noJdkZlibEncoder;
    private static final boolean supportsWindowSizeAndMemLevel;

    static {
        boolean z7;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(ZlibCodecFactory.class);
        logger = internalLoggerFactory;
        boolean z8 = true;
        if (PlatformDependent.javaVersion() < 7) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean z9 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibDecoder", z7);
        noJdkZlibDecoder = z9;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibDecoder: {}", Boolean.valueOf(z9));
        boolean z10 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibEncoder", false);
        noJdkZlibEncoder = z10;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibEncoder: {}", Boolean.valueOf(z10));
        if (!z9 && PlatformDependent.javaVersion() < 7) {
            z8 = false;
        }
        supportsWindowSizeAndMemLevel = z8;
    }

    private ZlibCodecFactory() {
    }

    public static ZlibDecoder newZlibDecoder(ZlibWrapper zlibWrapper) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder(zlibWrapper, true);
        }
        return new JZlibDecoder(zlibWrapper);
    }
}
