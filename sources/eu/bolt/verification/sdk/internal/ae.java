package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
public enum ae {
    SETTLING(0),
    DRAGGING(1),
    HIDDEN(2),
    PEEK(3),
    EXPANDED(4);
    

    /* renamed from: f  reason: collision with root package name */
    private int f42076f;

    ae(int i8) {
        this.f42076f = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ae c(int i8) {
        ae[] values;
        for (ae aeVar : values()) {
            if (aeVar.f42076f == i8) {
                return aeVar;
            }
        }
        throw new IllegalArgumentException("Unknown attr id " + i8);
    }

    public int a() {
        return this.f42076f;
    }
}
