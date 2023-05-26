package j$.time.format;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e implements g {

    /* renamed from: a  reason: collision with root package name */
    private final char f49999a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(char c8) {
        this.f49999a = c8;
    }

    @Override // j$.time.format.g
    public final boolean d(u uVar, StringBuilder sb) {
        sb.append(this.f49999a);
        return true;
    }

    @Override // j$.time.format.g
    public final int e(s sVar, CharSequence charSequence, int i8) {
        if (i8 == charSequence.length()) {
            return ~i8;
        }
        char charAt = charSequence.charAt(i8);
        return (charAt == this.f49999a || (!sVar.j() && (Character.toUpperCase(charAt) == Character.toUpperCase(this.f49999a) || Character.toLowerCase(charAt) == Character.toLowerCase(this.f49999a)))) ? i8 + 1 : ~i8;
    }

    public final String toString() {
        if (this.f49999a == '\'') {
            return "''";
        }
        StringBuilder a8 = j$.time.b.a("'");
        a8.append(this.f49999a);
        a8.append("'");
        return a8.toString();
    }
}
