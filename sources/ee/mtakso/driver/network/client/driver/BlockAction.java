package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlockAction.kt */
/* loaded from: classes3.dex */
public final class BlockAction implements Parcelable {
    public static final Parcelable.Creator<BlockAction> CREATOR = new Creator();
    @SerializedName("type")

    /* renamed from: f  reason: collision with root package name */
    private final BlockActionType f21879f;
    @SerializedName("name")

    /* renamed from: g  reason: collision with root package name */
    private final String f21880g;
    @SerializedName(ImagesContract.URL)

    /* renamed from: h  reason: collision with root package name */
    private final String f21881h;

    /* compiled from: BlockAction.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<BlockAction> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BlockAction createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new BlockAction(parcel.readInt() == 0 ? null : BlockActionType.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final BlockAction[] newArray(int i8) {
            return new BlockAction[i8];
        }
    }

    public BlockAction(BlockActionType blockActionType, String title, String url) {
        Intrinsics.f(title, "title");
        Intrinsics.f(url, "url");
        this.f21879f = blockActionType;
        this.f21880g = title;
        this.f21881h = url;
    }

    public final String a() {
        return this.f21880g;
    }

    public final BlockActionType b() {
        return this.f21879f;
    }

    public final String c() {
        return this.f21881h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlockAction) {
            BlockAction blockAction = (BlockAction) obj;
            return this.f21879f == blockAction.f21879f && Intrinsics.a(this.f21880g, blockAction.f21880g) && Intrinsics.a(this.f21881h, blockAction.f21881h);
        }
        return false;
    }

    public int hashCode() {
        BlockActionType blockActionType = this.f21879f;
        return ((((blockActionType == null ? 0 : blockActionType.hashCode()) * 31) + this.f21880g.hashCode()) * 31) + this.f21881h.hashCode();
    }

    public String toString() {
        BlockActionType blockActionType = this.f21879f;
        String str = this.f21880g;
        String str2 = this.f21881h;
        return "BlockAction(type=" + blockActionType + ", title=" + str + ", url=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        BlockActionType blockActionType = this.f21879f;
        if (blockActionType == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(blockActionType.name());
        }
        out.writeString(this.f21880g);
        out.writeString(this.f21881h);
    }
}
