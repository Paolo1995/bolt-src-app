package io.netty.util.internal;

import java.util.Arrays;

/* loaded from: classes5.dex */
public final class AppendableCharSequence implements CharSequence, Appendable {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int i8) {
        if (i8 >= 1) {
            this.chars = new char[i8];
            return;
        }
        throw new IllegalArgumentException("length: " + i8 + " (length: >= 1)");
    }

    private static char[] expand(char[] cArr, int i8, int i9) {
        int length = cArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i8 > length);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, i9);
        return cArr2;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i8) {
        if (i8 <= this.pos) {
            return this.chars[i8];
        }
        throw new IndexOutOfBoundsException();
    }

    public char charAtUnsafe(int i8) {
        return this.chars[i8];
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.pos;
    }

    public void reset() {
        this.pos = 0;
    }

    public void setLength(int i8) {
        if (i8 >= 0 && i8 <= this.pos) {
            this.pos = i8;
            return;
        }
        throw new IllegalArgumentException("length: " + i8 + " (length: >= 0, <= " + this.pos + ')');
    }

    public String subStringUnsafe(int i8, int i9) {
        return new String(this.chars, i8, i9 - i8);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.chars, 0, this.pos);
    }

    @Override // java.lang.CharSequence
    public AppendableCharSequence subSequence(int i8, int i9) {
        if (i8 == i9) {
            return new AppendableCharSequence(Math.min(16, this.chars.length));
        }
        return new AppendableCharSequence(Arrays.copyOfRange(this.chars, i8, i9));
    }

    private AppendableCharSequence(char[] cArr) {
        if (cArr.length >= 1) {
            this.chars = cArr;
            this.pos = cArr.length;
            return;
        }
        throw new IllegalArgumentException("length: " + cArr.length + " (length: >= 1)");
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(char c8) {
        int i8 = this.pos;
        char[] cArr = this.chars;
        if (i8 == cArr.length) {
            char[] cArr2 = new char[cArr.length << 1];
            this.chars = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        }
        char[] cArr3 = this.chars;
        int i9 = this.pos;
        this.pos = i9 + 1;
        cArr3[i9] = c8;
        return this;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence, int i8, int i9) {
        if (charSequence.length() >= i9) {
            int i10 = i9 - i8;
            char[] cArr = this.chars;
            int length = cArr.length;
            int i11 = this.pos;
            if (i10 > length - i11) {
                this.chars = expand(cArr, i11 + i10, i11);
            }
            if (charSequence instanceof AppendableCharSequence) {
                System.arraycopy(((AppendableCharSequence) charSequence).chars, i8, this.chars, this.pos, i10);
                this.pos += i10;
                return this;
            }
            while (i8 < i9) {
                char[] cArr2 = this.chars;
                int i12 = this.pos;
                this.pos = i12 + 1;
                cArr2[i12] = charSequence.charAt(i8);
                i8++;
            }
            return this;
        }
        throw new IndexOutOfBoundsException();
    }
}
