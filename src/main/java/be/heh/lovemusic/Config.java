package be.heh.lovemusic;

import be.heh.lovemusic.adapter.out.Categories_Persistence_Adapter;
import be.heh.lovemusic.adapter.out.Musics_Persistence_Adapter;
import be.heh.lovemusic.adapter.out.repository.Categories_Repository;
import be.heh.lovemusic.adapter.out.repository.Musics_Repository;
import be.heh.lovemusic.application.domain.service.Categories_Service;
import be.heh.lovemusic.application.domain.service.Musics_Service;
import be.heh.lovemusic.application.port.in.UseCase_In_Categories;
import be.heh.lovemusic.application.port.in.UseCase_In_Musics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories
public class Config {
    @Autowired
    Categories_Repository categories_repository;
    @Bean
    public UseCase_In_Categories getUseCase_In_Categories() {
        return new Categories_Service(new Categories_Persistence_Adapter(categories_repository));
    }
    @Autowired
    Musics_Repository musics_repository;
    @Bean
    public UseCase_In_Musics getUseCase_In_Musics() {
        return new Musics_Service(new Musics_Persistence_Adapter(musics_repository,categories_repository));
    }
}
