package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
@SafeParcelable.Class(creator = "SignInPasswordCreator")
/* loaded from: classes.dex */
public class SignInPassword extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SignInPassword> CREATOR = new zbo();
    @SafeParcelable.Field(getter = "getId", id = 1)
    private final String zba;
    @SafeParcelable.Field(getter = "getPassword", id = 2)
    private final String zbb;

    @SafeParcelable.Constructor
    public SignInPassword(@NonNull @SafeParcelable.Param(id = 1) String str, @NonNull @SafeParcelable.Param(id = 2) String str2) {
        this.zba = Preconditions.checkNotEmpty(((String) Preconditions.checkNotNull(str, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.zbb = Preconditions.checkNotEmpty(str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignInPassword)) {
            return false;
        }
        SignInPassword signInPassword = (SignInPassword) obj;
        if (!Objects.equal(this.zba, signInPassword.zba) || !Objects.equal(this.zbb, signInPassword.zbb)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getId() {
        return this.zba;
    }

    @NonNull
    public String getPassword() {
        return this.zbb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getPassword(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
