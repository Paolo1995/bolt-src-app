package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import com.google.android.gms.common.api.Api;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class EmojiTextWatcher implements TextWatcher {

    /* renamed from: f  reason: collision with root package name */
    private final EditText f6544f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f6545g;

    /* renamed from: h  reason: collision with root package name */
    private EmojiCompat.InitCallback f6546h;

    /* renamed from: i  reason: collision with root package name */
    private int f6547i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: j  reason: collision with root package name */
    private int f6548j = 0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6549k = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<EditText> f6550a;

        InitCallbackImpl(EditText editText) {
            this.f6550a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void b() {
            super.b();
            EmojiTextWatcher.b(this.f6550a.get(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiTextWatcher(EditText editText, boolean z7) {
        this.f6544f = editText;
        this.f6545g = z7;
    }

    private EmojiCompat.InitCallback a() {
        if (this.f6546h == null) {
            this.f6546h = new InitCallbackImpl(this.f6544f);
        }
        return this.f6546h;
    }

    static void b(EditText editText, int i8) {
        if (i8 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.b().o(editableText);
            EmojiInputFilter.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        if (this.f6549k && (this.f6545g || EmojiCompat.h())) {
            return false;
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }

    public void c(boolean z7) {
        if (this.f6549k != z7) {
            if (this.f6546h != null) {
                EmojiCompat.b().t(this.f6546h);
            }
            this.f6549k = z7;
            if (z7) {
                b(this.f6544f, EmojiCompat.b().d());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        if (!this.f6544f.isInEditMode() && !d() && i9 <= i10 && (charSequence instanceof Spannable)) {
            int d8 = EmojiCompat.b().d();
            if (d8 != 0) {
                if (d8 != 1) {
                    if (d8 != 3) {
                        return;
                    }
                } else {
                    EmojiCompat.b().r((Spannable) charSequence, i8, i8 + i10, this.f6547i, this.f6548j);
                    return;
                }
            }
            EmojiCompat.b().s(a());
        }
    }
}
