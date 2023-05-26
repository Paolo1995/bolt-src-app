package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class EmojiProcessor {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final EmojiCompat.SpanFactory f6464a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final MetadataRepo f6465b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private EmojiCompat.GlyphChecker f6466c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6467d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f6468e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CodepointIndexFinder {
        private CodepointIndexFinder() {
        }

        static int a(CharSequence charSequence, int i8, int i9) {
            int length = charSequence.length();
            if (i8 < 0 || length < i8 || i9 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i9 != 0) {
                    i8--;
                    if (i8 < 0) {
                        if (z7) {
                            return -1;
                        }
                        return 0;
                    }
                    char charAt = charSequence.charAt(i8);
                    if (z7) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i9--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i9--;
                    } else if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    } else {
                        z7 = true;
                    }
                }
                return i8;
            }
        }

        static int b(CharSequence charSequence, int i8, int i9) {
            int length = charSequence.length();
            if (i8 < 0 || length < i8 || i9 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i9 != 0) {
                    if (i8 >= length) {
                        if (z7) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i8);
                    if (z7) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i9--;
                        i8++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i9--;
                        i8++;
                    } else if (Character.isLowSurrogate(charAt)) {
                        return -1;
                    } else {
                        i8++;
                        z7 = true;
                    }
                }
                return i8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ProcessorSm {

        /* renamed from: a  reason: collision with root package name */
        private int f6469a = 1;

        /* renamed from: b  reason: collision with root package name */
        private final MetadataRepo.Node f6470b;

        /* renamed from: c  reason: collision with root package name */
        private MetadataRepo.Node f6471c;

        /* renamed from: d  reason: collision with root package name */
        private MetadataRepo.Node f6472d;

        /* renamed from: e  reason: collision with root package name */
        private int f6473e;

        /* renamed from: f  reason: collision with root package name */
        private int f6474f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f6475g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f6476h;

        ProcessorSm(MetadataRepo.Node node, boolean z7, int[] iArr) {
            this.f6470b = node;
            this.f6471c = node;
            this.f6475g = z7;
            this.f6476h = iArr;
        }

        private static boolean d(int i8) {
            return i8 == 65039;
        }

        private static boolean f(int i8) {
            return i8 == 65038;
        }

        private int g() {
            this.f6469a = 1;
            this.f6471c = this.f6470b;
            this.f6474f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f6471c.b().j() || d(this.f6473e)) {
                return true;
            }
            if (this.f6475g) {
                if (this.f6476h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f6476h, this.f6471c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i8) {
            MetadataRepo.Node a8 = this.f6471c.a(i8);
            int i9 = 3;
            if (this.f6469a != 2) {
                if (a8 == null) {
                    i9 = g();
                } else {
                    this.f6469a = 2;
                    this.f6471c = a8;
                    this.f6474f = 1;
                    i9 = 2;
                }
            } else {
                if (a8 != null) {
                    this.f6471c = a8;
                    this.f6474f++;
                } else if (f(i8)) {
                    i9 = g();
                } else if (!d(i8)) {
                    if (this.f6471c.b() != null) {
                        if (this.f6474f == 1) {
                            if (h()) {
                                this.f6472d = this.f6471c;
                                g();
                            } else {
                                i9 = g();
                            }
                        } else {
                            this.f6472d = this.f6471c;
                            g();
                        }
                    } else {
                        i9 = g();
                    }
                }
                i9 = 2;
            }
            this.f6473e = i8;
            return i9;
        }

        EmojiMetadata b() {
            return this.f6471c.b();
        }

        EmojiMetadata c() {
            return this.f6472d.b();
        }

        boolean e() {
            if (this.f6469a == 2 && this.f6471c.b() != null && (this.f6474f > 1 || h())) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiProcessor(@NonNull MetadataRepo metadataRepo, @NonNull EmojiCompat.SpanFactory spanFactory, @NonNull EmojiCompat.GlyphChecker glyphChecker, boolean z7, int[] iArr) {
        this.f6464a = spanFactory;
        this.f6465b = metadataRepo;
        this.f6466c = glyphChecker;
        this.f6467d = z7;
        this.f6468e = iArr;
    }

    private void a(@NonNull Spannable spannable, EmojiMetadata emojiMetadata, int i8, int i9) {
        spannable.setSpan(this.f6464a.a(emojiMetadata), i8, i9, 33);
    }

    private static boolean b(@NonNull Editable editable, @NonNull KeyEvent keyEvent, boolean z7) {
        EmojiSpan[] emojiSpanArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((z7 && spanStart == selectionStart) || ((!z7 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(@NonNull InputConnection inputConnection, @NonNull Editable editable, int i8, int i9, boolean z7) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i8 >= 0 && i9 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z7) {
                max = CodepointIndexFinder.a(editable, selectionStart, Math.max(i8, 0));
                min = CodepointIndexFinder.b(editable, selectionEnd, Math.max(i9, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i8, 0);
                min = Math.min(selectionEnd + i9, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(max, min, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(@NonNull Editable editable, int i8, @NonNull KeyEvent keyEvent) {
        boolean b8;
        if (i8 != 67) {
            if (i8 != 112) {
                b8 = false;
            } else {
                b8 = b(editable, keyEvent, true);
            }
        } else {
            b8 = b(editable, keyEvent, false);
        }
        if (!b8) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean e(CharSequence charSequence, int i8, int i9, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.d() == 0) {
            emojiMetadata.k(this.f6466c.a(charSequence, i8, i9, emojiMetadata.h()));
        }
        if (emojiMetadata.d() == 2) {
            return true;
        }
        return false;
    }

    private static boolean f(int i8, int i9) {
        return i8 == -1 || i9 == -1 || i8 != i9;
    }

    private static boolean g(@NonNull KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0125, code lost:
        ((androidx.emoji2.text.SpannableBuilder) r10).d();
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[Catch: all -> 0x012c, TryCatch #0 {all -> 0x012c, blocks: (B:7:0x000d, B:10:0x0012, B:12:0x0016, B:14:0x0025, B:18:0x0036, B:20:0x0040, B:22:0x0043, B:24:0x0047, B:26:0x0053, B:27:0x0056, B:29:0x0063, B:35:0x0072, B:36:0x0080, B:40:0x009b, B:48:0x00ab, B:51:0x00b7, B:52:0x00c1, B:53:0x00cb, B:55:0x00d2, B:56:0x00d7, B:58:0x00e2, B:60:0x00e9, B:64:0x00f3, B:67:0x00ff, B:68:0x0105, B:70:0x010e, B:15:0x002b), top: B:84:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ff A[Catch: all -> 0x012c, TryCatch #0 {all -> 0x012c, blocks: (B:7:0x000d, B:10:0x0012, B:12:0x0016, B:14:0x0025, B:18:0x0036, B:20:0x0040, B:22:0x0043, B:24:0x0047, B:26:0x0053, B:27:0x0056, B:29:0x0063, B:35:0x0072, B:36:0x0080, B:40:0x009b, B:48:0x00ab, B:51:0x00b7, B:52:0x00c1, B:53:0x00cb, B:55:0x00d2, B:56:0x00d7, B:58:0x00e2, B:60:0x00e9, B:64:0x00f3, B:67:0x00ff, B:68:0x0105, B:70:0x010e, B:15:0x002b), top: B:84:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010e A[Catch: all -> 0x012c, TRY_LEAVE, TryCatch #0 {all -> 0x012c, blocks: (B:7:0x000d, B:10:0x0012, B:12:0x0016, B:14:0x0025, B:18:0x0036, B:20:0x0040, B:22:0x0043, B:24:0x0047, B:26:0x0053, B:27:0x0056, B:29:0x0063, B:35:0x0072, B:36:0x0080, B:40:0x009b, B:48:0x00ab, B:51:0x00b7, B:52:0x00c1, B:53:0x00cb, B:55:0x00d2, B:56:0x00d7, B:58:0x00e2, B:60:0x00e9, B:64:0x00f3, B:67:0x00ff, B:68:0x0105, B:70:0x010e, B:15:0x002b), top: B:84:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00d7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence h(@androidx.annotation.NonNull java.lang.CharSequence r10, int r11, int r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
