package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* loaded from: classes.dex */
class AppCompatEmojiEditTextHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final EditText f1858a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final EmojiEditTextHelper f1859b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatEmojiEditTextHelper(@NonNull EditText editText) {
        this.f1858a = editText;
        this.f1859b = new EmojiEditTextHelper(editText, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyListener a(KeyListener keyListener) {
        if (b(keyListener)) {
            return this.f1859b.a(keyListener);
        }
        return keyListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i8) {
        TypedArray obtainStyledAttributes = this.f1858a.getContext().obtainStyledAttributes(attributeSet, R$styleable.f987g0, i8, 0);
        try {
            int i9 = R$styleable.f1057u0;
            boolean z7 = true;
            if (obtainStyledAttributes.hasValue(i9)) {
                z7 = obtainStyledAttributes.getBoolean(i9, true);
            }
            obtainStyledAttributes.recycle();
            e(z7);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputConnection d(InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return this.f1859b.b(inputConnection, editorInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z7) {
        this.f1859b.c(z7);
    }
}
