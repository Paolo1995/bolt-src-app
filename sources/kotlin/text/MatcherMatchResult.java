package kotlin.text;

import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Regex.kt */
/* loaded from: classes5.dex */
public final class MatcherMatchResult implements MatchResult {

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f51155a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f51156b;

    /* renamed from: c  reason: collision with root package name */
    private final MatchGroupCollection f51157c;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.f(matcher, "matcher");
        Intrinsics.f(input, "input");
        this.f51155a = matcher;
        this.f51156b = input;
        this.f51157c = new MatcherMatchResult$groups$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.regex.MatchResult c() {
        return this.f51155a;
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection a() {
        return this.f51157c;
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String group = c().group();
        Intrinsics.e(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int i8;
        MatchResult d8;
        int end = c().end();
        if (c().end() == c().start()) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        int i9 = end + i8;
        if (i9 <= this.f51156b.length()) {
            Matcher matcher = this.f51155a.pattern().matcher(this.f51156b);
            Intrinsics.e(matcher, "matcher.pattern().matcher(input)");
            d8 = RegexKt.d(matcher, i9, this.f51156b);
            return d8;
        }
        return null;
    }
}
