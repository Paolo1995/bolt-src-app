package io.netty.util;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class AsciiString implements CharSequence, Comparable<CharSequence> {
    private int hash;
    private final int length;
    private final int offset;
    private String string;
    private final byte[] value;
    public static final AsciiString EMPTY_STRING = cached("");
    public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.1
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEqualsIgnoreCase(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };
    public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.2
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEquals(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };

    public AsciiString(byte[] bArr, int i8, int i9, boolean z7) {
        if (z7) {
            this.value = Arrays.copyOfRange(bArr, i8, i8 + i9);
            this.offset = 0;
        } else if (!MathUtil.isOutOfBounds(i8, i9, bArr.length)) {
            this.value = bArr;
            this.offset = i8;
        } else {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i8 + ") <= start + length(" + i9 + ") <= value.length(" + bArr.length + ')');
        }
        this.length = i9;
    }

    public static char b2c(byte b8) {
        return (char) (b8 & 255);
    }

    public static byte c2b(char c8) {
        if (c8 > 255) {
            c8 = '?';
        }
        return (byte) c8;
    }

    private static byte c2b0(char c8) {
        return (byte) c8;
    }

    public static AsciiString cached(String str) {
        AsciiString asciiString = new AsciiString(str);
        asciiString.string = str;
        return asciiString;
    }

    private static boolean equalsIgnoreCase(byte b8, byte b9) {
        return b8 == b9 || toLowerCase(b8) == toLowerCase(b9);
    }

    private int forEachByte0(int i8, int i9, ByteProcessor byteProcessor) throws Exception {
        int i10 = this.offset;
        int i11 = i10 + i8 + i9;
        for (int i12 = i10 + i8; i12 < i11; i12++) {
            if (!byteProcessor.process(this.value[i12])) {
                return i12 - this.offset;
            }
        }
        return -1;
    }

    public static boolean isUpperCase(byte b8) {
        return b8 >= 65 && b8 <= 90;
    }

    public static boolean isUpperCase(char c8) {
        return c8 >= 'A' && c8 <= 'Z';
    }

    public static AsciiString of(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return (AsciiString) charSequence;
        }
        return new AsciiString(charSequence);
    }

    private static byte toLowerCase(byte b8) {
        return isUpperCase(b8) ? (byte) (b8 + 32) : b8;
    }

    public static CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).trim();
        }
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int i8 = 0;
        int length = charSequence.length() - 1;
        while (i8 <= length && charSequence.charAt(i8) <= ' ') {
            i8++;
        }
        int i9 = length;
        while (i9 >= i8 && charSequence.charAt(i9) <= ' ') {
            i9--;
        }
        return (i8 == 0 && i9 == length) ? charSequence : charSequence.subSequence(i8, i9);
    }

    public byte[] array() {
        return this.value;
    }

    public int arrayOffset() {
        return this.offset;
    }

    public byte byteAt(int i8) {
        if (i8 >= 0 && i8 < this.length) {
            if (PlatformDependent.hasUnsafe()) {
                return PlatformDependent.getByte(this.value, i8 + this.offset);
            }
            return this.value[i8 + this.offset];
        }
        throw new IndexOutOfBoundsException("index: " + i8 + " must be in the range [0," + this.length + ")");
    }

    @Override // java.lang.CharSequence
    public char charAt(int i8) {
        return b2c(byteAt(i8));
    }

    public boolean contentEquals(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (charSequence instanceof AsciiString) {
            return equals(charSequence);
        }
        int arrayOffset = arrayOffset();
        for (int i8 = 0; i8 < charSequence.length(); i8++) {
            if (b2c(this.value[arrayOffset]) != charSequence.charAt(i8)) {
                return false;
            }
            arrayOffset++;
        }
        return true;
    }

    public boolean contentEqualsIgnoreCase(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            int arrayOffset = arrayOffset();
            int arrayOffset2 = asciiString.arrayOffset();
            int length = length() + arrayOffset;
            while (arrayOffset < length) {
                if (!equalsIgnoreCase(this.value[arrayOffset], asciiString.value[arrayOffset2])) {
                    return false;
                }
                arrayOffset++;
                arrayOffset2++;
            }
            return true;
        }
        int arrayOffset3 = arrayOffset();
        int length2 = length();
        for (int i8 = 0; i8 < length2; i8++) {
            if (!equalsIgnoreCase(b2c(this.value[arrayOffset3]), charSequence.charAt(i8))) {
                return false;
            }
            arrayOffset3++;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != AsciiString.class) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        AsciiString asciiString = (AsciiString) obj;
        if (length() != asciiString.length() || hashCode() != asciiString.hashCode() || !PlatformDependent.equals(array(), arrayOffset(), asciiString.array(), asciiString.arrayOffset(), length())) {
            return false;
        }
        return true;
    }

    public int forEachByte(ByteProcessor byteProcessor) throws Exception {
        return forEachByte0(0, length(), byteProcessor);
    }

    public int hashCode() {
        int i8 = this.hash;
        if (i8 == 0) {
            int hashCodeAscii = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
            this.hash = hashCodeAscii;
            return hashCodeAscii;
        }
        return i8;
    }

    public int indexOf(char c8, int i8) {
        if (c8 > 255) {
            return -1;
        }
        if (i8 < 0) {
            i8 = 0;
        }
        byte c2b0 = c2b0(c8);
        int i9 = this.offset;
        int i10 = this.length + i9;
        for (int i11 = i8 + i9; i11 < i10; i11++) {
            if (this.value[i11] == c2b0) {
                return i11 - this.offset;
            }
        }
        return -1;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        String str = this.string;
        if (str == null) {
            String asciiString = toString(0);
            this.string = asciiString;
            return asciiString;
        }
        return str;
    }

    private static boolean equalsIgnoreCase(char c8, char c9) {
        return c8 == c9 || toLowerCase(c8) == toLowerCase(c9);
    }

    public static char toLowerCase(char c8) {
        return isUpperCase(c8) ? (char) (c8 + ' ') : c8;
    }

    @Override // java.lang.Comparable
    public int compareTo(CharSequence charSequence) {
        int i8 = 0;
        if (this == charSequence) {
            return 0;
        }
        int length = length();
        int length2 = charSequence.length();
        int min = Math.min(length, length2);
        int arrayOffset = arrayOffset();
        while (i8 < min) {
            int b2c = b2c(this.value[arrayOffset]) - charSequence.charAt(i8);
            if (b2c != 0) {
                return b2c;
            }
            i8++;
            arrayOffset++;
        }
        return length - length2;
    }

    @Override // java.lang.CharSequence
    public AsciiString subSequence(int i8, int i9) {
        return subSequence(i8, i9, true);
    }

    public AsciiString subSequence(int i8, int i9, boolean z7) {
        int i10 = i9 - i8;
        if (!MathUtil.isOutOfBounds(i8, i10, length())) {
            if (i8 == 0 && i9 == length()) {
                return this;
            }
            if (i9 == i8) {
                return EMPTY_STRING;
            }
            return new AsciiString(this.value, i8 + this.offset, i10, z7);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i8 + ") <= end (" + i9 + ") <= length(" + length() + ')');
    }

    public static int hashCode(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        if (charSequence instanceof AsciiString) {
            return charSequence.hashCode();
        }
        return PlatformDependent.hashCodeAscii(charSequence);
    }

    public String toString(int i8) {
        return toString(i8, length());
    }

    public static int indexOf(CharSequence charSequence, char c8, int i8) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c8, i8);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).indexOf(c8, i8);
        }
        if (charSequence == null) {
            return -1;
        }
        int length = charSequence.length();
        if (i8 < 0) {
            i8 = 0;
        }
        while (i8 < length) {
            if (charSequence.charAt(i8) == c8) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public String toString(int i8, int i9) {
        int i10 = i9 - i8;
        if (i10 == 0) {
            return "";
        }
        if (!MathUtil.isOutOfBounds(i8, i10, length())) {
            return new String(this.value, 0, i8 + this.offset, i10);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i8 + ") <= srcIdx + length(" + i10 + ") <= srcLen(" + length() + ')');
    }

    public static boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        } else if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEquals(charSequence2);
        } else {
            if (charSequence2 instanceof AsciiString) {
                return ((AsciiString) charSequence2).contentEquals(charSequence);
            }
            if (charSequence.length() != charSequence2.length()) {
                return false;
            }
            for (int i8 = 0; i8 < charSequence.length(); i8++) {
                if (charSequence.charAt(i8) != charSequence2.charAt(i8)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean contentEqualsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        } else if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEqualsIgnoreCase(charSequence2);
        } else {
            if (charSequence2 instanceof AsciiString) {
                return ((AsciiString) charSequence2).contentEqualsIgnoreCase(charSequence);
            }
            if (charSequence.length() != charSequence2.length()) {
                return false;
            }
            for (int i8 = 0; i8 < charSequence.length(); i8++) {
                if (!equalsIgnoreCase(charSequence.charAt(i8), charSequence2.charAt(i8))) {
                    return false;
                }
            }
            return true;
        }
    }

    public AsciiString(CharSequence charSequence) {
        this(charSequence, 0, charSequence.length());
    }

    public AsciiString trim() {
        int arrayOffset = arrayOffset();
        int arrayOffset2 = (arrayOffset() + length()) - 1;
        while (arrayOffset <= arrayOffset2 && this.value[arrayOffset] <= 32) {
            arrayOffset++;
        }
        int i8 = arrayOffset2;
        while (i8 >= arrayOffset && this.value[i8] <= 32) {
            i8--;
        }
        return (arrayOffset == 0 && i8 == arrayOffset2) ? this : new AsciiString(this.value, arrayOffset, (i8 - arrayOffset) + 1, false);
    }

    public AsciiString(CharSequence charSequence, int i8, int i9) {
        if (!MathUtil.isOutOfBounds(i8, i9, charSequence.length())) {
            this.value = PlatformDependent.allocateUninitializedArray(i9);
            int i10 = 0;
            while (i10 < i9) {
                this.value[i10] = c2b(charSequence.charAt(i8));
                i10++;
                i8++;
            }
            this.offset = 0;
            this.length = i9;
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i8 + ") <= start + length(" + i9 + ") <= value.length(" + charSequence.length() + ')');
    }
}
