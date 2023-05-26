package ee.mtakso.driver.ui.interactor.driver.surge;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurgeData.kt */
/* loaded from: classes3.dex */
public abstract class SurgeData {

    /* compiled from: SurgeData.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends SurgeData {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f26543a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: SurgeData.kt */
    /* loaded from: classes3.dex */
    public static final class Tile extends SurgeData {

        /* renamed from: a  reason: collision with root package name */
        private final String f26544a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tile(String tileCollectionId) {
            super(null);
            Intrinsics.f(tileCollectionId, "tileCollectionId");
            this.f26544a = tileCollectionId;
        }

        public final String a() {
            return this.f26544a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Tile) && Intrinsics.a(this.f26544a, ((Tile) obj).f26544a);
        }

        public int hashCode() {
            return this.f26544a.hashCode();
        }

        public String toString() {
            String str = this.f26544a;
            return "Tile(tileCollectionId=" + str + ")";
        }
    }

    private SurgeData() {
    }

    public /* synthetic */ SurgeData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
