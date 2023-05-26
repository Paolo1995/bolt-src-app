package androidx.text.emoji.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class MetadataList extends Table {
    public static MetadataList g(ByteBuffer byteBuffer) {
        return h(byteBuffer, new MetadataList());
    }

    public static MetadataList h(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.e(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public MetadataList e(int i8, ByteBuffer byteBuffer) {
        f(i8, byteBuffer);
        return this;
    }

    public void f(int i8, ByteBuffer byteBuffer) {
        this.f7777a = i8;
        this.f7778b = byteBuffer;
    }

    public MetadataItem i(MetadataItem metadataItem, int i8) {
        int b8 = b(6);
        if (b8 != 0) {
            return metadataItem.e(a(c(b8) + (i8 * 4)), this.f7778b);
        }
        return null;
    }

    public int j() {
        int b8 = b(6);
        if (b8 != 0) {
            return d(b8);
        }
        return 0;
    }

    public int k() {
        int b8 = b(4);
        if (b8 != 0) {
            return this.f7778b.getInt(b8 + this.f7777a);
        }
        return 0;
    }
}
