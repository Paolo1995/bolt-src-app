package androidx.emoji.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.text.emoji.flatbuffer.MetadataItem;

/* loaded from: classes.dex */
public class EmojiMetadata {

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<MetadataItem> f6335d = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final int f6336a;

    /* renamed from: b  reason: collision with root package name */
    private final MetadataRepo f6337b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f6338c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiMetadata(@NonNull MetadataRepo metadataRepo, int i8) {
        this.f6337b = metadataRepo;
        this.f6336a = i8;
    }

    private MetadataItem g() {
        ThreadLocal<MetadataItem> threadLocal = f6335d;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.f6337b.e().i(metadataItem, this.f6336a);
        return metadataItem;
    }

    public void a(@NonNull Canvas canvas, float f8, float f9, @NonNull Paint paint) {
        Typeface h8 = this.f6337b.h();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(h8);
        canvas.drawText(this.f6337b.d(), this.f6336a * 2, 2, f8, f9, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i8) {
        return g().g(i8);
    }

    public int c() {
        return g().h();
    }

    public int d() {
        return this.f6338c;
    }

    public short e() {
        return g().j();
    }

    public int f() {
        return g().k();
    }

    public short h() {
        return g().l();
    }

    public short i() {
        return g().m();
    }

    public boolean j() {
        return g().i();
    }

    public void k(boolean z7) {
        int i8;
        if (z7) {
            i8 = 2;
        } else {
            i8 = 1;
        }
        this.f6338c = i8;
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
