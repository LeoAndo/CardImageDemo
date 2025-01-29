package com.example.cardimagedemo;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

// NFCカードに対応する情報を管理するenum
public enum NFCCardItem {
    // NFCカードに必要なデータをここにまとめる
    CARD_001("card_id_001", R.drawable.image001, List.of(
            new Book(1, "本のタイトル1"),
            new Book(2, "本のタイトル2"),
            new Book(3, "本のタイトル3")
    )),
    CARD_002("card_id_002", R.drawable.image002, List.of(
            new Book(4, "本のタイトル4"),
            new Book(5, "本のタイトル5"),
            new Book(6, "本のタイトル6")
    )),
    CARD_003("card_id_003", R.drawable.image003, List.of(
            new Book(7, "本のタイトル7"),
            new Book(8, "本のタイトル8"),
            new Book(9, "本のタイトル9")
    ));

    @NonNull
    private final String cardId; // NFCカードを読み取った時に取得できるデータ
    @DrawableRes
    private final int resourceId; // 画像リソースID

    @NonNull
    private final List<Book> books; // 対応する本の情報をまとめたリスト

    // コンストラクタは書く必要がある.
    NFCCardItem(@NonNull String cardId, int resourceId, @NonNull List<Book> books) {
        this.cardId = cardId;
        this.resourceId = resourceId;
        this.books = books;
    }

    @NonNull
    public String getCardId() {
        return cardId;
    }

    public int getResourceId() {
        return resourceId;
    }

    @NonNull
    public List<Book> getBooks() {
        return books;
    }

    /**
     * NFCカードIDから対応するNFCCardItemを取得する
     *
     * @param cardId NFCカードID ex) "card_id_001"
     * @return 対応するNFCCardItem
     */
    @Nullable
    public static NFCCardItem findByCardId(@NonNull final String cardId) {
        for (final NFCCardItem card : NFCCardItem.values()) {
            if (card.getCardId().equals(cardId)) {
                return card;
            }
        }
        return null;
    }
}
