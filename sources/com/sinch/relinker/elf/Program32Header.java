package com.sinch.relinker.elf;

import com.sinch.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public class Program32Header extends Elf.ProgramHeader {
    public Program32Header(ElfParser elfParser, Elf.Header header, long j8) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j9 = header.phoff + (j8 * header.phentsize);
        this.type = elfParser.readWord(allocate, j9);
        this.offset = elfParser.readWord(allocate, 4 + j9);
        this.vaddr = elfParser.readWord(allocate, 8 + j9);
        this.memsz = elfParser.readWord(allocate, j9 + 20);
    }
}
