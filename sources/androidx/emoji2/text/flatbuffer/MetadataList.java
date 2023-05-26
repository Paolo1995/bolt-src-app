package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class MetadataList extends Table {
    public static MetadataList h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new MetadataList());
    }

    public static MetadataList i(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public MetadataList f(int i8, ByteBuffer byteBuffer) {
        g(i8, byteBuffer);
        return this;
    }

    public void g(int i8, ByteBuffer byteBuffer) {
        c(i8, byteBuffer);
    }

    public MetadataItem j(MetadataItem metadataItem, int i8) {
        int b8 = b(6);
        if (b8 != 0) {
            return metadataItem.f(a(d(b8) + (i8 * 4)), this.f6518b);
        }
        return null;
    }

    public int k() {
        int b8 = b(6);
        if (b8 != 0) {
            return e(b8);
        }
        return 0;
    }

    public int l() {
        int b8 = b(4);
        if (b8 != 0) {
            return this.f6518b.getInt(b8 + this.f6517a);
        }
        return 0;
    }
}
