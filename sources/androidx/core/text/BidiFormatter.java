package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* loaded from: classes.dex */
public final class BidiFormatter {

    /* renamed from: d  reason: collision with root package name */
    static final TextDirectionHeuristicCompat f5864d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f5865e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f5866f;

    /* renamed from: g  reason: collision with root package name */
    static final BidiFormatter f5867g;

    /* renamed from: h  reason: collision with root package name */
    static final BidiFormatter f5868h;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5869a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5870b;

    /* renamed from: c  reason: collision with root package name */
    private final TextDirectionHeuristicCompat f5871c;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f5872a;

        /* renamed from: b  reason: collision with root package name */
        private int f5873b;

        /* renamed from: c  reason: collision with root package name */
        private TextDirectionHeuristicCompat f5874c;

        public Builder() {
            c(BidiFormatter.e(Locale.getDefault()));
        }

        private static BidiFormatter b(boolean z7) {
            if (z7) {
                return BidiFormatter.f5868h;
            }
            return BidiFormatter.f5867g;
        }

        private void c(boolean z7) {
            this.f5872a = z7;
            this.f5874c = BidiFormatter.f5864d;
            this.f5873b = 2;
        }

        public BidiFormatter a() {
            if (this.f5873b == 2 && this.f5874c == BidiFormatter.f5864d) {
                return b(this.f5872a);
            }
            return new BidiFormatter(this.f5872a, this.f5873b, this.f5874c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DirectionalityEstimator {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f5875f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f5876a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f5877b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5878c;

        /* renamed from: d  reason: collision with root package name */
        private int f5879d;

        /* renamed from: e  reason: collision with root package name */
        private char f5880e;

        static {
            for (int i8 = 0; i8 < 1792; i8++) {
                f5875f[i8] = Character.getDirectionality(i8);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z7) {
            this.f5876a = charSequence;
            this.f5877b = z7;
            this.f5878c = charSequence.length();
        }

        private static byte c(char c8) {
            if (c8 < 1792) {
                return f5875f[c8];
            }
            return Character.getDirectionality(c8);
        }

        private byte f() {
            char charAt;
            int i8 = this.f5879d;
            do {
                int i9 = this.f5879d;
                if (i9 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f5876a;
                int i10 = i9 - 1;
                this.f5879d = i10;
                charAt = charSequence.charAt(i10);
                this.f5880e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f5879d = i8;
            this.f5880e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i8 = this.f5879d;
                if (i8 < this.f5878c) {
                    CharSequence charSequence = this.f5876a;
                    this.f5879d = i8 + 1;
                    charAt = charSequence.charAt(i8);
                    this.f5880e = charAt;
                } else {
                    return (byte) 12;
                }
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i8 = this.f5879d;
            while (true) {
                int i9 = this.f5879d;
                if (i9 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f5876a;
                int i10 = i9 - 1;
                this.f5879d = i10;
                char charAt2 = charSequence.charAt(i10);
                this.f5880e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i11 = this.f5879d;
                        if (i11 > 0) {
                            CharSequence charSequence2 = this.f5876a;
                            int i12 = i11 - 1;
                            this.f5879d = i12;
                            charAt = charSequence2.charAt(i12);
                            this.f5880e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f5879d = i8;
            this.f5880e = '>';
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i8 = this.f5879d;
            while (true) {
                int i9 = this.f5879d;
                if (i9 < this.f5878c) {
                    CharSequence charSequence = this.f5876a;
                    this.f5879d = i9 + 1;
                    char charAt2 = charSequence.charAt(i9);
                    this.f5880e = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i10 = this.f5879d;
                            if (i10 < this.f5878c) {
                                CharSequence charSequence2 = this.f5876a;
                                this.f5879d = i10 + 1;
                                charAt = charSequence2.charAt(i10);
                                this.f5880e = charAt;
                            }
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f5879d = i8;
                    this.f5880e = '<';
                    return (byte) 13;
                }
            }
        }

        byte a() {
            char charAt = this.f5876a.charAt(this.f5879d - 1);
            this.f5880e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f5876a, this.f5879d);
                this.f5879d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f5879d--;
            byte c8 = c(this.f5880e);
            if (this.f5877b) {
                char c9 = this.f5880e;
                if (c9 == '>') {
                    return h();
                }
                if (c9 == ';') {
                    return f();
                }
                return c8;
            }
            return c8;
        }

        byte b() {
            char charAt = this.f5876a.charAt(this.f5879d);
            this.f5880e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f5876a, this.f5879d);
                this.f5879d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f5879d++;
            byte c8 = c(this.f5880e);
            if (this.f5877b) {
                char c9 = this.f5880e;
                if (c9 == '<') {
                    return i();
                }
                if (c9 == '&') {
                    return g();
                }
                return c8;
            }
            return c8;
        }

        int d() {
            this.f5879d = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (this.f5879d < this.f5878c && i8 == 0) {
                byte b8 = b();
                if (b8 != 0) {
                    if (b8 != 1 && b8 != 2) {
                        if (b8 != 9) {
                            switch (b8) {
                                case 14:
                                case 15:
                                    i10++;
                                    i9 = -1;
                                    break;
                                case 16:
                                case 17:
                                    i10++;
                                    i9 = 1;
                                    break;
                                case 18:
                                    i10--;
                                    i9 = 0;
                                    break;
                            }
                        }
                    } else if (i10 == 0) {
                        return 1;
                    }
                } else if (i10 == 0) {
                    return -1;
                }
                i8 = i10;
            }
            if (i8 == 0) {
                return 0;
            }
            if (i9 != 0) {
                return i9;
            }
            while (this.f5879d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i8 == i10) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i8 == i10) {
                            return 1;
                        }
                        break;
                    case 18:
                        i10++;
                        continue;
                }
                i10--;
            }
            return 0;
        }

        int e() {
            this.f5879d = this.f5878c;
            int i8 = 0;
            int i9 = 0;
            while (this.f5879d > 0) {
                byte a8 = a();
                if (a8 != 0) {
                    if (a8 != 1 && a8 != 2) {
                        if (a8 != 9) {
                            switch (a8) {
                                case 14:
                                case 15:
                                    if (i9 == i8) {
                                        return -1;
                                    }
                                    i8--;
                                    break;
                                case 16:
                                case 17:
                                    if (i9 == i8) {
                                        return 1;
                                    }
                                    i8--;
                                    break;
                                case 18:
                                    i8++;
                                    break;
                                default:
                                    if (i9 != 0) {
                                        break;
                                    } else {
                                        i9 = i8;
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else if (i8 == 0) {
                        return 1;
                    } else {
                        if (i9 == 0) {
                            i9 = i8;
                        }
                    }
                } else if (i8 == 0) {
                    return -1;
                } else {
                    if (i9 == 0) {
                        i9 = i8;
                    }
                }
            }
            return 0;
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.f5897c;
        f5864d = textDirectionHeuristicCompat;
        f5865e = Character.toString((char) 8206);
        f5866f = Character.toString((char) 8207);
        f5867g = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        f5868h = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    BidiFormatter(boolean z7, int i8, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f5869a = z7;
        this.f5870b = i8;
        this.f5871c = textDirectionHeuristicCompat;
    }

    private static int a(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).e();
    }

    public static BidiFormatter c() {
        return new Builder().a();
    }

    static boolean e(Locale locale) {
        if (TextUtilsCompat.a(locale) == 1) {
            return true;
        }
        return false;
    }

    private String f(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.f5869a && (isRtl || b(charSequence) == 1)) {
            return f5865e;
        }
        if (this.f5869a) {
            if (!isRtl || b(charSequence) == -1) {
                return f5866f;
            }
            return "";
        }
        return "";
    }

    private String g(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.f5869a && (isRtl || a(charSequence) == 1)) {
            return f5865e;
        }
        if (this.f5869a) {
            if (!isRtl || a(charSequence) == -1) {
                return f5866f;
            }
            return "";
        }
        return "";
    }

    public boolean d() {
        if ((this.f5870b & 2) != 0) {
            return true;
        }
        return false;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f5871c, true);
    }

    public CharSequence i(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z7) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat2;
        char c8;
        TextDirectionHeuristicCompat textDirectionHeuristicCompat3;
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z7) {
            if (isRtl) {
                textDirectionHeuristicCompat3 = TextDirectionHeuristicsCompat.f5896b;
            } else {
                textDirectionHeuristicCompat3 = TextDirectionHeuristicsCompat.f5895a;
            }
            spannableStringBuilder.append((CharSequence) g(charSequence, textDirectionHeuristicCompat3));
        }
        if (isRtl != this.f5869a) {
            if (isRtl) {
                c8 = 8235;
            } else {
                c8 = 8234;
            }
            spannableStringBuilder.append(c8);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z7) {
            if (isRtl) {
                textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f5896b;
            } else {
                textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f5895a;
            }
            spannableStringBuilder.append((CharSequence) f(charSequence, textDirectionHeuristicCompat2));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f5871c, true);
    }

    public String k(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z7) {
        if (str == null) {
            return null;
        }
        return i(str, textDirectionHeuristicCompat, z7).toString();
    }
}
