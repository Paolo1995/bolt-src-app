package androidx.emoji2.text.flatbuffer;

/* loaded from: classes.dex */
public abstract class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    private static Utf8 f6522a;

    public static Utf8 a() {
        if (f6522a == null) {
            f6522a = new Utf8Safe();
        }
        return f6522a;
    }
}
