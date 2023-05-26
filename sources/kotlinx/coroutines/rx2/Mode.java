package kotlinx.coroutines.rx2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxAwait.kt */
/* loaded from: classes5.dex */
public enum Mode {
    FIRST("awaitFirst"),
    FIRST_OR_DEFAULT("awaitFirstOrDefault"),
    LAST("awaitLast"),
    SINGLE("awaitSingle");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f51889f;

    Mode(String str) {
        this.f51889f = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f51889f;
    }
}
