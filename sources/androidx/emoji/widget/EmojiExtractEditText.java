package androidx.emoji.widget;

import android.content.Context;
import android.inputmethodservice.ExtractEditText;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.widget.TextViewCompat;

/* loaded from: classes.dex */
public class EmojiExtractEditText extends ExtractEditText {

    /* renamed from: f  reason: collision with root package name */
    private EmojiEditTextHelper f6399f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6400g;

    public EmojiExtractEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 16842862, 0);
    }

    private void a(AttributeSet attributeSet, int i8, int i9) {
        if (!this.f6400g) {
            this.f6400g = true;
            setMaxEmojiCount(new EditTextAttributeHelper(this, attributeSet, i8, i9).a());
            setKeyListener(super.getKeyListener());
        }
    }

    private EmojiEditTextHelper getEmojiEditTextHelper() {
        if (this.f6399f == null) {
            this.f6399f = new EmojiEditTextHelper(this);
        }
        return this.f6399f;
    }

    public int getEmojiReplaceStrategy() {
        return getEmojiEditTextHelper().a();
    }

    public int getMaxEmojiCount() {
        return getEmojiEditTextHelper().c();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return getEmojiEditTextHelper().d(super.onCreateInputConnection(editorInfo), editorInfo);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    public void setEmojiReplaceStrategy(int i8) {
        getEmojiEditTextHelper().e(i8);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        if (keyListener != null) {
            keyListener = getEmojiEditTextHelper().b(keyListener);
        }
        super.setKeyListener(keyListener);
    }

    public void setMaxEmojiCount(int i8) {
        getEmojiEditTextHelper().f(i8);
    }
}
