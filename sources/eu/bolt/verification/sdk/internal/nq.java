package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class nq extends dh {
    @SerializedName("status")

    /* renamed from: d  reason: collision with root package name */
    private final String f44355d;
    @SerializedName("steps")

    /* renamed from: e  reason: collision with root package name */
    private final List<yp> f44356e;
    @SerializedName("first_step_id")

    /* renamed from: f  reason: collision with root package name */
    private final String f44357f;
    @SerializedName("poll_interval_sec")

    /* renamed from: g  reason: collision with root package name */
    private final Integer f44358g;
    @SerializedName("media_upload_failed_step")

    /* renamed from: h  reason: collision with root package name */
    private final yp f44359h;

    public final yp a() {
        return this.f44359h;
    }

    public final String b() {
        return this.f44357f;
    }

    public final Integer c() {
        return this.f44358g;
    }

    public final String d() {
        return this.f44355d;
    }

    public final List<yp> e() {
        return this.f44356e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof nq) {
            nq nqVar = (nq) obj;
            return Intrinsics.a(this.f44355d, nqVar.f44355d) && Intrinsics.a(this.f44356e, nqVar.f44356e) && Intrinsics.a(this.f44357f, nqVar.f44357f) && Intrinsics.a(this.f44358g, nqVar.f44358g) && Intrinsics.a(this.f44359h, nqVar.f44359h);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f44355d.hashCode() * 31) + this.f44356e.hashCode()) * 31) + this.f44357f.hashCode()) * 31;
        Integer num = this.f44358g;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        yp ypVar = this.f44359h;
        return hashCode2 + (ypVar != null ? ypVar.hashCode() : 0);
    }

    public String toString() {
        String str = this.f44355d;
        List<yp> list = this.f44356e;
        String str2 = this.f44357f;
        Integer num = this.f44358g;
        yp ypVar = this.f44359h;
        return "VerificationUploadFileResponse(status=" + str + ", steps=" + list + ", firstStepId=" + str2 + ", pollIntervalSec=" + num + ", errorStep=" + ypVar + ")";
    }
}
