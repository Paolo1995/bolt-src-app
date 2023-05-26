package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.contact.ContactOptionsUseCase;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsViewModel.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsConfig implements Parcelable {
    public static final Parcelable.Creator<ContactOptionsConfig> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final boolean f27768f;

    /* renamed from: g  reason: collision with root package name */
    private final CancelTarget f27769g;

    /* renamed from: h  reason: collision with root package name */
    private final ContactOptionsUseCase f27770h;

    /* renamed from: i  reason: collision with root package name */
    private final OrderHandle f27771i;

    /* compiled from: ContactOptionsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ContactOptionsConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ContactOptionsConfig createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new ContactOptionsConfig(parcel.readInt() != 0, CancelTarget.valueOf(parcel.readString()), ContactOptionsUseCase.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : OrderHandle.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ContactOptionsConfig[] newArray(int i8) {
            return new ContactOptionsConfig[i8];
        }
    }

    public ContactOptionsConfig() {
        this(false, null, null, null, 15, null);
    }

    public ContactOptionsConfig(boolean z7, CancelTarget cancelTarget, ContactOptionsUseCase useCase, OrderHandle orderHandle) {
        Intrinsics.f(cancelTarget, "cancelTarget");
        Intrinsics.f(useCase, "useCase");
        this.f27768f = z7;
        this.f27769g = cancelTarget;
        this.f27770h = useCase;
        this.f27771i = orderHandle;
    }

    public final CancelTarget a() {
        return this.f27769g;
    }

    public final boolean b() {
        return this.f27768f;
    }

    public final OrderHandle c() {
        return this.f27771i;
    }

    public final ContactOptionsUseCase d() {
        return this.f27770h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContactOptionsConfig) {
            ContactOptionsConfig contactOptionsConfig = (ContactOptionsConfig) obj;
            return this.f27768f == contactOptionsConfig.f27768f && this.f27769g == contactOptionsConfig.f27769g && this.f27770h == contactOptionsConfig.f27770h && Intrinsics.a(this.f27771i, contactOptionsConfig.f27771i);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z7 = this.f27768f;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int hashCode = ((((r02 * 31) + this.f27769g.hashCode()) * 31) + this.f27770h.hashCode()) * 31;
        OrderHandle orderHandle = this.f27771i;
        return hashCode + (orderHandle == null ? 0 : orderHandle.hashCode());
    }

    public String toString() {
        boolean z7 = this.f27768f;
        CancelTarget cancelTarget = this.f27769g;
        ContactOptionsUseCase contactOptionsUseCase = this.f27770h;
        OrderHandle orderHandle = this.f27771i;
        return "ContactOptionsConfig(ommitChat=" + z7 + ", cancelTarget=" + cancelTarget + ", useCase=" + contactOptionsUseCase + ", orderHandle=" + orderHandle + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeInt(this.f27768f ? 1 : 0);
        out.writeString(this.f27769g.name());
        out.writeString(this.f27770h.name());
        OrderHandle orderHandle = this.f27771i;
        if (orderHandle == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        orderHandle.writeToParcel(out, i8);
    }

    public /* synthetic */ ContactOptionsConfig(boolean z7, CancelTarget cancelTarget, ContactOptionsUseCase contactOptionsUseCase, OrderHandle orderHandle, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7, (i8 & 2) != 0 ? CancelTarget.NONE : cancelTarget, (i8 & 4) != 0 ? ContactOptionsUseCase.ACTIVE_ORDER : contactOptionsUseCase, (i8 & 8) != 0 ? null : orderHandle);
    }
}
