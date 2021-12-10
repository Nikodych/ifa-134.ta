package com.softserveinc.ita.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SocialMedia {

    FACEBOOK("https://www.facebook.com/rozetka.ua"),
    TWITTER("https://twitter.com/rozetka_ua"),
    YOUTUBE("https://www.youtube.com/channel/UCr7r1-z79TYfqS2IPeRR47A"),
    INSTAGRAM("https://www.instagram.com/rozetkaua/"),
    VIBER("https://invite.viber.com/?g2=AQB9mwM%2F5f%2FxJUlMxP4V9flr2%2BvXTC1MpxdGFZ0P6d%2Fs6Ws%2FFe%2FQtLiZwA4E28sj&lang=uk"),
    TELEGRAM("https://t.me/rrozetka");

    private final String socialMediaLink;
}
