package ee.mtakso.driver.platform.core;

/* compiled from: PlatformManager.kt */
/* loaded from: classes3.dex */
public interface PlatformManager {

    /* compiled from: PlatformManager.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(PlatformManager platformManager, String str, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    str = null;
                }
                platformManager.a(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openApplicationStore");
        }
    }

    void a(String str);

    PlatformType getType();
}
