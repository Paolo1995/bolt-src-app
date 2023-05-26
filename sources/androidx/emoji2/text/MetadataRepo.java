package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import j$.util.Spliterator;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class MetadataRepo {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MetadataList f6498a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final char[] f6499b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Node f6500c = new Node(Spliterator.IMMUTABLE);
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f6501d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Node {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<Node> f6502a;

        /* renamed from: b  reason: collision with root package name */
        private EmojiMetadata f6503b;

        private Node() {
            this(1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Node a(int i8) {
            SparseArray<Node> sparseArray = this.f6502a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final EmojiMetadata b() {
            return this.f6503b;
        }

        void c(@NonNull EmojiMetadata emojiMetadata, int i8, int i9) {
            Node a8 = a(emojiMetadata.b(i8));
            if (a8 == null) {
                a8 = new Node();
                this.f6502a.put(emojiMetadata.b(i8), a8);
            }
            if (i9 > i8) {
                a8.c(emojiMetadata, i8 + 1, i9);
            } else {
                a8.f6503b = emojiMetadata;
            }
        }

        Node(int i8) {
            this.f6502a = new SparseArray<>(i8);
        }
    }

    private MetadataRepo(@NonNull Typeface typeface, @NonNull MetadataList metadataList) {
        this.f6501d = typeface;
        this.f6498a = metadataList;
        this.f6499b = new char[metadataList.k() * 2];
        a(metadataList);
    }

    private void a(MetadataList metadataList) {
        int k8 = metadataList.k();
        for (int i8 = 0; i8 < k8; i8++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i8);
            Character.toChars(emojiMetadata.f(), this.f6499b, i8 * 2);
            h(emojiMetadata);
        }
    }

    @NonNull
    public static MetadataRepo b(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.a("EmojiCompat.MetadataRepo.create");
            return new MetadataRepo(typeface, MetadataListReader.b(byteBuffer));
        } finally {
            TraceCompat.b();
        }
    }

    @NonNull
    public char[] c() {
        return this.f6499b;
    }

    @NonNull
    public MetadataList d() {
        return this.f6498a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f6498a.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Node f() {
        return this.f6500c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Typeface g() {
        return this.f6501d;
    }

    void h(@NonNull EmojiMetadata emojiMetadata) {
        boolean z7;
        Preconditions.h(emojiMetadata, "emoji metadata cannot be null");
        if (emojiMetadata.c() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.b(z7, "invalid metadata codepoint length");
        this.f6500c.c(emojiMetadata, 0, emojiMetadata.c() - 1);
    }
}
