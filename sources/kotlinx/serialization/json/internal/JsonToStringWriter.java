package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: JsonToStringWriter.kt */
/* loaded from: classes5.dex */
public final class JsonToStringWriter implements JsonWriter {

    /* renamed from: a  reason: collision with root package name */
    private char[] f52394a = CharArrayPool.f52371a.b();

    /* renamed from: b  reason: collision with root package name */
    private int f52395b;

    private final void d(int i8, int i9, String str) {
        int i10;
        int length = str.length();
        while (i8 < length) {
            int f8 = f(i9, 2);
            char charAt = str.charAt(i8);
            if (charAt < StringOpsKt.a().length) {
                byte b8 = StringOpsKt.a()[charAt];
                if (b8 == 0) {
                    i10 = f8 + 1;
                    this.f52394a[f8] = charAt;
                } else {
                    if (b8 == 1) {
                        String str2 = StringOpsKt.b()[charAt];
                        Intrinsics.c(str2);
                        int f9 = f(f8, str2.length());
                        str2.getChars(0, str2.length(), this.f52394a, f9);
                        i9 = f9 + str2.length();
                        this.f52395b = i9;
                    } else {
                        char[] cArr = this.f52394a;
                        cArr[f8] = '\\';
                        cArr[f8 + 1] = (char) b8;
                        i9 = f8 + 2;
                        this.f52395b = i9;
                    }
                    i8++;
                }
            } else {
                i10 = f8 + 1;
                this.f52394a[f8] = charAt;
            }
            i9 = i10;
            i8++;
        }
        int f10 = f(i9, 1);
        this.f52394a[f10] = '\"';
        this.f52395b = f10 + 1;
    }

    private final void e(int i8) {
        f(this.f52395b, i8);
    }

    private final int f(int i8, int i9) {
        int d8;
        int i10 = i9 + i8;
        char[] cArr = this.f52394a;
        if (cArr.length <= i10) {
            d8 = RangesKt___RangesKt.d(i10, i8 * 2);
            char[] copyOf = Arrays.copyOf(cArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52394a = copyOf;
        }
        return i8;
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void a(char c8) {
        e(1);
        char[] cArr = this.f52394a;
        int i8 = this.f52395b;
        this.f52395b = i8 + 1;
        cArr[i8] = c8;
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void b(String text) {
        Intrinsics.f(text, "text");
        e(text.length() + 2);
        char[] cArr = this.f52394a;
        int i8 = this.f52395b;
        int i9 = i8 + 1;
        cArr[i8] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i9);
        int i10 = length + i9;
        for (int i11 = i9; i11 < i10; i11++) {
            char c8 = cArr[i11];
            if (c8 < StringOpsKt.a().length && StringOpsKt.a()[c8] != 0) {
                d(i11 - i9, i11, text);
                return;
            }
        }
        cArr[i10] = '\"';
        this.f52395b = i10 + 1;
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void c(String text) {
        Intrinsics.f(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        e(length);
        text.getChars(0, text.length(), this.f52394a, this.f52395b);
        this.f52395b += length;
    }

    public void g() {
        CharArrayPool.f52371a.a(this.f52394a);
    }

    public String toString() {
        return new String(this.f52394a, 0, this.f52395b);
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void writeLong(long j8) {
        c(String.valueOf(j8));
    }
}
