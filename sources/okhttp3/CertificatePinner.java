package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

/* compiled from: CertificatePinner.kt */
/* loaded from: classes5.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* compiled from: CertificatePinner.kt */
    /* loaded from: classes5.dex */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String pattern, String... pins) {
            Intrinsics.f(pattern, "pattern");
            Intrinsics.f(pins, "pins");
            int length = pins.length;
            int i8 = 0;
            while (i8 < length) {
                String str = pins[i8];
                i8++;
                getPins().add(new Pin(pattern, str));
            }
            return this;
        }

        public final CertificatePinner build() {
            Set L0;
            L0 = CollectionsKt___CollectionsKt.L0(this.pins);
            return new CertificatePinner(L0, null, 2, null);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* compiled from: CertificatePinner.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String pin(Certificate certificate) {
            Intrinsics.f(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return Intrinsics.n("sha256/", sha256Hash((X509Certificate) certificate).a());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final ByteString sha1Hash(X509Certificate x509Certificate) {
            Intrinsics.f(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.f52591i;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.e(encoded, "publicKey.encoded");
            return ByteString.Companion.f(companion, encoded, 0, 0, 3, null).x();
        }

        public final ByteString sha256Hash(X509Certificate x509Certificate) {
            Intrinsics.f(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.f52591i;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.e(encoded, "publicKey.encoded");
            return ByteString.Companion.f(companion, encoded, 0, 0, 3, null).y();
        }
    }

    /* compiled from: CertificatePinner.kt */
    /* loaded from: classes5.dex */
    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0024, code lost:
            if (r0 != (-1)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
            if (r0 != (-1)) goto L36;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Pin(java.lang.String r12, java.lang.String r13) {
            /*
                r11 = this;
                java.lang.String r0 = "pattern"
                kotlin.jvm.internal.Intrinsics.f(r12, r0)
                java.lang.String r0 = "pin"
                kotlin.jvm.internal.Intrinsics.f(r13, r0)
                r11.<init>()
                java.lang.String r0 = "*."
                r1 = 0
                r2 = 2
                r3 = 0
                boolean r0 = kotlin.text.StringsKt.L(r12, r0, r1, r2, r3)
                r4 = -1
                if (r0 == 0) goto L26
                r7 = 1
                r8 = 0
                r9 = 4
                r10 = 0
                java.lang.String r6 = "*"
                r5 = r12
                int r0 = kotlin.text.StringsKt.b0(r5, r6, r7, r8, r9, r10)
                if (r0 == r4) goto L48
            L26:
                java.lang.String r0 = "**."
                boolean r0 = kotlin.text.StringsKt.L(r12, r0, r1, r2, r3)
                if (r0 == 0) goto L3b
                r7 = 2
                r8 = 0
                r9 = 4
                r10 = 0
                java.lang.String r6 = "*"
                r5 = r12
                int r0 = kotlin.text.StringsKt.b0(r5, r6, r7, r8, r9, r10)
                if (r0 == r4) goto L48
            L3b:
                r7 = 0
                r8 = 0
                r9 = 6
                r10 = 0
                java.lang.String r6 = "*"
                r5 = r12
                int r0 = kotlin.text.StringsKt.b0(r5, r6, r7, r8, r9, r10)
                if (r0 != r4) goto L4a
            L48:
                r0 = 1
                goto L4b
            L4a:
                r0 = 0
            L4b:
                if (r0 == 0) goto Lc3
                java.lang.String r0 = okhttp3.internal.HostnamesKt.toCanonicalHost(r12)
                if (r0 == 0) goto Lb7
                r11.pattern = r0
                java.lang.String r12 = "sha1/"
                boolean r12 = kotlin.text.StringsKt.L(r13, r12, r1, r2, r3)
                java.lang.String r0 = "Invalid pin hash: "
                java.lang.String r4 = "this as java.lang.String).substring(startIndex)"
                if (r12 == 0) goto L82
                java.lang.String r12 = "sha1"
                r11.hashAlgorithm = r12
                okio.ByteString$Companion r12 = okio.ByteString.f52591i
                r1 = 5
                java.lang.String r1 = r13.substring(r1)
                kotlin.jvm.internal.Intrinsics.e(r1, r4)
                okio.ByteString r12 = r12.a(r1)
                if (r12 == 0) goto L78
                r11.hash = r12
                goto La0
            L78:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.String r13 = kotlin.jvm.internal.Intrinsics.n(r0, r13)
                r12.<init>(r13)
                throw r12
            L82:
                java.lang.String r12 = "sha256/"
                boolean r12 = kotlin.text.StringsKt.L(r13, r12, r1, r2, r3)
                if (r12 == 0) goto Lab
                java.lang.String r12 = "sha256"
                r11.hashAlgorithm = r12
                okio.ByteString$Companion r12 = okio.ByteString.f52591i
                r1 = 7
                java.lang.String r1 = r13.substring(r1)
                kotlin.jvm.internal.Intrinsics.e(r1, r4)
                okio.ByteString r12 = r12.a(r1)
                if (r12 == 0) goto La1
                r11.hash = r12
            La0:
                return
            La1:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.String r13 = kotlin.jvm.internal.Intrinsics.n(r0, r13)
                r12.<init>(r13)
                throw r12
            Lab:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "pins must start with 'sha256/' or 'sha1/': "
                java.lang.String r13 = kotlin.jvm.internal.Intrinsics.n(r0, r13)
                r12.<init>(r13)
                throw r12
            Lb7:
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Invalid pattern: "
                java.lang.String r12 = kotlin.jvm.internal.Intrinsics.n(r0, r12)
                r13.<init>(r12)
                throw r13
            Lc3:
                java.lang.String r13 = "Unexpected pattern: "
                java.lang.String r12 = kotlin.jvm.internal.Intrinsics.n(r13, r12)
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                java.lang.String r12 = r12.toString()
                r13.<init>(r12)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CertificatePinner.Pin.<init>(java.lang.String, java.lang.String):void");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            if (Intrinsics.a(this.pattern, pin.pattern) && Intrinsics.a(this.hashAlgorithm, pin.hashAlgorithm) && Intrinsics.a(this.hash, pin.hash)) {
                return true;
            }
            return false;
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(X509Certificate certificate) {
            Intrinsics.f(certificate, "certificate");
            String str = this.hashAlgorithm;
            if (Intrinsics.a(str, "sha256")) {
                return Intrinsics.a(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
            }
            if (Intrinsics.a(str, "sha1")) {
                return Intrinsics.a(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
            }
            return false;
        }

        public final boolean matchesHostname(String hostname) {
            boolean L;
            boolean L2;
            boolean A;
            int g02;
            boolean A2;
            Intrinsics.f(hostname, "hostname");
            L = StringsKt__StringsJVMKt.L(this.pattern, "**.", false, 2, null);
            if (L) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                A2 = StringsKt__StringsJVMKt.A(hostname, hostname.length() - length, this.pattern, 3, length, false, 16, null);
                if (!A2) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                L2 = StringsKt__StringsJVMKt.L(this.pattern, "*.", false, 2, null);
                if (L2) {
                    int length3 = this.pattern.length() - 1;
                    int length4 = hostname.length() - length3;
                    A = StringsKt__StringsJVMKt.A(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, null);
                    if (!A) {
                        return false;
                    }
                    g02 = StringsKt__StringsKt.g0(hostname, '.', length4 - 1, false, 4, null);
                    if (g02 != -1) {
                        return false;
                    }
                } else {
                    return Intrinsics.a(hostname, this.pattern);
                }
            }
            return true;
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.a();
        }
    }

    public CertificatePinner(Set<Pin> pins, CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.f(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final ByteString sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final ByteString sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(final String hostname, final List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        Intrinsics.f(hostname, "hostname");
        Intrinsics.f(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends X509Certificate> invoke() {
                int v7;
                CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
                List<Certificate> clean = certificateChainCleaner$okhttp == null ? null : certificateChainCleaner$okhttp.clean(peerCertificates, hostname);
                if (clean == null) {
                    clean = peerCertificates;
                }
                v7 = CollectionsKt__IterablesKt.v(clean, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (Certificate certificate : clean) {
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    public final void check$okhttp(String hostname, Function0<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) {
        Intrinsics.f(hostname, "hostname");
        Intrinsics.f(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(hostname);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> invoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : invoke) {
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (Pin pin : findMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (Intrinsics.a(hashAlgorithm, "sha256")) {
                    if (byteString == null) {
                        byteString = Companion.sha256Hash(x509Certificate);
                    }
                    if (Intrinsics.a(pin.getHash(), byteString)) {
                        return;
                    }
                } else if (Intrinsics.a(hashAlgorithm, "sha1")) {
                    if (byteString2 == null) {
                        byteString2 = Companion.sha1Hash(x509Certificate);
                    }
                    if (Intrinsics.a(pin.getHash(), byteString2)) {
                        return;
                    }
                } else {
                    throw new AssertionError(Intrinsics.n("unsupported hashAlgorithm: ", pin.getHashAlgorithm()));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : invoke) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (Pin pin2 : findMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Intrinsics.a(certificatePinner.pins, this.pins) && Intrinsics.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final List<Pin> findMatchingPins(String hostname) {
        List<Pin> k8;
        Intrinsics.f(hostname, "hostname");
        Set<Pin> set = this.pins;
        k8 = CollectionsKt__CollectionsKt.k();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(hostname)) {
                if (k8.isEmpty()) {
                    k8 = new ArrayList<>();
                }
                TypeIntrinsics.c(k8).add(obj);
            }
        }
        return k8;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int i8;
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            i8 = certificateChainCleaner.hashCode();
        } else {
            i8 = 0;
        }
        return hashCode + i8;
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.f(certificateChainCleaner, "certificateChainCleaner");
        if (Intrinsics.a(this.certificateChainCleaner, certificateChainCleaner)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public final void check(String hostname, Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        List<? extends Certificate> f02;
        Intrinsics.f(hostname, "hostname");
        Intrinsics.f(peerCertificates, "peerCertificates");
        f02 = ArraysKt___ArraysKt.f0(peerCertificates);
        check(hostname, f02);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i8 & 2) != 0 ? null : certificateChainCleaner);
    }
}
