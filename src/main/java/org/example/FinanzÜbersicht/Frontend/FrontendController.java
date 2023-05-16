package org.example.FinanzÜbersicht.Frontend;

import org.example.FinanzÜbersicht.Backend.BackendController;

/**
 * Class FrontendController.
 * <p>
 *     Interacts between frontend and backend.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */
public class FrontendController {
    private final BackendController backendController;

    public FrontendController(BackendController backendController) {
        this.backendController = backendController;
    }
}
