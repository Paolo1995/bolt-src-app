package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class EmojiInputFilter implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f6533a;

    /* renamed from: b  reason: collision with root package name */
    private EmojiCompat.InitCallback f6534b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<TextView> f6535a;

        /* renamed from: b  reason: collision with root package name */
        private final Reference<EmojiInputFilter> f6536b;

        InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.f6535a = new WeakReference(textView);
            this.f6536b = new WeakReference(emojiInputFilter);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void b() {
            CharSequence text;
            CharSequence o8;
            super.b();
            TextView textView = this.f6535a.get();
            if (!c(textView, this.f6536b.get()) || !textView.isAttachedToWindow() || text == (o8 = EmojiCompat.b().o((text = textView.getText())))) {
                return;
            }
            int selectionStart = Selection.getSelectionStart(o8);
            int selectionEnd = Selection.getSelectionEnd(o8);
            textView.setText(o8);
            if (o8 instanceof Spannable) {
                EmojiInputFilter.b((Spannable) o8, selectionStart, selectionEnd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputFilter(@NonNull TextView textView) {
        this.f6533a = textView;
    }

    private EmojiCompat.InitCallback a() {
        if (this.f6534b == null) {
            this.f6534b = new InitCallbackImpl(this.f6533a, this);
        }
        return this.f6534b;
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
        if (this.f6533a.isInEditMode()) {
            return charSequence;
        }
        int d8 = EmojiCompat.b().d();
        if (d8 != 0) {
            boolean z7 = true;
            if (d8 != 1) {
                if (d8 != 3) {
                    return charSequence;
                }
            } else {
                if (i11 == 0 && i10 == 0 && spanned.length() == 0 && charSequence == this.f6533a.getText()) {
                    z7 = false;
                }
                if (z7 && charSequence != null) {
                    if (i8 != 0 || i9 != charSequence.length()) {
                        charSequence = charSequence.subSequence(i8, i9);
                    }
                    return EmojiCompat.b().p(charSequence, 0, charSequence.length());
                }
                return charSequence;
            }
        }
        EmojiCompat.b().s(a());
        return charSequence;
    }
}
