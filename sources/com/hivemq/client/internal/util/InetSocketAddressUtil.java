package com.hivemq.client.internal.util;

import io.netty.util.NetUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* loaded from: classes3.dex */
public final class InetSocketAddressUtil {
    private InetSocketAddressUtil() {
    }

    public static InetSocketAddress a(String str, int i8) {
        byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
        if (createByteArrayFromIpAddressString != null) {
            try {
                return new InetSocketAddress(InetAddress.getByAddress(createByteArrayFromIpAddressString), i8);
            } catch (UnknownHostException unused) {
            }
        }
        return InetSocketAddress.createUnresolved(str, i8);
    }
}
