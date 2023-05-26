package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public abstract class EmojiSpan extends ReplacementSpan {
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final EmojiMetadata f6478g;

    /* renamed from: f  reason: collision with root package name */
    private final Paint.FontMetricsInt f6477f = new Paint.FontMetricsInt();

    /* renamed from: h  reason: collision with root package name */
    private short f6479h = -1;

    /* renamed from: i  reason: collision with root package name */
    private short f6480i = -1;

    /* renamed from: j  reason: collision with root package name */
    private float f6481j = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiSpan(@NonNull EmojiMetadata emojiMetadata) {
        Preconditions.h(emojiMetadata, "metadata cannot be null");
        this.f6478g = emojiMetadata;
    }

    @NonNull
    public final EmojiMetadata a() {
        return this.f6478g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.f6479h;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i8, int i9, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f6477f);
        Paint.FontMetricsInt fontMetricsInt2 = this.f6477f;
        this.f6481j = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f6478g.e();
        this.f6480i = (short) (this.f6478g.e() * this.f6481j);
        short i10 = (short) (this.f6478g.i() * this.f6481j);
        this.f6479h = i10;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f6477f;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i10;
    }
}
