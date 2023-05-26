package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f6420b = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f6421a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.f6421a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f6420b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean a(@NonNull CharSequence charSequence, int i8, int i9, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23 && i10 > i11) {
            return false;
        }
        StringBuilder b8 = b();
        b8.setLength(0);
        while (i8 < i9) {
            b8.append(charSequence.charAt(i8));
            i8++;
        }
        return PaintCompat.a(this.f6421a, b8.toString());
    }
}
