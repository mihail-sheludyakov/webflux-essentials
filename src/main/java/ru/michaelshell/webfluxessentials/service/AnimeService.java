package ru.michaelshell.webfluxessentials.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.michaelshell.webfluxessentials.entity.Anime;
import ru.michaelshell.webfluxessentials.repository.AnimeRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public Flux<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Mono<Anime> findById(int id) {
        return animeRepository.findById(id)
                .switchIfEmpty(responseStatusNotFoundException());
    }

    private Mono<Anime> responseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));
    }


    public Mono<Anime> save(Anime anime) {
        return animeRepository.save(anime);
    }

    public Mono<Void> update(Anime anime) {
        return findById(anime.getId())
                .flatMap(animeRepository::save)
                .then();
    }

    public Mono<Void> delete(int id) {
        return findById(id)
                .flatMap(animeRepository::delete);
    }
}
