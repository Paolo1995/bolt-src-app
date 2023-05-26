package io.netty.util;

/* loaded from: classes5.dex */
public interface ReferenceCounted {
    int refCnt();

    boolean release();

    ReferenceCounted retain();

    ReferenceCounted touch(Object obj);
}
