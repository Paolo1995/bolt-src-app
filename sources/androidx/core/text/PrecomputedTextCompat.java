package androidx.core.text;

import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;

/* loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {

    /* renamed from: i  reason: collision with root package name */
    private static final Object f5882i = new Object();
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Spannable f5883f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final Params f5884g;

    /* renamed from: h  reason: collision with root package name */
    private final PrecomputedText f5885h;

    @NonNull
    public Params a() {
        return this.f5884g;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f5883f;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i8) {
        return this.f5883f.charAt(i8);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f5883f.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f5883f.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f5883f.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i8, int i9, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return (T[]) this.f5885h.getSpans(i8, i9, cls);
        }
        return (T[]) this.f5883f.getSpans(i8, i9, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f5883f.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i8, int i9, Class cls) {
        return this.f5883f.nextSpanTransition(i8, i9, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f5885h.removeSpan(obj);
                return;
            } else {
                this.f5883f.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i8, int i9, int i10) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f5885h.setSpan(obj, i8, i9, i10);
                return;
            } else {
                this.f5883f.setSpan(obj, i8, i9, i10);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i8, int i9) {
        return this.f5883f.subSequence(i8, i9);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.f5883f.toString();
    }

    /* loaded from: classes.dex */
    public static final class Params {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f5886a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f5887b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5888c;

        /* renamed from: d  reason: collision with root package name */
        private final int f5889d;

        /* renamed from: e  reason: collision with root package name */
        final PrecomputedText.Params f5890e;

        /* loaded from: classes.dex */
        public static class Builder {
            @NonNull

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f5891a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f5892b;

            /* renamed from: c  reason: collision with root package name */
            private int f5893c;

            /* renamed from: d  reason: collision with root package name */
            private int f5894d;

            public Builder(@NonNull TextPaint textPaint) {
                this.f5891a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f5893c = 1;
                    this.f5894d = 1;
                } else {
                    this.f5894d = 0;
                    this.f5893c = 0;
                }
                this.f5892b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @NonNull
            public Params a() {
                return new Params(this.f5891a, this.f5892b, this.f5893c, this.f5894d);
            }

            public Builder b(int i8) {
                this.f5893c = i8;
                return this;
            }

            public Builder c(int i8) {
                this.f5894d = i8;
                return this;
            }

            public Builder d(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.f5892b = textDirectionHeuristic;
                return this;
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.text.PrecomputedText$Params$Builder] */
        Params(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i8, int i9) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f5890e = new Object(textPaint) { // from class: android.text.PrecomputedText.Params.Builder
                    static {
                        throw new NoClassDefFoundError();
                    }

                    @android.annotation.NonNull
                    public native /* synthetic */ Params build();

                    public native /* synthetic */ Builder setBreakStrategy(int i10);

                    public native /* synthetic */ Builder setHyphenationFrequency(int i10);

                    public native /* synthetic */ Builder setTextDirection(@android.annotation.NonNull TextDirectionHeuristic textDirectionHeuristic2);
                }.setBreakStrategy(i8).setHyphenationFrequency(i9).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f5890e = null;
            }
            this.f5886a = textPaint;
            this.f5887b = textDirectionHeuristic;
            this.f5888c = i8;
            this.f5889d = i9;
        }

        public boolean a(@NonNull Params params) {
            LocaleList textLocales;
            LocaleList textLocales2;
            int i8 = Build.VERSION.SDK_INT;
            if ((i8 >= 23 && (this.f5888c != params.b() || this.f5889d != params.c())) || this.f5886a.getTextSize() != params.e().getTextSize() || this.f5886a.getTextScaleX() != params.e().getTextScaleX() || this.f5886a.getTextSkewX() != params.e().getTextSkewX() || this.f5886a.getLetterSpacing() != params.e().getLetterSpacing() || !TextUtils.equals(this.f5886a.getFontFeatureSettings(), params.e().getFontFeatureSettings()) || this.f5886a.getFlags() != params.e().getFlags()) {
                return false;
            }
            if (i8 >= 24) {
                textLocales = this.f5886a.getTextLocales();
                textLocales2 = params.e().getTextLocales();
                if (!textLocales.equals(textLocales2)) {
                    return false;
                }
            } else if (!this.f5886a.getTextLocale().equals(params.e().getTextLocale())) {
                return false;
            }
            if (this.f5886a.getTypeface() == null) {
                if (params.e().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f5886a.getTypeface().equals(params.e().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public int b() {
            return this.f5888c;
        }

        public int c() {
            return this.f5889d;
        }

        public TextDirectionHeuristic d() {
            return this.f5887b;
        }

        @NonNull
        public TextPaint e() {
            return this.f5886a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (a(params) && this.f5887b == params.d()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            LocaleList textLocales;
            if (Build.VERSION.SDK_INT >= 24) {
                textLocales = this.f5886a.getTextLocales();
                return ObjectsCompat.b(Float.valueOf(this.f5886a.getTextSize()), Float.valueOf(this.f5886a.getTextScaleX()), Float.valueOf(this.f5886a.getTextSkewX()), Float.valueOf(this.f5886a.getLetterSpacing()), Integer.valueOf(this.f5886a.getFlags()), textLocales, this.f5886a.getTypeface(), Boolean.valueOf(this.f5886a.isElegantTextHeight()), this.f5887b, Integer.valueOf(this.f5888c), Integer.valueOf(this.f5889d));
            }
            return ObjectsCompat.b(Float.valueOf(this.f5886a.getTextSize()), Float.valueOf(this.f5886a.getTextScaleX()), Float.valueOf(this.f5886a.getTextSkewX()), Float.valueOf(this.f5886a.getLetterSpacing()), Integer.valueOf(this.f5886a.getFlags()), this.f5886a.getTextLocale(), this.f5886a.getTypeface(), Boolean.valueOf(this.f5886a.isElegantTextHeight()), this.f5887b, Integer.valueOf(this.f5888c), Integer.valueOf(this.f5889d));
        }

        public String toString() {
            String fontVariationSettings;
            LocaleList textLocales;
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f5886a.getTextSize());
            sb.append(", textScaleX=" + this.f5886a.getTextScaleX());
            sb.append(", textSkewX=" + this.f5886a.getTextSkewX());
            int i8 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.f5886a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f5886a.isElegantTextHeight());
            if (i8 >= 24) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(", textLocale=");
                textLocales = this.f5886a.getTextLocales();
                sb2.append(textLocales);
                sb.append(sb2.toString());
            } else {
                sb.append(", textLocale=" + this.f5886a.getTextLocale());
            }
            sb.append(", typeface=" + this.f5886a.getTypeface());
            if (i8 >= 26) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(", variationSettings=");
                fontVariationSettings = this.f5886a.getFontVariationSettings();
                sb3.append(fontVariationSettings);
                sb.append(sb3.toString());
            }
            sb.append(", textDir=" + this.f5887b);
            sb.append(", breakStrategy=" + this.f5888c);
            sb.append(", hyphenationFrequency=" + this.f5889d);
            sb.append("}");
            return sb.toString();
        }

        public Params(@NonNull PrecomputedText.Params params) {
            this.f5886a = params.getTextPaint();
            this.f5887b = params.getTextDirection();
            this.f5888c = params.getBreakStrategy();
            this.f5889d = params.getHyphenationFrequency();
            this.f5890e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
