package okhttp3.internal;

import com.google.android.gms.common.api.Api;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;

/* compiled from: Util.kt */
/* loaded from: classes5.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.10.0";

    static {
        String s02;
        String t02;
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.f52612i;
        ByteString.Companion companion2 = ByteString.f52591i;
        UNICODE_BOMS = companion.d(companion2.b("efbbbf"), companion2.b("feff"), companion2.b("fffe"), companion2.b("0000ffff"), companion2.b("ffff0000"));
        TimeZone timeZone = DesugarTimeZone.getTimeZone("GMT");
        Intrinsics.c(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        Intrinsics.e(name, "OkHttpClient::class.java.name");
        s02 = StringsKt__StringsKt.s0(name, "okhttp3.");
        t02 = StringsKt__StringsKt.t0(s02, "Client");
        okHttpName = t02;
    }

    public static final <E> void addIfAbsent(List<E> list, E e8) {
        Intrinsics.f(list, "<this>");
        if (!list.contains(e8)) {
            list.add(e8);
        }
    }

    public static final int and(byte b8, int i8) {
        return b8 & i8;
    }

    public static final int and(short s7, int i8) {
        return s7 & i8;
    }

    public static final long and(int i8, long j8) {
        return i8 & j8;
    }

    public static final EventListener.Factory asFactory(final EventListener eventListener) {
        Intrinsics.f(eventListener, "<this>");
        return new EventListener.Factory() { // from class: q7.b
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                EventListener m147asFactory$lambda8;
                m147asFactory$lambda8 = Util.m147asFactory$lambda8(EventListener.this, call);
                return m147asFactory$lambda8;
            }
        };
    }

    /* renamed from: asFactory$lambda-8 */
    public static final EventListener m147asFactory$lambda8(EventListener this_asFactory, Call it) {
        Intrinsics.f(this_asFactory, "$this_asFactory");
        Intrinsics.f(it, "it");
        return this_asFactory;
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        Intrinsics.f(obj, "<this>");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        Intrinsics.f(obj, "<this>");
        if (assertionsEnabled && !Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + obj);
        }
    }

    public static final boolean canParseAsIpAddress(String str) {
        Intrinsics.f(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.f(str);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl other) {
        Intrinsics.f(httpUrl, "<this>");
        Intrinsics.f(other, "other");
        if (Intrinsics.a(httpUrl.host(), other.host()) && httpUrl.port() == other.port() && Intrinsics.a(httpUrl.scheme(), other.scheme())) {
            return true;
        }
        return false;
    }

    public static final int checkDuration(String name, long j8, TimeUnit timeUnit) {
        boolean z7;
        boolean z8;
        boolean z9;
        Intrinsics.f(name, "name");
        boolean z10 = true;
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (timeUnit != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                long millis = timeUnit.toMillis(j8);
                if (millis <= 2147483647L) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z9) {
                    if (millis == 0 && i8 > 0) {
                        z10 = false;
                    }
                    if (z10) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException(Intrinsics.n(name, " too small.").toString());
                }
                throw new IllegalArgumentException(Intrinsics.n(name, " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException(Intrinsics.n(name, " < 0").toString());
    }

    public static final void checkOffsetAndCount(long j8, long j9, long j10) {
        if ((j9 | j10) >= 0 && j9 <= j8 && j8 - j9 >= j10) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final void closeQuietly(Closeable closeable) {
        Intrinsics.f(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e8) {
            throw e8;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String value) {
        int J;
        Intrinsics.f(strArr, "<this>");
        Intrinsics.f(value, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        J = ArraysKt___ArraysKt.J(strArr2);
        strArr2[J] = value;
        return strArr2;
    }

    public static final int delimiterOffset(String str, String delimiters, int i8, int i9) {
        boolean P;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(delimiters, "delimiters");
        while (i8 < i9) {
            int i10 = i8 + 1;
            P = StringsKt__StringsKt.P(delimiters, str.charAt(i8), false, 2, null);
            if (P) {
                return i8;
            }
            i8 = i10;
        }
        return i9;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = str.length();
        }
        return delimiterOffset(str, str2, i8, i9);
    }

    public static final boolean discard(Source source, int i8, TimeUnit timeUnit) {
        Intrinsics.f(source, "<this>");
        Intrinsics.f(timeUnit, "timeUnit");
        try {
            return skipAll(source, i8, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        List<T> k8;
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(predicate, "predicate");
        k8 = CollectionsKt__CollectionsKt.k();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (T) it.next();
            if (predicate.invoke(obj).booleanValue()) {
                if (k8.isEmpty()) {
                    k8 = new ArrayList<>();
                }
                TypeIntrinsics.c(k8).add(obj);
            }
        }
        return k8;
    }

    public static final String format(String format, Object... args) {
        Intrinsics.f(format, "format");
        Intrinsics.f(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.e(format2, "format(locale, format, *args)");
        return format2;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        boolean z7;
        boolean z8;
        Intrinsics.f(strArr, "<this>");
        Intrinsics.f(comparator, "comparator");
        if (strArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 && strArr2 != null) {
            if (strArr2.length == 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (!z8) {
                int length = strArr.length;
                int i8 = 0;
                while (i8 < length) {
                    String str = strArr[i8];
                    i8++;
                    Iterator a8 = ArrayIteratorKt.a(strArr2);
                    while (a8.hasNext()) {
                        if (comparator.compare(str, (String) a8.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        Intrinsics.f(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str == null) {
            return -1L;
        }
        return toLongOrDefault(str, -1L);
    }

    public static final void ignoreIoExceptions(Function0<Unit> block) {
        Intrinsics.f(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        List n8;
        Intrinsics.f(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        n8 = CollectionsKt__CollectionsKt.n(Arrays.copyOf(objArr, objArr.length));
        List<T> unmodifiableList = Collections.unmodifiableList(n8);
        Intrinsics.e(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(String[] strArr, String value, Comparator<String> comparator) {
        boolean z7;
        Intrinsics.f(strArr, "<this>");
        Intrinsics.f(value, "value");
        Intrinsics.f(comparator, "comparator");
        int length = strArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (comparator.compare(strArr[i8], value) == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                return i8;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        Intrinsics.f(str, "<this>");
        int length = str.length();
        int i8 = 0;
        while (i8 < length) {
            int i9 = i8 + 1;
            char charAt = str.charAt(i8);
            if (Intrinsics.h(charAt, 31) > 0 && Intrinsics.h(charAt, 127) < 0) {
                i8 = i9;
            } else {
                return i8;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i8, int i9) {
        boolean z7;
        boolean z8;
        boolean z9;
        Intrinsics.f(str, "<this>");
        while (i8 < i9) {
            int i10 = i8 + 1;
            char charAt = str.charAt(i8);
            boolean z10 = false;
            if (charAt == '\t' || charAt == '\n') {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 || charAt == '\f') {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8 || charAt == '\r') {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9 || charAt == ' ') {
                z10 = true;
            }
            if (z10) {
                i8 = i10;
            } else {
                return i8;
            }
        }
        return i9;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i8, i9);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i8, int i9) {
        boolean z7;
        boolean z8;
        boolean z9;
        Intrinsics.f(str, "<this>");
        int i10 = i9 - 1;
        if (i8 <= i10) {
            while (true) {
                int i11 = i10 - 1;
                char charAt = str.charAt(i10);
                boolean z10 = false;
                if (charAt == '\t' || charAt == '\n') {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7 || charAt == '\f') {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8 || charAt == '\r') {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z9 || charAt == ' ') {
                    z10 = true;
                }
                if (z10) {
                    if (i10 == i8) {
                        break;
                    }
                    i10 = i11;
                } else {
                    return i10 + 1;
                }
            }
        }
        return i8;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i8, i9);
    }

    public static final int indexOfNonWhitespace(String str, int i8) {
        Intrinsics.f(str, "<this>");
        int length = str.length();
        while (i8 < length) {
            int i9 = i8 + 1;
            char charAt = str.charAt(i8);
            if (charAt != ' ' && charAt != '\t') {
                return i8;
            }
            i8 = i9;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = 0;
        }
        return indexOfNonWhitespace(str, i8);
    }

    public static final String[] intersect(String[] strArr, String[] other, Comparator<? super String> comparator) {
        Intrinsics.f(strArr, "<this>");
        Intrinsics.f(other, "other");
        Intrinsics.f(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i8 = 0;
        while (i8 < length) {
            String str = strArr[i8];
            i8++;
            int length2 = other.length;
            int i9 = 0;
            while (true) {
                if (i9 < length2) {
                    String str2 = other[i9];
                    i9++;
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean isCivilized(FileSystem fileSystem, File file) {
        Intrinsics.f(fileSystem, "<this>");
        Intrinsics.f(file, "file");
        Sink sink = fileSystem.sink(file);
        try {
            try {
                fileSystem.delete(file);
                CloseableKt.a(sink, null);
                return true;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.a(sink, th);
                    throw th2;
                }
            }
        } catch (IOException unused) {
            Unit unit = Unit.f50853a;
            CloseableKt.a(sink, null);
            fileSystem.delete(file);
            return false;
        }
    }

    public static final boolean isHealthy(Socket socket, BufferedSource source) {
        Intrinsics.f(socket, "<this>");
        Intrinsics.f(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z7 = !source.y0();
                socket.setSoTimeout(soTimeout);
                return z7;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(String name) {
        boolean w7;
        boolean w8;
        boolean w9;
        boolean w10;
        Intrinsics.f(name, "name");
        w7 = StringsKt__StringsJVMKt.w(name, "Authorization", true);
        if (w7) {
            return true;
        }
        w8 = StringsKt__StringsJVMKt.w(name, "Cookie", true);
        if (w8) {
            return true;
        }
        w9 = StringsKt__StringsJVMKt.w(name, "Proxy-Authorization", true);
        if (w9) {
            return true;
        }
        w10 = StringsKt__StringsJVMKt.w(name, "Set-Cookie", true);
        if (w10) {
            return true;
        }
        return false;
    }

    public static final void notify(Object obj) {
        Intrinsics.f(obj, "<this>");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        Intrinsics.f(obj, "<this>");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c8) {
        boolean z7 = true;
        if ('0' <= c8 && c8 < ':') {
            return c8 - '0';
        }
        char c9 = 'a';
        if (!('a' <= c8 && c8 < 'g')) {
            c9 = 'A';
            if (!(('A' > c8 || c8 >= 'G') ? false : false)) {
                return -1;
            }
        }
        return (c8 - c9) + 10;
    }

    public static final String peerName(Socket socket) {
        Intrinsics.f(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
            Intrinsics.e(hostName, "address.hostName");
            return hostName;
        }
        return remoteSocketAddress.toString();
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        Intrinsics.f(bufferedSource, "<this>");
        Intrinsics.f(charset, "default");
        int k12 = bufferedSource.k1(UNICODE_BOMS);
        if (k12 != -1) {
            if (k12 != 0) {
                if (k12 != 1) {
                    if (k12 != 2) {
                        if (k12 != 3) {
                            if (k12 == 4) {
                                return Charsets.f51134a.b();
                            }
                            throw new AssertionError();
                        }
                        return Charsets.f51134a.a();
                    }
                    Charset UTF_16LE = StandardCharsets.UTF_16LE;
                    Intrinsics.e(UTF_16LE, "UTF_16LE");
                    return UTF_16LE;
                }
                Charset UTF_16BE = StandardCharsets.UTF_16BE;
                Intrinsics.e(UTF_16BE, "UTF_16BE");
                return UTF_16BE;
            }
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.e(UTF_8, "UTF_8");
            return UTF_8;
        }
        return charset;
    }

    public static final <T> T readFieldOrNull(Object instance, Class<T> fieldType, String fieldName) {
        T t7;
        Object readFieldOrNull;
        Intrinsics.f(instance, "instance");
        Intrinsics.f(fieldType, "fieldType");
        Intrinsics.f(fieldName, "fieldName");
        Class<?> cls = instance.getClass();
        while (true) {
            t7 = null;
            if (!Intrinsics.a(cls, Object.class)) {
                try {
                    Field declaredField = cls.getDeclaredField(fieldName);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(instance);
                    if (!fieldType.isInstance(obj)) {
                        break;
                    }
                    t7 = fieldType.cast(obj);
                    break;
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                    Intrinsics.e(cls, "c.superclass");
                }
            } else if (Intrinsics.a(fieldName, "delegate") || (readFieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                return null;
            } else {
                return (T) readFieldOrNull(readFieldOrNull, fieldType, fieldName);
            }
        }
        return t7;
    }

    public static final int readMedium(BufferedSource bufferedSource) throws IOException {
        Intrinsics.f(bufferedSource, "<this>");
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0051, code lost:
        if (r5 == Long.MAX_VALUE) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0053, code lost:
        r11.timeout().clearDeadline();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005b, code lost:
        r11.timeout().deadlineNanoTime(r0 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007e, code lost:
        if (r5 != Long.MAX_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0081, code lost:
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean skipAll(okio.Source r11, int r12, java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            java.lang.String r0 = "timeUnit"
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            long r0 = java.lang.System.nanoTime()
            okio.Timeout r2 = r11.timeout()
            boolean r2 = r2.hasDeadline()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L27
            okio.Timeout r2 = r11.timeout()
            long r5 = r2.deadlineNanoTime()
            long r5 = r5 - r0
            goto L28
        L27:
            r5 = r3
        L28:
            okio.Timeout r2 = r11.timeout()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.deadlineNanoTime(r12)
            okio.Buffer r12 = new okio.Buffer     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r12.<init>()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
        L3e:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.read(r12, r7)     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L4e
            r12.a()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            goto L3e
        L4e:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
        L53:
            okio.Timeout r11 = r11.timeout()
            r11.clearDeadline()
            goto L81
        L5b:
            okio.Timeout r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
            goto L81
        L64:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L71
            okio.Timeout r11 = r11.timeout()
            r11.clearDeadline()
            goto L79
        L71:
            okio.Timeout r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
        L79:
            throw r12
        L7a:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
            goto L53
        L81:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.skipAll(okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static final ThreadFactory threadFactory(final String name, final boolean z7) {
        Intrinsics.f(name, "name");
        return new ThreadFactory() { // from class: q7.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m148threadFactory$lambda1;
                m148threadFactory$lambda1 = Util.m148threadFactory$lambda1(name, z7, runnable);
                return m148threadFactory$lambda1;
            }
        };
    }

    /* renamed from: threadFactory$lambda-1 */
    public static final Thread m148threadFactory$lambda1(String name, boolean z7, Runnable runnable) {
        Intrinsics.f(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(z7);
        return thread;
    }

    public static final void threadName(String name, Function0<Unit> block) {
        Intrinsics.f(name, "name");
        Intrinsics.f(block, "block");
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            InlineMarker.b(1);
            currentThread.setName(name2);
            InlineMarker.a(1);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        IntRange o8;
        int v7;
        Intrinsics.f(headers, "<this>");
        o8 = RangesKt___RangesKt.o(0, headers.size());
        v7 = CollectionsKt__IterablesKt.v(o8, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<Integer> it = o8.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        Intrinsics.f(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().D(), header.component2().D());
        }
        return builder.build();
    }

    public static final String toHexString(long j8) {
        String hexString = Long.toHexString(j8);
        Intrinsics.e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z7) {
        boolean Q;
        String host;
        Intrinsics.f(httpUrl, "<this>");
        Q = StringsKt__StringsKt.Q(httpUrl.host(), ":", false, 2, null);
        if (Q) {
            host = '[' + httpUrl.host() + ']';
        } else {
            host = httpUrl.host();
        }
        if (z7 || httpUrl.port() != HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return host + ':' + httpUrl.port();
        }
        return host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return toHostHeader(httpUrl, z7);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        List J0;
        Intrinsics.f(list, "<this>");
        J0 = CollectionsKt___CollectionsKt.J0(list);
        List<T> unmodifiableList = Collections.unmodifiableList(J0);
        Intrinsics.e(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        Map<K, V> f8;
        Intrinsics.f(map, "<this>");
        if (map.isEmpty()) {
            f8 = MapsKt__MapsKt.f();
            return f8;
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics.e(unmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j8) {
        Intrinsics.f(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j8;
        }
    }

    public static final int toNonNegativeInt(String str, int i8) {
        Long valueOf;
        if (str == null) {
            valueOf = null;
        } else {
            try {
                valueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return i8;
            }
        }
        if (valueOf == null) {
            return i8;
        }
        long longValue = valueOf.longValue();
        if (longValue > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (longValue < 0) {
            return 0;
        }
        return (int) longValue;
    }

    public static final String trimSubstring(String str, int i8, int i9) {
        Intrinsics.f(str, "<this>");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i8, i9);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i9));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        return trimSubstring(str, i8, i9);
    }

    public static final void wait(Object obj) {
        Intrinsics.f(obj, "<this>");
        obj.wait();
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> suppressed) {
        Intrinsics.f(exc, "<this>");
        Intrinsics.f(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        for (Exception exc2 : suppressed) {
            ExceptionsKt__ExceptionsKt.a(exc, exc2);
        }
        return exc;
    }

    public static final void writeMedium(BufferedSink bufferedSink, int i8) throws IOException {
        Intrinsics.f(bufferedSink, "<this>");
        bufferedSink.writeByte((i8 >>> 16) & 255);
        bufferedSink.writeByte((i8 >>> 8) & 255);
        bufferedSink.writeByte(i8 & 255);
    }

    public static final int delimiterOffset(String str, char c8, int i8, int i9) {
        Intrinsics.f(str, "<this>");
        while (i8 < i9) {
            int i10 = i8 + 1;
            if (str.charAt(i8) == c8) {
                return i8;
            }
            i8 = i10;
        }
        return i9;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c8, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = str.length();
        }
        return delimiterOffset(str, c8, i8, i9);
    }

    public static final String toHexString(int i8) {
        String hexString = Integer.toHexString(i8);
        Intrinsics.e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final void closeQuietly(Socket socket) {
        Intrinsics.f(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e8) {
            throw e8;
        } catch (RuntimeException e9) {
            if (!Intrinsics.a(e9.getMessage(), "bio == null")) {
                throw e9;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        Intrinsics.f(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e8) {
            throw e8;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(Buffer buffer, byte b8) {
        Intrinsics.f(buffer, "<this>");
        int i8 = 0;
        while (!buffer.y0() && buffer.m(0L) == b8) {
            i8++;
            buffer.readByte();
        }
        return i8;
    }
}
