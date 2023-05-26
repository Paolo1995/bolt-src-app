package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {

    /* renamed from: k  reason: collision with root package name */
    private static Paint f6508k;

    public TypefaceEmojiSpan(@NonNull EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    @NonNull
    private static Paint c() {
        if (f6508k == null) {
            TextPaint textPaint = new TextPaint();
            f6508k = textPaint;
            textPaint.setColor(EmojiCompat.b().c());
            f6508k.setStyle(Paint.Style.FILL);
        }
        return f6508k;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i8, int i9, float f8, int i10, int i11, int i12, @NonNull Paint paint) {
        if (EmojiCompat.b().i()) {
            canvas.drawRect(f8, i10, f8 + b(), i12, c());
        }
        a().a(canvas, f8, i11, paint);
    }
}
