package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class TextFormatEscaper {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface ByteSequence {
        byte a(int i8);

        int size();
    }

    private TextFormatEscaper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(final ByteString byteString) {
        return b(new ByteSequence() { // from class: com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.1
            @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
            public byte a(int i8) {
                return ByteString.this.d(i8);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return ByteString.this.size();
            }
        });
    }

    static String b(ByteSequence byteSequence) {
        StringBuilder sb = new StringBuilder(byteSequence.size());
        for (int i8 = 0; i8 < byteSequence.size(); i8++) {
            byte a8 = byteSequence.a(i8);
            if (a8 != 34) {
                if (a8 != 39) {
                    if (a8 != 92) {
                        switch (a8) {
                            case 7:
                                sb.append("\\a");
                                continue;
                            case 8:
                                sb.append("\\b");
                                continue;
                            case 9:
                                sb.append("\\t");
                                continue;
                            case 10:
                                sb.append("\\n");
                                continue;
                            case 11:
                                sb.append("\\v");
                                continue;
                            case 12:
                                sb.append("\\f");
                                continue;
                            case 13:
                                sb.append("\\r");
                                continue;
                            default:
                                if (a8 >= 32 && a8 <= 126) {
                                    sb.append((char) a8);
                                    continue;
                                } else {
                                    sb.append('\\');
                                    sb.append((char) (((a8 >>> 6) & 3) + 48));
                                    sb.append((char) (((a8 >>> 3) & 7) + 48));
                                    sb.append((char) ((a8 & 7) + 48));
                                    break;
                                }
                                break;
                        }
                    } else {
                        sb.append("\\\\");
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        return a(ByteString.m(str));
    }
}
