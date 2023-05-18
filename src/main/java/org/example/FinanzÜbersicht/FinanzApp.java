package org.example.FinanzÜbersicht;

import org.example.FinanzÜbersicht.Backend.BackendController;
import org.example.FinanzÜbersicht.Frontend.FrontendController;

/**
 * Class FinanzApp.
 *
 * <p>
 *     Application to get an overview about their finances.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @since 08.05.2023
 */

public class FinanzApp {
    /**
     * Method main.
     *
     * <p>
     *     Initializes backend and frontend.
     * </p>
     * @param args unused
     */
    public static void main(String[] args) {
        new FrontendController(new BackendController());
    }
}
