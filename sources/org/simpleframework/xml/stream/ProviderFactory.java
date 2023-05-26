package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
final class ProviderFactory {
    ProviderFactory() {
    }

    public static Provider getInstance() {
        try {
            try {
                return new StreamProvider();
            } catch (Throwable unused) {
                return new DocumentProvider();
            }
        } catch (Throwable unused2) {
            return new PullProvider();
        }
    }
}
