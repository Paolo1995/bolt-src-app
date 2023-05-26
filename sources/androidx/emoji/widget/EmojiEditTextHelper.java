package androidx.emoji.widget;

import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class EmojiEditTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f6391a;

    /* renamed from: b  reason: collision with root package name */
    private int f6392b = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: c  reason: collision with root package name */
    private int f6393c = 0;

    /* loaded from: classes.dex */
    static class HelperInternal {
        HelperInternal() {
        }

        KeyListener a(@NonNull KeyListener keyListener) {
            return keyListener;
        }

        InputConnection b(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            return inputConnection;
        }

        void c(int i8) {
        }

        void d(int i8) {
        }
    }

    /* loaded from: classes.dex */
    private static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f6394a;

        /* renamed from: b  reason: collision with root package name */
        private final EmojiTextWatcher f6395b;

        HelperInternal19(@NonNull EditText editText) {
            this.f6394a = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText);
            this.f6395b = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji.widget.EmojiEditTextHelper.HelperInternal
        KeyListener a(@NonNull KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            return new EmojiKeyListener(keyListener);
        }

        @Override // androidx.emoji.widget.EmojiEditTextHelper.HelperInternal
        InputConnection b(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            if (inputConnection instanceof EmojiInputConnection) {
                return inputConnection;
            }
            return new EmojiInputConnection(this.f6394a, inputConnection, editorInfo);
        }

        @Override // androidx.emoji.widget.EmojiEditTextHelper.HelperInternal
        void c(int i8) {
            this.f6395b.b(i8);
        }

        @Override // androidx.emoji.widget.EmojiEditTextHelper.HelperInternal
        void d(int i8) {
            this.f6395b.c(i8);
        }
    }

    public EmojiEditTextHelper(@NonNull EditText editText) {
        Preconditions.h(editText, "editText cannot be null");
        this.f6391a = new HelperInternal19(editText);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f6393c;
    }

    @NonNull
    public KeyListener b(@NonNull KeyListener keyListener) {
        Preconditions.h(keyListener, "keyListener cannot be null");
        return this.f6391a.a(keyListener);
    }

    public int c() {
        return this.f6392b;
    }

    public InputConnection d(InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f6391a.b(inputConnection, editorInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i8) {
        this.f6393c = i8;
        this.f6391a.c(i8);
    }

    public void f(int i8) {
        Preconditions.e(i8, "maxEmojiCount should be greater than 0");
        this.f6392b = i8;
        this.f6391a.d(i8);
    }
}
