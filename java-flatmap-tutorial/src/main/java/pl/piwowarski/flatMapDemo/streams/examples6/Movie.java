package pl.piwowarski.flatMapDemo.streams.examples6;

import java.util.List;

class Movie {
    List<Actor> cast;

    Movie(List<Actor> cast) {
        this.cast = cast;
    }

    public List<Actor> getCast() {
        return cast;
    }
}
