package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
final class EmojiInputConnection extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f6531a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiCompatDeleteHelper f6532b;

    /* loaded from: classes.dex */
    public static class EmojiCompatDeleteHelper {
        public boolean a(@NonNull InputConnection inputConnection, @NonNull Editable editable, int i8, int i9, boolean z7) {
            return EmojiCompat.e(inputConnection, editable, i8, i9, z7);
        }

        public void b(@NonNull EditorInfo editorInfo) {
            if (EmojiCompat.h()) {
                EmojiCompat.b().u(editorInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputConnection(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    private Editable a() {
        return this.f6531a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i8, int i9) {
        if (!this.f6532b.a(this, a(), i8, i9, false) && !super.deleteSurroundingText(i8, i9)) {
            return false;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i8, int i9) {
        if (!this.f6532b.a(this, a(), i8, i9, true) && !super.deleteSurroundingTextInCodePoints(i8, i9)) {
            return false;
        }
        return true;
    }

    EmojiInputConnection(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.f6531a = textView;
        this.f6532b = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.b(editorInfo);
    }
}
