package androidx.emoji.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji.text.EmojiCompat;
import com.google.android.gms.common.api.Api;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class EmojiTextWatcher implements TextWatcher {

    /* renamed from: f  reason: collision with root package name */
    private final EditText f6409f;

    /* renamed from: g  reason: collision with root package name */
    private EmojiCompat.InitCallback f6410g;

    /* renamed from: h  reason: collision with root package name */
    private int f6411h = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: i  reason: collision with root package name */
    private int f6412i = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<EditText> f6413a;

        InitCallbackImpl(EditText editText) {
            this.f6413a = new WeakReference(editText);
        }

        @Override // androidx.emoji.text.EmojiCompat.InitCallback
        public void b() {
            super.b();
            EditText editText = this.f6413a.get();
            if (editText != null && editText.isAttachedToWindow()) {
                Editable editableText = editText.getEditableText();
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                EmojiCompat.a().l(editableText);
                EmojiInputFilter.b(editableText, selectionStart, selectionEnd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiTextWatcher(EditText editText) {
        this.f6409f = editText;
    }

    private EmojiCompat.InitCallback a() {
        if (this.f6410g == null) {
            this.f6410g = new InitCallbackImpl(this.f6409f);
        }
        return this.f6410g;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i8) {
        this.f6412i = i8;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i8) {
        this.f6411h = i8;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        if (!this.f6409f.isInEditMode() && i9 <= i10 && (charSequence instanceof Spannable)) {
            int c8 = EmojiCompat.a().c();
            if (c8 != 0) {
                if (c8 != 1) {
                    if (c8 != 3) {
                        return;
                    }
                } else {
                    EmojiCompat.a().o((Spannable) charSequence, i8, i8 + i10, this.f6411h, this.f6412i);
                    return;
                }
            }
            EmojiCompat.a().p(a());
        }
    }
}
