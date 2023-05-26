package org.ccil.cowan.tagsoup;

import java.io.IOException;
import java.io.PushbackReader;
import java.lang.reflect.Array;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class HTMLScanner implements Scanner, Locator {

    /* renamed from: l  reason: collision with root package name */
    private static int[] f52667l = {1, 47, 5, 22, 1, 61, 4, 3, 1, 62, 6, 28, 1, 0, 27, 1, 1, -1, 6, 21, 1, 32, 4, 24, 1, 10, 4, 24, 1, 9, 4, 24, 2, 39, 7, 34, 2, 0, 27, 2, 2, -1, 8, 21, 2, 32, 29, 2, 2, 10, 29, 2, 2, 9, 29, 2, 3, 34, 28, 31, 3, 39, 28, 2, 3, 62, 8, 28, 3, 0, 27, 32, 3, -1, 8, 21, 3, 32, 28, 3, 3, 10, 28, 3, 3, 9, 28, 3, 4, 67, 28, 5, 4, 0, 28, 19, 4, -1, 28, 21, 5, 68, 28, 6, 5, 0, 28, 19, 5, -1, 28, 21, 6, 65, 28, 7, 6, 0, 28, 19, 6, -1, 28, 21, 7, 84, 28, 8, 7, 0, 28, 19, 7, -1, 28, 21, 8, 65, 28, 9, 8, 0, 28, 19, 8, -1, 28, 21, 9, 91, 28, 12, 9, 0, 28, 19, 9, -1, 28, 21, 10, 60, 27, 11, 10, 0, 27, 10, 10, -1, 23, 21, 11, 47, 32, 25, 11, 0, 27, 10, 11, -1, 32, 21, 12, 93, 27, 13, 12, 0, 27, 12, 12, -1, 28, 21, 13, 93, 27, 14, 13, 0, 27, 12, 13, -1, 28, 21, 14, 62, 9, 28, 14, 93, 27, 14, 14, 0, 27, 12, 14, -1, 28, 21, 15, 45, 28, 16, 15, 0, 27, 16, 15, -1, 10, 21, 16, 45, 28, 17, 16, 0, 27, 16, 16, -1, 10, 21, 17, 45, 28, 18, 17, 0, 20, 16, 17, -1, 10, 21, 18, 45, 22, 18, 18, 62, 10, 28, 18, 0, 21, 16, 18, -1, 10, 21, 19, 45, 28, 15, 19, 62, 28, 28, 19, 91, 28, 4, 19, 0, 27, 20, 19, -1, 28, 21, 20, 62, 11, 28, 20, 0, 27, 20, 20, -1, 28, 21, 22, 62, 12, 28, 22, 0, 27, 1, 22, 32, 28, 34, 22, 10, 28, 34, 22, 9, 28, 34, 23, 0, 13, 23, 23, -1, 13, 21, 24, 61, 28, 3, 24, 62, 3, 28, 24, 0, 2, 1, 24, -1, 3, 21, 24, 32, 28, 24, 24, 10, 28, 24, 24, 9, 28, 24, 25, 62, 15, 28, 25, 0, 27, 25, 25, -1, 15, 21, 25, 32, 28, 25, 25, 10, 28, 25, 25, 9, 28, 25, 26, 47, 28, 22, 26, 62, 17, 28, 26, 0, 27, 26, 26, -1, 28, 21, 26, 32, 16, 34, 26, 10, 16, 34, 26, 9, 16, 34, 27, 0, 13, 27, 27, -1, 13, 21, 28, 38, 14, 23, 28, 60, 23, 33, 28, 0, 27, 28, 28, -1, 23, 21, 29, 62, 24, 28, 29, 0, 27, 29, 29, -1, 24, 21, 30, 62, 26, 28, 30, 0, 27, 30, 30, -1, 26, 21, 30, 32, 25, 29, 30, 10, 25, 29, 30, 9, 25, 29, 31, 34, 7, 34, 31, 0, 27, 31, 31, -1, 8, 21, 31, 32, 29, 31, 31, 10, 29, 31, 31, 9, 29, 31, 32, 62, 8, 28, 32, 0, 27, 32, 32, -1, 8, 21, 32, 32, 7, 34, 32, 10, 7, 34, 32, 9, 7, 34, 33, 33, 28, 19, 33, 47, 28, 25, 33, 60, 27, 33, 33, 63, 28, 30, 33, 0, 27, 26, 33, -1, 19, 21, 33, 32, 18, 28, 33, 10, 18, 28, 33, 9, 18, 28, 34, 47, 28, 22, 34, 62, 30, 28, 34, 0, 27, 1, 34, -1, 30, 21, 34, 32, 28, 34, 34, 10, 28, 34, 34, 9, 28, 34, 35, 0, 13, 35, 35, -1, 13, 21};

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f52668m = {"", "A_ADUP", "A_ADUP_SAVE", "A_ADUP_STAGC", "A_ANAME", "A_ANAME_ADUP", "A_ANAME_ADUP_STAGC", "A_AVAL", "A_AVAL_STAGC", "A_CDATA", "A_CMNT", "A_DECL", "A_EMPTYTAG", "A_ENTITY", "A_ENTITY_START", "A_ETAG", "A_GI", "A_GI_STAGC", "A_LT", "A_LT_PCDATA", "A_MINUS", "A_MINUS2", "A_MINUS3", "A_PCDATA", "A_PI", "A_PITARGET", "A_PITARGET_PI", "A_SAVE", "A_SKIP", "A_SP", "A_STAGC", "A_UNGET", "A_UNSAVE_PCDATA"};

    /* renamed from: n  reason: collision with root package name */
    private static final String[] f52669n = {"", "S_ANAME", "S_APOS", "S_AVAL", "S_BB", "S_BBC", "S_BBCD", "S_BBCDA", "S_BBCDAT", "S_BBCDATA", "S_CDATA", "S_CDATA2", "S_CDSECT", "S_CDSECT1", "S_CDSECT2", "S_COM", "S_COM2", "S_COM3", "S_COM4", "S_DECL", "S_DECL2", "S_DONE", "S_EMPTYTAG", "S_ENT", "S_EQ", "S_ETAG", "S_GI", "S_NCR", "S_PCDATA", "S_PI", "S_PITARGET", "S_QUOT", "S_STAGC", "S_TAG", "S_TAGWS", "S_XNCR"};

    /* renamed from: o  reason: collision with root package name */
    static short[][] f52670o;

    /* renamed from: p  reason: collision with root package name */
    static int f52671p;

    /* renamed from: a  reason: collision with root package name */
    private String f52672a;

    /* renamed from: b  reason: collision with root package name */
    private String f52673b;

    /* renamed from: c  reason: collision with root package name */
    private int f52674c;

    /* renamed from: d  reason: collision with root package name */
    private int f52675d;

    /* renamed from: e  reason: collision with root package name */
    private int f52676e;

    /* renamed from: f  reason: collision with root package name */
    private int f52677f;

    /* renamed from: g  reason: collision with root package name */
    int f52678g;

    /* renamed from: h  reason: collision with root package name */
    int f52679h;

    /* renamed from: j  reason: collision with root package name */
    int f52681j;

    /* renamed from: i  reason: collision with root package name */
    char[] f52680i = new char[200];

    /* renamed from: k  reason: collision with root package name */
    int[] f52682k = {8364, 65533, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 65533, 382, 376};

    static {
        int i8 = 0;
        int i9 = -1;
        int i10 = -1;
        while (true) {
            int[] iArr = f52667l;
            if (i8 >= iArr.length) {
                break;
            }
            int i11 = iArr[i8];
            if (i11 > i10) {
                i10 = i11;
            }
            int i12 = iArr[i8 + 1];
            if (i12 > i9) {
                i9 = i12;
            }
            i8 += 4;
        }
        f52671p = i9 + 1;
        f52670o = (short[][]) Array.newInstance(Short.TYPE, i10 + 1, i9 + 3);
        for (int i13 = 0; i13 <= i10; i13++) {
            for (int i14 = -2; i14 <= i9; i14++) {
                int i15 = 0;
                int i16 = 0;
                int i17 = -1;
                while (true) {
                    int[] iArr2 = f52667l;
                    if (i15 >= iArr2.length) {
                        break;
                    }
                    if (i13 != iArr2[i15]) {
                        if (i16 != 0) {
                            break;
                        }
                    } else {
                        int i18 = iArr2[i15 + 1];
                        if (i18 == 0) {
                            i16 = iArr2[i15 + 2];
                            i17 = i15;
                        } else if (i18 == i14) {
                            int i19 = iArr2[i15 + 2];
                            break;
                        }
                    }
                    i15 += 4;
                }
                i15 = i17;
                f52670o[i13][i14 + 2] = (short) i15;
            }
        }
    }

    private void c() {
        this.f52675d = this.f52677f;
        this.f52674c = this.f52676e;
    }

    private void d(int i8, ScanHandler scanHandler) throws IOException, SAXException {
        int i9 = this.f52681j;
        char[] cArr = this.f52680i;
        if (i9 >= cArr.length - 20) {
            int i10 = this.f52678g;
            if (i10 != 28 && i10 != 10) {
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, i9 + 1);
                this.f52680i = cArr2;
            } else {
                scanHandler.f(cArr, 0, i9);
                this.f52681j = 0;
            }
        }
        char[] cArr3 = this.f52680i;
        int i11 = this.f52681j;
        this.f52681j = i11 + 1;
        cArr3[i11] = (char) i8;
    }

    private void e(PushbackReader pushbackReader, int i8) throws IOException {
        if (i8 != -1) {
            pushbackReader.unread(i8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        if (r1 >= org.ccil.cowan.tagsoup.HTMLScanner.f52671p) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        r9 = r1;
     */
    @Override // org.ccil.cowan.tagsoup.Scanner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.io.Reader r17, org.ccil.cowan.tagsoup.ScanHandler r18) throws java.io.IOException, org.xml.sax.SAXException {
        /*
            Method dump skipped, instructions count: 870
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.HTMLScanner.a(java.io.Reader, org.ccil.cowan.tagsoup.ScanHandler):void");
    }

    @Override // org.ccil.cowan.tagsoup.Scanner
    public void b(String str, String str2) {
        this.f52672a = str;
        this.f52673b = str2;
        this.f52677f = 0;
        this.f52676e = 0;
        this.f52675d = 0;
        this.f52674c = 0;
    }

    @Override // org.xml.sax.Locator
    public int getColumnNumber() {
        return this.f52675d;
    }

    @Override // org.xml.sax.Locator
    public int getLineNumber() {
        return this.f52674c;
    }

    @Override // org.xml.sax.Locator
    public String getPublicId() {
        return this.f52672a;
    }

    @Override // org.xml.sax.Locator
    public String getSystemId() {
        return this.f52673b;
    }

    @Override // org.ccil.cowan.tagsoup.Scanner
    public void startCDATA() {
        this.f52679h = 10;
    }
}
