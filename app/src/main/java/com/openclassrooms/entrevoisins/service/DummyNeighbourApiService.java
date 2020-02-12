package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favNeighbour = new ArrayList<>();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {delete favoris}
*/
    @Override
    public void deleteFavNeighbour(Neighbour neighbour) {
        favNeighbour.remove(neighbour);
    }

    /**
     * {get favoris}
*/
    @Override
    public List<Neighbour> getFav() {
        return favNeighbour;
    }

    /**
     * {add fav}
     */
    @Override
public void addFavNeighbour (Neighbour neighbour) {
    favNeighbour.add(neighbour);
}
}
