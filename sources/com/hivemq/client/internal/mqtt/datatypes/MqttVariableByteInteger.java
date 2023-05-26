package com.hivemq.client.internal.mqtt.datatypes;

import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public final class MqttVariableByteInteger {
    private MqttVariableByteInteger() {
    }

    public static int a(ByteBuf byteBuf) {
        byte b8 = 0;
        int i8 = 0;
        while (b8 <= 21) {
            if (!byteBuf.isReadable()) {
                return -1;
            }
            byte readByte = byteBuf.readByte();
            i8 += (readByte & Byte.MAX_VALUE) << b8;
            b8 = (byte) (b8 + 7);
            if ((readByte & 128) == 0) {
                if (b8 > 7 && readByte == 0) {
                    return -3;
                }
                return i8;
            }
        }
        return -2;
    }

    public static void b(int i8, ByteBuf byteBuf) {
        do {
            int i9 = i8 & 127;
            i8 >>>= 7;
            if (i8 > 0) {
                i9 |= 128;
            }
            byteBuf.writeByte(i9);
        } while (i8 > 0);
    }

    public static int c(int i8) {
        if (i8 > 127) {
            if (i8 > 16383) {
                return i8 > 2097151 ? 4 : 3;
            }
            return 2;
        }
        return 1;
    }
}
