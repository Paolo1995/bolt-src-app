package androidx.core.text;

import java.util.Locale;

/* loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f5895a = new TextDirectionHeuristicInternal(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f5896b = new TextDirectionHeuristicInternal(null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f5897c;

    /* renamed from: d  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f5898d;

    /* renamed from: e  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f5899e;

    /* renamed from: f  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f5900f;

    /* loaded from: classes.dex */
    private static class AnyStrong implements TextDirectionAlgorithm {

        /* renamed from: b  reason: collision with root package name */
        static final AnyStrong f5901b = new AnyStrong(true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f5902a;

        private AnyStrong(boolean z7) {
            this.f5902a = z7;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int a(CharSequence charSequence, int i8, int i9) {
            int i10 = i9 + i8;
            boolean z7 = false;
            while (i8 < i10) {
                int a8 = TextDirectionHeuristicsCompat.a(Character.getDirectionality(charSequence.charAt(i8)));
                if (a8 != 0) {
                    if (a8 == 1) {
                        if (!this.f5902a) {
                            return 1;
                        }
                    } else {
                        continue;
                        i8++;
                    }
                } else if (this.f5902a) {
                    return 0;
                }
                z7 = true;
                i8++;
            }
            if (z7) {
                return this.f5902a ? 1 : 0;
            }
            return 2;
        }
    }

    /* loaded from: classes.dex */
    private static class FirstStrong implements TextDirectionAlgorithm {

        /* renamed from: a  reason: collision with root package name */
        static final FirstStrong f5903a = new FirstStrong();

        private FirstStrong() {
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int a(CharSequence charSequence, int i8, int i9) {
            int i10 = i9 + i8;
            int i11 = 2;
            while (i8 < i10 && i11 == 2) {
                i11 = TextDirectionHeuristicsCompat.b(Character.getDirectionality(charSequence.charAt(i8)));
                i8++;
            }
            return i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface TextDirectionAlgorithm {
        int a(CharSequence charSequence, int i8, int i9);
    }

    /* loaded from: classes.dex */
    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {

        /* renamed from: a  reason: collision with root package name */
        private final TextDirectionAlgorithm f5904a;

        TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f5904a = textDirectionAlgorithm;
        }

        private boolean b(CharSequence charSequence, int i8, int i9) {
            int a8 = this.f5904a.a(charSequence, i8, i9);
            if (a8 == 0) {
                return true;
            }
            if (a8 != 1) {
                return a();
            }
            return false;
        }

        protected abstract boolean a();

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence charSequence, int i8, int i9) {
            if (charSequence != null && i8 >= 0 && i9 >= 0 && charSequence.length() - i9 >= i8) {
                if (this.f5904a == null) {
                    return a();
                }
                return b(charSequence, i8, i9);
            }
            throw new IllegalArgumentException();
        }
    }

    /* loaded from: classes.dex */
    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f5905b;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z7) {
            super(textDirectionAlgorithm);
            this.f5905b = z7;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean a() {
            return this.f5905b;
        }
    }

    /* loaded from: classes.dex */
    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {

        /* renamed from: b  reason: collision with root package name */
        static final TextDirectionHeuristicLocale f5906b = new TextDirectionHeuristicLocale();

        TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean a() {
            if (TextUtilsCompat.a(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.f5903a;
        f5897c = new TextDirectionHeuristicInternal(firstStrong, false);
        f5898d = new TextDirectionHeuristicInternal(firstStrong, true);
        f5899e = new TextDirectionHeuristicInternal(AnyStrong.f5901b, false);
        f5900f = TextDirectionHeuristicLocale.f5906b;
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int a(int i8) {
        if (i8 != 0) {
            return (i8 == 1 || i8 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i8) {
        if (i8 != 0) {
            if (i8 == 1 || i8 == 2) {
                return 0;
            }
            switch (i8) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
