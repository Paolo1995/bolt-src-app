package ee.mtakso.driver.ui.screens.login.v3.emailverification;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmailVerificationConfig.kt */
/* loaded from: classes3.dex */
public final class EmailVerificationConfig implements Parcelable {
    public static final Parcelable.Creator<EmailVerificationConfig> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f30658f;

    /* renamed from: g  reason: collision with root package name */
    private final String f30659g;

    /* renamed from: h  reason: collision with root package name */
    private final String f30660h;

    /* compiled from: EmailVerificationConfig.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<EmailVerificationConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final EmailVerificationConfig createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new EmailVerificationConfig(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final EmailVerificationConfig[] newArray(int i8) {
            return new EmailVerificationConfig[i8];
        }
    }

    public EmailVerificationConfig(String title, String description, String email) {
        Intrinsics.f(title, "title");
        Intrinsics.f(description, "description");
        Intrinsics.f(email, "email");
        this.f30658f = title;
        this.f30659g = description;
        this.f30660h = email;
    }

    public final String a() {
        return this.f30659g;
    }

    public final String b() {
        return this.f30660h;
    }

    public final String c() {
        return this.f30658f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmailVerificationConfig) {
            EmailVerificationConfig emailVerificationConfig = (EmailVerificationConfig) obj;
            return Intrinsics.a(this.f30658f, emailVerificationConfig.f30658f) && Intrinsics.a(this.f30659g, emailVerificationConfig.f30659g) && Intrinsics.a(this.f30660h, emailVerificationConfig.f30660h);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f30658f.hashCode() * 31) + this.f30659g.hashCode()) * 31) + this.f30660h.hashCode();
    }

    public String toString() {
        String str = this.f30658f;
        String str2 = this.f30659g;
        String str3 = this.f30660h;
        return "EmailVerificationConfig(title=" + str + ", description=" + str2 + ", email=" + str3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f30658f);
        out.writeString(this.f30659g);
        out.writeString(this.f30660h);
    }
}
