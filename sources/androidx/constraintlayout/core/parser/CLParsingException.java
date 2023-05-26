package androidx.constraintlayout.core.parser;

/* loaded from: classes.dex */
public class CLParsingException extends Exception {

    /* renamed from: f  reason: collision with root package name */
    private final String f4487f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4488g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4489h;

    public String a() {
        return this.f4487f + " (" + this.f4489h + " at line " + this.f4488g + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + a();
    }
}
