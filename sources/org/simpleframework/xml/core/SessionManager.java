package org.simpleframework.xml.core;

/* loaded from: classes5.dex */
class SessionManager {
    private ThreadLocal<Reference> local = new ThreadLocal<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Reference {
        private int count;
        private Session session;

        public Reference(boolean z7) {
            this.session = new Session(z7);
        }

        public int clear() {
            int i8 = this.count - 1;
            this.count = i8;
            return i8;
        }

        public Session get() {
            int i8 = this.count;
            if (i8 >= 0) {
                this.count = i8 + 1;
            }
            return this.session;
        }
    }

    private Session create(boolean z7) throws Exception {
        Reference reference = new Reference(z7);
        this.local.set(reference);
        return reference.get();
    }

    public void close() throws Exception {
        Reference reference = this.local.get();
        if (reference != null) {
            if (reference.clear() == 0) {
                this.local.remove();
                return;
            }
            return;
        }
        throw new PersistenceException("Session does not exist", new Object[0]);
    }

    public Session open() throws Exception {
        return open(true);
    }

    public Session open(boolean z7) throws Exception {
        Reference reference = this.local.get();
        if (reference != null) {
            return reference.get();
        }
        return create(z7);
    }
}
