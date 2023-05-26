package ee.mtakso.driver.network.client.driver.map;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TileCollectionsPickerUi.kt */
/* loaded from: classes3.dex */
public final class TileCollectionsPickerUi {
    @SerializedName("options")

    /* renamed from: a  reason: collision with root package name */
    private final List<TileCollectionOption> f22056a;

    public final List<TileCollectionOption> a() {
        return this.f22056a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TileCollectionsPickerUi) && Intrinsics.a(this.f22056a, ((TileCollectionsPickerUi) obj).f22056a);
    }

    public int hashCode() {
        return this.f22056a.hashCode();
    }

    public String toString() {
        List<TileCollectionOption> list = this.f22056a;
        return "TileCollectionsPickerUi(options=" + list + ")";
    }
}
