package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class VersionedParcelParcel extends VersionedParcel {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f8019d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f8020e;

    /* renamed from: f  reason: collision with root package name */
    private final int f8021f;

    /* renamed from: g  reason: collision with root package name */
    private final int f8022g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8023h;

    /* renamed from: i  reason: collision with root package name */
    private int f8024i;

    /* renamed from: j  reason: collision with root package name */
    private int f8025j;

    /* renamed from: k  reason: collision with root package name */
    private int f8026k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f8020e.writeInt(bArr.length);
            this.f8020e.writeByteArray(bArr);
            return;
        }
        this.f8020e.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f8020e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i8) {
        this.f8020e.writeInt(i8);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.f8020e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        this.f8020e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i8 = this.f8024i;
        if (i8 >= 0) {
            int i9 = this.f8019d.get(i8);
            int dataPosition = this.f8020e.dataPosition();
            this.f8020e.setDataPosition(i9);
            this.f8020e.writeInt(dataPosition - i9);
            this.f8020e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        Parcel parcel = this.f8020e;
        int dataPosition = parcel.dataPosition();
        int i8 = this.f8025j;
        if (i8 == this.f8021f) {
            i8 = this.f8022g;
        }
        int i9 = i8;
        return new VersionedParcelParcel(parcel, dataPosition, i9, this.f8023h + "  ", this.f8016a, this.f8017b, this.f8018c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        if (this.f8020e.readInt() != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int readInt = this.f8020e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f8020e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f8020e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i8) {
        while (this.f8025j < this.f8022g) {
            int i9 = this.f8026k;
            if (i9 == i8) {
                return true;
            }
            if (String.valueOf(i9).compareTo(String.valueOf(i8)) > 0) {
                return false;
            }
            this.f8020e.setDataPosition(this.f8025j);
            int readInt = this.f8020e.readInt();
            this.f8026k = this.f8020e.readInt();
            this.f8025j += readInt;
        }
        if (this.f8026k == i8) {
            return true;
        }
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f8020e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T q() {
        return (T) this.f8020e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f8020e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i8) {
        a();
        this.f8024i = i8;
        this.f8019d.put(i8, this.f8020e.dataPosition());
        E(0);
        E(i8);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z7) {
        this.f8020e.writeInt(z7 ? 1 : 0);
    }

    private VersionedParcelParcel(Parcel parcel, int i8, int i9, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f8019d = new SparseIntArray();
        this.f8024i = -1;
        this.f8026k = -1;
        this.f8020e = parcel;
        this.f8021f = i8;
        this.f8022g = i9;
        this.f8025j = i8;
        this.f8023h = str;
    }
}
