package okhttp3;

import j$.time.Instant;
import j$.util.DateRetargetClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: Headers.kt */
/* loaded from: classes5.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    /* compiled from: Headers.kt */
    /* loaded from: classes5.dex */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String line) {
            int a02;
            CharSequence Y0;
            Intrinsics.f(line, "line");
            a02 = StringsKt__StringsKt.a0(line, ':', 0, false, 6, null);
            if (a02 != -1) {
                String substring = line.substring(0, a02);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                Y0 = StringsKt__StringsKt.Y0(substring);
                String obj = Y0.toString();
                String substring2 = line.substring(a02 + 1);
                Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
                add(obj, substring2);
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("Unexpected header: ", line).toString());
        }

        public final Builder addAll(Headers headers) {
            Intrinsics.f(headers, "headers");
            int size = headers.size();
            for (int i8 = 0; i8 < size; i8++) {
                addLenient$okhttp(headers.name(i8), headers.value(i8));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String line) {
            int a02;
            Intrinsics.f(line, "line");
            a02 = StringsKt__StringsKt.a0(line, ':', 1, false, 4, null);
            if (a02 != -1) {
                String substring = line.substring(0, a02);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = line.substring(a02 + 1);
                Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else if (line.charAt(0) == ':') {
                String substring3 = line.substring(1);
                Intrinsics.e(substring3, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", substring3);
            } else {
                addLenient$okhttp("", line);
            }
            return this;
        }

        public final Builder addUnsafeNonAscii(String name, String value) {
            Intrinsics.f(name, "name");
            Intrinsics.f(value, "value");
            Headers.Companion.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final String get(String name) {
            boolean w7;
            Intrinsics.f(name, "name");
            int size = this.namesAndValues.size() - 2;
            int c8 = ProgressionUtilKt.c(size, 0, -2);
            if (c8 > size) {
                return null;
            }
            while (true) {
                int i8 = size - 2;
                w7 = StringsKt__StringsJVMKt.w(name, this.namesAndValues.get(size), true);
                if (w7) {
                    return this.namesAndValues.get(size + 1);
                }
                if (size != c8) {
                    size = i8;
                } else {
                    return null;
                }
            }
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String name) {
            boolean w7;
            Intrinsics.f(name, "name");
            int i8 = 0;
            while (i8 < getNamesAndValues$okhttp().size()) {
                w7 = StringsKt__StringsJVMKt.w(name, getNamesAndValues$okhttp().get(i8), true);
                if (w7) {
                    getNamesAndValues$okhttp().remove(i8);
                    getNamesAndValues$okhttp().remove(i8);
                    i8 -= 2;
                }
                i8 += 2;
            }
            return this;
        }

        public final Builder set(String name, Date value) {
            Intrinsics.f(name, "name");
            Intrinsics.f(value, "value");
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder set(String name, Instant value) {
            Intrinsics.f(name, "name");
            Intrinsics.f(value, "value");
            return set(name, new Date(value.toEpochMilli()));
        }

        public final Builder set(String name, String value) {
            Intrinsics.f(name, "name");
            Intrinsics.f(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Builder add(String name, String value) {
            Intrinsics.f(name, "name");
            Intrinsics.f(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Builder addLenient$okhttp(String name, String value) {
            CharSequence Y0;
            Intrinsics.f(name, "name");
            Intrinsics.f(value, "value");
            getNamesAndValues$okhttp().add(name);
            List<String> namesAndValues$okhttp = getNamesAndValues$okhttp();
            Y0 = StringsKt__StringsKt.Y0(value);
            namesAndValues$okhttp.add(Y0.toString());
            return this;
        }

        public final Builder add(String name, Date value) {
            Intrinsics.f(name, "name");
            Intrinsics.f(value, "value");
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder add(String name, Instant value) {
            Intrinsics.f(name, "name");
            Intrinsics.f(value, "value");
            add(name, new Date(value.toEpochMilli()));
            return this;
        }
    }

    /* compiled from: Headers.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            boolean z7;
            boolean z8;
            if (str.length() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                int length = str.length();
                int i8 = 0;
                while (i8 < length) {
                    int i9 = i8 + 1;
                    char charAt = str.charAt(i8);
                    if ('!' <= charAt && charAt < 127) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        i8 = i9;
                    } else {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i8), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005b A[LOOP:0: B:3:0x0006->B:23:0x005b, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0026 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void checkValue(java.lang.String r8, java.lang.String r9) {
            /*
                r7 = this;
                int r0 = r8.length()
                r1 = 0
                r2 = 0
            L6:
                if (r2 >= r0) goto L5d
                int r3 = r2 + 1
                char r4 = r8.charAt(r2)
                r5 = 9
                r6 = 1
                if (r4 == r5) goto L23
                r5 = 32
                if (r5 > r4) goto L1d
                r5 = 127(0x7f, float:1.78E-43)
                if (r4 >= r5) goto L1d
                r5 = 1
                goto L1e
            L1d:
                r5 = 0
            L1e:
                if (r5 == 0) goto L21
                goto L23
            L21:
                r5 = 0
                goto L24
            L23:
                r5 = 1
            L24:
                if (r5 != 0) goto L5b
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
                r0[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r0[r6] = r1
                r1 = 2
                r0[r1] = r9
                java.lang.String r1 = "Unexpected char %#04x at %d in %s value"
                java.lang.String r0 = okhttp3.internal.Util.format(r1, r0)
                boolean r9 = okhttp3.internal.Util.isSensitiveHeader(r9)
                if (r9 == 0) goto L47
                java.lang.String r8 = ""
                goto L4d
            L47:
                java.lang.String r9 = ": "
                java.lang.String r8 = kotlin.jvm.internal.Intrinsics.n(r9, r8)
            L4d:
                java.lang.String r8 = kotlin.jvm.internal.Intrinsics.n(r0, r8)
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.String r8 = r8.toString()
                r9.<init>(r8)
                throw r9
            L5b:
                r2 = r3
                goto L6
            L5d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Headers.Companion.checkValue(java.lang.String, java.lang.String):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            boolean w7;
            int length = strArr.length - 2;
            int c8 = ProgressionUtilKt.c(length, 0, -2);
            if (c8 > length) {
                return null;
            }
            while (true) {
                int i8 = length - 2;
                w7 = StringsKt__StringsJVMKt.w(str, strArr[length], true);
                if (w7) {
                    return strArr[length + 1];
                }
                if (length != c8) {
                    length = i8;
                } else {
                    return null;
                }
            }
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m63deprecated_of(String... namesAndValues) {
            Intrinsics.f(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        public final Headers of(String... namesAndValues) {
            CharSequence Y0;
            Intrinsics.f(namesAndValues, "namesAndValues");
            int i8 = 0;
            if (namesAndValues.length % 2 == 0) {
                String[] strArr = (String[]) namesAndValues.clone();
                int length = strArr.length;
                int i9 = 0;
                while (i9 < length) {
                    int i10 = i9 + 1;
                    String str = strArr[i9];
                    if (str != null) {
                        Y0 = StringsKt__StringsKt.Y0(str);
                        strArr[i9] = Y0.toString();
                        i9 = i10;
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                }
                int c8 = ProgressionUtilKt.c(0, strArr.length - 1, 2);
                if (c8 >= 0) {
                    while (true) {
                        int i11 = i8 + 2;
                        String str2 = strArr[i8];
                        String str3 = strArr[i8 + 1];
                        checkName(str2);
                        checkValue(str3, str2);
                        if (i8 == c8) {
                            break;
                        }
                        i8 = i11;
                    }
                }
                return new Headers(strArr, null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m62deprecated_of(Map<String, String> headers) {
            Intrinsics.f(headers, "headers");
            return of(headers);
        }

        public final Headers of(Map<String, String> map) {
            CharSequence Y0;
            CharSequence Y02;
            Intrinsics.f(map, "<this>");
            String[] strArr = new String[map.size() * 2];
            int i8 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Y0 = StringsKt__StringsKt.Y0(entry.getKey());
                String obj = Y0.toString();
                Y02 = StringsKt__StringsKt.Y0(entry.getValue());
                String obj2 = Y02.toString();
                checkName(obj);
                checkValue(obj2, obj);
                strArr[i8] = obj;
                strArr[i8 + 1] = obj2;
                i8 += 2;
            }
            return new Headers(strArr, null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public /* synthetic */ Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m61deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i8 = 0; i8 < strArr.length; i8++) {
            length += this.namesAndValues[i8].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues)) {
            return true;
        }
        return false;
    }

    public final String get(String name) {
        Intrinsics.f(name, "name");
        return Companion.get(this.namesAndValues, name);
    }

    public final Date getDate(String name) {
        Intrinsics.f(name, "name");
        String str = get(name);
        if (str == null) {
            return null;
        }
        return DatesKt.toHttpDateOrNull(str);
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String name) {
        Intrinsics.f(name, "name");
        Date date = getDate(name);
        if (date == null) {
            return null;
        }
        return DateRetargetClass.toInstant(date);
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i8 = 0; i8 < size; i8++) {
            pairArr[i8] = TuplesKt.a(name(i8), value(i8));
        }
        return ArrayIteratorKt.a(pairArr);
    }

    public final String name(int i8) {
        return this.namesAndValues[i8 * 2];
    }

    public final Set<String> names() {
        Comparator x7;
        x7 = StringsKt__StringsJVMKt.x(StringCompanionObject.f51021a);
        TreeSet treeSet = new TreeSet(x7);
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            treeSet.add(name(i8));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        Intrinsics.e(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        CollectionsKt__MutableCollectionsKt.C(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        Comparator x7;
        x7 = StringsKt__StringsJVMKt.x(StringCompanionObject.f51021a);
        TreeMap treeMap = new TreeMap(x7);
        int size = size();
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            String name = name(i8);
            Locale US = Locale.US;
            Intrinsics.e(US, "US");
            String lowerCase = name.toLowerCase(US);
            Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i8));
            i8 = i9;
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            String name = name(i8);
            String value = value(i8);
            sb.append(name);
            sb.append(": ");
            if (Util.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append("\n");
            i8 = i9;
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String value(int i8) {
        return this.namesAndValues[(i8 * 2) + 1];
    }

    public final List<String> values(String name) {
        List<String> k8;
        boolean w7;
        Intrinsics.f(name, "name");
        int size = size();
        ArrayList arrayList = null;
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            w7 = StringsKt__StringsJVMKt.w(name, name(i8), true);
            if (w7) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i8));
            }
            i8 = i9;
        }
        if (arrayList != null) {
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.e(unmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
            return unmodifiableList;
        }
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }
}
