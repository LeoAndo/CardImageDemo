package com.example.cardimagedemo;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// NFCカードに対応する情報を管理するenum
public enum NFCCardItem {
    // NFCカードに必要なデータをここにまとめる
    CARD_001("card_id_001", R.drawable.image001),
    CARD_002("card_id_002", R.drawable.image002),
    CARD_003("card_id_003", R.drawable.image003);

    @NonNull
    private final String cardId; // NFCカードを読み取った時に取得できるデータ
    @DrawableRes
    private final int resourceId; // 画像リソースID

    NFCCardItem(@NonNull final String cardId, final int resourceId) {
        this.cardId = cardId;
        this.resourceId = resourceId;
    }

    @NonNull
    public String getCardId() {
        return cardId;
    }

    public int getResourceId() {
        return resourceId;
    }

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