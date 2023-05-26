package io.ktor.http.parsing;

/* compiled from: ParseException.kt */
/* loaded from: classes5.dex */
public final class ParseException extends IllegalArgumentException {

    /* renamed from: f  reason: collision with root package name */
    private final String f46948f;

    /* renamed from: g  reason: collision with root package name */
    private final Throwable f46949g;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f46949g;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f46948f;
    }
}
