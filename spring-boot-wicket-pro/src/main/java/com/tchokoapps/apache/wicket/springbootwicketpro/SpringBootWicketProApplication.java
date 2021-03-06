package com.tchokoapps.apache.wicket.springbootwicketpro;

import com.tchokoapps.apache.wicket.springbootwicketpro.pages.Index;
import com.tchokoapps.apache.wicket.springbootwicketpro.pages.Login;
import com.tchokoapps.apache.wicket.springbootwicketpro.pages.UserProfilePage;
import com.tchokoapps.apache.wicket.springbootwicketpro.pages.Welcome;
import com.tchokoapps.apache.wicket.springbootwicketpro.repositories.BookRepository;
import com.tchokoapps.apache.wicket.springbootwicketpro.services.BookService;
import com.tchokoapps.apache.wicket.springbootwicketpro.services.CategoryService;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.DefaultThemeProvider;
import de.agilecoders.wicket.core.settings.ITheme;
import de.agilecoders.wicket.themes.markup.html.bootswatch.BootswatchTheme;
import de.agilecoders.wicket.themes.markup.html.google.GoogleTheme;
import de.agilecoders.wicket.themes.markup.html.material_design.MaterialDesignTheme;
import de.agilecoders.wicket.themes.markup.html.vegibit.VegibitTheme;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringBootWicketProApplication extends WebApplication implements CommandLineRunner {

    public static List<ITheme> listBootstrapTheme() {
        final List<ITheme> list = new ArrayList<>();
        list.add(new GoogleTheme());
        list.add(BootswatchTheme.Cerulean);
        list.add(BootswatchTheme.Cosmo);
        list.add(BootswatchTheme.Cyborg);
        list.add(BootswatchTheme.Darkly);
        list.add(BootswatchTheme.Flatly);
        list.add(BootswatchTheme.Journal);
        list.add(BootswatchTheme.Lumen);
        list.add(BootswatchTheme.Paper);
        list.add(BootswatchTheme.Readable);
        list.add(BootswatchTheme.Sandstone);
        list.add(BootswatchTheme.Simplex);
        list.add(BootswatchTheme.Slate);
        list.add(BootswatchTheme.Spacelab);
        list.add(BootswatchTheme.Superhero);
        list.add(BootswatchTheme.United);
        list.add(BootswatchTheme.Yeti);
        return list;
    }

    public static List<ITheme> listVegibitTheme() {
        final List<ITheme> list = new ArrayList<>();
        list.add(VegibitTheme.vegibuntu);
        list.add(VegibitTheme.vegicalm);
        list.add(VegibitTheme.vegicasso);
        list.add(VegibitTheme.vegication);
        list.add(VegibitTheme.vegificial);
        list.add(VegibitTheme.vegiflat);
        list.add(VegibitTheme.vegilibrium);
        list.add(VegibitTheme.vegilime);
        list.add(VegibitTheme.vegimelon);
        list.add(VegibitTheme.vegimin);
        list.add(VegibitTheme.vegimoon);
        list.add(VegibitTheme.vegipooh);
        list.add(VegibitTheme.vegiretro);
        list.add(VegibitTheme.vegisail);
        list.add(VegibitTheme.vegisea);
        list.add(VegibitTheme.vegistone);
        list.add(VegibitTheme.vegitalian);
        list.add(VegibitTheme.vegitapenade);
        list.add(VegibitTheme.vegitini);
        return list;
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWicketProApplication.class, args);
    }

    private void configBootstrap() {
        final BootstrapSettings settings = new BootstrapSettings();

        final DefaultThemeProvider themeProvider = new DefaultThemeProvider();
        themeProvider.addDefaultTheme(new MaterialDesignTheme());

        for (final ITheme theme : listBootstrapTheme()) {
            themeProvider.add(theme);
        }
        for (final ITheme theme : listVegibitTheme()) {
            themeProvider.add(theme);
        }

        settings.setThemeProvider(themeProvider);
        Bootstrap.install(this, settings);
    }

    @Override
    public Class<? extends WebPage> getHomePage() {
        return Index.class;
    }

    @Override
    protected void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext));
        mountPage("/Index.html", Index.class);
        mountPage("/Login.html", Login.class);
        mountPage("/UserProfilePage.html", UserProfilePage.class);
        mountPage("/Welcome.html", Welcome.class);
        configBootstrap();
    }

    @Bean
    public Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.findAll().forEach(book -> log.info(book.getId().toString()));
        bookRepository.findBookByCategoryId(1L).forEach(book -> log.info(book.getId().toString()));
        bookRepository.findBookByCategoryIdAndCategoryNameLike(1L, "J2EE").forEach(book -> log.info(book.getId().toString()));
    }
}
