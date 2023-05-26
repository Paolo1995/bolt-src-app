package androidx.emoji.widget;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class EmojiTextViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f6406a;

    /* loaded from: classes.dex */
    static class HelperInternal {
        HelperInternal() {
        }

        InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        void b(boolean z7) {
        }
    }

    /* loaded from: classes.dex */
    private static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f6407a;

        /* renamed from: b  reason: collision with root package name */
        private final EmojiInputFilter f6408b;

        HelperInternal19(TextView textView) {
            this.f6407a = textView;
            this.f6408b = new EmojiInputFilter(textView);
        }

        @Override // androidx.emoji.widget.EmojiTextViewHelper.HelperInternal
        InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter instanceof EmojiInputFilter) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f6408b;
            return inputFilterArr2;
        }

        @Override // androidx.emoji.widget.EmojiTextViewHelper.HelperInternal
        void b(boolean z7) {
            if (z7) {
                c();
            }
        }

        void c() {
            TransformationMethod transformationMethod = this.f6407a.getTransformationMethod();
            if (transformationMethod != null && !(transformationMethod instanceof PasswordTransformationMethod)) {
                this.f6407a.setTransformationMethod(d(transformationMethod));
            }
        }

        TransformationMethod d(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof EmojiTransformationMethod) {
                return transformationMethod;
            }
            return new EmojiTransformationMethod(transformationMethod);
        }
    }

    public EmojiTextViewHelper(@NonNull TextView textView) {
        Preconditions.h(textView, "textView cannot be null");
        this.f6406a = new HelperInternal19(textView);
    }

    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f6406a.a(inputFilterArr);
    }

    public void b(boolean z7) {
        this.f6406a.b(z7);
    }
}
