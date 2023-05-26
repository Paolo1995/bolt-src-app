package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class EmojiEditTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f6523a;

    /* renamed from: b  reason: collision with root package name */
    private int f6524b = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: c  reason: collision with root package name */
    private int f6525c = 0;

    /* loaded from: classes.dex */
    static class HelperInternal {
        HelperInternal() {
        }

        KeyListener a(KeyListener keyListener) {
            return keyListener;
        }

        InputConnection b(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            return inputConnection;
        }

        void c(boolean z7) {
        }
    }

    /* loaded from: classes.dex */
    private static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f6526a;

        /* renamed from: b  reason: collision with root package name */
        private final EmojiTextWatcher f6527b;

        HelperInternal19(@NonNull EditText editText, boolean z7) {
            this.f6526a = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z7);
            this.f6527b = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new EmojiKeyListener(keyListener);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        InputConnection b(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            if (inputConnection instanceof EmojiInputConnection) {
                return inputConnection;
            }
            return new EmojiInputConnection(this.f6526a, inputConnection, editorInfo);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void c(boolean z7) {
            this.f6527b.c(z7);
        }
    }

    public EmojiEditTextHelper(@NonNull EditText editText, boolean z7) {
        Preconditions.h(editText, "editText cannot be null");
        this.f6523a = new HelperInternal19(editText, z7);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f6523a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f6523a.b(inputConnection, editorInfo);
    }

    public void c(boolean z7) {
        this.f6523a.c(z7);
    }
}
