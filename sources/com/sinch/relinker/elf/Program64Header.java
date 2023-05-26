package com.sinch.relinker.elf;

import com.sinch.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public class Program64Header extends Elf.ProgramHeader {
    public Program64Header(ElfParser elfParser, Elf.Header header, long j8) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j9 = header.phoff + (j8 * header.phentsize);
        this.type = elfParser.readWord(allocate, j9);
        this.offset = elfParser.readLong(allocate, 8 + j9);
        this.vaddr = elfParser.readLong(allocate, 16 + j9);
        this.memsz = elfParser.readLong(allocate, j9 + 40);
    }
}
