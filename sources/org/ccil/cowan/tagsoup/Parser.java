package org.ccil.cowan.tagsoup;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.Api;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes5.dex */
public class Parser extends DefaultHandler implements ScanHandler, XMLReader, LexicalHandler {
    private static boolean F = true;
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = true;
    private static boolean J = true;
    private static boolean K = false;
    private static boolean L = true;
    private static boolean M = false;
    private static boolean N = true;
    private static char[] O = {'<', '/', '>'};
    private static String P = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-'()+,./:=?;!*#@$_%";
    private Element A;
    private Element B;
    private int C;
    private boolean D;
    private char[] E;

    /* renamed from: f  reason: collision with root package name */
    private Schema f52688f;

    /* renamed from: g  reason: collision with root package name */
    private Scanner f52689g;

    /* renamed from: h  reason: collision with root package name */
    private AutoDetector f52690h;

    /* renamed from: r  reason: collision with root package name */
    private HashMap f52700r;

    /* renamed from: s  reason: collision with root package name */
    private Element f52701s;

    /* renamed from: t  reason: collision with root package name */
    private String f52702t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f52703u;

    /* renamed from: v  reason: collision with root package name */
    private String f52704v;

    /* renamed from: w  reason: collision with root package name */
    private String f52705w;

    /* renamed from: x  reason: collision with root package name */
    private String f52706x;

    /* renamed from: y  reason: collision with root package name */
    private String f52707y;

    /* renamed from: z  reason: collision with root package name */
    private Element f52708z;

    /* renamed from: a  reason: collision with root package name */
    private ContentHandler f52683a = this;

    /* renamed from: b  reason: collision with root package name */
    private LexicalHandler f52684b = this;

    /* renamed from: c  reason: collision with root package name */
    private DTDHandler f52685c = this;

    /* renamed from: d  reason: collision with root package name */
    private ErrorHandler f52686d = this;

    /* renamed from: e  reason: collision with root package name */
    private EntityResolver f52687e = this;

    /* renamed from: i  reason: collision with root package name */
    private boolean f52691i = F;

    /* renamed from: j  reason: collision with root package name */
    private boolean f52692j = G;

    /* renamed from: k  reason: collision with root package name */
    private boolean f52693k = H;

    /* renamed from: l  reason: collision with root package name */
    private boolean f52694l = I;

    /* renamed from: m  reason: collision with root package name */
    private boolean f52695m = J;

    /* renamed from: n  reason: collision with root package name */
    private boolean f52696n = K;

    /* renamed from: o  reason: collision with root package name */
    private boolean f52697o = L;

    /* renamed from: p  reason: collision with root package name */
    private boolean f52698p = M;

    /* renamed from: q  reason: collision with root package name */
    private boolean f52699q = N;

    public Parser() {
        HashMap hashMap = new HashMap();
        this.f52700r = hashMap;
        hashMap.put("http://xml.org/sax/features/namespaces", G(F));
        HashMap hashMap2 = this.f52700r;
        Boolean bool = Boolean.FALSE;
        hashMap2.put("http://xml.org/sax/features/namespace-prefixes", bool);
        this.f52700r.put("http://xml.org/sax/features/external-general-entities", bool);
        this.f52700r.put("http://xml.org/sax/features/external-parameter-entities", bool);
        this.f52700r.put("http://xml.org/sax/features/is-standalone", bool);
        this.f52700r.put("http://xml.org/sax/features/lexical-handler/parameter-entities", bool);
        HashMap hashMap3 = this.f52700r;
        Boolean bool2 = Boolean.TRUE;
        hashMap3.put("http://xml.org/sax/features/resolve-dtd-uris", bool2);
        this.f52700r.put("http://xml.org/sax/features/string-interning", bool2);
        this.f52700r.put("http://xml.org/sax/features/use-attributes2", bool);
        this.f52700r.put("http://xml.org/sax/features/use-locator2", bool);
        this.f52700r.put("http://xml.org/sax/features/use-entity-resolver2", bool);
        this.f52700r.put("http://xml.org/sax/features/validation", bool);
        this.f52700r.put("http://xml.org/sax/features/xmlns-uris", bool);
        this.f52700r.put("http://xml.org/sax/features/xmlns-uris", bool);
        this.f52700r.put("http://xml.org/sax/features/xml-1.1", bool);
        this.f52700r.put("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons", G(G));
        this.f52700r.put("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty", G(H));
        this.f52700r.put("http://www.ccil.org/~cowan/tagsoup/features/root-bogons", G(I));
        this.f52700r.put("http://www.ccil.org/~cowan/tagsoup/features/default-attributes", G(J));
        this.f52700r.put("http://www.ccil.org/~cowan/tagsoup/features/translate-colons", G(K));
        this.f52700r.put("http://www.ccil.org/~cowan/tagsoup/features/restart-elements", G(L));
        this.f52700r.put("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace", G(M));
        this.f52700r.put("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements", G(N));
        this.f52701s = null;
        this.f52702t = null;
        this.f52703u = false;
        this.f52704v = null;
        this.f52705w = null;
        this.f52706x = null;
        this.f52707y = null;
        this.f52708z = null;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.D = true;
        this.E = new char[CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE];
    }

