package ee.mtakso.voip_client;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipConnection.kt */
/* loaded from: classes5.dex */
public final class VoipConnection implements Parcelable {
    public static final Parcelable.Creator<VoipConnection> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f36536f;

    /* compiled from: VoipConnection.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<VoipConnection> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final VoipConnection createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i8 = 0; i8 != readInt; i8++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new VoipConnection(linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final VoipConnection[] newArray(int i8) {
            return new VoipConnection[i8];
        }
    }

    public VoipConnection(Map<String, String> headers) {
        Intrinsics.f(headers, "headers");
        this.f36536f = headers;
    }

    public final Map<String, String> a() {
        return this.f36536f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VoipConnection) && Intrinsics.a(this.f36536f, ((VoipConnection) obj).f36536f);
    }

    public int hashCode() {
        return this.f36536f.hashCode();
    }

    public String toString() {
        Map<String, String> map = this.f36536f;
        return "VoipConnection(headers=" + map + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        Map<String, String> map = this.f36536f;
        out.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeString(entry.getValue());
        }
    }
}
