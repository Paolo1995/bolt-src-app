package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.emoji2.text.flatbuffer.MetadataItem;

/* loaded from: classes.dex */
public class EmojiMetadata {

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<MetadataItem> f6460d = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final int f6461a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final MetadataRepo f6462b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f6463c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiMetadata(@NonNull MetadataRepo metadataRepo, int i8) {
        this.f6462b = metadataRepo;
        this.f6461a = i8;
    }

    private MetadataItem g() {
        ThreadLocal<MetadataItem> threadLocal = f6460d;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.f6462b.d().j(metadataItem, this.f6461a);
        return metadataItem;
    }

    public void a(@NonNull Canvas canvas, float f8, float f9, @NonNull Paint paint) {
        Typeface g8 = this.f6462b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g8);
        canvas.drawText(this.f6462b.c(), this.f6461a * 2, 2, f8, f9, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i8) {
        return g().h(i8);
    }

    public int c() {
        return g().i();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int d() {
        return this.f6463c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void k(boolean z7) {
        int i8;
        if (z7) {
            i8 = 2;
        } else {
            i8 = 1;
        }
        this.f6463c = i8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int c8 = c();
        for (int i8 = 0; i8 < c8; i8++) {
            sb.append(Integer.toHexString(b(i8)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
