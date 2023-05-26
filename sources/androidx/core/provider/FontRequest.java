package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.List;

/* loaded from: classes.dex */
public final class FontRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f5826a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5827b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5828c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f5829d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5830e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5831f;

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        this.f5826a = (String) Preconditions.g(str);
        this.f5827b = (String) Preconditions.g(str2);
        this.f5828c = (String) Preconditions.g(str3);
        this.f5829d = (List) Preconditions.g(list);
        this.f5830e = 0;
        this.f5831f = a(str, str2, str3);
    }

    private String a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f5829d;
    }

    public int c() {
        return this.f5830e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String d() {
        return this.f5831f;
    }

    @NonNull
    public String e() {
        return this.f5826a;
    }

    @NonNull
    public String f() {
        return this.f5827b;
    }

    @NonNull
    public String g() {
        return this.f5828c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f5826a + ", mProviderPackage: " + this.f5827b + ", mQuery: " + this.f5828c + ", mCertificates:");
        for (int i8 = 0; i8 < this.f5829d.size(); i8++) {
            sb.append(" [");
            List<byte[]> list = this.f5829d.get(i8);
            for (int i9 = 0; i9 < list.size(); i9++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i9), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f5830e);
        return sb.toString();
    }

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, int i8) {
        this.f5826a = (String) Preconditions.g(str);
        this.f5827b = (String) Preconditions.g(str2);
        this.f5828c = (String) Preconditions.g(str3);
        this.f5829d = null;
        Preconditions.a(i8 != 0);
        this.f5830e = i8;
        this.f5831f = a(str, str2, str3);
    }
}
