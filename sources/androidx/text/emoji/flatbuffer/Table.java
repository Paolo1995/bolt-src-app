package androidx.text.emoji.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* loaded from: classes.dex */
public class Table {

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<CharsetDecoder> f7774c = new ThreadLocal<CharsetDecoder>() { // from class: androidx.text.emoji.flatbuffer.Table.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public CharsetDecoder initialValue() {
            return Charset.forName("UTF-8").newDecoder();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<Charset> f7775d = new ThreadLocal<Charset>() { // from class: androidx.text.emoji.flatbuffer.Table.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Charset initialValue() {
            return Charset.forName("UTF-8");
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<CharBuffer> f7776e = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    protected int f7777a;

    /* renamed from: b  reason: collision with root package name */
    protected ByteBuffer f7778b;

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i8) {
        return i8 + this.f7778b.getInt(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i8) {
        int i9 = this.f7777a;
        int i10 = i9 - this.f7778b.getInt(i9);
        if (i8 < this.f7778b.getShort(i10)) {
            return this.f7778b.getShort(i10 + i8);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(int i8) {
        int i9 = i8 + this.f7777a;
        return i9 + this.f7778b.getInt(i9) + 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i8) {
        int i9 = i8 + this.f7777a;
        return this.f7778b.getInt(i9 + this.f7778b.getInt(i9));
    }
}
