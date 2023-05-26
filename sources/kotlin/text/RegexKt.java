package kotlin.text;

import java.util.regex.Matcher;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Regex.kt */
/* loaded from: classes5.dex */
public final class RegexKt {
    public static final /* synthetic */ MatchResult a(Matcher matcher, int i8, CharSequence charSequence) {
        return d(matcher, i8, charSequence);
    }

    public static final /* synthetic */ MatchResult b(Matcher matcher, CharSequence charSequence) {
        return e(matcher, charSequence);
    }

    public static final MatchResult d(Matcher matcher, int i8, CharSequence charSequence) {
        if (!matcher.find(i8)) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final MatchResult e(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final IntRange f(java.util.regex.MatchResult matchResult, int i8) {
        IntRange o8;
        o8 = RangesKt___RangesKt.o(matchResult.start(i8), matchResult.end(i8));
        return o8;
    }
}
