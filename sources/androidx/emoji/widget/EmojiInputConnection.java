package androidx.emoji.widget;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.emoji.text.EmojiCompat;

/* loaded from: classes.dex */
final class EmojiInputConnection extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f6401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputConnection(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        super(inputConnection, false);
        this.f6401a = textView;
        EmojiCompat.a().q(editorInfo);
    }

    private Editable a() {
        return this.f6401a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i8, int i9) {
        if (!EmojiCompat.d(this, a(), i8, i9, false) && !super.deleteSurroundingText(i8, i9)) {
            return false;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i8, int i9) {
        if (EmojiCompat.d(this, a(), i8, i9, true) || super.deleteSurroundingTextInCodePoints(i8, i9)) {
            return true;
        }
        return false;
    }
}
