package androidx.emoji.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public abstract class EmojiSpan extends ReplacementSpan {

    /* renamed from: g  reason: collision with root package name */
    private final EmojiMetadata f6355g;

    /* renamed from: f  reason: collision with root package name */
    private final Paint.FontMetricsInt f6354f = new Paint.FontMetricsInt();

    /* renamed from: h  reason: collision with root package name */
    private short f6356h = -1;

    /* renamed from: i  reason: collision with root package name */
    private short f6357i = -1;

    /* renamed from: j  reason: collision with root package name */
    private float f6358j = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiSpan(@NonNull EmojiMetadata emojiMetadata) {
        Preconditions.h(emojiMetadata, "metadata cannot be null");
        this.f6355g = emojiMetadata;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final EmojiMetadata a() {
        return this.f6355g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.f6356h;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i8, int i9, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f6354f);
        Paint.FontMetricsInt fontMetricsInt2 = this.f6354f;
        this.f6358j = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f6355g.e();
        this.f6357i = (short) (this.f6355g.e() * this.f6358j);
        short i10 = (short) (this.f6355g.i() * this.f6358j);
        this.f6356h = i10;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f6354f;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i10;
    }
}
