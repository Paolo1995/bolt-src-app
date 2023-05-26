package kotlinx.serialization.json.internal;

/* compiled from: WriteMode.kt */
/* loaded from: classes5.dex */
public enum WriteMode {
    OBJ('{', '}'),
    LIST('[', ']'),
    MAP('{', '}'),
    POLY_OBJ('[', ']');
    

    /* renamed from: f  reason: collision with root package name */
    public final char f52451f;

    /* renamed from: g  reason: collision with root package name */
    public final char f52452g;

    WriteMode(char c8, char c9) {
        this.f52451f = c8;
        this.f52452g = c9;
    }
}
