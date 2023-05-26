package ee.mtakso.driver.features;

/* compiled from: FeatureStore.kt */
/* loaded from: classes3.dex */
public interface FeatureStore {

    /* compiled from: FeatureStore.kt */
    /* loaded from: classes3.dex */
    public enum Result {
        ENABLED,
        DISABLED,
        NOT_SET
    }

    void a(String str, Result result);

    Result b(String str);
}
