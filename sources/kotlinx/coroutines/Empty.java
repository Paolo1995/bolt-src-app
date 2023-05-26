package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public final class Empty implements Incomplete {

    /* renamed from: f  reason: collision with root package name */
    private final boolean f51269f;

    public Empty(boolean z7) {
        this.f51269f = z7;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList d() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return this.f51269f;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        if (isActive()) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
