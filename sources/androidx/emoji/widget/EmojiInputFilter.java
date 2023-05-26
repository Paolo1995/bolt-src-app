package androidx.emoji.widget;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.emoji.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class EmojiInputFilter implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f6402a;

    /* renamed from: b  reason: collision with root package name */
    private EmojiCompat.InitCallback f6403b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<TextView> f6404a;

        InitCallbackImpl(TextView textView) {
            this.f6404a = new WeakReference(textView);
        }

        @Override // androidx.emoji.text.EmojiCompat.InitCallback
        public void b() {
            super.b();
            TextView textView = this.f6404a.get();
            if (textView != null && textView.isAttachedToWindow()) {
                CharSequence l8 = EmojiCompat.a().l(textView.getText());
                int selectionStart = Selection.getSelectionStart(l8);
                int selectionEnd = Selection.getSelectionEnd(l8);
                textView.setText(l8);
                if (l8 instanceof Spannable) {
                    EmojiInputFilter.b((Spannable) l8, selectionStart, selectionEnd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputFilter(@NonNull TextView textView) {
        this.f6402a = textView;
    }

    private EmojiCompat.InitCallback a() {
        if (this.f6403b == null) {
            this.f6403b = new InitCallbackImpl(this.f6402a);
        }
        return this.f6403b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Spannable spannable, int i8, int i9) {
        if (i8 >= 0 && i9 >= 0) {
            Selection.setSelection(spannable, i8, i9);
        } else if (i8 >= 0) {
            Selection.setSelection(spannable, i8);
        } else if (i9 >= 0) {
            Selection.setSelection(spannable, i9);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i8, int i9, Spanned spanned, int i10, int i11) {
        if (this.f6402a.isInEditMode()) {
            return charSequence;
        }
        int c8 = EmojiCompat.a().c();
        if (c8 != 0) {
            boolean z7 = true;
            if (c8 != 1) {
                if (c8 != 3) {
                    return charSequence;
                }
            } else {
                if (i11 == 0 && i10 == 0 && spanned.length() == 0 && charSequence == this.f6402a.getText()) {
                    z7 = false;
                }
                if (z7 && charSequence != null) {
                    if (i8 != 0 || i9 != charSequence.length()) {
                        charSequence = charSequence.subSequence(i8, i9);
                    }
                    return EmojiCompat.a().m(charSequence, 0, charSequence.length());
                }
                return charSequence;
            }
        }
        EmojiCompat.a().p(a());
        return charSequence;
    }
}
