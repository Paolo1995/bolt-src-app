package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public final class InactiveNodeList implements Incomplete {

    /* renamed from: f  reason: collision with root package name */
    private final NodeList f51287f;

    public InactiveNodeList(NodeList nodeList) {
        this.f51287f = nodeList;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList d() {
        return this.f51287f;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return false;
    }

    public String toString() {
        return super.toString();
    }
}
