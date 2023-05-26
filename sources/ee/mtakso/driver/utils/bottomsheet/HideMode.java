package ee.mtakso.driver.utils.bottomsheet;

/* loaded from: classes5.dex */
public enum HideMode {
    NON_HIDEABLE(0),
    HIDEABLE_ONLY_VIA_API(1),
    HIDEABLE(2);
    

    /* renamed from: f  reason: collision with root package name */
    private int f36386f;

    HideMode(int i8) {
        this.f36386f = i8;
    }

    public static HideMode c(int i8) {
        HideMode[] values;
        for (HideMode hideMode : values()) {
            if (hideMode.f36386f == i8) {
                return hideMode;
            }
        }
        throw new IllegalArgumentException("Unknown attr id " + i8);
    }

    public int a() {
        return this.f36386f;
    }

    public boolean e() {
        if (this != HIDEABLE && this != HIDEABLE_ONLY_VIA_API) {
            return false;
        }
        return true;
    }

    public boolean f() {
        if (this == HIDEABLE) {
            return true;
        }
        return false;
    }
}
