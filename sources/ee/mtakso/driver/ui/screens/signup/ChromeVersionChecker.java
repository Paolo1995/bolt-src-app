package ee.mtakso.driver.ui.screens.signup;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: ChromeVersionChecker.kt */
/* loaded from: classes5.dex */
public final class ChromeVersionChecker {

    /* renamed from: a  reason: collision with root package name */
    public static final ChromeVersionChecker f33322a = new ChromeVersionChecker();

    /* renamed from: b  reason: collision with root package name */
    private static final Regex f33323b = new Regex("Chrome/(\\d+)");

    /* renamed from: c  reason: collision with root package name */
    private static final Regex f33324c = new Regex("(\\d+)");

    private ChromeVersionChecker() {
    }

    public final Integer a(String agent) {
        String str;
        Intrinsics.f(agent, "agent");
        MatchResult b8 = Regex.b(f33323b, agent, 0, 2, null);
        if (b8 == null) {
            return null;
        }
        MatchResult b9 = Regex.b(f33324c, b8.getValue(), 0, 2, null);
        if (b9 != null) {
            str = b9.getValue();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }
}