    private void A(Element element) throws SAXException {
        Element element2;
        ElementType l8;
        while (true) {
            element2 = this.f52708z;
            while (element2 != null && !element2.c(element)) {
                element2 = element2.k();
            }
            if (element2 == null && (l8 = element.l()) != null) {
                Element element3 = new Element(l8, this.f52695m);
                element3.o(element);
                element = element3;
            }
        }
        if (element2 == null) {
            return;
        }
        while (true) {
            Element element4 = this.f52708z;
            if (element4 == element2 || element4 == null || element4.k() == null || this.f52708z.k().k() == null) {
                break;
            }
            C();
        }
        while (element != null) {
            Element k8 = element.k();
            if (!element.i().equals("<pcdata>")) {
                z(element);
            }
            B(k8);
            element = k8;
        }
        this.f52701s = null;
    }

    private void B(Element element) throws SAXException {
        while (true) {
            Element element2 = this.A;
            if (element2 != null && this.f52708z.c(element2)) {
                if (element == null || this.A.c(element)) {
                    Element k8 = this.A.k();
                    z(this.A);
                    this.A = k8;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void C() throws SAXException {
        Element element = this.f52708z;
        x();
        if (this.f52697o && (element.e() & 1) != 0) {
            element.a();
            element.o(this.A);
            this.A = element;
        }
    }

    private void D() {
        if (this.f52688f == null) {
            this.f52688f = new HTMLSchema();
        }
        if (this.f52689g == null) {
            this.f52689g = new HTMLScanner();
        }
        if (this.f52690h == null) {
            this.f52690h = new AutoDetector() { // from class: org.ccil.cowan.tagsoup.Parser.1
                @Override // org.ccil.cowan.tagsoup.AutoDetector
                public Reader a(InputStream inputStream) {
                    return new InputStreamReader(inputStream);
                }
            };
        }
        this.f52708z = new Element(this.f52688f.d("<root>"), this.f52695m);
        this.B = new Element(this.f52688f.d("<pcdata>"), this.f52695m);
        this.f52701s = null;
        this.f52702t = null;
        this.f52707y = null;
        this.A = null;
        this.C = 0;
        this.D = true;
        this.f52705w = null;
        this.f52704v = null;
        this.f52706x = null;
    }

    private static String[] E(String str) throws IllegalArgumentException {
        String trim = str.trim();
        if (trim.length() == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = trim.length();
        int i8 = 0;
        int i9 = 0;
        boolean z7 = false;
        char c8 = 0;
        boolean z8 = false;
        while (i8 < length) {
            char charAt = trim.charAt(i8);
            if (!z7 && charAt == '\'' && c8 != '\\') {
                z8 = !z8;
                if (i9 >= 0) {
                    i8++;
                    c8 = charAt;
                }
                i9 = i8;
                i8++;
                c8 = charAt;
            } else if (!z8 && charAt == '\"' && c8 != '\\') {
                z7 = !z7;
                if (i9 >= 0) {
                    i8++;
                    c8 = charAt;
                }
                i9 = i8;
                i8++;
                c8 = charAt;
            } else {
                if (!z8 && !z7) {
                    if (Character.isWhitespace(charAt)) {
                        if (i9 >= 0) {
                            arrayList.add(trim.substring(i9, i8));
                        }
                        i9 = -1;
                    } else if (i9 < 0) {
                        if (charAt == ' ') {
                        }
                        i9 = i8;
                    }
                }
                i8++;
                c8 = charAt;
            }
        }
        arrayList.add(trim.substring(i9, i8));
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static String F(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if (charAt == str.charAt(length - 1)) {
            if (charAt == '\'' || charAt == '\"') {
                return str.substring(1, str.length() - 1);
            }
            return str;
        }
        return str;
    }

    private static Boolean G(boolean z7) {
        if (z7) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private String o(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        boolean z7 = true;
        for (int i8 = 0; i8 < length; i8++) {
            char charAt = str.charAt(i8);
            if (P.indexOf(charAt) != -1) {
                stringBuffer.append(charAt);
                z7 = false;
            } else if (!z7) {
                stringBuffer.append(' ');
                z7 = true;
            }
        }
        return stringBuffer.toString().trim();
    }

    private String r(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i8 = 0;
        int i9 = -1;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            int i11 = i8 + 1;
            cArr[i8] = charAt;
            if (charAt == '&' && i9 == -1) {
                i8 = i11;
                i9 = i8;
            } else if (i9 != -1 && !Character.isLetter(charAt) && !Character.isDigit(charAt) && charAt != '#') {
                if (charAt == ';') {
                    int v7 = v(cArr, i9, (i11 - i9) - 1);
                    if (v7 > 65535) {
                        int i12 = v7 - 65536;
                        cArr[i9 - 1] = (char) ((i12 >> 10) + 55296);
                        cArr[i9] = (char) ((i12 & 1023) + 56320);
                        i9++;
                    } else if (v7 != 0) {
                        cArr[i9 - 1] = (char) v7;
                    } else {
                        i9 = i11;
                    }
                    i8 = i9;
                } else {
                    i8 = i11;
                }
                i9 = -1;
            } else {
                i8 = i11;
            }
        }
        return new String(cArr, 0, i8);
    }

    private boolean s(String str, String str2) {
        if (!str.equals("") && !str2.equals("") && !str2.equals(this.f52688f.g())) {
            return true;
        }
        return false;
    }

    private InputStream t(String str, String str2) throws IOException, SAXException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(System.getProperty("user.dir"));
        stringBuffer.append("/.");
        return ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(new URL("file", "", stringBuffer.toString()), str2).openConnection())).getInputStream();
    }

    private Reader u(InputSource inputSource) throws SAXException, IOException {
        Reader characterStream = inputSource.getCharacterStream();
        InputStream byteStream = inputSource.getByteStream();
        String encoding = inputSource.getEncoding();
        String publicId = inputSource.getPublicId();
        String systemId = inputSource.getSystemId();
        if (characterStream == null) {
            if (byteStream == null) {
                byteStream = t(publicId, systemId);
            }
            if (encoding == null) {
                return this.f52690h.a(byteStream);
            }
            try {
                return new InputStreamReader(byteStream, encoding);
            } catch (UnsupportedEncodingException unused) {
                return new InputStreamReader(byteStream);
            }
        }
        return characterStream;
    }

    private int v(char[] cArr, int i8, int i9) {
        char c8;
        if (i9 < 1) {
            return 0;
        }
        if (cArr[i8] == '#') {
            if (i9 > 1 && ((c8 = cArr[i8 + 1]) == 'x' || c8 == 'X')) {
                try {
                    return Integer.parseInt(new String(cArr, i8 + 2, i9 - 2), 16);
                } catch (NumberFormatException unused) {
                    return 0;
                }
            }
            try {
                return Integer.parseInt(new String(cArr, i8 + 1, i9 - 1), 10);
            } catch (NumberFormatException unused2) {
                return 0;
            }
        }
        return this.f52688f.e(new String(cArr, i8, i9));
    }

    private String w(char[] cArr, int i8, int i9) {
        StringBuffer stringBuffer = new StringBuffer(i9 + 2);
        boolean z7 = true;
        boolean z8 = false;
        while (true) {
            int i10 = i9 - 1;
            char c8 = '_';
            if (i9 <= 0) {
                break;
            }
            char c9 = cArr[i8];
            if (!Character.isLetter(c9) && c9 != '_') {
                if (!Character.isDigit(c9) && c9 != '-' && c9 != '.') {
                    if (c9 == ':' && !z8) {
                        if (z7) {
                            stringBuffer.append('_');
                        }
                        if (!this.f52696n) {
                            c8 = c9;
                        }
                        stringBuffer.append(c8);
                        z7 = true;
                        z8 = true;
                    }
                    i8++;
                    i9 = i10;
                } else {
                    if (z7) {
                        stringBuffer.append('_');
                    }
                    stringBuffer.append(c9);
                }
            } else {
                stringBuffer.append(c9);
            }
            z7 = false;
            i8++;
            i9 = i10;
        }
        int length = stringBuffer.length();
        if (length == 0 || stringBuffer.charAt(length - 1) == ':') {
            stringBuffer.append('_');
        }
        return stringBuffer.toString().intern();
    }

    private void x() throws SAXException {
        Element element = this.f52708z;
        if (element == null) {
            return;
        }
        String i8 = element.i();
        String g8 = this.f52708z.g();
        String j8 = this.f52708z.j();
        String y7 = y(i8);
        if (!this.f52691i) {
            g8 = "";
            j8 = "";
        }
        this.f52683a.endElement(j8, g8, i8);
        if (s(y7, j8)) {
            this.f52683a.endPrefixMapping(y7);
        }
        AttributesImpl b8 = this.f52708z.b();
        for (int length = b8.getLength() - 1; length >= 0; length--) {
            String uri = b8.getURI(length);
            String y8 = y(b8.getQName(length));
            if (s(y8, uri)) {
                this.f52683a.endPrefixMapping(y8);
            }
        }
        this.f52708z = this.f52708z.k();
    }

    private String y(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return "";
    }

    private void z(Element element) throws SAXException {
        String i8 = element.i();
        String g8 = element.g();
        String j8 = element.j();
        String y7 = y(i8);
        element.d();
        if (!this.f52691i) {
            g8 = "";
            j8 = "";
        }
        if (this.D && g8.equalsIgnoreCase(this.f52706x)) {
            try {
                this.f52687e.resolveEntity(this.f52704v, this.f52705w);
            } catch (IOException unused) {
            }
        }
        if (s(y7, j8)) {
            this.f52683a.startPrefixMapping(y7, j8);
        }
        AttributesImpl b8 = element.b();
        int length = b8.getLength();
        for (int i9 = 0; i9 < length; i9++) {
            String uri = b8.getURI(i9);
            String y8 = y(b8.getQName(i9));
            if (s(y8, uri)) {
                this.f52683a.startPrefixMapping(y8, uri);
            }
        }
        this.f52683a.startElement(j8, g8, i8, element.b());
        element.o(this.f52708z);
        this.f52708z = element;
        this.D = false;
        if (this.f52699q && (element.e() & 2) != 0) {
            this.f52689g.startCDATA();
        }
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void a(char[] cArr, int i8, int i9) throws SAXException {
        if (this.f52701s != null) {
            return;
        }
        this.f52707y = w(cArr, i8, i9).replace(':', '_');
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void b(char[] cArr, int i8, int i9) throws SAXException {
        this.C = v(cArr, i8, i9);
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void c(char[] cArr, int i8, int i9) throws SAXException {
        String str;
        Element element = this.f52701s;
        if (element != null && (str = this.f52702t) != null) {
            element.n(str, null, str);
            this.f52702t = null;
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i8, int i9) throws SAXException {
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void d(char[] cArr, int i8, int i9) throws SAXException {
        if (this.f52701s != null && this.f52702t != null) {
            this.f52701s.n(this.f52702t, null, r(new String(cArr, i8, i9)));
            this.f52702t = null;
        }
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void e(char[] cArr, int i8, int i9) throws SAXException {
        String w7;
        int i10;
        if (this.f52701s != null || (w7 = w(cArr, i8, i9)) == null) {
            return;
        }
        ElementType d8 = this.f52688f.d(w7);
        if (d8 == null) {
            if (this.f52692j) {
                return;
            }
            int i11 = -1;
            if (this.f52693k) {
                i10 = 0;
            } else {
                i10 = -1;
            }
            if (!this.f52694l) {
                i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            this.f52688f.b(w7, i10, i11, 0);
            if (!this.f52694l) {
                Schema schema = this.f52688f;
                schema.h(w7, schema.i().g());
            }
            d8 = this.f52688f.d(w7);
        }
        this.f52701s = new Element(d8, this.f52695m);
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() throws SAXException {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() throws SAXException {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) throws SAXException {
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void f(char[] cArr, int i8, int i9) throws SAXException {
        if (i9 == 0) {
            return;
        }
        boolean z7 = true;
        for (int i10 = 0; i10 < i9; i10++) {
            if (!Character.isWhitespace(cArr[i8 + i10])) {
                z7 = false;
            }
        }
        if (z7 && !this.f52708z.c(this.B)) {
            if (this.f52698p) {
                this.f52683a.ignorableWhitespace(cArr, i8, i9);
                return;
            }
            return;
        }
        A(this.B);
        this.f52683a.characters(cArr, i8, i9);
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void g(char[] cArr, int i8, int i9) throws SAXException {
        Element element = this.f52701s;
        if (element == null) {
            return;
        }
        A(element);
        p(cArr, i8, i9);
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        ContentHandler contentHandler = this.f52683a;
        if (contentHandler == this) {
            return null;
        }
        return contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        DTDHandler dTDHandler = this.f52685c;
        if (dTDHandler == this) {
            return null;
        }
        return dTDHandler;
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public int getEntity() {
        return this.C;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        EntityResolver entityResolver = this.f52687e;
        if (entityResolver == this) {
            return null;
        }
        return entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        ErrorHandler errorHandler = this.f52686d;
        if (errorHandler == this) {
            return null;
        }
        return errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        Boolean bool = (Boolean) this.f52700r.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unknown feature ");
        stringBuffer.append(str);
        throw new SAXNotRecognizedException(stringBuffer.toString());
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
            LexicalHandler lexicalHandler = this.f52684b;
            if (lexicalHandler == this) {
                return null;
            }
            return lexicalHandler;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner")) {
            return this.f52689g;
        } else {
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema")) {
                return this.f52688f;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector")) {
                return this.f52690h;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unknown property ");
            stringBuffer.append(str);
            throw new SAXNotRecognizedException(stringBuffer.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // org.ccil.cowan.tagsoup.ScanHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(char[] r5, int r6, int r7) throws org.xml.sax.SAXException {
        /*
            r4 = this;
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r6, r7)
            java.lang.String[] r5 = E(r0)
            int r6 = r5.length
            r7 = 0
            if (r6 <= 0) goto L52
            r6 = 0
            r6 = r5[r6]
            java.lang.String r0 = "DOCTYPE"
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 == 0) goto L52
            boolean r6 = r4.f52703u
            if (r6 == 0) goto L1d
            return
        L1d:
            r6 = 1
            r4.f52703u = r6
            int r0 = r5.length
            if (r0 <= r6) goto L52
            r6 = r5[r6]
            int r0 = r5.length
            r1 = 2
            r2 = 3
            if (r0 <= r2) goto L37
            r0 = r5[r1]
            java.lang.String r3 = "SYSTEM"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L37
            r5 = r5[r2]
            goto L54
        L37:
            int r0 = r5.length
            if (r0 <= r2) goto L50
            r0 = r5[r1]
            java.lang.String r1 = "PUBLIC"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L50
            r7 = r5[r2]
            int r0 = r5.length
            r1 = 4
            if (r0 <= r1) goto L4d
            r5 = r5[r1]
            goto L54
        L4d:
            java.lang.String r5 = ""
            goto L54
        L50:
            r5 = r7
            goto L54
        L52:
            r5 = r7
            r6 = r5
        L54:
            java.lang.String r7 = F(r7)
            java.lang.String r5 = F(r5)
            if (r6 == 0) goto L90
            java.lang.String r7 = r4.o(r7)
            org.xml.sax.ext.LexicalHandler r0 = r4.f52684b
            r0.startDTD(r6, r7, r5)
            org.xml.sax.ext.LexicalHandler r0 = r4.f52684b
            r0.endDTD()
            r4.f52706x = r6
            r4.f52704v = r7
            org.ccil.cowan.tagsoup.Scanner r6 = r4.f52689g
            boolean r7 = r6 instanceof org.xml.sax.Locator
            if (r7 == 0) goto L90
            org.xml.sax.Locator r6 = (org.xml.sax.Locator) r6
            java.lang.String r6 = r6.getSystemId()
            r4.f52705w = r6
            java.net.URL r6 = new java.net.URL     // Catch: java.lang.Exception -> L90
            java.net.URL r7 = new java.net.URL     // Catch: java.lang.Exception -> L90
            java.lang.String r0 = r4.f52705w     // Catch: java.lang.Exception -> L90
            r7.<init>(r0)     // Catch: java.lang.Exception -> L90
            r6.<init>(r7, r5)     // Catch: java.lang.Exception -> L90
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Exception -> L90
            r4.f52705w = r5     // Catch: java.lang.Exception -> L90
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.Parser.h(char[], int, int):void");
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void i(char[] cArr, int i8, int i9) throws SAXException {
        if (this.D) {
            A(this.B);
        }
        while (this.f52708z.k() != null) {
            x();
        }
        if (!this.f52688f.g().equals("")) {
            this.f52683a.endPrefixMapping(this.f52688f.f());
        }
        this.f52683a.endDocument();
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void j(char[] cArr, int i8, int i9) throws SAXException {
        String str;
        if (this.f52701s != null || (str = this.f52707y) == null || "xml".equalsIgnoreCase(str)) {
            return;
        }
        if (i9 > 0 && cArr[i9 - 1] == '?') {
            i9--;
        }
        this.f52683a.processingInstruction(this.f52707y, new String(cArr, i8, i9));
        this.f52707y = null;
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void k(char[] cArr, int i8, int i9) throws SAXException {
        if (q(cArr, i8, i9)) {
            return;
        }
        p(cArr, i8, i9);
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void l(char[] cArr, int i8, int i9) throws SAXException {
        this.f52684b.comment(cArr, i8, i9);
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void m(char[] cArr, int i8, int i9) throws SAXException {
        if (this.f52701s == null) {
            return;
        }
        this.f52702t = w(cArr, i8, i9).toLowerCase();
    }

    @Override // org.ccil.cowan.tagsoup.ScanHandler
    public void n(char[] cArr, int i8, int i9) throws SAXException {
        Element element = this.f52701s;
        if (element == null) {
            return;
        }
        A(element);
        if (this.f52708z.h() == 0) {
            p(cArr, i8, i9);
        }
    }

    public void p(char[] cArr, int i8, int i9) throws SAXException {
        String i10;
        this.f52701s = null;
        if (i9 != 0) {
            ElementType d8 = this.f52688f.d(w(cArr, i8, i9));
            if (d8 == null) {
                return;
            }
            i10 = d8.g();
        } else {
            i10 = this.f52708z.i();
        }
        boolean z7 = false;
        Element element = this.f52708z;
        while (element != null && !element.i().equals(i10)) {
            if ((element.e() & 4) != 0) {
                z7 = true;
            }
            element = element.k();
        }
        if (element != null && element.k() != null && element.k().k() != null) {
            if (z7) {
                element.m();
            } else {
                while (this.f52708z != element) {
                    C();
                }
                x();
            }
            while (this.f52708z.f()) {
                x();
            }
            B(null);
        }
    }

    @Override // org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws IOException, SAXException {
        D();
        Reader u7 = u(inputSource);
        this.f52683a.startDocument();
        this.f52689g.b(inputSource.getPublicId(), inputSource.getSystemId());
        Scanner scanner = this.f52689g;
        if (scanner instanceof Locator) {
            this.f52683a.setDocumentLocator((Locator) scanner);
        }
        if (!this.f52688f.g().equals("")) {
            this.f52683a.startPrefixMapping(this.f52688f.f(), this.f52688f.g());
        }
        this.f52689g.a(u7, this);
    }

    public boolean q(char[] cArr, int i8, int i9) throws SAXException {
        boolean z7;
        String i10 = this.f52708z.i();
        if (this.f52699q && (this.f52708z.e() & 2) != 0) {
            if (i9 == i10.length()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                int i11 = 0;
                while (true) {
                    if (i11 >= i9) {
                        break;
                    } else if (Character.toLowerCase(cArr[i8 + i11]) != Character.toLowerCase(i10.charAt(i11))) {
                        z7 = false;
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            if (!z7) {
                this.f52683a.characters(O, 0, 2);
                this.f52683a.characters(cArr, i8, i9);
                this.f52683a.characters(O, 2, 1);
                this.f52689g.startCDATA();
                return true;
            }
        }
        return false;
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        if (contentHandler == null) {
            contentHandler = this;
        }
        this.f52683a = contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        if (dTDHandler == null) {
            dTDHandler = this;
        }
        this.f52685c = dTDHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        if (entityResolver == null) {
            entityResolver = this;
        }
        this.f52687e = entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            errorHandler = this;
        }
        this.f52686d = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z7) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (((Boolean) this.f52700r.get(str)) != null) {
            if (z7) {
                this.f52700r.put(str, Boolean.TRUE);
            } else {
                this.f52700r.put(str, Boolean.FALSE);
            }
            if (str.equals("http://xml.org/sax/features/namespaces")) {
                this.f52691i = z7;
                return;
            } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons")) {
                this.f52692j = z7;
                return;
            } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty")) {
                this.f52693k = z7;
                return;
            } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/root-bogons")) {
                this.f52694l = z7;
                return;
            } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/default-attributes")) {
                this.f52695m = z7;
                return;
            } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/translate-colons")) {
                this.f52696n = z7;
                return;
            } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/restart-elements")) {
                this.f52697o = z7;
                return;
            } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace")) {
                this.f52698p = z7;
                return;
            } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements")) {
                this.f52699q = z7;
                return;
            } else {
                return;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unknown feature ");
        stringBuffer.append(str);
        throw new SAXNotRecognizedException(stringBuffer.toString());
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
            if (obj == null) {
                this.f52684b = this;
            } else if (obj instanceof LexicalHandler) {
                this.f52684b = (LexicalHandler) obj;
            } else {
                throw new SAXNotSupportedException("Your lexical handler is not a LexicalHandler");
            }
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner")) {
            if (obj instanceof Scanner) {
                this.f52689g = (Scanner) obj;
                return;
            }
            throw new SAXNotSupportedException("Your scanner is not a Scanner");
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema")) {
            if (obj instanceof Schema) {
                this.f52688f = (Schema) obj;
                return;
            }
            throw new SAXNotSupportedException("Your schema is not a Schema");
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector")) {
            if (obj instanceof AutoDetector) {
                this.f52690h = (AutoDetector) obj;
                return;
            }
            throw new SAXNotSupportedException("Your auto-detector is not an AutoDetector");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unknown property ");
            stringBuffer.append(str);
            throw new SAXNotRecognizedException(stringBuffer.toString());
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() throws SAXException {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) throws SAXException {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) throws SAXException {
    }

    @Override // org.xml.sax.XMLReader
    public void parse(String str) throws IOException, SAXException {
        parse(new InputSource(str));
    }
}
