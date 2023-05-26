package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.ByteBufferUtil;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class MqttBinaryData {
    private MqttBinaryData() {
    }

    public static ByteBuffer a(ByteBuf byteBuf, boolean z7) {
        int readUnsignedShort;
        if (byteBuf.readableBytes() < 2 || byteBuf.readableBytes() < (readUnsignedShort = byteBuf.readUnsignedShort())) {
            return null;
        }
        ByteBuffer a8 = ByteBufferUtil.a(readUnsignedShort, z7);
        byteBuf.readBytes(a8);
        a8.position(0);
        return a8;
    }

    public static byte[] b(ByteBuf byteBuf) {
        int readUnsignedShort;
        if (byteBuf.readableBytes() < 2 || byteBuf.readableBytes() < (readUnsignedShort = byteBuf.readUnsignedShort())) {
            return null;
        }
        byte[] bArr = new byte[readUnsignedShort];
        byteBuf.readBytes(bArr);
        return bArr;
    }

    public static void c(ByteBuffer byteBuffer, ByteBuf byteBuf) {
        byteBuf.writeShort(byteBuffer.remaining());
        byteBuf.writeBytes(byteBuffer.duplicate());
    }

    public static void d(byte[] bArr, ByteBuf byteBuf) {
        byteBuf.writeShort(bArr.length);
        byteBuf.writeBytes(bArr);
    }

    public static void e(ByteBuf byteBuf) {
        byteBuf.writeShort(0);
    }

    public static int f(ByteBuffer byteBuffer) {
        return byteBuffer.remaining() + 2;
    }

    public static int g(byte[] bArr) {
        return bArr.length + 2;
    }

    public static boolean h(byte[] bArr) {
        if (bArr.length <= 65535) {
            return true;
        }
        return false;
    }
}
