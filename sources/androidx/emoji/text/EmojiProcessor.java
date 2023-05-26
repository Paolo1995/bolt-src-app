package androidx.emoji.text;

import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.core.graphics.PaintCompat;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.MetadataRepo;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class EmojiProcessor {

    /* renamed from: a  reason: collision with root package name */
    private final EmojiCompat.SpanFactory f6339a;

    /* renamed from: b  reason: collision with root package name */
    private final MetadataRepo f6340b;

    /* renamed from: c  reason: collision with root package name */
    private GlyphChecker f6341c = new GlyphChecker();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6342d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f6343e;

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

    /* loaded from: classes.dex */
    public static class GlyphChecker {

        /* renamed from: b  reason: collision with root package name */
        private static final ThreadLocal<StringBuilder> f6344b = new ThreadLocal<>();

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f6345a;

        GlyphChecker() {
            TextPaint textPaint = new TextPaint();
            this.f6345a = textPaint;
            textPaint.setTextSize(10.0f);
        }

        private static StringBuilder a() {
            ThreadLocal<StringBuilder> threadLocal = f6344b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            return threadLocal.get();
        }

        public boolean b(CharSequence charSequence, int i8, int i9) {
            StringBuilder a8 = a();
            a8.setLength(0);
            while (i8 < i9) {
                a8.append(charSequence.charAt(i8));
                i8++;
            }
            return PaintCompat.a(this.f6345a, a8.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ProcessorSm {

        /* renamed from: a  reason: collision with root package name */
        private int f6346a = 1;

        /* renamed from: b  reason: collision with root package name */
        private final MetadataRepo.Node f6347b;

        /* renamed from: c  reason: collision with root package name */
        private MetadataRepo.Node f6348c;

        /* renamed from: d  reason: collision with root package name */
        private MetadataRepo.Node f6349d;

        /* renamed from: e  reason: collision with root package name */
        private int f6350e;

        /* renamed from: f  reason: collision with root package name */
        private int f6351f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f6352g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f6353h;

        ProcessorSm(MetadataRepo.Node node, boolean z7, int[] iArr) {
            this.f6347b = node;
            this.f6348c = node;
            this.f6352g = z7;
            this.f6353h = iArr;
        }

        private static boolean d(int i8) {
            return i8 == 65039;
        }

        private static boolean f(int i8) {
            return i8 == 65038;
        }

        private int g() {
            this.f6346a = 1;
            this.f6348c = this.f6347b;
            this.f6351f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f6348c.b().j() || d(this.f6350e)) {
                return true;
            }
            if (this.f6352g) {
                if (this.f6353h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f6353h, this.f6348c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i8) {
            MetadataRepo.Node a8 = this.f6348c.a(i8);
            int i9 = 3;
            if (this.f6346a != 2) {
                if (a8 == null) {
                    i9 = g();
                } else {
                    this.f6346a = 2;
                    this.f6348c = a8;
                    this.f6351f = 1;
                    i9 = 2;
                }
            } else {
                if (a8 != null) {
                    this.f6348c = a8;
                    this.f6351f++;
                } else if (f(i8)) {
                    i9 = g();
                } else if (!d(i8)) {
                    if (this.f6348c.b() != null) {
                        if (this.f6351f == 1) {
                            if (h()) {
                                this.f6349d = this.f6348c;
                                g();
                            } else {
                                i9 = g();
                            }
                        } else {
                            this.f6349d = this.f6348c;
                            g();
                        }
                    } else {
                        i9 = g();
                    }
                }
                i9 = 2;
            }
            this.f6350e = i8;
            return i9;
        }

        EmojiMetadata b() {
            return this.f6348c.b();
        }

        EmojiMetadata c() {
            return this.f6349d.b();
        }

        boolean e() {
            if (this.f6346a == 2 && this.f6348c.b() != null && (this.f6351f > 1 || h())) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiProcessor(@NonNull MetadataRepo metadataRepo, @NonNull EmojiCompat.SpanFactory spanFactory, boolean z7, int[] iArr) {
        this.f6339a = spanFactory;
        this.f6340b = metadataRepo;
        this.f6342d = z7;
        this.f6343e = iArr;
    }

    private void a(@NonNull Spannable spannable, EmojiMetadata emojiMetadata, int i8, int i9) {
        spannable.setSpan(this.f6339a.a(emojiMetadata), i8, i9, 33);
    }

    private static boolean b(Editable editable, KeyEvent keyEvent, boolean z7) {
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
    public static boolean d(@NonNull Editable editable, int i8, KeyEvent keyEvent) {
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
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23 && emojiMetadata.h() > i10) {
            return false;
        }
        if (emojiMetadata.d() == 0) {
            emojiMetadata.k(this.f6341c.b(charSequence, i8, i9));
        }
        if (emojiMetadata.d() != 2) {
            return false;
        }
        return true;
    }

    private static boolean f(int i8, int i9) {
        return i8 == -1 || i9 == -1 || i8 != i9;
    }

    private static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x010f, code lost:
        ((androidx.emoji.widget.SpannableBuilder) r10).d();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042 A[Catch: all -> 0x0116, TryCatch #0 {all -> 0x0116, blocks: (B:7:0x000d, B:10:0x0012, B:12:0x0016, B:14:0x0025, B:18:0x0031, B:20:0x003b, B:22:0x003e, B:24:0x0042, B:26:0x004e, B:27:0x0051, B:29:0x005e, B:35:0x006d, B:36:0x007b, B:40:0x0096, B:48:0x00a6, B:51:0x00b2, B:52:0x00b7, B:53:0x00c1, B:55:0x00c8, B:56:0x00cd, B:58:0x00d8, B:60:0x00df, B:64:0x00e9, B:67:0x00f5, B:68:0x00fb, B:15:0x002b), top: B:81:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f5 A[Catch: all -> 0x0116, TryCatch #0 {all -> 0x0116, blocks: (B:7:0x000d, B:10:0x0012, B:12:0x0016, B:14:0x0025, B:18:0x0031, B:20:0x003b, B:22:0x003e, B:24:0x0042, B:26:0x004e, B:27:0x0051, B:29:0x005e, B:35:0x006d, B:36:0x007b, B:40:0x0096, B:48:0x00a6, B:51:0x00b2, B:52:0x00b7, B:53:0x00c1, B:55:0x00c8, B:56:0x00cd, B:58:0x00d8, B:60:0x00df, B:64:0x00e9, B:67:0x00f5, B:68:0x00fb, B:15:0x002b), top: B:81:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0107 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x009d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence h(@androidx.annotation.NonNull java.lang.CharSequence r10, int r11, int r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji.text.EmojiProcessor.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
