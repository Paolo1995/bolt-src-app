package io.netty.channel;

import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.MacAddressUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class DefaultChannelId implements ChannelId {
    private static final byte[] MACHINE_ID;
    private static final int PROCESS_ID;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelId.class);
    private static final AtomicInteger nextSequence = new AtomicInteger();
    private final byte[] data;
    private final int hashCode;
    private transient String longValue;
    private transient String shortValue;

    static {
        int i8;
        String str = SystemPropertyUtil.get("io.netty.processId");
        int i9 = -1;
        if (str != null) {
            try {
                i8 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i8 = -1;
            }
            if (i8 < 0) {
                logger.warn("-Dio.netty.processId: {} (malformed)", str);
            } else {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("-Dio.netty.processId: {} (user-set)", Integer.valueOf(i8));
                }
                i9 = i8;
            }
        }
        if (i9 < 0) {
            i9 = defaultProcessId();
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(i9));
            }
        }
        PROCESS_ID = i9;
        byte[] bArr = null;
        String str2 = SystemPropertyUtil.get("io.netty.machineId");
        if (str2 != null) {
            try {
                bArr = MacAddressUtil.parseMAC(str2);
            } catch (Exception e8) {
                logger.warn("-Dio.netty.machineId: {} (malformed)", str2, e8);
            }
            if (bArr != null) {
                logger.debug("-Dio.netty.machineId: {} (user-set)", str2);
            }
        }
        if (bArr == null) {
            bArr = MacAddressUtil.defaultMachineId();
            InternalLogger internalLogger3 = logger;
            if (internalLogger3.isDebugEnabled()) {
                internalLogger3.debug("-Dio.netty.machineId: {} (auto-detected)", MacAddressUtil.formatAddress(bArr));
            }
        }
        MACHINE_ID = bArr;
    }

    private DefaultChannelId() {
        byte[] bArr = MACHINE_ID;
        byte[] bArr2 = new byte[bArr.length + 4 + 4 + 8 + 4];
        this.data = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        writeInt(writeLong(writeInt(writeInt(bArr.length + 0, PROCESS_ID), nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis()), PlatformDependent.threadLocalRandom().nextInt());
        this.hashCode = Arrays.hashCode(bArr2);
    }

    private int appendHexDumpField(StringBuilder sb, int i8, int i9) {
        sb.append(ByteBufUtil.hexDump(this.data, i8, i9));
        sb.append('-');
        return i8 + i9;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int defaultProcessId() {
        /*
            r0 = 1
            r1 = 0
            java.lang.Class<io.netty.channel.DefaultChannelId> r2 = io.netty.channel.DefaultChannelId.class
            java.lang.ClassLoader r2 = io.netty.util.internal.PlatformDependent.getClassLoader(r2)     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "java.lang.management.ManagementFactory"
            java.lang.Class r3 = java.lang.Class.forName(r3, r0, r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = "java.lang.management.RuntimeMXBean"
            java.lang.Class r4 = java.lang.Class.forName(r4, r0, r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r5 = "getRuntimeMXBean"
            java.lang.Class<?>[] r6 = io.netty.util.internal.EmptyArrays.EMPTY_CLASSES     // Catch: java.lang.Throwable -> L2f
            java.lang.reflect.Method r3 = r3.getMethod(r5, r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object[] r5 = io.netty.util.internal.EmptyArrays.EMPTY_OBJECTS     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r3 = r3.invoke(r1, r5)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r7 = "getName"
            java.lang.reflect.Method r4 = r4.getMethod(r7, r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r3 = r4.invoke(r3, r5)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L2f
            goto L5d
        L2f:
            r3 = move-exception
            goto L33
        L31:
            r3 = move-exception
            r2 = r1
        L33:
            io.netty.util.internal.logging.InternalLogger r4 = io.netty.channel.DefaultChannelId.logger
            java.lang.String r5 = "Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?"
            r4.debug(r5, r3)
            java.lang.String r3 = "android.os.Process"
            java.lang.Class r0 = java.lang.Class.forName(r3, r0, r2)     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = "myPid"
            java.lang.Class<?>[] r3 = io.netty.util.internal.EmptyArrays.EMPTY_CLASSES     // Catch: java.lang.Throwable -> L53
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch: java.lang.Throwable -> L53
            java.lang.Object[] r2 = io.netty.util.internal.EmptyArrays.EMPTY_OBJECTS     // Catch: java.lang.Throwable -> L53
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L53
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L53
            goto L5d
        L53:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.DefaultChannelId.logger
            java.lang.String r2 = "Could not invoke Process.myPid(); not Android?"
            r1.debug(r2, r0)
            java.lang.String r3 = ""
        L5d:
            r0 = 64
            int r0 = r3.indexOf(r0)
            if (r0 < 0) goto L6a
            r1 = 0
            java.lang.String r3 = r3.substring(r1, r0)
        L6a:
            int r0 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L6f
            goto L70
        L6f:
            r0 = -1
        L70:
            if (r0 >= 0) goto L85
            java.util.Random r0 = io.netty.util.internal.PlatformDependent.threadLocalRandom()
            int r0 = r0.nextInt()
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.DefaultChannelId.logger
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "Failed to find the current process ID from '{}'; using a random value: {}"
            r1.warn(r4, r3, r2)
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.DefaultChannelId.defaultProcessId():int");
    }

    public static DefaultChannelId newInstance() {
        return new DefaultChannelId();
    }

    private String newLongValue() {
        StringBuilder sb = new StringBuilder((this.data.length * 2) + 5);
        appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, 0, MACHINE_ID.length), 4), 4), 8), 4);
        return sb.substring(0, sb.length() - 1);
    }

    private int writeInt(int i8, int i9) {
        byte[] bArr = this.data;
        int i10 = i8 + 1;
        bArr[i8] = (byte) (i9 >>> 24);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i9 >>> 16);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i9 >>> 8);
        int i13 = i12 + 1;
        bArr[i12] = (byte) i9;
        return i13;
    }

    private int writeLong(int i8, long j8) {
        byte[] bArr = this.data;
        int i9 = i8 + 1;
        bArr[i8] = (byte) (j8 >>> 56);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (j8 >>> 48);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (j8 >>> 40);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (j8 >>> 32);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (j8 >>> 24);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (j8 >>> 16);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (j8 >>> 8);
        int i16 = i15 + 1;
        bArr[i15] = (byte) j8;
        return i16;
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        String str = this.longValue;
        if (str == null) {
            String newLongValue = newLongValue();
            this.longValue = newLongValue;
            return newLongValue;
        }
        return str;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        String str = this.shortValue;
        if (str == null) {
            byte[] bArr = this.data;
            String hexDump = ByteBufUtil.hexDump(bArr, bArr.length - 4, 4);
            this.shortValue = hexDump;
            return hexDump;
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultChannelId)) {
            return false;
        }
        DefaultChannelId defaultChannelId = (DefaultChannelId) obj;
        if (this.hashCode == defaultChannelId.hashCode && Arrays.equals(this.data, defaultChannelId.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return asShortText();
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (this == channelId) {
            return 0;
        }
        if (channelId instanceof DefaultChannelId) {
            byte[] bArr = ((DefaultChannelId) channelId).data;
            int length = this.data.length;
            int length2 = bArr.length;
            int min = Math.min(length, length2);
            for (int i8 = 0; i8 < min; i8++) {
                byte b8 = this.data[i8];
                byte b9 = bArr[i8];
                if (b8 != b9) {
                    return (b8 & 255) - (b9 & 255);
                }
            }
            return length - length2;
        }
        return asLongText().compareTo(channelId.asLongText());
    }
}
