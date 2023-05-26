package j$.time;

/* loaded from: classes2.dex */
abstract /* synthetic */ class n {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f50081a;

    static {
        int[] iArr = new int[j$.time.temporal.a.values().length];
        f50081a = iArr;
        try {
            iArr[j$.time.temporal.a.INSTANT_SECONDS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f50081a[j$.time.temporal.a.OFFSET_SECONDS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
