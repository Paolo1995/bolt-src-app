package androidx.emoji2.text;

import androidx.annotation.NonNull;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
class MetadataListReader {

    /* loaded from: classes.dex */
    private static class ByteBufferReader implements OpenTypeReader {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f6495a;

        ByteBufferReader(@NonNull ByteBuffer byteBuffer) {
            this.f6495a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int a() throws IOException {
            return this.f6495a.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void b(int i8) throws IOException {
            ByteBuffer byteBuffer = this.f6495a;
            byteBuffer.position(byteBuffer.position() + i8);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long c() throws IOException {
            return MetadataListReader.c(this.f6495a.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.f6495a.position();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            return MetadataListReader.d(this.f6495a.getShort());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class OffsetInfo {

        /* renamed from: a  reason: collision with root package name */
        private final long f6496a;

        /* renamed from: b  reason: collision with root package name */
        private final long f6497b;

        OffsetInfo(long j8, long j9) {
            this.f6496a = j8;
            this.f6497b = j9;
        }

        long a() {
            return this.f6496a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface OpenTypeReader {
        int a() throws IOException;

        void b(int i8) throws IOException;

        long c() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    private MetadataListReader() {
    }

    private static OffsetInfo a(OpenTypeReader openTypeReader) throws IOException {
        long j8;
        openTypeReader.b(4);
        int readUnsignedShort = openTypeReader.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            openTypeReader.b(6);
            int i8 = 0;
            while (true) {
                if (i8 < readUnsignedShort) {
                    int a8 = openTypeReader.a();
                    openTypeReader.b(4);
                    j8 = openTypeReader.c();
                    openTypeReader.b(4);
                    if (1835365473 == a8) {
                        break;
                    }
                    i8++;
                } else {
                    j8 = -1;
                    break;
                }
            }
            if (j8 != -1) {
                openTypeReader.b((int) (j8 - openTypeReader.getPosition()));
                openTypeReader.b(12);
                long c8 = openTypeReader.c();
                for (int i9 = 0; i9 < c8; i9++) {
                    int a9 = openTypeReader.a();
                    long c9 = openTypeReader.c();
                    long c10 = openTypeReader.c();
                    if (1164798569 == a9 || 1701669481 == a9) {
                        return new OffsetInfo(c9 + j8, c10);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataList b(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new ByteBufferReader(duplicate)).a());
        return MetadataList.h(duplicate);
    }

    static long c(int i8) {
        return i8 & 4294967295L;
    }

    static int d(short s7) {
        return s7 & 65535;
    }
}
