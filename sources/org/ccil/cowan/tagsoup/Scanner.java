package org.ccil.cowan.tagsoup;

import java.io.IOException;
import java.io.Reader;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public interface Scanner {
    void a(Reader reader, ScanHandler scanHandler) throws IOException, SAXException;

    void b(String str, String str2);

    void startCDATA();
}
