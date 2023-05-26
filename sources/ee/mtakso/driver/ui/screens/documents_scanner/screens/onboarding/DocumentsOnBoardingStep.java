package ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBoardingFlows.kt */
/* loaded from: classes3.dex */
public final class DocumentsOnBoardingStep implements Parcelable {
    public static final Parcelable.Creator<DocumentsOnBoardingStep> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f28449f;

    /* renamed from: g  reason: collision with root package name */
    private final int f28450g;

    /* renamed from: h  reason: collision with root package name */
    private final int f28451h;

    /* renamed from: i  reason: collision with root package name */
    private final int f28452i;

    /* compiled from: OnBoardingFlows.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<DocumentsOnBoardingStep> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DocumentsOnBoardingStep createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new DocumentsOnBoardingStep(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final DocumentsOnBoardingStep[] newArray(int i8) {
            return new DocumentsOnBoardingStep[i8];
        }
    }

    public DocumentsOnBoardingStep(String id, int i8, int i9, int i10) {
        Intrinsics.f(id, "id");
        this.f28449f = id;
        this.f28450g = i8;
        this.f28451h = i9;
        this.f28452i = i10;
    }

    public final int a() {
        return this.f28450g;
    }

    public final int b() {
        return this.f28452i;
    }

    public final int c() {
        return this.f28451h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DocumentsOnBoardingStep) {
            DocumentsOnBoardingStep documentsOnBoardingStep = (DocumentsOnBoardingStep) obj;
            return Intrinsics.a(this.f28449f, documentsOnBoardingStep.f28449f) && this.f28450g == documentsOnBoardingStep.f28450g && this.f28451h == documentsOnBoardingStep.f28451h && this.f28452i == documentsOnBoardingStep.f28452i;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f28449f.hashCode() * 31) + this.f28450g) * 31) + this.f28451h) * 31) + this.f28452i;
    }

    public String toString() {
        String str = this.f28449f;
        int i8 = this.f28450g;
        int i9 = this.f28451h;
        int i10 = this.f28452i;
        return "DocumentsOnBoardingStep(id=" + str + ", animationId=" + i8 + ", titleId=" + i9 + ", descriptionId=" + i10 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f28449f);
        out.writeInt(this.f28450g);
        out.writeInt(this.f28451h);
        out.writeInt(this.f28452i);
    }
}
