package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* compiled from: PublicSuffixDatabase.kt */
/* loaded from: classes5.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final PublicSuffixDatabase instance;
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {42};
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* compiled from: PublicSuffixDatabase.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i8) {
            int i9;
            boolean z7;
            int and;
            int and2;
            int length = bArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = (i10 + length) / 2;
                while (i11 > -1 && bArr[i11] != 10) {
                    i11--;
                }
                int i12 = i11 + 1;
                int i13 = 1;
                while (true) {
                    i9 = i12 + i13;
                    if (bArr[i9] == 10) {
                        break;
                    }
                    i13++;
                }
                int i14 = i9 - i12;
                int i15 = i8;
                boolean z8 = false;
                int i16 = 0;
                int i17 = 0;
                while (true) {
                    if (z8) {
                        and = 46;
                        z7 = false;
                    } else {
                        z7 = z8;
                        and = Util.and(bArr2[i15][i16], 255);
                    }
                    and2 = and - Util.and(bArr[i12 + i17], 255);
                    if (and2 != 0) {
                        break;
                    }
                    i17++;
                    i16++;
                    if (i17 == i14) {
                        break;
                    } else if (bArr2[i15].length == i16) {
                        if (i15 == bArr2.length - 1) {
                            break;
                        }
                        i15++;
                        z8 = true;
                        i16 = -1;
                    } else {
                        z8 = z7;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i18 = i14 - i17;
                        int length2 = bArr2[i15].length - i16;
                        int length3 = bArr2.length;
                        for (int i19 = i15 + 1; i19 < length3; i19++) {
                            length2 += bArr2[i19].length;
                        }
                        if (length2 >= i18) {
                            if (length2 <= i18) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.e(UTF_8, "UTF_8");
                                return new String(bArr, i12, i14, UTF_8);
                            }
                        }
                    }
                    i10 = i9 + 1;
                }
                length = i12 - 1;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    static {
        List<String> e8;
        e8 = CollectionsKt__CollectionsJVMKt.e("*");
        PREVAILING_RULE = e8;
        instance = new PublicSuffixDatabase();
    }

    private final List<String> findMatchingRule(List<String> list) {
        boolean z7;
        List<String> list2;
        String str;
        String str2;
        String str3;
        List<String> B0;
        List<String> B02;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            readTheListUninterruptibly();
        } else {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.publicSuffixListBytes != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int size = list.size();
            byte[][] bArr = new byte[size];
            for (int i8 = 0; i8 < size; i8++) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.e(UTF_8, "UTF_8");
                byte[] bytes = list.get(i8).getBytes(UTF_8);
                Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
                bArr[i8] = bytes;
            }
            int i9 = 0;
            while (true) {
                list2 = null;
                if (i9 < size) {
                    int i10 = i9 + 1;
                    Companion companion = Companion;
                    byte[] bArr2 = this.publicSuffixListBytes;
                    if (bArr2 == null) {
                        Intrinsics.w("publicSuffixListBytes");
                        bArr2 = null;
                    }
                    String binarySearch = companion.binarySearch(bArr2, bArr, i9);
                    if (binarySearch != null) {
                        str = binarySearch;
                        break;
                    }
                    i9 = i10;
                } else {
                    str = null;
                    break;
                }
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                int i11 = 0;
                while (i11 < length) {
                    int i12 = i11 + 1;
                    bArr3[i11] = WILDCARD_LABEL;
                    Companion companion2 = Companion;
                    byte[] bArr4 = this.publicSuffixListBytes;
                    if (bArr4 == null) {
                        Intrinsics.w("publicSuffixListBytes");
                        bArr4 = null;
                    }
                    String binarySearch2 = companion2.binarySearch(bArr4, bArr3, i11);
                    if (binarySearch2 != null) {
                        str2 = binarySearch2;
                        break;
                    }
                    i11 = i12;
                }
            }
            str2 = null;
            if (str2 != null) {
                int i13 = size - 1;
                int i14 = 0;
                while (i14 < i13) {
                    int i15 = i14 + 1;
                    Companion companion3 = Companion;
                    byte[] bArr5 = this.publicSuffixExceptionListBytes;
                    if (bArr5 == null) {
                        Intrinsics.w("publicSuffixExceptionListBytes");
                        bArr5 = null;
                    }
                    str3 = companion3.binarySearch(bArr5, bArr, i14);
                    if (str3 != null) {
                        break;
                    }
                    i14 = i15;
                }
            }
            str3 = null;
            if (str3 != null) {
                B02 = StringsKt__StringsKt.B0(Intrinsics.n("!", str3), new char[]{'.'}, false, 0, 6, null);
                return B02;
            } else if (str == null && str2 == null) {
                return PREVAILING_RULE;
            } else {
                if (str == null) {
                    B0 = null;
                } else {
                    B0 = StringsKt__StringsKt.B0(str, new char[]{'.'}, false, 0, 6, null);
                }
                if (B0 == null) {
                    B0 = CollectionsKt__CollectionsKt.k();
                }
                if (str2 != null) {
                    list2 = StringsKt__StringsKt.B0(str2, new char[]{'.'}, false, 0, 6, null);
                }
                if (list2 == null) {
                    list2 = CollectionsKt__CollectionsKt.k();
                }
                if (B0.size() <= list2.size()) {
                    return list2;
                }
                return B0;
            }
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    }

    private final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource d8 = Okio.d(new GzipSource(Okio.k(resourceAsStream)));
        try {
            byte[] e02 = d8.e0(d8.readInt());
            byte[] e03 = d8.e0(d8.readInt());
            Unit unit = Unit.f50853a;
            CloseableKt.a(d8, null);
            synchronized (this) {
                Intrinsics.c(e02);
                this.publicSuffixListBytes = e02;
                Intrinsics.c(e03);
                this.publicSuffixExceptionListBytes = e03;
            }
            this.readCompleteLatch.countDown();
        } finally {
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z7 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z7 = true;
                } catch (IOException e8) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e8);
                    if (z7) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> B0;
        Object h02;
        List<String> S;
        B0 = StringsKt__StringsKt.B0(str, new char[]{'.'}, false, 0, 6, null);
        h02 = CollectionsKt___CollectionsKt.h0(B0);
        if (Intrinsics.a(h02, "")) {
            S = CollectionsKt___CollectionsKt.S(B0, 1);
            return S;
        }
        return B0;
    }

    public final String getEffectiveTldPlusOne(String domain) {
        int size;
        int size2;
        Sequence O;
        Sequence m8;
        String t7;
        Intrinsics.f(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.e(unicodeDomain, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicodeDomain);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            size = splitDomain.size();
            size2 = findMatchingRule.size();
        } else {
            size = splitDomain.size();
            size2 = findMatchingRule.size() + 1;
        }
        O = CollectionsKt___CollectionsKt.O(splitDomain(domain));
        m8 = SequencesKt___SequencesKt.m(O, size - size2);
        t7 = SequencesKt___SequencesKt.t(m8, ".", null, null, 0, null, null, 62, null);
        return t7;
    }

    public final void setListBytes(byte[] publicSuffixListBytes, byte[] publicSuffixExceptionListBytes) {
        Intrinsics.f(publicSuffixListBytes, "publicSuffixListBytes");
        Intrinsics.f(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = publicSuffixListBytes;
        this.publicSuffixExceptionListBytes = publicSuffixExceptionListBytes;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
