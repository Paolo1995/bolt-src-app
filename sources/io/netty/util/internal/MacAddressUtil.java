package io.netty.util.internal;

import io.netty.util.NetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class MacAddressUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(MacAddressUtil.class);

    private MacAddressUtil() {
    }

    public static byte[] bestAvailableMac() {
        int compareAddresses;
        byte[] bArr = EmptyArrays.EMPTY_BYTES;
        InetAddress inetAddress = NetUtil.LOCALHOST4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    Enumeration<InetAddress> addressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(nextElement);
                    if (addressesFromNetworkInterface.hasMoreElements()) {
                        InetAddress nextElement2 = addressesFromNetworkInterface.nextElement();
                        if (!nextElement2.isLoopbackAddress()) {
                            linkedHashMap.put(nextElement, nextElement2);
                        }
                    }
                }
            }
        } catch (SocketException e8) {
            logger.warn("Failed to retrieve the list of available network interfaces", (Throwable) e8);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            boolean z7 = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            NetworkInterface networkInterface = (NetworkInterface) entry.getKey();
            InetAddress inetAddress2 = (InetAddress) entry.getValue();
            if (!networkInterface.isVirtual()) {
                try {
                    byte[] hardwareAddressFromNetworkInterface = SocketUtils.hardwareAddressFromNetworkInterface(networkInterface);
                    int compareAddresses2 = compareAddresses(bArr, hardwareAddressFromNetworkInterface);
                    if (compareAddresses2 < 0 || (compareAddresses2 == 0 && ((compareAddresses = compareAddresses(inetAddress, inetAddress2)) < 0 || (compareAddresses == 0 && bArr.length < hardwareAddressFromNetworkInterface.length)))) {
                        z7 = true;
                    }
                    if (z7) {
                        inetAddress = inetAddress2;
                        bArr = hardwareAddressFromNetworkInterface;
                    }
                } catch (SocketException e9) {
                    logger.debug("Failed to get the hardware address of a network interface: {}", networkInterface, e9);
                }
            }
        }
        if (bArr == EmptyArrays.EMPTY_BYTES) {
            return null;
        }
        if (bArr.length != 6) {
            return Arrays.copyOf(bArr, 8);
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 3);
        bArr2[3] = -1;
        bArr2[4] = -2;
        System.arraycopy(bArr, 3, bArr2, 5, 3);
        return bArr2;
    }

    static int compareAddresses(byte[] bArr, byte[] bArr2) {
        boolean z7;
        if (bArr2 == null || bArr2.length < 6) {
            return 1;
        }
        int length = bArr2.length;
        int i8 = 0;
        while (true) {
            if (i8 < length) {
                byte b8 = bArr2[i8];
                if (b8 != 0 && b8 != 1) {
                    z7 = false;
                    break;
                }
                i8++;
            } else {
                z7 = true;
                break;
            }
        }
        if (z7) {
            return 1;
        }
        byte b9 = bArr2[0];
        if ((b9 & 1) != 0) {
            return 1;
        }
        return (b9 & 2) == 0 ? (bArr.length == 0 || (bArr[0] & 2) != 0) ? -1 : 0 : (bArr.length == 0 || (bArr[0] & 2) != 0) ? 0 : 1;
    }

    public static byte[] defaultMachineId() {
        byte[] bestAvailableMac = bestAvailableMac();
        if (bestAvailableMac == null) {
            byte[] bArr = new byte[8];
            PlatformDependent.threadLocalRandom().nextBytes(bArr);
            logger.warn("Failed to find a usable hardware address from the network interfaces; using random bytes: {}", formatAddress(bArr));
            return bArr;
        }
        return bestAvailableMac;
    }

    public static String formatAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder(24);
        int length = bArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            sb.append(String.format("%02x:", Integer.valueOf(bArr[i8] & 255)));
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static byte[] parseMAC(String str) {
        char charAt;
        byte[] bArr;
        int length = str.length();
        if (length != 17) {
            if (length == 23) {
                charAt = str.charAt(2);
                validateMacSeparator(charAt);
                bArr = new byte[8];
            } else {
                throw new IllegalArgumentException("value is not supported [MAC-48, EUI-48, EUI-64]");
            }
        } else {
            charAt = str.charAt(2);
            validateMacSeparator(charAt);
            bArr = new byte[6];
        }
        int length2 = bArr.length - 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length2) {
            int i10 = i9 + 2;
            bArr[i8] = StringUtil.decodeHexByte(str, i9);
            if (str.charAt(i10) == charAt) {
                i8++;
                i9 += 3;
            } else {
                throw new IllegalArgumentException("expected separator '" + charAt + " but got '" + str.charAt(i10) + "' at index: " + i10);
            }
        }
        bArr[length2] = StringUtil.decodeHexByte(str, i9);
        return bArr;
    }

    private static int scoreAddress(InetAddress inetAddress) {
        if (!inetAddress.isAnyLocalAddress() && !inetAddress.isLoopbackAddress()) {
            if (inetAddress.isMulticastAddress()) {
                return 1;
            }
            if (inetAddress.isLinkLocalAddress()) {
                return 2;
            }
            if (inetAddress.isSiteLocalAddress()) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private static void validateMacSeparator(char c8) {
        if (c8 != ':' && c8 != '-') {
            throw new IllegalArgumentException("unsupported separator: " + c8 + " (expected: [:-])");
        }
    }

    private static int compareAddresses(InetAddress inetAddress, InetAddress inetAddress2) {
        return scoreAddress(inetAddress) - scoreAddress(inetAddress2);
    }
}
