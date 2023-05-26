package io.netty.channel;

import io.netty.util.ReferenceCounted;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes5.dex */
public interface FileRegion extends ReferenceCounted {
    long count();

    @Override // io.netty.util.ReferenceCounted
    FileRegion retain();

    long transferTo(WritableByteChannel writableByteChannel, long j8) throws IOException;

    long transferred();
}
