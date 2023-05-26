package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.annotation.NonNull;
import androidx.core.text.PrecomputedTextCompat;
import j$.util.stream.IntStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class UnprecomputeTextOnModificationSpannable implements Spannable {

    /* renamed from: f  reason: collision with root package name */
    private boolean f6509f = false;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private Spannable f6510g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream a(CharSequence charSequence) {
            IntStream convert;
            convert = IntStream.VivifiedWrapper.convert(charSequence.chars());
            return convert;
        }

        static IntStream b(CharSequence charSequence) {
            IntStream convert;
            convert = IntStream.VivifiedWrapper.convert(charSequence.codePoints());
            return convert;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        boolean a(CharSequence charSequence) {
            if (!(charSequence instanceof PrecomputedText) && !(charSequence instanceof PrecomputedTextCompat)) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnprecomputeTextOnModificationSpannable(@NonNull Spannable spannable) {
        this.f6510g = spannable;
    }

    private void a() {
        Spannable spannable = this.f6510g;
        if (!this.f6509f && c().a(spannable)) {
            this.f6510g = new SpannableString(spannable);
        }
        this.f6509f = true;
    }

    static PrecomputedTextDetector c() {
        if (Build.VERSION.SDK_INT < 28) {
            return new PrecomputedTextDetector();
        }
        return new PrecomputedTextDetector_28();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spannable b() {
        return this.f6510g;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i8) {
        return this.f6510g.charAt(i8);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public IntStream chars() {
        return CharSequenceHelper_API24.a(this.f6510g);
    }

    @Override // java.lang.CharSequence
    public /* synthetic */ java.util.stream.IntStream chars() {
        return IntStream.Wrapper.convert(chars());
    }

    @Override // java.lang.CharSequence
    @NonNull
    public IntStream codePoints() {
        return CharSequenceHelper_API24.b(this.f6510g);
    }

    @Override // java.lang.CharSequence
    public /* synthetic */ java.util.stream.IntStream codePoints() {
        return IntStream.Wrapper.convert(codePoints());
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f6510g.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f6510g.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f6510g.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i8, int i9, Class<T> cls) {
        return (T[]) this.f6510g.getSpans(i8, i9, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f6510g.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i8, int i9, Class cls) {
        return this.f6510g.nextSpanTransition(i8, i9, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f6510g.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i8, int i9, int i10) {
        a();
        this.f6510g.setSpan(obj, i8, i9, i10);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public CharSequence subSequence(int i8, int i9) {
        return this.f6510g.subSequence(i8, i9);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.f6510g.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnprecomputeTextOnModificationSpannable(@NonNull CharSequence charSequence) {
        this.f6510g = new SpannableString(charSequence);
    }
}
