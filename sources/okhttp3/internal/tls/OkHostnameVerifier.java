package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;

/* compiled from: OkHostnameVerifier.kt */
/* loaded from: classes5.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (isAscii(str)) {
            Locale US = Locale.US;
            Intrinsics.e(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        return str;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i8) {
        List<String> k8;
        Object obj;
        List<String> k9;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                k9 = CollectionsKt__CollectionsKt.k();
                return k9;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && Intrinsics.a(list.get(0), Integer.valueOf(i8)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
    }

    private final boolean isAscii(String str) {
        if (str.length() != ((int) Utf8.b(str, 0, 0, 3, null))) {
            return false;
        }
        return true;
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        for (String str2 : subjectAltNames) {
            if (INSTANCE.verifyHostname(asciiToLowercase, str2)) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        for (String str2 : subjectAltNames) {
            if (Intrinsics.a(canonicalHost, HostnamesKt.toCanonicalHost(str2))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate certificate) {
        List<String> n02;
        Intrinsics.f(certificate, "certificate");
        n02 = CollectionsKt___CollectionsKt.n0(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
        return n02;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        Certificate certificate;
        Intrinsics.f(host, "host");
        Intrinsics.f(session, "session");
        if (isAscii(host)) {
            try {
                certificate = session.getPeerCertificates()[0];
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
            } catch (SSLException unused) {
                return false;
            }
        }
        return verify(host, (X509Certificate) certificate);
    }

    public final boolean verify(String host, X509Certificate certificate) {
        Intrinsics.f(host, "host");
        Intrinsics.f(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        boolean L;
        boolean v7;
        boolean L2;
        boolean v8;
        boolean v9;
        boolean v10;
        boolean Q;
        boolean L3;
        int a02;
        boolean v11;
        int g02;
        if (!(str == null || str.length() == 0)) {
            L = StringsKt__StringsJVMKt.L(str, ".", false, 2, null);
            if (!L) {
                v7 = StringsKt__StringsJVMKt.v(str, "..", false, 2, null);
                if (!v7) {
                    if (!(str2 == null || str2.length() == 0)) {
                        L2 = StringsKt__StringsJVMKt.L(str2, ".", false, 2, null);
                        if (!L2) {
                            v8 = StringsKt__StringsJVMKt.v(str2, "..", false, 2, null);
                            if (!v8) {
                                v9 = StringsKt__StringsJVMKt.v(str, ".", false, 2, null);
                                if (!v9) {
                                    str = Intrinsics.n(str, ".");
                                }
                                String str3 = str;
                                v10 = StringsKt__StringsJVMKt.v(str2, ".", false, 2, null);
                                if (!v10) {
                                    str2 = Intrinsics.n(str2, ".");
                                }
                                String asciiToLowercase = asciiToLowercase(str2);
                                Q = StringsKt__StringsKt.Q(asciiToLowercase, "*", false, 2, null);
                                if (!Q) {
                                    return Intrinsics.a(str3, asciiToLowercase);
                                }
                                L3 = StringsKt__StringsJVMKt.L(asciiToLowercase, "*.", false, 2, null);
                                if (L3) {
                                    a02 = StringsKt__StringsKt.a0(asciiToLowercase, '*', 1, false, 4, null);
                                    if (a02 == -1 && str3.length() >= asciiToLowercase.length() && !Intrinsics.a("*.", asciiToLowercase)) {
                                        String substring = asciiToLowercase.substring(1);
                                        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                                        v11 = StringsKt__StringsJVMKt.v(str3, substring, false, 2, null);
                                        if (v11) {
                                            int length = str3.length() - substring.length();
                                            if (length > 0) {
                                                g02 = StringsKt__StringsKt.g0(str3, '.', length - 1, false, 4, null);
                                                if (g02 != -1) {
                                                    return false;
                                                }
                                            }
                                            return true;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
