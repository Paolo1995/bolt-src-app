package kotlinx.coroutines.internal;

/* compiled from: SystemProps.kt */
/* loaded from: classes5.dex */
final /* synthetic */ class SystemPropsKt__SystemPropsKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f51836a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f51836a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
