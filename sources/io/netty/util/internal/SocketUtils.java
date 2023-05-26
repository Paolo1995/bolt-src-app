package io.netty.util.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collections;
import java.util.Enumeration;

/* loaded from: classes5.dex */
public final class SocketUtils {
    private static final Enumeration<Object> EMPTY = Collections.enumeration(Collections.emptyList());

    private SocketUtils() {
    }

    public static InetAddress addressByName(final String str) throws UnknownHostException {
        try {
            return (InetAddress) AccessController.doPrivileged(new PrivilegedExceptionAction<InetAddress>() { // from class: io.netty.util.internal.SocketUtils.8
                @Override // java.security.PrivilegedExceptionAction
                public InetAddress run() throws UnknownHostException {
                    return InetAddress.getByName(str);
                }
            });
        } catch (PrivilegedActionException e8) {
            throw ((UnknownHostException) e8.getCause());
        }
    }

    public static Enumeration<InetAddress> addressesFromNetworkInterface(final NetworkInterface networkInterface) {
        Enumeration<InetAddress> enumeration = (Enumeration) AccessController.doPrivileged(new PrivilegedAction<Enumeration<InetAddress>>() { // from class: io.netty.util.internal.SocketUtils.11
            @Override // java.security.PrivilegedAction
            public Enumeration<InetAddress> run() {
                return networkInterface.getInetAddresses();
            }
        });
        if (enumeration == null) {
            return empty();
        }
        return enumeration;
    }

    public static void bind(final Socket socket, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: io.netty.util.internal.SocketUtils.2
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws IOException {
                    socket.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e8) {
            throw ((IOException) e8.getCause());
        }
    }

    public static boolean connect(final SocketChannel socketChannel, final SocketAddress socketAddress) throws IOException {
        try {
            return ((Boolean) AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() { // from class: io.netty.util.internal.SocketUtils.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public Boolean run() throws IOException {
                    return Boolean.valueOf(socketChannel.connect(socketAddress));
                }
            })).booleanValue();
        } catch (PrivilegedActionException e8) {
            throw ((IOException) e8.getCause());
        }
    }

    private static <T> Enumeration<T> empty() {
        return (Enumeration<T>) EMPTY;
    }

    public static byte[] hardwareAddressFromNetworkInterface(final NetworkInterface networkInterface) throws SocketException {
        try {
            return (byte[]) AccessController.doPrivileged(new PrivilegedExceptionAction<byte[]>() { // from class: io.netty.util.internal.SocketUtils.13
                @Override // java.security.PrivilegedExceptionAction
                public byte[] run() throws SocketException {
                    return networkInterface.getHardwareAddress();
                }
            });
        } catch (PrivilegedActionException e8) {
            throw ((SocketException) e8.getCause());
        }
    }

    public static void bind(final SocketChannel socketChannel, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: io.netty.util.internal.SocketUtils.4
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws IOException {
                    socketChannel.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e8) {
            throw ((IOException) e8.getCause());
        }
    }
}
