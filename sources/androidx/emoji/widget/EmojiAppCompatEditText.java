package androidx.emoji.widget;

import android.content.Context;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatEditText;

/* loaded from: classes.dex */
public class EmojiAppCompatEditText extends AppCompatEditText {

    /* renamed from: l  reason: collision with root package name */
    private EmojiEditTextHelper f6389l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f6390m;

    public EmojiAppCompatEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(attributeSet, R$attr.B);
    }

    private void e(AttributeSet attributeSet, int i8) {
        if (!this.f6390m) {
            this.f6390m = true;
            setMaxEmojiCount(new EditTextAttributeHelper(this, attributeSet, i8, 0).a());
            setKeyListener(super.getKeyListener());
        }
    }

    private EmojiEditTextHelper getEmojiEditTextHelper() {
        if (this.f6389l == null) {
            this.f6389l = new EmojiEditTextHelper(this);
        }
        return this.f6389l;
    }

    public int getMaxEmojiCount() {
        return getEmojiEditTextHelper().c();
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return getEmojiEditTextHelper().d(super.onCreateInputConnection(editorInfo), editorInfo);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        if (keyListener != null) {
            keyListener = getEmojiEditTextHelper().b(keyListener);
        }
        super.setKeyListener(keyListener);
    }

    public void setMaxEmojiCount(int i8) {
        getEmojiEditTextHelper().f(i8);
    }

    public EmojiAppCompatEditText(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        e(attributeSet, i8);
    }
}
