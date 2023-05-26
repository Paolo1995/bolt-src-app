package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

/* loaded from: classes.dex */
class AppCompatEmojiTextHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1860a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final EmojiTextViewHelper f1861b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatEmojiTextHelper(@NonNull TextView textView) {
        this.f1860a = textView;
        this.f1861b = new EmojiTextViewHelper(textView, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f1861b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1861b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i8) {
        TypedArray obtainStyledAttributes = this.f1860a.getContext().obtainStyledAttributes(attributeSet, R$styleable.f987g0, i8, 0);
        try {
            int i9 = R$styleable.f1057u0;
            boolean z7 = true;
            if (obtainStyledAttributes.hasValue(i9)) {
                z7 = obtainStyledAttributes.getBoolean(i9, true);
            }
            obtainStyledAttributes.recycle();
            e(z7);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z7) {
        this.f1861b.c(z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z7) {
        this.f1861b.d(z7);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f1861b.e(transformationMethod);
    }
}
