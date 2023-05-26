package eu.bolt.android.engine.html.util;

import eu.bolt.android.engine.html.util.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringBuilderJVMKt;

/* compiled from: Decoder.kt */
/* loaded from: classes5.dex */
public final class Decoder {

    /* renamed from: a  reason: collision with root package name */
    private final String f36920a;

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f36921b;

    /* renamed from: c  reason: collision with root package name */
    private int f36922c;

    public Decoder(String input) {
        Intrinsics.f(input, "input");
        this.f36920a = input;
        this.f36921b = new StringBuilder();
    }

    private final Token.HoursMarker a(char c8) {
        if (this.f36922c + 1 < this.f36920a.length() && this.f36920a.charAt(this.f36922c) == c8 && this.f36920a.charAt(this.f36922c + 1) == c8) {
            return new Token.HoursMarker(e(c8, 2));
        }
        return null;
    }

    private final String c(StringBuilder sb) {
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "toString()");
        StringsKt__StringBuilderJVMKt.i(sb);
        return sb2;
    }

    private final Token d() {
        Set<Character> f8;
        f8 = SetsKt__SetsKt.f('s', 'm', 'H', 'h', 'd', '\'', 'a');
        return new Token.Text(g(f8));
    }

    private final String e(char c8, int i8) {
        int i9 = 0;
        while (this.f36922c < this.f36920a.length() && this.f36920a.charAt(this.f36922c) == c8) {
            StringBuilder sb = this.f36921b;
            String str = this.f36920a;
            int i10 = this.f36922c;
            this.f36922c = i10 + 1;
            sb.append(str.charAt(i10));
            if (i8 >= 0 && i9 == i8) {
                break;
            }
            i9++;
        }
        return c(this.f36921b);
    }

    static /* synthetic */ String f(Decoder decoder, char c8, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = -1;
        }
        return decoder.e(c8, i8);
    }

    private final String g(Set<Character> set) {
        while (this.f36922c < this.f36920a.length() && !set.contains(Character.valueOf(this.f36920a.charAt(this.f36922c)))) {
            StringBuilder sb = this.f36921b;
            String str = this.f36920a;
            int i8 = this.f36922c;
            this.f36922c = i8 + 1;
            sb.append(str.charAt(i8));
        }
        return c(this.f36921b);
    }

    private final Token h() {
        Set<Character> a8;
        if (this.f36920a.charAt(this.f36922c) != '\'') {
            return null;
        }
        this.f36922c++;
        a8 = SetsKt__SetsJVMKt.a('\'');
        String g8 = g(a8);
        this.f36922c++;
        return new Token.Text(g8);
    }

    private final Token i() {
        Token days;
        char charAt = this.f36920a.charAt(this.f36922c);
        if (charAt == 's') {
            days = new Token.Seconds(f(this, charAt, 0, 2, null));
        } else if (charAt == 'm') {
            days = new Token.Minutes(f(this, charAt, 0, 2, null));
        } else if (charAt == 'H') {
            days = new Token.Hours(true, f(this, charAt, 0, 2, null));
        } else if (charAt == 'h') {
            days = new Token.Hours(false, f(this, charAt, 0, 2, null));
        } else if (charAt == 'd') {
            days = new Token.Days(f(this, charAt, 0, 2, null));
        } else if (charAt != 'a') {
            return null;
        } else {
            return a(charAt);
        }
        return days;
    }

    public final List<Token> b() {
        ArrayList arrayList = new ArrayList();
        while (this.f36922c < this.f36920a.length()) {
            Token i8 = i();
            if (i8 != null) {
                arrayList.add(i8);
            } else {
                Token h8 = h();
                if (h8 != null) {
                    arrayList.add(h8);
                } else {
                    arrayList.add(d());
                }
            }
        }
        return arrayList;
    }
}
