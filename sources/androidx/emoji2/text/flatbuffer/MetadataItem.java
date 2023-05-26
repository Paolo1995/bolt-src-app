package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class MetadataItem extends Table {
    public MetadataItem f(int i8, ByteBuffer byteBuffer) {
        g(i8, byteBuffer);
        return this;
    }

    public void g(int i8, ByteBuffer byteBuffer) {
        c(i8, byteBuffer);
    }

    public int h(int i8) {
        int b8 = b(16);
        if (b8 != 0) {
            return this.f6518b.getInt(d(b8) + (i8 * 4));
        }
        return 0;
    }

    public int i() {
        int b8 = b(16);
        if (b8 != 0) {
            return e(b8);
        }
        return 0;
    }

    public boolean j() {
        int b8 = b(6);
        if (b8 == 0 || this.f6518b.get(b8 + this.f6517a) == 0) {
            return false;
        }
        return true;
    }

    public short k() {
        int b8 = b(14);
        if (b8 != 0) {
            return this.f6518b.getShort(b8 + this.f6517a);
        }
        return (short) 0;
    }

    public int l() {
        int b8 = b(4);
        if (b8 != 0) {
            return this.f6518b.getInt(b8 + this.f6517a);
        }
        return 0;
    }

    public short m() {
        int b8 = b(8);
        if (b8 != 0) {
            return this.f6518b.getShort(b8 + this.f6517a);
        }
        return (short) 0;
    }

    public short n() {
        int b8 = b(12);
        if (b8 != 0) {
            return this.f6518b.getShort(b8 + this.f6517a);
        }
        return (short) 0;
    }
}
