package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Block.kt */
/* loaded from: classes3.dex */
public final class BlockData implements Parcelable {
    public static final Parcelable.Creator<BlockData> CREATOR = new Creator();
    @SerializedName(Name.MARK)

    /* renamed from: f  reason: collision with root package name */
    private final long f21882f;
    @SerializedName("message")

    /* renamed from: g  reason: collision with root package name */
    private final String f21883g;
    @SerializedName("actions")

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<BlockAction> f21884h;

    /* compiled from: Block.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<BlockData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BlockData createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i8 = 0; i8 != readInt; i8++) {
                arrayList.add(BlockAction.CREATOR.createFromParcel(parcel));
            }
            return new BlockData(readLong, readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final BlockData[] newArray(int i8) {
            return new BlockData[i8];
        }
    }

    public BlockData(long j8, String message, ArrayList<BlockAction> actions) {
        Intrinsics.f(message, "message");
        Intrinsics.f(actions, "actions");
        this.f21882f = j8;
        this.f21883g = message;
        this.f21884h = actions;
    }

    public final ArrayList<BlockAction> a() {
        return this.f21884h;
    }

    public final String b() {
        return this.f21883g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlockData) {
            BlockData blockData = (BlockData) obj;
            return this.f21882f == blockData.f21882f && Intrinsics.a(this.f21883g, blockData.f21883g) && Intrinsics.a(this.f21884h, blockData.f21884h);
        }
        return false;
    }

    public int hashCode() {
        return (((i0.a.a(this.f21882f) * 31) + this.f21883g.hashCode()) * 31) + this.f21884h.hashCode();
    }

    public String toString() {
        long j8 = this.f21882f;
        String str = this.f21883g;
        ArrayList<BlockAction> arrayList = this.f21884h;
        return "BlockData(id=" + j8 + ", message=" + str + ", actions=" + arrayList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.f21882f);
        out.writeString(this.f21883g);
        ArrayList<BlockAction> arrayList = this.f21884h;
        out.writeInt(arrayList.size());
        Iterator<BlockAction> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i8);
        }
    }
}
