package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;

/* compiled from: Regex.kt */
/* loaded from: classes5.dex */
public final class Regex implements Serializable {

    /* renamed from: g */
    public static final Companion f51160g = new Companion(null);

    /* renamed from: f */
    private final Pattern f51161f;

    /* compiled from: Regex.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Regex(Pattern nativePattern) {
        Intrinsics.f(nativePattern, "nativePattern");
        this.f51161f = nativePattern;
    }

    public static /* synthetic */ MatchResult b(Regex regex, CharSequence charSequence, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        return regex.a(charSequence, i8);
    }

    public static /* synthetic */ Sequence d(Regex regex, CharSequence charSequence, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        return regex.c(charSequence, i8);
    }

    public final MatchResult a(CharSequence input, int i8) {
        MatchResult d8;
        Intrinsics.f(input, "input");
        Matcher matcher = this.f51161f.matcher(input);
        Intrinsics.e(matcher, "nativePattern.matcher(input)");
        d8 = RegexKt.d(matcher, i8, input);
        return d8;
    }

    public final Sequence<MatchResult> c(final CharSequence input, final int i8) {
        Sequence<MatchResult> i9;
        Intrinsics.f(input, "input");
        if (i8 >= 0 && i8 <= input.length()) {
            i9 = SequencesKt__SequencesKt.i(new Function0<MatchResult>() { // from class: kotlin.text.Regex$findAll$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final MatchResult invoke() {
                    return Regex.this.a(input, i8);
                }
            }, Regex$findAll$2.f51165o);
            return i9;
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i8 + ", input length: " + input.length());
    }

    public final MatchResult e(CharSequence input) {
        MatchResult e8;
        Intrinsics.f(input, "input");
        Matcher matcher = this.f51161f.matcher(input);
        Intrinsics.e(matcher, "nativePattern.matcher(input)");
        e8 = RegexKt.e(matcher, input);
        return e8;
    }

    public final boolean f(CharSequence input) {
        Intrinsics.f(input, "input");
        return this.f51161f.matcher(input).matches();
    }

    public final String g(CharSequence input, String replacement) {
        Intrinsics.f(input, "input");
        Intrinsics.f(replacement, "replacement");
        String replaceAll = this.f51161f.matcher(input).replaceAll(replacement);
        Intrinsics.e(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final List<String> h(CharSequence input, int i8) {
        List<String> e8;
        Intrinsics.f(input, "input");
        StringsKt__StringsKt.x0(i8);
        Matcher matcher = this.f51161f.matcher(input);
        if (i8 != 1 && matcher.find()) {
            int i9 = 10;
            if (i8 > 0) {
                i9 = RangesKt___RangesKt.g(i8, 10);
            }
            ArrayList arrayList = new ArrayList(i9);
            int i10 = 0;
            int i11 = i8 - 1;
            do {
                arrayList.add(input.subSequence(i10, matcher.start()).toString());
                i10 = matcher.end();
                if (i11 >= 0 && arrayList.size() == i11) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(input.subSequence(i10, input.length()).toString());
            return arrayList;
        }
        e8 = CollectionsKt__CollectionsJVMKt.e(input.toString());
        return e8;
    }

    public String toString() {
        String pattern = this.f51161f.toString();
        Intrinsics.e(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            kotlin.jvm.internal.Intrinsics.e(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }
}
