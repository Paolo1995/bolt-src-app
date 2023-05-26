package androidx.text.emoji.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class MetadataItem extends Table {
    public MetadataItem e(int i8, ByteBuffer byteBuffer) {
        f(i8, byteBuffer);
        return this;
    }

    public void f(int i8, ByteBuffer byteBuffer) {
        this.f7777a = i8;
        this.f7778b = byteBuffer;
    }

    public int g(int i8) {
        int b8 = b(16);
        if (b8 != 0) {
            return this.f7778b.getInt(c(b8) + (i8 * 4));
        }
        return 0;
    }

    public int h() {
        int b8 = b(16);
        if (b8 != 0) {
            return d(b8);
        }
        return 0;
    }

    public boolean i() {
        int b8 = b(6);
        if (b8 == 0 || this.f7778b.get(b8 + this.f7777a) == 0) {
            return false;
        }
        return true;
    }

    public short j() {
        int b8 = b(14);
        if (b8 != 0) {
            return this.f7778b.getShort(b8 + this.f7777a);
        }
        return (short) 0;
    }

    public int k() {
        int b8 = b(4);
        if (b8 != 0) {
            return this.f7778b.getInt(b8 + this.f7777a);
        }
        return 0;
    }

    public short l() {
        int b8 = b(8);
        if (b8 != 0) {
            return this.f7778b.getShort(b8 + this.f7777a);
        }
        return (short) 0;
    }

    public short m() {
        int b8 = b(12);
        if (b8 != 0) {
            return this.f7778b.getShort(b8 + this.f7777a);
        }
        return (short) 0;
    }
}
