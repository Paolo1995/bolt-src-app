package eu.bolt.verification.sdk.internal;

import android.net.Uri;
import eu.bolt.verification.sdk.internal.td;
import java.util.Set;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class kr implements jr {

    /* renamed from: g  reason: collision with root package name */
    public static final a f43910g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f43911a;

    /* renamed from: b  reason: collision with root package name */
    private final String f43912b;

    /* renamed from: c  reason: collision with root package name */
    private final String f43913c;

    /* renamed from: d  reason: collision with root package name */
    private final String f43914d;

    /* renamed from: e  reason: collision with root package name */
    private final String f43915e;

    /* renamed from: f  reason: collision with root package name */
    private final String f43916f;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public kr(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f43911a = str;
        this.f43912b = str2;
        this.f43913c = str3;
        this.f43914d = str4;
        this.f43915e = str5;
        this.f43916f = str6;
    }

    private final String b(String str) {
        Uri parse = Uri.parse(str);
        Uri.Builder appendEncodedPath = new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).appendEncodedPath(parse.getPath());
        Set<String> inputUriQueryParameterNames = parse.getQueryParameterNames();
        for (String str2 : inputUriQueryParameterNames) {
            appendEncodedPath.appendQueryParameter(str2, parse.getQueryParameter(str2));
        }
        String str3 = this.f43911a;
        Intrinsics.e(inputUriQueryParameterNames, "inputUriQueryParameterNames");
        Intrinsics.e(appendEncodedPath, "this");
        c(str3, "language", inputUriQueryParameterNames, appendEncodedPath);
        c(this.f43914d, "version", inputUriQueryParameterNames, appendEncodedPath);
        c(this.f43913c, "device_os_version", inputUriQueryParameterNames, appendEncodedPath);
        c(this.f43912b, "deviceId", inputUriQueryParameterNames, appendEncodedPath);
        c(this.f43915e, "deviceType", inputUriQueryParameterNames, appendEncodedPath);
        c(this.f43916f, "country", inputUriQueryParameterNames, appendEncodedPath);
        String uri = appendEncodedPath.build().toString();
        Intrinsics.e(uri, "Builder()\n            .s…     }.build().toString()");
        return uri;
    }

    private final void c(String str, String str2, Set<String> set, Uri.Builder builder) {
        if (str == null || set.contains(str2)) {
            return;
        }
        builder.appendQueryParameter(str2, str);
    }

    @Override // eu.bolt.verification.sdk.internal.jr
    public td a(td openWebViewModel) {
        Intrinsics.f(openWebViewModel, "openWebViewModel");
        return openWebViewModel instanceof td.a ? td.a.b((td.a) openWebViewModel, b(openWebViewModel.a()), null, null, 6, null) : openWebViewModel instanceof td.b ? td.b.b((td.b) openWebViewModel, b(openWebViewModel.a()), null, 2, null) : openWebViewModel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kr) {
            kr krVar = (kr) obj;
            return Intrinsics.a(this.f43911a, krVar.f43911a) && Intrinsics.a(this.f43912b, krVar.f43912b) && Intrinsics.a(this.f43913c, krVar.f43913c) && Intrinsics.a(this.f43914d, krVar.f43914d) && Intrinsics.a(this.f43915e, krVar.f43915e) && Intrinsics.a(this.f43916f, krVar.f43916f);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f43911a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f43912b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f43913c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f43914d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f43915e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f43916f;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        String str = this.f43911a;
        String str2 = this.f43912b;
        String str3 = this.f43913c;
        String str4 = this.f43914d;
        String str5 = this.f43915e;
        String str6 = this.f43916f;
        return "WebViewQueryParamsWrapperImpl(languageParam=" + str + ", deviceIdParam=" + str2 + ", deviceOsVersionParam=" + str3 + ", appVersionParam=" + str4 + ", deviceTypeParam=" + str5 + ", countryParam=" + str6 + ")";
    }
}
