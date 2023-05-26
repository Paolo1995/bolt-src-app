package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class Table {

    /* renamed from: a  reason: collision with root package name */
    protected int f6517a;

    /* renamed from: b  reason: collision with root package name */
    protected ByteBuffer f6518b;

    /* renamed from: c  reason: collision with root package name */
    private int f6519c;

    /* renamed from: d  reason: collision with root package name */
    private int f6520d;

    /* renamed from: e  reason: collision with root package name */
    Utf8 f6521e = Utf8.a();

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i8) {
        return i8 + this.f6518b.getInt(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i8) {
        if (i8 < this.f6520d) {
            return this.f6518b.getShort(this.f6519c + i8);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i8, ByteBuffer byteBuffer) {
        this.f6518b = byteBuffer;
        if (byteBuffer != null) {
            this.f6517a = i8;
            int i9 = i8 - byteBuffer.getInt(i8);
            this.f6519c = i9;
            this.f6520d = this.f6518b.getShort(i9);
            return;
        }
        this.f6517a = 0;
        this.f6519c = 0;
        this.f6520d = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i8) {
        int i9 = i8 + this.f6517a;
        return i9 + this.f6518b.getInt(i9) + 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(int i8) {
        int i9 = i8 + this.f6517a;
        return this.f6518b.getInt(i9 + this.f6518b.getInt(i9));
    }
}
