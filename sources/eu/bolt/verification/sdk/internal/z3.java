package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
public class z3 extends y3 {

    /* renamed from: j  reason: collision with root package name */
    private final String f45796j;

    /* renamed from: k  reason: collision with root package name */
    private final String f45797k;

    @Override // eu.bolt.verification.sdk.internal.y3
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof z3) && super.equals(obj)) {
            z3 z3Var = (z3) obj;
            String str = this.f45796j;
            if (str == null ? z3Var.f45796j == null : str.equals(z3Var.f45796j)) {
                String str2 = this.f45797k;
                String str3 = z3Var.f45797k;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }

    @Override // eu.bolt.verification.sdk.internal.y3
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f45796j;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f45797k;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
