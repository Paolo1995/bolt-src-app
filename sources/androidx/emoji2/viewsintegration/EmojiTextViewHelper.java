package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class EmojiTextViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f6539a;

    /* loaded from: classes.dex */
    static class HelperInternal {
        HelperInternal() {
        }

        @NonNull
        InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public boolean b() {
            return false;
        }

        void c(boolean z7) {
        }

        void d(boolean z7) {
        }

        TransformationMethod e(TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    /* loaded from: classes.dex */
    private static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f6540a;

        /* renamed from: b  reason: collision with root package name */
        private final EmojiInputFilter f6541b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6542c = true;

        HelperInternal19(TextView textView) {
            this.f6540a = textView;
            this.f6541b = new EmojiInputFilter(textView);
        }

        @NonNull
        private InputFilter[] f(@NonNull InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f6541b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f6541b;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> g(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i8 = 0; i8 < inputFilterArr.length; i8++) {
                InputFilter inputFilter = inputFilterArr[i8];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i8, inputFilter);
                }
            }
            return sparseArray;
        }

        @NonNull
        private InputFilter[] h(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> g8 = g(inputFilterArr);
            if (g8.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - g8.size()];
            int i8 = 0;
            for (int i9 = 0; i9 < length; i9++) {
                if (g8.indexOfKey(i9) < 0) {
                    inputFilterArr2[i8] = inputFilterArr[i9];
                    i8++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof EmojiTransformationMethod) {
                return ((EmojiTransformationMethod) transformationMethod).a();
            }
            return transformationMethod;
        }

        private void k() {
            this.f6540a.setFilters(a(this.f6540a.getFilters()));
        }

        @NonNull
        private TransformationMethod m(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof EmojiTransformationMethod) {
                return transformationMethod;
            }
            if (transformationMethod instanceof PasswordTransformationMethod) {
                return transformationMethod;
            }
            return new EmojiTransformationMethod(transformationMethod);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            if (!this.f6542c) {
                return h(inputFilterArr);
            }
            return f(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean b() {
            return this.f6542c;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void c(boolean z7) {
            if (z7) {
                l();
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void d(boolean z7) {
            this.f6542c = z7;
            l();
            k();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.f6542c) {
                return m(transformationMethod);
            }
            return j(transformationMethod);
        }

        void i(boolean z7) {
            this.f6542c = z7;
        }

        void l() {
            this.f6540a.setTransformationMethod(e(this.f6540a.getTransformationMethod()));
        }
    }

    /* loaded from: classes.dex */
    private static class SkippingHelper19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final HelperInternal19 f6543a;

        SkippingHelper19(TextView textView) {
            this.f6543a = new HelperInternal19(textView);
        }

        private boolean f() {
            return !EmojiCompat.h();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            if (f()) {
                return inputFilterArr;
            }
            return this.f6543a.a(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean b() {
            return this.f6543a.b();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void c(boolean z7) {
            if (f()) {
                return;
            }
            this.f6543a.c(z7);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void d(boolean z7) {
            if (f()) {
                this.f6543a.i(z7);
            } else {
                this.f6543a.d(z7);
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        TransformationMethod e(TransformationMethod transformationMethod) {
            if (f()) {
                return transformationMethod;
            }
            return this.f6543a.e(transformationMethod);
        }
    }

    public EmojiTextViewHelper(@NonNull TextView textView, boolean z7) {
        Preconditions.h(textView, "textView cannot be null");
        if (!z7) {
            this.f6539a = new SkippingHelper19(textView);
        } else {
            this.f6539a = new HelperInternal19(textView);
        }
    }

    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f6539a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f6539a.b();
    }

    public void c(boolean z7) {
        this.f6539a.c(z7);
    }

    public void d(boolean z7) {
        this.f6539a.d(z7);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f6539a.e(transformationMethod);
    }
}
