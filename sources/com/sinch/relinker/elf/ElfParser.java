package com.sinch.relinker.elf;

import com.sinch.relinker.elf.Elf;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes3.dex */
public class ElfParser implements Closeable, Elf {
    private final int MAGIC = 1179403647;
    private final FileChannel channel;

    public ElfParser(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.channel = new FileInputStream(file).getChannel();
    }

    private long offsetFromVma(Elf.Header header, long j8, long j9) throws IOException {
        for (long j10 = 0; j10 < j8; j10++) {
            Elf.ProgramHeader programHeader = header.getProgramHeader(j10);
            if (programHeader.type == 1) {
                long j11 = programHeader.vaddr;
                if (j11 <= j9 && j9 <= programHeader.memsz + j11) {
                    return (j9 - j11) + programHeader.offset;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    public Elf.Header parseHeader() throws IOException {
        this.channel.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (readWord(allocate, 0L) == 1179403647) {
            short readByte = readByte(allocate, 4L);
            boolean z7 = readByte(allocate, 5L) == 2;
            if (readByte == 1) {
                return new Elf32Header(z7, this);
            }
            if (readByte == 2) {
                return new Elf64Header(z7, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> parseNeededDependencies() throws IOException {
        long j8;
        this.channel.position(0L);
        ArrayList arrayList = new ArrayList();
        Elf.Header parseHeader = parseHeader();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(parseHeader.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j9 = parseHeader.phnum;
        int i8 = 0;
        if (j9 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j9 = parseHeader.getSectionHeader(0).info;
        }
        long j10 = 0;
        while (true) {
            if (j10 >= j9) {
                j8 = 0;
                break;
            }
            Elf.ProgramHeader programHeader = parseHeader.getProgramHeader(j10);
            if (programHeader.type == 2) {
                j8 = programHeader.offset;
                break;
            }
            j10++;
        }
        if (j8 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList<Long> arrayList2 = new ArrayList();
        long j11 = 0;
        while (true) {
            Elf.DynamicStructure dynamicStructure = parseHeader.getDynamicStructure(j8, i8);
            long j12 = j8;
            long j13 = dynamicStructure.tag;
            if (j13 == 1) {
                arrayList2.add(Long.valueOf(dynamicStructure.val));
            } else if (j13 == 5) {
                j11 = dynamicStructure.val;
            }
            i8++;
            if (dynamicStructure.tag == 0) {
                break;
            }
            j8 = j12;
        }
        if (j11 != 0) {
            long offsetFromVma = offsetFromVma(parseHeader, j9, j11);
            for (Long l8 : arrayList2) {
                arrayList.add(readString(allocate, l8.longValue() + offsetFromVma));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    public void read(ByteBuffer byteBuffer, long j8, int i8) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i8);
        long j9 = 0;
        while (j9 < i8) {
            int read = this.channel.read(byteBuffer, j8 + j9);
            if (read == -1) {
                throw new EOFException();
            }
            j9 += read;
        }
        byteBuffer.position(0);
    }

    public short readByte(ByteBuffer byteBuffer, long j8) throws IOException {
        read(byteBuffer, j8, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public int readHalf(ByteBuffer byteBuffer, long j8) throws IOException {
        read(byteBuffer, j8, 2);
        return byteBuffer.getShort() & 65535;
    }

    public long readLong(ByteBuffer byteBuffer, long j8) throws IOException {
        read(byteBuffer, j8, 8);
        return byteBuffer.getLong();
    }

    public String readString(ByteBuffer byteBuffer, long j8) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j9 = 1 + j8;
            short readByte = readByte(byteBuffer, j8);
            if (readByte == 0) {
                return sb.toString();
            }
            sb.append((char) readByte);
            j8 = j9;
        }
    }

    public long readWord(ByteBuffer byteBuffer, long j8) throws IOException {
        read(byteBuffer, j8, 4);
        return byteBuffer.getInt() & 4294967295L;
    }
}
