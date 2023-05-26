package j$.time.chrono;

/* loaded from: classes2.dex */
abstract /* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f49976a;

    static {
        int[] iArr = new int[j$.time.temporal.a.values().length];
        f49976a = iArr;
        try {
            iArr[j$.time.temporal.a.INSTANT_SECONDS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f49976a[j$.time.temporal.a.OFFSET_SECONDS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
