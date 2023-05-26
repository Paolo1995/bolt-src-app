package ee.mtakso.driver.service.modules.map;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TileIndex.kt */
/* loaded from: classes3.dex */
public final class TileIndex {

    /* renamed from: a  reason: collision with root package name */
    private final String f24863a;

    /* renamed from: b  reason: collision with root package name */
    private final TilePosition f24864b;

    public TileIndex(String tileCollectionId, TilePosition position) {
        Intrinsics.f(tileCollectionId, "tileCollectionId");
        Intrinsics.f(position, "position");
        this.f24863a = tileCollectionId;
        this.f24864b = position;
    }

    public final TilePosition a() {
        return this.f24864b;
    }

    public final String b() {
        return this.f24863a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TileIndex) {
            TileIndex tileIndex = (TileIndex) obj;
            return Intrinsics.a(this.f24863a, tileIndex.f24863a) && Intrinsics.a(this.f24864b, tileIndex.f24864b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f24863a.hashCode() * 31) + this.f24864b.hashCode();
    }

    public String toString() {
        String str = this.f24863a;
        TilePosition tilePosition = this.f24864b;
        return "TileIndex(tileCollectionId=" + str + ", position=" + tilePosition + ")";
    }
}
