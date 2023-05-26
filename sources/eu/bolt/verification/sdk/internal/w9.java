package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public final class w9 implements Serializable {
    @SerializedName("height")

    /* renamed from: f  reason: collision with root package name */
    private final int f45537f;
    @SerializedName("width")

    /* renamed from: g  reason: collision with root package name */
    private final int f45538g;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w9) {
            w9 w9Var = (w9) obj;
            return this.f45537f == w9Var.f45537f && this.f45538g == w9Var.f45538g;
        }
        return false;
    }

    public int hashCode() {
        return (this.f45537f * 31) + this.f45538g;
    }

    public String toString() {
        int i8 = this.f45537f;
        int i9 = this.f45538g;
        return "ImageSizeResponse(height=" + i8 + ", width=" + i9 + ")";
    }
}
