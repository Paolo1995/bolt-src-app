package io.ktor.utils.io;

import kotlinx.coroutines.Job;

/* compiled from: ByteChannelCtor.kt */
/* loaded from: classes5.dex */
public interface ByteChannel extends ByteReadChannel, ByteWriteChannel {
    void j(Job job);
}
