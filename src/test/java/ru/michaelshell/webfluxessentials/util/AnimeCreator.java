package ru.michaelshell.webfluxessentials.util;

import ru.michaelshell.webfluxessentials.entity.Anime;

public final class AnimeCreator {

    private AnimeCreator() {
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .name("Test name")
                .id(1)
                .build();
    }

    public static Anime createAnimeToSave() {
        return Anime.builder()
                .name("Anime to save")
                .build();
    }

    public static Anime createAnimeToUpdate() {
        return Anime.builder()
                .name("Anime to update")
                .id(1)
                .build();
    }
}
