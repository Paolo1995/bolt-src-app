package kotlin.internal.jdk7;

import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JDK7PlatformImplementations.kt */
/* loaded from: classes5.dex */
public class JDK7PlatformImplementations extends PlatformImplementations {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JDK7PlatformImplementations.kt */
    /* loaded from: classes5.dex */
    public static final class ReflectSdkVersion {

        /* renamed from: a  reason: collision with root package name */
        public static final ReflectSdkVersion f50940a = new ReflectSdkVersion();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f50941b;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        static {
            /*
                kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion r0 = new kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion
                r0.<init>()
                kotlin.internal.jdk7.JDK7PlatformImplementations.ReflectSdkVersion.f50940a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L1f
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L1f
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L1f
                if (r2 == 0) goto L20
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L1f
                goto L21
            L1f:
            L20:
                r1 = r0
            L21:
                if (r1 == 0) goto L2f
                int r2 = r1.intValue()
                if (r2 <= 0) goto L2b
                r2 = 1
                goto L2c
            L2b:
                r2 = 0
            L2c:
                if (r2 == 0) goto L2f
                r0 = r1
            L2f:
                kotlin.internal.jdk7.JDK7PlatformImplementations.ReflectSdkVersion.f50941b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.jdk7.JDK7PlatformImplementations.ReflectSdkVersion.<clinit>():void");
        }

        private ReflectSdkVersion() {
        }
    }

    private final boolean c(int i8) {
        Integer num = ReflectSdkVersion.f50941b;
        if (num != null && num.intValue() < i8) {
            return false;
        }
        return true;
    }

    @Override // kotlin.internal.PlatformImplementations
    public void a(Throwable cause, Throwable exception) {
        Intrinsics.f(cause, "cause");
        Intrinsics.f(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
