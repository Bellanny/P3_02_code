package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * get fav
*/
    List<Neighbour> getFav();

    /**
     * Delete fav
*/
    void deleteFavNeighbour (Neighbour neighbour);

    /**
     * add fav
     */
void addFavNeighbour (Neighbour neighbour);
}
