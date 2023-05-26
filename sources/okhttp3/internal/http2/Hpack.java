package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* compiled from: Hpack.kt */
/* loaded from: classes5.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, "http"), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        int i8 = 0;
        while (i8 < length) {
            int i9 = i8 + 1;
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i8].name)) {
                linkedHashMap.put(headerArr2[i8].name, Integer.valueOf(i8));
            }
            i8 = i9;
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.e(unmodifiableMap, "unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final ByteString checkLowercase(ByteString name) throws IOException {
        boolean z7;
        Intrinsics.f(name, "name");
        int z8 = name.z();
        int i8 = 0;
        while (i8 < z8) {
            int i9 = i8 + 1;
            byte h8 = name.h(i8);
            if (65 <= h8 && h8 <= 90) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                i8 = i9;
            } else {
                throw new IOException(Intrinsics.n("PROTOCOL_ERROR response malformed: mixed case name: ", name.D()));
            }
        }
        return name;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    /* compiled from: Hpack.kt */
    /* loaded from: classes5.dex */
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Reader(Source source, int i8) {
            this(source, i8, 0, 4, null);
            Intrinsics.f(source, "source");
        }

        public Reader(Source source, int i8, int i9) {
            Intrinsics.f(source, "source");
            this.headerTableSizeSetting = i8;
            this.maxDynamicTableByteCount = i9;
            this.headerList = new ArrayList();
            this.source = Okio.d(source);
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        private final void adjustDynamicTableByteCount() {
            int i8 = this.maxDynamicTableByteCount;
            int i9 = this.dynamicTableByteCount;
            if (i8 < i9) {
                if (i8 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i9 - i8);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.o(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i8) {
            return this.nextHeaderIndex + 1 + i8;
        }

        private final int evictToRecoverBytes(int i8) {
            int i9;
            int i10 = 0;
            if (i8 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i9 = this.nextHeaderIndex;
                    if (length < i9 || i8 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.c(header);
                    int i11 = header.hpackSize;
                    i8 -= i11;
                    this.dynamicTableByteCount -= i11;
                    this.headerCount--;
                    i10++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i9 + 1, headerArr, i9 + 1 + i10, this.headerCount);
                this.nextHeaderIndex += i10;
            }
            return i10;
        }

        private final ByteString getName(int i8) throws IOException {
            if (isStaticHeader(i8)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i8].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i8 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.c(header);
                    return header.name;
                }
            }
            throw new IOException(Intrinsics.n("Header index too large ", Integer.valueOf(i8 + 1)));
        }

        private final void insertIntoDynamicTable(int i8, Header header) {
            this.headerList.add(header);
            int i9 = header.hpackSize;
            if (i8 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i8)];
                Intrinsics.c(header2);
                i9 -= header2.hpackSize;
            }
            int i10 = this.maxDynamicTableByteCount;
            if (i9 > i10) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i9) - i10);
            if (i8 == -1) {
                int i11 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i11 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i12 = this.nextHeaderIndex;
                this.nextHeaderIndex = i12 - 1;
                this.dynamicTable[i12] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i8 + dynamicTableIndex(i8) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i9;
        }

        private final boolean isStaticHeader(int i8) {
            if (i8 >= 0 && i8 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1) {
                return true;
            }
            return false;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i8) throws IOException {
            if (isStaticHeader(i8)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i8]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i8 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.c(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException(Intrinsics.n("Header index too large ", Integer.valueOf(i8 + 1)));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i8) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i8), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i8) throws IOException {
            this.headerList.add(new Header(getName(i8), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> H0;
            H0 = CollectionsKt___CollectionsKt.H0(this.headerList);
            this.headerList.clear();
            return H0;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() throws IOException {
            boolean z7;
            int readByte = readByte();
            if ((readByte & 128) == 128) {
                z7 = true;
            } else {
                z7 = false;
            }
            long readInt = readInt(readByte, 127);
            if (z7) {
                Buffer buffer = new Buffer();
                Huffman.INSTANCE.decode(this.source, readInt, buffer);
                return buffer.N0();
            }
            return this.source.o0(readInt);
        }

        public final void readHeaders() throws IOException {
            while (!this.source.y0()) {
                int and = Util.and(this.source.readByte(), 255);
                if (and != 128) {
                    if ((and & 128) == 128) {
                        readIndexedHeader(readInt(and, 127) - 1);
                    } else if (and == 64) {
                        readLiteralHeaderWithIncrementalIndexingNewName();
                    } else if ((and & 64) == 64) {
                        readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                    } else if ((and & 32) == 32) {
                        int readInt = readInt(and, 31);
                        this.maxDynamicTableByteCount = readInt;
                        if (readInt >= 0 && readInt <= this.headerTableSizeSetting) {
                            adjustDynamicTableByteCount();
                        } else {
                            throw new IOException(Intrinsics.n("Invalid dynamic table size update ", Integer.valueOf(this.maxDynamicTableByteCount)));
                        }
                    } else if (and != 16 && and != 0) {
                        readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                    } else {
                        readLiteralHeaderWithoutIndexingNewName();
                    }
                } else {
                    throw new IOException("index == 0");
                }
            }
        }

        public final int readInt(int i8, int i9) throws IOException {
            int i10 = i8 & i9;
            if (i10 < i9) {
                return i10;
            }
            int i11 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) != 0) {
                    i9 += (readByte & 127) << i11;
                    i11 += 7;
                } else {
                    return i9 + (readByte << i11);
                }
            }
        }

        public /* synthetic */ Reader(Source source, int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(source, i8, (i10 & 4) != 0 ? i8 : i9);
        }
    }

    /* compiled from: Hpack.kt */
    /* loaded from: classes5.dex */
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(int i8, Buffer out) {
            this(i8, false, out, 2, null);
            Intrinsics.f(out, "out");
        }

        public Writer(int i8, boolean z7, Buffer out) {
            Intrinsics.f(out, "out");
            this.headerTableSizeSetting = i8;
            this.useCompression = z7;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.maxDynamicTableByteCount = i8;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(Buffer out) {
            this(0, false, out, 3, null);
            Intrinsics.f(out, "out");
        }

        private final void adjustDynamicTableByteCount() {
            int i8 = this.maxDynamicTableByteCount;
            int i9 = this.dynamicTableByteCount;
            if (i8 < i9) {
                if (i8 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i9 - i8);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.o(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i8) {
            int i9;
            int i10 = 0;
            if (i8 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i9 = this.nextHeaderIndex;
                    if (length < i9 || i8 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.c(header);
                    i8 -= header.hpackSize;
                    int i11 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    Intrinsics.c(header2);
                    this.dynamicTableByteCount = i11 - header2.hpackSize;
                    this.headerCount--;
                    i10++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i9 + 1, headerArr, i9 + 1 + i10, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i12 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i12 + 1, i12 + 1 + i10, (Object) null);
                this.nextHeaderIndex += i10;
            }
            return i10;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i8 = header.hpackSize;
            int i9 = this.maxDynamicTableByteCount;
            if (i8 > i9) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i8) - i9);
            int i10 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i10 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i11 = this.nextHeaderIndex;
            this.nextHeaderIndex = i11 - 1;
            this.dynamicTable[i11] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i8;
        }

        public final void resizeHeaderTable(int i8) {
            this.headerTableSizeSetting = i8;
            int min = Math.min(i8, 16384);
            int i9 = this.maxDynamicTableByteCount;
            if (i9 == min) {
                return;
            }
            if (min < i9) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(ByteString data) throws IOException {
            Intrinsics.f(data, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(data) < data.z()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(data, buffer);
                    ByteString N0 = buffer.N0();
                    writeInt(N0.z(), 127, 128);
                    this.out.a1(N0);
                    return;
                }
            }
            writeInt(data.z(), 127, 0);
            this.out.a1(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void writeHeaders(java.util.List<okhttp3.internal.http2.Header> r15) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 271
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        public final void writeInt(int i8, int i9, int i10) {
            if (i8 < i9) {
                this.out.writeByte(i8 | i10);
                return;
            }
            this.out.writeByte(i10 | i9);
            int i11 = i8 - i9;
            while (i11 >= 128) {
                this.out.writeByte(128 | (i11 & 127));
                i11 >>>= 7;
            }
            this.out.writeByte(i11);
        }

        public /* synthetic */ Writer(int i8, boolean z7, Buffer buffer, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this((i9 & 1) != 0 ? 4096 : i8, (i9 & 2) != 0 ? true : z7, buffer);
        }
    }
}
