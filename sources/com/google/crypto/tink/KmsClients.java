package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class KmsClients {

    /* renamed from: a  reason: collision with root package name */
    private static final CopyOnWriteArrayList<KmsClient> f14815a = new CopyOnWriteArrayList<>();

    public static KmsClient a(String str) throws GeneralSecurityException {
        Iterator<KmsClient> it = f14815a.iterator();
        while (it.hasNext()) {
            KmsClient next = it.next();
            if (next.a(str)) {
                return next;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
