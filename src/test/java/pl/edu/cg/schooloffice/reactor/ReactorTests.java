package pl.edu.cg.schooloffice.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ReactorTests {


    @Test
    public void createFlux_just() {

        var disp = Flux.just("jabłko", "pomarańcza", "banan", "kiwi", "truskawka")
                .buffer(3)
                .flatMap(s ->
                    Flux.fromIterable(s)
                            .map(String::toLowerCase)
                            .subscribeOn(Schedulers.parallel())
                            .log()
                );




    }

}
