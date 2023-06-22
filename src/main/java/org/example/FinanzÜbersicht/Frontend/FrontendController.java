package org.example.FinanzÜbersicht.Frontend;

import org.example.FinanzÜbersicht.Backend.BackendController;
import org.example.FinanzÜbersicht.Backend.Security.SHA256;
import org.example.FinanzÜbersicht.Frontend.Frames.LoginFrame;
import org.example.FinanzÜbersicht.Frontend.Frames.RegisterFrame;

/**
 * Class FrontendController.
 * <p>
 *     Interacts between frontend and backend.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */
public class FrontendController {
    /**
     * Constructor FrontendController.
     * <p>
     *     Initializes the frontend.
     * </p>
     * @param backendController an {@link org.example.FinanzÜbersicht.Backend.BackendController} instance.
     * @param sha256 {@link org.example.FinanzÜbersicht.Backend.Security.SHA256} instance.
     */
    public FrontendController(BackendController backendController, SHA256 sha256) {
        System.out.println("(~) INFO: Initializing JFrames.");

        // Frame initialisation
        RegisterFrame registerFrame = new RegisterFrame(backendController);
        LoginFrame loginFrame = new LoginFrame(registerFrame, backendController, sha256);
        System.out.println("(+) INFO: JFrames initialized successfully.");

        // visibility logic
        registerFrame.setLoginFrame(loginFrame);
        registerFrame.setVisible(true);
        loginFrame.setVisible(false);
    }
}
