package androidx.emoji.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {

    /* renamed from: k  reason: collision with root package name */
    private static Paint f6387k;

    public TypefaceEmojiSpan(EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    private static Paint c() {
        if (f6387k == null) {
            TextPaint textPaint = new TextPaint();
            f6387k = textPaint;
            textPaint.setColor(EmojiCompat.a().b());
            f6387k.setStyle(Paint.Style.FILL);
        }
        return f6387k;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i8, int i9, float f8, int i10, int i11, int i12, @NonNull Paint paint) {
        if (EmojiCompat.a().g()) {
            canvas.drawRect(f8, i10, f8 + b(), i12, c());
        }
        a().a(canvas, f8, i11, paint);
    }
}
