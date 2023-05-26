package eu.bolt.verification.sdk.internal;

import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class ma {

    /* renamed from: a  reason: collision with root package name */
    public static final ma f44164a = new ma();

    /* renamed from: b  reason: collision with root package name */
    private static final Function1<Character, Boolean> f44165b = b.f44169f;

    /* renamed from: c  reason: collision with root package name */
    private static final Function1<Character, Boolean> f44166c = d.f44171f;

    /* renamed from: d  reason: collision with root package name */
    private static final Function1<Character, Character> f44167d = c.f44170f;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44168a;

        static {
            int[] iArr = new int[la.values().length];
            try {
                iArr[la.DELETE_WHITESPACES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[la.LOWERCASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f44168a = iArr;
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<Character, Boolean> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f44169f = new b();

        b() {
            super(1);
        }

        public final Boolean b(char c8) {
            return Boolean.valueOf(Character.isWhitespace(c8));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return b(ch.charValue());
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function1<Character, Character> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f44170f = new c();

        c() {
            super(1);
        }

        public final Character b(char c8) {
            return Character.valueOf(Character.toLowerCase(c8));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Character invoke(Character ch) {
            return b(ch.charValue());
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<Character, Boolean> {

        /* renamed from: f  reason: collision with root package name */
        public static final d f44171f = new d();

        d() {
            super(1);
        }

        public final Boolean b(char c8) {
            return Boolean.valueOf(Character.isUpperCase(c8));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return b(ch.charValue());
        }
    }

    private ma() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ InputFilter c(ma maVar, Function1 function1, Function1 function12, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            function12 = null;
        }
        return maVar.d(function1, function12);
    }

    private final InputFilter d(final Function1<? super Character, Boolean> function1, final Function1<? super Character, Character> function12) {
        return new InputFilter() { // from class: eu.bolt.verification.sdk.internal.tu
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i8, int i9, Spanned spanned, int i10, int i11) {
                CharSequence e8;
                e8 = ma.e(Function1.this, function12, charSequence, i8, i9, spanned, i10, i11);
                return e8;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(Function1 predicate, Function1 function1, CharSequence charSequence, int i8, int i9, Spanned spanned, int i10, int i11) {
        Intrinsics.f(predicate, "$predicate");
        StringBuilder sb = new StringBuilder(i9 - i8);
        boolean z7 = true;
        for (int i12 = i8; i12 < i9; i12++) {
            char charAt = charSequence.charAt(i12);
            if (((Boolean) predicate.invoke(Character.valueOf(charAt))).booleanValue()) {
                z7 = false;
                if (function1 != null) {
                    charAt = ((Character) function1.invoke(Character.valueOf(charAt))).charValue();
                }
            }
            sb.append(charAt);
        }
        if (z7) {
            return null;
        }
        if (charSequence instanceof Spanned) {
            SpannableString spannableString = new SpannableString(sb);
            TextUtils.copySpansFrom((Spanned) charSequence, i8, sb.length(), null, spannableString, 0);
            return spannableString;
        }
        return sb;
    }

    public final InputFilter b(la filterType) {
        Intrinsics.f(filterType, "filterType");
        int i8 = a.f44168a[filterType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return d(f44166c, f44167d);
            }
            throw new NoWhenBranchMatchedException();
        }
        return c(this, f44165b, null, 2, null);
    }
}
