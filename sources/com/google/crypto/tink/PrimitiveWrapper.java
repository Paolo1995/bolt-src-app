package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface PrimitiveWrapper<B, P> {
    P a(PrimitiveSet<B> primitiveSet) throws GeneralSecurityException;

    Class<B> b();

    Class<P> c();
}
